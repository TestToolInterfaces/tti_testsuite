package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.testtoolinterfaces.utils.Trace;

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
	private TestEntrySequence myExecutionEntries;
    
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
	                      TestEntrySequence aTestEntries,
	                      TestStepSequence aRestoreSteps )
	{
		super( aTestGroupId,
			       TestEntry.TYPE.Group,
			       aDescription,
			       aSequenceNr,
			       aRequirementIds,
			       aPrepareSteps,
			       aRestoreSteps );

			Trace.println( Trace.CONSTRUCTOR,
						   "TestGroupImpl( " + aTestGroupId + ", "
						   					 + aDescription + ", "
						   					 + aSequenceNr + ", "
						   					 + aRequirementIds.hashCode() + ", "
						   					 + aPrepareSteps + ", "
						   					 + aTestEntries + ", "
						   					 + aRestoreSteps + " )",
							true );

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
	                      TestEntrySequence aTestEntries,
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
	                      TestEntrySequence aTestEntries,
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
	                      TestEntrySequence aTestEntries,
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
	                      TestEntrySequence aTestEntries,
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

	public TestEntrySequence getExecutionEntries() {
		return myExecutionEntries;
	}

	public boolean hasGroupId(String aGroupId) {
		if ( this.getId().equals(aGroupId) ) {
			return true;
		}

		Iterator<TestEntry> itr = (Iterator<TestEntry>) myExecutionEntries.iterator();
		while(itr.hasNext()) {
			TestEntry entry = itr.next();

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
