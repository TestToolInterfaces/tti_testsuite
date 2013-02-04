package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;


public class TestGroupEntrySequenceTester extends TestCase
{
	TestCaseImpl myTestCase = null;
	TestCaseLink myTestCase2 = null;
	TestGroup myTestGroup = null;
	
	TestGroupEntrySequence myTestEntryList = null;

	private void assertOrder( TestGroupEntrySequence atsList )
	{
		Iterator<TestGroupEntry> itr = atsList.iterator();
		int curSequence = 0;
		while(itr.hasNext())
		{
			TestGroupEntry entry = itr.next();
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

		if ( myTestCase == null )
		{
			myTestCase = new TestCaseImpl( "tcId",
			                               "An extensive description",
			                               2,
			                               new TestStepSequence(),
			                               new TestStepSequence(),
			                               new TestStepSequence() );
		}

		if ( myTestCase2 == null )
		{
			myTestCase2 = new TestCaseLink( "tcId",
			                               3,
			                              "link" );
		}

		if ( myTestGroup == null )
		{
			myTestGroup = new TestGroupImpl( "ID",
			                                 "A Description",
			                                 1,
			                                 new ArrayList<String>(),
			                                 new TestStepSequence(),
			                                 new TestGroupEntrySequence(),
			                                 new TestStepSequence() );
		}

		if ( myTestEntryList == null )
		{
			myTestEntryList = new TestGroupEntrySequence();
			myTestEntryList.add(myTestCase);
			myTestEntryList.add(myTestGroup);
			
		}
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor()
	{
		TestGroupEntrySequence teArray = new TestGroupEntrySequence();

		Assert.assertEquals("Incorrect Size", 0, teArray.size());
		Assert.assertTrue(  "Incorrect isEmpty", teArray.isEmpty());
	}

	/**
	 * Test Cases
	 */
	public void testCase_add()
	{
		TestGroupEntrySequence teArray = new TestGroupEntrySequence();

		Assert.assertTrue("Add not OK", teArray.add(myTestCase) );
		Assert.assertTrue("Add not OK", teArray.add(myTestGroup) );

		Assert.assertEquals("Incorrect Size", 2, teArray.size());
		assertOrder( teArray );
	}

	/**
	 * Test Cases
	 */
	public void testCase_iterator()
	{
		Iterator<TestGroupEntry> itr = myTestEntryList.iterator();
		int i = 0;
		while(itr.hasNext())
		{
		    TestGroupEntry entry = itr.next();
			Assert.assertEquals("Incorrect SeqNr " + entry.toString(), ++i, entry.getSequenceNr());
		} 

		assertOrder(myTestEntryList);
	}

	/**
	 * Test Cases
	 */
	public void testCase_clear()
	{
		TestGroupEntrySequence teArray = new TestGroupEntrySequence(0);
		teArray.add(myTestCase);
		teArray.add(myTestGroup);

		Assert.assertEquals("Incorrect Size", 2, teArray.size());
		teArray.clear();
		Assert.assertEquals("Incorrect Size", 0, teArray.size());

		assertOrder(teArray);
	}

	/**
	 * Test Cases
	 */
	public void testCase_remove()
	{
		TestGroupEntrySequence teArray = new TestGroupEntrySequence(0);
		teArray.add(myTestCase);
		teArray.add(myTestGroup);
		Assert.assertEquals("Incorrect Size", 2, teArray.size());

		Assert.assertTrue("Remove not OK", teArray.remove(myTestCase) );
		Assert.assertEquals("Incorrect Size", 1, teArray.size());
		assertOrder(teArray);

		Assert.assertFalse("Remove OK, should not", teArray.remove(myTestCase2) ); //non-existing
		Assert.assertEquals("Incorrect Size", 1, teArray.size());
		assertOrder(teArray);

		teArray.add(myTestCase2); // new one
		Assert.assertEquals("Incorrect Size", 2, teArray.size());
		assertOrder(teArray);

		Assert.assertTrue("Remove not OK", teArray.remove(myTestGroup) ); // last of orginal
		Assert.assertEquals("Incorrect Size", 1, teArray.size());
		assertOrder(teArray);

		teArray.add(myTestGroup);
		teArray.add(myTestGroup); // Duplicates are possible
		Assert.assertEquals("Incorrect Size", 3, teArray.size());
		assertOrder(teArray);

		Assert.assertTrue("Remove not OK", teArray.remove(myTestGroup) ); // Removes one
		Assert.assertEquals("Incorrect Size", 2, teArray.size());
		assertOrder(teArray);

		Assert.assertTrue("Remove not OK", teArray.remove(myTestGroup) ); // Removes other
		Assert.assertEquals("Incorrect Size", 1, teArray.size());
		assertOrder(teArray);

		Assert.assertTrue("Remove not OK", teArray.remove(myTestCase2) ); // last remaining
		Assert.assertEquals("Incorrect Size", 0, teArray.size());
		assertOrder(teArray);
	}

	/**
	 * Test Cases
	 */
	public void testCase_removeAll()
	{
		TestGroupEntrySequence teArray1 = new TestGroupEntrySequence(0);
		teArray1.add(myTestCase);
		teArray1.add(myTestGroup);
		teArray1.add(myTestCase); // Duplicates are possible
		teArray1.add(myTestCase2);

		TestGroupEntrySequence teArray2 = new TestGroupEntrySequence(0);
		teArray2.add(myTestCase);
		teArray2.add(myTestGroup);

		TestGroupEntrySequence teArray3 = new TestGroupEntrySequence(0);
		teArray3.add(myTestGroup);

		Assert.assertEquals("Incorrect Size", 4, teArray1.size());
		assertOrder(teArray1);

		teArray1.removeAll(teArray2); // all of teArray2 match
		Assert.assertEquals("Incorrect Size", 1, teArray1.size()); // Also both entry3 are removed
		assertOrder(teArray1);

		teArray1.removeAll(teArray3); // no match
		Assert.assertEquals("Incorrect Size", 1, teArray1.size());
		assertOrder(teArray1);
	}

	/**
	 * Test Cases
	 */
	public void testCase_retainAll()
	{
		TestGroupEntrySequence teArray1 = new TestGroupEntrySequence(0);
		teArray1.add(myTestCase);
		teArray1.add(myTestGroup);
		teArray1.add(myTestCase2);

		TestGroupEntrySequence teArray2 = new TestGroupEntrySequence(1);
		teArray2.add(myTestGroup);

		TestGroupEntrySequence teArray3 = new TestGroupEntrySequence(2);
		teArray3.add(myTestGroup);
		teArray3.add(myTestCase2);

		TestGroupEntrySequence teArray4 = new TestGroupEntrySequence(3);
		teArray4.add(myTestGroup);

		Assert.assertEquals("Incorrect Size", 3, teArray1.size());

		Assert.assertTrue( "List not changed", teArray1.retainAll(teArray2) );
		Assert.assertEquals("Incorrect Size", 1, teArray1.size()); // Also both entry3 are retained
		assertOrder(teArray1);

		Assert.assertFalse( "List changed, should not", teArray1.retainAll(teArray3) ); // some match
		Assert.assertEquals("Incorrect Size", 1, teArray1.size());
		assertOrder(teArray1);

		Assert.assertFalse( "List changed, should not", teArray1.retainAll(teArray4) ); // all matches
		Assert.assertEquals("Incorrect Size", 1, teArray1.size());
		assertOrder(teArray1);
	}

	/**
	 * Test Cases
	 */
	public void testCase_containsAll()
	{
		TestGroupEntrySequence teArray1 = new TestGroupEntrySequence();
		teArray1.add(myTestCase);
		
		TestGroupEntrySequence teArray2 = new TestGroupEntrySequence(1);
		teArray2.add(myTestCase);
		teArray2.add(myTestGroup);
		teArray2.add(myTestGroup);

		TestGroupEntrySequence teArray3 = new TestGroupEntrySequence(2);
		teArray3.add(myTestCase2);

		TestGroupEntrySequence teArray4 = new TestGroupEntrySequence(3);
		teArray4.add(myTestCase);
		teArray4.add(myTestCase);

		Assert.assertTrue( "List did not contain all", myTestEntryList.containsAll(teArray2) );
		Assert.assertFalse( "List contains all, but should not", myTestEntryList.containsAll(teArray3) );
		Assert.assertTrue( "List did not contain all", teArray4.containsAll(teArray1) ); // Also works with duplicates
	}

	/**
	 * Test Cases
	 */
	public void testCase_toArray()
	{
		TestGroupEntry[] teArray = myTestEntryList.toArray();

		Assert.assertEquals("Incorrect size", 2, teArray.length );
	}

	/**
	 * Test Cases
	 */
	public void testCase_toArray_Array()
	{
		TestGroupEntry[] array_small = new TestGroupEntry[ 2 ];
		TestGroupEntry[] teArray1 = myTestEntryList.toArray( array_small );
		Assert.assertSame("Same array returned", array_small, teArray1);
		Assert.assertEquals( "Incorrect size", 2, teArray1.length );

		TestGroupEntry[] array_ok = new TestGroupEntry[ 3 ];
		TestGroupEntry[] teArray2 = myTestEntryList.toArray( array_ok );
		Assert.assertSame("New array returned", array_ok, teArray2);
		Assert.assertEquals( "Incorrect size", 3, teArray2.length );

		TestGroupEntry[] array_large = new TestGroupEntry[ 5 ];
		TestGroupEntry[] teArray3 = myTestEntryList.toArray( array_large );
		Assert.assertSame("New array returned", array_large, teArray3);
		Assert.assertEquals( "Incorrect size", 5, teArray3.length );
	}

	/**
	 * Test Cases
	 */
	public void testCase_addAll_Collection()
	{
		// order of steps: 2 7 5 8
		TestGroupEntrySequence teArray = new TestGroupEntrySequence(0);
		teArray.add(myTestCase);
		TestCaseImpl testCase7 = new TestCaseImpl( "tc7", "An extensive description", 4,
				new TestStepSequence(), new TestStepSequence(), new TestStepSequence() );
		teArray.add(testCase7);

		TestCaseImpl testCase8 = new TestCaseImpl( "tc8", "An extensive description", 7,
				new TestStepSequence(), new TestStepSequence(), new TestStepSequence() );
		teArray.add(testCase8);

		Assert.assertTrue("No steps were added", teArray.addAll(myTestEntryList) );
		Assert.assertEquals("Incorrect size", 5, teArray.size());
		Assert.assertEquals("Incorrect size", 2, myTestEntryList.size()); // unchanged
		assertOrder(teArray);

		Assert.assertTrue("No steps were added", teArray.addAll(myTestEntryList) );
		Assert.assertEquals("Incorrect size", 7, teArray.size());
		assertOrder(teArray);
	}
}
