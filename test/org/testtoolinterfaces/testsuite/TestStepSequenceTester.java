package org.testtoolinterfaces.testsuite;

import java.util.Iterator;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.TestStep;

/**
 * 
 * @author Arjan
 *
 * 
 */

public class TestStepSequenceTester extends TestCase
{
	TestStep myTestStep1 = null;
	TestStep myTestStep2 = null;
	TestStep myTestStep3 = null;
	TestStep myTestStep4 = null;
	TestStep myTestStep5 = null;
	TestStep myTestStep6 = null;
	
	TestStepSequence myTestStepList = null;

	private void assertOrder( TestStepSequence atsList )
	{
		Iterator<TestStep> itr = atsList.iterator();
		int curSequence = 0;
		while(itr.hasNext())
		{
		    TestStep step = itr.next();
			Assert.assertTrue("Not ordered " + step.getDisplayName(), curSequence <= step.getSequenceNr());
			curSequence = step.getSequenceNr();
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

		TestInterface_stub iface1 = new TestInterface_stub( "interface1" );
		TestInterface_stub iface2 = new TestInterface_stub( "interface2" );
		if ( myTestStep1 == null )
		{
			myTestStep1 = new TestStepCommand(5, "command1", iface1);
		}

		if ( myTestStep2 == null )
		{
			myTestStep2 = new TestStepCommand(2, "command2", iface2);
		}

		if ( myTestStep3 == null )
		{
			myTestStep3 = new TestStepCommand(3, "command3", iface1);
		}

		if ( myTestStep4 == null )
		{
			myTestStep4 = new TestStepCommand(1, "command4", iface2);
		}

		if ( myTestStep5 == null )
		{
			myTestStep5 = new TestStepCommand(6, "command5", iface1);
		}

		if ( myTestStep6 == null )
		{
			myTestStep6 = new TestStepCommand(4, "command6", iface2);
		}
		
		if ( myTestStepList == null )
		{
			myTestStepList = new TestStepSequence(0);
			myTestStepList.add(myTestStep1);
			myTestStepList.add(myTestStep2);
			myTestStepList.add(myTestStep3);
			myTestStepList.add(myTestStep4);
			myTestStepList.add(myTestStep5);
			myTestStepList.add(myTestStep6);
		}
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor1()
	{
		TestStepSequence tsArray = new TestStepSequence(0);

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, tsArray.getType());
		Assert.assertNull(  "Step has an ID", tsArray.getId());
		Assert.assertEquals("Incorrect Description", "", tsArray.getDescription());
		Assert.assertTrue(  "Incorrect Parameters", tsArray.getParameters().isEmpty());

		Assert.assertEquals("Incorrect Size", 0, tsArray.size());
		Assert.assertTrue(  "Incorrect isEmpty", tsArray.isEmpty());
		Assert.assertEquals("Incorrect Display Name", "Ordered (0 TestStep(s))", tsArray.getDisplayName());
		
		Assert.assertTrue(  "Any Attributes not empty", tsArray.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", tsArray.getAnyElements().isEmpty());

		assertOrder(tsArray);
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor2()
	{
		TestStepSequence tsArray = new TestStepSequence(0,2);

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, tsArray.getType());
		Assert.assertNull(  "Step has an ID", tsArray.getId());
		Assert.assertEquals("Incorrect Description", "", tsArray.getDescription());
		Assert.assertTrue(  "Incorrect Parameters", tsArray.getParameters().isEmpty());

		Assert.assertEquals("Incorrect Size", 0, tsArray.size());
		Assert.assertEquals("Incorrect Display Name", "Ordered (0 TestStep(s))", tsArray.getDisplayName());

		Assert.assertTrue(  "Any Attributes not empty", tsArray.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", tsArray.getAnyElements().isEmpty());

		assertOrder(tsArray);
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor3()
	{
		TestStepSequence tsArray = new TestStepSequence();

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, tsArray.getType());
		Assert.assertNull(  "Step has an ID", tsArray.getId());
		Assert.assertEquals("Incorrect Description", "", tsArray.getDescription());
		Assert.assertTrue(  "Incorrect Parameters", tsArray.getParameters().isEmpty());

		Assert.assertEquals("Incorrect Size", 0, tsArray.size());
		Assert.assertEquals("Incorrect Display Name", "Ordered (0 TestStep(s))", tsArray.getDisplayName());

		assertOrder(tsArray);
	}

	/**
	 * Test Cases
	 */
	public void testCase_add()
	{
		TestStepSequence tsArray = new TestStepSequence(0);
		Assert.assertTrue("Add not OK", tsArray.add(myTestStep1) );
		Assert.assertTrue("Add not OK", tsArray.add(myTestStep2) );
		Assert.assertTrue("Add not OK", tsArray.add(myTestStep3) );
		Assert.assertTrue("Add not OK", tsArray.add(myTestStep4) );
		Assert.assertTrue("Add not OK", tsArray.add(myTestStep5) );
		Assert.assertTrue("Add not OK", tsArray.add(myTestStep6) );

		Assert.assertEquals("Incorrect Size", 6, tsArray.size());
//		System.out.println("Modified contents of tsArray: "); 
		Iterator<TestStep> itr = tsArray.iterator();
		int i = 0;
		while(itr.hasNext())
		{
		    TestStep step = itr.next();
//		    System.out.println( step.getSequenceNr() + " - " + step.getDisplayName());
			Assert.assertEquals("Incorrect SeqNr " + step.getDisplayName(), ++i, step.getSequenceNr());
		} 

		Assert.assertTrue("Add not OK", tsArray.add(myTestStep2) ); // Duplicates are possible
		Assert.assertEquals("Incorrect Size", 7, tsArray.size());

		assertOrder(tsArray);
	}
	
	/**
	 * Test Cases
	 */
	public void testCase_iterator()
	{
		Iterator<TestStep> itr = myTestStepList.iterator();
		int i = 0;
		while(itr.hasNext())
		{
		    TestStep step = itr.next();
			Assert.assertEquals("Incorrect SeqNr " + step.getDisplayName(), ++i, step.getSequenceNr());
		} 

		assertOrder(myTestStepList);
	}

	/**
	 * Test Cases
	 */
	public void testCase_clear()
	{
		TestStepSequence tsArray = new TestStepSequence(0);
		tsArray.add(myTestStep1);
		tsArray.add(myTestStep2);
		tsArray.add(myTestStep3);

		Assert.assertEquals("Incorrect Size", 3, tsArray.size());
		tsArray.clear();
		Assert.assertEquals("Incorrect Size", 0, tsArray.size());

		assertOrder(tsArray);
	}

	/**
	 * Test Cases
	 */
	public void testCase_remove()
	{
		TestStepSequence tsArray = new TestStepSequence(0);
		tsArray.add(myTestStep1);
		tsArray.add(myTestStep2);
		tsArray.add(myTestStep3);
		Assert.assertEquals("Incorrect Size", 3, tsArray.size());

		Assert.assertTrue("Remove not OK", tsArray.remove(myTestStep2) );
		Assert.assertEquals("Incorrect Size", 2, tsArray.size());
		assertOrder(tsArray);

		Assert.assertFalse("Remove OK, should not", tsArray.remove(myTestStep2) ); //again
		Assert.assertEquals("Incorrect Size", 2, tsArray.size());
		assertOrder(tsArray);

		Assert.assertTrue("Remove not OK", tsArray.remove(myTestStep1) );
		Assert.assertEquals("Incorrect Size", 1, tsArray.size());
		assertOrder(tsArray);

		Assert.assertFalse("Remove OK, should not", tsArray.remove(myTestStep4) ); //non-existing
		Assert.assertEquals("Incorrect Size", 1, tsArray.size());
		assertOrder(tsArray);

		tsArray.add(myTestStep5); // new one
		Assert.assertEquals("Incorrect Size", 2, tsArray.size());
		assertOrder(tsArray);

		Assert.assertTrue("Remove not OK", tsArray.remove(myTestStep3) ); // last of orginal
		Assert.assertEquals("Incorrect Size", 1, tsArray.size());
		assertOrder(tsArray);

		tsArray.add(myTestStep6);
		tsArray.add(myTestStep6); // Duplicates are possible
		Assert.assertEquals("Incorrect Size", 3, tsArray.size());
		assertOrder(tsArray);

		Assert.assertTrue("Remove not OK", tsArray.remove(myTestStep6) ); // Removes one
		Assert.assertEquals("Incorrect Size", 2, tsArray.size());
		assertOrder(tsArray);

		Assert.assertTrue("Remove not OK", tsArray.remove(myTestStep6) ); // Removes other
		Assert.assertEquals("Incorrect Size", 1, tsArray.size());
		assertOrder(tsArray);

		Assert.assertTrue("Remove not OK", tsArray.remove(myTestStep5) ); // last remaining
		Assert.assertEquals("Incorrect Size", 0, tsArray.size());
		assertOrder(tsArray);
	}

	/**
	 * Test Cases
	 */
	public void testCase_removeAll()
	{
		TestStepSequence tsArray1 = new TestStepSequence(0);
		tsArray1.add(myTestStep1);
		tsArray1.add(myTestStep2);
		tsArray1.add(myTestStep3);
		tsArray1.add(myTestStep3); // Duplicates are possible
		tsArray1.add(myTestStep4);

		TestStepSequence tsArray2 = new TestStepSequence(0);
		tsArray2.add(myTestStep2);
		tsArray2.add(myTestStep3);

		TestStepSequence tsArray3 = new TestStepSequence(0);
		tsArray3.add(myTestStep4);
		tsArray3.add(myTestStep5);

		Assert.assertEquals("Incorrect Size", 5, tsArray1.size());
		assertOrder(tsArray1);

		tsArray1.removeAll(tsArray2); // all of tsArray2 match
		Assert.assertEquals("Incorrect Size", 2, tsArray1.size()); // Also both step3 are removed
		assertOrder(tsArray1);

		tsArray1.removeAll(tsArray3); // some match
		Assert.assertEquals("Incorrect Size", 1, tsArray1.size());
		assertOrder(tsArray1);
	}

	/**
	 * Test Cases
	 */
	public void testCase_retainAll()
	{
		TestStepSequence tsArray1 = new TestStepSequence(0);
		tsArray1.add(myTestStep1);
		tsArray1.add(myTestStep2);
		tsArray1.add(myTestStep3);
		tsArray1.add(myTestStep3); // Duplicates are possible
		tsArray1.add(myTestStep4);

		TestStepSequence tsArray2 = new TestStepSequence(1);
		tsArray2.add(myTestStep2);
		tsArray2.add(myTestStep3);

		TestStepSequence tsArray3 = new TestStepSequence(2);
		tsArray3.add(myTestStep2);
		tsArray3.add(myTestStep5);

		TestStepSequence tsArray4 = new TestStepSequence(3);
		tsArray4.add(myTestStep2);

		Assert.assertEquals("Incorrect Size", 5, tsArray1.size());

		Assert.assertTrue( "List not changed", tsArray1.retainAll(tsArray2) );
		Assert.assertEquals("Incorrect Size", 3, tsArray1.size()); // Also both step3 are retained
		assertOrder(tsArray1);

		Assert.assertTrue( "List not changed", tsArray1.retainAll(tsArray3) ); // some match
		Assert.assertEquals("Incorrect Size", 1, tsArray1.size());
		assertOrder(tsArray1);

		Assert.assertFalse( "List changed, should not", tsArray1.retainAll(tsArray4) ); // all matches
		Assert.assertEquals("Incorrect Size", 1, tsArray1.size());
		assertOrder(tsArray1);
	}

	/**
	 * Test Cases
	 */
	public void testCase_containsAll()
	{
		TestStepSequence tsArray2 = new TestStepSequence(1);
		tsArray2.add(myTestStep2);
		tsArray2.add(myTestStep4);

		TestStepSequence tsArray3 = new TestStepSequence(2);
		tsArray3.add(myTestStep2);
		tsArray3.add(myTestStep5);
		TestStepCommand testStep7 = new TestStepCommand(4, "command7", new TestInterface_stub( "interface1" ));
		tsArray3.add(testStep7);

		TestStepSequence tsArray4 = new TestStepSequence(3);
		tsArray4.add(myTestStep2);
		tsArray4.add(myTestStep4);
		tsArray4.add(myTestStep4);

		Assert.assertTrue( "List did not contain all", myTestStepList.containsAll(tsArray2) );
		Assert.assertFalse( "List contains all, but should not", myTestStepList.containsAll(tsArray3) );
		Assert.assertTrue( "List did not contain all", tsArray4.containsAll(tsArray2) ); // Also works with duplicates
	}

	/**
	 * Test Cases
	 */
	public void testCase_toArray()
	{
		TestStep[] tsArray = myTestStepList.toArray();

		Assert.assertEquals("Incorrect size", 6, tsArray.length );
	}

	/**
	 * Test Cases
	 */
	public void testCase_toArray_Array()
	{
		TestStep[] array_small = new TestStep[ 4 ];
		TestStep[] tsArray1 = myTestStepList.toArray( array_small );
		Assert.assertNotSame("Same array returned", array_small, tsArray1);
		Assert.assertEquals( "Incorrect size", 6, tsArray1.length );

		TestStep[] array_ok = new TestStep[ 6 ];
		TestStep[] tsArray2 = myTestStepList.toArray( array_ok );
		Assert.assertSame("New array returned", array_ok, tsArray2);
		Assert.assertEquals( "Incorrect size", 6, tsArray2.length );

		TestStep[] array_large = new TestStep[ 9 ];
		TestStep[] tsArray3 = myTestStepList.toArray( array_large );
		Assert.assertSame("New array returned", array_large, tsArray3);
		Assert.assertEquals( "Incorrect size", 9, tsArray3.length );
	}

	/**
	 * Test Cases
	 */
	public void testCase_addAll_Collection()
	{
		// order of steps: 2 7 5 8
		TestStepSequence tsArray = new TestStepSequence(0);
		tsArray.add(myTestStep2);
		tsArray.add(myTestStep5);
		TestStepCommand testStep7 = new TestStepCommand(4, "command7", new TestInterface_stub( "interface1" ));
		tsArray.add(testStep7);
		TestStepCommand testStep8 = new TestStepCommand(7, "command8", new TestInterface_stub( "interface1" ));
		tsArray.add(testStep8);

		Assert.assertTrue("No steps were added", tsArray.addAll(myTestStepList) );
		Assert.assertEquals("Incorrect size", 10, tsArray.size());
		Assert.assertEquals("Incorrect size", 6, myTestStepList.size()); // unchanged
		assertOrder(tsArray);

		Assert.assertTrue("No steps were added", tsArray.addAll(myTestStepList) );
		Assert.assertEquals("Incorrect size", 16, tsArray.size());
		assertOrder(tsArray);
	}
}
