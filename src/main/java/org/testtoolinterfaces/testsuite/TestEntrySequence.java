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
public class TestEntrySequence implements Collection<TestEntry>
{
	private ArrayList<TestEntry> myEntries;

	/**
	 * Creates a TestEntryCollection
	 * 
	 */
	public TestEntrySequence()
	{
		myEntries = new ArrayList<TestEntry>();
	}
	
	public TestEntrySequence( int aSize )
	{
		myEntries = new ArrayList<TestEntry>( aSize );
	}

	public TestEntrySequence( Collection<? extends TestEntry> aTestEntryList )
	{
		myEntries = new ArrayList<TestEntry>( aTestEntryList );
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
	public boolean add( TestEntry anEntry )
	{
		 // We start at the end, since in most cases entries will be added already in order.
		ListIterator<TestEntry> entriesIter = myEntries.listIterator( myEntries.size() );
		
		while ( entriesIter.hasPrevious() )
		{
			TestEntry entry = entriesIter.previous();
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
	public boolean addAll(Collection<? extends TestEntry> aTestEntryList)
	{
		boolean rc = false;
		Iterator<TestEntry> itr = (Iterator<TestEntry>) aTestEntryList.iterator();
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

	public Iterator<TestEntry> iterator()
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

	public TestEntry[] toArray()
	{
		TestEntry[] array = new TestEntry[ myEntries.size() ];
		return myEntries.toArray( array );
	}

	public <T> T[] toArray(T[] aTestEntryArray)
	{
		return myEntries.toArray(aTestEntryArray);
	}
}
