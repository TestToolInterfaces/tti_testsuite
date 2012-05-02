package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class to hold a Parameter.
 * Parameters have a name, a value of type, and an index.
 * 
 * The index can be used in a ParameterArrayList to specify an order.
 * The index defaults to 99 and does not have to be unique.
 * 
 * @author Arjan Kranenburg
 *
 */
public class ParameterImpl extends Parameter
{
	private Class<? extends Object> myType;
	private Object myValue;
	
	/**
	 * Creates a simple parameter
	 * 
	 * @param aParameter 		Parameter name
	 * @param aValue     		Value
	 * @param anIndex    		Index
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 *
	 * The index can be used in a ParameterArrayList to specify an order.
	 * The index defaults to 99 and does not have to be unique.
	 */
	public ParameterImpl( String aParameter,
	                      Object aValue,
	                      int anIndex,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		super( aParameter, 
		       anIndex,
		       anAnyAttributes,
		       anAnyElements );
		Trace.println(Trace.CONSTRUCTOR, "ParameterImpl( " + aParameter + ", " 
		              									   + aValue.toString() + ", "
		              									   + anIndex + " )", true);

	    myType = aValue.getClass();
	    myValue = aValue;
	}

	/**
	 * Creates a simple parameter.
	 * 
	 * @param aParameter 		Parameter name
	 * @param aValue     		Value
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public ParameterImpl( String aParameter,
	                      Object aValue,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		this( aParameter,
		      aValue,
		      Parameter.DEFAULT_INDEX,
		      anAnyAttributes,
		      anAnyElements );
	}

	/**
	 * Creates a simple parameter
	 * 
	 * @param aParameter 		Parameter name
	 * @param aValue     		Value
	 * @param anIndex    		Index
	 *
	 * The index can be used in a ParameterArrayList to specify an order.
	 * The index defaults to 99 and does not have to be unique.
	 */
	public ParameterImpl( String aParameter,
	                      Object aValue,
	                      int anIndex )
	{
		this( aParameter,
		      aValue,
		      anIndex,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Creates a simple parameter.
	 * 
	 * @param aParameter 		Parameter name
	 * @param aValue     		Value
	 */
	public ParameterImpl( String aParameter,
	                      Object aValue )
	{
		this( aParameter,
		      aValue,
		      Parameter.DEFAULT_INDEX,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * @return the java-type of the parameter value
	 */
	public Class<? extends Object> getValueType()
	{
		Trace.println(Trace.GETTER);
	    return myType;
	}

	/**
	 * @return the parameter value
	 */
	public Object getValue()
	{
		Trace.println(Trace.GETTER);
		return myValue;
	}

	/**
	 * @return the value as a <Type> object
	 *         null if it doesn't exist or is not exactly a <Type> (also no subclasses)
	 *         
	 *         In case of Boolean, false is returned in stead of null.
	 *         In case of Integer, 0 is returned in stead of null.
	 *         
	 */
	@SuppressWarnings("unchecked")
	public <Type> Type getValueAs(Class<Type> aType)
	{
		Type varOfType = null;
		if ( aType == Boolean.class )
		{
			varOfType = (Type) Boolean.FALSE;
		}

		if ( aType == Integer.class )
		{
			varOfType = (Type) new Integer( 0 );
		}

		Object value = this.getValue();
		if ( value != null && aType.isInstance(value) )
		{
			varOfType = (Type) value;
		}
		return varOfType;
	}

	/**
	 * @return the value as a String object
	 *         null if it doesn't exist or is not a String
	 */
	public String getValueAsString()
	{
		return getValueAs( String.class );
	}

	/**
	 * @return the value as a int
	 *         0 if it doesn't exist or is not a String
	 */
	public int getValueAsInt()
	{
		return getValueAs( Integer.class ).intValue();
	}

	/**
	 * Sets (changes) the value of the parameter
	 * @param aValue
	 */
	public void setValue(Object aValue)
	{
		Trace.println(Trace.SETTER, "setValue( " + aValue.toString() + " )", true);
		myValue = aValue;
	}
}
