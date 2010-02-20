package org.testtoolinterfaces.testsuite;

public interface TestEntry
{
	public enum TYPE { Group, GroupLink, Case, CaseLink, Step };
	
	/**
	 * @return the ID
	 */
	public String getId();

	/**
	 * @return the Test Entry Type
	 */
	public TYPE getType();

	/**
	 * @return the Description
	 */
	public String getDescription();

	/**
	 * @return the Sequence Number.
	 * This specifies in what order this entry must be executed with respect to other entries
	 */
	public int getSequenceNr();

	/**
	 * @param aDescription: the new description
	 */
	public void setDescription(String aDescription);

	/**
	 * @return the string representation of this entry
	 */
	public String toString();

}