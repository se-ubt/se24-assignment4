package de.unibayreuth.se.teaching.list;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CucumberSteps {
    private static final Logger logger = LoggerFactory.getLogger(CucumberSteps.class);

    private DoublyLinkedList list;
    private double value;
    private double[] arrayFromValues;
    private double[] arrayFromList;

    @Before
    public void initialization() {
        list = new DoublyLinkedList();
    }

    @Given("^an empty list$")
    public void anEmptyList() {
        assertTrue(list.isEmpty());
    }

    @When("^I append an element with value (\\d+.\\d+)$")
    public void iAppendAnElementWithValue(double value) {
        this.value = value;
        list.append(value);
    }

    @Then("^the list should contain that element$")
    public void theListShouldContainThatElement() {
        assertArrayEquals(new double[]{value}, list.asArray());
    }

    @Given("^I have elements with the following values in my list:$")
    public void iHaveElementsWithTheFollowingValuesInMyList(List<Double> values) {
        values.forEach(list::append);
        arrayFromValues = values.stream().mapToDouble(Double::doubleValue).toArray();
    }

    @When("^I convert the list to an array$")
    public void iConvertTheListToAnArray() {
        arrayFromList = list.asArray();
    }

    @Then("^the array should contain the same elements in the same order$")
    public void theArrayShouldContainTheSameElementsInTheSameOrder() {
        assertArrayEquals(arrayFromValues, arrayFromList);
    }

    @When("^I invert the list$")
    public void iInvertTheList() {
        logger.info("%s not implemented yet.".formatted(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Then("^the list should contain the elements in the following order:$")
    public void theListShouldContainTheElementsInTheFollowingOrder(List<Double> values) {
        logger.info("%s not implemented yet.".formatted(Thread.currentThread().getStackTrace()[1].getMethodName()));
    }

    @Then("the list should contain {int} element(s)")
    public void theListShouldContainElement(int count) {
        assertEquals(count, list.getLength());
    }
}
