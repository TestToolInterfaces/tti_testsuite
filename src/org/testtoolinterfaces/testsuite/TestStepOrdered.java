package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
//import java.util.Collection;
import java.util.Iterator;
//import java.util.List;
import java.util.ListIterator;


public class TestStepOrdered extends TestStep
//		implements List<TestStep>
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
		return mySteps.add( aStep );
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

//	@Override
	public void add(int anIndex, TestStep aStep)
	{
		mySteps.add(anIndex, aStep);
	}
/*
	@Override
	public boolean addAll(Collection<? extends TestStep> arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends TestStep> arg1)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}
*/
//	@Override
	public Iterator<TestStep> iterator()
	{
		return mySteps.iterator();
	}
/*
	@Override
	public int lastIndexOf(Object arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}
*/
//	@Override
	public ListIterator<TestStep> listIterator()
	{
		return mySteps.listIterator();
	}

//	@Override
	public ListIterator<TestStep> listIterator(int anIndex)
	{
		return mySteps.listIterator(anIndex);
	}
/*
	@Override
	public boolean remove(Object arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TestStep remove(int arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TestStep set(int arg0, TestStep arg1)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestStep> subList(int arg0, int arg1)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}
*/

}
