package org.testtoolinterfaces.testsuite;

public abstract class TestStep
{
	public enum StepType { action, check, set };

	private StepType myActionType;
	private int mySequenceNr;

	public TestStep(StepType aStepType, int aSequenceNr)
	{
		myActionType = aStepType;
		mySequenceNr = aSequenceNr;
	}

	/**
	 * @return the Action Type
	 */
	public StepType getStepType()
	{
		return myActionType;
	}
	
	public int getSequenceNr()
	{
		return mySequenceNr;
	}
}
