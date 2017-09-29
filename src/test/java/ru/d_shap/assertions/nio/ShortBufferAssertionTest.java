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
import ru.d_shap.assertions.FailDescription;

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
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).contains(1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).contains(2);

        try {
            new ShortBufferAssertion(null, new FailDescription()).contains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).contains(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).contains(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).contains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).contains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContains(1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContains(2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContains(2);

        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContains(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).doesNotContain(3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).doesNotContain(2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).doesNotContain(5);

        try {
            new ShortBufferAssertion(null, new FailDescription()).doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).doesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndDoesNotContain(3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndDoesNotContain(5);

        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndDoesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndDoesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll((short) 1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAll((short) 1, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAll((short) 4, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAll(4, 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAll(Arrays.asList((short) 4, (short) 2));

        try {
            new ShortBufferAssertion(null, new FailDescription()).containsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAll((short) 1, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAll(1, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAll(Arrays.asList((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAll((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAll(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAll(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll((short) 1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll((short) 1, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll((short) 4, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(4, 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAll(Arrays.asList((short) 4, (short) 2));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAll((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAll(1, 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList((short) 1, (short) 2));

        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAll((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAll(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder((short) 1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder((short) 1, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(1, 3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));

        try {
            new ShortBufferAssertion(null, new FailDescription()).containsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAllInOrder((short) 1, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAllInOrder(1, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAllInOrder(Arrays.asList((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAllInOrder((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAllInOrder(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAllInOrder(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((short) 1);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder((short) 1, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(1, 3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAllInOrder((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAllInOrder(1, 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList((short) 1, (short) 2));

        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactly((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1, 3, 2, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).containsExactly();
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).containsExactly(new int[0]);
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).containsExactly(new ArrayList<Short>());

        try {
            new ShortBufferAssertion(null, new FailDescription()).containsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactly((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactly(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactly((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1, 3, 2, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).rewindAndContainsExactly();
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).rewindAndContainsExactly(new int[0]);
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).rewindAndContainsExactly(new ArrayList<Short>());
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactly(1, 2, 3, 4, 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));

        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactly((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactly(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactlyInOrder((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).containsExactlyInOrder();
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).containsExactlyInOrder(new int[0]);
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).containsExactlyInOrder(new ArrayList<Short>());

        try {
            new ShortBufferAssertion(null, new FailDescription()).containsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactlyInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactlyInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((short) 1, (short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).rewindAndContainsExactlyInOrder();
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new int[0]);
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));

        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny((short) 2, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAny((short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAny((short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAny((short) 5, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAny(5, 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).containsAny(Arrays.asList((short) 5, (short) 3));

        try {
            new ShortBufferAssertion(null, new FailDescription()).containsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAny((short) 1, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAny(1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsAny(Arrays.asList((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAny((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAny(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsAny(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny((short) 2, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny((short) 2);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny((short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny((short) 5, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(5, 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4}), new FailDescription()).rewindAndContainsAny(Arrays.asList((short) 5, (short) 3));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAny((short) 1, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAny(1, 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList((short) 1, (short) 3));

        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAny((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAny(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone((short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone((short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone(3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone(Arrays.asList((short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsNone((short) 1, (short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsNone(1, 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).containsNone(Arrays.asList((short) 1, (short) 3));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsNone((short) 4, (short) 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsNone(4, 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).containsNone(Arrays.asList((short) 4, (short) 5));

        try {
            new ShortBufferAssertion(null, new FailDescription()).containsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone((short) 3);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone((short) 3, (short) 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone(3, 4);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone(Arrays.asList((short) 3, (short) 4));
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsNone((short) 4, (short) 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsNone(4, 5);
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList((short) 4, (short) 5));

        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(null, new FailDescription()).rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsNone((short) 1, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsNone(1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).rewindAndContainsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).rewindAndContainsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new ShortBufferAssertion(createShortBuffer(new short[0]), new FailDescription()).createCollectionAssertion(false).isEmpty();
        new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).createCollectionAssertion(false).isNotEmpty();

        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription()).createCollectionAssertion(false).isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>.");
        }
        try {
            new ShortBufferAssertion(createShortBuffer(new short[]{1, 2}), new FailDescription("Message")).createCollectionAssertion(false).isEmpty();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>.");
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
