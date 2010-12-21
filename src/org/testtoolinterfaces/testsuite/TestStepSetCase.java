package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

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
		Trace.println(Trace.LEVEL.GETTER);
		return myId;
	}

	public String getAfterSetCase()
	{
		Trace.println(Trace.LEVEL.GETTER);
		return myAfter;
	}

	/**
	 * @return
	 */
	public TestStep getCheck()
	{
		Trace.println(Trace.LEVEL.GETTER);
		return myCheck;
	}

	/**
	 * @return
	 */
	public TestStepArrayList getThen()
	{
		Trace.println(Trace.LEVEL.GETTER);
		return myThen;
	}
}
