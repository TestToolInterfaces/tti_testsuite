package org.testtoolinterfaces.testsuite.impl;

import java.io.File;

import org.testtoolinterfaces.testsuite.TestExecItemLink;
import org.testtoolinterfaces.testsuite.TestLink;

/**
 * Class for a link to a TestExecutionItemLink.
 * 
 * @author Arjan Kranenburg
 *
 */
public abstract class TestExecItemLinkImpl extends TestGroupEntryImpl
							implements TestExecItemLink
{
	private TestLink myLink;
	

	/**
	 * Constructor
	 * 
	 * @param aTestLinkId		TestItem Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestLink			Test Item Link
	 */
	public TestExecItemLinkImpl( String aTestLinkId,
	                      int aSequenceNr,
	                      TestLink aTestLink )
	{
		super( aTestLinkId, "", aSequenceNr );
		
		this.myLink = aTestLink;
	}

	public File getLink()
	{
		return myLink.getFile();
	}

	public void setLink(TestLink aLink)
	{
		myLink = aLink;
	}

	public String getLinkType()
	{
		return myLink.getType();
	}

	public void setLinkDir( File aLinkDir )
	{
		if ( ! myLink.getFile().isAbsolute() )
		{
			myLink = new TestLinkImpl( aLinkDir, myLink.getPath(), myLink.getType() );
		}
	}
}
