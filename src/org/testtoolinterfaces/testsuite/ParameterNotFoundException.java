package org.testtoolinterfaces.testsuite;

public class ParameterNotFoundException extends Exception
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1328189529445640127L;

	/**
	 * @param aParameter
	 */
	public ParameterNotFoundException(String anInterface, String aCommand, String aParameter)
	{
		super("For the command " + anInterface + ":" + aCommand
				  + ", the parameter \"" + aParameter + "\" was not found.");
	}
}