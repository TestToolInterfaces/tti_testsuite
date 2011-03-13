package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;

public class TestStepSet extends TestStep
{
	ArrayList<TestStepSetCase> myCases;
	
	public TestStepSet(int aSequence, ArrayList<TestStepSetCase> aCases)
	{
		super( TestStep.StepType.set, aSequence);
		myCases = aCases;
	}

	public ArrayList<TestStepSetCase> getSetCase()
	{
		Trace.println(Trace.LEVEL.GETTER);
		return myCases;
	}
}
