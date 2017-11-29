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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link DoubleArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleArrayAssertionTest() {
        super();
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.doubleArrayAssertion(), new double[0]);

        try {
            initialize(Raw.doubleArrayAssertion(), new Object());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new Object(), "Message");
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).contains(1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).contains(2.0);

        try {
            Raw.doubleArrayAssertion().contains(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).contains(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).contains(3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").contains(3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).doesNotContain(3.0);

        try {
            Raw.doubleArrayAssertion().doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(1.0, 2.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(1.0, 3.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(4.0, 2.0);

        try {
            Raw.doubleArrayAssertion().containsAll(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAll(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(Arrays.asList(1.0, 3.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAll(Arrays.asList(4.0, 2.0));

        try {
            Raw.doubleArrayAssertion().containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(1.0, 2.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAllInOrder(1.0, 3.0, 4.0);

        try {
            Raw.doubleArrayAssertion().containsAllInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));

        try {
            Raw.doubleArrayAssertion().containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(1.0, 2.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 3.0, 2.0, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[0]).containsExactly();

        try {
            Raw.doubleArrayAssertion().containsExactly(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[0]).containsExactly(new ArrayList<Double>());

        try {
            Raw.doubleArrayAssertion().containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(1.0, 2.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[0]).containsExactlyInOrder();

        try {
            Raw.doubleArrayAssertion().containsExactlyInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(Arrays.asList(1.0, 2.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[0]).containsExactlyInOrder(new ArrayList<Double>());

        try {
            Raw.doubleArrayAssertion().containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(2.0, 3.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(2.0, 4.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(4.0, 1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(5.0, 3.0);

        try {
            Raw.doubleArrayAssertion().containsAny(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(3.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAny(3.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(Arrays.asList(2.0, 3.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(Arrays.asList(2.0, 4.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(Arrays.asList(4.0, 1.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0, 3.0, 4.0}).containsAny(Arrays.asList(5.0, 3.0));

        try {
            Raw.doubleArrayAssertion().containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(3.0, 7.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(3.0, 4.0, 5.0);

        try {
            Raw.doubleArrayAssertion().containsNone(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsNone(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(Arrays.asList(3.0, 7.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(Arrays.asList(3.0, 4.0, 5.0));

        try {
            Raw.doubleArrayAssertion().containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.doubleArrayAssertion(), null).isNull();

        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).isNull();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").isNull();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        double[] value = new double[]{1.0, 2.0};
        initialize(Raw.doubleArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.doubleArrayAssertion(), value).isSameAs(new double[]{1.0, 2.0});
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), value, "Message").isSameAs(new double[]{1.0, 2.0});
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1.0, 2.0]> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), value).isSameAs("test");
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        double[] value = new double[]{1.0, 2.0};
        initialize(Raw.doubleArrayAssertion(), value).isNotSameAs(new double[]{1.0, 2.0});
        initialize(Raw.doubleArrayAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.doubleArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1.0, 2.0]>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.doubleArrayAssertion(), null).asString(null));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.doubleArrayAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.doubleArrayAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.doubleArrayAssertion(), null).asString(new double[]{1.0, 2.0})).isEqualTo("[1.0, 2.0]");
    }

}
