package ch02.proxy;

import ch02.reflect.Person;

public class JDKProxyTestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProxyClass class1 = new ProxyClass();
		Hello proxyObj = (Hello)class1.bind(new HelloImpl());
		proxyObj.hello();
	}

}
