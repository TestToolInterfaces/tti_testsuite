package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.TestStep;

public class TestStepSetTester extends TestCase
{
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepSet#TestStepSet()}.
	 */
	@Test
	public void testConstructor()
	{
		ArrayList<TestStepSetCase> cases = new ArrayList<TestStepSetCase>();

		TestStepSet stepSet = new TestStepSet( 2, cases );

		Assert.assertEquals("Incorrect Type", TestStep.StepType.set, stepSet.getStepType());
		Assert.assertEquals("Incorrect TestStepCases", cases, stepSet.getSetCase());
	}
}
