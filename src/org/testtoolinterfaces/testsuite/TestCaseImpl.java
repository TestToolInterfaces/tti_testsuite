/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class TestCaseImpl extends TestEntryImpl implements TestCase
{
    private ArrayList<String> myRequirementIds;

    private TestStepArrayList myInitializationSteps;
    private TestStepArrayList myExecutionSteps;
    private TestStepArrayList myRestoreSteps;

	public TestCaseImpl(
			String aTestCaseId,
			int aSequenceNr,
			String aDescription,
			ArrayList<String> aRequirementIds,
			TestStepArrayList anInitializationSteps,
			TestStepArrayList anExecutionSteps,
			TestStepArrayList aRestoreSteps)
	{
		super(aTestCaseId, TestEntry.TYPE.Case, aDescription, aSequenceNr);
		Trace.println( Trace.LEVEL.CONSTRUCTOR,
					   "TestCaseImpl( " + aTestCaseId + ", "
									+ aDescription + ", "
									+ aSequenceNr + ", "
									+ aRequirementIds.hashCode() + ", "
									+ anInitializationSteps + ", "
									+ anExecutionSteps + ", "
									+ aRestoreSteps + " )",
						true );

		myRequirementIds = aRequirementIds;

		myInitializationSteps = anInitializationSteps;
		myExecutionSteps = anExecutionSteps;
		myRestoreSteps = aRestoreSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestCase#getInitializationSteps()
	 */
	public TestStepArrayList getInitializationSteps()
	{
		return myInitializationSteps;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestCase#getExecutionSteps()
	 */
	public TestStepArrayList getExecutionSteps()
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
	public TestStepArrayList getRestoreSteps()
	{
		return myRestoreSteps;
	}
}
