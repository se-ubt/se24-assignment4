package de.unibayreuth.se.teaching.list.data.persistence;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Test runner for the Cucumber tests of the double-linked list.
 */
@Suite
@SelectPackages("de.unibayreuth.se.teaching.list")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/cucumber.html")
public class CucumberListTestRunner {

}