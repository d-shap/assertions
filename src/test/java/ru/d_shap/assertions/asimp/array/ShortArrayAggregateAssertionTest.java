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
 * Tests for {@link ShortArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortArrayAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortArrayAggregateAssertionTest() {
        super();
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{}).toMin().isNull();
        initialize(Raw.shortArrayAssertion(), new short[]{1}).toMin().isEqualTo(1);
        initialize(Raw.shortArrayAssertion(), new short[]{10, 1, 15, 25}).toMin().isEqualTo(1);
        initialize(Raw.shortArrayAssertion(), new short[]{Short.MIN_VALUE, 100, -100, 100, 100}).toMin().isEqualTo(Short.MIN_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, 100, 100, Short.MIN_VALUE}).toMin().isEqualTo(Short.MIN_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, Short.MIN_VALUE, 100, 100}).toMin().isEqualTo(Short.MIN_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{1}).isNotNull().toMin().isEqualTo(1);

        try {
            Raw.shortArrayAssertion().toMin();
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toMin();
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toMin();
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toMin()).isEqualTo(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toMin()).isEqualTo(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toMin().isEqualTo(4);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toMin().isEqualTo(4);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{}).toMin(Matchers.nullValue());
        initialize(Raw.shortArrayAssertion(), new short[]{1}).toMin(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortArrayAssertion(), new short[]{10, 1, 15, 25}).toMin(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortArrayAssertion(), new short[]{Short.MIN_VALUE, 100, -100, 100, 100}).toMin(Matchers.is(Matchers.equalTo(Short.MIN_VALUE)));
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, 100, 100, Short.MIN_VALUE}).toMin(Matchers.is(Matchers.equalTo(Short.MIN_VALUE)));
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, Short.MIN_VALUE, 100, 100}).toMin(Matchers.is(Matchers.equalTo(Short.MIN_VALUE)));
        initialize(Raw.shortArrayAssertion(), new short[]{1}).isNotNull().toMin(Matchers.is(Matchers.equalTo((short) 1))).isInstanceOf(short[].class);

        try {
            Raw.shortArrayAssertion().toMin(Matchers.equalTo((short) 0));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toMin(Matchers.equalTo((short) 0));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toMin(Matchers.equalTo((short) 0));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toMin(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toMin(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).toMin(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").toMin(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toMin(Matchers.equalTo((short) 4));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4s>\n     but: was <1s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toMin(Matchers.equalTo((short) 4));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4s>\n     but: was <1s>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1}).hasMin(1);
        initialize(Raw.shortArrayAssertion(), new short[]{10, 1, 15, 25}).hasMin(1);
        initialize(Raw.shortArrayAssertion(), new short[]{Short.MIN_VALUE, 100, -100, 100, 100}).hasMin(Short.MIN_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, 100, 100, Short.MIN_VALUE}).hasMin(Short.MIN_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, Short.MIN_VALUE, 100, 100}).hasMin(Short.MIN_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{1}).isNotNull().hasMin(1).isInstanceOf(short[].class);

        try {
            Raw.shortArrayAssertion().hasMin(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasMin(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasMin(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasMin(4);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasMin(4);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{}).hasMin(null);
        initialize(Raw.shortArrayAssertion(), new short[]{1}).hasMin(Short.valueOf("1"));
        initialize(Raw.shortArrayAssertion(), new short[]{10, 1, 15, 25}).hasMin(Short.valueOf("1"));
        initialize(Raw.shortArrayAssertion(), new short[]{Short.MIN_VALUE, 100, -100, 100, 100}).hasMin(Short.valueOf("-32768"));
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, 100, 100, Short.MIN_VALUE}).hasMin(Short.valueOf("-32768"));
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, Short.MIN_VALUE, 100, 100}).hasMin(Short.valueOf("-32768"));
        initialize(Raw.shortArrayAssertion(), new short[]{1}).isNotNull().hasMin(Short.valueOf("1")).isInstanceOf(short[].class);

        try {
            Raw.shortArrayAssertion().hasMin(Short.valueOf("0"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasMin(Short.valueOf("0"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasMin(Short.valueOf("0"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasMin(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasMin(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1}).hasMin(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1}, "Message").hasMin(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasMin(Short.valueOf("4"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasMin(Short.valueOf("4"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<1s>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{}).toMax().isNull();
        initialize(Raw.shortArrayAssertion(), new short[]{1}).toMax().isEqualTo(1);
        initialize(Raw.shortArrayAssertion(), new short[]{10, 1, 15, 25}).toMax().isEqualTo(25);
        initialize(Raw.shortArrayAssertion(), new short[]{Short.MAX_VALUE, 100, -100, 100, 100}).toMax().isEqualTo(Short.MAX_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, 100, 100, Short.MAX_VALUE}).toMax().isEqualTo(Short.MAX_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, Short.MAX_VALUE, 100, 100}).toMax().isEqualTo(Short.MAX_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{1}).isNotNull().toMax().isEqualTo(1);

        try {
            Raw.shortArrayAssertion().toMax();
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toMax();
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toMax();
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toMax()).isEqualTo(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toMax()).isEqualTo(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toMax().isEqualTo(4);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toMax().isEqualTo(4);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{}).toMax(Matchers.nullValue());
        initialize(Raw.shortArrayAssertion(), new short[]{1}).toMax(Matchers.is(Matchers.equalTo((short) 1)));
        initialize(Raw.shortArrayAssertion(), new short[]{10, 1, 15, 25}).toMax(Matchers.is(Matchers.equalTo((short) 25)));
        initialize(Raw.shortArrayAssertion(), new short[]{Short.MAX_VALUE, 100, -100, 100, 100}).toMax(Matchers.is(Matchers.equalTo(Short.MAX_VALUE)));
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, 100, 100, Short.MAX_VALUE}).toMax(Matchers.is(Matchers.equalTo(Short.MAX_VALUE)));
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, Short.MAX_VALUE, 100, 100}).toMax(Matchers.is(Matchers.equalTo(Short.MAX_VALUE)));
        initialize(Raw.shortArrayAssertion(), new short[]{1}).isNotNull().toMax(Matchers.is(Matchers.equalTo((short) 1))).isInstanceOf(short[].class);

        try {
            Raw.shortArrayAssertion().toMax(Matchers.equalTo((short) 0));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toMax(Matchers.equalTo((short) 0));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toMax(Matchers.equalTo((short) 0));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).toMax(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").toMax(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}).toMax(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{}, "Message").toMax(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).toMax(Matchers.equalTo((short) 4));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4s>\n     but: was <2s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").toMax(Matchers.equalTo((short) 4));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4s>\n     but: was <2s>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{1}).hasMax(1);
        initialize(Raw.shortArrayAssertion(), new short[]{10, 1, 15, 25}).hasMax(25);
        initialize(Raw.shortArrayAssertion(), new short[]{Short.MAX_VALUE, 100, -100, 100, 100}).hasMax(Short.MAX_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, 100, 100, Short.MAX_VALUE}).hasMax(Short.MAX_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, Short.MAX_VALUE, 100, 100}).hasMax(Short.MAX_VALUE);
        initialize(Raw.shortArrayAssertion(), new short[]{1}).isNotNull().hasMax(1).isInstanceOf(short[].class);

        try {
            Raw.shortArrayAssertion().hasMax(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasMax(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasMax(0);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasMax(4);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasMax(4);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
    }

    /**
     * {@link ShortArrayAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.shortArrayAssertion(), new short[]{}).hasMax(null);
        initialize(Raw.shortArrayAssertion(), new short[]{1}).hasMax(Short.valueOf("1"));
        initialize(Raw.shortArrayAssertion(), new short[]{10, 1, 15, 25}).hasMax(Short.valueOf("25"));
        initialize(Raw.shortArrayAssertion(), new short[]{Short.MAX_VALUE, 100, -100, 100, 100}).hasMax(Short.valueOf("32767"));
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, 100, 100, Short.MAX_VALUE}).hasMax(Short.valueOf("32767"));
        initialize(Raw.shortArrayAssertion(), new short[]{100, -100, Short.MAX_VALUE, 100, 100}).hasMax(Short.valueOf("32767"));
        initialize(Raw.shortArrayAssertion(), new short[]{1}).isNotNull().hasMax(Short.valueOf("1")).isInstanceOf(short[].class);

        try {
            Raw.shortArrayAssertion().hasMax(Short.valueOf("0"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasMax(Short.valueOf("0"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasMax(Short.valueOf("0"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null).hasMax(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), null, "Message").hasMax(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1}).hasMax(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1}, "Message").hasMax(null);
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}).hasMax(Short.valueOf("4"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
        try {
            initialize(Raw.shortArrayAssertion(), new short[]{1, 2}, "Message").hasMax(Short.valueOf("4"));
            Assertions.fail(ShortArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4s> but was:<2s>");
        }
    }

}
