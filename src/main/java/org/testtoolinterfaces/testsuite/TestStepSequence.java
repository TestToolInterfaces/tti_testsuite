package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Class for a Sequence of TestSteps.
 * The sequence is ordered on the Sequence Number at all times.
 * 
 * This class implements the Collection<TestStep> interface
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepSequence implements Collection<TestStep>
{
	private ArrayList<TestStep> mySteps;

	/**
	 * Creates a TestStepSequence
	 * 
	 */
	public TestStepSequence()
	{
		mySteps = new ArrayList<TestStep>();
	}
	
	/**
	 * Creates a TestStepSequence with a specific size
	 * 
	 * @param aSize	Initial size of the sequence
	 */
	public TestStepSequence( int aSize )
	{
		mySteps = new ArrayList<TestStep>( aSize );
	}
	
	public TestStepSequence(Collection<? extends TestStep> sequence) {
		mySteps = new ArrayList<TestStep>( sequence );
	}

	public int size()
	{
		return mySteps.size();
	}

	@Override
	public String toString()
	{
		return mySteps.size() + " TestStep(s)";
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

	public void clear()
	{
		mySteps.clear();
	}

	public boolean contains(Object anObject)
	{
		return mySteps.contains(anObject);
	}

	public boolean containsAll(Collection<?> anObjects)
	{
		return mySteps.containsAll(anObjects);
	}

	public boolean isEmpty()
	{
		return mySteps.isEmpty();
	}

	public Iterator<TestStep> iterator()
	{
		return mySteps.iterator();
	}

	public boolean remove(Object anObject)
	{
		return mySteps.remove(anObject);
	}

	public boolean removeAll(Collection<?> aTestSteps)
	{
		return mySteps.removeAll(aTestSteps);
	}

	public boolean retainAll(Collection<?> aTestSteps)
	{
		return mySteps.retainAll(aTestSteps);
	}

	public TestStep[] toArray()
	{
		TestStep[] array = new TestStep[ mySteps.size() ];
		return mySteps.toArray( array );
	}

	public <T> T[] toArray(T[] aTestStepArray)
	{
		return mySteps.toArray(aTestStepArray);
	}
}
