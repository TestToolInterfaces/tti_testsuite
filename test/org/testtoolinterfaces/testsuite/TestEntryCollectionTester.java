package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestCaseImpl;
import org.testtoolinterfaces.testsuite.TestEntryCollection;
import org.testtoolinterfaces.testsuite.TestGroupImpl;
import org.testtoolinterfaces.testsuite.TestStep;


public class TestEntryCollectionTester extends TestCase
{
	private void assertOrder( TestEntryCollection atsList )
	{
		Iterator<TestEntry> itr = atsList.iterator();
		int curSequence = 0;
		while(itr.hasNext())
		{
			TestEntry entry = itr.next();
			Assert.assertTrue("Not ordered " + entry.toString(), curSequence <= entry.getSequenceNr());
			curSequence = entry.getSequenceNr();
		}		
	}

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
		TestEntryCollection teArray = new TestEntryCollection();

		Assert.assertEquals("Incorrect Size", 0, teArray.size());

		TestCaseImpl testCase = new TestCaseImpl( "tcId",
				"An extensive description",
				0,
				new TestStepCollection(),
				new TestStepCollection(),
				new TestStepCollection() );

		TestInterface_stub iface = new TestInterface_stub( "interface" );
		TestStep testStep = new TestStepCommand(
				3,
				"description2",
				"command2",
				iface,
				new ParameterArrayList() );

		TestGroupImpl testGroup = new TestGroupImpl( "ID",
				 "A Description",
				 3,
				 new ArrayList<String>(),
				 new TestStepCollection(0),
				 new TestEntryCollection(),
				 new TestStepCollection(0),
				 new Hashtable<String, String>(),
				 new Hashtable<String, String>() );

	
		teArray.add(testCase);
		teArray.add(testStep);
		teArray.add(testGroup);

		Assert.assertEquals("Incorrect Size", 3, teArray.size());
		assertOrder( teArray );
	}
}
