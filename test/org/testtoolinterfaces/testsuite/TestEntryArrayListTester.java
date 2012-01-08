package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Hashtable;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestCaseImpl;
import org.testtoolinterfaces.testsuite.TestEntryArrayList;
import org.testtoolinterfaces.testsuite.TestGroupImpl;
import org.testtoolinterfaces.testsuite.TestStep;


public class TestEntryArrayListTester extends TestCase
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
		TestEntryArrayList teArray = new TestEntryArrayList();

		Assert.assertEquals("Incorrect Size", 0, teArray.size());
	}

	/**
	 * Test Cases
	 */
	public void testCase_sort()
	{
		TestCaseImpl testCase = new TestCaseImpl( "tcId",
				"An extensive description",
				0,
				new TestStepCollection(0),
				new TestStepCollection(0),
				new TestStepCollection(0) );

		TestInterface_stub iface = new TestInterface_stub( "interface" );
		TestStep testStep = new TestStepCommand(
				3,
				"description2",
				"command2",
				iface,
				new ParameterArrayList() );

		TestGroupImpl testGroup = new TestGroupImpl( "ID",
				 new Hashtable<String, String>(),
				 "A Description",
				 new ArrayList<String>(),
				 new TestStepCollection(0),
				 new TestEntryArrayList(),
				 new TestStepCollection(0),
				 new Hashtable<String, String>() );

	
		TestEntryArrayList teArray = new TestEntryArrayList();
		teArray.add(testCase);
		teArray.add(testStep);
		teArray.add(testGroup);

		TestEntryArrayList newArray = teArray.sort();

		// Old array remains unchanged
		Assert.assertEquals("Incorrect Size", 3, teArray.size());
//		Assert.assertEquals("Incorrect SeqNr 1st step", 5, teArray.get(0).getSequenceNr());
//		Assert.assertEquals("Incorrect SeqNr 2nd step", 3, teArray.get(1).getSequenceNr());
//		Assert.assertEquals("Incorrect SeqNr 3rd step", 4, teArray.get(2).getSequenceNr());

		Assert.assertEquals("Incorrect Size", 3, newArray.size());
//		Assert.assertEquals("Incorrect SeqNr 1st step", 3, newArray.get(0).getSequenceNr());
//		Assert.assertEquals("Incorrect SeqNr 2nd step", 4, newArray.get(1).getSequenceNr());
//		Assert.assertEquals("Incorrect SeqNr 3rd step", 5, newArray.get(2).getSequenceNr());
	}
}
