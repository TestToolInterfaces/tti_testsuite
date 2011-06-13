package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class ParameterHash extends Parameter
{
	/**
	 * @param aParameter
	 * @param aParamList
	 */
	public ParameterHash(String aParameter, ParameterArrayList aParamList)
	{
		super(aParameter, aParamList);
	}

	public Class<? extends Object> getValueType()
	{
		Trace.println(Trace.GETTER);
	    return ParameterArrayList.class;
	}

	/**
	 * @return the parameter value
	 */
	public ParameterArrayList getValue()
	{
		Trace.println(Trace.GETTER);
		return (ParameterArrayList) super.getValue();
	}
}
