package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;

/**
 * Abstract Class to hold a TestExecutionItem.
 * TestExecutionItems all have an Id, a Type, a sequenceNr and may have a description.
 * 
 * They may also store any other attributes and elements
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestExecItemImpl extends TestGroupEntryImpl implements TestExecItem
{
    private ArrayList<String> myRequirementIds;

	private TestStepSequence myInitializationSteps;
    private TestStepSequence myRestoreSteps;

    /**
     * Creates a TestExecutionItem
     * 
	 * @param anId			Identifier
	 * @param aDescription	Description
	 * @param aSequenceNr	Sequence number, to be used in a collection
	 * @param aRequirementIds	List of RequirementIds
	 * @param aPrepareSteps		Sequence of Test Steps for preparation
	 * @param aRestoreSteps		Sequence of Test Steps for restoration
	 */
	public TestExecItemImpl( String anId,
	                      String aDescription,
	                      int aSequenceNr,
	                      ArrayList<String> aRequirementIds,
	                      TestStepSequence aPrepareSteps,
	                      TestStepSequence aRestoreSteps )
	{
		super(anId, aDescription, aSequenceNr);
		Trace.println( Trace.CONSTRUCTOR,
					   "TestEntryImpl(" + anId + ", "
					   					+ aDescription + ", "
					   					+ aSequenceNr + ", "
					   					 + aRequirementIds.hashCode() + ", "
					   					 + aPrepareSteps + ", "
					   					 + aRestoreSteps + " )",
					   true );
		
		myRequirementIds = aRequirementIds;

		myInitializationSteps = aPrepareSteps;
		myRestoreSteps = aRestoreSteps;
	}

	public ArrayList<String> getRequirements() {
		return myRequirementIds;
	}

	public TestStepSequence getPrepareSteps() {
		return myInitializationSteps;
	}

	public TestStepSequence getRestoreSteps() {
		return myRestoreSteps;
	}
}
