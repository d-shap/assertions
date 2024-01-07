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
 * Tests for {@link LongArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongArrayAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongArrayAggregateAssertionTest() {
        super();
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.longArrayAssertion(), new long[]{}).toMin().isNull();
        initialize(Raw.longArrayAssertion(), new long[]{1L}).toMin().isEqualTo(1L);
        initialize(Raw.longArrayAssertion(), new long[]{10L, 1L, 15L, 25L}).toMin().isEqualTo(1L);
        initialize(Raw.longArrayAssertion(), new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L}).toMin().isEqualTo(Long.MIN_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE}).toMin().isEqualTo(Long.MIN_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L}).toMin().isEqualTo(Long.MIN_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{1L}).isNotNull().toMin().isEqualTo(1L);

        try {
            Raw.longArrayAssertion().toMin();
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toMin();
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toMin();
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toMin()).isEqualTo(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").toMin()).isEqualTo(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toMin().isEqualTo(4L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").toMin().isEqualTo(4L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.longArrayAssertion(), new long[]{}).toMin(Matchers.nullValue());
        initialize(Raw.longArrayAssertion(), new long[]{1L}).toMin(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longArrayAssertion(), new long[]{10L, 1L, 15L, 25L}).toMin(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longArrayAssertion(), new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L}).toMin(Matchers.is(Matchers.equalTo(Long.MIN_VALUE)));
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE}).toMin(Matchers.is(Matchers.equalTo(Long.MIN_VALUE)));
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L}).toMin(Matchers.is(Matchers.equalTo(Long.MIN_VALUE)));
        initialize(Raw.longArrayAssertion(), new long[]{1L}).isNotNull().toMin(Matchers.is(Matchers.equalTo(1L))).isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().toMin(Matchers.equalTo(0L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toMin(Matchers.equalTo(0L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toMin(Matchers.equalTo(0L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toMin(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toMin(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).toMin(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").toMin(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toMin(Matchers.equalTo(4L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4L>\n     but: was <1L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").toMin(Matchers.equalTo(4L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4L>\n     but: was <1L>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L}).hasMin(1L);
        initialize(Raw.longArrayAssertion(), new long[]{10L, 1L, 15L, 25L}).hasMin(1L);
        initialize(Raw.longArrayAssertion(), new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L}).hasMin(Long.MIN_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE}).hasMin(Long.MIN_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L}).hasMin(Long.MIN_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{1L}).isNotNull().hasMin(1L).isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().hasMin(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasMin(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasMin(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).hasMin(4L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").hasMin(4L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.longArrayAssertion(), new long[]{}).hasMin(null);
        initialize(Raw.longArrayAssertion(), new long[]{1L}).hasMin(Long.valueOf("1"));
        initialize(Raw.longArrayAssertion(), new long[]{10L, 1L, 15L, 25L}).hasMin(Long.valueOf("1"));
        initialize(Raw.longArrayAssertion(), new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L}).hasMin(Long.valueOf("-9223372036854775808"));
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE}).hasMin(Long.valueOf("-9223372036854775808"));
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L}).hasMin(Long.valueOf("-9223372036854775808"));
        initialize(Raw.longArrayAssertion(), new long[]{1L}).isNotNull().hasMin(Long.valueOf("1")).isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().hasMin(Long.valueOf("0"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasMin(Long.valueOf("0"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasMin(Long.valueOf("0"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasMin(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasMin(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L}).hasMin(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L}, "Message").hasMin(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).hasMin(Long.valueOf("4"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").hasMin(Long.valueOf("4"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.longArrayAssertion(), new long[]{}).toMax().isNull();
        initialize(Raw.longArrayAssertion(), new long[]{1L}).toMax().isEqualTo(1L);
        initialize(Raw.longArrayAssertion(), new long[]{10L, 1L, 15L, 25L}).toMax().isEqualTo(25L);
        initialize(Raw.longArrayAssertion(), new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L}).toMax().isEqualTo(Long.MAX_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE}).toMax().isEqualTo(Long.MAX_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{100, -100, Long.MAX_VALUE, 100, 100}).toMax().isEqualTo(Long.MAX_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{1L}).isNotNull().toMax().isEqualTo(1L);

        try {
            Raw.longArrayAssertion().toMax();
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toMax();
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toMax();
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toMax()).isEqualTo(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").toMax()).isEqualTo(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toMax().isEqualTo(4L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").toMax().isEqualTo(4L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.longArrayAssertion(), new long[]{}).toMax(Matchers.nullValue());
        initialize(Raw.longArrayAssertion(), new long[]{1L}).toMax(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longArrayAssertion(), new long[]{10L, 1L, 15L, 25L}).toMax(Matchers.is(Matchers.equalTo(25L)));
        initialize(Raw.longArrayAssertion(), new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L}).toMax(Matchers.is(Matchers.equalTo(Long.MAX_VALUE)));
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE}).toMax(Matchers.is(Matchers.equalTo(Long.MAX_VALUE)));
        initialize(Raw.longArrayAssertion(), new long[]{100, -100, Long.MAX_VALUE, 100, 100}).toMax(Matchers.is(Matchers.equalTo(Long.MAX_VALUE)));
        initialize(Raw.longArrayAssertion(), new long[]{1L}).isNotNull().toMax(Matchers.is(Matchers.equalTo(1L))).isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().toMax(Matchers.equalTo(0L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toMax(Matchers.equalTo(0L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toMax(Matchers.equalTo(0L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toMax(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toMax(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}).toMax(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{}, "Message").toMax(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).toMax(Matchers.equalTo(4L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4L>\n     but: was <2L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").toMax(Matchers.equalTo(4L));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4L>\n     but: was <2L>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1L}).hasMax(1L);
        initialize(Raw.longArrayAssertion(), new long[]{10L, 1L, 15L, 25L}).hasMax(25L);
        initialize(Raw.longArrayAssertion(), new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L}).hasMax(Long.MAX_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE}).hasMax(Long.MAX_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{100, -100, Long.MAX_VALUE, 100, 100}).hasMax(Long.MAX_VALUE);
        initialize(Raw.longArrayAssertion(), new long[]{1L}).isNotNull().hasMax(1L).isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().hasMax(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasMax(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasMax(0L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).hasMax(4L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").hasMax(4L);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.longArrayAssertion(), new long[]{}).hasMax(null);
        initialize(Raw.longArrayAssertion(), new long[]{1L}).hasMax(Long.valueOf("1"));
        initialize(Raw.longArrayAssertion(), new long[]{10L, 1L, 15L, 25L}).hasMax(Long.valueOf("25"));
        initialize(Raw.longArrayAssertion(), new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L}).hasMax(Long.valueOf("9223372036854775807"));
        initialize(Raw.longArrayAssertion(), new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE}).hasMax(Long.valueOf("9223372036854775807"));
        initialize(Raw.longArrayAssertion(), new long[]{100, -100, Long.MAX_VALUE, 100, 100}).hasMax(Long.valueOf("9223372036854775807"));
        initialize(Raw.longArrayAssertion(), new long[]{1L}).isNotNull().hasMax(Long.valueOf("1")).isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().hasMax(Long.valueOf("0"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasMax(Long.valueOf("0"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasMax(Long.valueOf("0"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasMax(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasMax(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L}).hasMax(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L}, "Message").hasMax(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}).hasMax(Long.valueOf("4"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1L, 2L}, "Message").hasMax(Long.valueOf("4"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
    }

}
