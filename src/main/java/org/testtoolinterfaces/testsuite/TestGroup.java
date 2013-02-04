package org.testtoolinterfaces.testsuite;

/**
 * Interface for TestGroups.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestGroup extends TestExecItem
{
	/**
	 * @return the Execution Entries
	 */
	public TestGroupEntrySequence getExecutionEntries();

	/**
	 * @return if this group's id or one of the sub-group's id is equal to the requested id
	 * 
	 * Note: the TestGroupLinks are not really checked and will always return true. This will have
	 * to be checked when the file is opened, i.e. in the executor.
	 */
	public boolean hasGroupId( String aGroupId );
}