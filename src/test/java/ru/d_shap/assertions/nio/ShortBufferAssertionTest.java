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

import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ShortBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortBufferAssertionTest extends AssertionTest {

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
    public void actualValueValidatorTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0]));

        try {
            initialize(Raw.shortBufferAssertion(), new Object());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), new Object(), "Message");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).contains(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).contains(2);

        try {
            initialize(Raw.shortBufferAssertion(), null).contains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).contains(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).contains(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).contains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").contains(3);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContains(1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContains(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContains(2);

        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContains(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContains(4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContains(3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContains(3);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).doesNotContain(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).doesNotContain(2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(5);

        try {
            initialize(Raw.shortBufferAssertion(), null).doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).doesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).doesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").doesNotContain(1);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndDoesNotContain(3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(5);

        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndDoesNotContain(2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndDoesNotContain(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndDoesNotContain(1);
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll((short) 1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll((short) 1, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll((short) 4, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(4, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAll(Arrays.asList((short) 4, (short) 2));

        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll((short) 1, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll(1, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAll(Arrays.asList((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAll(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAll(Arrays.asList((short) 2, (short) 3));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll((short) 1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll((short) 1, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll((short) 4, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(4, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAll(Arrays.asList((short) 4, (short) 2));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAll(Arrays.asList((short) 1, (short) 2));

        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAll(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll(2, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAll(Arrays.asList((short) 2, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAll(Arrays.asList((short) 2, (short) 3));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((short) 1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAllInOrder((short) 1, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAllInOrder(1, 3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));

        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder((short) 1, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(1, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAllInOrder(Arrays.asList((short) 1, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAllInOrder(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAllInOrder(Arrays.asList((short) 2, (short) 1));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((short) 1);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAllInOrder((short) 1, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(1, 3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAllInOrder(Arrays.asList((short) 1, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(1, 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAllInOrder(Arrays.asList((short) 1, (short) 2));

        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAllInOrder(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAllInOrder(Arrays.asList((short) 2, (short) 1));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(1, 3, 2, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).containsExactly();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).containsExactly(new int[0]);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).containsExactly(new ArrayList<Short>());

        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 3, (short) 2, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 3, 2, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 3, (short) 2, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).rewindAndContainsExactly();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).rewindAndContainsExactly(new int[0]);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).rewindAndContainsExactly(new ArrayList<Short>());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));

        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly((short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactly(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly((short) 1, (short) 1, (short) 3, (short) 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(1, 1, 3, 2);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactly(Arrays.asList((short) 1, (short) 1, (short) 3, (short) 2));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).containsExactlyInOrder();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).containsExactlyInOrder(new int[0]);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).containsExactlyInOrder(new ArrayList<Short>());

        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").containsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder((short) 1, (short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).rewindAndContainsExactlyInOrder();
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).rewindAndContainsExactlyInOrder(new int[0]);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[0])).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));

        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsExactlyInOrder(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder((short) 2, (short) 3, (short) 1, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList((short) 2, (short) 3, (short) 1, (short) 4));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny((short) 2, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny((short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny((short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny((short) 5, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(5, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).containsAny(Arrays.asList((short) 5, (short) 3));

        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny((short) 1, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny(1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsAny(Arrays.asList((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsAny(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsAny(Arrays.asList((short) 3, (short) 4));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny((short) 2, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny((short) 2);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny((short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny((short) 5, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(5, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4})).rewindAndContainsAny(Arrays.asList((short) 5, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny((short) 1, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(1, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsAny(Arrays.asList((short) 1, (short) 3));

        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny((short) 4, (short) 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(4, 5);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsAny(Arrays.asList((short) 4, (short) 5));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny((short) 3, (short) 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny(3, 4);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsAny(Arrays.asList((short) 3, (short) 4));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsAny(Arrays.asList((short) 3, (short) 4));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(Arrays.asList((short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsNone((short) 1, (short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsNone(1, 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).containsNone(Arrays.asList((short) 1, (short) 3));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsNone((short) 4, (short) 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(4, 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).containsNone(Arrays.asList((short) 4, (short) 5));

        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).containsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").containsNone(Arrays.asList((short) 2, (short) 1));
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
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((short) 3);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((short) 3, (short) 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(3, 4);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(Arrays.asList((short) 3, (short) 4));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone((short) 4, (short) 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(4, 5);
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).rewindAndContainsNone(Arrays.asList((short) 4, (short) 5));

        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone(1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((short[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((int[]) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((Iterable<Short>) null);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(new int[0]);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(new ArrayList<Short>());
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone((short) 1, (short) 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(1, 3);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).rewindAndContainsNone(Arrays.asList((short) 1, (short) 3));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone((short) 2, (short) 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone(2, 1);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).rewindAndContainsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").rewindAndContainsNone(Arrays.asList((short) 2, (short) 1));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.shortBufferAssertion(), null).isNull();

        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNull();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").isNull();
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        ShortBuffer value = createShortBuffer(new short[]{1, 2});
        initialize(Raw.shortBufferAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.shortBufferAssertion(), value).isSameAs(createShortBuffer(new short[]{1, 2}));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), value, "Message").isSameAs(createShortBuffer(new short[]{1, 2}));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), value).isSameAs("test");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        ShortBuffer value = createShortBuffer(new short[]{1, 2});
        initialize(Raw.shortBufferAssertion(), value).isNotSameAs(createShortBuffer(new short[]{1, 2}));
        initialize(Raw.shortBufferAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.shortBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.shortBufferAssertion(), null).asString(null));
            Assertions.fail("ShortBufferAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.shortBufferAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.shortBufferAssertion(), null).asString(createShortBuffer(new short[]{1, 2, 3}))).isEqualTo("[1, 2, 3]");
        Assertions.assertThat(initialize(Raw.shortBufferAssertion(), null).asString(createShortBuffer(new short[]{1, 2, 3, 4, 5}))).isEqualTo("[1, 2, 3, 4, 5]");
        Assertions.assertThat(initialize(Raw.shortBufferAssertion(), null).asString(createShortBuffer(new short[]{1, 2, 3, 4, 5}, 2))).isEqualTo("[3, 4, 5]");
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

}
