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
package ru.d_shap.assertions.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link IteratorAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IteratorAssertionTest {

    /**
     * Test class constructor.
     */
    public IteratorAssertionTest() {
        super();
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new IteratorAssertion(new ArrayList<String>().iterator(), null).isEmpty();
        new IteratorAssertion(new HashSet<String>().iterator(), null).isEmpty();

        try {
            new IteratorAssertion(null, null).isEmpty();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).isEmpty();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), "Message").isEmpty();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new IteratorAssertion(new ArrayList<String>().iterator(), null).isNullOrEmpty();
        new IteratorAssertion(new HashSet<String>().iterator(), null).isNullOrEmpty();
        new IteratorAssertion(null, null).isNullOrEmpty();

        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).isNullOrEmpty();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), "Message").isNullOrEmpty();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).isNotEmpty();
        new IteratorAssertion(Arrays.asList("test1", "test2").iterator(), null).isNotEmpty();

        try {
            new IteratorAssertion(null, null).isNotEmpty();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(new ArrayList<String>().iterator(), null).isNotEmpty();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new IteratorAssertion(new HashSet<String>().iterator(), null).isNotEmpty();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new IteratorAssertion(new HashSet<String>().iterator(), "Message").isNotEmpty();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).contains("val1");
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).contains("val2");

        try {
            new IteratorAssertion(null, null).contains("val");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).contains(null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).contains("val3");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).contains(1);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<1> but was:<[val1, val2]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).contains(new StringBuilder("test1"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), "Message").contains(new StringBuilder("test1"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).doesNotContain("val3");
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).doesNotContain(1);
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).doesNotContain(new StringBuilder("test1"));

        try {
            new IteratorAssertion(null, null).doesNotContain("val");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).doesNotContain(null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).doesNotContain("val1");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).doesNotContain("val2");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), "Message").doesNotContain("val2");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val1", "val2");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val1", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val3", "val1");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val5", "val1", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val3", "val5", "val4");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val3", "val1", "val4", "val5", "val2");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));

        try {
            new IteratorAssertion(null, null).containsAll("val");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, null).containsAll(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAll((Object[]) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAll();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAll((Iterable<?>) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAll(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val1", "val6");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val0", "val1");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val1", "val1", "val2");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder("val1", "val2");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder("val1", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder("val1", "val3", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder("val3", "val4", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val1", "val1", "val2", "val2").iterator(), null).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));

        try {
            new IteratorAssertion(null, null).containsAllInOrder("val");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAllInOrder((Object[]) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAllInOrder();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAllInOrder((Iterable<?>) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder("val1", "val6");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder("val3", "val1");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val1", "val1").iterator(), null).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly("val1", "val2", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly("val2", "val1", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly("val2", "val3", "val1");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly("val3", "val2", "val1");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsExactly("val1", "val2", "val3", "val4", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsExactly("val2", "val4", "val1", "val3", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        new IteratorAssertion(new ArrayList<String>().iterator(), null).containsExactly();
        new IteratorAssertion(new ArrayList<String>().iterator(), null).containsExactly(new ArrayList<String>());

        try {
            new IteratorAssertion(null, null).containsExactly("val");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, null).containsExactly(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsExactly((Object[]) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsExactly((Iterable<?>) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly("val1", "val2");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly("val2", "val1");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly("val2", "val4", "val1");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactlyInOrder("val1", "val2", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        new IteratorAssertion(new ArrayList<String>().iterator(), null).containsExactlyInOrder();
        new IteratorAssertion(new ArrayList<String>().iterator(), null).containsExactlyInOrder(new ArrayList<String>());

        try {
            new IteratorAssertion(null, null).containsExactlyInOrder("val");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsExactlyInOrder((Object[]) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsExactlyInOrder((Iterable<?>) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactlyInOrder("val1", "val2");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactlyInOrder("val2", "val3");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactlyInOrder();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsAny("val1", "val3", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsAny("val6", "val2", "val4");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAny("val7", "val9", "val1", "val5", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));

        try {
            new IteratorAssertion(null, null).containsAny("val");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, null).containsAny(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAny((Object[]) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAny();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAny((Iterable<?>) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsAny(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsAny("val4", "val5", "val6");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAny("val8", "val7");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAny("val8", "val7");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsNone("val4", "val5", "val6");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsNone("val8", "val4");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsNone(Arrays.asList("val8", "val4"));

        try {
            new IteratorAssertion(null, null).containsNone("val");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, null).containsNone(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsNone((Object[]) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsNone();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsNone((Iterable<?>) null);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), null).containsNone(new ArrayList<String>());
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsNone("val2");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsNone("val4", "val2");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).toSize().isEqualTo(3);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).toSize().isGreaterThan(2);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).toSize().isLessThan(6);

        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).toSize().isEqualTo(5);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).toSize().isGreaterThan(1);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).toSize().isLessThan(9);

        try {
            new IteratorAssertion(null, null).toSize();
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).toSize().isEqualTo(4);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), "Message").toSize().isEqualTo(4);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).hasSize(3);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), null).hasSize(5);

        try {
            new IteratorAssertion(null, null).hasSize(3);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), null).hasSize(4);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), "Message").hasSize(4);
            Assertions.fail("Iterator assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new IteratorAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new IteratorAssertion(null, null).asString(new StringBuilder("test"))).isNull();
        Assertions.assertThat(new IteratorAssertion(null, null).asString(Arrays.asList("val1", "val2", "val3"))).isNull();
        Assertions.assertThat(new IteratorAssertion(null, null).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"))).isNull();
    }

}
