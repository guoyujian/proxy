package ch02.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyExample implements MethodInterceptor {

	//类似于JDK动态代理中的bind()方法
	
	public Object getProxy(Class cls) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(cls);
		enhancer.setCallback(this);
		return enhancer.create();
		
	}

	@Override
	public Object intercept(Object obj, Method method, 
			Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("-------cglib--------");
		Object object = proxy.invokeSuper(obj, args);
		System.out.println("-------cglib--------");
		return object;
	}
	
	
	public static void main(String[] args) {
		CglibProxyExample example = new CglibProxyExample();
		HelloImpl hl = (HelloImpl)example.getProxy(HelloImpl.class);
		hl.hello();
		
	}

	
}
