/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for Test Steps that consist of an (execution) script 
 * TestStepScripts all have a sequenceNr, a Script, and a ScriptType.
 * And they may have a description or list of Parameter.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepScript extends TestStep
{
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
			 			   ParameterArrayList aParameters,
			 			   Hashtable<String, String> anAnyAttributes,
			 			   Hashtable<String, String> anAnyElements )
	{
		super( aSequenceNr,
		       aDescription,
		       aParameters,
		       anAnyAttributes,
		       anAnyElements );
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
		
		this.setDisplayName(aScript);
	}

	/**
	 * Creates a TestStepScript without unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aDescription	Description
	 * @param aScript		Test Step Script
	 * @param aScriptType	Type of the Script
	 * @param aParameters	List of parameters
	 */
	public TestStepScript( 
			 			   int aSequenceNr,
			 			   String aDescription,
			 			   String aScript,
			 			   String aScriptType,
			 			   ParameterArrayList aParameters )
	{
		this( aSequenceNr,
		      aDescription,
		      aScript,
		      aScriptType,
		      aParameters, 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
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
		      new ParameterArrayList(), 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
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
		      aParameters, 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
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
		      new ParameterArrayList(), 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
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
