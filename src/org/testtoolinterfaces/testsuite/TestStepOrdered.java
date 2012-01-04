package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestStepOrdered extends TestStep implements List<TestStep>
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

	/**
	 * 
	 * @param aSequenceNr
	 * @return
	 */
	public TestStep get( int anIndex )
	{
		return mySteps.get(anIndex);
	}

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

	/**
	 * In order to guarantee the order of the elements, this method is kept the same as
	 * add(TestStep)
	 */
	@Override
	@Deprecated
	public void add(int anIndex, TestStep aStep)
	{
		add(aStep);
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

	/**
	 * In order to guarantee the order of the elements, this method is kept the same as
	 * add(Collection)
	 */
	@Override
	@Deprecated
	public boolean addAll(int anIndex, Collection<? extends TestStep> aTestStepList)
	{
		return this.addAll(aTestStepList);
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
	public int indexOf(Object anObject)
	{
		return mySteps.indexOf(anObject);
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
	public int lastIndexOf(Object anObject)
	{
		return mySteps.lastIndexOf(anObject);
	}

	@Override
	public ListIterator<TestStep> listIterator()
	{
		return mySteps.listIterator();
	}

	@Override
	public ListIterator<TestStep> listIterator(int anIndex)
	{
		return mySteps.listIterator(anIndex);
	}

	@Override
	public boolean remove(Object anObject)
	{
		return mySteps.remove(anObject);
	}

	@Override
	public TestStep remove(int anIndex)
	{
		return mySteps.remove(anIndex);
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

	/**
	 * In order to guarantee the order of the elements, this method is kept the same as
	 * add(TestStep)
	 * 
	 * @param anIndex	ignored
	 * @param aTestStep	TestStep to be added
	 * 
	 * @return the added TestStep
	 */
	@Override
	@Deprecated
	public TestStep set(int anIndex, TestStep aTestStep)
	{
		this.add(aTestStep);
		return aTestStep;
	}

	@Override
	public List<TestStep> subList(int aFromIndex, int aToIndex)
	{
		return mySteps.subList(aFromIndex, aToIndex);
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
