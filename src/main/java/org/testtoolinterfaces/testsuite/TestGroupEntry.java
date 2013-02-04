package org.testtoolinterfaces.testsuite;

/**
 * Interface for TestEntries with an ID.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestGroupEntry extends TestEntry
{
	/**
	 * 
	 * @return the unique identifier for this entry.
	 * It is locally unique, i.e. within the current TestGroup.
	 */
	public String getId();
}