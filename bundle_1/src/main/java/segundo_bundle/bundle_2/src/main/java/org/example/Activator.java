/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.example;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import prueba.Service1;

import java.security.Provider;

public class Activator implements BundleActivator {

	public void start(BundleContext context) {
		ServiceReference<?> reference = context.getServiceReference(Service1.class.getName());
		if (reference != null) {
			Service1 service1 = (Service1) context.getService(reference);
			Service2 service2 = new Service2Impl(service1);
			context.registerService(Service2.class.getName(), service2, null);
			System.out.println("Starting the bundle"+ " Desde el segundo bundle "+ service1.sayHello());

		}
	}

	public void stop(BundleContext context) {
		System.out.println("Stopping the bundle");
	}

}