/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import junit.framework.TestCase;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.Parameter;

/**
 * @author Arjan Kranenburg
 *
 */
public class ParameterTester extends TestCase
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
	 * Test method for {@link org.testtoolinterfaces.testsuite.Parameter#Parameter(java.lang.String, java.lang.Object)}.
	 */
	@Test
	public void testConstructorStringObject()
	{
		Parameter param = new Parameter( "name", new Integer(3) );
		
		Assert.assertEquals("Incorrect name", "name", param.getName());
		Assert.assertEquals("Incorrect Index", 99, param.getIndex());
		Assert.assertEquals("Incorrect Value Type", Integer.class, param.getValueType());
		Assert.assertEquals("Incorrect Value", new Integer(3), param.getValue());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.Parameter#getValueAsString()}.
	 */
	@Test
	public void testGetValueAsString()
	{
		Parameter param = new Parameter( "name", "Value" );
		
		Assert.assertEquals("Incorrect value", "Value", param.getValueAsString());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.Parameter#getValueAsInt()}.
	 */
	@Test
	public void testGetValueAsInt()
	{
		Parameter param = new Parameter( "name", 3 );
		Assert.assertEquals("Incorrect value", 3, param.getValueAsInt());

		Parameter paramString = new Parameter( "name", "five" );
		Assert.assertEquals("Incorrect value", 0, paramString.getValueAsInt());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.Parameter#Parameter(java.lang.String, org.testtoolinterfaces.testsuite.Parameter.DIRECTION, java.lang.Object)}.
	 */
	@Test
	public void testConstructorStringDIRECTIONObject()
	{
		Parameter param = new Parameter( "name", "A String" );
		
		Assert.assertEquals("Incorrect name", "name", param.getName());
		Assert.assertEquals("Incorrect Index", 99, param.getIndex());
		Assert.assertEquals("Incorrect Value Type", String.class, param.getValueType());
		Assert.assertEquals("Incorrect Value", "A String", param.getValue());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.Parameter#setIndex(int)}.
	 */
	@Test
	public void testSetIndex()
	{
		Parameter param = new Parameter( "name", "A String" );
	
		Assert.assertEquals("Incorrect Index (a)", 99, param.getIndex());
		
		param.setIndex(5);
		Assert.assertEquals("Incorrect Index (b)", 5, param.getIndex());
	}
}
