package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;


public class TestGroupImpl extends TestEntryImpl implements TestGroup
{
    private ArrayList<String> myRequirementIds;

	private TestStepArrayList myInitializationSteps;
	private TestEntryArrayList myExecutionEntries;
    private TestStepArrayList myRestoreSteps;
    
	public TestGroupImpl(String aTestGroupId, 
			int aSequenceNr,
			String aDescription, 
			ArrayList<String> aRequirementIds, 
			TestStepArrayList anInitializationSteps, 
			TestEntryArrayList aTestEntries, 
			TestStepArrayList aRestoreSteps)
	{
		super(aTestGroupId, TestEntry.TYPE.Group, aDescription, aSequenceNr);
		Trace.println( Trace.LEVEL.CONSTRUCTOR,
					   "TestGroupImpl( " + aTestGroupId + ", "
									 + aDescription + ", "
									 + aSequenceNr + ", "
									 + aRequirementIds.hashCode() + ", "
									 + anInitializationSteps + ", "
									 + aTestEntries + ", "
									 + aRestoreSteps + " )",
						true );

		myRequirementIds = aRequirementIds;
		myInitializationSteps = anInitializationSteps;
		myExecutionEntries = aTestEntries;
		myRestoreSteps = aRestoreSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestGroup#getInitializationSteps()
	 */
	public TestStepArrayList getInitializationSteps()
	{
		return myInitializationSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestGroup#getExecutionEntries()
	 */
	public TestEntryArrayList getExecutionEntries()
	{
		return myExecutionEntries;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestGroup#getRestoreSteps()
	 */
	public TestStepArrayList getRestoreSteps()
	{
		return myRestoreSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestGroup#getRequirements()
	 */
	public ArrayList<String> getRequirements()
	{
		return myRequirementIds;
	}

	@Override
	public boolean hasGroupId(String aGroupId)
	{
		if (this.getId().equals(aGroupId))
		{
			return true;
		}

		for (int key = 0; key < myExecutionEntries.size(); key++)
    	{
			TestEntry entry = myExecutionEntries.get(key);
			if ( entry.getType() == TestEntry.TYPE.Group || entry.getType() == TestEntry.TYPE.GroupLink )
			{
				if ( ((TestGroup) entry).hasGroupId(aGroupId) )
				{
					return true;
				}
			}
    	}

		return false;
	}
}
