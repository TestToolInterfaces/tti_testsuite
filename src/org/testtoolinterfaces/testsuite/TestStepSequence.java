package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Class for Test Steps that consist of a Sequence of TestSteps.
 * The sequence is ordered on the Sequence Number at all times.
 * 
 * This class implements the Collection<TestStep> interface
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepSequence extends TestStep implements Collection<TestStep>
{
	private ArrayList<TestStep> mySteps;

	/**
	 * Creates a TestStepSequence
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a list
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestStepSequence( int aSequenceNr,
	                           Hashtable<String, String> anAnyAttributes, 
	                           Hashtable<String, String> anAnyElements )
	{
		super( aSequenceNr,
		       "",
		       new ParameterArrayList(),
		       anAnyAttributes,
		       anAnyElements );
		mySteps = new ArrayList<TestStep>();
	}
	
	/**
	 * Creates a TestStepSequence with a specific size
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a list
	 * @param aSize				Initial size of the sequence
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestStepSequence( int aSequenceNr,
	                           int aSize,
	                           Hashtable<String, String> anAnyAttributes, 
	                           Hashtable<String, String> anAnyElements )
	{
		super( aSequenceNr,
		       "",
		       new ParameterArrayList(),
		       anAnyAttributes,
		       anAnyElements );
		mySteps = new ArrayList<TestStep>( aSize );
	}
	
	/**
	 * Creates a TestStepSequence with a specific size,
	 * but without any unknown attributes or elements
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a list
	 * @param aSize				Initial size of the sequence
	 */
	public TestStepSequence( int aSequenceNr,
	                           int aSize )
	{
		this( aSequenceNr,
		      aSize,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}
	
	/**
	 * Creates a TestStepSequence without any unknown attributes or elements
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a list
	 */
	public TestStepSequence( int aSequenceNr )
	{
		this( aSequenceNr,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}
	
	/**
	 * Creates a TestStepSequence with sequence number 0,
	 * but without any unknown attributes or elements
	 * 
	 */
	public TestStepSequence()
	{
		this( 0,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}
	
	@Override
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
