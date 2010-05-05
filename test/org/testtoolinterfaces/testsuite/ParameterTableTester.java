package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.ParameterArrayList;

public class ParameterTableTester extends TestCase
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
	}

	/**
	 * Test Cases
	 */
	public void testCase_sort()
	{
		ParameterArrayList paramTable = new ParameterArrayList();

		Parameter param_e = new Parameter("-e", "e-parameter");
		param_e.setIndex(0);
		paramTable.add(param_e);

		Parameter param_r = new Parameter("-r", "");
		param_r.setIndex(3);
		paramTable.add(param_r);

		Parameter param_f = new Parameter("-f", "f-parameter");
		param_f.setIndex(6);
		paramTable.add(param_f);

		Parameter param_A = new Parameter("-A", "");
		param_A.setIndex(4);
		paramTable.add(param_A);

		Parameter param_s = new Parameter("-s", "s-parameter");
		param_s.setIndex(1);
		paramTable.add(param_s);

		Parameter param_j = new Parameter("-j", "");
		param_j.setIndex(5);
		paramTable.add(param_j);

		Parameter param = new Parameter("", "mandatory-parameter");
		param.setIndex(7);
		paramTable.add(param);

		Parameter param_c = new Parameter("-c", "c-parameter");
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

    	ArrayList<Parameter> newParams = paramTable.sort();

		Assert.assertEquals("Incorrect 1st parameter", "-e", newParams.get(0).getName());
		Assert.assertEquals("Incorrect 2nd parameter", "-s", newParams.get(1).getName());
		Assert.assertEquals("Incorrect 3rd parameter", "-c", newParams.get(2).getName());
		Assert.assertEquals("Incorrect 4th parameter", "-r", newParams.get(3).getName());
		Assert.assertEquals("Incorrect 5th parameter", "-A", newParams.get(4).getName());
		Assert.assertEquals("Incorrect 6th parameter", "-j", newParams.get(5).getName());
		Assert.assertEquals("Incorrect 7th parameter", "-f", newParams.get(6).getName());
		Assert.assertEquals("Incorrect 8th parameter", "", newParams.get(7).getName());

		Assert.assertEquals("Incorrect Name 1st step", "e-parameter", newParams.get(0).getValue());
		Assert.assertEquals("Incorrect Name 2nd step", "s-parameter", newParams.get(1).getValue());
		Assert.assertEquals("Incorrect Name 3rd step", "c-parameter", newParams.get(2).getValue());
		Assert.assertEquals("Incorrect Name 4th step", "", newParams.get(3).getValue());
		Assert.assertEquals("Incorrect Name 5th step", "", newParams.get(4).getValue());
		Assert.assertEquals("Incorrect Name 6th step", "", newParams.get(5).getValue());
		Assert.assertEquals("Incorrect Name 7th step", "f-parameter", newParams.get(6).getValue());
		Assert.assertEquals("Incorrect Name 8th step", "mandatory-parameter", newParams.get(7).getValue());

	}
}
