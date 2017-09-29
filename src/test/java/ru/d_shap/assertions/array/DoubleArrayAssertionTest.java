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
import ru.d_shap.assertions.FailDescription;

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
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).contains(1.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).contains(2.0);

        try {
            new DoubleArrayAssertion(null, new FailDescription()).contains(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).contains(3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).contains(3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).doesNotContain(3.0);

        try {
            new DoubleArrayAssertion(null, new FailDescription()).doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).doesNotContain(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAll(1.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsAll(1.0, 3.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsAll(4.0, 2.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsAll(Arrays.asList(4.0, 2.0));

        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsAll(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAll((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAll();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAll(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).containsAll(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAllInOrder(1.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsAllInOrder(1.0, 3.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));

        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsAllInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAllInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAllInOrder();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAllInOrder(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactly(1.0, 2.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactly(1.0, 2.0, 3.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactly(1.0, 3.0, 2.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        new DoubleArrayAssertion(new double[0], new FailDescription()).containsExactly();
        new DoubleArrayAssertion(new double[0], new FailDescription()).containsExactly(new ArrayList<Double>());

        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsExactly(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactly((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactly(2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactly();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription("Message")).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription("Message")).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactlyInOrder(1.0, 2.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        new DoubleArrayAssertion(new double[0], new FailDescription()).containsExactlyInOrder();
        new DoubleArrayAssertion(new double[0], new FailDescription()).containsExactlyInOrder(new ArrayList<Double>());

        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsExactlyInOrder(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactlyInOrder();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription("Message")).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription("Message")).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAny(2.0, 3.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsAny(2.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsAny(4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsAny(5.0, 3.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0, 3.0, 4.0}, new FailDescription()).containsAny(Arrays.asList(5.0, 3.0));

        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsAny(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAny((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAny();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAny(3.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).containsAny(3.0, 4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone(3.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone(3.0, 4.0);
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone(Arrays.asList(3.0, 4.0));

        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsNone(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(null, new FailDescription()).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone((double[]) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone(1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).containsNone(2.0, 1.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void createListAssertionTest() {
        new DoubleArrayAssertion(new double[0], new FailDescription()).createListAssertion().isEmpty();
        new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).createListAssertion().isNotEmpty();

        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription()).createListAssertion().isEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1.0, 2.0]>.");
        }
        try {
            new DoubleArrayAssertion(new double[]{1.0, 2.0}, new FailDescription("Message")).createListAssertion().isEmpty();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1.0, 2.0]>.");
        }
    }

}
