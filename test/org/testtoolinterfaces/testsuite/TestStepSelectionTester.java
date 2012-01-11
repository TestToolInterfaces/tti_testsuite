package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.TestEntry;

public class TestStepSelectionTester extends TestCase
{
	private static final String IF_THEN_ELSE_DISPLAY = "if - then - else";
	private static final String IF_THEN_DISPLAY = "if - then";
	private static final String IF_THEN_ELSE_STRING = "if (interface1->commandA) then {interface1->commandB} else {interface1->commandC}";
	private static final String IF_THEN_STRING = "if (interface1->commandA) then {interface1->commandB}";
	private TestInterface_stub myIface = null;
	private TestStepCommand myTsIf = null;
	private TestStepCommand myTsThen = null;
	private TestStepCommand myTsElse = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");
		
		if ( myIface== null )
		{
			myIface = new TestInterface_stub( "interface1" );
		}
		
		if ( myTsIf== null )
		{
			myTsIf = new TestStepCommand( 0, "commandA", myIface );
		}
		
		if ( myTsThen== null )
		{
			myTsThen = new TestStepCommand( 0, "commandB", myIface );
		}
		
		if ( myTsElse== null )
		{
			myTsElse = new TestStepCommand( 0, "commandC", myIface );
		}
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepSelection#TestStepSelection()}.
	 */
	@Test
	public void testConstructor1()
	{
		Hashtable<String, String> anyParams = new Hashtable<String, String>();
		anyParams.put("param1", "value1");
		anyParams.put("param2", "value2");
		Hashtable<String, String> anyElems = new Hashtable<String, String>();
		anyElems.put("paramA", "valueA");
		anyElems.put("paramB", "valueB");
		anyElems.put("paramC", "valueC");

		TestStepSelection testStep = new TestStepSelection(
				0,
				"An extensive description",
				myTsIf,
				myTsThen,
				myTsElse,
				anyParams,
				anyElems );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertNull(  "Step has an ID", testStep.getId());
		Assert.assertEquals("Incorrect Description", "An extensive description", testStep.getDescription());
		Assert.assertTrue(  "Incorrect Parameters", testStep.getParameters().isEmpty());

		Assert.assertEquals("Incorrect if-TestStep", myTsIf, testStep.getIfStep());
		Assert.assertEquals("Incorrect then-TestStep", myTsThen, testStep.getThenStep());
		Assert.assertEquals("Incorrect else-TestStep", myTsElse, testStep.getElseStep());
		Assert.assertEquals("Incorrect Display Name", IF_THEN_ELSE_DISPLAY, testStep.getDisplayName());
		Assert.assertEquals("Incorrect toString", IF_THEN_ELSE_STRING, testStep.toString());

		Assert.assertEquals("Incorrect Any Attributes size", 2, testStep.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 3, testStep.getAnyElements().size());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepSelection#TestStepSelection()}.
	 */
	@Test
	public void testConstructor2()
	{
		TestStepSelection testStep = new TestStepSelection(
		                                   				0,
		                                   				"An extensive description",
		                                   				myTsIf,
		                                   				myTsThen,
		                                   				myTsElse );

   		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
   		Assert.assertNull(  "Step has an ID", testStep.getId());
   		Assert.assertEquals("Incorrect Description", "An extensive description", testStep.getDescription());
   		Assert.assertTrue(  "Incorrect Parameters", testStep.getParameters().isEmpty());

   		Assert.assertEquals("Incorrect if-TestStep", myTsIf, testStep.getIfStep());
   		Assert.assertEquals("Incorrect then-TestStep", myTsThen, testStep.getThenStep());
   		Assert.assertEquals("Incorrect else-TestStep", myTsElse, testStep.getElseStep());
   		Assert.assertEquals("Incorrect Display Name", IF_THEN_ELSE_DISPLAY, testStep.getDisplayName());
   		Assert.assertEquals("Incorrect toString", IF_THEN_ELSE_STRING, testStep.toString());

		Assert.assertTrue(  "Any Attributes not empty", testStep.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", testStep.getAnyElements().isEmpty());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepSelection#TestStepSelection()}.
	 */
	@Test
	public void testConstructor3()
	{
		TestStepSelection testStep = new TestStepSelection(
		                                   				0,
		                                   				myTsIf,
		                                   				myTsThen,
		                                   				myTsElse );

   		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
   		Assert.assertNull(  "Step has an ID", testStep.getId());
		Assert.assertEquals("Incorrect Description", "", testStep.getDescription());
   		Assert.assertTrue(  "Incorrect Parameters", testStep.getParameters().isEmpty());

   		Assert.assertEquals("Incorrect if-TestStep", myTsIf, testStep.getIfStep());
   		Assert.assertEquals("Incorrect then-TestStep", myTsThen, testStep.getThenStep());
   		Assert.assertEquals("Incorrect else-TestStep", myTsElse, testStep.getElseStep());
   		Assert.assertEquals("Incorrect Display Name", IF_THEN_ELSE_DISPLAY, testStep.getDisplayName());
   		Assert.assertEquals("Incorrect toString", IF_THEN_ELSE_STRING, testStep.toString());

		Assert.assertTrue(  "Any Attributes not empty", testStep.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", testStep.getAnyElements().isEmpty());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepSelection#TestStepSelection()}.
	 */
	@Test
	public void testConstructor4()
	{
		TestStepSelection testStep = new TestStepSelection(
		                                   				0,
		                                   				"An extensive description",
		                                   				myTsIf,
		                                   				myTsThen );

   		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
   		Assert.assertNull(  "Step has an ID", testStep.getId());
   		Assert.assertEquals("Incorrect Description", "An extensive description", testStep.getDescription());
   		Assert.assertTrue(  "Incorrect Parameters", testStep.getParameters().isEmpty());

   		Assert.assertEquals("Incorrect if-TestStep", myTsIf, testStep.getIfStep());
   		Assert.assertEquals("Incorrect then-TestStep", myTsThen, testStep.getThenStep());
   		Assert.assertNull(  "Else-TestStep not null", testStep.getElseStep());
   		Assert.assertEquals("Incorrect Display Name", IF_THEN_DISPLAY, testStep.getDisplayName());
   		Assert.assertEquals("Incorrect toString", IF_THEN_STRING, testStep.toString());

		Assert.assertTrue(  "Any Attributes not empty", testStep.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", testStep.getAnyElements().isEmpty());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepSelection#TestStepSelection()}.
	 */
	@Test
	public void testConstructor5()
	{
		TestStepSelection testStep = new TestStepSelection(
		                                   				0,
		                                   				myTsIf,
		                                   				myTsThen );

   		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
   		Assert.assertNull(  "Step has an ID", testStep.getId());
		Assert.assertEquals("Incorrect Description", "", testStep.getDescription());
   		Assert.assertTrue(  "Incorrect Parameters", testStep.getParameters().isEmpty());

   		Assert.assertEquals("Incorrect if-TestStep", myTsIf, testStep.getIfStep());
   		Assert.assertEquals("Incorrect then-TestStep", myTsThen, testStep.getThenStep());
   		Assert.assertNull(  "Else-TestStep not null", testStep.getElseStep());
   		Assert.assertEquals("Incorrect Display Name", IF_THEN_DISPLAY, testStep.getDisplayName());
   		Assert.assertEquals("Incorrect toString", IF_THEN_STRING, testStep.toString());

		Assert.assertTrue(  "Any Attributes not empty", testStep.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", testStep.getAnyElements().isEmpty());
	}
}
