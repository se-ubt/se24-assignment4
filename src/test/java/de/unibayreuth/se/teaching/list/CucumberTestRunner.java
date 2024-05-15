package de.unibayreuth.se.teaching.list;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("de.unibayreuth.se.teaching.list")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/cucumber.html")
public class CucumberTestRunner {

}