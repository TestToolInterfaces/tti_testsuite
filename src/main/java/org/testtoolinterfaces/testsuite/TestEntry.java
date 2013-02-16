package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

/**
 * Interface for TestEntries.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestEntry
{
	
	/**
	 * Type of the TestEntry
	 * Group		for a Test Group
	 * GroupLink	for a link to a TestGroup, e.g. a TestGroup File
	 * Case			for a Test Case
	 * CaseLink		for a link to a TestCase, e.g. in a seperate file
	 * Step			for a Test Step
	 */
//	public enum TYPE { Group, GroupLink, Case, CaseLink, Step };
	
	/**
	 * @return the Test Entry Type
	 */
//	public TYPE getType();

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
	 * @param aSequenceNr the sequenceNr
	 */
	public void setSequenceNr( int aSequenceNr);

	/**
	 * 
	 * @param aDescription the new description
	 */
	public void setDescription(String aDescription);

	/**
	 * @return the string representation of this entry
	 */
	public String toString();

	/**
	 * @return all other attributes
	 */
	public Hashtable<String, String> getAnyAttributes();

	/**
	 * @param anAnyAttributes the AnyAttributes to set
	 */
	public void setAnyAttributes(Hashtable<String, String> anAnyAttributes);
	
	/**
	 * @return all other elements
	 */
	public Hashtable<String, String> getAnyElements();

	/**
	 * @param anAnyElements the AnyElements to set
	 */
	public void setAnyElements(Hashtable<String, String> anAnyElements);
}