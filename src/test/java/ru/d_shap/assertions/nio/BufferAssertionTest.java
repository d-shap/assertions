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
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link BufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BufferAssertionTest {

    /**
     * Test class constructor.
     */
    public BufferAssertionTest() {
        super();
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new BufferAssertionImpl(new ArrayList<Byte>(), null).isEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, null).isEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, 2, 4, null).isEmpty();

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), 0, 4, 4, null).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, "Message").isEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        new BufferAssertionImpl(new ArrayList<Byte>(), null).isRewindAndEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, 0, null).isRewindAndEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, 0, 4, null).isRewindAndEmpty();

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), 0, 4, 4, null).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, "Message").isRewindAndEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new BufferAssertionImpl(new ArrayList<Byte>(), null).isNullOrEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, null).isNullOrEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, 2, 4, null).isNullOrEmpty();
        new BufferAssertionImpl((ByteBuffer) null, null).isNullOrEmpty();

        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), 0, 4, 4, null).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, "Message").isNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        new BufferAssertionImpl(new ArrayList<Byte>(), null).isRewindAndNullOrEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, 0, null).isRewindAndNullOrEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, 0, 4, null).isRewindAndNullOrEmpty();
        new BufferAssertionImpl((ByteBuffer) null, null).isRewindAndNullOrEmpty();

        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), 0, 4, 4, null).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, "Message").isRewindAndNullOrEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isNotEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isNotEmpty();
        new BufferAssertionImpl(new ArrayList<Byte>(), 0, 4, 4, null).isNotEmpty();

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), null).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, null).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, 2, 4, null).isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, 2, 4, "Message").isNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isRewindAndNotEmptyTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isRewindAndNotEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isRewindAndNotEmpty();
        new BufferAssertionImpl(new ArrayList<Byte>(), 0, 4, 4, null).isRewindAndNotEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, null).isRewindAndNotEmpty();
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, 2, 4, null).isRewindAndNotEmpty();

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).isRewindAndNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), null).isRewindAndNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), "Message").isRewindAndNotEmpty();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doContains((byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doContains((byte) 2);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContains((byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doContains(null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).doContains((byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<1> but was:<[2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, 1, null).doContains((byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[1]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doContains((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, "Message").doContains((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doRewindAndContains((byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doRewindAndContains((byte) 2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).doRewindAndContains((byte) 1);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContains((byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doRewindAndContains(null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, 1, null).doRewindAndContains((byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[1]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doRewindAndContains((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, "Message").doRewindAndContains((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doDoesNotContainTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doDoesNotContain((byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).doDoesNotContain((byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, 1, null).doDoesNotContain((byte) 2);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doDoesNotContain((byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doDoesNotContain(null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doDoesNotContain((byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doDoesNotContain((byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, "Message").doDoesNotContain((byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<2> but was:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndDoesNotContainTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doRewindAndDoesNotContain((byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, 1, null).doRewindAndDoesNotContain((byte) 2);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndDoesNotContain((byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doRewindAndDoesNotContain(null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doRewindAndDoesNotContain((byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).doRewindAndDoesNotContain((byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, null).doRewindAndDoesNotContain((byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 0, "Message").doRewindAndDoesNotContain((byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<2> but was:<[1, 2]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 1, (byte) 2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 1, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 3, (byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 5, (byte) 1, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 3, (byte) 5, (byte) 4);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 3, (byte) 1, (byte) 4, (byte) 5, (byte) 2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll(Arrays.asList((byte) 3, (byte) 1, (byte) 4, (byte) 5, (byte) 2));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsAll((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsAll(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAll((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAll();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAll((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAll(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 1, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 0, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[0, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 1, (byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 1, 2]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doContainsAll((byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doContainsAll((byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doContainsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAll(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doContainsAll(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAllTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 1, (byte) 2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 1, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 3, (byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 5, (byte) 1, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 3, (byte) 5, (byte) 4);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 3, (byte) 1, (byte) 4, (byte) 5, (byte) 2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll(Arrays.asList((byte) 3, (byte) 1, (byte) 4, (byte) 5, (byte) 2));
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsAll((byte) 3, (byte) 4);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsAll(Arrays.asList((byte) 3, (byte) 4));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsAll((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAll((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAll();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAll((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAll(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 1, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 0, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[0, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 1, (byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 1, 2]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doRewindAndContainsAll((byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doRewindAndContainsAll((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAll(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doRewindAndContainsAll(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllInOrderTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder((byte) 1, (byte) 2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder((byte) 1, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder((byte) 1, (byte) 3, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder((byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 1, (byte) 1, (byte) 2, (byte) 2), null).doContainsAllInOrder((byte) 1, (byte) 1, (byte) 1, (byte) 2, (byte) 2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsAllInOrder((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAllInOrder((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAllInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder((byte) 1, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder((byte) 3, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 1, (byte) 1), null).doContainsAllInOrder((byte) 1, (byte) 1, (byte) 1, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 1, 1, 1]> but was:<[1, 1, 1]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doContainsAllInOrder((byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doContainsAllInOrder((byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doContainsAllInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAllInOrderTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder((byte) 1, (byte) 2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder((byte) 1, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder((byte) 1, (byte) 3, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder((byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 1, (byte) 1, (byte) 2, (byte) 2), null).doRewindAndContainsAllInOrder((byte) 1, (byte) 1, (byte) 1, (byte) 2, (byte) 2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsAllInOrder((byte) 3, (byte) 4);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsAllInOrder(Arrays.asList((byte) 3, (byte) 4));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsAllInOrder((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAllInOrder((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAllInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder((byte) 1, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder((byte) 3, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 1]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 1, (byte) 1), null).doRewindAndContainsAllInOrder((byte) 1, (byte) 1, (byte) 1, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 1, 1, 1]> but was:<[1, 1, 1]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doRewindAndContainsAllInOrder((byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doRewindAndContainsAllInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doRewindAndContainsAllInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[1, 2, 3, 4, 5, 6]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly((byte) 1, (byte) 2, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly((byte) 2, (byte) 1, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly((byte) 2, (byte) 3, (byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly((byte) 3, (byte) 2, (byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsExactly((byte) 2, (byte) 4, (byte) 1, (byte) 3, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsExactly(Arrays.asList((byte) 2, (byte) 4, (byte) 1, (byte) 3, (byte) 5));
        new BufferAssertionImpl(new ArrayList<Byte>(), null).doContainsExactly();
        new BufferAssertionImpl(new ArrayList<Byte>(), null).doContainsExactly(new ArrayList<Byte>());

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsExactly((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsExactly(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsExactly((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsExactly((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly((byte) 3, (byte) 2, (byte) 1, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[3, 2, 1, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly((byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly((byte) 2, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 1]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsExactly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsExactly(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly((byte) 2, (byte) 4, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doContainsExactly((byte) 2, (byte) 4, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactly(Arrays.asList((byte) 2, (byte) 4, (byte) 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doContainsExactly(Arrays.asList((byte) 2, (byte) 4, (byte) 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly((byte) 2, (byte) 1, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly((byte) 2, (byte) 3, (byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly((byte) 3, (byte) 2, (byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsExactly((byte) 2, (byte) 4, (byte) 1, (byte) 3, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsExactly(Arrays.asList((byte) 2, (byte) 4, (byte) 1, (byte) 3, (byte) 5));
        new BufferAssertionImpl(new ArrayList<Byte>(), null).doRewindAndContainsExactly();
        new BufferAssertionImpl(new ArrayList<Byte>(), null).doRewindAndContainsExactly(new ArrayList<Byte>());
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsExactly((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsExactly((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsExactly((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly((byte) 3, (byte) 2, (byte) 1, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[3, 2, 1, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly((byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly((byte) 2, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 1]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsExactly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsExactly(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doRewindAndContainsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly((byte) 2, (byte) 4, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doRewindAndContainsExactly((byte) 2, (byte) 4, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactly(Arrays.asList((byte) 2, (byte) 4, (byte) 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doRewindAndContainsExactly(Arrays.asList((byte) 2, (byte) 4, (byte) 1));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[2, 4, 1]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyInOrderTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        new BufferAssertionImpl(new ArrayList<Byte>(), null).doContainsExactlyInOrder();
        new BufferAssertionImpl(new ArrayList<Byte>(), null).doContainsExactlyInOrder(new ArrayList<Byte>());

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsExactlyInOrder((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsExactlyInOrder((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactlyInOrder((byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactlyInOrder((byte) 2, (byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsExactlyInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactlyInOrder((byte) 3, (byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doContainsExactlyInOrder((byte) 3, (byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsExactlyInOrder(Arrays.asList((byte) 3, (byte) 1, (byte) 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doContainsExactlyInOrder(Arrays.asList((byte) 3, (byte) 1, (byte) 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyInOrderTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        new BufferAssertionImpl(new ArrayList<Byte>(), null).doRewindAndContainsExactlyInOrder();
        new BufferAssertionImpl(new ArrayList<Byte>(), null).doRewindAndContainsExactlyInOrder(new ArrayList<Byte>());
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsExactlyInOrder((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsExactlyInOrder((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactlyInOrder((byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactlyInOrder((byte) 2, (byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsExactlyInOrder();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doRewindAndContainsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactlyInOrder((byte) 3, (byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doRewindAndContainsExactlyInOrder((byte) 3, (byte) 1, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsExactlyInOrder(Arrays.asList((byte) 3, (byte) 1, (byte) 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doRewindAndContainsExactlyInOrder(Arrays.asList((byte) 3, (byte) 1, (byte) 2));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[3, 1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAnyTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsAny((byte) 1, (byte) 3, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsAny((byte) 6, (byte) 2, (byte) 4);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAny((byte) 7, (byte) 9, (byte) 1, (byte) 5, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAny(Arrays.asList((byte) 7, (byte) 9, (byte) 1, (byte) 5, (byte) 3));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsAny((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsAny(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAny((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAny();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAny((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsAny(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsAny((byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5, 6]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doContainsAny((byte) 3, (byte) 1);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 1]> but was:<[4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doContainsAny((byte) 4, (byte) 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAny((byte) 8, (byte) 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doContainsAny((byte) 8, (byte) 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doContainsAny(Arrays.asList((byte) 8, (byte) 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doContainsAny(Arrays.asList((byte) 8, (byte) 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAnyTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsAny((byte) 1, (byte) 3, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsAny((byte) 6, (byte) 2, (byte) 4);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAny((byte) 7, (byte) 9, (byte) 1, (byte) 5, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAny(Arrays.asList((byte) 7, (byte) 9, (byte) 1, (byte) 5, (byte) 3));
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsAny((byte) 3, (byte) 1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsAny(Arrays.asList((byte) 3, (byte) 1));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsAny((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAny((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAny();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAny((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsAny(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsAny((byte) 4, (byte) 5, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5, 6]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doRewindAndContainsAny((byte) 4, (byte) 5);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAny((byte) 8, (byte) 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doRewindAndContainsAny((byte) 8, (byte) 7);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), null).doRewindAndContainsAny(Arrays.asList((byte) 8, (byte) 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), "Message").doRewindAndContainsAny(Arrays.asList((byte) 8, (byte) 7));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[8, 7]> but was:<[1, 2, 3, 4, 5]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsNoneTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsNone((byte) 4, (byte) 5, (byte) 6);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsNone((byte) 8, (byte) 4);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsNone(Arrays.asList((byte) 8, (byte) 4));
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doContainsNone((byte) 1, (byte) 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doContainsNone(Arrays.asList((byte) 1, (byte) 3));
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doContainsNone((byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doContainsNone(Arrays.asList((byte) 4, (byte) 5));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsNone((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doContainsNone(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsNone((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsNone();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsNone((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doContainsNone(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsNone((byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsNone((byte) 4, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[4, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsNone((byte) 5, (byte) 4, (byte) 2, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doContainsNone((byte) 5, (byte) 4, (byte) 2, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doContainsNone(Arrays.asList((byte) 5, (byte) 4, (byte) 2, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doContainsNone(Arrays.asList((byte) 5, (byte) 4, (byte) 2, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsNoneTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsNone((byte) 4, (byte) 5, (byte) 6);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsNone((byte) 8, (byte) 4);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsNone(Arrays.asList((byte) 8, (byte) 4));
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doRewindAndContainsNone((byte) 4, (byte) 5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 0, 3, null).doRewindAndContainsNone(Arrays.asList((byte) 4, (byte) 5));

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsNone((byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl((ByteBuffer) null, null).doRewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsNone((Byte[]) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsNone();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsNone((Iterable<Byte>) null);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).doRewindAndContainsNone(new ArrayList<Byte>());
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsNone((byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsNone((byte) 4, (byte) 2);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[4, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), 3, null).doRewindAndContainsNone((byte) 1, (byte) 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsNone((byte) 5, (byte) 4, (byte) 2, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doRewindAndContainsNone((byte) 5, (byte) 4, (byte) 2, (byte) 6);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), null).doRewindAndContainsNone(Arrays.asList((byte) 5, (byte) 4, (byte) 2, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), "Message").doRewindAndContainsNone(Arrays.asList((byte) 5, (byte) 4, (byte) 2, (byte) 6));
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[5, 4, 2, 6]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toPosition().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toPosition().isGreaterThan(2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toPosition().isLessThan(6);

        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, null).toPosition().isEqualTo(1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, null).toPosition().isGreaterThan(0);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, null).toPosition().isLessThan(4);

        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).toPosition().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).toPosition().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).toPosition().isLessThan(5);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).toPosition();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toPosition().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").toPosition().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasPosition(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, null).hasPosition(1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).hasPosition(3);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).hasPosition(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasPosition(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").hasPosition(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toLimit().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toLimit().isGreaterThan(2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toLimit().isLessThan(6);

        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 1, null).toLimit().isEqualTo(1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 1, null).toLimit().isGreaterThan(0);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 1, null).toLimit().isLessThan(4);

        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).toLimit().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).toLimit().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).toLimit().isLessThan(5);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).toLimit();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toLimit().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").toLimit().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasLimit(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 1, null).hasLimit(1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).hasLimit(3);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).hasLimit(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasLimit(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").hasLimit(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toCapacity().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toCapacity().isGreaterThan(2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toCapacity().isLessThan(6);

        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 1, null).toCapacity().isEqualTo(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 1, null).toCapacity().isGreaterThan(2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 1, null).toCapacity().isLessThan(6);

        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).toCapacity().isEqualTo(5);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).toCapacity().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).toCapacity().isLessThan(7);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).toCapacity();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toCapacity().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").toCapacity().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasCapacity(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 1, null).hasCapacity(3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).hasCapacity(5);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).hasCapacity(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasCapacity(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").hasCapacity(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasProperties(3, 3, 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, null).hasProperties(1, 3, 3);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 3, 5, null).hasProperties(3, 3, 5);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).hasProperties(3, 3, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasProperties(4, 3, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasProperties(3, 4, 3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasProperties(3, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").hasProperties(3, 3, 4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toRemaining().isEqualTo(0);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toRemaining().isGreaterThan(-1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toRemaining().isLessThan(3);

        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 3, null).toRemaining().isEqualTo(2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 3, null).toRemaining().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 3, null).toRemaining().isLessThan(5);

        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 2, 5, null).toRemaining().isEqualTo(0);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 2, 5, null).toRemaining().isGreaterThan(-1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 2, 5, null).toRemaining().isLessThan(3);

        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 2, 4, 5, null).toRemaining().isEqualTo(2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 2, 4, 5, null).toRemaining().isGreaterThan(1);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 2, 4, 5, null).toRemaining().isLessThan(5);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).toRemaining();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 0, 3, 3, null).toRemaining().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 0, 3, 3, "Message").toRemaining().isEqualTo(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasRemaining(0);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 1, 3, null).hasRemaining(2);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 4, 2, 5, null).hasRemaining(0);
        new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 2, 4, 5, null).hasRemaining(2);

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).hasRemaining(3);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 0, 3, 3, null).hasRemaining(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 0, 3, 3, "Message").hasRemaining(4);
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        new BufferAssertionImpl(ByteBuffer.allocateDirect(10), null).isDirect();

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocate(10), null).isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be direct.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocate(10), "Message").isDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be direct.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        new BufferAssertionImpl(ByteBuffer.allocate(10), null).isNotDirect();

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocateDirect(10), null).isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be direct.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocateDirect(10), "Message").isNotDirect();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be direct.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        new BufferAssertionImpl(readOnlyBuffer, null).isReadOnly();

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(byteBuffer, null).isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be read only.");
        }
        try {
            new BufferAssertionImpl(byteBuffer, "Message").isReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be read only.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        new BufferAssertionImpl(byteBuffer, null).isNotReadOnly();

        try {
            new BufferAssertionImpl((ByteBuffer) null, null).isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(readOnlyBuffer, null).isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be read only.");
        }
        try {
            new BufferAssertionImpl(readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("BufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be read only.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new BufferAssertionImpl((ByteBuffer) null, null).asString(null)).isNull();
        Assertions.assertThat(new BufferAssertionImpl((ByteBuffer) null, null).asString(ByteBuffer.allocate(10))).isNull();
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BufferAssertionImpl extends ByteBufferAssertion {

        BufferAssertionImpl(final List<Byte> actual, final String message) {
            this(actual, 0, message);
        }

        BufferAssertionImpl(final List<Byte> actual, final int position, final String message) {
            this(actual, position, getSize(actual), message);
        }

        BufferAssertionImpl(final List<Byte> actual, final int position, final int limit, final String message) {
            this(actual, position, limit, getSize(actual), message);
        }

        BufferAssertionImpl(final List<Byte> actual, final int position, final int limit, final int capacity, final String message) {
            this(createByteBuffer(actual, position, limit, capacity), message);
        }

        BufferAssertionImpl(final ByteBuffer byteBuffer, final String message) {
            super(byteBuffer, message);
        }

        private static ByteBuffer createByteBuffer(final List<Byte> actual, final int position, final int limit, final int capacity) {
            if (actual == null) {
                return null;
            } else {
                ByteBuffer byteBuffer = ByteBuffer.allocate(capacity);
                for (Byte value : actual) {
                    byteBuffer.put(value);
                }
                byteBuffer.position(position);
                byteBuffer.limit(limit);
                return byteBuffer;
            }
        }

        private static int getSize(final List<Byte> actual) {
            if (actual == null) {
                return 0;
            } else {
                return actual.size();
            }
        }

    }

}
