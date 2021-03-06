package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class to hold a variable name as parameter.
 * The parameter value is in effect a name to a variable.
 * 
 * Note that the value of the variable is not stored. It should be stored separately in a variable dictionary.
 * 
 * @author Arjan Kranenburg
 *
 */
public class ParameterVariable extends Parameter
{
	String myVariableName;
	
	/**
	 * Creates a parameter variable
	 * 
	 * @param aParameter    	Parameter name
	 * @param aVariableName 	Variable name
	 * @param anIndex       	Index
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 *
	 * The index can be used in a ParameterArrayList to specify an order.
	 */
	public ParameterVariable( String aParameter,
	                          String aVariableName,
	                          int anIndex,
		                      Hashtable<String, String> anAnyAttributes,
		                      Hashtable<String, String> anAnyElements )
	{
		super( aParameter,
		       anIndex,
		       anAnyAttributes,
		       anAnyElements);

		Trace.println(Trace.CONSTRUCTOR, "ParameterVariable( " + aParameter + ", " 
					   + aVariableName + ", "
					   + anIndex + " )", true);

		myVariableName = aVariableName;
	}

	/**
	 * Creates a parameter variable
	 * 
	 * @param aParameter    	Parameter name
	 * @param aVariableName 	Variable name
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public ParameterVariable( String aParameter,
	                          String aVariableName,
		                      Hashtable<String, String> anAnyAttributes,
		                      Hashtable<String, String> anAnyElements )
	{
		this( aParameter,
		      aVariableName,
		      Parameter.DEFAULT_INDEX,
		      anAnyAttributes,
		      anAnyElements );
	}

	/**
	 * Creates a parameter variable
	 * 
	 * @param aParameter    Parameter name
	 * @param aVariableName Variable name
	 * @param anIndex       Index
	 *
	 * The index can be used in a ParameterArrayList to specify an order.
	 */
	public ParameterVariable( String aParameter,
	                          String aVariableName,
	                          int anIndex)
	{
		this( aParameter,
		      aVariableName,
		      anIndex,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Creates a parameter variable
	 * 
	 * @param aParameter    Parameter name
	 * @param aVariableName Variable name
	 */
	public ParameterVariable( String aParameter,
	                          String aVariableName )
	{
		this( aParameter,
		      aVariableName,
		      Parameter.DEFAULT_INDEX,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * @return the variable name
	 */
	public String getVariableName()
	{
		Trace.println(Trace.GETTER);
		return myVariableName;
	}

	/**
	 * Sets (changes) the variable name
	 * @param aVariableName the new variable name
	 */
	public void setVariableName(String aVariableName)
	{
		Trace.println(Trace.SETTER, "setVariableName( " + aVariableName + " )", true);
		myVariableName = aVariableName;
	}
}
