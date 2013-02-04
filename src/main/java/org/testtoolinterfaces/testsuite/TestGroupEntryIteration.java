package org.testtoolinterfaces.testsuite;

import java.util.Collection;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class to hold a TestEntryIteration (a for each of test groups and cases).
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupEntryIteration extends TestGroupEntryImpl
				implements TestEntryIteration<TestGroupEntry> {
	private String itemName;
	private String listName;
	private Collection<TestGroupEntry> sequence;

    /**
     * Creates a TestEntryIteration
     * 
	 * @param aDescription	Description
	 * @param aSequenceNr	Sequence number, to be used in a collection
	 * @param anItemName	Name that is given to the item when iterating over the list
	 * @param aListName		Name of the list
	 * @param myDoEntries	The sequence of {@link TestEntryImpl} to do in every iteration
	 */
	public TestGroupEntryIteration( String aDescription,
	        int aSequenceNr,
	        String anItemName,
	        String aListName,
    		Collection<TestGroupEntry> myDoEntries )
	{
		super("Foreach " + anItemName, TYPE.Group, aDescription, aSequenceNr);
		Trace.println( Trace.CONSTRUCTOR,
			"TestEntryWithIdIteration(" + aDescription + ", " + aSequenceNr + ", "
					+ anItemName + ", " + aListName + " )", true );
		
		this.itemName = anItemName;
		this.listName = aListName;
		this.sequence = myDoEntries;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @return the list name
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @return the sequence
	 */
	public Collection<TestGroupEntry> getSequence() {
		return sequence;
	}
}
