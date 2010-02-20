package org.testtoolinterfaces.testsuite;

public class TestScriptImpl implements TestScript
{
	private String myExecutionScript;
	private String myType;
	private ParameterTable myParameters;
	
	public TestScriptImpl( String anExecutionScript, String aType, ParameterTable aParameters )
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

	public ParameterTable getParameters()
	{
		return myParameters;
	}
}
