package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestCaseLinkImpl;
import org.testtoolinterfaces.testsuite.TestEntry;
import org.testtoolinterfaces.testsuite.TestScriptImpl;
import org.testtoolinterfaces.testsuite.TestStepArrayList;


public class TestCaseLinkImplTester extends TestCase
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
	public void testCase_constructor()
	{
		TestCaseLinkImpl testCaseLink = new TestCaseLinkImpl(
				"tc2",
				"standard",
				7,
				new ArrayList<String>(),
				new TestStepArrayList(),
				new TestScriptImpl( "noName", "stamdard", new ParameterArrayList() ),
				new TestStepArrayList()
		);
		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.CaseLink, testCaseLink.getType());
		Assert.assertEquals("Incorrect ID", "tc2", testCaseLink.getId());
		Assert.assertEquals("Incorrect Sequence NR", 7, testCaseLink.getSequenceNr());
		Assert.assertEquals("Incorrect Description", "", testCaseLink.getDescription());
		Assert.assertTrue("Execution Steps not empty", testCaseLink.getExecutionSteps().isEmpty());
		Assert.assertEquals("Incorrect FileName", "noName", testCaseLink.getTestCaseScript().getExecutionScript());
	}
}
