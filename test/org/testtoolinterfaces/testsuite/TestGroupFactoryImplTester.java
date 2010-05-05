/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestCaseFactory;
import org.testtoolinterfaces.testsuite.TestCaseFactoryImpl;
import org.testtoolinterfaces.testsuite.TestEntryArrayList;
import org.testtoolinterfaces.testsuite.TestGroup;
import org.testtoolinterfaces.testsuite.TestGroupFactory;
import org.testtoolinterfaces.testsuite.TestGroupFactoryImpl;
import org.testtoolinterfaces.testsuite.TestGroupImpl;
import org.testtoolinterfaces.testsuite.TestGroupLink;
import org.testtoolinterfaces.testsuite.TestGroupLinkImpl;
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
public class TestGroupFactoryImplTester extends junit.framework.TestCase
{
	TestGroupFactory myTestGroupFactory;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");
		
		TestStepFactory testStepFactory = new TestStepFactoryImpl();
		TestCaseFactory testCaseFactory = new TestCaseFactoryImpl( testStepFactory );

		myTestGroupFactory = new TestGroupFactoryImpl( testCaseFactory );
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestGroupFactoryImpl#create(java.lang.String, java.lang.String, int, java.lang.String, java.util.ArrayList, org.testtoolinterfaces.testsuite.TestStepArrayList, org.testtoolinterfaces.testsuite.TestEntryArrayList, java.io.File, org.testtoolinterfaces.testsuite.TestStepArrayList)}.
	 */
	@Test
	public void testCreate()
	{
		ArrayList<String> reqs = new ArrayList<String>();
		reqs.add("req1");

		TestStepArrayList initSteps = new TestStepArrayList();
		initSteps.add( new TestStepImpl( TestStep.ActionType.initialize, 1, "Init 1", "cmdInit", new ParameterArrayList() ) );

		TestEntryArrayList execSteps = new TestEntryArrayList();
		execSteps.add( new TestStepImpl( TestStep.ActionType.action, 1, "Exec 1", "cmdAction", new ParameterArrayList() ) );

		TestStepArrayList restoreSteps = new TestStepArrayList();
		restoreSteps.add( new TestStepImpl( TestStep.ActionType.restore, 1, "Restore 1", "cmdRestore", new ParameterArrayList() ) );

		TestGroup testGroup1 = myTestGroupFactory.create( "tg1",
														  null,
														  1,
														  "description",
														  reqs,
														  initSteps,
														  execSteps,
														  new TestScriptImpl( "aScript", "stamdard", new ParameterArrayList() ),
														  restoreSteps );
		
		Assert.assertEquals("Incorrect Class", TestGroupLinkImpl.class, testGroup1.getClass());
		Assert.assertEquals("Incorrect ID", "tg1", testGroup1.getId());
		Assert.assertEquals("Incorrect Sequence Nr", 1, testGroup1.getSequenceNr());
		Assert.assertEquals("Incorrect Description", "", testGroup1.getDescription());
		Assert.assertEquals("Incorrect Requirements", reqs, testGroup1.getRequirements());
		Assert.assertEquals("Incorrect initSteps", initSteps, testGroup1.getInitializationSteps());
		Assert.assertEquals("Incorrect execSteps", new TestEntryArrayList(), testGroup1.getExecutionEntries());
		Assert.assertEquals("Incorrect File", "aScript", ((TestGroupLink) testGroup1).getTestGroupScript().getExecutionScript());
		Assert.assertEquals("Incorrect restoreSteps", restoreSteps, testGroup1.getRestoreSteps());

		TestGroup testGroup2 = myTestGroupFactory.create( "tg1",
														  null,
														  3,
														  "TG2 description",
														  reqs,
														  initSteps,
														  execSteps,
														  null,
														  restoreSteps );

		Assert.assertEquals("Incorrect Class", TestGroupImpl.class, testGroup2.getClass());
		Assert.assertEquals("Incorrect ID", "tg1", testGroup2.getId());
		Assert.assertEquals("Incorrect Sequence Nr", 3, testGroup2.getSequenceNr());
		Assert.assertEquals("Incorrect Description", "TG2 description", testGroup2.getDescription());
		Assert.assertEquals("Incorrect Requirements", reqs, testGroup2.getRequirements());
		Assert.assertEquals("Incorrect initSteps", initSteps, testGroup2.getInitializationSteps());
		Assert.assertEquals("Incorrect execSteps", execSteps, testGroup2.getExecutionEntries());
		Assert.assertEquals("Incorrect restoreSteps", restoreSteps, testGroup2.getRestoreSteps());
}
}
