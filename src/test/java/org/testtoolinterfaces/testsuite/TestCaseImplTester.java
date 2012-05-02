package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.TestCaseImpl;
import org.testtoolinterfaces.testsuite.TestEntry;

public class TestCaseImplTester extends TestCase
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
	 * Test Cases
	 */
	public void testCase_constructor0()
	{
		Hashtable<String, String> anyParams = new Hashtable<String, String>();
		anyParams.put("param1", "value1");
		anyParams.put("param2", "value2");
		Hashtable<String, String> anyElems = new Hashtable<String, String>();
		anyElems.put("paramA", "valueA");
		anyElems.put("paramB", "valueB");
		anyElems.put("paramC", "valueC");

		TestCaseImpl testCase = new TestCaseImpl(
				"tcId",
				"An extensive description",
				3,
				new ArrayList<String>(),
				new TestStepSequence(),
				new TestStepSequence(),
				new TestStepSequence(),
				anyParams,
				anyElems );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Case, testCase.getType());
		Assert.assertEquals("Incorrect ID", "tcId", testCase.getId());
		Assert.assertEquals("Incorrect Description", "An extensive description", testCase.getDescription());
		Assert.assertEquals("Incorrect Sequence Number", 3, testCase.getSequenceNr());
		Assert.assertTrue(  "Requirements not empty", testCase.getRequirements().isEmpty());

		Assert.assertTrue(  "Preparation Steps not empty", testCase.getPrepareSteps().isEmpty());
		Assert.assertTrue(  "Execution Steps not empty", testCase.getExecutionSteps().isEmpty());
		Assert.assertTrue(  "Restore Steps not empty", testCase.getRestoreSteps().isEmpty());

		Assert.assertEquals("Incorrect Any Attributes size", 2, testCase.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 3, testCase.getAnyElements().size());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor1()
	{
		TestCaseImpl testCase = new TestCaseImpl(
				"tcId",
				"An extensive description",
				0,
				new ArrayList<String>(),
				new TestStepSequence(0),
				new TestStepSequence(0),
				new TestStepSequence(0) );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Case, testCase.getType());
		Assert.assertEquals("Incorrect ID", "tcId", testCase.getId());
		Assert.assertEquals("Incorrect Description", "An extensive description", testCase.getDescription());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor2()
	{
		TestCaseImpl testCase = new TestCaseImpl(
				"tcId",
				0,
				new ArrayList<String>(),
				new TestStepSequence(0),
				new TestStepSequence(0),
				new TestStepSequence(0) );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Case, testCase.getType());
		Assert.assertEquals("Incorrect ID", "tcId", testCase.getId());
		Assert.assertEquals("Incorrect Description", "", testCase.getDescription());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor3()
	{
		TestCaseImpl testCase = new TestCaseImpl(
				"tcId",
				"An extensive description",
				0,
				new TestStepSequence(0),
				new TestStepSequence(0),
				new TestStepSequence(0) );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Case, testCase.getType());
		Assert.assertEquals("Incorrect ID", "tcId", testCase.getId());
		Assert.assertEquals("Incorrect Description", "An extensive description", testCase.getDescription());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor4()
	{
		TestCaseImpl testCase = new TestCaseImpl(
				"tcId",
				0,
				new TestStepSequence(0),
				new TestStepSequence(0),
				new TestStepSequence(0) );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Case, testCase.getType());
		Assert.assertEquals("Incorrect ID", "tcId", testCase.getId());
		Assert.assertEquals("Incorrect Description", "", testCase.getDescription());
	}

	/**
	 * Test Cases
	 */
	public void testCase_setDescription()
	{
		TestCaseImpl testCase = new TestCaseImpl(
				"tcId",
				"An old description",
				4,
				new TestStepSequence(0),
				new TestStepSequence(0),
				new TestStepSequence(0) );

		Assert.assertEquals("Incorrect Description (1)", "An old description", testCase.getDescription());

		testCase.setDescription( "A new description" );
		Assert.assertEquals("Incorrect Description (2)", "A new description", testCase.getDescription());
	}
}
