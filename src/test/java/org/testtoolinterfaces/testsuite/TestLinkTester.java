package org.testtoolinterfaces.testsuite;

import java.io.File;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.impl.TestLinkImpl;

public class TestLinkTester extends TestCase
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
		TestLink testLink = new TestLinkImpl( "pathName" );

		Assert.assertEquals("TestLink File incorrect", "pathName", testLink.getPath());
		Assert.assertEquals("Incorrect Type", TestLink.TYPE_TTI, testLink.getType());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor1()
	{
		TestLink testLink = new TestLinkImpl( new File("parent"), "pathName" );

		Assert.assertEquals("TestLink File incorrect", "parent" + File.separator + "pathName", testLink.getPath());
		Assert.assertEquals("Incorrect Type", TestLink.TYPE_TTI, testLink.getType());
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor2()
	{
		TestLink testLink = new TestLinkImpl( "parDir", "pathName", "type" );

		Assert.assertEquals("TestLink File incorrect", "parDir" + File.separator + "pathName", testLink.getPath());
		Assert.assertEquals("Incorrect Type", "type", testLink.getType());
	}

	/**
	 * Test Cases
	 */
	public void testCase_getFile()
	{
		TestLink testLink = new TestLinkImpl( "pathName" );

		Assert.assertEquals("TestLink File incorrect", new File( "pathName" ), testLink.getFile());
	}
}
