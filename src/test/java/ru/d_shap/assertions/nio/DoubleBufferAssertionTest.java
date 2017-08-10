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
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).contains(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).contains(2.0);

        try {
            new DoubleBufferAssertion(null, null).contains(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).contains(2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2.0> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).contains(4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).contains(3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").contains(3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContains(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContains(2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContains(2.0);

        try {
            new DoubleBufferAssertion(null, null).rewindAndContains(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContains(4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContains(3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContains(3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).doesNotContain(3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).doesNotContain(2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).doesNotContain(5.0);

        try {
            new DoubleBufferAssertion(null, null).doesNotContain(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).doesNotContain(2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).doesNotContain(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").doesNotContain(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndDoesNotContain(3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndDoesNotContain(5.0);

        try {
            new DoubleBufferAssertion(null, null).rewindAndDoesNotContain(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndDoesNotContain(2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndDoesNotContain(2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2.0> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndDoesNotContain(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndDoesNotContain(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1.0> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAll(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsAll(1.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsAll(4.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsAll(Arrays.asList(4.0, 2.0));

        try {
            new DoubleBufferAssertion(null, null).containsAll(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).containsAll(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAll((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAll((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAll();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAll(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsAll(1.0, 2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsAll(Arrays.asList(1.0, 2.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsAll(4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsAll(Arrays.asList(4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAll(2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAll(2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAll(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsAll(1.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsAll(4.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsAll(Arrays.asList(4.0, 2.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsAll(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsAll(Arrays.asList(1.0, 2.0));

        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsAll(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsAll(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAll((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAll((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAll();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAll(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsAll(4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsAll(Arrays.asList(4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAll(2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAll(2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAll(Arrays.asList(2.0, 3.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAllInOrder(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsAllInOrder(1.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));

        try {
            new DoubleBufferAssertion(null, null).containsAllInOrder(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAllInOrder((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAllInOrder((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAllInOrder();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAllInOrder(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAllInOrder(2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsAllInOrder(1.0, 2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsAllInOrder(Arrays.asList(1.0, 2.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1.0, 2.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsAllInOrder(4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsAllInOrder(Arrays.asList(4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAllInOrder(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAllInOrder(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAllInOrder(1.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(1.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(Arrays.asList(1.0, 3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsAllInOrder(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsAllInOrder(Arrays.asList(1.0, 2.0));

        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsAllInOrder(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsAllInOrder(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAllInOrder((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAllInOrder((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAllInOrder();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAllInOrder(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAllInOrder(2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsAllInOrder(4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsAllInOrder(Arrays.asList(4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAllInOrder(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAllInOrder(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactly(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactly(1.0, 2.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactly(1.0, 3.0, 2.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), null).containsExactly();
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), null).containsExactly(new ArrayList<Double>());

        try {
            new DoubleBufferAssertion(null, null).containsExactly(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).containsExactly(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactly((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactly((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactly(2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactly();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactly(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").containsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactly(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1.0, 3.0, 2.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList(1.0, 3.0, 2.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), null).rewindAndContainsExactly();
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), null).rewindAndContainsExactly(new ArrayList<Double>());
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsExactly(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsExactly(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactly((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactly((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactly(2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2.0, 3.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactly();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactly(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsExactly(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1.0, 1.0, 3.0, 2.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList(1.0, 1.0, 3.0, 2.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1.0, 1.0, 3.0, 2.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactlyInOrder(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), null).containsExactlyInOrder();
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), null).containsExactlyInOrder(new ArrayList<Double>());

        try {
            new DoubleBufferAssertion(null, null).containsExactlyInOrder(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactlyInOrder((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactlyInOrder(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactlyInOrder();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactlyInOrder(1.0, 2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), null).rewindAndContainsExactlyInOrder();
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), null).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsExactlyInOrder(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactlyInOrder((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactlyInOrder((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactlyInOrder(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactlyInOrder();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsExactlyInOrder(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsExactlyInOrder(1.0, 2.0, 3.0, 4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1.0, 2.0, 3.0, 4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2.0, 3.0, 1.0, 4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2.0, 3.0, 1.0, 4.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2.0, 3.0, 1.0, 4.0]> but was:<[1.0, 2.0, 3.0, 4.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAny(2.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsAny(2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsAny(4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsAny(5.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).containsAny(Arrays.asList(5.0, 3.0));

        try {
            new DoubleBufferAssertion(null, null).containsAny(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).containsAny(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAny((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAny((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAny();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAny(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsAny(1.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsAny(Arrays.asList(1.0, 3.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsAny(4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsAny(Arrays.asList(4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAny(3.0, 4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAny(3.0, 4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAny(2.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsAny(2.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsAny(4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsAny(5.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1, 2, 3, 4}), null).rewindAndContainsAny(Arrays.asList(5.0, 3.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsAny(1.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsAny(Arrays.asList(1.0, 3.0));

        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsAny(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsAny(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAny((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAny((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAny();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAny(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsAny(4.0, 5.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsAny(Arrays.asList(4.0, 5.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4.0, 5.0]> but was:<[1.0, 2.0, 3.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAny(3.0, 4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAny(3.0, 4.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsAny(Arrays.asList(3.0, 4.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3.0, 4.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone(3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone(3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone(Arrays.asList(3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsNone(1.0, 3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).containsNone(Arrays.asList(1.0, 3.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsNone(4.0, 5.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).containsNone(Arrays.asList(4.0, 5.0));

        try {
            new DoubleBufferAssertion(null, null).containsNone(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).containsNone(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsNone(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").containsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone(3.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone(3.0, 4.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone(Arrays.asList(3.0, 4.0));
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsNone(4.0, 5.0);
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 0, 3), null).rewindAndContainsNone(Arrays.asList(4.0, 5.0));

        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsNone(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(null, null).rewindAndContainsNone(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone((double[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone((Iterable<Double>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone(new ArrayList<Double>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone(1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsNone(1.0, 3.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}, 3), null).rewindAndContainsNone(Arrays.asList(1.0, 3.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1.0, 3.0]> but was:<[1.0, 2.0, 3.0, 4.0, 5.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsNone(2.0, 1.0);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).rewindAndContainsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").rewindAndContainsNone(Arrays.asList(2.0, 1.0));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2.0, 1.0]> but was:<[1.0, 2.0]>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new DoubleBufferAssertion(createDoubleBuffer(new double[0]), null).createCollectionAssertion(false).isEmpty();
        new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).createCollectionAssertion(false).isNotEmpty();

        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), null).createCollectionAssertion(false).isEmpty();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1.0, 2.0]>");
        }
        try {
            new DoubleBufferAssertion(createDoubleBuffer(new double[]{1.0, 2.0}), "Message").createCollectionAssertion(false).isEmpty();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1.0, 2.0]>");
        }
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
