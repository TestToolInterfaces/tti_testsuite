package org.testtoolinterfaces.testsuite.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testtoolinterfaces.testsuite.TestGroup;
import org.testtoolinterfaces.testsuite.TestGroupEntry;
import org.testtoolinterfaces.testsuite.TestGroupEntrySequence;
import org.testtoolinterfaces.testsuite.TestGroupLink;
import org.testtoolinterfaces.testsuite.TestStepSequence;
import org.testtoolinterfaces.utils.Mark;

/**
 * Class for Default (i.e. TTI) Test Groups.
 * TestGroupImpls all have an Id, a sequenceNr and may have a description and a list of Requirements.
 * And they all have collections of prepare steps, execution entries, and restore steps.
 * (These collections may be empty as well.)
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupImpl extends TestExecItemImpl implements TestGroup
{
    private static final Logger LOG = LoggerFactory.getLogger(TestGroupImpl.class);

    private TestGroupEntrySequence myExecutionEntries;
    
	/**
	 * Constructor
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestGroupImpl( String aTestGroupId,
	                      String aDescription,
	                      int aSequenceNr,
	                      ArrayList<String> aRequirementIds,
	                      TestStepSequence aPrepareSteps,
	                      TestGroupEntrySequence aTestEntries,
	                      TestStepSequence aRestoreSteps )
	{
		super( aTestGroupId,
			       aDescription,
			       aSequenceNr,
			       aRequirementIds,
			       aPrepareSteps,
			       aRestoreSteps );

			LOG.trace(Mark.CONSTRUCTOR, "{}, {}, {}, {}, {}, {}",
					aTestGroupId, aDescription, aSequenceNr, aRequirementIds,
					aPrepareSteps, aRestoreSteps);

			myExecutionEntries = aTestEntries;
	}

	@Deprecated // Use constructor without anyAttributes and anyElements
	/**
	 * Constructor
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestGroupImpl( String aTestGroupId,
	                      String aDescription,
	                      int aSequenceNr,
	                      ArrayList<String> aRequirementIds,
	                      TestStepSequence aPrepareSteps,
	                      TestGroupEntrySequence aTestEntries,
	                      TestStepSequence aRestoreSteps,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		this( aTestGroupId,
		       aDescription,
		       aSequenceNr,
		       aRequirementIds,
		       aPrepareSteps,
		       aTestEntries,
		       aRestoreSteps );

		this.setAnyAttributes(anAnyAttributes);
		this.setAnyElements(anAnyElements);
	}

	/**
	 * Constructor without description and unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aRequirementIds	List of Requirements
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestGroupImpl( String aTestGroupId,
	                      int aSequenceNr,
	                      ArrayList<String> aRequirementIds,
	                      TestStepSequence aPrepareSteps,
	                      TestGroupEntrySequence aTestEntries,
	                      TestStepSequence aRestoreSteps )
	{
		this( aTestGroupId,
		      "",
		      aSequenceNr,
		      aRequirementIds,
		      aPrepareSteps,
		      aTestEntries,
		      aRestoreSteps );
	}

	/**
	 * Constructor without requirements and unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aDescription		Description
	 * @param aSequenceNr		Sequence Number
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestGroupImpl( String aTestGroupId,
	                      String aDescription,
	                      int aSequenceNr,
	                      TestStepSequence aPrepareSteps,
	                      TestGroupEntrySequence aTestEntries,
	                      TestStepSequence aRestoreSteps )
	{
		this( aTestGroupId,
		      aDescription,
		      aSequenceNr,
		      new ArrayList<String>(),
		      aPrepareSteps,
		      aTestEntries,
		      aRestoreSteps );
	}

	/**
	 * Constructor without description, requirements, and unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aPrepareSteps		Collection of preparation steps
	 * @param aTestEntries		Collection of test entries
	 * @param aRestoreSteps		Collection of Restore steps
	 */
	public TestGroupImpl( String aTestGroupId,
	                      int aSequenceNr,
	                      TestStepSequence aPrepareSteps,
	                      TestGroupEntrySequence aTestEntries,
	                      TestStepSequence aRestoreSteps )
	{
		this( aTestGroupId,
		      "",
		      aSequenceNr,
		      new ArrayList<String>(),
		      aPrepareSteps,
		      aTestEntries,
		      aRestoreSteps );
	}

	public TestGroupEntrySequence getExecutionEntries() {
		return myExecutionEntries;
	}

	public boolean hasGroupId(String aGroupId) {
		if ( this.getId().equals(aGroupId) ) {
			return true;
		}

		Iterator<TestGroupEntry> itr = (Iterator<TestGroupEntry>) myExecutionEntries.iterator();
		while(itr.hasNext()) {
			TestGroupEntry entry = itr.next();

			if ( entry instanceof TestGroup ) {
				if ( ((TestGroup) entry).hasGroupId(aGroupId) )	{
					return true;
				}
			}
			else if ( entry instanceof TestGroupLink ) {
				if ( ((TestGroupLink) entry).getId().equals(aGroupId) ) {
					return true;
				}
			}
		}

		return false;
	}
}
