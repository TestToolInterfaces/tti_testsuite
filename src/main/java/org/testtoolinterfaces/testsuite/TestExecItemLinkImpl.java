package org.testtoolinterfaces.testsuite;

import java.io.File;

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
	public TestExecItemLinkImpl( TYPE aType, String aTestLinkId,
	                      int aSequenceNr,
	                      TestLink aTestLink )
	{
		super( aTestLinkId, aType, "", aSequenceNr );
		
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
