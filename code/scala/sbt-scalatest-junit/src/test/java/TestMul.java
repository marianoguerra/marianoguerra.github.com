package org.myproject;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestMul extends TestCase {
	@Test
	public void testMul() {
		Muler muler = new Muler();
		System.out.println("testing from junit in java");
		Assert.assertEquals(6, muler.mul(2, 3));
	}
}
