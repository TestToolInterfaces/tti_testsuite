package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class Parameter
{
	public static enum DIRECTION { IN, OUT, INOUT }

	private DIRECTION myInOut;
	private String myParameter;
	private Class<? extends Object> myType;
	private int myIndex;
	private Object myValue;
	
	/**
	 * @param aParameter
	 * @param aValue
	 */
	public Parameter(String aParameter, Object aValue)
	{
		Trace.println(Trace.CONSTRUCTOR, "Parameter( " + aParameter + ", " 
													   + aValue.toString() + " )", true);
	    myInOut = DIRECTION.IN;

	    myIndex = 99;

	    myParameter = aParameter;
	    myType = aValue.getClass();
	    myValue = aValue;
	}

	public Parameter(String aParameter, DIRECTION anInOut, Object aValue)
	{
		this(aParameter, aValue);
		Trace.println(Trace.CONSTRUCTOR, "Parameter( " + aParameter + ", " 
													   + anInOut.toString() + ", "
													   + aValue.toString() + " )", true);
		myInOut = anInOut;
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

	public void setValue(Object aValue)
	{
		Trace.println(Trace.SETTER, "setValue( " + aValue.toString() + " )", true);
		if ((myInOut == DIRECTION.INOUT) || (myInOut == DIRECTION.OUT))
	    {
			myValue = aValue;
	    }
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

	public boolean isIn()
	{
		Trace.println(Trace.UTIL);
	    return ((myInOut == DIRECTION.IN) || (myInOut == DIRECTION.INOUT));
	}
}
