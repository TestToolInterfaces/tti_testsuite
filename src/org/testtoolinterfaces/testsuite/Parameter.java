package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * Abstract Class to hold a Parameter.
 * Parameters have a name, a value, and an index.
 * The value is abstract, i.e. subclasses must define suitable methods for handling the value.  
 * 
 * The index can be used in a ParameterArrayList to specify an order.
 * The index defaults to 99 and does not have to be unique.
 * 
 * @author Arjan Kranenburg
 *
 */
public abstract class Parameter
{
	private String myParameter;
	private int myIndex;
	
	/**
	 * Creates a parameter with index 99.
	 * 
	 * @param aParameter Parameter name
	 */
	public Parameter(String aParameter)
	{
		this( aParameter, 99 );
	}

	/**
	 * Creates a parameter
	 * 
	 * @param aParameter Parameter name
	 * @param anIndex    Index
	 *
	 * The index can be used in a ParameterArrayList to specify an order.
	 * The index defaults to 99 and does not have to be unique.
	 */
	public Parameter(String aParameter, int anIndex)
	{
		Trace.println(Trace.CONSTRUCTOR, "Parameter( " + aParameter + ", " 
													   + anIndex + " )", true);
	    myIndex = anIndex;

	    myParameter = aParameter;
	}

	/**
	 * @return the name of the parameter
	 */
	public String getName()
	{
		Trace.println(Trace.GETTER);
	    return myParameter;
	}

	/**
	 * @return the index of the parameter
	 * 
	 * The index can be used in a ParameterArrayList to specify an order.
	 * The index defaults to 99 and does not have to be unique.
	 */
	public int getIndex()
	{
		Trace.println(Trace.GETTER);
	    return myIndex;
	}

	/**
	 * Sets (changes) the index of a parameter
	 * @param anIndex
	 * 
	 * The index can be used in a ParameterArrayList to specify an order.
	 * The index defaults to 99 and does not have to be unique.
	 */
	public void setIndex(int anIndex)
	{
		Trace.println(Trace.SETTER, "setValue( " + anIndex + " )", true);
	    myIndex = anIndex;
	}
}
