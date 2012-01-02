/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class TestCaseImpl extends TestEntryImpl implements TestCase
{
    private ArrayList<String> myRequirementIds;

    private TestStepOrdered myPrepareSteps;
    private TestStepOrdered myExecutionSteps;
    private TestStepOrdered myRestoreSteps;

	public TestCaseImpl(
			String aTestCaseId,
            Hashtable<String, String> anAnyAttributes,
			String aDescription,
			ArrayList<String> aRequirementIds,
			TestStepOrdered aPrepareSteps,
			TestStepOrdered anExecutionSteps,
			TestStepOrdered aRestoreSteps,
			Hashtable<String, String> anAnyElements )
	{
		super(aTestCaseId, TestEntry.TYPE.Case, aDescription, 0);
		Trace.println( Trace.CONSTRUCTOR,
					   "TestCaseImpl( " + aTestCaseId + ", "
									+ aDescription + ", "
									+ aRequirementIds.hashCode() + ", "
									+ aPrepareSteps + ", "
									+ anExecutionSteps + ", "
									+ aRestoreSteps + " )",
						true );

		myRequirementIds = aRequirementIds;

		myPrepareSteps = aPrepareSteps;
		myExecutionSteps = anExecutionSteps;
		myRestoreSteps = aRestoreSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestCase#getInitializationSteps()
	 */
	public TestStepOrdered getPrepareSteps()
	{
		return myPrepareSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestCase#getExecutionSteps()
	 */
	public TestStepOrdered getExecutionSteps()
	{
		return myExecutionSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestCase#getRequirements()
	 */
	public ArrayList<String> getRequirements()
	{
		return myRequirementIds;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestCase#getRestoreSteps()
	 */
	public TestStepOrdered getRestoreSteps()
	{
		return myRestoreSteps;
	}
}
