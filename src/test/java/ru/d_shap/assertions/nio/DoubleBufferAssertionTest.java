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
package ru.d_shap.assertions.nio;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link DoubleBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleBufferAssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleBufferAssertionTest() {
        super();
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).contains(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).contains(2.0);

        try {
            new DoubleBufferAssertion(null, new FailDescription()).contains(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).contains(2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2.0> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).contains(4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4.0> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).contains(3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).contains(3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContains(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContains(2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContains(2.0);

        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContains(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContains(4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4.0> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContains(3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndContains(3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).doesNotContain(3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).doesNotContain(2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).doesNotContain(5.0);

        try {
            new DoubleBufferAssertion(null, new FailDescription()).doesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).doesNotContain(2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).doesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).doesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndDoesNotContain(3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndDoesNotContain(5.0);

        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndDoesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndDoesNotContain(2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndDoesNotContain(2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndDoesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndDoesNotContain(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAll(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsAll(1.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsAll(4.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsAll(Arrays.asList(4.0, 2.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsAll(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsAll(1.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsAll(Arrays.asList(1.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsAll(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsAll(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAll(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).containsAll(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAll(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(1.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(4.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(Arrays.asList(4.0, 2.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsAll(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList(1.0, 2.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsAll(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAll((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAll((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAll();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAll(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsAll(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAll(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndContainsAll(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndContainsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAllInOrder(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(1.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsAllInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAllInOrder(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsAllInOrder(1.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsAllInOrder(Arrays.asList(1.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsAllInOrder(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsAllInOrder(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).containsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAllInOrder(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(1.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsAllInOrder(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(1.0, 2.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAllInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAllInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAllInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAllInOrder(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndContainsAllInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndContainsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactly(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1.0, 2.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1.0, 3.0, 2.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), new FailDescription()).containsExactly();
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), new FailDescription()).containsExactly(new ArrayList<Double>());

        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsExactly(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactly(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactly(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1.0, 3.0, 2.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), new FailDescription()).rewindAndContainsExactly();
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), new FailDescription()).rewindAndContainsExactly(new ArrayList<Double>());
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactly((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactly((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactly(2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactly();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactly(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactlyInOrder(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), new FailDescription()).containsExactlyInOrder();
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), new FailDescription()).containsExactlyInOrder(new ArrayList<Double>());

        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsExactlyInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactlyInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactlyInOrder(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), new FailDescription()).rewindAndContainsExactlyInOrder();
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactlyInOrder((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactlyInOrder(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactlyInOrder();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAny(2.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsAny(2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsAny(4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsAny(5.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).containsAny(Arrays.asList(5.0, 3.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsAny(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsAny(1.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsAny(Arrays.asList(1.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsAny(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsAny(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAny(3.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).containsAny(3.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAny(2.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(5.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(Arrays.asList(5.0, 3.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsAny(1.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList(1.0, 3.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsAny(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAny((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAny((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAny();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAny(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsAny(4.0, 5.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList(4.0, 5.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAny(3.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndContainsAny(3.0, 4.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndContainsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone(3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone(3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone(Arrays.asList(3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsNone(1.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).containsNone(Arrays.asList(1.0, 3.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsNone(4.0, 5.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).containsNone(Arrays.asList(4.0, 5.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).containsNone(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone(3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone(3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone(Arrays.asList(3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsNone(4.0, 5.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList(4.0, 5.0));

        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, new FailDescription()).rewindAndContainsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone((double[]) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone((Iterable<Double>) null);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone(new ArrayList<Double>());
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone(1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsNone(1.0, 3.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList(1.0, 3.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndContainsNone(2.0, 1.0);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).rewindAndContainsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).rewindAndContainsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new DoubleBufferAssertion(null, new FailDescription()).isNull();

        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription()).isNull();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), new FailDescription("Message")).isNull();
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        DoubleBuffer value = createDoubleBuffer(new double[]{1.0, 2.0});
        new DoubleBufferAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new DoubleBufferAssertion(value, new FailDescription()).isSameAs(createDoubleBuffer(new double[]{1.0, 2.0}));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1.0, 2.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(value, new FailDescription("Message")).isSameAs(createDoubleBuffer(new double[]{1.0, 2.0}));
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1.0, 2.0]> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        DoubleBuffer value = createDoubleBuffer(new double[]{1.0, 2.0});
        new DoubleBufferAssertion(value, new FailDescription()).isNotSameAs(createDoubleBuffer(new double[]{1.0, 2.0}));
        new DoubleBufferAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new DoubleBufferAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1.0, 2.0]>.");
        }
        try {
            new DoubleBufferAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("DoubleBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1.0, 2.0]>.");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new DoubleBufferAssertion(null, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new DoubleBufferAssertion(null, new FailDescription()).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new DoubleBufferAssertion(null, new FailDescription()).asString(createDoubleBuffer(new double[]{1.0, 2.0, 3.0}))).isEqualTo("[1.0, 2.0, 3.0]");
        Assertions.assertThat(new DoubleBufferAssertion(null, new FailDescription()).asString(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}))).isEqualTo("[1.0, 2.0, 3.0, 4.0, 5.0]");
        Assertions.assertThat(new DoubleBufferAssertion(null, new FailDescription()).asString(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 2))).isEqualTo("[3.0, 4.0, 5.0]");
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        DoubleBuffer buffer = createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains(4.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains(2.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain(2.0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndDoesNotContain(0);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAll(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAll(2, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAllInOrder(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAllInOrder(2, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactly(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactly(1, 2, 3, 4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactlyInOrder(4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAny(1, 5, 7);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAny(1, 7, 9);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsNone(1, 9);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsNone(7, 9);
        Assertions.assertThat(buffer).hasPosition(3);
    }

    private static DoubleBuffer createDoubleBuffer(final double[] values) {
        return createDoubleBuffer(values, 0);
    }

    private static DoubleBuffer createDoubleBuffer(final double[] values, final int position) {
        return createDoubleBuffer(values, position, values.length);
    }

    private static DoubleBuffer createDoubleBuffer(final double[] values, final int position, final int limit) {
        return createDoubleBuffer(values, position, limit, values.length);
    }

    private static DoubleBuffer createDoubleBuffer(final double[] values, final int position, final int limit, final int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 8);
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        for (double value : values) {
            doubleBuffer.put(value);
        }
        doubleBuffer.position(position);
        doubleBuffer.limit(limit);
        return doubleBuffer;
    }

}
