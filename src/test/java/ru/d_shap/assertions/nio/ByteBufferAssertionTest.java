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
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ByteBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferAssertionTest {

    /**
     * Test class constructor.
     */
    public ByteBufferAssertionTest() {
        super();
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).contains(1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).contains(2);

        try {
            new ByteBufferAssertion(null, null).contains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).contains(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).contains(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).contains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").contains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContains(1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContains(2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContains(2);

        try {
            new ByteBufferAssertion(null, null).rewindAndContains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContains(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).doesNotContain(3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).doesNotContain(2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).doesNotContain(5);

        try {
            new ByteBufferAssertion(null, null).doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).doesNotContain(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndDoesNotContain(3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndDoesNotContain(5);

        try {
            new ByteBufferAssertion(null, null).rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndDoesNotContain(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndDoesNotContain(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll((byte) 1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAll((byte) 1, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAll((byte) 4, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAll(4, 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAll(Arrays.asList((byte) 4, (byte) 2));

        try {
            new ByteBufferAssertion(null, null).containsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsAll((byte) 1, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsAll(1, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsAll(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsAll((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsAll(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsAll(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll((byte) 1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAll((byte) 1, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAll((byte) 4, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAll(4, 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAll(Arrays.asList((byte) 4, (byte) 2));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAll((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAll(1, 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAll(Arrays.asList((byte) 1, (byte) 2));

        try {
            new ByteBufferAssertion(null, null).rewindAndContainsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAll((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAll(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAll(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder((byte) 1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAllInOrder((byte) 1, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAllInOrder(1, 3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAllInOrder(Arrays.asList((byte) 1, (byte) 3, (byte) 4));

        try {
            new ByteBufferAssertion(null, null).containsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsAllInOrder((byte) 1, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsAllInOrder(1, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsAllInOrder(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsAllInOrder((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsAllInOrder(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsAllInOrder(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder((byte) 1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder((byte) 1, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(1, 3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAllInOrder((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAllInOrder(1, 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2));

        try {
            new ByteBufferAssertion(null, null).rewindAndContainsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAllInOrder((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAllInOrder(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactly((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactly((byte) 1, (byte) 3, (byte) 2, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactly(1, 3, 2, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).containsExactly();
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).containsExactly(new int[0]);
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).containsExactly(new ArrayList<Byte>());

        try {
            new ByteBufferAssertion(null, null).containsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactly((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactly(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactly((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactly((byte) 1, (byte) 3, (byte) 2, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1, 3, 2, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).rewindAndContainsExactly();
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).rewindAndContainsExactly(new int[0]);
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).rewindAndContainsExactly(new ArrayList<Byte>());
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactly(1, 2, 3, 4, 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));

        try {
            new ByteBufferAssertion(null, null).rewindAndContainsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactly((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactly(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactlyInOrder((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactlyInOrder(1, 2, 3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).containsExactlyInOrder();
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).containsExactlyInOrder(new int[0]);
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).containsExactlyInOrder(new ArrayList<Byte>());

        try {
            new ByteBufferAssertion(null, null).containsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactlyInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactlyInOrder(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).rewindAndContainsExactlyInOrder();
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).rewindAndContainsExactlyInOrder(new int[0]);
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));

        try {
            new ByteBufferAssertion(null, null).rewindAndContainsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactlyInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactlyInOrder(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny((byte) 2, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAny((byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAny((byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAny((byte) 5, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAny(5, 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).containsAny(Arrays.asList((byte) 5, (byte) 3));

        try {
            new ByteBufferAssertion(null, null).containsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsAny((byte) 1, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsAny(1, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsAny(Arrays.asList((byte) 1, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsAny((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsAny(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsAny(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny((byte) 2, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAny((byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAny((byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAny((byte) 5, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAny(5, 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), null).rewindAndContainsAny(Arrays.asList((byte) 5, (byte) 3));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAny((byte) 1, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAny(1, 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAny(Arrays.asList((byte) 1, (byte) 3));

        try {
            new ByteBufferAssertion(null, null).rewindAndContainsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAny((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAny(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAny(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone((byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone((byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone(3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone(Arrays.asList((byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsNone((byte) 1, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsNone(1, 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).containsNone(Arrays.asList((byte) 1, (byte) 3));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsNone((byte) 4, (byte) 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsNone(4, 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).containsNone(Arrays.asList((byte) 4, (byte) 5));

        try {
            new ByteBufferAssertion(null, null).containsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone((byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone((byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone(3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone(Arrays.asList((byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsNone((byte) 4, (byte) 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsNone(4, 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsNone(Arrays.asList((byte) 4, (byte) 5));

        try {
            new ByteBufferAssertion(null, null).rewindAndContainsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, null).rewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsNone((byte) 1, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsNone(1, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsNone(Arrays.asList((byte) 1, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).rewindAndContainsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").rewindAndContainsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[0]), null).createCollectionAssertion(false).isEmpty();
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).createCollectionAssertion(false).isNotEmpty();

        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), null).createCollectionAssertion(false).isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), "Message").createCollectionAssertion(false).isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        ByteBuffer buffer = createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3);
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

    private static ByteBuffer createByteBuffer(final byte[] values) {
        return createByteBuffer(values, 0);
    }

    private static ByteBuffer createByteBuffer(final byte[] values, final int position) {
        return createByteBuffer(values, position, values.length);
    }

    private static ByteBuffer createByteBuffer(final byte[] values, final int position, final int limit) {
        return createByteBuffer(values, position, limit, values.length);
    }

    private static ByteBuffer createByteBuffer(final byte[] values, final int position, final int limit, final int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
        for (byte value : values) {
            byteBuffer.put(value);
        }
        byteBuffer.position(position);
        byteBuffer.limit(limit);
        return byteBuffer;
    }

}
