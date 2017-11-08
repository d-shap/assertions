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

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link ArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ArrayAssertionTest {

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
        new ArrayAssertionImpl(new ArrayList<String>(), new FailDescription()).isEmpty();

        try {
            new ArrayAssertionImpl(null, new FailDescription()).isEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription("Message")).isEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).isEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[val1, val2]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription("Message")).isEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[val1, val2]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new ArrayAssertionImpl(new ArrayList<String>(), new FailDescription()).isNullOrEmpty();
        new ArrayAssertionImpl(null, new FailDescription()).isNullOrEmpty();

        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).isNullOrEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[val1, val2]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription("Message")).isNullOrEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[val1, val2]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).isNotEmpty();
        new ArrayAssertionImpl(Arrays.asList("test1", "test2"), new FailDescription()).isNotEmpty();

        try {
            new ArrayAssertionImpl(null, new FailDescription()).isNotEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription("Message")).isNotEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(new ArrayList<String>(), new FailDescription()).isNotEmpty();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new ArrayAssertionImpl(new ArrayList<String>(), new FailDescription("Message")).isNotEmpty();
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
        new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContains("val1");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContains("val2");
        new ArrayAssertionImpl(Arrays.asList(null, "val1", "val2"), new FailDescription()).doContains(null);
        new ArrayAssertionImpl(Arrays.asList("val1", null, "val2"), new FailDescription()).doContains(null);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", null), new FailDescription()).doContains(null);

        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContains("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription("Message")).doContains("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContains("val3");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription("Message")).doContains("val3");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<val3> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doDoesNotContainTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doDoesNotContain("val3");
        new ArrayAssertionImpl(Arrays.asList("val1", null), new FailDescription()).doDoesNotContain("val3");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doDoesNotContain(null);

        try {
            new ArrayAssertionImpl(null, new FailDescription()).doDoesNotContain("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription("Message")).doDoesNotContain("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doDoesNotContain("val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val1> but was:<[val1, val2]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doDoesNotContain("val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription("Message")).doDoesNotContain("val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<val2> but was:<[val1, val2]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsAllTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val1", "val2");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val1", "val3");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val3", "val1");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val5", "val1", "val3");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val3", "val5", "val4");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val3", "val1", "val4", "val5", "val2");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll(Arrays.asList("val3", "val1", "val4", "val5", "val2"));
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsAll("val3", "val1", "val4", null, "val2");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsAll(Arrays.asList("val3", "val1", "val4", null, "val2"));

        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAll("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAll(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAll((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAll((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAll((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAll((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAll();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAll(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val1", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val0", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val0, val1]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val1", "val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val1, val2]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).doContainsAll("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).doContainsAll(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsAllInOrderTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder("val1", "val2");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder("val1", "val3");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder("val1", "val3", "val5");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder("val3", "val4", "val5");
        new ArrayAssertionImpl(Arrays.asList("val1", "val1", "val1", "val2", "val2"), new FailDescription()).doContainsAllInOrder("val1", "val1", "val1", "val2", "val2");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder("val1", "val2", "val3", "val4", "val5");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsAllInOrder("val1", "val2", "val3", "val4", null);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));

        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAllInOrder("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAllInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAllInOrder((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAllInOrder((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAllInOrder((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAllInOrder((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAllInOrder();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAllInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder("val1", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder("val3", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val3, val1]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val1", "val1"), new FailDescription()).doContainsAllInOrder("val1", "val1", "val1", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val1, val1, val1]> but was:<[val1, val1, val1]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).doContainsAllInOrder("val1", "val2", "val3", "val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).doContainsAllInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[val1, val2, val3, val4, val5, val6]> but was:<[val1, val2, val3, val4, val5]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsExactlyTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly("val1", "val2", "val3");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly("val2", "val1", "val3");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly("val2", "val3", "val1");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly("val3", "val2", "val1");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsExactly("val1", "val2", "val3", "val4", "val5");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsExactly("val2", "val4", "val1", "val3", "val5");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsExactly(Arrays.asList("val2", "val4", "val1", "val3", "val5"));
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsExactly("val2", "val4", "val1", "val3", null);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsExactly(Arrays.asList("val2", "val4", "val1", "val3", null));
        new ArrayAssertionImpl(new ArrayList<String>(), new FailDescription()).doContainsExactly();
        new ArrayAssertionImpl(new ArrayList<String>(), new FailDescription()).doContainsExactly(new ArrayList<String>());

        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsExactly("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsExactly(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsExactly((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsExactly((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsExactly((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsExactly((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly("val1", "val2", "val3", "val4");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly("val3", "val2", "val1", "val4");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val3, val2, val1, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly("val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly("val2", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsExactly();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsExactly(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[val1, val2]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly("val2", "val4", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).doContainsExactly("val2", "val4", "val1");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).doContainsExactly(Arrays.asList("val2", "val4", "val1"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[val2, val4, val1]> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsExactlyInOrderTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactlyInOrder("val1", "val2", "val3");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", "val5"));
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsExactlyInOrder("val1", "val2", "val3", "val4", null);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsExactlyInOrder(Arrays.asList("val1", "val2", "val3", "val4", null));
        new ArrayAssertionImpl(new ArrayList<String>(), new FailDescription()).doContainsExactlyInOrder();
        new ArrayAssertionImpl(new ArrayList<String>(), new FailDescription()).doContainsExactlyInOrder(new ArrayList<String>());

        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsExactlyInOrder("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsExactlyInOrder((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsExactlyInOrder((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsExactlyInOrder((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactlyInOrder("val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactlyInOrder("val2", "val3");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val2, val3]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactlyInOrder("val1", "val2", "val4");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactlyInOrder("val1", "val2", "val3", "val4");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val1, val2, val3, val4]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsExactlyInOrder();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsExactlyInOrder(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[val1, val2]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).doContainsExactlyInOrder("val3", "val1", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).doContainsExactlyInOrder(Arrays.asList("val3", "val1", "val2"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[val3, val1, val2]> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsAnyTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsAny("val1", "val3", "val5");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsAny("val6", "val2", "val4");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAny("val7", "val9", "val1", "val5", "val3");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAny(Arrays.asList("val7", "val9", "val1", "val5", "val3"));
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsAny("val7", "val9", null);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", null), new FailDescription()).doContainsAny(Arrays.asList("val7", "val9", null));

        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAny("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAny(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAny((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsAny((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAny((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAny((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAny();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsAny(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsAny("val4", "val5", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val4, val5, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAny("val8", "val7");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).doContainsAny("val8", "val7");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).doContainsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription("Message")).doContainsAny(Arrays.asList("val8", "val7"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[val8, val7]> but was:<[val1, val2, val3, val4, val5]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void doContainsNoneTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsNone("val4", "val5", "val6");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsNone("val8", "val4");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsNone(Arrays.asList("val8", "val4"));
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", null), new FailDescription()).doContainsNone("val8", "val4");
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", null), new FailDescription()).doContainsNone(Arrays.asList("val8", "val4"));
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsNone("val8", "val4", null);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsNone(Arrays.asList("val8", "val4", null));

        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsNone("val");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsNone(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsNone((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription()).doContainsNone((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsNone((String[]) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsNone((Iterable<String>) null);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsNone();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2"), new FailDescription()).doContainsNone(new ArrayList<String>());
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsNone("val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsNone("val4", "val2");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val4, val2]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsNone("val5", "val4", "val2", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).doContainsNone("val5", "val4", "val2", "val6");
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).doContainsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).doContainsNone(Arrays.asList("val5", "val4", "val2", "val6"));
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[val5, val4, val2, val6]> but was:<[val1, val2, val3]>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).toLength().isEqualTo(3);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).toLength().isGreaterThan(2);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).toLength().isLessThan(6);

        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).toLength().isEqualTo(5);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).toLength().isGreaterThan(1);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).toLength().isLessThan(9);

        try {
            new ArrayAssertionImpl(null, new FailDescription()).toLength();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(null, new FailDescription("Message")).toLength();
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).toLength().isEqualTo(4);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).toLength().isEqualTo(4);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value length. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link ArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).hasLength(3);
        new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3", "val4", "val5"), new FailDescription()).hasLength(5);

        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription()).hasLength(4);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new ArrayAssertionImpl(Arrays.asList("val1", "val2", "val3"), new FailDescription("Message")).hasLength(4);
            Assertions.fail("ArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value length. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ArrayAssertionImpl extends ArrayAssertion<String> {

        ArrayAssertionImpl(final List<String> actual, final FailDescription failDescription) {
            super(actual, failDescription);
        }

        @Override
        @SuppressWarnings("unchecked")
        protected List<String> createList(final Object value) {
            List<String> copy = new ArrayList<>();
            copy.addAll((List) value);
            return copy;
        }

        @Override
        protected String asString(final Object value) {
            return value.toString();
        }

    }

}
