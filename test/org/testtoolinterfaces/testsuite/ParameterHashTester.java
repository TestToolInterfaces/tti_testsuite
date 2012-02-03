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
public class ParameterHashTester extends TestCase
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
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterHash#ParameterHash(java.lang.String, org.testtoolinterfaces.testsuit.ParameterArrayList, java.util.Hashtable<java.lang.String, java.lang.String>, java.util.Hashtable<java.lang.String, java.lang.String>)}.
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

		ParameterHash param = new ParameterHash( "hashName",
		                                         new ParameterArrayList(),
		                                         35,
		                                         anyParams,
		                                         anyElems );
		
		Assert.assertEquals("Incorrect Name", "hashName", param.getName());
		Assert.assertEquals("Incorrect Index", 35, param.getIndex());

		Assert.assertEquals("Incorrect Any Attributes size", 2, param.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 3, param.getAnyElements().size());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterHash#ParameterHash(java.lang.String, org.testtoolinterfaces.testsuit.ParameterArrayList, java.util.Hashtable<java.lang.String, java.lang.String>, java.util.Hashtable<java.lang.String, java.lang.String>)}.
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

		ParameterHash param = new ParameterHash( "hashName",
		                                         new ParameterArrayList(),
		                                         anyParams,
		                                         anyElems );
		
		Assert.assertEquals("Incorrect Name", "hashName", param.getName());
		Assert.assertEquals("Incorrect Index", 99, param.getIndex());

		Assert.assertEquals("Incorrect Any Attributes size", 2, param.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 3, param.getAnyElements().size());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterHash#ParameterHash(java.lang.String, org.testtoolinterfaces.testsuit.ParameterArrayList, int)}.
	 */
	@Test
	public void testConstructor2()
	{
		ParameterHash param = new ParameterHash( "hashName",
		                                         new ParameterArrayList(),
		                                         37 );
		
		Assert.assertEquals("Incorrect Name", "hashName", param.getName());
		Assert.assertEquals("Incorrect Index", 37, param.getIndex());

		Assert.assertEquals("Incorrect Any Attributes size", 0, param.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 0, param.getAnyElements().size());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterHash#ParameterHash(java.lang.String, org.testtoolinterfaces.testsuit.ParameterArrayList)}.
	 */
	@Test
	public void testConstructor3()
	{
		ParameterHash param = new ParameterHash( "hashName",
		                                         new ParameterArrayList() );
		
		Assert.assertEquals("Incorrect Name", "hashName", param.getName());
		Assert.assertEquals("Incorrect Index", 99, param.getIndex());

		Assert.assertEquals("Incorrect Any Attributes size", 0, param.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 0, param.getAnyElements().size());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterHash#getList()}.
	 */
	@Test
	public void testGetList()
	{
		ParameterHash param = new ParameterHash( "name", new ParameterArrayList() );
		
		Assert.assertEquals("Incorrect ParameterHash", 0, param.getList().size());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterHash#get( java.lang.String )}.
	 */
	@Test
	public void testGet()
	{
		ParameterArrayList paramTable = new ParameterArrayList();

		ParameterImpl param_e = new ParameterImpl("-e", "e-parameter");
		param_e.setIndex(0);
		paramTable.add(param_e);

		ParameterImpl param_r = new ParameterImpl("-r", "r-parameter");
		param_r.setIndex(3);
		paramTable.add(param_r);

		ParameterHash param = new ParameterHash( "name", paramTable );
		
		Assert.assertEquals("Incorrect Parameter", "e-parameter", ((ParameterImpl) param.get( "-e" )).getValueAsString());
		Assert.assertEquals("Incorrect Parameter", "r-parameter", ((ParameterImpl) param.get( "-r" )).getValueAsString());
	}

	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.ParameterHash#size()}.
	 */
	@Test
	public void testSize()
	{
		ParameterArrayList paramTable = new ParameterArrayList();

		ParameterImpl param_e = new ParameterImpl("-e", "e-parameter");
		param_e.setIndex(0);
		paramTable.add(param_e);

		ParameterImpl param_r = new ParameterImpl("-r", "r-parameter");
		param_r.setIndex(3);
		paramTable.add(param_r);

		ParameterHash param = new ParameterHash( "name", paramTable );
		
		Assert.assertEquals("Incorrect Size", 2, param.size());
	}
}
