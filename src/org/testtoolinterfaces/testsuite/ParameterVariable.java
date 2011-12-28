package org.testtoolinterfaces.testsuite;

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
	 * @param aParameter    Parameter name
	 * @param aVariableName variable name
	 */
	public ParameterVariable(String aParameter, String aVariableName)
	{
		super(aParameter);
		myVariableName = aVariableName;
	}

	/**
	 * Creates a parameter
	 * 
	 * @param aParameter    Parameter name
	 * @param aVariableName variable name
	 * @param anIndex       Index
	 *
	 * The index can be used in a ParameterArrayList to specify an order.
	 */
	public ParameterVariable(String aParameter, String aVariableName, int anIndex)
	{
		super(aParameter, anIndex);
		myVariableName = aVariableName;
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
