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
package ru.d_shap.assertions.asimp.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ByteArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteArrayAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteArrayAggregateAssertionTest() {
        super();
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{}).toMin().isNull();
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).toMin().isEqualTo(1);
        initialize(Raw.byteArrayAssertion(), new byte[]{10, 1, 15, 25}).toMin().isEqualTo(1);
        initialize(Raw.byteArrayAssertion(), new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100}).toMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, 100, 100, Byte.MIN_VALUE}).toMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, Byte.MIN_VALUE, 100, 100}).toMin().isEqualTo(Byte.MIN_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).isNotNull().toMin().isEqualTo(1);

        try {
            Raw.byteArrayAssertion().toMin();
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toMin();
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toMin();
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toMin()).isEqualTo(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toMin()).isEqualTo(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toMin().isEqualTo(4);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toMin().isEqualTo(4);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{}).toMin(Matchers.nullValue());
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).toMin(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteArrayAssertion(), new byte[]{10, 1, 15, 25}).toMin(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteArrayAssertion(), new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100}).toMin(Matchers.is(Matchers.equalTo(Byte.MIN_VALUE)));
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, 100, 100, Byte.MIN_VALUE}).toMin(Matchers.is(Matchers.equalTo(Byte.MIN_VALUE)));
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, Byte.MIN_VALUE, 100, 100}).toMin(Matchers.is(Matchers.equalTo(Byte.MIN_VALUE)));
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).isNotNull().toMin(Matchers.is(Matchers.equalTo((byte) 1))).isInstanceOf(byte[].class);

        try {
            Raw.byteArrayAssertion().toMin(Matchers.equalTo((byte) 0));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toMin(Matchers.equalTo((byte) 0));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toMin(Matchers.equalTo((byte) 0));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toMin(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toMin(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).toMin(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").toMin(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toMin(Matchers.equalTo((byte) 4));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toMin(Matchers.equalTo((byte) 4));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).hasMin(1);
        initialize(Raw.byteArrayAssertion(), new byte[]{10, 1, 15, 25}).hasMin(1);
        initialize(Raw.byteArrayAssertion(), new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100}).hasMin(Byte.MIN_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, 100, 100, Byte.MIN_VALUE}).hasMin(Byte.MIN_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, Byte.MIN_VALUE, 100, 100}).hasMin(Byte.MIN_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).isNotNull().hasMin(1).isInstanceOf(byte[].class);

        try {
            Raw.byteArrayAssertion().hasMin(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasMin(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasMin(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasMin(4);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasMin(4);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{}).hasMin(null);
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).hasMin(Byte.valueOf("1"));
        initialize(Raw.byteArrayAssertion(), new byte[]{10, 1, 15, 25}).hasMin(Byte.valueOf("1"));
        initialize(Raw.byteArrayAssertion(), new byte[]{Byte.MIN_VALUE, 100, -100, 100, 100}).hasMin(Byte.valueOf("-128"));
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, 100, 100, Byte.MIN_VALUE}).hasMin(Byte.valueOf("-128"));
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, Byte.MIN_VALUE, 100, 100}).hasMin(Byte.valueOf("-128"));
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).isNotNull().hasMin(Byte.valueOf("1")).isInstanceOf(byte[].class);

        try {
            Raw.byteArrayAssertion().hasMin(Byte.valueOf("0"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasMin(Byte.valueOf("0"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasMin(Byte.valueOf("0"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasMin(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasMin(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1}).hasMin(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1}, "Message").hasMin(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasMin(Byte.valueOf("4"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasMin(Byte.valueOf("4"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<1b>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{}).toMax().isNull();
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).toMax().isEqualTo(1);
        initialize(Raw.byteArrayAssertion(), new byte[]{10, 1, 15, 25}).toMax().isEqualTo(25);
        initialize(Raw.byteArrayAssertion(), new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100}).toMax().isEqualTo(Byte.MAX_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, 100, 100, Byte.MAX_VALUE}).toMax().isEqualTo(Byte.MAX_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, Byte.MAX_VALUE, 100, 100}).toMax().isEqualTo(Byte.MAX_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).isNotNull().toMax().isEqualTo(1);

        try {
            Raw.byteArrayAssertion().toMax();
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toMax();
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toMax();
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toMax()).isEqualTo(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toMax()).isEqualTo(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toMax().isEqualTo(4);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toMax().isEqualTo(4);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{}).toMax(Matchers.nullValue());
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).toMax(Matchers.is(Matchers.equalTo((byte) 1)));
        initialize(Raw.byteArrayAssertion(), new byte[]{10, 1, 15, 25}).toMax(Matchers.is(Matchers.equalTo((byte) 25)));
        initialize(Raw.byteArrayAssertion(), new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100}).toMax(Matchers.is(Matchers.equalTo(Byte.MAX_VALUE)));
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, 100, 100, Byte.MAX_VALUE}).toMax(Matchers.is(Matchers.equalTo(Byte.MAX_VALUE)));
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, Byte.MAX_VALUE, 100, 100}).toMax(Matchers.is(Matchers.equalTo(Byte.MAX_VALUE)));
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).isNotNull().toMax(Matchers.is(Matchers.equalTo((byte) 1))).isInstanceOf(byte[].class);

        try {
            Raw.byteArrayAssertion().toMax(Matchers.equalTo((byte) 0));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toMax(Matchers.equalTo((byte) 0));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toMax(Matchers.equalTo((byte) 0));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toMax(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toMax(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).toMax(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").toMax(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toMax(Matchers.equalTo((byte) 4));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toMax(Matchers.equalTo((byte) 4));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).hasMax(1);
        initialize(Raw.byteArrayAssertion(), new byte[]{10, 1, 15, 25}).hasMax(25);
        initialize(Raw.byteArrayAssertion(), new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100}).hasMax(Byte.MAX_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, 100, 100, Byte.MAX_VALUE}).hasMax(Byte.MAX_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, Byte.MAX_VALUE, 100, 100}).hasMax(Byte.MAX_VALUE);
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).isNotNull().hasMax(1).isInstanceOf(byte[].class);

        try {
            Raw.byteArrayAssertion().hasMax(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasMax(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasMax(0);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasMax(4);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasMax(4);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{}).hasMax(null);
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).hasMax(Byte.valueOf("1"));
        initialize(Raw.byteArrayAssertion(), new byte[]{10, 1, 15, 25}).hasMax(Byte.valueOf("25"));
        initialize(Raw.byteArrayAssertion(), new byte[]{Byte.MAX_VALUE, 100, -100, 100, 100}).hasMax(Byte.valueOf("127"));
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, 100, 100, Byte.MAX_VALUE}).hasMax(Byte.valueOf("127"));
        initialize(Raw.byteArrayAssertion(), new byte[]{100, -100, Byte.MAX_VALUE, 100, 100}).hasMax(Byte.valueOf("127"));
        initialize(Raw.byteArrayAssertion(), new byte[]{1}).isNotNull().hasMax(Byte.valueOf("1")).isInstanceOf(byte[].class);

        try {
            Raw.byteArrayAssertion().hasMax(Byte.valueOf("0"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasMax(Byte.valueOf("0"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasMax(Byte.valueOf("0"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasMax(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasMax(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1}).hasMax(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1}, "Message").hasMax(null);
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasMax(Byte.valueOf("4"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasMax(Byte.valueOf("4"));
            Assertions.fail(ByteArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4b> but was:<2b>");
        }
    }

}
