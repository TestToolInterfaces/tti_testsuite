package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Class for Test Steps that consist of a List of TestSteps.
 * The list is ordered on the Sequence Number at all times
 * 
 * This class implements the Collection<TestStep> interface
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepOrdered extends TestStep implements Collection<TestStep>
{
	private ArrayList<TestStep> mySteps;

	public TestStepOrdered( int aSequenceNr )
	{
		super( aSequenceNr );
		mySteps = new ArrayList<TestStep>();
	}
	
	public TestStepOrdered( int aSequenceNr, int aSize )
	{
		super( aSequenceNr );
		mySteps = new ArrayList<TestStep>( aSize );
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#size()
	 */
	public int size()
	{
		return mySteps.size();
	}

	@Override
	public String toString()
	{
		return mySteps.size() + " TestStep(s)";
	}

	@Override
	public String getDisplayName()
	{
		return "Ordered (" + this.toString() + ")";
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add( TestStep aStep )
	{
		 // We start at the end, since in most cases steps will be added already in order.
		ListIterator<TestStep> stepsIter = mySteps.listIterator( mySteps.size() );
		
		while ( stepsIter.hasPrevious() )
		{
			TestStep step = stepsIter.previous();
			if (step.getSequenceNr() < aStep.getSequenceNr())
			{
				stepsIter.next(); // We were 1 too far
				break;
			}
		}
		stepsIter.add(aStep);

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends TestStep> aTestStepList)
	{
		boolean rc = false;
		Iterator<TestStep> itr = (Iterator<TestStep>) aTestStepList.iterator();
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
		mySteps.clear();
	}

	@Override
	public boolean contains(Object anObject)
	{
		return mySteps.contains(anObject);
	}

	@Override
	public boolean containsAll(Collection<?> anObjects)
	{
		return mySteps.containsAll(anObjects);
	}

	@Override
	public boolean isEmpty()
	{
		return mySteps.isEmpty();
	}
	@Override
	public Iterator<TestStep> iterator()
	{
		return mySteps.iterator();
	}

	@Override
	public boolean remove(Object anObject)
	{
		return mySteps.remove(anObject);
	}

	@Override
	public boolean removeAll(Collection<?> aTestSteps)
	{
		return mySteps.removeAll(aTestSteps);
	}

	@Override
	public boolean retainAll(Collection<?> aTestSteps)
	{
		return mySteps.retainAll(aTestSteps);
	}

	@Override
	public TestStep[] toArray()
	{
		TestStep[] array = new TestStep[ mySteps.size() ];
		return mySteps.toArray( array );
	}

	@Override
	public <T> T[] toArray(T[] aTestStepArray)
	{
		return mySteps.toArray(aTestStepArray);
	}
}
