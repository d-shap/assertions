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
import ru.d_shap.assertions.FailDescription;

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
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).contains(1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).contains(2);

        try {
            new ByteBufferAssertion(null, new FailDescription()).contains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).contains(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).contains(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).contains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).contains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContains(1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContains(2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContains(2);

        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContains(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContains(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContains(3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).doesNotContain(3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).doesNotContain(2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).doesNotContain(5);

        try {
            new ByteBufferAssertion(null, new FailDescription()).doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).doesNotContain(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).doesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndDoesNotContain(3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndDoesNotContain(5);

        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndDoesNotContain(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndDoesNotContain(2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndDoesNotContain(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll((byte) 1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAll((byte) 1, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAll((byte) 4, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAll(4, 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAll(Arrays.asList((byte) 4, (byte) 2));

        try {
            new ByteBufferAssertion(null, new FailDescription()).containsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAll((byte) 1, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAll(1, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAll(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAll((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAll(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAll(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll((byte) 1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll((byte) 1, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll((byte) 4, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(4, 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(Arrays.asList((byte) 4, (byte) 2));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAll((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAll(1, 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList((byte) 1, (byte) 2));

        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsAll((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsAll(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAll((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAll(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsAll(2, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder((byte) 1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder((byte) 1, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(1, 3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(Arrays.asList((byte) 1, (byte) 3, (byte) 4));

        try {
            new ByteBufferAssertion(null, new FailDescription()).containsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAllInOrder((byte) 1, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAllInOrder(1, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAllInOrder(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAllInOrder((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAllInOrder(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAllInOrder(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((byte) 1);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder((byte) 1, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(1, 3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAllInOrder((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAllInOrder(1, 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2));

        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactly((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactly((byte) 1, (byte) 3, (byte) 2, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1, 3, 2, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).containsExactly();
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).containsExactly(new int[0]);
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).containsExactly(new ArrayList<Byte>());

        try {
            new ByteBufferAssertion(null, new FailDescription()).containsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactly((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactly(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactly((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly((byte) 1, (byte) 3, (byte) 2, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1, 3, 2, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).rewindAndContainsExactly();
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).rewindAndContainsExactly(new int[0]);
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).rewindAndContainsExactly(new ArrayList<Byte>());
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactly(1, 2, 3, 4, 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));

        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsExactly((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactly((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactly((byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactly();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactly(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).containsExactlyInOrder();
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).containsExactlyInOrder(new int[0]);
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).containsExactlyInOrder(new ArrayList<Byte>());

        try {
            new ByteBufferAssertion(null, new FailDescription()).containsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactlyInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactlyInOrder(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).rewindAndContainsExactlyInOrder();
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new int[0]);
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));

        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny((byte) 2, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAny((byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAny((byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAny((byte) 5, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAny(5, 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).containsAny(Arrays.asList((byte) 5, (byte) 3));

        try {
            new ByteBufferAssertion(null, new FailDescription()).containsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAny((byte) 1, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAny(1, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAny(Arrays.asList((byte) 1, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAny((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAny(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAny(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny((byte) 2, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny((byte) 2);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny((byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny((byte) 5, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(5, 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(Arrays.asList((byte) 5, (byte) 3));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAny((byte) 1, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAny(1, 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList((byte) 1, (byte) 3));

        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsAny((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsAny(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAny((byte) 4, (byte) 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAny(4, 5);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList((byte) 4, (byte) 5));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsAny(3, 4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone((byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone((byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone(3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone(Arrays.asList((byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsNone((byte) 1, (byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsNone(1, 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsNone(Arrays.asList((byte) 1, (byte) 3));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsNone((byte) 4, (byte) 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsNone(4, 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsNone(Arrays.asList((byte) 4, (byte) 5));

        try {
            new ByteBufferAssertion(null, new FailDescription()).containsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone((byte) 3);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone((byte) 3, (byte) 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone(3, 4);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone(Arrays.asList((byte) 3, (byte) 4));
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsNone((byte) 4, (byte) 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsNone(4, 5);
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList((byte) 4, (byte) 5));

        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsNone(1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(null, new FailDescription()).rewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone((byte[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone((int[]) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone((Iterable<Byte>) null);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone(new int[0]);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone((byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsNone((byte) 1, (byte) 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsNone(1, 3);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList((byte) 1, (byte) 3));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsNone(2, 1);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).rewindAndContainsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).rewindAndContainsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new ByteBufferAssertion(createByteBuffer(new byte[0]), new FailDescription()).createCollectionAssertion(false).isEmpty();
        new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).createCollectionAssertion(false).isNotEmpty();

        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription()).createCollectionAssertion(false).isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>.");
        }
        try {
            new ByteBufferAssertion(createByteBuffer(new byte[]{1, 2}), new FailDescription("Message")).createCollectionAssertion(false).isEmpty();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>.");
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
