package org.testtoolinterfaces.testsuite;

import java.io.File;
import java.util.Hashtable;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.TestEntry;

public class TestCaseLinkTester extends TestCase
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

		TestCaseLink tcLink = new TestCaseLink(
				"tcLinkId",
				2,
				"fileName",
				"perl" );
		
		tcLink.setAnyAttributes(anyParams);
		tcLink.setAnyElements(anyElems);

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.CaseLink, tcLink.getType());
		Assert.assertEquals("Incorrect ID", "tcLinkId", tcLink.getId());
		Assert.assertEquals("Incorrect Description", "", tcLink.getDescription());
		Assert.assertEquals("Incorrect Sequence Number", 2, tcLink.getSequenceNr());

		Assert.assertEquals("TC File incorrect", "fileName", tcLink.getLink().getPath());
		Assert.assertEquals("Incorrect TC Link Type", "perl", tcLink.getLinkType());

		Assert.assertEquals("Incorrect Any Attributes size", 2, tcLink.getAnyAttributes().size());
		Assert.assertEquals("Incorrect Any Elements size", 3, tcLink.getAnyElements().size());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor1()
	{
		TestCaseLink tcLink = new TestCaseLink(
				"tcLinkId",
				4,
				"fileName",
				"shell" );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.CaseLink, tcLink.getType());
		Assert.assertEquals("Incorrect ID", "tcLinkId", tcLink.getId());
		Assert.assertEquals("Incorrect Description", "", tcLink.getDescription());
		Assert.assertEquals("Incorrect Sequence Number", 4, tcLink.getSequenceNr());

		Assert.assertEquals("TC File incorrect", "fileName", tcLink.getLink().getPath());
		Assert.assertEquals("Incorrect TC Link Type", "shell", tcLink.getLinkType());

		Assert.assertTrue(  "Any Attributes not empty", tcLink.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", tcLink.getAnyElements().isEmpty());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor2()
	{
		TestCaseLink tcLink = new TestCaseLink(
				"tcLinkId",
				5,
				"fileName2" );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.CaseLink, tcLink.getType());
		Assert.assertEquals("Incorrect ID", "tcLinkId", tcLink.getId());
		Assert.assertEquals("Incorrect Description", "", tcLink.getDescription());
		Assert.assertEquals("Incorrect Sequence Number", 5, tcLink.getSequenceNr());

		Assert.assertEquals("TC File incorrect", "fileName2", tcLink.getLink().getPath());
		Assert.assertEquals("Incorrect TC Link Type", "tti", tcLink.getLinkType());

		Assert.assertTrue(  "Any Attributes not empty", tcLink.getAnyAttributes().isEmpty());
		Assert.assertTrue(  "Any Elements not empty", tcLink.getAnyElements().isEmpty());
	}

	/**
	 * Test Cases
	 */
	public void testCase_setLinkDir()
	{
		String sep = File.separator;
		File drive = File.listRoots()[0];
		TestCaseLink tcLink = new TestCaseLink(
				"tcLinkId",
				5,
				"fileName2" );

		Assert.assertEquals("TC File incorrect", "fileName2", tcLink.getLink().getPath());

		tcLink.setLinkDir( new File(drive, "home" + sep + "user") );
		String expFileName = drive.getPath() + "home" + sep + "user" + sep + "fileName2";
		Assert.assertEquals("TC File incorrect (1)", expFileName, tcLink.getLink().getPath());

		tcLink.setLinkDir( new File(drive, "home" + sep + "other") );
		Assert.assertEquals("TC File incorrect (2)", expFileName, tcLink.getLink().getPath());
	}
}
