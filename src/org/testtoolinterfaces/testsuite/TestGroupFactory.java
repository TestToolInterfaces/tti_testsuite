package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

public interface TestGroupFactory
{

	public abstract TestGroup create( String anId,
									  String aType,
									  int aSequence,
									  String aDescription,
									  ArrayList<String> aRequirementIds,
									  TestStepArrayList anInitializationSteps,
									  TestEntryArrayList aTestEntries,
									  TestScript aTestGroupScript,
									  TestStepArrayList aRestoreSteps );

	public abstract TestCaseFactory getTestCaseFactory();

}