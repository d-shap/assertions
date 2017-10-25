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
import java.util.HashSet;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

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
        new IterableAssertion(new ArrayList<String>(), new FailDescription()).isEmpty();
        new IterableAssertion(new HashSet<String>(), new FailDescription()).isEmpty();

        try {
            new IterableAssertion(null, new FailDescription()).isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription("Message")).isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription("Message")).isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new IterableAssertion(new ArrayList<String>(), new FailDescription()).isNullOrEmpty();
        new IterableAssertion(new HashSet<String>(), new FailDescription()).isNullOrEmpty();
        new IterableAssertion(null, new FailDescription()).isNullOrEmpty();

        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).isNullOrEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription("Message")).isNullOrEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).isNotEmpty();
        new IterableAssertion(Arrays.asList("test1", "test2"), new FailDescription()).isNotEmpty();

        try {
            new IterableAssertion(null, new FailDescription()).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription("Message")).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new IterableAssertion(new ArrayList<String>(), new FailDescription()).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new IterableAssertion(new ArrayList<String>(), new FailDescription("Message")).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
        try {
            new IterableAssertion(new HashSet<String>(), new FailDescription()).isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new IterableAssertion(new HashSet<String>(), new FailDescription("Message")).isNotEmpty();
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
        new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).contains("val1");
        new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).contains("val2");

        try {
            new IterableAssertion(null, new FailDescription()).contains("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).contains(null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).contains("val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).contains(1);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<1> but was:<[val1, val2]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).contains(new StringBuilder("test1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription("Message")).contains(new StringBuilder("test1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).doesNotContain("val3");
        new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).doesNotContain(1);
        new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).doesNotContain(new StringBuilder("test1"));

        try {
            new IterableAssertion(null, new FailDescription()).doesNotContain("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).doesNotContain(null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).doesNotContain("val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).doesNotContain("val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription("Message")).doesNotContain("val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val1", "val2");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val1", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val3", "val1");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val5", "val1", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val3", "val5", "val4");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val3", "val1", "val4", "val5", "val2");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));

        try {
            new IterableAssertion(null, new FailDescription()).containsAll("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription()).containsAll(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAll((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAll();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAll((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAll(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val1", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val0", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val1", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder("val1", "val2");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder("val1", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder("val1", "val3", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder("val3", "val4", "val5");
        new IterableAssertion(Arrays.asList("val1", "val1", "val1", "val2", "val2"), new FailDescription()).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));

        try {
            new IterableAssertion(null, new FailDescription()).containsAllInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAllInOrder((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAllInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAllInOrder((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder("val1", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder("val3", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val1", "val1"), new FailDescription()).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly("val1", "val2", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly("val2", "val1", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly("val2", "val3", "val1");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly("val3", "val2", "val1");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsExactly("val1", "val2", "val3", "val4", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsExactly("val2", "val4", "val1", "val3", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        new IterableAssertion(new ArrayList<String>(), new FailDescription()).containsExactly();
        new IterableAssertion(new ArrayList<String>(), new FailDescription()).containsExactly(new ArrayList<String>());

        try {
            new IterableAssertion(null, new FailDescription()).containsExactly("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription()).containsExactly(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsExactly((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsExactly((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly("val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly("val2", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly("val2", "val4", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).containsExactly("val2", "val4", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactlyInOrder("val1", "val2", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        new IterableAssertion(new ArrayList<String>(), new FailDescription()).containsExactlyInOrder();
        new IterableAssertion(new ArrayList<String>(), new FailDescription()).containsExactlyInOrder(new ArrayList<String>());

        try {
            new IterableAssertion(null, new FailDescription()).containsExactlyInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsExactlyInOrder((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsExactlyInOrder((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactlyInOrder("val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactlyInOrder("val2", "val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactlyInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsAny("val1", "val3", "val5");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsAny("val6", "val2", "val4");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAny("val7", "val9", "val1", "val5", "val3");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));

        try {
            new IterableAssertion(null, new FailDescription()).containsAny("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription()).containsAny(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAny((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAny();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAny((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsAny(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsAny("val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAny("val8", "val7");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).containsAny("val8", "val7");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsNone("val4", "val5", "val6");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsNone("val8", "val4");
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsNone(Arrays.asList("val8", "val4"));

        try {
            new IterableAssertion(null, new FailDescription()).containsNone("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription()).containsNone(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsNone((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsNone();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsNone((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2"), new FailDescription()).containsNone(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsNone("val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsNone("val4", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).toSize().isEqualTo(3);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).toSize().isGreaterThan(2);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).toSize().isLessThan(6);

        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).toSize().isEqualTo(5);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).toSize().isGreaterThan(1);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).toSize().isLessThan(9);

        try {
            new IterableAssertion(null, new FailDescription()).toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription("Message")).toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).toSize().isEqualTo(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).toSize().isEqualTo(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).hasSize(3);
        new IterableAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).hasSize(5);

        try {
            new IterableAssertion(null, new FailDescription()).hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IterableAssertion(null, new FailDescription("Message")).hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new IterableAssertion(null, new FailDescription()).isNull();

        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription()).isNull();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).isNull();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Iterable<String> value = Arrays.asList("val1", "val2", "val3");
        new IterableAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new IterableAssertion(value, new FailDescription()).isSameAs(Arrays.asList("val1", "val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(value, new FailDescription("Message")).isSameAs(Arrays.asList("val1", "val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Iterable<String> value = Arrays.asList("val1", "val2", "val3");
        new IterableAssertion(value, new FailDescription()).isNotSameAs(Arrays.asList("val1", "val2", "val3"));
        new IterableAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new IterableAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[val1, val2, val3]>.");
        }
        try {
            new IterableAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link IterableAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new IterableAssertion(null, new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new IterableAssertion(null, new FailDescription()).asString(new StringBuilder("test"), true)).isEqualTo("test");
        Assertions.assertThat(new IterableAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"), true)).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new IterableAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"), true)).isEqualTo("[val1, val2, val3, val4, val5]");

        Assertions.assertThat(new IterableAssertion(null, new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new IterableAssertion(null, new FailDescription()).asString(new StringBuilder("test"), false)).isEqualTo("test");
        Assertions.assertThat(new IterableAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"), false)).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new IterableAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"), false)).isEqualTo("[val1, val2, val3, val4, val5]");
    }

}
