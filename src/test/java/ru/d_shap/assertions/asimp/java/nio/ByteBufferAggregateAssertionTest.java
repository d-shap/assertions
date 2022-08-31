///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.asimp.java.nio;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ByteBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteBufferAggregateAssertionTest() {
        super();
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toMin().isNull();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).toMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).toMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).toMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).toMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).toMin().isEqualTo(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).toMin().isEqualTo(2);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).toMin().isEqualTo(15);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toMin().isEqualTo(1);

        try {
            Raw.byteBufferAssertion().toMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toMin()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toMin()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).toMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").toMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{})).toRewindAndMin().isNull();
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{10, 1, 15, 25})).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100})).toRewindAndMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, 100, 100, Byte.MIN_VALUE})).toRewindAndMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{100, -100, Byte.MIN_VALUE, 100, 100})).toRewindAndMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 1)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 2)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 10, 2, 15, 25}, 3)).toRewindAndMin().isEqualTo(1);
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1})).isNotNull().toRewindAndMin().isEqualTo(1);

        try {
            Raw.byteBufferAssertion().toRewindAndMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndMin();
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndMin()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndMin()).isEqualTo(0);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1)).toRewindAndMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}, 1), "Message").toRewindAndMin().isEqualTo(4);
            Assertions.fail("ByteBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinMatcherTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinPrimitiveTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinObjectTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxMatcherTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxPrimitiveTest() {
        // TODO
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxObjectTest() {
        // TODO
    }

}
