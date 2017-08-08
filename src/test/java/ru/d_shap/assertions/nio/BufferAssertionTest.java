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
            Assertions.fail("Buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), 0, 4, 4, null).isEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, "Message").isEmpty();
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), 0, 4, 4, null).isRewindAndEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isRewindAndEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isRewindAndEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, "Message").isRewindAndEmpty();
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isNullOrEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isNullOrEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, "Message").isNullOrEmpty();
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[0, 0, 0, 0]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), null).isRewindAndNullOrEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, null).isRewindAndNullOrEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<[1, 2]>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 1, "Message").isRewindAndNullOrEmpty();
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), null).isNotEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, null).isNotEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, 2, 4, null).isNotEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2), 2, 2, 4, "Message").isNotEmpty();
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Buffer assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), null).isRewindAndNotEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new BufferAssertionImpl(new ArrayList<Byte>(), "Message").isRewindAndNotEmpty();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doDoesNotContainTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndDoesNotContainTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAll() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAllInOrderTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAllInOrderTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsExactlyInOrderTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsExactlyInOrderTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsAnyTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsAnyTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doContainsNoneTest() {

    }

    /**
     * {@link BufferAssertion} class test.
     */
    @Test
    public void doRewindAndContainsNoneTest() {

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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toPosition().isEqualTo(4);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").toPosition().isEqualTo(4);
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasPosition(4);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").hasPosition(4);
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toLimit().isEqualTo(4);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").toLimit().isEqualTo(4);
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasLimit(4);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").hasLimit(4);
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).toCapacity().isEqualTo(4);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").toCapacity().isEqualTo(4);
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasCapacity(4);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").hasCapacity(4);
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasProperties(4, 3, 3);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasProperties(3, 4, 3);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, null).hasProperties(3, 3, 4);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 3, "Message").hasProperties(3, 3, 4);
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 0, 3, 3, null).toRemaining().isEqualTo(4);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 0, 3, 3, "Message").toRemaining().isEqualTo(4);
            Assertions.fail("Array assertion test fail");
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
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 0, 3, 3, null).hasRemaining(4);
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new BufferAssertionImpl(Arrays.asList((byte) 1, (byte) 2, (byte) 3), 0, 3, 3, "Message").hasRemaining(4);
            Assertions.fail("Array assertion test fail");
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
            new BufferAssertionImpl(ByteBuffer.allocate(10), null).isDirect();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be direct.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocate(10), "Message").isDirect();
            Assertions.fail("Array assertion test fail");
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
            new BufferAssertionImpl(ByteBuffer.allocateDirect(10), null).isNotDirect();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be direct.");
        }
        try {
            new BufferAssertionImpl(ByteBuffer.allocateDirect(10), "Message").isNotDirect();
            Assertions.fail("Array assertion test fail");
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
            new BufferAssertionImpl(byteBuffer, null).isReadOnly();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be read only.");
        }
        try {
            new BufferAssertionImpl(byteBuffer, "Message").isReadOnly();
            Assertions.fail("Array assertion test fail");
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
            new BufferAssertionImpl(readOnlyBuffer, null).isNotReadOnly();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be read only.");
        }
        try {
            new BufferAssertionImpl(readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("Array assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be read only.");
        }
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
