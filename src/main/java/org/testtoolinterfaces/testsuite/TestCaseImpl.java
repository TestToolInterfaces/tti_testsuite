/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for Default (i.e. TTI) Test Cases.
 * TestCaseImpls all have an Id, a sequenceNr and may have a description and a list of Requirements.
 * And they all have collections of prepare, execution, and restore steps.
 * (These collections may be empty as well.)
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestCaseImpl extends TestExecItemImpl implements TestCase
{
    private TestStepSequence myExecutionSteps;

	/**
	 * Constructor
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param anExecutionSteps	Collection of execution steps
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestCaseImpl(
			String aTestCaseId,
			String aDescription,
			int aSequenceNr,
			ArrayList<String> aRequirementIds,
			TestStepSequence aPrepareSteps,
			TestStepSequence anExecutionSteps,
			TestStepSequence aRestoreSteps ) {

		super( aTestCaseId, aDescription, aSequenceNr,
				aRequirementIds, aPrepareSteps, aRestoreSteps );
		Trace.println( Trace.CONSTRUCTOR,
					   "TestCaseImpl( " + aTestCaseId + ", "
										+ aDescription + ", "
										+ aSequenceNr + ", "
										+ aRequirementIds.hashCode() + ", "
										+ aPrepareSteps + ", "
										+ anExecutionSteps + ", "
										+ aRestoreSteps + " )",
						true );

		myExecutionSteps = anExecutionSteps;
	}

	/**
	 * Constructor without description and unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param anExecutionSteps	Collection of execution steps
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestCaseImpl(
			String aTestCaseId,
			int aSequenceNr,
			ArrayList<String> aRequirementIds,
			TestStepSequence aPrepareSteps,
			TestStepSequence anExecutionSteps,
			TestStepSequence aRestoreSteps )
	{
		this( aTestCaseId,
		      "",
		      aSequenceNr,
		      aRequirementIds,
		      aPrepareSteps,
		      anExecutionSteps,
		      aRestoreSteps );
	}

	/**
	 * Constructor without requirements and unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param anExecutionSteps	Collection of execution steps
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestCaseImpl(
			String aTestCaseId,
			String aDescription,
			int aSequenceNr,
			TestStepSequence aPrepareSteps,
			TestStepSequence anExecutionSteps,
			TestStepSequence aRestoreSteps )
	{
		this( aTestCaseId,
		      aDescription,
		      aSequenceNr,
		      new ArrayList<String>(),
		      aPrepareSteps,
		      anExecutionSteps,
		      aRestoreSteps );
	}

	/**
	 * Constructor without description, requirements, and unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param anExecutionSteps	Collection of execution steps
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestCaseImpl(
			String aTestCaseId,
			int aSequenceNr,
			TestStepSequence aPrepareSteps,
			TestStepSequence anExecutionSteps,
			TestStepSequence aRestoreSteps )
	{
		this( aTestCaseId,
		      "",
		      aSequenceNr,
		      new ArrayList<String>(),
		      aPrepareSteps,
		      anExecutionSteps,
		      aRestoreSteps);
	}

	public TestStepSequence getExecutionSteps()
	{
		return myExecutionSteps;
	}
}
