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
package ru.d_shap.assertions.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

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
    public void toListTest() {

    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new IteratorAssertion(new ArrayList<String>().iterator(), new FailDescription()).isEmpty();
        new IteratorAssertion(new HashSet<String>().iterator(), new FailDescription()).isEmpty();

        try {
            new IteratorAssertion(null, new FailDescription()).isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription("Message")).isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription("Message")).isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new IteratorAssertion(new ArrayList<String>().iterator(), new FailDescription()).isNullOrEmpty();
        new IteratorAssertion(new HashSet<String>().iterator(), new FailDescription()).isNullOrEmpty();
        new IteratorAssertion(null, new FailDescription()).isNullOrEmpty();

        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).isNullOrEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription("Message")).isNullOrEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).isNotEmpty();
        new IteratorAssertion(Arrays.asList("test1", "test2").iterator(), new FailDescription()).isNotEmpty();

        try {
            new IteratorAssertion(null, new FailDescription()).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription("Message")).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new IteratorAssertion(new ArrayList<String>().iterator(), new FailDescription()).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new IteratorAssertion(new ArrayList<String>().iterator(), new FailDescription("Message")).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
        try {
            new IteratorAssertion(new HashSet<String>().iterator(), new FailDescription()).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new IteratorAssertion(new HashSet<String>().iterator(), new FailDescription("Message")).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNextElementsEqualToTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo("val1");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo(Collections.singletonList("val1"));
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo("val1", "val2");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo(Arrays.asList("val1", "val2"));
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo("val1", "val2", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3"));
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo("val1", "val2", "val3", "val4");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4"));

        try {
            new IteratorAssertion(null, new FailDescription()).isNextElementsEqualTo("val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription()).isNextElementsEqualTo(Arrays.asList("val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo("val2", "val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo(Arrays.asList("val2", "val3"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription("Message")).isNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription()).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4").iterator(), new FailDescription("Message")).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).contains("val1");
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).contains("val2");

        try {
            new IteratorAssertion(null, new FailDescription()).contains("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).contains(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).contains("val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).contains(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<1> but was:<[val1, val2]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).contains(new StringBuilder("test1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription("Message")).contains(new StringBuilder("test1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).doesNotContain("val3");
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).doesNotContain(1);
        new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).doesNotContain(new StringBuilder("test1"));

        try {
            new IteratorAssertion(null, new FailDescription()).doesNotContain("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).doesNotContain(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).doesNotContain("val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).doesNotContain("val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription("Message")).doesNotContain("val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val1", "val2");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val1", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val3", "val1");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val5", "val1", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val3", "val5", "val4");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val3", "val1", "val4", "val5", "val2");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));

        try {
            new IteratorAssertion(null, new FailDescription()).containsAll("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription()).containsAll(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAll((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAll();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAll((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAll(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val1", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val0", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val1", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription("Message")).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription("Message")).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder("val1", "val2");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder("val1", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder("val1", "val3", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder("val3", "val4", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val1", "val1", "val2", "val2").iterator(), new FailDescription()).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));

        try {
            new IteratorAssertion(null, new FailDescription()).containsAllInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAllInOrder((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAllInOrder();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAllInOrder((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder("val1", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder("val3", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val1", "val1").iterator(), new FailDescription()).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription("Message")).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription("Message")).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly("val1", "val2", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly("val2", "val1", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly("val2", "val3", "val1");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly("val3", "val2", "val1");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsExactly("val1", "val2", "val3", "val4", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsExactly("val2", "val4", "val1", "val3", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        new IteratorAssertion(new ArrayList<String>().iterator(), new FailDescription()).containsExactly();
        new IteratorAssertion(new ArrayList<String>().iterator(), new FailDescription()).containsExactly(new ArrayList<String>());

        try {
            new IteratorAssertion(null, new FailDescription()).containsExactly("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription()).containsExactly(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsExactly((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsExactly((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly("val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly("val2", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly("val2", "val4", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription("Message")).containsExactly("val2", "val4", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription("Message")).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactlyInOrder("val1", "val2", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        new IteratorAssertion(new ArrayList<String>().iterator(), new FailDescription()).containsExactlyInOrder();
        new IteratorAssertion(new ArrayList<String>().iterator(), new FailDescription()).containsExactlyInOrder(new ArrayList<String>());

        try {
            new IteratorAssertion(null, new FailDescription()).containsExactlyInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsExactlyInOrder((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsExactlyInOrder((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactlyInOrder("val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactlyInOrder("val2", "val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactlyInOrder();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription("Message")).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription("Message")).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsAny("val1", "val3", "val5");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsAny("val6", "val2", "val4");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAny("val7", "val9", "val1", "val5", "val3");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));

        try {
            new IteratorAssertion(null, new FailDescription()).containsAny("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription()).containsAny(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAny((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAny();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAny((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsAny(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsAny("val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAny("val8", "val7");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription("Message")).containsAny("val8", "val7");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription("Message")).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsNone("val4", "val5", "val6");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsNone("val8", "val4");
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsNone(Arrays.asList("val8", "val4"));

        try {
            new IteratorAssertion(null, new FailDescription()).containsNone("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription()).containsNone(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsNone((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsNone();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsNone((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2").iterator(), new FailDescription()).containsNone(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsNone("val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsNone("val4", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription("Message")).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription("Message")).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).toSize().isEqualTo(3);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).toSize().isGreaterThan(2);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).toSize().isLessThan(6);

        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).toSize().isEqualTo(5);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).toSize().isGreaterThan(1);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).toSize().isLessThan(9);

        try {
            new IteratorAssertion(null, new FailDescription()).toSize();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IteratorAssertion(null, new FailDescription("Message")).toSize();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).toSize().isEqualTo(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription("Message")).toSize().isEqualTo(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).hasSize(3);
        new IteratorAssertion(Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), new FailDescription()).hasSize(5);

        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).hasSize(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription("Message")).hasSize(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new IteratorAssertion(null, new FailDescription()).isNull();

        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription()).isNull();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Value should be null. Actual:<java.util.AbstractList.*>.");
        }
        try {
            new IteratorAssertion(Arrays.asList("val1", "val2", "val3").iterator(), new FailDescription("Message")).isNull();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Value should be null. Actual:<java.util.AbstractList.*>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Iterator<String> value = Arrays.asList("val1", "val2", "val3").iterator();
        new IteratorAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new IteratorAssertion(value, new FailDescription()).isSameAs(Arrays.asList("val1", "val2", "val3").iterator());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<java.util.AbstractList.*> but was:<java.util.AbstractList.*>.");
        }
        try {
            new IteratorAssertion(value, new FailDescription("Message")).isSameAs(Arrays.asList("val1", "val2", "val3").iterator());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<java.util.AbstractList.*> but was:<java.util.AbstractList.*>.");
        }
        try {
            new IteratorAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<test> but was:<java.util.AbstractList.*>.");
        }
        try {
            new IteratorAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<test> but was:<java.util.AbstractList.*>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Iterator<String> value = Arrays.asList("val1", "val2", "val3").iterator();
        new IteratorAssertion(value, new FailDescription()).isNotSameAs(Arrays.asList("val1", "val2", "val3").iterator());
        new IteratorAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new IteratorAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be different. Actual:<java.util.AbstractList.*>.");
        }
        try {
            new IteratorAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be different. Actual:<java.util.AbstractList.*>.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new IteratorAssertion(null, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new IteratorAssertion(null, new FailDescription()).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new IteratorAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(new IteratorAssertion(null, new FailDescription()).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"))).isEqualTo("[val1, val2, val3, val4, val5]");
    }

}
