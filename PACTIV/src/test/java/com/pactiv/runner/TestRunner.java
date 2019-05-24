package com.pactiv.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The Class RunnerTest.
 * 
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/CPT/LoginFunctionality_DMG.feature",
		"src/test/resources/features/CPT/LoginFunctionality.feature",
		"src/test/resources/features/CPT/PTBox_Entry.feature" }, glue = {
				"com.pactiv.steps" }, plugin = {}, tags = { "@SmokeCPT" })

public class TestRunner {

}
