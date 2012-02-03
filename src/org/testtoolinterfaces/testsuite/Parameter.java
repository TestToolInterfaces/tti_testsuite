package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

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
	public static final int DEFAULT_INDEX = 99;

	private String myParameter;
	private int myIndex;
	private Hashtable<String, String> myAnyAttributes;
	private Hashtable<String, String> myAnyElements;
	
	/**
	 * Creates a parameter
	 * 
	 * @param aParameter		Parameter name
	 * @param anIndex   		Index
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 *
	 * The index can be used in a ParameterArrayList to specify an order.
	 * The index defaults to 99 and does not have to be unique.
	 */
	public Parameter( String aParameter,
	                  int anIndex,
	                  Hashtable<String, String> anAnyAttributes,
	     			  Hashtable<String, String> anAnyElements )
	{
		Trace.println(Trace.CONSTRUCTOR, "Parameter( " + aParameter + ", " 
													   + anIndex + " )", true);
	    myIndex = anIndex;
	    myParameter = aParameter;

	    myAnyAttributes = anAnyAttributes;
		myAnyElements = anAnyElements;
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

	/**
	 * @return all other attributes
	 */
	public Hashtable<String, String> getAnyAttributes()
	{
		return myAnyAttributes;
	}

	/**
	 * @return all other elements
	 */
	public Hashtable<String, String> getAnyElements()
	{
		return myAnyElements;
	}
}
