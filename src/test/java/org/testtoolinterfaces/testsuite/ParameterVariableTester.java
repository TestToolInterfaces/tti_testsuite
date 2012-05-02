/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

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
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterVariable#ParameterVariable(java.lang.String, java.lang.String, int, java.util.Hashtable<java.lang.String, java.lang.String>, java.util.Hashtable<java.lang.String, java.lang.String>)}.
	 */
	@Test
	public void testConstructor0()
	{
		Hashtable<String, String> anyParams = new Hashtable<String, String>();
		anyParams.put("param1", "value1");
		anyParams.put("param2", "value2");
		Hashtable<String, String> anyElems = new Hashtable<String, String>();
		anyElems.put("paramA", "valueA");
		anyElems.put("paramB", "valueB");
		anyElems.put("paramC", "valueC");

		ParameterVariable param = new ParameterVariable( "parName",
		                                                 "variableName",
		                                                 16,
		                                                 anyParams,
		                                                 anyElems );
		
		Assert.assertEquals("Incorrect Name", "parName", param.getName());
		Assert.assertEquals("Incorrect Index", 16, param.getIndex());
		Assert.assertEquals("Incorrect Variable", "variableName", param.getVariableName());

		Assert.assertEquals("Incorrect Any Attributes size", 2, param.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 3, param.getAnyElements().size());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterVariable#ParameterVariable(java.lang.String, java.lang.String, java.util.Hashtable<java.lang.String, java.lang.String>, java.util.Hashtable<java.lang.String, java.lang.String>)}.
	 */
	@Test
	public void testConstructor1()
	{
		Hashtable<String, String> anyParams = new Hashtable<String, String>();
		anyParams.put("param1", "value1");
		anyParams.put("param2", "value2");
		Hashtable<String, String> anyElems = new Hashtable<String, String>();
		anyElems.put("paramA", "valueA");
		anyElems.put("paramB", "valueB");
		anyElems.put("paramC", "valueC");

		ParameterVariable param = new ParameterVariable( "parName2",
		                                                 "variableName2",
		                                                 anyParams,
		                                                 anyElems );
		
		Assert.assertEquals("Incorrect Name", "parName2", param.getName());
		Assert.assertEquals("Incorrect Index", 99, param.getIndex());
		Assert.assertEquals("Incorrect Variable", "variableName2", param.getVariableName());

		Assert.assertEquals("Incorrect Any Attributes size", 2, param.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 3, param.getAnyElements().size());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterVariable#ParameterVariable(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testConstructor2()
	{
		ParameterVariable param = new ParameterVariable( "parName",
		                                                 "variableName",
		                                                 18 );
		
		Assert.assertEquals("Incorrect Name", "parName", param.getName());
		Assert.assertEquals("Incorrect Index", 18, param.getIndex());
		Assert.assertEquals("Incorrect Variable", "variableName", param.getVariableName());

		Assert.assertEquals("Incorrect Any Attributes size", 0, param.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 0, param.getAnyElements().size());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterVariable#ParameterVariable(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testConstructor3()
	{
		ParameterVariable param = new ParameterVariable( "parName3",
		                                                 "variableName2" );
		
		Assert.assertEquals("Incorrect Name", "parName3", param.getName());
		Assert.assertEquals("Incorrect Index", 99, param.getIndex());
		Assert.assertEquals("Incorrect Variable", "variableName2", param.getVariableName());

		Assert.assertEquals("Incorrect Any Attributes size", 0, param.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 0, param.getAnyElements().size());
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
