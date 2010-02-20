package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;


public class TestCaseLinkImpl extends TestEntryImpl implements TestCaseLink
{
	private String myType;
    private ArrayList<String> myRequirementIds;

	private TestStepArrayList myInitializationSteps;
	private TestScript myTestCaseScript;
    private TestStepArrayList myRestoreSteps;

	/**
	 * @param aTestCaseId
	 * @param aType 
	 * @param aSequenceNr
	 * @param aRequirementIds
	 * @param anInitializationSteps
	 * @param aTestCaseScript
	 * @param aRestoreSteps
	 */
	public TestCaseLinkImpl( String aTestCaseId,
						  String aType,
						  int aSequenceNr,
						  ArrayList<String> aRequirementIds, 
						  TestStepArrayList anInitializationSteps, 
						  TestScript aTestCaseScript,
						  TestStepArrayList aRestoreSteps )
	{
		super(aTestCaseId, TestEntry.TYPE.CaseLink, "", aSequenceNr);

		Trace.println( Trace.CONSTRUCTOR,
					   "TestCaseLinkImpl( " + aTestCaseId + ", " 
					   						+ aType + ", "
					   						+ aSequenceNr + ", "
					   						+ aRequirementIds.hashCode() + ", "
					   						+ anInitializationSteps + ", "
					   						+ aTestCaseScript + ", "
					   						+ aRestoreSteps + " )",
					   true );

		myType = aType;
		myRequirementIds = aRequirementIds;
		myInitializationSteps = anInitializationSteps;
		myTestCaseScript = aTestCaseScript;
		myRestoreSteps = aRestoreSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestCaseLink#getInitializationSteps()
	 */
	public TestStepArrayList getInitializationSteps()
	{
		return myInitializationSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestCaseLink#getRequirementIds()
	 */
	public ArrayList<String> getRequirements()
	{
		return myRequirementIds;
	}
	
	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.testsuite.TestCaseLink#getTestCaseScript()
	 */
	public TestScript getTestCaseScript()
	{
		return myTestCaseScript;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestCaseLink#getRestoreSteps()
	 */
	public TestStepArrayList getRestoreSteps()
	{
		return myRestoreSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.testsuite.TestCase#getExecutionSteps()
	 */
	public TestStepArrayList getExecutionSteps()
	{
		return new TestStepArrayList();
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.testsuite.TestCaseLink#getScriptType()
	 */
	public String getScriptType()
	{
		return myType;
	}
}
