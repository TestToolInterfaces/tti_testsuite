package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Class for a Sequence of Test Entries (i.e Test Groups, Test Cases, etc.).
 * The Sequence is ordered on the Sequence Number at all times.
 * 
 * This class implements the Collection<TestEntry> interface
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupEntrySequence implements Collection<TestGroupEntry>
{
	private ArrayList<TestGroupEntry> myEntries;

	/**
	 * Creates a TestEntryCollection
	 * 
	 */
	public TestGroupEntrySequence()
	{
		myEntries = new ArrayList<TestGroupEntry>();
	}
	
	public TestGroupEntrySequence( int aSize )
	{
		myEntries = new ArrayList<TestGroupEntry>( aSize );
	}

	public TestGroupEntrySequence( Collection<? extends TestGroupEntry> aTestEntryList )
	{
		myEntries = new ArrayList<TestGroupEntry>( aTestEntryList );
	}

	public int size()
	{
		return myEntries.size();
	}

	@Override
	public String toString()
	{
		return myEntries.size() + " TestEntry(s)";
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add( TestGroupEntry anEntry )
	{
		 // We start at the end, since in most cases entries will be added already in order.
		ListIterator<TestGroupEntry> entriesIter = myEntries.listIterator( myEntries.size() );
		
		while ( entriesIter.hasPrevious() )
		{
			TestGroupEntry entry = entriesIter.previous();
			if (entry.getSequenceNr() < anEntry.getSequenceNr())
			{
				entriesIter.next(); // We were 1 too far
				break;
			}
		}
		entriesIter.add(anEntry);

		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean addAll(Collection<? extends TestGroupEntry> aTestEntryList)
	{
		boolean rc = false;
		Iterator<TestGroupEntry> itr = (Iterator<TestGroupEntry>) aTestEntryList.iterator();
		while(itr.hasNext())
		{
			if ( this.add(itr.next()) )
			{
				rc = true;
			}
		}
		
		return rc;
	}

	public void clear()
	{
		myEntries.clear();
	}

	public boolean contains(Object anObject)
	{
		return myEntries.contains(anObject);
	}

	public boolean containsAll(Collection<?> anObjects)
	{
		return myEntries.containsAll(anObjects);
	}

	public boolean isEmpty()
	{
		return myEntries.isEmpty();
	}

	public Iterator<TestGroupEntry> iterator()
	{
		return myEntries.iterator();
	}

	public boolean remove(Object anObject)
	{
		return myEntries.remove(anObject);
	}

	public boolean removeAll(Collection<?> aTestEntries)
	{
		return myEntries.removeAll(aTestEntries);
	}

	public boolean retainAll(Collection<?> aTestEntries)
	{
		return myEntries.retainAll(aTestEntries);
	}

	public TestGroupEntry[] toArray()
	{
		TestGroupEntry[] array = new TestGroupEntry[ myEntries.size() ];
		return myEntries.toArray( array );
	}

	public <T> T[] toArray(T[] aTestEntryArray)
	{
		return myEntries.toArray(aTestEntryArray);
	}
}
