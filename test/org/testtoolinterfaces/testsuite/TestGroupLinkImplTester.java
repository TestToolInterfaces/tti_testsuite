package org.testtoolinterfaces.testsuite;

import java.io.File;
import java.util.Hashtable;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;


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
		TestGroupLink testGroup = new TestGroupLink( "ID2", 
		                                                     "aType",
		                                                     8,
															 new File(""),
															 new Hashtable<String, String>() );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.GroupLink, testGroup.getType());
		Assert.assertEquals("Incorrect ID", "ID2", testGroup.getId());
		Assert.assertEquals("Incorrect Sequence NR", 8, testGroup.getSequenceNr());
		Assert.assertTrue("Incorrect Description", testGroup.getDescription().isEmpty());
	}
}
