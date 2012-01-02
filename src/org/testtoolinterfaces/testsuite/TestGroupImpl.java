package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;


public class TestGroupImpl extends TestEntryImpl implements TestGroup
{
    private ArrayList<String> myRequirementIds;

	private TestStepOrdered myInitializationSteps;
	private TestEntryArrayList myExecutionEntries;
    private TestStepOrdered myRestoreSteps;
    
    private Hashtable<String, String> myAnyAttributes;
    private Hashtable<String, String> myAnyElements;
    
	public TestGroupImpl( String aTestGroupId,
	                      Hashtable<String, String> anAnyAttributes,
	                      String aDescription,
	                      ArrayList<String> aRequirementIds,
	                      TestStepOrdered aPrepareSteps,
	                      TestEntryArrayList aTestEntries,
	                      TestStepOrdered aRestoreSteps,
	                      Hashtable<String, String> anAnyElements )
	{
		super(aTestGroupId, TestEntry.TYPE.Group, aDescription, 0);
		Trace.println( Trace.CONSTRUCTOR,
					   "TestGroupImpl( " + aTestGroupId + ", "
									 + aDescription + ", "
									 + aRequirementIds.hashCode() + ", "
									 + aPrepareSteps + ", "
									 + aTestEntries + ", "
									 + aRestoreSteps + " )",
						true );

		myRequirementIds = aRequirementIds;
		myInitializationSteps = aPrepareSteps;
		myExecutionEntries = aTestEntries;
		myRestoreSteps = aRestoreSteps;
		
		myAnyAttributes = anAnyAttributes;
		myAnyElements = anAnyElements;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestGroup#getInitializationSteps()
	 */
	public TestStepOrdered getPrepareSteps()
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
	public TestStepOrdered getRestoreSteps()
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
