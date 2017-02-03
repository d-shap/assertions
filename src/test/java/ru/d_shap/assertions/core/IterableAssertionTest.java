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
package ru.d_shap.assertions.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link IterableAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IterableAssertionTest {

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
    public void isEmptyTest() {
        new IterableAssertion(new ArrayList<String>(), null).isEmpty();
        new IterableAssertion(new HashSet<String>(), null).isEmpty();

        try {
            new IterableAssertion(null, null).isEmpty();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).isEmpty();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), "Message").isEmpty();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new IterableAssertion(new ArrayList<String>(), null).isNullOrEmpty();
        new IterableAssertion(new HashSet<String>(), null).isNullOrEmpty();
        new IterableAssertion(null, null).isNullOrEmpty();

        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).isNullOrEmpty();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new IterableAssertion(Arrays.asList("val1", "val2"), null).isNotEmpty();
        new IterableAssertion(Arrays.asList("test1", "test2"), null).isNotEmpty();

        try {
            new IterableAssertion(null, null).isNotEmpty();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(new ArrayList<String>(), null).isNotEmpty();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new IterableAssertion(new HashSet<String>(), null).isNotEmpty();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new IterableAssertion(new HashSet<String>(), "Message").isNotEmpty();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsTest() {
        new IterableAssertion(Arrays.asList("val1", "val2"), null).contains("val1");
        new IterableAssertion(Arrays.asList("val1", "val2"), null).contains("val2");

        try {
            new IterableAssertion(null, null).contains("val");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).contains(null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).contains("val3");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).contains(1);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<1> but was:<[val1, val2]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).contains(new StringBuilder("test1"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), "Message").contains(new StringBuilder("test1"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new IterableAssertion(Arrays.asList("val1", "val2"), null).doesNotContain("val3");
        new IterableAssertion(Arrays.asList("val1", "val2"), null).doesNotContain(1);
        new IterableAssertion(Arrays.asList("val1", "val2"), null).doesNotContain(new StringBuilder("test1"));

        try {
            new IterableAssertion(null, null).doesNotContain("val");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).doesNotContain(null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).doesNotContain("val1");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).doesNotContain("val2");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val2");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val3", "val1");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val5", "val1", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val3", "val5", "val4");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val3", "val1", "val4", "val5", "val2");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));

        try {
            new IterableAssertion(null, null).containsAll("val");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, null).containsAll(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAll((Object[]) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAll();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAll((Iterable<?>) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAll(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val6");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val0", "val1");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val1", "val2");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder("val1", "val2");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder("val1", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder("val1", "val3", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder("val3", "val4", "val5");
        new IterableAssertion(Arrays.asList("val1", "val1", "val1", "val2", "val2"), null).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));

        try {
            new IterableAssertion(null, null).containsAllInOrder("val");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAllInOrder((Object[]) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAllInOrder();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAllInOrder((Iterable<?>) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder("val1", "val6");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder("val3", "val1");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val1", "val1"), null).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val1", "val2", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val2", "val1", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val2", "val3", "val1");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val3", "val2", "val1");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsExactly("val1", "val2", "val3", "val4", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsExactly("val2", "val4", "val1", "val3", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));

        try {
            new IterableAssertion(null, null).containsExactly("val");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, null).containsExactly(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsExactly((Object[]) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsExactly();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsExactly((Iterable<?>) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsExactly(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val1", "val2");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val2", "val1");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly("val2", "val4", "val1");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInOrder("val1", "val2", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));

        try {
            new IterableAssertion(null, null).containsExactlyInOrder("val");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsExactlyInOrder((Object[]) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsExactlyInOrder();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsExactlyInOrder((Iterable<?>) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInOrder("val1", "val2");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInOrder("val2", "val3");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsAny("val1", "val3", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsAny("val6", "val2", "val4");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAny("val7", "val9", "val1", "val5", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));

        try {
            new IterableAssertion(null, null).containsAny("val");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, null).containsAny(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAny((Object[]) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAny();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAny((Iterable<?>) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsAny(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsAny("val4", "val5", "val6");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAny("val8", "val7");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val4", "val5", "val6");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val8", "val4");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone(Arrays.asList("val8", "val4"));

        try {
            new IterableAssertion(null, null).containsNone("val");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, null).containsNone(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsNone((Object[]) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsNone();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsNone((Iterable<?>) null);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), null).containsNone(new ArrayList<String>());
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val2");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val4", "val2");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).toSize().isEqualTo(3);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).toSize().isGreaterThan(2);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).toSize().isLessThan(6);

        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).toSize().isEqualTo(5);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).toSize().isGreaterThan(1);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).toSize().isLessThan(9);

        try {
            new IterableAssertion(null, null).toSize();
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).toSize().isEqualTo(4);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).hasSize(3);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), null).hasSize(5);

        try {
            new IterableAssertion(null, null).hasSize(3);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), null).hasSize(4);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), "Message").hasSize(4);
            Assertions.fail("Iterable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new IterableAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new IterableAssertion(null, null).asString(new StringBuilder("test"))).isNull();
        Assertions.assertThat(new IterableAssertion(null, null).asString(Arrays.asList("val1", "val2", "val3"))).isNull();
        Assertions.assertThat(new IterableAssertion(null, null).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"))).isNull();
    }

}
