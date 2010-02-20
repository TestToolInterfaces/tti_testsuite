package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

import org.testtoolinterfaces.utils.Trace;


public class TestCaseFactoryImpl implements TestCaseFactory
{
	private TestStepFactory myTestStepFactory;
	
	public TestCaseFactoryImpl( TestStepFactory aTestStepFactory )
	{
		myTestStepFactory = aTestStepFactory;
	}
	
	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.testsuite.TestCaseFactory#create(java.lang.String, java.lang.String, int, java.util.ArrayList, org.testtoolinterfaces.testsuite.TestStepArrayList, org.testtoolinterfaces.testsuite.TestStepArrayList, java.io.File, org.testtoolinterfaces.testsuite.TestStepArrayList)
	 */
	public TestCase create( String anId,
							String aType,
							int aSequence,
							String aDescription,
							ArrayList<String> aRequirementIds, 
							TestStepArrayList anInitializationSteps, 
							TestStepArrayList anExecutionSteps,
							TestScript aTestCaseScript,
							TestStepArrayList aRestoreSteps )
	{
		Trace.println(Trace.SUITE,
					   "create( " + anId + ", " 
					   			  + aType + ", "
						   				 + aSequence + ", "
						   				+ aRequirementIds.size() + " Requirements, "
										 + anInitializationSteps + ", "
										 + anExecutionSteps + ", "
										 + aTestCaseScript + ", "
										 + aRestoreSteps + " )",
					   true );

		TestCase testCase;
		if ( aTestCaseScript != null )
		{
			testCase = (TestCase) new TestCaseLinkImpl( anId,
			                                            aType,
														aSequence,
														aRequirementIds,
														anInitializationSteps,
														aTestCaseScript,
														aRestoreSteps );
		}
		else
		{
			testCase = (TestCase) new TestCaseImpl( anId,
													aSequence,
													aDescription,
													aRequirementIds,
													anInitializationSteps,
													anExecutionSteps,
													aRestoreSteps );
		}

		return testCase;
	}

	public TestStepFactory getTestStepFactory()
	{
		return myTestStepFactory;
	}
}
