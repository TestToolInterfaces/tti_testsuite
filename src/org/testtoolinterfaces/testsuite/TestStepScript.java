/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class TestStepScript extends TestStepSimple
{
	private String myScript;
	private String myScriptType;

	/**
	 * @param anActionType one of action, check
	 * @param aSequenceNr
	 * @param aDescription
	 * @param aScript
	 * @param aParameters
	 */
	public TestStepScript( StepType anActionType,
			 			 int aSequenceNr,
						 String aDescription,
						 String aScript,
						 String aScriptType,
						 ParameterArrayList aParameters )
	{
		super(anActionType, aSequenceNr, aDescription, aParameters);
		Trace.println( Trace.LEVEL.CONSTRUCTOR,
					   "TestStepImpl( " + anActionType + ", "
	   									+ aSequenceNr + ", "
	   									+ aDescription + ", "
					   					+ aScript + ", "
					   					+ aScriptType + ", "
					   					+ "aParameters )",
				   	   true );

		myScript = aScript;
		myScriptType = aScriptType;
	}

	public String getScript()
	{
		return myScript;
	}

	public String getScriptType()
	{
		return myScriptType;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestStepSimple#getDisplayName()
	 */
	public String getDisplayName()
	{
		return myScript;
	}
}
