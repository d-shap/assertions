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
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link IntBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntBufferAssertionTest {

    /**
     * Test class constructor.
     */
    public IntBufferAssertionTest() {
        super();
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).contains(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).contains(2);

        try {
            new IntBufferAssertion(null, null).contains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).contains(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).contains(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).contains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").contains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContains(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContains(2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContains(2);

        try {
            new IntBufferAssertion(null, null).rewindAndContains(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContains(4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndContains(3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).doesNotContain(3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).doesNotContain(2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).doesNotContain(5);

        try {
            new IntBufferAssertion(null, null).doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).doesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").doesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndDoesNotContain(3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndDoesNotContain(5);

        try {
            new IntBufferAssertion(null, null).rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndDoesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndDoesNotContain(2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndDoesNotContain(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAll(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsAll(1, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsAll(4, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsAll(Arrays.asList(4, 2));

        try {
            new IntBufferAssertion(null, null).containsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsAll(1, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsAll(Arrays.asList(1, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsAll(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsAll(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").containsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").containsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAll(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsAll(1, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsAll(4, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsAll(Arrays.asList(4, 2));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAll(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAll(Arrays.asList(1, 2));

        try {
            new IntBufferAssertion(null, null).rewindAndContainsAll(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).rewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAll((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAll();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAll(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAll(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAll(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAll(Arrays.asList(2, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAllInOrder(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsAllInOrder(1, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsAllInOrder(Arrays.asList(1, 3, 4));

        try {
            new IntBufferAssertion(null, null).containsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAllInOrder(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsAllInOrder(1, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsAllInOrder(Arrays.asList(1, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsAllInOrder(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsAllInOrder(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").containsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAllInOrder(1);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(1, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(Arrays.asList(1, 3, 4));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAllInOrder(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAllInOrder(Arrays.asList(1, 2));

        try {
            new IntBufferAssertion(null, null).rewindAndContainsAllInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).rewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAllInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAllInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAllInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAllInOrder(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAllInOrder(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactly(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactly(1, 2, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactly(1, 3, 2, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList(1, 3, 2, 4));
        new IntBufferAssertion(createIntBuffer(new int[0]), null).containsExactly();
        new IntBufferAssertion(createIntBuffer(new int[0]), null).containsExactly(new ArrayList<Integer>());

        try {
            new IntBufferAssertion(null, null).containsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactly(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactly(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1, 2, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1, 3, 2, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList(1, 3, 2, 4));
        new IntBufferAssertion(createIntBuffer(new int[0]), null).rewindAndContainsExactly();
        new IntBufferAssertion(createIntBuffer(new int[0]), null).rewindAndContainsExactly(new ArrayList<Integer>());
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactly(1, 2, 3, 4, 5);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new IntBufferAssertion(null, null).rewindAndContainsExactly(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).rewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactly((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactly(2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactly();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactly(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactly(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList(1, 1, 3, 2));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactlyInOrder(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactlyInOrder(1, 2, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        new IntBufferAssertion(createIntBuffer(new int[0]), null).containsExactlyInOrder();
        new IntBufferAssertion(createIntBuffer(new int[0]), null).containsExactlyInOrder(new ArrayList<Integer>());

        try {
            new IntBufferAssertion(null, null).containsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactlyInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactlyInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactlyInOrder(1, 2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4));
        new IntBufferAssertion(createIntBuffer(new int[0]), null).rewindAndContainsExactlyInOrder();
        new IntBufferAssertion(createIntBuffer(new int[0]), null).rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));

        try {
            new IntBufferAssertion(null, null).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactlyInOrder((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactlyInOrder(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1, 2, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactlyInOrder();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsExactlyInOrder(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList(1, 2, 3, 4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2, 3, 1, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAny(2, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsAny(2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsAny(4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsAny(5, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).containsAny(Arrays.asList(5, 3));

        try {
            new IntBufferAssertion(null, null).containsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsAny(1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsAny(Arrays.asList(1, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsAny(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsAny(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").containsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").containsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAny(2, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsAny(2);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsAny(4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsAny(5, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4}), null).rewindAndContainsAny(Arrays.asList(5, 3));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAny(1, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAny(Arrays.asList(1, 3));

        try {
            new IntBufferAssertion(null, null).rewindAndContainsAny(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).rewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAny((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAny();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAny(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAny(4, 5);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAny(Arrays.asList(4, 5));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny(3, 4);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsAny(Arrays.asList(3, 4));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone(3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone(3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone(Arrays.asList(3, 4));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsNone(1, 3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).containsNone(Arrays.asList(1, 3));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsNone(4, 5);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).containsNone(Arrays.asList(4, 5));

        try {
            new IntBufferAssertion(null, null).containsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").containsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").containsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone(3);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone(3, 4);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone(Arrays.asList(3, 4));
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsNone(4, 5);
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsNone(Arrays.asList(4, 5));

        try {
            new IntBufferAssertion(null, null).rewindAndContainsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(null, null).rewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone((Iterable<Integer>) null);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone(new ArrayList<Integer>());
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone(1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsNone(1, 3);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsNone(Arrays.asList(1, 3));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone(2, 1);
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).rewindAndContainsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").rewindAndContainsNone(Arrays.asList(2, 1));
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new IntBufferAssertion(createIntBuffer(new int[0]), null).createCollectionAssertion(false).isEmpty();
        new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).createCollectionAssertion(false).isNotEmpty();

        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), null).createCollectionAssertion(false).isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new IntBufferAssertion(createIntBuffer(new int[]{1, 2}), "Message").createCollectionAssertion(false).isEmpty();
            Assertions.fail("IntBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        IntBuffer buffer = createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains(4);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains(2);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain(2);
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

    private static IntBuffer createIntBuffer(final int[] values) {
        return createIntBuffer(values, 0);
    }

    private static IntBuffer createIntBuffer(final int[] values, final int position) {
        return createIntBuffer(values, position, values.length);
    }

    private static IntBuffer createIntBuffer(final int[] values, final int position, final int limit) {
        return createIntBuffer(values, position, limit, values.length);
    }

    private static IntBuffer createIntBuffer(final int[] values, final int position, final int limit, final int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 4);
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        for (int value : values) {
            intBuffer.put(value);
        }
        intBuffer.position(position);
        intBuffer.limit(limit);
        return intBuffer;
    }

}
