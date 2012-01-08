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
		TestCaseImpl testCase = new TestCaseImpl(
				"tcId",
				"An extensive description",
				3,
				new ArrayList<String>(),
				new TestStepCollection(),
				new TestStepCollection(),
				new TestStepCollection(),
				new Hashtable<String, String>(),
				new Hashtable<String, String>() );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Case, testCase.getType());
		Assert.assertEquals("Incorrect ID", "tcId", testCase.getId());
		Assert.assertEquals("Incorrect Description", "An extensive description", testCase.getDescription());
		Assert.assertEquals("Incorrect Sequence Number", 3, testCase.getSequenceNr());
		Assert.assertTrue(  "Requirements not empty", testCase.getRequirements().isEmpty());

		Assert.assertTrue(  "Preparation Steps not empty", testCase.getPrepareSteps().isEmpty());
		Assert.assertTrue(  "Execution Steps not empty", testCase.getExecutionSteps().isEmpty());
		Assert.assertTrue(  "Restore Steps not empty", testCase.getRestoreSteps().isEmpty());

		Assert.assertTrue(  "Any Attributes not empty", testCase.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", testCase.getAnyElements().isEmpty());
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
				new TestStepCollection(0),
				new TestStepCollection(0),
				new TestStepCollection(0) );

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
				new TestStepCollection(0),
				new TestStepCollection(0),
				new TestStepCollection(0) );

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
				new TestStepCollection(0),
				new TestStepCollection(0),
				new TestStepCollection(0) );

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
				new TestStepCollection(0),
				new TestStepCollection(0),
				new TestStepCollection(0) );

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
				new TestStepCollection(0),
				new TestStepCollection(0),
				new TestStepCollection(0) );

		Assert.assertEquals("Incorrect Description (1)", "An old description", testCase.getDescription());

		testCase.setDescription( "A new description" );
		Assert.assertEquals("Incorrect Description (2)", "A new description", testCase.getDescription());
	}
}
