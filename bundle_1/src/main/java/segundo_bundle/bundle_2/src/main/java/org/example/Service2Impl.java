package org.example;

import prueba.Service1;

public class Service2Impl implements Service2 {
	private final Service1 service1;

	public Service2Impl(Service1 service1) {

		this.service1 = service1;
	}

	public String callService1() {

		return service1.sayHello();
	}

}
