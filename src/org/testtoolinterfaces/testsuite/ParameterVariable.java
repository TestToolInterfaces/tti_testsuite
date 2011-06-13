package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class ParameterVariable extends Parameter
{
	/**
	 * @param aParameter
	 * @param aVariableName
	 */
	public ParameterVariable(String aParameter, String aVariableName)
	{
		super(aParameter, aVariableName);
	}

	/**
	 * @return the variable name
	 */
	public String getVariableName()
	{
		Trace.println(Trace.GETTER);
		return (String) super.getValue();
	}

	/**
	 * @deprecated use getVariableName
	 * @return the variable name, but as an Object
	 */
	public Object getValue()
	{
		Trace.println(Trace.GETTER);
		return super.getValue();
	}

	/**
	 * @deprecated use getVariableName
	 * @return the variable name
	 */
	public String getValueAsString()
	{
		Trace.println(Trace.GETTER);
		return super.getValueAsString();
	}

	/**
	 * @param aVariableName
	 */
	public void setVariableName(String aVariableName)
	{
		Trace.println(Trace.SETTER, "setVariableName( " + aVariableName + " )", true);
		super.setValue(aVariableName);
	}

	/**
	 * @deprecated
	 */
	public void setValue(String aVariableName)
	{
		Trace.println(Trace.SETTER, "setValue( " + aVariableName + " )", true);
		super.setValue(aVariableName);
	}
}
