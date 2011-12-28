package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.TestStep;

public class TestStepSetCaseTester extends TestCase
{
	TestStep myTestStep;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");

		TestInterface iface = new TestInterface_stub( "interface1" );

		myTestStep = new TestStepCommand(
				TestStep.StepType.check,
				0,
				"An extensive description",
				"command string",
				iface,
				new ParameterArrayList() );
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepSetCase#TestStepSetCase()}.
	 */
	@Test
	public void testConstructor()
	{
		TestStepSetCase stepSetCase = new TestStepSetCase( "anId", "afterClaus", myTestStep, new TestStepArrayList() );

//		Assert.assertEquals("Incorrect Type", TestStep.StepType.set, stepSet.getStepType());
//		Assert.assertEquals("Incorrect TestStepCases", cases, stepSet.getSetCase());
	}
}
