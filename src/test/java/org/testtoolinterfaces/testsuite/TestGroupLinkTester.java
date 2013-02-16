package org.testtoolinterfaces.testsuite;

import java.io.File;
import java.util.Hashtable;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;


public class TestGroupLinkTester extends TestCase
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
	public void testCase_constructor0()
	{
		Hashtable<String, String> anyParams = new Hashtable<String, String>();
		anyParams.put("param1", "value1");
		anyParams.put("param2", "value2");
		Hashtable<String, String> anyElems = new Hashtable<String, String>();
		anyElems.put("paramA", "valueA");
		anyElems.put("paramB", "valueB");
		anyElems.put("paramC", "valueC");

		TestGroupLink tgLink = new TestGroupLink( "ID0", 
		                                             8,
		                                             "link",
		                                             "aType" );
		
		tgLink.setAnyAttributes(anyParams);
		tgLink.setAnyElements(anyElems);

		Assert.assertEquals("Incorrect ID", "ID0", tgLink.getId());
		Assert.assertEquals("Incorrect Sequence Number", 8, tgLink.getSequenceNr());
		Assert.assertTrue(  "Incorrect Description", tgLink.getDescription().isEmpty());

		Assert.assertEquals("TG File incorrect", "link", tgLink.getLink().getPath());
		Assert.assertEquals("Incorrect TG Link Type", "aType", tgLink.getLinkType());

		Assert.assertEquals("Incorrect Any Attributes size", 2, tgLink.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 3, tgLink.getAnyElements().size());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor1()
	{
		TestGroupLink tgLink = new TestGroupLink( "ID1", 
		                                          5,
		                                          "link",
												  "aType" );

		Assert.assertEquals("Incorrect ID", "ID1", tgLink.getId());
		Assert.assertEquals("Incorrect Sequence Number", 5, tgLink.getSequenceNr());

		Assert.assertEquals("TG File incorrect", "link", tgLink.getLink().getPath());
		Assert.assertEquals("Incorrect TG Link Type", "aType", tgLink.getLinkType());

		Assert.assertTrue(  "Any Attributes not empty", tgLink.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", tgLink.getAnyElements().isEmpty());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor2()
	{
		TestGroupLink tgLink = new TestGroupLink( "ID2", 
		                                          3,
		                                          "link" );

		Assert.assertEquals("Incorrect ID", "ID2", tgLink.getId());
		Assert.assertEquals("Incorrect Sequence Number", 3, tgLink.getSequenceNr());

		Assert.assertEquals("TG File incorrect", "link", tgLink.getLink().getPath());
		Assert.assertEquals("Incorrect TG Link Type", TestGroupLink.TYPE_TTI, tgLink.getLinkType());
	}

	/**
	 * Test Cases
	 */
	public void testCase_setLinkDir()
	{
		String sep = File.separator;
		File drive = File.listRoots()[0];
		TestGroupLink tgLink = new TestGroupLink( "ID2", 
		                                          3,
		                                          "link" );

		Assert.assertEquals("TC File incorrect", "link", tgLink.getLink().getPath());

		tgLink.setLinkDir( new File(drive, "home" + sep + "user") );
		String expFileName = drive.getPath() + "home" + sep + "user" + sep + "link";
		Assert.assertEquals("TC File incorrect (1)", expFileName, tgLink.getLink().getPath());

		tgLink.setLinkDir( new File(drive, "home" + sep + "other") );
		Assert.assertEquals("TC File incorrect (2)", expFileName, tgLink.getLink().getPath());
	}
}
