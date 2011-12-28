package org.testtoolinterfaces.testsuite;

/**
 * Class to hold an Hash of parameters.
 * 
 * @author Arjan Kranenburg
 *
 */
public class ParameterHash extends Parameter
{
	ParameterArrayList myParams;

	/**
	 * @param aParameter    Parameter name
	 * @param aVariableName variable name
	 */
	public ParameterHash(String aParameter, ParameterArrayList aParamList)
	{
		super(aParameter);
		myParams = aParamList;
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
	public ParameterHash(String aParameter, ParameterArrayList aParamList, int anIndex)
	{
		super(aParameter, anIndex);
		myParams = aParamList;
	}

	/**
	 * Getter for a parameter from the list.
	 * 
	 * @param  anId the id of the parameter to get.
	 * @return the parameter with requested Id or null if the parameter was not found.
	 */
	public Parameter get( String anId )
	{
		return myParams.get( anId );
	}
	
	/**
	 * @return the ParameterArrayList.
	 */
	public ParameterArrayList getList()
	{
		return myParams;
	}

	/**
	 * @see {@link java.util.ArrayList#size()}
	 */
	public int size()
	{
		return myParams.size();
	}
}
