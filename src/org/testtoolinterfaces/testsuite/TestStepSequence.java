package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;

public class TestStepSequence
{
	ArrayList<TestStep> mySteps;
	
	public TestStepSequence(ArrayList<TestStep> aSteps)
	{
		mySteps = aSteps;
	}

	public ArrayList<TestStep> getSteps()
	{
		Trace.println(Trace.LEVEL.GETTER);
		return mySteps;
	}
}
