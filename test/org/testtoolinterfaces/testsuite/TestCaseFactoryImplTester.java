/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.ParameterTable;
import org.testtoolinterfaces.testsuite.TestCase;
import org.testtoolinterfaces.testsuite.TestCaseFactory;
import org.testtoolinterfaces.testsuite.TestCaseFactoryImpl;
import org.testtoolinterfaces.testsuite.TestCaseImpl;
import org.testtoolinterfaces.testsuite.TestCaseLink;
import org.testtoolinterfaces.testsuite.TestCaseLinkImpl;
import org.testtoolinterfaces.testsuite.TestScript;
import org.testtoolinterfaces.testsuite.TestScriptImpl;
import org.testtoolinterfaces.testsuite.TestStep;
import org.testtoolinterfaces.testsuite.TestStepArrayList;
import org.testtoolinterfaces.testsuite.TestStepFactory;
import org.testtoolinterfaces.testsuite.TestStepFactoryImpl;
import org.testtoolinterfaces.testsuite.TestStepImpl;

/**
 * @author Arjan Kranenburg
 *
 */
public class TestCaseFactoryImplTester extends junit.framework.TestCase
{
	TestCaseFactory myTestCaseFactory;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");
		
		TestStepFactory testStepFactory = new TestStepFactoryImpl();
		myTestCaseFactory = new TestCaseFactoryImpl( testStepFactory );
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestCaseFactoryImpl#create(java.lang.String, java.lang.String, int, java.lang.String, java.util.ArrayList, org.testtoolinterfaces.testsuite.TestStepArrayList, org.testtoolinterfaces.testsuite.TestStepArrayList, java.io.File, org.testtoolinterfaces.testsuite.TestStepArrayList)}.
	 */
	@Test
	public void testCreate()
	{
		ArrayList<String> reqs = new ArrayList<String>();
		reqs.add("req1");

		TestStepArrayList initSteps = new TestStepArrayList();
		initSteps.add( new TestStepImpl( TestStep.ActionType.initialize, 1, "Init 1", "cmdInit", new ParameterTable() ) );

		TestStepArrayList execSteps = new TestStepArrayList();
		execSteps.add( new TestStepImpl( TestStep.ActionType.action, 1, "Exec 1", "cmdAction", new ParameterTable() ) );

		TestStepArrayList restoreSteps = new TestStepArrayList();
		restoreSteps.add( new TestStepImpl( TestStep.ActionType.restore, 1, "Restore 1", "cmdRestore", new ParameterTable() ) );

		TestScript testScript = new TestScriptImpl( "aScript", "stamdard", new ParameterTable() );
		TestCase testCase1 = myTestCaseFactory.create( "tc1",
													   null,
													   1,
													   "description",
													   reqs,
													   initSteps,
													   execSteps,
													   testScript,
													   restoreSteps );
		
		Assert.assertEquals("Incorrect Class", TestCaseLinkImpl.class, testCase1.getClass());
		Assert.assertEquals("Incorrect ID", "tc1", testCase1.getId());
		Assert.assertEquals("Incorrect Sequence Nr", 1, testCase1.getSequenceNr());
		Assert.assertEquals("Incorrect Description", "", testCase1.getDescription());
		Assert.assertEquals("Incorrect Requirements", reqs, testCase1.getRequirements());
		Assert.assertEquals("Incorrect initSteps", initSteps, testCase1.getInitializationSteps());
		Assert.assertEquals("Incorrect execSteps", new TestStepArrayList(), testCase1.getExecutionSteps());
		Assert.assertEquals("Incorrect File", "aScript", ((TestCaseLink) testCase1).getTestCaseScript());
		Assert.assertEquals("Incorrect restoreSteps", restoreSteps, testCase1.getRestoreSteps());
		
		TestCase testCase2 = myTestCaseFactory.create( "tc1",
													   null,
													   2,
													   "TC2 description",
													   reqs,
													   initSteps,
													   execSteps,
													   null,
													   restoreSteps );

		Assert.assertEquals("Incorrect Class", TestCaseImpl.class, testCase2.getClass());
		Assert.assertEquals("Incorrect ID", "tc1", testCase2.getId());
		Assert.assertEquals("Incorrect Sequence Nr", 2, testCase2.getSequenceNr());
		Assert.assertEquals("Incorrect Description", "TC2 description", testCase2.getDescription());
		Assert.assertEquals("Incorrect Requirements", reqs, testCase2.getRequirements());
		Assert.assertEquals("Incorrect initSteps", initSteps, testCase2.getInitializationSteps());
		Assert.assertEquals("Incorrect execSteps", execSteps, testCase2.getExecutionSteps());
		Assert.assertEquals("Incorrect restoreSteps", restoreSteps, testCase2.getRestoreSteps());

	}

}
