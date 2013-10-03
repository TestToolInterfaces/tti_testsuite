package org.testtoolinterfaces.testsuite;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testtoolinterfaces.utils.Mark;

/**
 * Class to hold a TestStepIteration (a for each of steps).
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepIteration extends TestStepImpl
				implements TestEntryIteration<TestStep> {
    private static final Logger LOG = LoggerFactory.getLogger(TestStepIteration.class);

    private String itemName;
	private String listName;
	private Collection<TestStep> sequence;
	private TestStep untilStep;

    /**
     * Creates a TestStepIteration
     * 
	 * @param aDescription	Description
	 * @param aSequenceNr	Sequence number, to be used in a collection
	 * @param anItemName	Name that is given to the item when iterating over the list
	 * @param aListName		Name of the list
	 * @param aSequence		The sequence of {@link TestStep} to do in every iteration
	 * @param anUntilStep		The untilStep to provide a possibility to break out of the loop
	 */
	public TestStepIteration( String aDescription,
	        int aSequenceNr, String anItemName, String aListName,
    		Collection<TestStep> aSequence, TestStep anUntilStep )
	{
		super(aSequenceNr, aDescription, new ParameterArrayList());
		LOG.trace(Mark.CONSTRUCTOR, "{}, {}, {}, {}, {}, {}",
				aDescription, aSequenceNr,
				anItemName, aListName, aSequence, anUntilStep);
		
		this.itemName = anItemName;
		this.listName = aListName;
		this.sequence = aSequence;
		this.untilStep = anUntilStep;

		this.setDisplayName("Foreach " + itemName + " in " + listName);
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
	public Collection<TestStep> getSequence() {
		return sequence;
	}

	/**
	 * @return the until-step
	 */
	public TestStep getUntilStep() {
		return untilStep;
	}
}
