package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;


public class TestGroupFactoryImpl implements TestGroupFactory
{
//	private static final String DEFAULT_TYPE = "standard";

	public TestGroupFactoryImpl()
	{
		// nop
	}
	
	private TestCaseFactory myTestCaseFactory;
	
	public TestGroupFactoryImpl( TestCaseFactory aTestCaseFactory )
	{
		myTestCaseFactory = aTestCaseFactory;
	}
	
	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.testsuite.TestGroupFactory#create(java.lang.String, java.lang.String, int, java.lang.String, java.util.ArrayList, org.testtoolinterfaces.testsuite.TestStepArrayList, org.testtoolinterfaces.testsuite.TestEntryArrayList, java.io.File, org.testtoolinterfaces.testsuite.TestStepArrayList)
	 */
	public TestGroup create( String anId,
							 String aType,
							 int aSequence,
							 String aDescription,
							 ArrayList<String> aRequirementIds, 
							 TestStepArrayList anInitializationSteps, 
							 TestEntryArrayList aTestEntries,
							 TestScript aTestGroupScript, 
							 TestStepArrayList aRestoreSteps )
	{
		Trace.println( Trace.SUITE,
					   "create( " + anId + ", " 
					   			  + aType + ", "
					   			  + aSequence + ", "
					   			  + aDescription + ", "
					   			  + aRequirementIds.hashCode() + ", "
					   			  + anInitializationSteps + ", "
					   			  + aTestEntries + ", "
					   			  + aTestGroupScript + ", "
					   			  + aRestoreSteps + " )",
					   true );

//		String type = aType;
//		if ( type.isEmpty() )
//		{
//			type = DEFAULT_TYPE;
//		}
		// Ignoring type for now, and just create a TestGroup based on the existance of a script

		TestGroup testGroup;
		if( aTestGroupScript != null )
		{
			testGroup = (TestGroup) new TestGroupLinkImpl( anId,
														   aSequence,
														   aRequirementIds,
														   anInitializationSteps,
														   aTestGroupScript,
														   aRestoreSteps );
		}
		else
		{
			testGroup = (TestGroup) new TestGroupImpl( anId,
													   aSequence,
													   aDescription,
													   aRequirementIds,
													   anInitializationSteps,
													   aTestEntries,
													   aRestoreSteps );
		}
		
		return testGroup;
	}
	
	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.testsuite.TestGroupFactory#getTestCaseFactory()
	 */
	public TestCaseFactory getTestCaseFactory()
	{
		return myTestCaseFactory;
	}
}
