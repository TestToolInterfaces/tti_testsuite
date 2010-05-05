package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;
import org.testtoolinterfaces.utils.Warning;


public class ParameterArrayList extends ArrayList<Parameter>
{
	private static final long serialVersionUID = 1L;

//	public void put(Parameter aParameter)
//	{
//		Trace.println(Trace.LEVEL.UTIL, "put( " + aParameter.getName() + " )");
//		this.add(aParameter);
//	}

	public ParameterArrayList()
	{
		super();
	}
	
	public ParameterArrayList( int aSize )
	{
		super( aSize );
	}
	
	/**
	 * Sorts the Entries in the ArrayList.
	 * @return a new sorted TestEntryArrayList
	 * 
	 *  Note: the old ArrayList remains unchanged
	 */
	public ParameterArrayList sort()
	{
		Trace.println(Trace.LEVEL.UTIL);
		Trace.println(Trace.LEVEL.ALL, "Array size is " + this.size());

		ParameterArrayList newParams = new ParameterArrayList(this.size());
		for (int old_i = 0; old_i < this.size(); old_i++)
	    {
			int new_i = 0;
			while (new_i < newParams.size() &&
					this.get(old_i).getIndex() >= newParams.get(new_i).getIndex())
			{
				new_i++;
			}
    		Trace.println(Trace.LEVEL.ALL, "inserting " + this.get(old_i).getName() + " at location " + new_i);
    		newParams.add(new_i, this.get(old_i));

			if (new_i>0 && 
					newParams.get(new_i).getIndex() == newParams.get(new_i-1).getIndex())
			{
				Warning.println("Steps found with same sequence numbers: " +
						newParams.get(new_i-1).getName() + " and " +
						newParams.get(new_i).getName() + "\n" +
						"         Order of execution is undetermined...");
			}
	    }
	    
		Trace.println(Trace.LEVEL.ALL, "New Array size is " + newParams.size());
		return newParams;
	}
}