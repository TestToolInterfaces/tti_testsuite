package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Class for a Collection of Test Entries (i.e Test Groups, Test Cases, etc.).
 * The collection is ordered on the Sequence Number at all times.
 * 
 * This class implements the Collection<TestEntry> interface
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestEntryCollection implements Collection<TestEntry>
{
	private ArrayList<TestEntry> myEntries;

	/**
	 * Creates a TestEntryCollection
	 * 
	 */
	public TestEntryCollection()
	{
		myEntries = new ArrayList<TestEntry>();
	}
	
	public TestEntryCollection( int aSize )
	{
		myEntries = new ArrayList<TestEntry>( aSize );
	}

	@Override
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
	@Override
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

	@Override
	public void clear()
	{
		myEntries.clear();
	}

	@Override
	public boolean contains(Object anObject)
	{
		return myEntries.contains(anObject);
	}

	@Override
	public boolean containsAll(Collection<?> anObjects)
	{
		return myEntries.containsAll(anObjects);
	}

	@Override
	public boolean isEmpty()
	{
		return myEntries.isEmpty();
	}
	@Override
	public Iterator<TestEntry> iterator()
	{
		return myEntries.iterator();
	}

	@Override
	public boolean remove(Object anObject)
	{
		return myEntries.remove(anObject);
	}

	@Override
	public boolean removeAll(Collection<?> aTestEntries)
	{
		return myEntries.removeAll(aTestEntries);
	}

	@Override
	public boolean retainAll(Collection<?> aTestEntries)
	{
		return myEntries.retainAll(aTestEntries);
	}

	@Override
	public TestEntry[] toArray()
	{
		TestEntry[] array = new TestEntry[ myEntries.size() ];
		return myEntries.toArray( array );
	}

	@Override
	public <T> T[] toArray(T[] aTestEntryArray)
	{
		return myEntries.toArray(aTestEntryArray);
	}
}
