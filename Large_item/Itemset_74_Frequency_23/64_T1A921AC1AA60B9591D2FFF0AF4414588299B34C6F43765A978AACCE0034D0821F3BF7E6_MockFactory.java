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

package org.osgi.test.support.mock;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Useful to mock Framework interfaces which may change in future releases.
 * 
 * The mock will delegate method calls on the mocked interface to the delegate
 * object. The delegate object does NOT need to implement the interface and does
 * NOT need to implement all the methods on the interface.
 * 
 * @author $Id: faa4bd522fc447b98a2752aa9c65a7316867e3c1 $
 */
public class MockFactory {
	private MockFactory() {
		/* non-instantiable */
	}

	/**
	 * Return a mocked object for the specified interface. The mocked object
	 * will delegate method calls on the specified interface to the specified
	 * delegate object. The specified delegate object does NOT need to implement
	 * the specified interface and does NOT need to implement all the methods on
	 * the specified interface.
	 * 
	 * <p>
	 * The mocked object will throw UnsupportedOperationException if the
	 * specified delegate is <code>null</code> or if the specified delegate does
	 * not implement the method called on the mocked object.
	 * 
	 * @param interfce The interface to mock.
	 * @param delegate The object to which method calls on the mocked object are
	 *        delegated.
	 * @return A mocked which implements the specified interface and delegates
	 *         method calls to the specified delegate object.
	 */
	public static <T> T newMock(final Class<T> interfce, final Object delegate) {
		final ClassLoader proxyLoader = ((delegate == null) ? MockFactory.class
				: delegate.getClass()).getClassLoader();
		final InvocationHandler handler = new InvocationHandler() {
			final Class< ? >	delegateClass	= (delegate == null) ? null
														: delegate.getClass();
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if (delegate == null) {
					throw new UnsupportedOperationException("null delegate");
				}
				Method delegateMethod;
				try {
					delegateMethod = delegateClass.getMethod(method.getName(),
							method.getParameterTypes());
				}
				catch (NoSuchMethodException e) {
					UnsupportedOperationException uoe = new UnsupportedOperationException();
					uoe.initCause(e);
					throw uoe;
				}
				delegateMethod.setAccessible(true);
				try {
					return delegateMethod.invoke(delegate, args);
				}
				catch (InvocationTargetException e) {
					Throwable cause = e.getCause();
					if (cause == null) {
						cause = e;
					}
					throw cause;
				}
			}
		};
        @SuppressWarnings("unchecked")
        T newProxyInstance = (T) Proxy.newProxyInstance(proxyLoader, new Class[] {interfce},
				handler);
        return newProxyInstance;
	}
}
