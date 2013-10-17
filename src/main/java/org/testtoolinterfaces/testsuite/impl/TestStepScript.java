/**
 * 
 */
package org.testtoolinterfaces.testsuite.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.utils.Mark;

/**
 * Class for Test Steps that consist of an (execution) script 
 * TestStepScripts all have a sequenceNr, a Script, and a ScriptType.
 * And they may have a description or list of Parameter.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepScript extends TestStepImpl
{
    private static final Logger LOG = LoggerFactory.getLogger(TestStepScript.class);

    private String myScript;
	private String myScriptType;

	/**
	 * Creates a TestStepScript
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a list
	 * @param aDescription		Description
	 * @param aScript			Test Step Script
	 * @param aScriptType		Type of the Script
	 * @param aParameters		List of parameters
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestStepScript( 
			 			   int aSequenceNr,
			 			   String aDescription,
			 			   String aScript,
			 			   String aScriptType,
			 			   ParameterArrayList aParameters )
	{
		super( aSequenceNr, aDescription, aParameters );
		LOG.trace(Mark.CONSTRUCTOR, "{}, {}, {}, {}, {}",
				aSequenceNr, aDescription,
				aScript, aScriptType, aParameters);

		myScript = aScript;
		myScriptType = aScriptType;
		
		this.setDisplayName(aScript);
	}

	/**
	 * Creates a TestStepScript without parameter and unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aDescription	Description
	 * @param aScript		Test Step Script
	 * @param aScriptType	Type of the Script
	 */
	public TestStepScript( 
			 			   int aSequenceNr,
			 			   String aDescription,
			 			   String aScript,
			 			   String aScriptType )
	{
		this( aSequenceNr,
		      aDescription,
		      aScript,
		      aScriptType,
		      new ParameterArrayList() );
	}

	/**
	 * Creates a TestStepScript without description and unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aScript		Test Step Script
	 * @param aScriptType	Type of the Script
	 * @param aParameters	List of parameters
	 */
	public TestStepScript( 
			 			   int aSequenceNr,
			 			   String aScript,
			 			   String aScriptType,
			 			   ParameterArrayList aParameters )
	{
		this( aSequenceNr,
		      "",
		      aScript,
		      aScriptType,
		      aParameters );
	}

	/**
	 * Creates a TestStepScript without description, parameters, and unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aScript		Test Step Script
	 * @param aScriptType	Type of the Script
	 */
	public TestStepScript( 
			 			   int aSequenceNr,
			 			   String aScript,
			 			   String aScriptType )
	{
		this( aSequenceNr,
		      "",
		      aScript,
		      aScriptType,
		      new ParameterArrayList() );
	}

	/**
	 * @return the script
	 */
	public String getScript()
	{
		return myScript;
	}

	/**
	 * @return the type of script
	 */
	public String getScriptType()
	{
		return myScriptType;
	}
}
