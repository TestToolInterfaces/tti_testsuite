package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;
import org.testtoolinterfaces.utils.Warning;


public class TestEntryArrayList extends ArrayList<TestEntry>
{
	private static final long	serialVersionUID	= 1L;

	public TestEntryArrayList()
	{
		super();
	}
	
	public TestEntryArrayList( int aSize )
	{
		super( aSize );
	}
	
	/**
	 * Sorts the Entries in the ArrayList.
	 * @return a new sorted TestEntryArrayList
	 * 
	 *  Note: the old ArrayList remains unchanged
	 */
	public TestEntryArrayList sort()
	{
		Trace.println(Trace.LEVEL.UTIL);
		Trace.println(Trace.LEVEL.ALL, "Array size is " + this.size());

		TestEntryArrayList newEntries = new TestEntryArrayList(this.size());
		for (int old_i = 0; old_i < this.size(); old_i++)
	    {
			int new_i = 0;
			while (new_i < newEntries.size() &&
					this.get(old_i).getSequenceNr() >= newEntries.get(new_i).getSequenceNr())
			{
				new_i++;
			}
			Trace.println(Trace.LEVEL.ALL, "inserting " + this.get(old_i).getId() + " at location " + new_i);
    		newEntries.add(new_i, this.get(old_i));

			if (new_i>0 && 
					newEntries.get(new_i).getSequenceNr() == newEntries.get(new_i-1).getSequenceNr())
			{
				Warning.println("Entries found with same sequence numbers: " +
						newEntries.get(new_i-1).getId() + " and " +
						newEntries.get(new_i).getId() + "\n" +
						"         Order of execution is undetermined...");
			}
	    }
	    
		Trace.println(Trace.LEVEL.ALL, "New Array size is " + newEntries.size());
		return newEntries;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString()
	{
		return this.size() + " TestEntry";
	}
}
