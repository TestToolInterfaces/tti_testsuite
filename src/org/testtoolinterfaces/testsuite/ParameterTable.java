package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;


public class ParameterTable extends Hashtable<String, Parameter>
{
  private static final long serialVersionUID = 1L;

  public void put(Parameter aParameter)
  {
    Trace.println(Trace.LEVEL.UTIL, "put( " + aParameter.getName() + " )");
    put(aParameter.getName(), aParameter);
  }

@SuppressWarnings("unchecked")
public ArrayList<Parameter> getOrderedList()
  {
    Trace.println(Trace.LEVEL.UTIL, "getOrderedList()");

    ArrayList newParameters = new ArrayList<Parameter>();

    for (Enumeration keys = keys(); keys.hasMoreElements(); )
    {
      String paramName = (String)keys.nextElement();

      int new_i = 0;

      while ((new_i < newParameters.size()) && 
        (((Parameter)get(paramName)).getIndex() > ((Parameter)newParameters.get(new_i)).getIndex()))
      {
        ++new_i;
      }
      Trace.println(Trace.LEVEL.ALL, "inserting " + paramName + " at location " + new_i);
      newParameters.add(new_i, (Parameter)get(paramName));
    }

    return newParameters;
  }
}