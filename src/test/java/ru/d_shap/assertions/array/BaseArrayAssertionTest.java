///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.collection.CollectionAssertion;

/**
 * Tests for {@link BaseArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BaseArrayAssertionTest {

    /**
     * Test class constructor.
     */
    public BaseArrayAssertionTest() {
        super();
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new BaseArrayAssertionImpl(new ArrayList<String>(), null).isEmpty();

        try {
            new BaseArrayAssertionImpl(null, null).isEmpty();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).isEmpty();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), "Message").isEmpty();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new BaseArrayAssertionImpl(new ArrayList<String>(), null).isNullOrEmpty();
        new BaseArrayAssertionImpl(null, null).isNullOrEmpty();

        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).isNullOrEmpty();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).isNotEmpty();
        new BaseArrayAssertionImpl(Arrays.asList("test1", "test2"), null).isNotEmpty();

        try {
            new BaseArrayAssertionImpl(null, null).isNotEmpty();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(new ArrayList<String>(), null).isNotEmpty();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BaseArrayAssertionImpl(new ArrayList<String>(), "Message").isNotEmpty();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void doContainsTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContains("val1");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContains("val2");

        try {
            new BaseArrayAssertionImpl(null, null).doContains("val");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContains(null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContains("val3");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), "Message").doContains("val3");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void doDoesNotContainTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doDoesNotContain("val3");

        try {
            new BaseArrayAssertionImpl(null, null).doDoesNotContain("val");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doDoesNotContain(null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doDoesNotContain("val1");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doDoesNotContain("val2");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), "Message").doDoesNotContain("val2");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void doContainsAllTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val1", "val2");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val1", "val3");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val3", "val1");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val5", "val1", "val3");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val3", "val5", "val4");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val3", "val1", "val4", "val5", "val2");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));

        try {
            new BaseArrayAssertionImpl(null, null).doContainsAll("val");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(null, null).doContainsAll(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAll((String[]) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAll();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAll((Iterable<String>) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAll(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val1", "val6");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val0", "val1");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val1", "val1", "val2");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").doContainsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").doContainsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void doContainsAllInOrderTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder("val1", "val2");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder("val1", "val3");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder("val1", "val3", "val5");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder("val3", "val4", "val5");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val1", "val1", "val2", "val2"), null).doContainsAllInOrder("val1", "val1", "val1", "val2", "val2");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder("val1", "val2", "val3", "val4", "val5");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));

        try {
            new BaseArrayAssertionImpl(null, null).doContainsAllInOrder("val");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(null, null).doContainsAllInOrder(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAllInOrder((String[]) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAllInOrder();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAllInOrder((Iterable<String>) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAllInOrder(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder("val1", "val6");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder("val3", "val1");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val1", "val1"), null).doContainsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").doContainsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void doContainsExactlyTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly("val1", "val2", "val3");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly("val2", "val1", "val3");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly("val2", "val3", "val1");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly("val3", "val2", "val1");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsExactly("val1", "val2", "val3", "val4", "val5");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsExactly("val2", "val4", "val1", "val3", "val5");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        new BaseArrayAssertionImpl(new ArrayList<String>(), null).doContainsExactly();
        new BaseArrayAssertionImpl(new ArrayList<String>(), null).doContainsExactly(new ArrayList<String>());

        try {
            new BaseArrayAssertionImpl(null, null).doContainsExactly("val");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(null, null).doContainsExactly(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsExactly((String[]) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsExactly((Iterable<String>) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly("val1", "val2");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly("val2", "val1");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsExactly();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsExactly(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly("val2", "val4", "val1");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), "Message").doContainsExactly("val2", "val4", "val1");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), "Message").doContainsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void doContainsExactlyInOrderTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactlyInOrder("val1", "val2", "val3");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        new BaseArrayAssertionImpl(new ArrayList<String>(), null).doContainsExactlyInOrder();
        new BaseArrayAssertionImpl(new ArrayList<String>(), null).doContainsExactlyInOrder(new ArrayList<String>());

        try {
            new BaseArrayAssertionImpl(null, null).doContainsExactlyInOrder("val");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(null, null).doContainsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsExactlyInOrder((String[]) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactlyInOrder("val1", "val2");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactlyInOrder("val2", "val3");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsExactlyInOrder();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), "Message").doContainsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), "Message").doContainsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void doContainsAnyTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsAny("val1", "val3", "val5");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsAny("val6", "val2", "val4");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAny("val7", "val9", "val1", "val5", "val3");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));

        try {
            new BaseArrayAssertionImpl(null, null).doContainsAny("val");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(null, null).doContainsAny(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAny((String[]) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAny();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAny((Iterable<String>) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsAny(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsAny("val4", "val5", "val6");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAny("val8", "val7");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").doContainsAny("val8", "val7");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).doContainsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").doContainsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void doContainsNoneTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsNone("val4", "val5", "val6");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsNone("val8", "val4");
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsNone(Arrays.asList("val8", "val4"));

        try {
            new BaseArrayAssertionImpl(null, null).doContainsNone("val");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(null, null).doContainsNone(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsNone((String[]) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsNone();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsNone((Iterable<String>) null);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2"), null).doContainsNone(new ArrayList<String>());
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsNone("val2");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsNone("val4", "val2");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsNone("val5", "val4", "val2", "val6");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), "Message").doContainsNone("val5", "val4", "val2", "val6");
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).doContainsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), "Message").doContainsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).toLength().isEqualTo(3);
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).toLength().isGreaterThan(2);
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).toLength().isLessThan(6);

        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).toLength().isEqualTo(5);
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).toLength().isGreaterThan(1);
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).toLength().isLessThan(9);

        try {
            new BaseArrayAssertionImpl(null, null).toLength();
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).toLength().isEqualTo(4);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), "Message").toLength().isEqualTo(4);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).hasLength(3);
        new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).hasLength(5);

        try {
            new BaseArrayAssertionImpl(null, null).hasLength(3);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), null).hasLength(4);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BaseArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), "Message").hasLength(4);
            Assertions.fail("Base array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BaseArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new BaseArrayAssertionImpl(null, null).asString(null)).isNull();
        Assertions.assertThat(new BaseArrayAssertionImpl(null, null).asString(new StringBuilder("test"))).isNull();
        Assertions.assertThat(new BaseArrayAssertionImpl(null, null).asString(Arrays.asList("val1", "val2", "val3"))).isNull();
        Assertions.assertThat(new BaseArrayAssertionImpl(null, null).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"))).isNull();
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseArrayAssertionImpl extends BaseArrayAssertion<String> {

        BaseArrayAssertionImpl(final List<String> actual, final String message) {
            super(actual, message);
        }

        @Override
        protected CollectionAssertion createCollectionAssertion() {
            List<Object> copy = new ArrayList<>();
            for (Object object : (List) getActual()) {
                copy.add(object);
            }
            return new CollectionAssertion(copy, getMessage());
        }

    }

}
