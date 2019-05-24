package com.pactiv.runner;

import org.junit.runner.RunWith;

import com.pactiv.constants.Constants;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The Class RunnerTest.

 */
@RunWith(Cucumber.class)
@CucumberOptions(features = Constants.END_TO_END_FEATURES_PATH, glue = {
		Constants.STEP_DEFINITIONS }, plugin = {}, tags="@SmokeTests")

public class TestRunner {

}
