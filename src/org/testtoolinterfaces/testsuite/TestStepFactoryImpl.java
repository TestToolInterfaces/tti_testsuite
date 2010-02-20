package org.testtoolinterfaces.testsuite;

public class TestStepFactoryImpl implements TestStepFactory
{
	public TestStepFactoryImpl()
	{
		// nop
	}
	
	/*
	 * Creates a Test Step
	 */
	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.testsuite.TestStepFactory#create(org.testtoolinterfaces.testsuite.TestStep.ActionType, int, java.lang.String, java.lang.String)
	 */
	public TestStep create( TestStep.ActionType anActionType,
							String aType,
							int aSequence,
							String aDescription,
							String aCommand,
							ParameterTable aParameter )
	{
		TestStep testStep = (TestStep) new TestStepImpl( anActionType,
														 aSequence,
														 aDescription,
														 aCommand,
														 aParameter );

		return testStep;
	}
}
