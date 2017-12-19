///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
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

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ValueConverter;

/**
 * Tests for {@link ArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ArrayAssertionTest() {
        super();
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(new ArrayAssertionImpl(), new String[0]).isEmpty();

        try {
            new ArrayAssertionImpl().isEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).isEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null, "Message").isEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).isEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}, "Message").isEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(new ArrayAssertionImpl(), new String[0]).isNullOrEmpty();
        initialize(new ArrayAssertionImpl(), null).isNullOrEmpty();

        try {
            new ArrayAssertionImpl().isNullOrEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).isNullOrEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}, "Message").isNullOrEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).isNotEmpty();
        initialize(new ArrayAssertionImpl(), new String[]{"test1", "test2"}).isNotEmpty();

        try {
            new ArrayAssertionImpl().isNotEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).isNotEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null, "Message").isNotEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[0]).isNotEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[0], "Message").isNotEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContains("val1");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContains("val2");
        initialize(new ArrayAssertionImpl(), new String[]{null, "val1", "val2"}).doContains(null);
        initialize(new ArrayAssertionImpl(), new String[]{"val1", null, "val2"}).doContains(null);
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", null}).doContains(null);

        try {
            new ArrayAssertionImpl().doContains("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContains("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null, "Message").doContains("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContains("val3");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}, "Message").doContains("val3");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doDoesNotContainTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doDoesNotContain("val3");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", null}).doDoesNotContain("val3");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doDoesNotContain(null);

        try {
            new ArrayAssertionImpl().doDoesNotContain("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doDoesNotContain("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null, "Message").doDoesNotContain("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doDoesNotContain("val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doDoesNotContain("val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}, "Message").doDoesNotContain("val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsAllArrayTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val1", "val2");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val1", "val3");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val3", "val1");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val5", "val1", "val3");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val3", "val5", "val4");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val3", "val1", "val4", "val5", "val2");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsAll("val3", "val1", "val4", null, "val2");

        try {
            new ArrayAssertionImpl().doContainsAll("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAll("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAll((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAll((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAll();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val1", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val0", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val1", "val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}, "Message").doContainsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsAllIterableTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val1", "val2"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val1", "val3"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val3", "val1"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val5", "val1", "val3"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val3", "val5", "val4"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsAll(Arrays.asList("val3", "val1", "val4", null, "val2"));

        try {
            new ArrayAssertionImpl().doContainsAll(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAll(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAll((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAll((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAll(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val1", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val0", "val1"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val1", "val1", "val2"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}, "Message").doContainsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsAllInOrderArrayTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder("val1", "val2");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder("val1", "val3");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder("val1", "val3", "val5");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder("val3", "val4", "val5");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val1", "val1", "val2", "val2"}).doContainsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsAllInOrder("val1", "val2", "val3", "val4", null);

        try {
            new ArrayAssertionImpl().doContainsAllInOrder("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAllInOrder("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAllInOrder((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAllInOrder((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAllInOrder();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder("val1", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder("val3", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val1", "val1"}).doContainsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}, "Message").doContainsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsAllInOrderIterableTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder(Arrays.asList("val1", "val2"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder(Arrays.asList("val1", "val3"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder(Arrays.asList("val1", "val3", "val5"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder(Arrays.asList("val3", "val4", "val5"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val1", "val1", "val2", "val2"}).doContainsAllInOrder(Arrays.asList("val1", "val1", "val1", "val2", "val2"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));

        try {
            new ArrayAssertionImpl().doContainsAllInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAllInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAllInOrder((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAllInOrder((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAllInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder(Arrays.asList("val1", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder(Arrays.asList("val3", "val1"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val1", "val1"}).doContainsAllInOrder(Arrays.asList("val1", "val1", "val1", "val1"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}, "Message").doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsExactlyArrayTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly("val1", "val2", "val3");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly("val2", "val1", "val3");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly("val2", "val3", "val1");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly("val3", "val2", "val1");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsExactly("val2", "val4", "val1", "val3", null);
        initialize(new ArrayAssertionImpl(), new String[0]).doContainsExactly();

        try {
            new ArrayAssertionImpl().doContainsExactly("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsExactly("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsExactly((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsExactly((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly("val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly("val2", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsExactly();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly("val2", "val4", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}, "Message").doContainsExactly("val2", "val4", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsExactlyIterableTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly(Arrays.asList("val1", "val2", "val3"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly(Arrays.asList("val2", "val1", "val3"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly(Arrays.asList("val2", "val3", "val1"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly(Arrays.asList("val3", "val2", "val1"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsExactly(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsExactly(Arrays.asList("val2", "val4", "val1", "val3", null));
        initialize(new ArrayAssertionImpl(), new String[0]).doContainsExactly(new ArrayList<String>());

        try {
            new ArrayAssertionImpl().doContainsExactly(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsExactly(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsExactly((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsExactly((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly(Arrays.asList("val3", "val2", "val1", "val4"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly(Arrays.asList("val1", "val2"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly(Arrays.asList("val2", "val1"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsExactly(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}, "Message").doContainsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsExactlyInOrderArrayTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder("val1", "val2", "val3");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(new ArrayAssertionImpl(), new String[0]).doContainsExactlyInOrder();

        try {
            new ArrayAssertionImpl().doContainsExactlyInOrder("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsExactlyInOrder("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsExactlyInOrder((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsExactlyInOrder((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder("val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder("val2", "val3");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsExactlyInOrder();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}, "Message").doContainsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsExactlyInOrderIterableTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder(Arrays.asList("val1", "val2", "val3"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));
        initialize(new ArrayAssertionImpl(), new String[0]).doContainsExactlyInOrder(new ArrayList<String>());

        try {
            new ArrayAssertionImpl().doContainsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder(Arrays.asList("val1", "val2"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder(Arrays.asList("val2", "val3"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder(Arrays.asList("val1", "val2", "val4"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}, "Message").doContainsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsAnyArrayTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsAny("val1", "val3", "val5");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsAny("val6", "val2", "val4");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAny("val7", "val9", "val1", "val5", "val3");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsAny("val7", "val9", null);

        try {
            new ArrayAssertionImpl().doContainsAny("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAny("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAny((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAny((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAny();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsAny("val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAny("val8", "val7");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}, "Message").doContainsAny("val8", "val7");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsAnyIterableTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsAny(Arrays.asList("val1", "val3", "val5"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsAny(Arrays.asList("val6", "val2", "val4"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", null}).doContainsAny(Arrays.asList("val7", "val9", null));

        try {
            new ArrayAssertionImpl().doContainsAny(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAny(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsAny((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAny((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsAny(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsAny(Arrays.asList("val4", "val5", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).doContainsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}, "Message").doContainsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsNoneArrayTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone("val4", "val5", "val6");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone("val8", "val4");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", null}).doContainsNone("val8", "val4");
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone("val8", "val4", null);

        try {
            new ArrayAssertionImpl().doContainsNone("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsNone("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsNone((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsNone((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsNone();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone("val4", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone("val5", "val4", "val2", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}, "Message").doContainsNone("val5", "val4", "val2", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsNoneIterableTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone(Arrays.asList("val4", "val5", "val6"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone(Arrays.asList("val8", "val4"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", null}).doContainsNone(Arrays.asList("val8", "val4"));
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone(Arrays.asList("val8", "val4", null));

        try {
            new ArrayAssertionImpl().doContainsNone(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsNone(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).doContainsNone((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsNone((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2"}).doContainsNone(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone(Arrays.asList("val4", "val2"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).doContainsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}, "Message").doContainsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).toLength().isEqualTo(3);
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).toLength().isGreaterThan(2);
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).toLength().isLessThan(6);

        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).toLength().isEqualTo(5);
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).toLength().isGreaterThan(1);
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).toLength().isLessThan(9);

        try {
            new ArrayAssertionImpl().toLength();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).toLength();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null, "Message").toLength();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).toLength().isEqualTo(4);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's length. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}, "Message").toLength().isEqualTo(4);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's length. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).hasLength(3);
        initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3", "val4", "val5"}).hasLength(5);

        try {
            new ArrayAssertionImpl().hasLength(1);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null).hasLength(1);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), null, "Message").hasLength(1);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}).hasLength(4);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's length. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(new ArrayAssertionImpl(), new String[]{"val1", "val2", "val3"}, "Message").hasLength(4);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's length. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ArrayAssertionImpl extends ArrayAssertion<String[], String> {

        ArrayAssertionImpl() {
            super();
        }

        @Override
        protected Class<String[]> getActualValueClass() {
            return String[].class;
        }

        @Override
        protected List<String> createList(final Object value) {
            return ValueConverter.toObjectList((String[]) value);
        }

        @Override
        protected String asString(final Object value) {
            return value.toString();
        }

    }

}
