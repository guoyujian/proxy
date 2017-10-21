package ch02.proxy;

import java.lang.reflect.Method;

/**
 * 拦截器接口
 * @author Aaron
 * 2017年10月14日
 */
public interface Intercepter {
	boolean before(Object proxy,Object target,Method method,Object[] args);
	void around(Object proxy,Object target,Method method,Object[] args);
	void after(Object proxy,Object target,Method method,Object[] args);
}
