/*******************************************************************************
 * Copyright (c) Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0 
 *******************************************************************************/

package org.osgi.test.support.signature;

/**
 * Verify the signatures of all methods in the spec. Check that there no more
 * and less fields, methods, end constructors that are visible.
 */

import static org.assertj.core.api.Assertions.*;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.test.support.junit4.AbstractOSGiTestCase;

/**
 * @author $Id: 43788b52e0267b3a30e060c4d463a8a9ce708b77 $
 */
public abstract class SignatureTestCase extends AbstractOSGiTestCase
		implements ParserCallback {
	private Class< ? >						clazz;
	private Map<String,Method>				methods;
	private Map<String,Constructor< ? >>	constructors;
	private Map<String,Field>				fields;
	private Set<String>						found;
	private Set<String>						missing;

	@Test
	public void testSignatures() throws Exception {
		Bundle bundle = getContext().getBundle();
		String path = "OSGI-INF/signature";
		found = new HashSet<String>();
		missing = new HashSet<String>();
		Enumeration<URL> e = bundle.findEntries(path, null, true);
		assertThat(e).as("No Signature Files found in %s", path).isNotNull();

		while (e.hasMoreElements()) {
			URL url = e.nextElement();
			if (!url.toString().endsWith("/")) {
				try (InputStream in = url.openStream()) {
					ClassParser rdr = new ClassParser(in);
					rdr.go(this);
				} catch (Exception ioe) {
					fail("Unexpected exception", ioe);
				}
			}
		}
		if (found.isEmpty()) {
			log("Package is not present: " + path);
			return;
		}
		assertThat(missing).as(
				"Missing classes %s.\n\nThe following classes were found %s",
				missing, found).isEmpty();
	}

	/**
	 * Callback For the class parser to do attributes that are unknown.
	 * 
	 * @param name
	 * @param data
	 * @see org.osgi.test.cases.signature.tbc.ParserCallback#doAttribute(java.lang.String,
	 *      byte[])
	 */
	@Override
	public Object doAttribute(String name, byte[] data) {
		return null;
	}

	/**
	 * Call back to handle a class file.
	 * 
	 * @param access
	 * @param name
	 * @param superName
	 * @param interfaces
	 * @return
	 * @see org.osgi.test.cases.signature.tbc.ParserCallback#doClass(int,
	 *      java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Override
	public boolean doClass(int access, String name, String superName,
			String[] interfaces) {
		clazz = null;
		if (!isAPI(access)) {
			return false;
		}

		String className = name.replace('/', '.');
		String superClassName = superName.replace('/', '.');
		log("#Checking class: " + className);
		try {

			try {
				clazz = Class.forName(className);
				if (clazz.getClassLoader() == getClass().getClassLoader()) {
					// We have gotten our own package
					missing.add(name);
					clazz = null;
					log("ever got here where we have gotten our own package");
					return false;
				}
				found.add(name);
				checkInterfaces(clazz, interfaces);

				int cMods = clazz.getModifiers();
				checkModifiers(access, cMods,
						ACC_PUBLIC | ACC_FINAL | ACC_INTERFACE | ACC_ABSTRACT);

				checkSuperClass(clazz, superClassName);

				methods = getMethods(clazz);
				fields = getFields(clazz);
				constructors = getConstructors(clazz);
				return true;
			} catch (ClassNotFoundException cnfe) {
				missing.add(name);
			}
		} catch (Exception e) {
			fail("Unexpected exception", e);
		}
		return false;
	}

	private Map<String,Field> getFields(Class< ? > c) {
		Map<String,Field> result = new HashMap<String,Field>();
		while (c != null) {
			Field[] f = c.getDeclaredFields();
			for (int i = 0, l = f.length; i < l; i++) {
				if (!isAPI(f[i].getModifiers())) {
					continue;
				}
				String key = f[i].getName();
				if (result.containsKey(key)) {
					continue;
				}
				result.put(key, f[i]);
			}
			c = c.getSuperclass();
		}
		return result;
	}

	private Map<String,Method> getMethods(Class< ? > c) {
		Map<String,Method> result = new HashMap<String,Method>();
		while (c != null) {
			Method[] m = c.getDeclaredMethods();
			for (int i = 0, l = m.length; i < l; i++) {
				if (!isAPI(m[i].getModifiers())) {
					continue;
				}
				String key = m[i].getName() + getMethodDescriptor(m[i]);
				if (result.containsKey(key)) {
					continue;
				}
				result.put(key, m[i]);
			}
			c = c.getSuperclass();
		}
		return result;
	}

	private Map<String,Constructor< ? >> getConstructors(Class< ? > c) {
		Map<String,Constructor< ? >> result = new HashMap<String,Constructor< ? >>();
		Constructor< ? >[] m = c.getDeclaredConstructors();
		for (int i = 0, l = m.length; i < l; i++) {
			if (!isAPI(m[i].getModifiers())) {
				continue;
			}
			StringBuffer sb = new StringBuffer();
			sb.append("(");
			getDescriptor(sb, m[i].getParameterTypes());
			sb.append(")V");
			String key = sb.toString();
			if (result.containsKey(key)) {
				continue;
			}
			result.put(key, m[i]);
		}
		return result;
	}

	public static void log(String string) {
		System.out.println(string);
	}

	@Override
	public void doField(int access, String name, String desiredDescriptor,
			Object constant) {
		if (!isAPI(access))
			return;

		log("#visit " + getClassName(clazz) + "." + name + " "
				+ desiredDescriptor);

		Field f = fields.remove(name);
		assertThat(f)
				.as("Could not find field: %s.%s", getClassName(clazz), name)
				.isNotNull();

		int cMods = f.getModifiers();
		checkModifiers(access, cMods, ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED
				| ACC_STATIC | ACC_FINAL);

		Class< ? > type = f.getType();
		StringBuffer sb = new StringBuffer();
		createTypeDescriptor(sb, type);
		assertThat(sb.toString()).as("Field %s.%s", getClassName(clazz), name)
				.isEqualTo(desiredDescriptor);

		if (constant != null) {
			try {
				Object value = f.get(null);
				// need to handle that boolean, byte, short, char and int
				// are placed in an Integer constant.
				switch (desiredDescriptor.charAt(0)) {
					case 'Z' : // boolean
						assertThat((Boolean) value).as("Constant value")
								.isEqualTo(
										((Integer) constant).intValue() != 0);
						break;
					case 'B' : // byte
						assertThat((Byte) value).as("Constant value")
								.isEqualTo(((Integer) constant).byteValue());
						break;
					case 'C' : // char
						assertThat((Character) value).as("Constant value")
								.isEqualTo(
										(char) ((Integer) constant).intValue());
						break;
					case 'S' : // short
						assertThat((Short) value).as("Constant value")
								.isEqualTo(((Integer) constant).shortValue());
						break;
					default :
						assertThat(value).as("Constant value")
								.isEqualTo(constant);
						break;
				}
			}
			// These can probably be ignored
			catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doMethod(int access, String name, String desc,
			String[] exceptions) {

		if (!isAPI(access))
			return;

		log("#visit " + getClassName(clazz) + "." + name + " " + desc);

		if (name.equals("<init>"))
			checkConstructor(access, name, desc, exceptions);
		else
			checkMethod(access, name, desc, exceptions);
	}

	@Override
	public void doEnd() {
		/**
		 * We removed the check to see if there is too much
		 */
	}

	private void checkConstructor(int access, String name,
			String desiredDescriptor, String[] exceptions) {
		String key = desiredDescriptor;
		Constructor< ? > m = constructors.remove(key);
		assertThat(m)
				.as("Could not find constructor: %s.%s %s", getClassName(clazz),
						name, key)
				.isNotNull();

		int cMods = m.getModifiers();
		checkModifiers(access, cMods, ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED
				| ACC_STATIC | ACC_FINAL | ACC_ABSTRACT);
		checkExceptions(exceptions, m.getExceptionTypes());
	}

	private void checkExceptions(String[] exceptions,
			Class< ? >[] exceptionTypes) {
		Set<String> expected = new TreeSet<>();
		if (exceptions != null) {
			expected.addAll(Arrays.asList(exceptions));
		}
		if (exceptionTypes != null) {
			Set<String> actual = new TreeSet<>();
			for (Class< ? > exceptionType : exceptionTypes) {
				actual.add(exceptionType.getName().replace('.', '/'));
			}
			for (String name : actual) {
				assertThat(expected.remove(name))
						.as("Superfluous Exception %s", name)
						.isTrue();
			}
		}
		assertThat(expected).as("Missing declared exceptions: %s", expected)
				.isEmpty();
	}

	private void checkInterfaces(Class< ? > c, String[] interfaces) {
		Class< ? > implemented[] = c.getInterfaces();
		outer: for (int i = 0; i < interfaces.length; i++) {
			String ifname = interfaces[i].replace('/', '.');
			for (int j = 0; j < implemented.length; j++) {
				if (implemented[j] != null
						&& implemented[j].getName().equals(ifname)) {
					implemented[j] = null;
					continue outer;
				}
			}
			fail("Missing interface, class %s misses %s", getClassName(c),
					ifname);
		}
	}

	private void checkMethod(int access, String name, String desiredDescriptor,
			String[] exceptions) {
		String key = name + desiredDescriptor;
		Method m = methods.remove(key);
		assertThat(m)
				.as("Could not find method: %s.%s", getClassName(clazz), key)
				.isNotNull();
		int cMods = m.getModifiers();
		checkModifiers(access, cMods, ACC_PUBLIC | ACC_PRIVATE | ACC_PROTECTED
				| ACC_STATIC | ACC_FINAL | ACC_ABSTRACT);
		checkExceptions(exceptions, m.getExceptionTypes());
	}

	private void checkModifiers(int access, int cMods, int mask) {
		assertThat(cMods & mask).as("Relevant access modifiers")
				.isEqualTo(access & mask);
	}

	private void checkSuperClass(Class< ? > c, String superClassName) {
		Class< ? > superClass = c.getSuperclass();
		if (superClass != null) {
			assertThat(superClass.getName()).as("Super class")
					.isEqualTo(superClassName);
		}
	}

	private void createTypeDescriptor(StringBuffer sb, Class< ? > type) {
		if (type.isArray()) {
			sb.append("[");
			createTypeDescriptor(sb, type.getComponentType());
		} else {
			if (type.isPrimitive()) {
				if (type == byte.class)
					sb.append("B");
				else if (type == char.class)
					sb.append("C");
				else if (type == double.class)
					sb.append("D");
				else if (type == float.class)
					sb.append("F");
				else if (type == int.class)
					sb.append("I");
				else if (type == long.class)
					sb.append("J");
				else if (type == short.class)
					sb.append("S");
				else if (type == boolean.class)
					sb.append("Z");
				else if (type == void.class)
					sb.append("V");
				else
					throw new IllegalArgumentException(
							"Unknown primitive type " + type);
			} else {
				sb.append("L");
				sb.append(type.getName().replace('.', '/'));
				sb.append(";");
			}
		}
	}

	private String getClassName(Class< ? > c) {
		if (c.isArray())
			return getClassName(c.getComponentType()) + "[]";
		return c.getName();
	}

	private void getDescriptor(StringBuffer sb, Class< ? >[] parameters) {
		for (int i = 0; i < parameters.length; i++) {
			createTypeDescriptor(sb, parameters[i]);
		}
	}

	private String getMethodDescriptor(Method method) {
		StringBuffer sb = new StringBuffer();
		sb.append("(");
		getDescriptor(sb, method.getParameterTypes());
		sb.append(")");
		createTypeDescriptor(sb, method.getReturnType());
		return sb.toString();
	}

	private boolean isAPI(int access) {
		return ((access & (ACC_PUBLIC | ACC_PROTECTED)) != 0)
				&& ((access & (ACC_SYNTHETIC)) == 0);
	}
}
