package org.testtoolinterfaces.testsuite;

public interface TestStepFactory
{
	/*
	 * Creates a Test Step
	 */
	public abstract TestStep create(
			TestStep.ActionType anActionType,
			String aType,
			int aSequence,
			String aDescription,
			String aCommand,
			ParameterArrayList aParameters );
}