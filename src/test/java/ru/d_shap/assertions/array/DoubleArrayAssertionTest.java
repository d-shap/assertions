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

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link DoubleArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleArrayAssertionTest {

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
    public void containsTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).contains(1.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).contains(2.0);

        try {
            new DoubleArrayAssertion(null, null).contains(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).contains(3.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").contains(3.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).doesNotContain(3.0);

        try {
            new DoubleArrayAssertion(null, null).doesNotContain(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).doesNotContain(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").doesNotContain(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAll(1.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsAll(1.0, 3.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsAll(4.0, 2.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsAll(Arrays.asList(4.0, 2.0));

        try {
            new DoubleArrayAssertion(null, null).containsAll(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, null).containsAll(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAll((double[]) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAll();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAll((Iterable<Double>) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAll(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAll(2.0, 3.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").containsAll(2.0, 3.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAllInOrder(1.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsAllInOrder(1.0, 3.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));

        try {
            new DoubleArrayAssertion(null, null).containsAllInOrder(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, null).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAllInOrder((double[]) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAllInOrder();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAllInOrder(2.0, 3.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAllInOrder(2.0, 1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").containsAllInOrder(2.0, 1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactly(1.0, 2.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactly(1.0, 2.0, 3.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactly(1.0, 3.0, 2.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        new DoubleArrayAssertion(new double[0], null).containsExactly();
        new DoubleArrayAssertion(new double[0], null).containsExactly(new ArrayList<Double>());

        try {
            new DoubleArrayAssertion(null, null).containsExactly(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, null).containsExactly(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactly((double[]) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactly((Iterable<Double>) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactly(2.0, 3.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactly();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactly(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactlyInOrder(1.0, 2.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        new DoubleArrayAssertion(new double[0], null).containsExactlyInOrder();
        new DoubleArrayAssertion(new double[0], null).containsExactlyInOrder(new ArrayList<Double>());

        try {
            new DoubleArrayAssertion(null, null).containsExactlyInOrder(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, null).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactlyInOrder((double[]) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactlyInOrder();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, "Message").containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAny(2.0, 3.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsAny(2.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsAny(4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsAny(5.0, 3.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, null).containsAny(Arrays.asList(5.0, 3.0));

        try {
            new DoubleArrayAssertion(null, null).containsAny(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, null).containsAny(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAny((double[]) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAny();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAny((Iterable<Double>) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAny(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAny(3.0, 4.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").containsAny(3.0, 4.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone(3.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone(3.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone(Arrays.asList(3.0, 4.0));

        try {
            new DoubleArrayAssertion(null, null).containsNone(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, null).containsNone(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone((double[]) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone((Iterable<Double>) null);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone(new ArrayList<Double>());
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone(1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone(2.0, 1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").containsNone(2.0, 1.0);
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new DoubleArrayAssertion(new double[0], null).createCollectionAssertion().isEmpty();
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).createCollectionAssertion().isNotEmpty();

        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, null).createCollectionAssertion().isEmpty();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1.0, 2.0]>");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, "Message").createCollectionAssertion().isEmpty();
            Assertions.fail("Double array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1.0, 2.0]>");
        }
    }

}
