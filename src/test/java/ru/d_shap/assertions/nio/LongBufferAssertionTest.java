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
import ru.d_shap.assertions.FailDescription;

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
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).contains(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).contains(2L);

        try {
            new LongBufferAssertion(null, new FailDescription()).contains(1L);
            Assertions.fail("Long buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).contains(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).contains(4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).contains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).contains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContains(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContains(2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContains(2L);

        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContains(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContains(4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndContains(3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).doesNotContain(3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).doesNotContain(2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).doesNotContain(5L);

        try {
            new LongBufferAssertion(null, new FailDescription()).doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).doesNotContain(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).doesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndDoesNotContain(3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndDoesNotContain(5L);

        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndDoesNotContain(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndDoesNotContain(2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndDoesNotContain(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAll(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsAll(1L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsAll(4L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsAll(Arrays.asList(4L, 2L));

        try {
            new LongBufferAssertion(null, new FailDescription()).containsAll(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).containsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsAll(1L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsAll(Arrays.asList(1L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsAll(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsAll(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).containsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).containsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAll(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(1L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(4L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(Arrays.asList(4L, 2L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsAll(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList(1L, 2L));

        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsAll(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAll((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAll((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAll();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAll(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsAll(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndContainsAll(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndContainsAll(Arrays.asList(2L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAllInOrder(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(1L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(Arrays.asList(1L, 3L, 4L));

        try {
            new LongBufferAssertion(null, new FailDescription()).containsAllInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAllInOrder(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsAllInOrder(1L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsAllInOrder(Arrays.asList(1L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsAllInOrder(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsAllInOrder(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).containsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).containsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAllInOrder(1L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(1L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(1L, 3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsAllInOrder(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(1L, 2L));

        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAllInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAllInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAllInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAllInOrder(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndContainsAllInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndContainsAllInOrder(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactly(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1L, 2L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1L, 3L, 2L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[0]), new FailDescription()).containsExactly();
        new LongBufferAssertion(createLongBuffer(new long[0]), new FailDescription()).containsExactly(new ArrayList<Long>());

        try {
            new LongBufferAssertion(null, new FailDescription()).containsExactly(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactly(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactly(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1L, 2L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1L, 3L, 2L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1L, 3L, 2L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[0]), new FailDescription()).rewindAndContainsExactly();
        new LongBufferAssertion(createLongBuffer(new long[0]), new FailDescription()).rewindAndContainsExactly(new ArrayList<Long>());
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));

        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactly((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactly((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactly(2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactly();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactly(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsExactly(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(1L, 1L, 3L, 2L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(Arrays.asList(1L, 1L, 3L, 2L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactlyInOrder(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1L, 2L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[0]), new FailDescription()).containsExactlyInOrder();
        new LongBufferAssertion(createLongBuffer(new long[0]), new FailDescription()).containsExactlyInOrder(new ArrayList<Long>());

        try {
            new LongBufferAssertion(null, new FailDescription()).containsExactlyInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactlyInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactlyInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactlyInOrder(1L, 2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[0]), new FailDescription()).rewindAndContainsExactlyInOrder();
        new LongBufferAssertion(createLongBuffer(new long[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));

        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactlyInOrder((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactlyInOrder((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactlyInOrder(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1L, 2L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactlyInOrder();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1L, 2L, 3L, 4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(1L, 2L, 3L, 4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(2L, 3L, 1L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(Arrays.asList(2L, 3L, 1L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAny(2L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsAny(2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsAny(4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsAny(5L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).containsAny(Arrays.asList(5L, 3L));

        try {
            new LongBufferAssertion(null, new FailDescription()).containsAny(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).containsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsAny(1L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsAny(Arrays.asList(1L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsAny(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsAny(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).containsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).containsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAny(2L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(2L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(5L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(Arrays.asList(5L, 3L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsAny(1L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList(1L, 3L));

        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsAny(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAny((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAny((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAny();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAny(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsAny(4L, 5L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList(4L, 5L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndContainsAny(3L, 4L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndContainsAny(Arrays.asList(3L, 4L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone(3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone(3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone(Arrays.asList(3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsNone(1L, 3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).containsNone(Arrays.asList(1L, 3L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsNone(4L, 5L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).containsNone(Arrays.asList(4L, 5L));

        try {
            new LongBufferAssertion(null, new FailDescription()).containsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).containsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).containsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).containsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone(3L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone(3L, 4L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone(Arrays.asList(3L, 4L));
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsNone(4L, 5L);
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList(4L, 5L));

        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(null, new FailDescription()).rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone((long[]) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone((Iterable<Long>) null);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone(new ArrayList<Long>());
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone(1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsNone(1L, 3L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList(1L, 3L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndContainsNone(2L, 1L);
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).rewindAndContainsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).rewindAndContainsNone(Arrays.asList(2L, 1L));
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new LongBufferAssertion(createLongBuffer(new long[0]), new FailDescription()).createCollectionAssertion(false).isEmpty();
        new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).createCollectionAssertion(false).isNotEmpty();

        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription()).createCollectionAssertion(false).isEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>.");
        }
        try {
            new LongBufferAssertion(createLongBuffer(new long[]{1L, 2L}), new FailDescription("Message")).createCollectionAssertion(false).isEmpty();
            Assertions.fail("LongBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>.");
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
