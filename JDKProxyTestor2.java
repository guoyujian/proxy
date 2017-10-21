package ch02.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 调用代理时设置拦截
 * @author Aaron
 * 2017年10月14日
 */
public class JDKProxyTestor2 implements InvocationHandler {
	private static Object target = null;
	private static String intercepter = null;//拦截器的全限定名
	
	public JDKProxyTestor2(Object target, String intercepter) {
		// TODO Auto-generated constructor stub
		this.target=target;
		this.intercepter=intercepter;
	}
	
	//bind
	public static Object bind(Object target, String intercepter) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), 
				new JDKProxyTestor2(target,intercepter));
		
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null ;
		Intercepter instance = (Intercepter)Class.forName(intercepter).newInstance();
		if(instance.before(proxy, target, method, args)){
			result = method.invoke(target, args);
		}else {
			instance.around(proxy, target, method, args);
		}
		instance.after(proxy, target, method, args);
		return result;
	}
	
	//test
	public static void main(String[] args) {
		Hello proxy =(Hello)JDKProxyTestor2.bind(new HelloImpl(),
				"ch02.proxy.MyIntercepter");
		proxy.hello();
	}
	
}
