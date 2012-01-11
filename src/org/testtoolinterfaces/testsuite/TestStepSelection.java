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
	private TestStep myThenStep;
	private TestStep myElseStep;

	/**
	 * Creates a TestStepSelection
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a list
	 * @param aDescription		Description
	 * @param anIfStep			The if-step, evaluated before the decision
	 * @param aThenStep			The then-step, executed when the if-step evaluates to PASS
	 * @param anElseStep		The else-step, executed when the if-step does not evaluate to PASS
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 String aDescription,
						 TestStep anIfStep,
						 TestStep aThenStep,
						 TestStep anElseStep,
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
					   					+ aThenStep.toString() + ", "
					   					+ ( anElseStep == null ? "<no else>" : anElseStep.toString() ) + " )",
				   	   true );

		myIfStep   = anIfStep;
		myThenStep = aThenStep;
		myElseStep = anElseStep;
	}

	/**
	 * Creates a TestStepSelection without unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aDescription	Description
	 * @param anIfStep		The if-step, evaluated before the decision
	 * @param aThenStep		The then-step, executed when the if-step evaluates to PASS
	 * @param anElseStep	The else-step, executed when the if-step does not evaluate to PASS
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 String aDescription,
						 TestStep anIfStep,
						 TestStep aThenStep,
						 TestStep anElseStep )
	{
		this( aSequenceNr,
		      aDescription,
		      anIfStep,
		      aThenStep,
		      anElseStep, 
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
	 * @param aThenStep		The then-step, executed when the if-step evaluates to PASS
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 String aDescription,
						 TestStep anIfStep,
						 TestStep aThenStep )
	{
		this( aSequenceNr,
		      aDescription,
		      anIfStep,
		      aThenStep,
		      null, 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Creates a TestStepSelection without description and unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param anIfStep		The if-step, evaluated before the decision
	 * @param aThenStep		The then-step, executed when the if-step evaluates to PASS
	 * @param anElseStep	The else-step, executed when the if-step does not evaluate to PASS
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 TestStep anIfStep,
						 TestStep aThenStep,
						 TestStep anElseStep )
	{
		this( aSequenceNr,
		      "",
		      anIfStep,
		      aThenStep,
		      anElseStep, 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Creates a TestStepSelection without else-step, description, and unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param anIfStep		The if-step, evaluated before the decision
	 * @param aThenStep		The then-step, executed when the if-step evaluates to PASS
	 */
	public TestStepSelection(
			 			 int aSequenceNr,
						 TestStep anIfStep,
						 TestStep aThenStep )
	{
		this( aSequenceNr,
		      "",
		      anIfStep,
		      aThenStep,
		      null, 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * @return the ifStep
	 */
	public TestStep getIfStep()
	{
		return myIfStep;
	}

	/**
	 * @return the thenStep
	 */
	public TestStep getThenStep()
	{
		return myThenStep;
	}

	/**
	 * @return the elseStep
	 */
	public TestStep getElseStep()
	{
		return myElseStep;
	}

	@Override
	public String toString()
	{
		return "if (" + myIfStep.toString() + ") then {" + myThenStep.toString()
					  + (myElseStep != null ? "} else {" + myElseStep.toString() : "") + "}";
	}

	@Override
	public String getDisplayName()
	{
		return "if - then" + (myElseStep != null ? " - else" : "");
	}
}
