/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for script command
 * 
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
	 * @param aScriptType
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
		Trace.println( Trace.CONSTRUCTOR,
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

	/**
	 * @return the Command script
	 */
	public String getScript()
	{
		return myScript;
	}

	/**
	 * @return the type of command script
	 */
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
