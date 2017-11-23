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

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IteratorAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IteratorAssertionTest extends AssertionTest {

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
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList().containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(5).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(4).containsExactlyInOrder("val1", "val2", "val3", "val4");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(3).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(2).containsExactlyInOrder("val1", "val2");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).toList(1).containsExactlyInOrder("val1");

        try {
            initialize(Raw.iteratorAssertion(), null).toList();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null, "Message").toList();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).toList(5);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null, "Message").toList(5);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).toList(0);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").toList(0);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).toList(-1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").toList(-1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.iteratorAssertion(), new ArrayList<String>().iterator()).isEmpty();
        initialize(Raw.iteratorAssertion(), new HashSet<String>().iterator()).isEmpty();

        try {
            initialize(Raw.iteratorAssertion(), null).isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null, "Message").isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should be empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").isEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should be empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.iteratorAssertion(), new ArrayList<String>().iterator()).isNullOrEmpty();
        initialize(Raw.iteratorAssertion(), new HashSet<String>().iterator()).isNullOrEmpty();
        initialize(Raw.iteratorAssertion(), null).isNullOrEmpty();

        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).isNullOrEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should be null or empty. Actual:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").isNullOrEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should be null or empty. Actual:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).isNotEmpty();
        initialize(Raw.iteratorAssertion(), Arrays.asList("test1", "test2").iterator()).isNotEmpty();

        try {
            initialize(Raw.iteratorAssertion(), null).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), new ArrayList<String>().iterator()).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), new ArrayList<String>().iterator(), "Message").isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), new HashSet<String>().iterator()).isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should not be empty.");
        }
        try {
            initialize(Raw.iteratorAssertion(), new HashSet<String>().iterator(), "Message").isNotEmpty();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should not be empty.");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNextElementsEqualToTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val1");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Collections.singletonList("val1"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val1", "val2");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val1", "val2", "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val1", "val2", "val3", "val4");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", null, "val4").iterator()).isNextElementsEqualTo("val1", "val2", null, "val4");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", null, "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2", null, "val4"));

        try {
            initialize(Raw.iteratorAssertion(), null).isNextElementsEqualTo("val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).isNextElementsEqualTo(Arrays.asList("val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).isNextElementsEqualTo((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).isNextElementsEqualTo((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val2", "val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val2", "val3"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").isNextElementsEqualTo("val1", "val2", "val3", "val4", "val5");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator()).isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4").iterator(), "Message").isNextElementsEqualTo(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4, val5]> but was:<[val1, val2, val3, val4]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).contains("val1");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).contains("val2");
        initialize(Raw.iteratorAssertion(), Arrays.asList(null, "val1", "val2").iterator()).contains(null);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", null, "val2").iterator()).contains(null);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", null).iterator()).contains(null);

        try {
            initialize(Raw.iteratorAssertion(), null).contains("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null, "Message").contains("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).contains("val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).contains(1);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain the expected value. Expected:<1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).contains(new StringBuilder("test1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").contains(new StringBuilder("test1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain("val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain(1);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain(new StringBuilder("test1"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", null).iterator()).doesNotContain("val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain(null);

        try {
            initialize(Raw.iteratorAssertion(), null).doesNotContain("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain("val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).doesNotContain("val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator(), "Message").doesNotContain("val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", null, "val2").iterator()).doesNotContain(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should not contain the expected value. Expected:<null> but was:<[val1, null, val2]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", null, "val2").iterator(), "Message").doesNotContain(null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should not contain the expected value. Expected:<null> but was:<[val1, null, val2]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val2");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val3", "val1");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val5", "val1", "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val3", "val5", "val4");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAll("val3", "val1", "val4", null, "val2");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAll(Arrays.asList("val3", "val1", "val4", null, "val2"));

        try {
            initialize(Raw.iteratorAssertion(), null).containsAll("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsAll(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsAll((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsAll((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAll((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAll((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAll();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAll(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val0", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val2");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val1", "val1", "val2", "val2").iterator()).containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAllInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));

        try {
            initialize(Raw.iteratorAssertion(), null).containsAllInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsAllInOrder((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsAllInOrder((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAllInOrder((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAllInOrder((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAllInOrder();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val3", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val1", "val1").iterator()).containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val1", "val2", "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val2", "val1", "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val2", "val3", "val1");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val3", "val2", "val1");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsExactly(Arrays.asList("val2", "val4", "val1", "val3", null));
        initialize(Raw.iteratorAssertion(), new ArrayList<String>().iterator()).containsExactly();
        initialize(Raw.iteratorAssertion(), new ArrayList<String>().iterator()).containsExactly(new ArrayList<String>());

        try {
            initialize(Raw.iteratorAssertion(), null).containsExactly("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsExactly(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsExactly((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsExactly((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsExactly((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsExactly((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val2", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly("val2", "val4", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));
        initialize(Raw.iteratorAssertion(), new ArrayList<String>().iterator()).containsExactlyInOrder();
        initialize(Raw.iteratorAssertion(), new ArrayList<String>().iterator()).containsExactlyInOrder(new ArrayList<String>());

        try {
            initialize(Raw.iteratorAssertion(), null).containsExactlyInOrder("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsExactlyInOrder((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsExactlyInOrder((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsExactlyInOrder((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsExactlyInOrder((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val2", "val3");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsAny("val1", "val3", "val5");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsAny("val6", "val2", "val4");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAny("val7", "val9", "val1", null, "val3");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAny(Arrays.asList("val7", "val9", "val1", null, "val3"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAny("val7", "val9", null);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null).iterator()).containsAny(Arrays.asList("val7", "val9", null));

        try {
            initialize(Raw.iteratorAssertion(), null).containsAny("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsAny(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsAny((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsAny((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAny((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAny((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAny();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsAny(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsAny("val4", "val5", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAny("val8", "val7");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAny("val8", "val7");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator(), "Message").containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val4", "val5", "val6");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val8", "val4");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", null).iterator()).containsNone("val8", "val4");
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", null).iterator()).containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val8", "val4", null);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone(Arrays.asList("val8", "val4", null));

        try {
            initialize(Raw.iteratorAssertion(), null).containsNone("val");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsNone(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsNone((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null).containsNone((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsNone((Object[]) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsNone((Iterable<?>) null);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsNone();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2").iterator()).containsNone(new ArrayList<String>());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val4", "val2");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize().isEqualTo(3);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize().isGreaterThan(2);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize().isLessThan(6);

        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).toSize().isEqualTo(5);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).toSize().isGreaterThan(1);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).toSize().isLessThan(9);

        try {
            initialize(Raw.iteratorAssertion(), null).toSize();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), null, "Message").toSize();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).toSize().isEqualTo(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").toSize().isEqualTo(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).hasSize(3);
        initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5").iterator()).hasSize(5);

        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).hasSize(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check iterator elements. Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").hasSize(4);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check iterator elements. Check value size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.iteratorAssertion(), null).isNull();

        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator()).isNull();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Value should be null. Actual:<java.util.AbstractList.*>");
        }
        try {
            initialize(Raw.iteratorAssertion(), Arrays.asList("val1", "val2", "val3").iterator(), "Message").isNull();
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Value should be null. Actual:<java.util.AbstractList.*>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Iterator<String> value = Arrays.asList("val1", "val2", "val3").iterator();
        initialize(Raw.iteratorAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.iteratorAssertion(), value).isSameAs(Arrays.asList("val1", "val2", "val3").iterator());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<java.util.AbstractList.*> but was:<java.util.AbstractList.*>");
        }
        try {
            initialize(Raw.iteratorAssertion(), value, "Message").isSameAs(Arrays.asList("val1", "val2", "val3").iterator());
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<java.util.AbstractList.*> but was:<java.util.AbstractList.*>");
        }
        try {
            initialize(Raw.iteratorAssertion(), value).isSameAs("test");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<test> but was:<java.util.AbstractList.*>");
        }
        try {
            initialize(Raw.iteratorAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<test> but was:<java.util.AbstractList.*>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Iterator<String> value = Arrays.asList("val1", "val2", "val3").iterator();
        initialize(Raw.iteratorAssertion(), value).isNotSameAs(Arrays.asList("val1", "val2", "val3").iterator());
        initialize(Raw.iteratorAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.iteratorAssertion(), value).isNotSameAs(value);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be different. Actual:<java.util.AbstractList.*>");
        }
        try {
            initialize(Raw.iteratorAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("IteratorAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be different. Actual:<java.util.AbstractList.*>");
        }
    }

    /**
     * {@link IteratorAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.iteratorAssertion(), null).asString(null));
            Assertions.fail("IteratorAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.iteratorAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.iteratorAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.iteratorAssertion(), null).asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"))).isEqualTo("[val1, val2, val3, val4, val5]");
    }

}
