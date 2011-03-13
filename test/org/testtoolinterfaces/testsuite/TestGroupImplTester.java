package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.TestEntry;
import org.testtoolinterfaces.testsuite.TestEntryArrayList;
import org.testtoolinterfaces.testsuite.TestGroupImpl;
import org.testtoolinterfaces.testsuite.TestStepArrayList;


public class TestGroupImplTester extends TestCase
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
		TestGroupImpl testGroup = new TestGroupImpl( "ID",
		                                             new Hashtable<String, String>(),
		                                             "A Description",
		                                             new ArrayList<String>(),
		                                             new TestStepArrayList(),
		                                             new TestEntryArrayList(),
		                                             new TestStepArrayList(),
		                                             new Hashtable<String, String>() );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Group, testGroup.getType());
		Assert.assertEquals("Incorrect ID", "ID", testGroup.getId());
		Assert.assertEquals("Incorrect Description", "A Description", testGroup.getDescription());
	}
}
