/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestStep;
import org.testtoolinterfaces.testsuite.TestStepFactory;
import org.testtoolinterfaces.testsuite.TestStepFactoryImpl;
import org.testtoolinterfaces.testsuite.TestStepImpl;

/**
 * @author Arjan Kranenburg
 *
 */
public class TestStepFactoryImplTester extends junit.framework.TestCase
{
	TestStepFactory myTestStepFactory;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");

		myTestStepFactory = new TestStepFactoryImpl();
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepFactoryImpl#create(org.testtoolinterfaces.testsuite.TestStep.ActionType, int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreate()
	{
		TestStep testStep = myTestStepFactory.create( TestStep.ActionType.check,
		                                              "standard",
													  4,
													  "A description",
													  "Command 1",
													  new ParameterArrayList());

		Assert.assertEquals("Incorrect Class", TestStepImpl.class, testStep.getClass());
		Assert.assertEquals("Incorrect ID", "TestStep_4", testStep.getId());
		Assert.assertEquals("Incorrect Sequence Nr", 4, testStep.getSequenceNr());
		Assert.assertEquals("Incorrect Description", "A description", testStep.getDescription());
		Assert.assertEquals("Incorrect Command", "Command 1", testStep.getCommand());
	}
}
