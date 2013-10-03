package org.testtoolinterfaces.testsuite;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testtoolinterfaces.utils.Mark;

/**
 * Class to hold a TestEntryIteration (a for each of test groups and cases).
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupEntryIteration extends TestGroupEntryImpl
				implements TestEntryIteration<TestGroupEntry> {
    private static final Logger LOG = LoggerFactory.getLogger(TestGroupEntryIteration.class);

	private String itemName;
	private String listName;
	private Collection<TestGroupEntry> sequence;
	private TestStep untilStep;

    /**
     * Creates a TestEntryIteration
     * 
	 * @param aDescription	Description
	 * @param aSequenceNr	Sequence number, to be used in a collection
	 * @param anItemName	Name that is given to the item when iterating over the list
	 * @param aListName		Name of the list
	 * @param doEntries		The sequence of {@link TestEntryImpl} to do in every iteration
	 * @param anUntilStep	The untilStep to provide a possibility to break out of the loop
	 */
	public TestGroupEntryIteration( String aDescription,
	        int aSequenceNr, String anItemName, String aListName,
    		Collection<TestGroupEntry> aDoEntries, TestStep anUntilStep )
	{
		super("Foreach " + anItemName, aDescription, aSequenceNr);
		LOG.trace(Mark.CONSTRUCTOR, "{}, {}, {}, {}, {}, {}",
				aDescription, aSequenceNr,
				anItemName, aListName, aDoEntries, anUntilStep);
		
		this.itemName = anItemName;
		this.listName = aListName;
		this.sequence = aDoEntries;
		this.untilStep = anUntilStep;
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

	/**
	 * @return the until-step
	 */
	public TestStep getUntilStep() {
		return untilStep;
	}
}
