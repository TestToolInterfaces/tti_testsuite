package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

/**
 * Interface for TestGroups.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestGroup extends TestEntry
{
	/**
	 * @return the Requirement IDs
	 */
	public ArrayList<String> getRequirements();

	/**
	 * @return the Preparation Steps
	 */
	public TestStepSequence getPrepareSteps();

	/**
	 * @return the Execution Entries
	 */
	public TestEntrySequence getExecutionEntries();

	/**
	 * @return the Restore Steps
	 */
	public TestStepSequence getRestoreSteps();
	
	/**
	 * @return if this group's id or one of the sub-group's id is equal to the requested id
	 * 
	 * Note: the TestGroupLinks are not really checked and will always return true. This will have
	 * to be checked when the file is opened, i.e. in the executor.
	 */
	public boolean hasGroupId( String aGroupId );
}