/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import junit.framework.TestCase;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Arjan Kranenburg
 *
 */
public class ParameterVariableTester extends TestCase
{

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterVariable#ParameterVariable(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testConstructor()
	{
		ParameterVariable param = new ParameterVariable( "parName", "variableName" );
		
		Assert.assertEquals("Incorrect Name", "parName", param.getName());
		Assert.assertEquals("Incorrect Index", 99, param.getIndex());
		Assert.assertEquals("Incorrect Variable", "variableName", param.getVariableName());

		ParameterVariable param2 = new ParameterVariable( "parName2", "variableName2", 35 );
		Assert.assertEquals("Incorrect Index", 35, param2.getIndex());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterVariable#getVariableName()}.
	 */
	@Test
	public void testGetVariableName()
	{
		ParameterVariable param = new ParameterVariable( "name", "VarName" );
		
		Assert.assertEquals("Incorrect Variable name", "VarName", param.getVariableName());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterVariable#setVariableName(java.lang.String)}.
	 */
	@Test
	public void testSetVariableName()
	{
		ParameterVariable param = new ParameterVariable( "name", "variableName" );
	
		Assert.assertEquals("Incorrect variable name (a)", "variableName", param.getVariableName());
		
		param.setVariableName( "newVarName" );
		Assert.assertEquals("Incorrect variable name (b)", "newVarName", param.getVariableName());
	}
}
