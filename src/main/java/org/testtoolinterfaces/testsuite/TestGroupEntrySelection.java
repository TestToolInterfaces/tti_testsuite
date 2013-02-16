/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for Test Group Entries that consist of a Decision and Consequences (aka if-then-else).
 * TestGroupEntrySelection all have a sequenceNr, an if-step, and a then-sequence.
 * And they may have an else-sequence, and a description.
 * 
 * If the if-step evaluates to PASS, the then-sequence is executed.
 * In all other cases, the else-sequence is executed (if specified).
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupEntrySelection extends TestGroupEntryImpl
{
	private TestStep myIfStep;
	private boolean myNegator;
	private TestGroupEntrySequence myThenSteps;
	private TestGroupEntrySequence myElseSteps;

	/**
	 * Creates a TestGroupEntrySelection
	 * 
	 * @param anId				Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence number, to be used in a list
	 * @param anIfStep			The if-step, evaluated before the decision
	 * @param aNegator			If true, it negates the if-evaluation
	 * @param aThenSteps		The then-sequence, executed when the if-step evaluates to PASS
	 * @param anElseSteps		The else-sequence, executed when the if-step does not evaluate to PASS
	 */
	public TestGroupEntrySelection( String anId,
						 String aDescription,
			 			 int aSequenceNr,
						 TestStep anIfStep,
						 boolean aNegator,
						 TestGroupEntrySequence aThenSteps,
						 TestGroupEntrySequence anElseSteps )
	{
		super( anId, aDescription, aSequenceNr );
		Trace.println( Trace.CONSTRUCTOR, "TestStepImpl( " + anId + ", "
				+ aSequenceNr + ", " + aDescription + ", " + anIfStep.toString() + ", "
				+ aNegator + ", " + aThenSteps.toString() + ", "
				+ ( anElseSteps.isEmpty() ? "<no else>" : anElseSteps.toString() ) + " )",
			true );

		myIfStep    = anIfStep;
		myNegator	= aNegator;
		myThenSteps = aThenSteps;
		myElseSteps = anElseSteps;
	}

	/**
	 * @return the if-step
	 */
	public TestStep getIfStep()
	{
		return myIfStep;
	}

	/**
	 * @return the negator flag
	 */
	public boolean getNegator()
	{
		return myNegator;
	}

	/**
	 * @return the sequence of then-steps
	 */
	public TestGroupEntrySequence getThenSteps()
	{
		return myThenSteps;
	}

	/**
	 * @return the sequence of else-steps
	 */
	public TestGroupEntrySequence getElseSteps()
	{
		return myElseSteps;
	}

	@Override
	public String toString()
	{
		return "if (" + myIfStep.toString() + ") then {" + myThenSteps.toString()
					  + (myElseSteps.isEmpty() ? "" : "} else {" + myElseSteps.toString()) + "}";
	}
}
