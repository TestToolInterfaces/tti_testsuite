package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;


public class TestGroupLinkImpl extends TestEntryImpl implements TestGroupLink
{
    private ArrayList<String> myRequirementIds;

	private TestStepArrayList myInitializationSteps;
	private TestScript myTestGroupScript;
    private TestStepArrayList myRestoreSteps;

	/**
	 * @param aTestGroupId
	 * @param aSequenceNr
	 * @param aRequirementIds
	 * @param anInitializationSteps
	 * @param aTestGroupScript
	 * @param aRestoreSteps
	 */
	public TestGroupLinkImpl( String aTestGroupId,
							  int aSequenceNr,
							  ArrayList<String> aRequirementIds, 
							  TestStepArrayList anInitializationSteps, 
							  TestScript aTestGroupScript,
							  TestStepArrayList aRestoreSteps )
	{
		super(aTestGroupId, TestEntry.TYPE.GroupLink, "", aSequenceNr);

		Trace.println( Trace.LEVEL.CONSTRUCTOR,
					   "TestGroupLinkImpl( " + aTestGroupId + ", " 
						   				 + aSequenceNr + ", "
										 + aRequirementIds.hashCode() + ", "
										 + anInitializationSteps + ", "
										 + aTestGroupScript + ", "
										 + aRestoreSteps + " )",
					   true );

		myRequirementIds = aRequirementIds;
		myInitializationSteps = anInitializationSteps;
		myTestGroupScript = aTestGroupScript;
		myRestoreSteps = aRestoreSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestGroupLink#getInitializationSteps()
	 */
	public TestStepArrayList getInitializationSteps()
	{
		return myInitializationSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestGroupLink#getRequirementIds()
	 */
	public ArrayList<String> getRequirements()
	{
		return myRequirementIds;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestGroupLink#getRestoreSteps()
	 */
	public TestStepArrayList getRestoreSteps()
	{
		return myRestoreSteps;
	}
	
	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestGroupLink#getTestGroupScript()
	 */
	public TestScript getTestGroupScript()
	{
		return myTestGroupScript;
	}

	public TestEntryArrayList getExecutionEntries()
	{
		return new TestEntryArrayList();
	}
	
	@Override
	public boolean hasGroupId(String aGroupId)
	{
		return true;
	}
}
