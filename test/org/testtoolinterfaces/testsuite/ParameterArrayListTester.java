package org.testtoolinterfaces.testsuite;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.ParameterArrayList;

public class ParameterArrayListTester extends TestCase
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
	 * Test Cases
	 */
	public void testCase_constructor()
	{
		ParameterArrayList paramTable = new ParameterArrayList();
		Assert.assertEquals("Incorrect Size", 0, paramTable.size());

		ParameterArrayList paramTable2 = new ParameterArrayList( 5 );
		Assert.assertEquals("Incorrect Size", 0, paramTable2.size());
	}

	/**
	 * Test Cases
	 */
	public void testCase_get()
	{
		ParameterArrayList paramTable = new ParameterArrayList();

		ParameterImpl param_e = new ParameterImpl("-e", "e-parameter");
		param_e.setIndex(0);
		paramTable.add(param_e);

		ParameterVariable paramVar = new ParameterVariable("paramVar", "varName");
		paramVar.setIndex(1);
		paramTable.add(paramVar);

		ParameterHash paramHash = new ParameterHash("paramHash", new ParameterArrayList());
		paramVar.setIndex(2);
		paramTable.add(paramHash);

		ParameterImpl param_r = new ParameterImpl("-r", "r-parameter");
		param_r.setIndex(3);
		paramTable.add(param_r);

		Assert.assertEquals("Incorrect Parameter", "r-parameter", ((ParameterImpl) paramTable.get( "-r" )).getValueAsString());
		Assert.assertEquals("Incorrect Parameter", "varName", ((ParameterVariable) paramTable.get( "paramVar" )).getVariableName());
		Assert.assertEquals("Incorrect Parameter", 0, ((ParameterHash) paramTable.get( "paramHash" )).size());
		Assert.assertEquals("Incorrect Parameter", "e-parameter", ((ParameterImpl) paramTable.get( "-e" )).getValueAsString());
		Assert.assertNull(  "Parameter exists", paramTable.get( "-f" ));
	}

	/**
	 * Test Cases
	 */
	public void testCase_sort()
	{
		ParameterArrayList paramTable = new ParameterArrayList();

		ParameterImpl param_e = new ParameterImpl("-e", "e-parameter");
		param_e.setIndex(0);
		paramTable.add(param_e);

		ParameterImpl param_r = new ParameterImpl("-r", "");
		param_r.setIndex(3);
		paramTable.add(param_r);

		ParameterImpl param_f = new ParameterImpl("-f", "f-parameter");
		param_f.setIndex(6);
		paramTable.add(param_f);

		ParameterImpl param_A = new ParameterImpl("-A", "");
		param_A.setIndex(4);
		paramTable.add(param_A);

		ParameterImpl param_s = new ParameterImpl("-s", "s-parameter");
		param_s.setIndex(1);
		paramTable.add(param_s);

		ParameterImpl param_j = new ParameterImpl("-j", "");
		param_j.setIndex(5);
		paramTable.add(param_j);

		ParameterImpl param = new ParameterImpl("", "mandatory-parameter");
		param.setIndex(7);
		paramTable.add(param);

		ParameterImpl param_c = new ParameterImpl("-c", "c-parameter");
		param_c.setIndex(2);
		paramTable.add(param_c);

		Assert.assertEquals("Incorrect Size", 8, paramTable.size());
		Assert.assertEquals("Incorrect Index Nr 1st parameter", 0, paramTable.get(0).getIndex());
		Assert.assertEquals("Incorrect Index Nr 2nd parameter", 3, paramTable.get(1).getIndex());
		Assert.assertEquals("Incorrect Index Nr 3rd parameter", 6, paramTable.get(2).getIndex());
		Assert.assertEquals("Incorrect Index Nr 4th parameter", 4, paramTable.get(3).getIndex());
		Assert.assertEquals("Incorrect Index Nr 5th parameter", 1, paramTable.get(4).getIndex());
		Assert.assertEquals("Incorrect Index Nr 6th parameter", 5, paramTable.get(5).getIndex());
		Assert.assertEquals("Incorrect Index Nr 7th parameter", 7, paramTable.get(6).getIndex());
		Assert.assertEquals("Incorrect Index Nr 8th parameter", 2, paramTable.get(7).getIndex());

		ParameterArrayList newParams = paramTable.sort();

		Assert.assertEquals("Incorrect 1st parameter", "-e", newParams.get(0).getName());
		Assert.assertEquals("Incorrect 2nd parameter", "-s", newParams.get(1).getName());
		Assert.assertEquals("Incorrect 3rd parameter", "-c", newParams.get(2).getName());
		Assert.assertEquals("Incorrect 4th parameter", "-r", newParams.get(3).getName());
		Assert.assertEquals("Incorrect 5th parameter", "-A", newParams.get(4).getName());
		Assert.assertEquals("Incorrect 6th parameter", "-j", newParams.get(5).getName());
		Assert.assertEquals("Incorrect 7th parameter", "-f", newParams.get(6).getName());
		Assert.assertEquals("Incorrect 8th parameter", "", newParams.get(7).getName());

		Assert.assertEquals("Incorrect Name 1st step", "e-parameter", ((ParameterImpl) newParams.get(0)).getValue());
		Assert.assertEquals("Incorrect Name 2nd step", "s-parameter", ((ParameterImpl) newParams.get(1)).getValue());
		Assert.assertEquals("Incorrect Name 3rd step", "c-parameter", ((ParameterImpl) newParams.get(2)).getValue());
		Assert.assertEquals("Incorrect Name 4th step", "", ((ParameterImpl) newParams.get(3)).getValue());
		Assert.assertEquals("Incorrect Name 5th step", "", ((ParameterImpl) newParams.get(4)).getValue());
		Assert.assertEquals("Incorrect Name 6th step", "", ((ParameterImpl) newParams.get(5)).getValue());
		Assert.assertEquals("Incorrect Name 7th step", "f-parameter", ((ParameterImpl) newParams.get(6)).getValue());
		Assert.assertEquals("Incorrect Name 8th step", "mandatory-parameter", ((ParameterImpl) newParams.get(7)).getValue());

		ParameterArrayList paramTable_2 = new ParameterArrayList();

		ParameterImpl param_e2 = new ParameterImpl("e", "e-parameter");
		param_e2.setIndex(4);
		paramTable_2.add(param_e2);

		ParameterImpl param_r2 = new ParameterImpl("r", "r-parameter");
		param_r2.setIndex(4);
		paramTable_2.add(param_r2);

		ParameterArrayList newParams2 = paramTable_2.sort();

		Assert.assertEquals( "Incorrect Size", 2, newParams2.size());
		Assert.assertNotNull("Parameter not present", newParams2.get( "e" ));
		Assert.assertNotNull("Parameter not present", newParams2.get( "r" ));
	}

}
