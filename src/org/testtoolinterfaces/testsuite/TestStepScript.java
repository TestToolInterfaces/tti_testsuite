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
public class TestStepScript extends TestStep
{
	private String myScript;
	private String myScriptType;

	/**
	 * @param aSequenceNr
	 * @param aDescription
	 * @param aScript
	 * @param aScriptType
	 * @param aParameters
	 */
	public TestStepScript( 
			 			   int aSequenceNr,
			 			   String aDescription,
			 			   String aScript,
			 			   String aScriptType,
			 			   ParameterArrayList aParameters )
	{
		super(aSequenceNr, aParameters);
		this.setDescription(aDescription);
		Trace.println( Trace.CONSTRUCTOR,
					   "TestStepScript( "
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

	/**
	 * 
	 */
	public String getDisplayName()
	{
		return myScript;
	}
}
