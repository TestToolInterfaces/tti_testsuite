package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

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
	 * Creates a parameter hash
	 * 
	 * @param aParameter    	Parameter name
	 * @param aVariableName 	Variable name
	 * @param anIndex       	Index
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 *
	 * The index can be used in a ParameterArrayList to specify an order.
	 */
	public ParameterHash( String aParameter,
	                      ParameterArrayList aParamList,
	                      int anIndex,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		super( aParameter,
		       anIndex,
		       anAnyAttributes,
		       anAnyElements );

		Trace.println(Trace.CONSTRUCTOR, "ParameterHash( " + aParameter + ", " 
						   + aParamList.toString() + ", "
						   + anIndex + " )", true);

		myParams = aParamList;
	}

	/**
	 * Creates a parameter hash
	 * 
	 * @param aParameter    	Parameter name
	 * @param aVariableName 	Variable name
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public ParameterHash( String aParameter,
	                      ParameterArrayList aParamList,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		this( aParameter,
		      aParamList,
		      Parameter.DEFAULT_INDEX,
		      anAnyAttributes,
		      anAnyElements );
	}

	/**
	 * Creates a parameter hash
	 * 
	 * @param aParameter    Parameter name
	 * @param aVariableName variable name
	 * @param anIndex       Index
	 *
	 * The index can be used in a ParameterArrayList to specify an order.
	 */
	public ParameterHash(String aParameter, ParameterArrayList aParamList, int anIndex)
	{
		this( aParameter,
		      aParamList,
		      anIndex,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * @param aParameter    Parameter name
	 * @param aVariableName variable name
	 */
	public ParameterHash(String aParameter, ParameterArrayList aParamList)
	{
		this( aParameter,
		      aParamList,
		      Parameter.DEFAULT_INDEX,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
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
