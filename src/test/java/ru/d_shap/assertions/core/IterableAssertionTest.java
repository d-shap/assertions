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
    public void isEmptyTest() {
        initialize(Raw.iterableAssertion(), new ArrayList<String>(), "Message").isEmpty();
        initialize(Raw.iterableAssertion(), new HashSet<String>(), "Message").isEmpty();

        try {
            initialize(Raw.iterableAssertion(), null, "Message").isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").isEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").isEmpty();
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
        initialize(Raw.iterableAssertion(), new ArrayList<String>(), "Message").isNullOrEmpty();
        initialize(Raw.iterableAssertion(), new HashSet<String>(), "Message").isNullOrEmpty();
        initialize(Raw.iterableAssertion(), null, "Message").isNullOrEmpty();

        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").isNullOrEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").isNullOrEmpty();
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").isNotEmpty();
        initialize(Raw.iterableAssertion(), Arrays.asList("test1", "test2"), "Message").isNotEmpty();

        try {
            initialize(Raw.iterableAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), new ArrayList<String>(), "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.iterableAssertion(), new ArrayList<String>(), "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
        try {
            initialize(Raw.iterableAssertion(), new HashSet<String>(), "Message").isNotEmpty();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.iterableAssertion(), new HashSet<String>(), "Message").isNotEmpty();
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").contains("val1");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").contains("val2");
        initialize(Raw.iterableAssertion(), Arrays.asList(null, "val1", "val2"), "Message").contains(null);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", null, "val2"), "Message").contains(null);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", null, "val2"), "Message").contains(null);

        try {
            initialize(Raw.iterableAssertion(), null, "Message").contains("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").contains("val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").contains(1);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<1> but was:<[val1, val2]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").contains(new StringBuilder("test1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<test1> but was:<[val1, val2]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").contains(new StringBuilder("test1"));
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").doesNotContain("val3");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").doesNotContain(1);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").doesNotContain(new StringBuilder("test1"));
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", null), "Message").doesNotContain("val3");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").doesNotContain(null);

        try {
            initialize(Raw.iterableAssertion(), null, "Message").doesNotContain("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").doesNotContain("val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").doesNotContain("val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").doesNotContain("val2");
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val3");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val3", "val1");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val5", "val1", "val3");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val3", "val5", "val4");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val3", "val1", "val4", "val5", "val2");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsAll("val3", "val1", "val4", null, "val2");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsAll(Arrays.asList("val3", "val1", "val4", null, "val2"));

        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAll("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAll(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAll((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAll((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAll((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAll((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAll();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAll(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val0", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val3");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val3", "val5");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val3", "val4", "val5");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val1", "val1", "val2", "val2"), "Message").containsAllInOrder("val1", "val1", "val1", "val2", "val2");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsAllInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));

        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAllInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAllInOrder((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAllInOrder((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAllInOrder((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAllInOrder((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAllInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAllInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val3", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val1", "val1"), "Message").containsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val1", "val2", "val3");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val2", "val1", "val3");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val2", "val3", "val1");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val3", "val2", "val1");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsExactly("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsExactly("val2", "val4", "val1", "val3", "val5");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsExactly("val2", "val4", "val1", "val3", null);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsExactly(Arrays.asList("val2", "val4", "val1", "val3", null));
        initialize(Raw.iterableAssertion(), new ArrayList<String>(), "Message").containsExactly();
        initialize(Raw.iterableAssertion(), new ArrayList<String>(), "Message").containsExactly(new ArrayList<String>());

        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsExactly("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsExactly(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsExactly((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsExactly((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsExactly((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsExactly((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val2", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly("val2", "val4", "val1");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactly(Arrays.asList("val2", "val4", "val1"));
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val1", "val2", "val3");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsExactlyInOrder("val1", "val2", "val3", "val4", null);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));
        initialize(Raw.iterableAssertion(), new ArrayList<String>(), "Message").containsExactlyInOrder();
        initialize(Raw.iterableAssertion(), new ArrayList<String>(), "Message").containsExactlyInOrder(new ArrayList<String>());

        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsExactlyInOrder("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsExactlyInOrder((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsExactlyInOrder((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsExactlyInOrder((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsExactlyInOrder((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val2", "val3");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsAny("val1", "val3", "val5");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsAny("val6", "val2", "val4");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val7", "val9", "val1", "val5", "val3");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsAny("val7", "val9", null);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", null), "Message").containsAny(Arrays.asList("val7", "val9", null));

        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAny("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAny(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAny((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsAny((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAny((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAny((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAny();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsAny(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsAny("val4", "val5", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny("val8", "val7");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").containsAny(Arrays.asList("val8", "val7"));
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val4", "val5", "val6");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val8", "val4");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", null), "Message").containsNone("val8", "val4");
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", null), "Message").containsNone(Arrays.asList("val8", "val4"));
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val8", null);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone(Arrays.asList("val8", null));

        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsNone("val");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsNone(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsNone((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").containsNone((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsNone((Object[]) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsNone((Iterable<?>) null);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsNone();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2"), "Message").containsNone(new ArrayList<String>());
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val4", "val2");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone("val5", "val4", "val2", "val6");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").containsNone(Arrays.asList("val5", "val4", "val2", "val6"));
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").toSize().isEqualTo(3);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").toSize().isGreaterThan(2);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").toSize().isLessThan(6);

        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").toSize().isEqualTo(5);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").toSize().isGreaterThan(1);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").toSize().isLessThan(9);

        try {
            initialize(Raw.iterableAssertion(), null, "Message").toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").toSize();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").toSize().isEqualTo(4);
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
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").hasSize(3);
        initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3", "val4", "val5"), "Message").hasSize(5);

        try {
            initialize(Raw.iterableAssertion(), null, "Message").hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), null, "Message").hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").hasSize(4);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").hasSize(4);
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
        initialize(Raw.iterableAssertion(), null, "Message").isNull();

        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").isNull();
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), Arrays.asList("val1", "val2", "val3"), "Message").isNull();
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
        initialize(Raw.iterableAssertion(), value, "Message").isSameAs(value);

        try {
            initialize(Raw.iterableAssertion(), value, "Message").isSameAs(Arrays.asList("val1", "val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), value, "Message").isSameAs(Arrays.asList("val1", "val2", "val3"));
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[val1, val2, val3]> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), value, "Message").isSameAs("test");
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
        initialize(Raw.iterableAssertion(), value, "Message").isNotSameAs(Arrays.asList("val1", "val2", "val3"));
        initialize(Raw.iterableAssertion(), value, "Message").isNotSameAs("test");

        try {
            initialize(Raw.iterableAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("IterableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[val1, val2, val3]>.");
        }
        try {
            initialize(Raw.iterableAssertion(), value, "Message").isNotSameAs(value);
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
        try {
            Assertions.assertThat(initialize(Raw.iterableAssertion(), null, "Message").asString(null));
            Assertions.fail("IterableAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.iterableAssertion(), null, "Message").asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.iterableAssertion(), null, "Message").asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.iterableAssertion(), null, "Message").asString(Arrays.asList("val1", "val2", "val3", "val4", "val5"))).isEqualTo("[val1, val2, val3, val4, val5]");
    }

}
