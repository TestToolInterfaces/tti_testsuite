package org.testtoolinterfaces.testsuite;

public class TestScriptImpl implements TestScript
{
	private String myExecutionScript;
	private String myType;
	private ParameterArrayList myParameters;
	
	public TestScriptImpl( String anExecutionScript, String aType, ParameterArrayList aParameters )
	{
		myExecutionScript = anExecutionScript;
		myType = aType;
		myParameters = aParameters;
	}
	
	public String getExecutionScript()
	{
		return myExecutionScript;
	}

	public String getType()
	{
		return myType;
	}

	public ParameterArrayList getParameters()
	{
		return myParameters;
	}
}
