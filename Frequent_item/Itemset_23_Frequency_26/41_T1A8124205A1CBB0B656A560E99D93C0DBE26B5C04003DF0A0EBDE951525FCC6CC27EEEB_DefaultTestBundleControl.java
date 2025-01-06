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
package org.osgi.test.support.compatibility;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.test.support.OSGiTestCase;

/**
 * @author <a href="mailto:tdiekman@tibco.com">Tim Diekmann</a>
 * 
 */
public abstract class DefaultTestBundleControl extends OSGiTestCase {

	private final Map<Object, ServiceRegistration< ? >>	serviceRegistry	= new HashMap<Object, ServiceRegistration< ? >>();
	private final Map<Object, ServiceReference< ? >>	fetchedServices	= new HashMap<Object, ServiceReference< ? >>();
	private volatile String	webServer;

	/**
	 * This returned a web server but we will just now, it is mostly used in
	 * installBundle and there we get the bundle from our resources.
	 */
	public String getWebServer() {
		String w = webServer;
		if (w == null) {
			URL base = getContext().getBundle().getEntry("/");
			webServer = w = (base == null) ? "/" : base.toExternalForm();
		}
		return w;
	}

	/**
	 * This method is called before a test is executed.
	 * 
	 * @throws Exception
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setState(); // call old version of setUp if it has been implemented.
	}

	/**
	 * This method is called after a test is executed.
	 * 
	 * @throws Exception
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		clearState(); // call old version of tearDown if it has been
		// implemented.
		super.tearDown();
	}

	/**
	 * Old version of setUp.
	 * 
	 * @throws Exception
	 * @deprecated
	 */
	protected void setState() throws Exception {
		// no default implementation
	}

	/**
	 * Old version of tearDown.
	 * 
	 * @throws Exception
	 * @deprecated
	 */
	protected void clearState() throws Exception {
		// no default implementation
	}

	public static void failException(String message,
			Class< ? > expectedExceptionClass) {
		fail(message + " expected:[" + expectedExceptionClass.getName()
				+ "] and got nothing");
	}

	public static void pass(String message) {
		System.out.println(message);
	}

	public static void log(String message) {
		System.out.println(message);
	}

	public static void trace(String message) {
		System.out.println(message);
	}

	/**
	 * Method for logging exceptions. The tested code may throw an exception
	 * that is a subclass of the specified, so the parameter <code>want</code>
	 * specifies the expected class. If the parameter <code>got</code> is of the
	 * wanted type (or a subtype of the wanted type), the classname of
	 * <code>want</code> is logged. If <code>got</code> is of an unexpected
	 * type, the classname of <code>got</code> is logged.
	 * 
	 * @param message the log description
	 * @param want the exception that is specified to be thrown
	 * @param got the exception that was thrown
	 */
	public static void assertException(String message, Class<? extends Throwable> want,
			Throwable got) {
		String formatted = "";

		if (message != null) {
			formatted = message + " ";
		}

		if (!want.isInstance(got)) {
			fail(formatted + "expected:[" + want.getName() + "] but was:["
					+ got.getClass().getName() + "]", got);
		}
	}

	/**
	 * Asserts that two Dictionaries of properties are equal. If they are not an
	 * AssertionFailedError is thrown.
	 */
	public static void assertEqualProperties(String message,
			Dictionary< ? , ? > expected, Dictionary< ? , ? > actual) {
		if (expected == actual) {
			passEquals(message, expected, actual);
			return;
		}

		if ((expected == null) || (actual == null)) {
			failNotEquals(message, expected, actual);
			return;
		}

		if (expected.size() != actual.size()) {
			failNotEquals(message, expected, actual);
			return;
		}

		Enumeration< ? > e = expected.keys();
		while (e.hasMoreElements()) {
			Object key = e.nextElement();
			Object expectedValue = expected.get(key);
			Object actualValue = actual.get(key);

			if (!objectEquals(expectedValue, actualValue)) {
				failNotEquals(message, expected, actual);
				return;
			}
		}

		passEquals(message, expected, actual);
	}

	/**
	 * Compare two objects for equality. This method calls Arrays.equals if the
	 * object types are arrays.
	 * 
	 */
	private static boolean objectEquals(Object expected, Object actual) {
		return objectEquals(null, expected, actual);
	}

	/**
	 * Compare two objects for equality. This method calls Arrays.equals if the
	 * object types are arrays.
	 * 
	 */
	@SuppressWarnings("unchecked")
	private static <T> boolean objectEquals(Comparator<T> comparator,
			T expected, T actual) {
		if (expected == actual) {
			return true;
		}

		if ((expected == null) || (actual == null)) {
			return false;
		}

		if (expected.equals(actual)) {
			return true;
		}

		if (expected instanceof List && actual instanceof List)
			return listEquals(comparator, (List<T>) expected, (List<T>) actual);

		if (expected instanceof Dictionary && actual instanceof Dictionary)
			return dictionaryEquals(comparator,
					(Dictionary<Object, T>) expected,
					(Dictionary<Object, T>) actual);

		try {
			Class<?> clazz = expected.getClass();
			if (clazz.isArray()) {
				Class<?> type = clazz.getComponentType();

				if (type.isPrimitive()) {
					if (type.equals(Integer.TYPE)) {
						return Arrays.equals((int[]) expected, (int[]) actual);
					}
					else
						if (type.equals(Long.TYPE)) {
							return Arrays.equals((long[]) expected,
									(long[]) actual);
						}
						else
							if (type.equals(Byte.TYPE)) {
								return Arrays.equals((byte[]) expected,
										(byte[]) actual);
							}
							else
								if (type.equals(Short.TYPE)) {
									return Arrays.equals((short[]) expected,
											(short[]) actual);
								}
								else
									if (type.equals(Character.TYPE)) {
										return Arrays.equals((char[]) expected,
												(char[]) actual);
									}
									else
										if (type.equals(Float.TYPE)) {
											return Arrays.equals(
													(float[]) expected,
													(float[]) actual);
										}
										else
											if (type.equals(Double.TYPE)) {
												return Arrays.equals(
														(double[]) expected,
														(double[]) actual);
											}
											else
												if (type.equals(Boolean.TYPE)) {
													return Arrays
															.equals(
																	(boolean[]) expected,
																	(boolean[]) actual);
												}
				}
				else { /* non-primitive array object */
					return Arrays
							.equals((Object[]) expected, (Object[]) actual);
				}
			}

			/*
			 * well it did not match any of the above types do we have a
			 * comparator to compare them?
			 */
			if (comparator != null) {
				if (comparator.compare(expected, actual) == 0) {
					return true;
				}
			}
		}
		catch (ClassCastException e) {
			// ignore since we return false below
		}

		return false;
	}

	private static <T> boolean listEquals(Comparator<T> comparator,
			List<T> expected, List<T> actual) {
		if (expected.size() != actual.size())
			return false;

		boolean result = true;

		for (int i = 0; result && i < expected.size(); i++)
			result = objectEquals(comparator, expected.get(i), actual.get(i));

		return result;
	}

	private static <K, V> boolean dictionaryEquals(Comparator<V> comparator,
			Dictionary<K, V> expected, Dictionary<K, V> actual) {
		if (expected.size() != actual.size())
			return false;

		boolean result = true;

		for (Enumeration<K> e = expected.keys(); result && e.hasMoreElements();) {
			K key = e.nextElement();
			V expectedValue = expected.get(key);
			V actualValue = actual.get(key);
			result = objectEquals(comparator, expectedValue, actualValue);
		}
		return result;
	}

	private static void passEquals(String message, Object expected,
			Object actual) {
		String formatted = "";

		if (message != null) {
			formatted = message + " ";
		}

		pass(formatted + "expected:[" + expected + "] and correctly got:["
				+ actual + "]");
	}

	public boolean serviceAvailable(Class< ? > clazz) {
		return getContext().getServiceReference(clazz.getName()) != null;
	}

	public void registerService(String clazz, Object service,
			Dictionary<String, ? > properties) throws Exception {
		ServiceRegistration< ? > sr = getContext().registerService(clazz,
				service,
				properties);
		synchronized (serviceRegistry) {
			serviceRegistry.put(service, sr);
		}
	}

	public void unregisterService(Object service) {
		ServiceRegistration< ? > sr;
		synchronized (serviceRegistry) {
			sr = serviceRegistry.remove(service);
		}
		if (sr == null) {
			fail("trying to unregister a service which is not currently registered");
		}
		sr.unregister();
	}

	public void unregisterAllServices() {
		ServiceRegistration< ? >[] srs;
		synchronized (serviceRegistry) {
			srs = serviceRegistry.values().toArray(
					new ServiceRegistration[serviceRegistry.size()]);
			serviceRegistry.clear();
		}

		for (int l = srs.length, i = 0; i < l; i++) {
			srs[i].unregister();
		}
	}

	/**
	 * Convenience method for getting services from the framework in cases when
	 * you don't want to keep track of the ServiceReference.
	 * <p>
	 * To unregister the service, use the ungetService(Object service) method.
	 * 
	 * @param clazz the Class object of the service you with to retrieve
	 * @return a service object
	 * @throws NullPointerException if the service couldn't be retrieved from
	 *         the framework.
	 */
	public <S> S getService(Class< S > clazz) {
		try {
			return getService(clazz, null);
		}
		catch (InvalidSyntaxException e) {
			/* null can not give an exception of this type */
		}
		return null;
	}

	/**
     */
	public <S> S getService(Class< S > clazz, String filter)
			throws InvalidSyntaxException {
		@SuppressWarnings("unchecked")
		ServiceReference< S >[] refs = (ServiceReference<S>[]) getContext().getServiceReferences(
				clazz.getName(), filter);

		if (refs == null) {
			fail("Can't get service reference for " + clazz.getName() + filter);
		}

		ServiceReference< S > chosenRef = pickServiceReference(refs);

		S service = getContext().getService(chosenRef);

		if (service == null) {
			fail("Can't get service for " + clazz.getName() + filter);
		}

		/* Save the service and its reference */
		synchronized (fetchedServices) {
			fetchedServices.put(service, chosenRef);
		}

		return service;
	}

	public ServiceReference< ? > getServiceReference(Object service) {
		ServiceReference< ? > ref;
		synchronized (fetchedServices) {
			ref = fetchedServices.get(service);
		}

		if (ref == null) {
			fail("trying to get ServiceReference for a service which is not currently bound");
		}

		return ref;
	}

	public void ungetService(Object service) {
		ServiceReference< ? > ref;
		synchronized (fetchedServices) {
			ref = fetchedServices.remove(service);
		}

		if (ref == null) {
			fail("trying to unget a service which is not currently bound");
		}

		getContext().ungetService(ref);
	}

	public void ungetAllServices() {
		ServiceReference< ? >[] refs;
		synchronized (fetchedServices) {
			refs = fetchedServices.values().toArray(
					new ServiceReference[fetchedServices.size()]);
			fetchedServices.clear();
		}

		for (int l = refs.length, i = 0; i < l; i++) {
			getContext().ungetService(refs[i]);
		}
	}

	/**
	 * Picks a service from the given array of references. The rules the service
	 * is picked by are the same as the rules defined in
	 * BundleContext.getServiceReference() (highest ranking, lowest service ID
	 * if the ranking is a tie)
	 */
	private static <S> ServiceReference< S > pickServiceReference(
			ServiceReference<S >[] refs) {
		ServiceReference< S > highest = refs[0];

		for (int i = 1; i < refs.length; i++) {
			ServiceReference<S > challenger = refs[i];

			if (ranking(highest) < ranking(challenger)) {
				highest = challenger;
			}
			else
				if (ranking(highest) == ranking(challenger)) {
					if (serviceid(highest) > serviceid(challenger)) {
						highest = challenger;
					}
				}
		}

		return highest;
	}

	/**
	 * Get service ranking from a service reference.
	 * 
	 * @param s The service reference
	 * @return Ranking value of service, default value is zero
	 */
	private static int ranking(ServiceReference< ? > s) {
		Object v = s.getProperty(Constants.SERVICE_RANKING);

		if (v != null && v instanceof Integer) {
			return ((Integer) v).intValue();
		}
		else {
			return 0;
		}
	}

	private static long serviceid(ServiceReference< ? > s) {
		Long sid = (Long) s.getProperty(Constants.SERVICE_ID);

		return sid.longValue();
	}

	/**
	 * Install a bundle.
	 * 
	 * @param bundle
	 * @throws BundleException
	 */
	public Bundle installBundle(String url) throws Exception {
		return installBundle(url, true);
	}

	public Bundle installBundle(String bundleName, boolean start)
			throws Exception {
		try {
			if (!bundleName.startsWith(getWebServer())) {
				bundleName = getWebServer() + bundleName;
			}
			URL url = new URL(bundleName);
			InputStream in = url.openStream();

			Bundle b = getContext().installBundle(bundleName, in);
			if (start) {
				b.start();
			}
			return b;
		}
		catch (Exception e) {
			log("Not able to install testbundle " + bundleName);
			log("Nested " + e.getCause());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Uninstall a bundle.
	 * 
	 * @param bundle
	 * @throws BundleException
	 */
	public void uninstallBundle(Bundle bundle) throws BundleException {
		bundle.uninstall();
	}

	public static String arrayToString(Object[] array) {
		return arrayToString(array, false);
	}

	public static String arrayToString(Object[] array, boolean sort) {
		StringBuffer buf = new StringBuffer();

		if (sort) {
			Arrays.sort(array);
		}

		if (array != null) {
			buf.append("{ ");
			for (int i = 0; i < array.length; i++) {
				buf.append(array[i]);
				if (i + 1 < array.length) {
					buf.append(", ");
				}
			}

			buf.append(" }");

		}
		else {
			buf.append("null");
		}

		return buf.toString();
	}

}
