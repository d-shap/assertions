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
package ru.d_shap.assertions.core;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IterableAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IterableAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IterableAssertionTest() {
        super();
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.<String>iterableAssertion(), new ArrayList<String>());

        try {
            initializeWithRawActual(Raw.<String>iterableAssertion(), new Object());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.<String>iterableAssertion(), new Object(), "Message");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).isEmpty();
        initialize(Raw.<String>iterableAssertion(), createHashSet()).isEmpty();
        initialize(Raw.<String>iterableAssertion(), createTreeSet()).isEmpty();

        try {
            Raw.<String>iterableAssertion().isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).isNullOrEmpty();
        initialize(Raw.<String>iterableAssertion(), createHashSet()).isNullOrEmpty();
        initialize(Raw.<String>iterableAssertion(), createTreeSet()).isNullOrEmpty();
        initialize(Raw.<String>iterableAssertion(), null).isNullOrEmpty();

        try {
            Raw.<String>iterableAssertion().isNullOrEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).isNullOrEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).isNotEmpty();
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("test1", "test2")).isNotEmpty();

        try {
            Raw.<String>iterableAssertion().isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), new ArrayList<String>(), "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), createHashSet()).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), createHashSet(), "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), createTreeSet()).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), createTreeSet(), "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).contains("val1");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).contains("val2");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList(null, "val1", "val2")).contains(null);
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", null, "val2")).contains(null);
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", null, "val2")).contains(null);

        try {
            Raw.<String>iterableAssertion().contains("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).contains("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").contains("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).contains("val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").contains("val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).doesNotContain("val3");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", null)).doesNotContain("val3");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).doesNotContain(null);

        try {
            Raw.<String>iterableAssertion().doesNotContain("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).doesNotContain("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).doesNotContain("val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).doesNotContain("val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val3");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val5", "val1", "val3");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val5", "val4");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAll("val3", "val1", "val4", null, "val2");

        try {
            Raw.<String>iterableAssertion().containsAll("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAll("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAll("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAll((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAll((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAll((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAll((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAll();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAll();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val0", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val3"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val3", "val1"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val5", "val1", "val3"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val3", "val5", "val4"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAll(Arrays.asList("val3", "val1", "val4", null, "val2"));

        try {
            Raw.<String>iterableAssertion().containsAll(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAll(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAll(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAll((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAll((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAll((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAll((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAll(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAll(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val0", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val1", "val1", "val2", "val2")).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAllInOrder("val1", "val2", "val3", "val4", null);

        try {
            Raw.<String>iterableAssertion().containsAllInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAllInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAllInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAllInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAllInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAllInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAllInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAllInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAllInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val3", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val1", "val1")).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val2"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val3"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val3", "val5"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val3", "val4", "val5"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val1", "val1", "val2", "val2")).containsAllInOrder(Arrays.asList("val1", "val1", "val1", "val2", "val2"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));

        try {
            Raw.<String>iterableAssertion().containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAllInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val3", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val1", "val1")).containsAllInOrder(Arrays.asList("val1", "val1", "val1", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val1", "val2", "val3");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val2", "val1", "val3");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val2", "val3", "val1");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val3", "val2", "val1");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).containsExactly();

        try {
            Raw.<String>iterableAssertion().containsExactly("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactly("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactly("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactly((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactly((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsExactly((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsExactly((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val2", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly("val2", "val4", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val1", "val3"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val3", "val1"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val3", "val2", "val1"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactly(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", null));
        initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).containsExactly(new ArrayList<String>());

        try {
            Raw.<String>iterableAssertion().containsExactly(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactly(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactly(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactly((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsExactly((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsExactly((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val3", "val2", "val1", "val4"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).containsExactlyInOrder();

        try {
            Raw.<String>iterableAssertion().containsExactlyInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactlyInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactlyInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsExactlyInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsExactlyInOrder((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val2", "val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));
        initialize(Raw.<String>iterableAssertion(), new ArrayList<String>()).containsExactlyInOrder(new ArrayList<String>());

        try {
            Raw.<String>iterableAssertion().containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val4"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsAny("val1", "val3", "val5");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsAny("val6", "val2", "val4");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAny("val7", "val9", null);

        try {
            Raw.<String>iterableAssertion().containsAny("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAny("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAny("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAny((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAny((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAny((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAny((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAny();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAny();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsAny("val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAny("val8", "val7");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsAny(Arrays.asList("val1", "val3", "val5"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsAny(Arrays.asList("val6", "val2", "val4"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null)).containsAny(Arrays.asList("val7", "val9", null));

        try {
            Raw.<String>iterableAssertion().containsAny(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAny(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAny(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsAny((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsAny((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAny((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAny((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsAny(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAny(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsAny(Arrays.asList("val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val4", "val5", "val6");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val8", "val4");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", null)).containsNone("val8", "val4");
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val8", null);

        try {
            Raw.<String>iterableAssertion().containsNone("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsNone("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsNone("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsNone((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsNone((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsNone((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsNone((String[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsNone();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsNone();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val4", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone(Arrays.asList("val4", "val5", "val6"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", null)).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone(Arrays.asList("val8", null));

        try {
            Raw.<String>iterableAssertion().containsNone(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsNone(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsNone(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).containsNone((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").containsNone((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsNone((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsNone((Iterable<String>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2")).containsNone(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsNone(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone(Arrays.asList("val4", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).toSize().isEqualTo(3);
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).toSize().isGreaterThan(2);
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).toSize().isLessThan(6);

        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).toSize().isEqualTo(5);
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).toSize().isGreaterThan(1);
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).toSize().isLessThan(9);

        try {
            Raw.<String>iterableAssertion().toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).toSize().isEqualTo(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).hasSize(3);
        initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5")).hasSize(5);

        try {
            Raw.<String>iterableAssertion().hasSize(3);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null).hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), null, "Message").hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String>iterableAssertion(), null).isNull();

        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3")).isNull();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").isNull();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Iterable<String> value = Arrays.asList("val1", "val2", "val3");
        initialize(Raw.<String>iterableAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<String>iterableAssertion(), value).isSameAs(Arrays.asList("val1", "val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), value, "Message").isSameAs(Arrays.asList("val1", "val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Iterable<String> value = Arrays.asList("val1", "val2", "val3");
        initialize(Raw.<String>iterableAssertion(), value).isNotSameAs(Arrays.asList("val1", "val2", "val3"));

        try {
            initialize(Raw.<String>iterableAssertion(), value).isNotSameAs(value);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.<String>iterableAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.<String>iterableAssertion(), null).asString(null));
            Assertions.fail("IterableAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.<String>iterableAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.<String>iterableAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.<String>iterableAssertion(), null).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"))).isEqualTo("[val1, val2, val3, val4, val5]");
    }

}
