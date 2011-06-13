package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class Parameter
{
	private String myParameter;
	private Class<? extends Object> myType;
	private int myIndex;
	private Object myValue;
	
	/**
	 * @param aParameter Parameter name
	 * @param aValue	Value or variable name
	 */
	public Parameter(String aParameter, Object aValue)
	{
		Trace.println(Trace.CONSTRUCTOR, "Parameter( " + aParameter + ", " 
													   + aValue.toString() + " )", true);
	    myIndex = 99;

	    myParameter = aParameter;
	    myType = aValue.getClass();
	    myValue = aValue;
	}

	public String getName()
	{
		Trace.println(Trace.GETTER);
	    return myParameter;
	}

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
	 *         null if it doesn't exist or is not a <Type>
	 *         In case of Boolean, false is returned in stead of null. Be carefull to use this for booleans
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
		if ( value != null && this.getValueType( ).equals( aType ) )
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

	public void setValue(Object aValue)
	{
		Trace.println(Trace.SETTER, "setValue( " + aValue.toString() + " )", true);
		myValue = aValue;
	}

	public int getIndex()
	{
		Trace.println(Trace.GETTER);
	    return myIndex;
	}

	public void setIndex(int anIndex)
	{
		Trace.println(Trace.SETTER, "setValue( " + anIndex + " )", true);
	    myIndex = anIndex;
	}
}
