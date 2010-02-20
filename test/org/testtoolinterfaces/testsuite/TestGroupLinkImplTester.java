package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.ParameterTable;
import org.testtoolinterfaces.testsuite.TestEntry;
import org.testtoolinterfaces.testsuite.TestGroupLinkImpl;
import org.testtoolinterfaces.testsuite.TestScriptImpl;
import org.testtoolinterfaces.testsuite.TestStepArrayList;


public class TestGroupLinkImplTester extends TestCase
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
		TestGroupLinkImpl testGroup = new TestGroupLinkImpl( "ID2",
										 8,
										 new ArrayList<String>(),
										 new TestStepArrayList(),
										 new TestScriptImpl( "noName", "stamdard", new ParameterTable()),
										 new TestStepArrayList() );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.GroupLink, testGroup.getType());
		Assert.assertEquals("Incorrect ID", "ID2", testGroup.getId());
		Assert.assertEquals("Incorrect Sequence NR", 8, testGroup.getSequenceNr());
		Assert.assertTrue("Incorrect Description", testGroup.getDescription().isEmpty());
	}
}
