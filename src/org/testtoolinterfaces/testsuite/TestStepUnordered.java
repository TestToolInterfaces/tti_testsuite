package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;
import org.testtoolinterfaces.utils.Warning;


public class TestStepUnordered extends TestStep
{
	private ArrayList<TestStep> mySteps;

	public TestStepUnordered( int aSequenceNr )
	{
		super( aSequenceNr );
		mySteps = new ArrayList<TestStep>();
	}
	
	public TestStepUnordered( int aSequenceNr,
							  int aSize
	                       )
	{
		super( aSequenceNr );
		mySteps = new ArrayList<TestStep>( aSize );
	}
	
	/**
	 * Sorts the Entries in the ArrayList.
	 * @return a new sorted TestEntryArrayList
	 * 
	 *  Note: the old ArrayList remains unchanged
	 */
	public TestStepOrdered sort()
	{
		Trace.println(Trace.UTIL);
		Trace.println(Trace.ALL, "Array size is " + mySteps.size());

		TestStepOrdered newSteps = new TestStepOrdered(mySteps.size());
		for (int old_i = 0; old_i < mySteps.size(); old_i++)
	    {
			int new_i = 0;
			while (new_i < newSteps.size() &&
					mySteps.get(old_i).getSequenceNr() >= newSteps.get(new_i).getSequenceNr())
			{
				new_i++;
			}
    		Trace.println(Trace.ALL, "inserting " + mySteps.get(old_i).getDisplayName() + " at location " + new_i);
			newSteps.add(new_i, mySteps.get(old_i));

			if (new_i>0 && 
					newSteps.get(new_i).getSequenceNr() == newSteps.get(new_i-1).getSequenceNr())
			{
				Warning.println("Steps found with same sequence numbers: " +
						newSteps.get(new_i-1).getDisplayName() + " and " +
						newSteps.get(new_i).getDisplayName() + "\n" +
						"         Order of execution is undetermined...");
			}
	    }
	    
		Trace.println(Trace.ALL, "New Array size is " + newSteps.size());
		return newSteps;
	}

	public int size()
	{
		return mySteps.size();
	}

	public TestStep get( int anIndex )
	{
		return mySteps.get(anIndex);
	}
	
	public void add( TestStep aStep )
	{
		mySteps.add( aStep );
	}
	
	public void add( int anIndex, TestStep aStep )
	{
		mySteps.add(anIndex, aStep);
	}

	@Override
	public String toString()
	{
		return mySteps.size() + " TestStep(s)";
	}

	@Override
	public String getDisplayName()
	{
		return "Unordered (" + this.toString() + ")";
	}
}
