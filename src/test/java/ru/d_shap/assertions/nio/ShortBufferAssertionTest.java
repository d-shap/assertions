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
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ShortBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortBufferAssertionTest {

    /**
     * Test class constructor.
     */
    public ShortBufferAssertionTest() {
        super();
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).contains(1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).contains(2);

        try {
            new ShortBufferAssertion(null, null).contains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).contains(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).contains(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).contains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").contains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContains(1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContains(2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContains(2);

        try {
            new ShortBufferAssertion(null, null).rewindAndContains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContains(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).doesNotContain(3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).doesNotContain(2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).doesNotContain(5);

        try {
            new ShortBufferAssertion(null, null).doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).doesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndDoesNotContain(3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndDoesNotContain(5);

        try {
            new ShortBufferAssertion(null, null).rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndDoesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndDoesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll((short) 1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAll((short) 1, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAll((short) 4, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAll(4, 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAll(Arrays.asList((short) 4, (short) 2));

        try {
            new ShortBufferAssertion(null, null).containsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsAll((short) 1, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsAll(1, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsAll(Arrays.asList((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsAll((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsAll(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsAll(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll((short) 1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAll((short) 1, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAll((short) 4, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAll(4, 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAll(Arrays.asList((short) 4, (short) 2));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAll((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAll(1, 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAll(Arrays.asList((short) 1, (short) 2));

        try {
            new ShortBufferAssertion(null, null).rewindAndContainsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAll((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAll(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAll(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder((short) 1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAllInOrder((short) 1, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAllInOrder(1, 3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));

        try {
            new ShortBufferAssertion(null, null).containsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsAllInOrder((short) 1, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsAllInOrder(1, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsAllInOrder(Arrays.asList((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsAllInOrder((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsAllInOrder(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsAllInOrder(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder((short) 1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder((short) 1, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(1, 3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAllInOrder((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAllInOrder(1, 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAllInOrder(Arrays.asList((short) 1, (short) 2));

        try {
            new ShortBufferAssertion(null, null).rewindAndContainsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAllInOrder((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAllInOrder(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactly((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactly(1, 3, 2, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).containsExactly();
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).containsExactly(new int[0]);
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).containsExactly(new ArrayList<Short>());

        try {
            new ShortBufferAssertion(null, null).containsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactly((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactly(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactly((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1, 3, 2, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).rewindAndContainsExactly();
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).rewindAndContainsExactly(new int[0]);
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).rewindAndContainsExactly(new ArrayList<Short>());
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactly(1, 2, 3, 4, 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));

        try {
            new ShortBufferAssertion(null, null).rewindAndContainsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactly((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactly(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactlyInOrder((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactlyInOrder(1, 2, 3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).containsExactlyInOrder();
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).containsExactlyInOrder(new int[0]);
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).containsExactlyInOrder(new ArrayList<Short>());

        try {
            new ShortBufferAssertion(null, null).containsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactlyInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactlyInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactlyInOrder((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).rewindAndContainsExactlyInOrder();
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).rewindAndContainsExactlyInOrder(new int[0]);
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));

        try {
            new ShortBufferAssertion(null, null).rewindAndContainsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactlyInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactlyInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny((short) 2, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAny((short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAny((short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAny((short) 5, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAny(5, 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).containsAny(Arrays.asList((short) 5, (short) 3));

        try {
            new ShortBufferAssertion(null, null).containsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsAny((short) 1, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsAny(1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsAny(Arrays.asList((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsAny((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsAny(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsAny(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny((short) 2, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAny((short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAny((short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAny((short) 5, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAny(5, 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), null).rewindAndContainsAny(Arrays.asList((short) 5, (short) 3));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAny((short) 1, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAny(1, 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsAny(Arrays.asList((short) 1, (short) 3));

        try {
            new ShortBufferAssertion(null, null).rewindAndContainsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAny((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAny(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsAny(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone((short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone((short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone(3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone(Arrays.asList((short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsNone((short) 1, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsNone(1, 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).containsNone(Arrays.asList((short) 1, (short) 3));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsNone((short) 4, (short) 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsNone(4, 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).containsNone(Arrays.asList((short) 4, (short) 5));

        try {
            new ShortBufferAssertion(null, null).containsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone((short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone((short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone(3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone(Arrays.asList((short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsNone((short) 4, (short) 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsNone(4, 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), null).rewindAndContainsNone(Arrays.asList((short) 4, (short) 5));

        try {
            new ShortBufferAssertion(null, null).rewindAndContainsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, null).rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsNone((short) 1, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsNone(1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), null).rewindAndContainsNone(Arrays.asList((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).rewindAndContainsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new ShortBufferAssertion(createShortBuffer(new short[0]), null).createCollectionAssertion(false).isEmpty();
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).createCollectionAssertion(false).isNotEmpty();

        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), null).createCollectionAssertion(false).isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), "Message").createCollectionAssertion(false).isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        ShortBuffer buffer = createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3);
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

    private static ShortBuffer createShortBuffer(final short[] values) {
        return createShortBuffer(values, 0);
    }

    private static ShortBuffer createShortBuffer(final short[] values, final int position) {
        return createShortBuffer(values, position, values.length);
    }

    private static ShortBuffer createShortBuffer(final short[] values, final int position, final int limit) {
        return createShortBuffer(values, position, limit, values.length);
    }

    private static ShortBuffer createShortBuffer(final short[] values, final int position, final int limit, final int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 2);
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        for (short value : values) {
            shortBuffer.put(value);
        }
        shortBuffer.position(position);
        shortBuffer.limit(limit);
        return shortBuffer;
    }

}
