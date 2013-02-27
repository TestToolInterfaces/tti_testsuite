package org.testtoolinterfaces.testsuite;

import java.util.Collection;

/**
 * Interface for a TestItemIteration (a for each).
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestEntryIteration<E extends TestEntry>
{
	/**
	 * @return the itemName
	 */
	public String getItemName();

	/**
	 * @return the list name
	 */
	public String getListName();

	/**
	 * @return the sequence
	 */
	public Collection<E> getSequence();

	/**
	 * @return the until-step
	 */
	public TestStep getUntilStep();
}
