/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for Test Steps that consist of a Decision and Consequences (aka if-then-else).
 * TestStepSelections all have a sequenceNr, an if-step, and a then-step.
 * And they may have an else-step, and a description.
 * 
 * If the if-step evaluates to PASS, the then-step is executed.
 * In all other cases, the else-step is executed (if specified).
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepSelection extends TestStep
{
	private TestStep myIfStep;
	private TestStepSequence myThenSteps;
	private TestStepSequence myElseSteps;

	/**
	 * Creates a TestStepSelection
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a list
	 * @param aDescription		Description
	 * @param anIfStep			The if-step, evaluated before the decision
	 * @param aThenSteps		The sequence of then-steps, executed when the if-step evaluates to PASS
	 * @param anElseSteps		The sequence of else-steps, executed when the if-step does not evaluate to PASS
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 String aDescription,
						 TestStep anIfStep,
						 TestStepSequence aThenSteps,
						 TestStepSequence anElseSteps,
	                     Hashtable<String, String> anAnyAttributes,
	                     Hashtable<String, String> anAnyElements )
	{
		super( aSequenceNr,
		       aDescription,
		       new ParameterArrayList(),
		       anAnyAttributes,
		       anAnyElements );
		Trace.println( Trace.CONSTRUCTOR,
					   "TestStepImpl( "
	   									+ aSequenceNr + ", "
	   									+ aDescription + ", "
					   					+ anIfStep.toString() + ", "
					   					+ aThenSteps.toString() + ", "
					   					+ ( anElseSteps.isEmpty() ? "<no else>" : anElseSteps.toString() ) + " )",
				   	   true );

		myIfStep    = anIfStep;
		myThenSteps = aThenSteps;
		myElseSteps = anElseSteps;
		
		this.setDisplayName("if - then" + (myElseSteps.isEmpty() ? "" : " - else"));
	}

	/**
	 * Creates a TestStepSelection without unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aDescription	Description
	 * @param anIfStep		The if-step, evaluated before the decision
	 * @param aThenSteps	The sequence of then-steps, executed when the if-step evaluates to PASS
	 * @param anElseSteps	The sequence of else-steps, executed when the if-step does not evaluate to PASS
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 String aDescription,
						 TestStep anIfStep,
						 TestStepSequence aThenSteps,
						 TestStepSequence anElseSteps )
	{
		this( aSequenceNr,
		      aDescription,
		      anIfStep,
		      aThenSteps,
		      anElseSteps, 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Creates a TestStepSelection without an else-step and unknown attributes and elements.
	 * If the if-steps does not evaluate to PASS, nothing else is done in this step.
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aDescription	Description
	 * @param anIfStep		The if-step, evaluated before the decision
	 * @param aThenSteps	The sequence of then-steps, executed when the if-step evaluates to PASS
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 String aDescription,
						 TestStep anIfStep,
						 TestStepSequence aThenSteps )
	{
		this( aSequenceNr,
		      aDescription,
		      anIfStep,
		      aThenSteps,
		      new TestStepSequence(), 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Creates a TestStepSelection without description and unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param anIfStep		The if-step, evaluated before the decision
	 * @param aThenSteps	The sequence of then-steps, executed when the if-step evaluates to PASS
	 * @param anElseSteps	The sequence of else-steps, executed when the if-step does not evaluate to PASS
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 TestStep anIfStep,
						 TestStepSequence aThenSteps,
						 TestStepSequence anElseSteps )
	{
		this( aSequenceNr,
		      "",
		      anIfStep,
		      aThenSteps,
		      anElseSteps, 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Creates a TestStepSelection without else-step, description, and unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param anIfStep		The if-step, evaluated before the decision
	 * @param aThenSteps	The sequence of then-steps, executed when the if-step evaluates to PASS
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 TestStep anIfStep,
						 TestStepSequence aThenSteps )
	{
		this( aSequenceNr,
		      "",
		      anIfStep,
		      aThenSteps,
		      new TestStepSequence(), 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * @return the if-step
	 */
	public TestStep getIfStep()
	{
		return myIfStep;
	}

	/**
	 * @return the sequence of then-steps
	 */
	public TestStepSequence getThenSteps()
	{
		return myThenSteps;
	}

	/**
	 * @return the sequence of else-steps
	 */
	public TestStepSequence getElseSteps()
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
