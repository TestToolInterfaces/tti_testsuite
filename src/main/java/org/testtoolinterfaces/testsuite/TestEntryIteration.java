package org.testtoolinterfaces.testsuite;

import java.util.Collection;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class to hold a TestEntryIteration (a for each).
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestEntryIteration extends TestEntryImpl
//public class TestEntryIteration<E extends TestEntry> extends TestEntryImpl
{
	private String itemName;
	private String listName;
	private TestEntrySequence sequence;
//	private Collection<E> sequence;

    /**
     * Creates a TestEntry
     * 
	 * @param anId			Identifier
	 * @param aType			Type of TestEntry
	 * @param aDescription	Description
	 * @param aSequenceNr	Sequence number, to be used in a collection
	 */
	public TestEntryIteration( String aDescription,
	        int aSequenceNr,
	        String anItemName,
	        String aListName,
	        TestEntrySequence aSequence )
//    		Collection<E> aSequence )
	{
		super("Foreach " + anItemName, TYPE.Step, aDescription, aSequenceNr);
		Trace.println( Trace.CONSTRUCTOR,
			"TestEntryIteration(" + aDescription + ", " + aSequenceNr + ", "
					+ anItemName + ", " + aListName + " )", true );
		
		this.itemName = anItemName;
		this.listName = aListName;
		this.sequence = aSequence;
	}

	@Override
	public String toString()
	{
		return this.getId();
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
	public TestEntrySequence getSequence() {
//	public Collection<E> getSequence() {
		return sequence;
	}
}
