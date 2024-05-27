package de.unibayreuth.se.teaching.list.business.impl;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

/**
 * Test runner for the Cucumber tests of the double-linked list.
 */
@Suite
@SelectPackages("de.unibayreuth.se.teaching.list")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/cucumber.html")
public class CucumberListTestRunner {

}