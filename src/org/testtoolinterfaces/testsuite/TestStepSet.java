package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for a set of Test Step Set Cases.
 * A Test Step Set consists of a few cases.
 * If the check of a case passes, that step is further used.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepSet extends TestStep
{
	ArrayList<TestStepSetCase> myCases;
	
	/**
	 * @param aSequenceNr
	 * @param aSetCases
	 */
	public TestStepSet(int aSequenceNr, ArrayList<TestStepSetCase> aSetCases)
	{
		super( TestStep.StepType.set, aSequenceNr);
		myCases = aSetCases;
	}

	/**
	 * @return the TestStepSetCases
	 */
	public ArrayList<TestStepSetCase> getSetCase()
	{
		Trace.println(Trace.GETTER);
		return myCases;
	}
}
