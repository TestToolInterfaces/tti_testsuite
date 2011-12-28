package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for a case in a Test Step Set.
 * If the check of this case passes, this step is further used.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepSetCase
{
	String myId;
	String myAfter;
	TestStep myCheck;
	TestStepArrayList myThen;
	
	public TestStepSetCase(String aSetCaseId, String anAfterSetCase, TestStep aCheck, TestStepArrayList aThen)
	{
		myId = aSetCaseId;
		myAfter = anAfterSetCase;
		myCheck = aCheck;
		myThen = aThen;
	}

	public String getId()
	{
		Trace.println(Trace.GETTER);
		return myId;
	}

	public String getAfterSetCase()
	{
		Trace.println(Trace.GETTER);
		return myAfter;
	}

	/**
	 * @return
	 */
	public TestStep getCheck()
	{
		Trace.println(Trace.GETTER);
		return myCheck;
	}

	/**
	 * @return
	 */
	public TestStepArrayList getThen()
	{
		Trace.println(Trace.GETTER);
		return myThen;
	}
}
