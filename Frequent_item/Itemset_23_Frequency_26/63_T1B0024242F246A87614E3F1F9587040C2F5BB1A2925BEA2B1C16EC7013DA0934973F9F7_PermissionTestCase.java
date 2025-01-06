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

package org.osgi.test.support;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.osgi.test.support.mock.MockFactory;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public abstract class PermissionTestCase extends TestCase {

	public static void checkEnumeration(Enumeration< ? > en, boolean isEmpty) {
		assertEquals(en + " empty state is invalid", !isEmpty, en
				.hasMoreElements()); 
		try {
			while (en.hasMoreElements()) {
				en.nextElement();
			}
		} catch (NoSuchElementException e) {
			fail(en + " threw NoSuchElementException"); 
		}

		try {
			en.nextElement();
			fail(en + " is empty but didn't throw NoSuchElementException"); 
		} catch (NoSuchElementException e) {
			// expected
		}
	}

	public static void assertImplies(Permission p1, Permission p2) {
		assertTrue(p1 + " does not imply " + p2, p1.implies(p2)); 
	}

	public static void assertNotImplies(Permission p1, Permission p2) {
		assertFalse(p1 + " does imply " + p2, p1.implies(p2)); 
	}

	public static void assertImplies(PermissionCollection p1, Permission p2) {
		assertTrue(p1 + " does not imply " + p2, p1.implies(p2)); 
	}

	public static void assertNotImplies(PermissionCollection p1, Permission p2) {
		assertFalse(p1 + " does imply " + p2, p1.implies(p2)); 
	}

	public static void assertEquals(Permission p1, Permission p2) {
		assertEquals(p1 + " does not equal " + p2, p1, p2); 
		assertEquals(p1 + " hashcodes do not equal " + p2, p1.hashCode(), p2
				.hashCode()); 
	}

	public static void assertNotEquals(Permission p1, Permission p2) {
		assertFalse(p1 + " does equal " + p2, p1.equals(p2)); 
		assertFalse(p1 + " hashcodes equal " + p2, p1.hashCode() == p2
				.hashCode()); 
	}

	public static void assertAddPermission(PermissionCollection p1,
			Permission p2) {
		try {
			p1.add(p2);
		} catch (Exception e) {
			fail(p1 + " will not add " + p2); 
		}
	}

	public static void assertNotAddPermission(PermissionCollection p1,
			Permission p2) {
		try {
			p1.add(p2);
			fail(p1 + " will add " + p2); 
		} catch (Exception e) {
			// expected
		}
	}

	public static void assertSerializable(PermissionCollection c1) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(baos);

			out.writeObject(c1);
			out.flush();
			out.close();

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bais);

			PermissionCollection c2 = (PermissionCollection) in.readObject();

			assertNotSame(c1, c2);
			assertEquals(enumerationAsSet(c1.elements()), enumerationAsSet(c2
					.elements()));
		}
		catch (Exception e) {
			fail("serialization error", e);
		}
	}

	/**
	 * Fail with cause t.
	 *
	 * @param message Failure message.
	 * @param t Cause of the failure.
	 */
	public static void fail(String message, Throwable t) {
		AssertionFailedError e = new AssertionFailedError(
				message + ": " + t.getMessage());
		e.initCause(t);
		throw e;
	}

	private static <T> Set<T> enumerationAsSet(Enumeration<T> e) {
		Set<T> result = new HashSet<T>();
		while (e.hasMoreElements()) {
			result.add(e.nextElement());
		}
		return result;
	}
	
	public static void assertSerializable(Permission p1) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(baos);

			out.writeObject(p1);
			out.flush();
			out.close();

			ByteArrayInputStream bais = new ByteArrayInputStream(baos
					.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bais);

			Permission p2 = (Permission) in.readObject();

			assertEquals(p1, p2);
			assertEquals(p2, p1);
			assertNotSame(p1, p2);
		} catch (Exception e) {
			fail("serialization error", e);
		}
	}
	
	public static void assertNotSerializable(Object p1) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(baos);

			out.writeObject(p1);
			out.flush();
			out.close();
			fail("serialization did not throw exception");
		}
		catch (Exception e) {
			// expected
		}
	}

	public static Bundle newMockBundle(long id, String name, String location,
			String dn) {
		Map<X509Certificate, List<X509Certificate>> testMap = new HashMap<X509Certificate, List<X509Certificate>>();
		if (dn != null) {
			Principal principal = new MockPrincipal(dn);
			X509Certificate cert = new MockX509Certificate(principal);
			List<X509Certificate> testList = new ArrayList<X509Certificate>();
			testList.add(cert);
			testMap.put(cert, testList);
		}
		return MockFactory.newMock(Bundle.class, new MockBundle(id,
				name, location, testMap));
	}

	private static class MockBundle {
		private final long		id;
		private final String	name;
		private final String	location;
		private final Map<X509Certificate, List<X509Certificate>>	signers;

		MockBundle(long id, String name, String location,
				Map<X509Certificate, List<X509Certificate>> signers) {
			this.id = id;
			this.name = name;
			this.location = location;
			this.signers = signers;
		}

		@SuppressWarnings("unused")
		public long getBundleId() {
			return id;
		}

		@SuppressWarnings("unused")
		public String getLocation() {
			return location;
		}

		@SuppressWarnings("unused")
		public Map<X509Certificate, List<X509Certificate>> getSignerCertificates(
				int type) {
			return new HashMap<X509Certificate, List<X509Certificate>>(signers);
		}

		@SuppressWarnings("unused")
		public String getSymbolicName() {
			return name;
		}
	}

	private static class MockX509Certificate extends X509Certificate {
		private final Principal	principal;

		MockX509Certificate(Principal principal) {
			this.principal = principal;
		}

		@Override
		public Principal getSubjectDN() {
			return principal;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof MockX509Certificate) {
				return principal.equals(((MockX509Certificate) obj).principal);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return principal.hashCode();
		}

		@Override
		public String toString() {
			return principal.toString();
		}

		@Override
		public void checkValidity() throws CertificateExpiredException,
				java.security.cert.CertificateNotYetValidException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void checkValidity(Date var0)
				throws java.security.cert.CertificateExpiredException,
				java.security.cert.CertificateNotYetValidException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int getBasicConstraints() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Principal getIssuerDN() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean[] getIssuerUniqueID() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean[] getKeyUsage() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Date getNotAfter() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Date getNotBefore() {
			throw new UnsupportedOperationException();
		}

		@Override
		public BigInteger getSerialNumber() {
			throw new UnsupportedOperationException();
		}

		@Override
		public String getSigAlgName() {
			throw new UnsupportedOperationException();
		}

		@Override
		public String getSigAlgOID() {
			throw new UnsupportedOperationException();
		}

		@Override
		public byte[] getSigAlgParams() {
			throw new UnsupportedOperationException();
		}

		@Override
		public byte[] getSignature() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean[] getSubjectUniqueID() {
			throw new UnsupportedOperationException();
		}

		@Override
		public byte[] getTBSCertificate() throws CertificateEncodingException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int getVersion() {
			throw new UnsupportedOperationException();
		}

		@Override
		public byte[] getEncoded() throws CertificateEncodingException {
			throw new UnsupportedOperationException();
		}

		@Override
		public PublicKey getPublicKey() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void verify(PublicKey var0)
				throws java.security.InvalidKeyException,
				java.security.NoSuchAlgorithmException,
				java.security.NoSuchProviderException,
				java.security.SignatureException,
				java.security.cert.CertificateException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void verify(PublicKey var0, String var1)
				throws InvalidKeyException, NoSuchAlgorithmException,
				NoSuchProviderException, SignatureException,
				CertificateException {
			throw new UnsupportedOperationException();
		}

		@Override
		public Set<String> getCriticalExtensionOIDs() {
			throw new UnsupportedOperationException();
		}

		@Override
		public byte[] getExtensionValue(String var0) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Set<String> getNonCriticalExtensionOIDs() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasUnsupportedCriticalExtension() {
			throw new UnsupportedOperationException();
		}
	}

	private static class MockPrincipal implements Principal {
		private final String	name;

		MockPrincipal(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj instanceof MockPrincipal) {
				return name.equals(((MockPrincipal) obj).name);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return name.hashCode();
		}

		@Override
		public String toString() {
			return getName();
		}
	}
	
	public static ServiceReference< ? > newMockServiceReference(Bundle bundle,
			Map<String, ? > properties) {
		return MockFactory.newMock(
				ServiceReference.class,
				new MockServiceReference(bundle, properties));
	}

	private static class MockServiceReference {
		private final Bundle	bundle;
		private final Map<String, ? >	properties;

		MockServiceReference(Bundle bundle, Map<String, ? > properties) {
			this.bundle = bundle;
			this.properties = properties;
		}

		@SuppressWarnings("unused")
		public Bundle getBundle() {
			return bundle;
		}

		@SuppressWarnings("unused")
		public Object getProperty(String key) {
			Object result = properties.get(key);
			if (result != null) {
				return result;
			}
			for (String k : properties.keySet()) {
				if (k.equalsIgnoreCase(key)) {
					return properties.get(k);
				}
			}
			return null;
		}

		@SuppressWarnings("unused")
		public String[] getPropertyKeys() {
			String[] result = new String[properties.size()];
			properties.keySet().toArray(result);
			return result;
		}
	}
}
