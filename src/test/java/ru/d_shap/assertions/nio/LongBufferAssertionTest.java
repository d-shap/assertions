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
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link LongBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongBufferAssertionTest {

    /**
     * Test class constructor.
     */
    public LongBufferAssertionTest() {
        super();
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).contains(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).contains(2L);

        try {
            new LongBufferAssertion(null, null).contains(1L);
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).contains(2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).contains(4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).contains(3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").contains(3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContains(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContains(2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContains(2L);

        try {
            new LongBufferAssertion(null, null).rewindAndContains(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContains(4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContains(3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContains(3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).doesNotContain(3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).doesNotContain(2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).doesNotContain(5L);

        try {
            new LongBufferAssertion(null, null).doesNotContain(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).doesNotContain(2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).doesNotContain(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").doesNotContain(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndDoesNotContain(3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndDoesNotContain(5L);

        try {
            new LongBufferAssertion(null, null).rewindAndDoesNotContain(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndDoesNotContain(2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndDoesNotContain(2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndDoesNotContain(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndDoesNotContain(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAll(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsAll(1L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsAll(4L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsAll(Arrays.asList(4L, 2L));

        try {
            new LongBufferAssertion(null, null).containsAll(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).containsAll(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAll((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAll((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAll();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAll(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsAll(1L, 2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsAll(Arrays.asList(1L, 2L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsAll(4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsAll(Arrays.asList(4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAll(2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").containsAll(2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAll(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsAll(1L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsAll(4L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsAll(Arrays.asList(4L, 2L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsAll(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsAll(Arrays.asList(1L, 2L));

        try {
            new LongBufferAssertion(null, null).rewindAndContainsAll(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAll((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAll((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAll();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsAll(4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsAll(Arrays.asList(4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAll(2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll(2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAll(Arrays.asList(2L, 3L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAll(Arrays.asList(2L, 3L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAllInOrder(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsAllInOrder(1L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsAllInOrder(Arrays.asList(1L, 3L, 4L));

        try {
            new LongBufferAssertion(null, null).containsAllInOrder(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAllInOrder((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAllInOrder();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAllInOrder(2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsAllInOrder(1L, 2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsAllInOrder(Arrays.asList(1L, 2L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsAllInOrder(4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsAllInOrder(Arrays.asList(4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAllInOrder(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAllInOrder(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(1L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(Arrays.asList(1L, 3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsAllInOrder(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsAllInOrder(Arrays.asList(1L, 2L));

        try {
            new LongBufferAssertion(null, null).rewindAndContainsAllInOrder(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAllInOrder((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAllInOrder((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAllInOrder();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAllInOrder(2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsAllInOrder(4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsAllInOrder(Arrays.asList(4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAllInOrder(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactly(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactly(1L, 2L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactly(1L, 3L, 2L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[0]), null).containsExactly();
        new LongBufferAssertion(createLongBuffer(new long[0]), null).containsExactly(new ArrayList<Long>());

        try {
            new LongBufferAssertion(null, null).containsExactly(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).containsExactly(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactly((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactly((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactly(2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactly();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactly(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), "Message").containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactly(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1L, 2L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1L, 3L, 2L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[0]), null).rewindAndContainsExactly();
        new LongBufferAssertion(createLongBuffer(new long[0]), null).rewindAndContainsExactly(new ArrayList<Long>());
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));

        try {
            new LongBufferAssertion(null, null).rewindAndContainsExactly(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).rewindAndContainsExactly(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactly((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactly((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactly(2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactly();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactly(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactlyInOrder(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactlyInOrder(1L, 2L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[0]), null).containsExactlyInOrder();
        new LongBufferAssertion(createLongBuffer(new long[0]), null).containsExactlyInOrder(new ArrayList<Long>());

        try {
            new LongBufferAssertion(null, null).containsExactlyInOrder(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactlyInOrder((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactlyInOrder(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactlyInOrder();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactlyInOrder(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[0]), null).rewindAndContainsExactlyInOrder();
        new LongBufferAssertion(createLongBuffer(new long[0]), null).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));

        try {
            new LongBufferAssertion(null, null).rewindAndContainsExactlyInOrder(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactlyInOrder((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactlyInOrder(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactlyInOrder();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAny(2L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsAny(2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsAny(4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsAny(5L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).containsAny(Arrays.asList(5L, 3L));

        try {
            new LongBufferAssertion(null, null).containsAny(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).containsAny(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAny((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAny((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAny();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAny(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsAny(1L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsAny(Arrays.asList(1L, 3L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsAny(4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsAny(Arrays.asList(4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAny(3L, 4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").containsAny(3L, 4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAny(2L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsAny(2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsAny(4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsAny(5L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), null).rewindAndContainsAny(Arrays.asList(5L, 3L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsAny(1L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsAny(Arrays.asList(1L, 3L));

        try {
            new LongBufferAssertion(null, null).rewindAndContainsAny(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAny((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAny((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAny();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsAny(4L, 5L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsAny(Arrays.asList(4L, 5L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAny(3L, 4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny(3L, 4L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsAny(Arrays.asList(3L, 4L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsAny(Arrays.asList(3L, 4L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone(3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone(3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone(Arrays.asList(3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsNone(1L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).containsNone(Arrays.asList(1L, 3L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsNone(4L, 5L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).containsNone(Arrays.asList(4L, 5L));

        try {
            new LongBufferAssertion(null, null).containsNone(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).containsNone(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").containsNone(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone(3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone(3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone(Arrays.asList(3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsNone(4L, 5L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), null).rewindAndContainsNone(Arrays.asList(4L, 5L));

        try {
            new LongBufferAssertion(null, null).rewindAndContainsNone(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, null).rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone((long[]) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone((Iterable<Long>) null);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone(1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsNone(1L, 3L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), null).rewindAndContainsNone(Arrays.asList(1L, 3L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone(2L, 1L);
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).rewindAndContainsNone(Arrays.asList(2L, 1L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").rewindAndContainsNone(Arrays.asList(2L, 1L));
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new LongBufferAssertion(createLongBuffer(new long[0]), null).createCollectionAssertion(false).isEmpty();
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).createCollectionAssertion(false).isNotEmpty();

        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), null).createCollectionAssertion(false).isEmpty();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), "Message").createCollectionAssertion(false).isEmpty();
            Assertions.fail("Double buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        LongBuffer buffer = createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains(4L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains(2L);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain(2L);
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

    private static LongBuffer createLongBuffer(final long[] values) {
        return createLongBuffer(values, 0);
    }

    private static LongBuffer createLongBuffer(final long[] values, final int position) {
        return createLongBuffer(values, position, values.length);
    }

    private static LongBuffer createLongBuffer(final long[] values, final int position, final int limit) {
        return createLongBuffer(values, position, limit, values.length);
    }

    private static LongBuffer createLongBuffer(final long[] values, final int position, final int limit, final int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 8);
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        for (long value : values) {
            longBuffer.put(value);
        }
        longBuffer.position(position);
        longBuffer.limit(limit);
        return longBuffer;
    }

}
