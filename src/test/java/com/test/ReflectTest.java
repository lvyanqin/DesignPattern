/**
 * 
 */
package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.demo.config.pay.CardHelper_singleton;

/**
 * @author yanlei
 * @date 2017年12月24日 下午5:05:39
 *
 */
public class ReflectTest {
	
	@Test
	public void test1() {
		Object o = null;
		try {
			Class c = Class.forName("com.demo.config.pay.CardHelper_singleton");
			Constructor<?>[] cons = c.getDeclaredConstructors();
			cons[0].setAccessible(true);
			o = cons[0].newInstance();
			CardHelper_singleton cardHelper_singleton = (CardHelper_singleton) o;
			System.out.println(cardHelper_singleton);
			o = cons[0].newInstance();
			cardHelper_singleton = (CardHelper_singleton) o;
			System.out.println(cardHelper_singleton);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
