package net.herranzmartin.utils;

import java.lang.reflect.Field;

public class TestJCE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try { 
			Field field = Class.forName("javax.crypto.JceSecurity").
			getDeclaredField("isRestricted");
			field.setAccessible(true);
			field.set(null, java.lang.Boolean.FALSE); 
			} catch (Exception ex) {
			ex.printStackTrace();
			}
	}

}
