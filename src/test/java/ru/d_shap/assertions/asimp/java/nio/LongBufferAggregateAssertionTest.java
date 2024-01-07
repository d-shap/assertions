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

import java.nio.LongBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LongBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongBufferAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongBufferAggregateAssertionTest() {
        super();
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toMin().isNull();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).toMin().isEqualTo(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{10L, 1L, 15L, 25L})).toMin().isEqualTo(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L})).toMin().isEqualTo(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE})).toMin().isEqualTo(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L})).toMin().isEqualTo(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 1)).toMin().isEqualTo(2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 2)).toMin().isEqualTo(2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 3)).toMin().isEqualTo(15L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().toMin().isEqualTo(1L);

        try {
            Raw.longBufferAssertion().toMin();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toMin();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toMin();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toMin()).isEqualTo(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toMin()).isEqualTo(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toMin().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toMin().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).toMin().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").toMin().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toMin(Matchers.nullValue());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).toMin(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{10L, 1L, 15L, 25L})).toMin(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L})).toMin(Matchers.is(Matchers.equalTo(Long.MIN_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE})).toMin(Matchers.is(Matchers.equalTo(Long.MIN_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L})).toMin(Matchers.is(Matchers.equalTo(Long.MIN_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 1)).toMin(Matchers.is(Matchers.equalTo(2L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 2)).toMin(Matchers.is(Matchers.equalTo(2L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 3)).toMin(Matchers.is(Matchers.equalTo(15L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().toMin(Matchers.is(Matchers.equalTo(1L))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toMin(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toMin(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toMin(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toMin(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4L>\n     but: was <1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toMin(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4L>\n     but: was <1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).toMin(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4L>\n     but: was <2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").toMin(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4L>\n     but: was <2L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toRewindAndMin().isNull();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).toRewindAndMin().isEqualTo(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{10L, 1L, 15L, 25L})).toRewindAndMin().isEqualTo(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L})).toRewindAndMin().isEqualTo(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE})).toRewindAndMin().isEqualTo(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L})).toRewindAndMin().isEqualTo(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 1)).toRewindAndMin().isEqualTo(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 2)).toRewindAndMin().isEqualTo(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 3)).toRewindAndMin().isEqualTo(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().toRewindAndMin().isEqualTo(1L);

        try {
            Raw.longBufferAssertion().toRewindAndMin();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndMin();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndMin();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndMin()).isEqualTo(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndMin()).isEqualTo(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndMin().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndMin().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).toRewindAndMin().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").toRewindAndMin().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toRewindAndMin(Matchers.nullValue());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).toRewindAndMin(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{10L, 1L, 15L, 25L})).toRewindAndMin(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L})).toRewindAndMin(Matchers.is(Matchers.equalTo(Long.MIN_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE})).toRewindAndMin(Matchers.is(Matchers.equalTo(Long.MIN_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L})).toRewindAndMin(Matchers.is(Matchers.equalTo(Long.MIN_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 1)).toRewindAndMin(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 2)).toRewindAndMin(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 3)).toRewindAndMin(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().toRewindAndMin(Matchers.is(Matchers.equalTo(1L))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toRewindAndMin(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndMin(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndMin(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toRewindAndMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toRewindAndMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndMin(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4L>\n     but: was <1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndMin(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4L>\n     but: was <1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).toRewindAndMin(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4L>\n     but: was <1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").toRewindAndMin(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4L>\n     but: was <1L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasMin(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{10L, 1L, 15L, 25L})).hasMin(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L})).hasMin(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE})).hasMin(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L})).hasMin(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 1)).hasMin(2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 2)).hasMin(2L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 3)).hasMin(15L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().hasMin(1L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasMin(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasMin(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasMin(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasMin(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasMin(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).hasMin(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").hasMin(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).hasMin(null);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasMin(Long.valueOf("1"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{10L, 1L, 15L, 25L})).hasMin(Long.valueOf("1"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L})).hasMin(Long.valueOf("-9223372036854775808"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE})).hasMin(Long.valueOf("-9223372036854775808"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L})).hasMin(Long.valueOf("-9223372036854775808"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 1)).hasMin(Long.valueOf("2"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 2)).hasMin(Long.valueOf("2"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 3)).hasMin(Long.valueOf("15"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().hasMin(Long.valueOf("1")).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasMin(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasMin(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasMin(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L}), "Message").hasMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasMin(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasMin(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).hasMin(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").hasMin(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinPrimitiveTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasRewindAndMin(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{10L, 1L, 15L, 25L})).hasRewindAndMin(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L})).hasRewindAndMin(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE})).hasRewindAndMin(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L})).hasRewindAndMin(Long.MIN_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 1)).hasRewindAndMin(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 2)).hasRewindAndMin(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 3)).hasRewindAndMin(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().hasRewindAndMin(1L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasRewindAndMin(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndMin(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndMin(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndMin(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndMin(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).hasRewindAndMin(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").hasRewindAndMin(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinObjectTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).hasRewindAndMin(null);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasRewindAndMin(Long.valueOf("1"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{10L, 1L, 15L, 25L})).hasRewindAndMin(Long.valueOf("1"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MIN_VALUE, 100L, -100L, 100L, 100L})).hasRewindAndMin(Long.valueOf("-9223372036854775808"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MIN_VALUE})).hasRewindAndMin(Long.valueOf("-9223372036854775808"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MIN_VALUE, 100L, 100L})).hasRewindAndMin(Long.valueOf("-9223372036854775808"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 1)).hasRewindAndMin(Long.valueOf("1"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 2)).hasRewindAndMin(Long.valueOf("1"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 10L, 2L, 15L, 25L}, 3)).hasRewindAndMin(Long.valueOf("1"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().hasRewindAndMin(Long.valueOf("1")).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasRewindAndMin(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndMin(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndMin(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasRewindAndMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L}), "Message").hasRewindAndMin(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndMin(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndMin(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1)).hasRewindAndMin(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}, 1), "Message").hasRewindAndMin(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toMax().isNull();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).toMax().isEqualTo(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, 25L, 10L, 1L})).toMax().isEqualTo(25L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L})).toMax().isEqualTo(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE})).toMax().isEqualTo(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MAX_VALUE, 100L, 100L})).toMax().isEqualTo(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 1)).toMax().isEqualTo(25L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 2)).toMax().isEqualTo(25L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 3)).toMax().isEqualTo(10L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().toMax().isEqualTo(1L);

        try {
            Raw.longBufferAssertion().toMax();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toMax();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toMax();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).toMax()).isEqualTo(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").toMax()).isEqualTo(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).toMax().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").toMax().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1)).toMax().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1), "Message").toMax().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toMax(Matchers.nullValue());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).toMax(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, 25L, 10L, 1L})).toMax(Matchers.is(Matchers.equalTo(25L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L})).toMax(Matchers.is(Matchers.equalTo(Long.MAX_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE})).toMax(Matchers.is(Matchers.equalTo(Long.MAX_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MAX_VALUE, 100L, 100L})).toMax(Matchers.is(Matchers.equalTo(Long.MAX_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 1)).toMax(Matchers.is(Matchers.equalTo(25L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 2)).toMax(Matchers.is(Matchers.equalTo(25L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 3)).toMax(Matchers.is(Matchers.equalTo(10L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().toMax(Matchers.is(Matchers.equalTo(1L))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toMax(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toMax(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toMax(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).toMax(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4L>\n     but: was <2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").toMax(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4L>\n     but: was <2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1)).toMax(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4L>\n     but: was <1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1), "Message").toMax(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4L>\n     but: was <1L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toRewindAndMax().isNull();
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).toRewindAndMax().isEqualTo(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, 25L, 10L, 1L})).toRewindAndMax().isEqualTo(25L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L})).toRewindAndMax().isEqualTo(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE})).toRewindAndMax().isEqualTo(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MAX_VALUE, 100L, 100L})).toRewindAndMax().isEqualTo(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 1)).toRewindAndMax().isEqualTo(30L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 2)).toRewindAndMax().isEqualTo(30L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 3)).toRewindAndMax().isEqualTo(30L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().toRewindAndMax().isEqualTo(1L);

        try {
            Raw.longBufferAssertion().toRewindAndMax();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndMax();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndMax();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).toRewindAndMax()).isEqualTo(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").toRewindAndMax()).isEqualTo(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).toRewindAndMax().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").toRewindAndMax().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1)).toRewindAndMax().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1), "Message").toRewindAndMax().isEqualTo(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toRewindAndMax(Matchers.nullValue());
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).toRewindAndMax(Matchers.is(Matchers.equalTo(1L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, 25L, 10L, 1L})).toRewindAndMax(Matchers.is(Matchers.equalTo(25L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L})).toRewindAndMax(Matchers.is(Matchers.equalTo(Long.MAX_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE})).toRewindAndMax(Matchers.is(Matchers.equalTo(Long.MAX_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MAX_VALUE, 100L, 100L})).toRewindAndMax(Matchers.is(Matchers.equalTo(Long.MAX_VALUE)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 1)).toRewindAndMax(Matchers.is(Matchers.equalTo(30L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 2)).toRewindAndMax(Matchers.is(Matchers.equalTo(30L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 3)).toRewindAndMax(Matchers.is(Matchers.equalTo(30L)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().toRewindAndMax(Matchers.is(Matchers.equalTo(1L))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toRewindAndMax(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndMax(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndMax(Matchers.equalTo(0L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).toRewindAndMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L}), "Message").toRewindAndMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).toRewindAndMax(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4L>\n     but: was <2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").toRewindAndMax(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4L>\n     but: was <2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1)).toRewindAndMax(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4L>\n     but: was <2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1), "Message").toRewindAndMax(Matchers.equalTo(4L));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4L>\n     but: was <2L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasMax(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, 25L, 10L, 1L})).hasMax(25L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L})).hasMax(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE})).hasMax(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MAX_VALUE, 100L, 100L})).hasMax(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 1)).hasMax(25L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 2)).hasMax(25L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 3)).hasMax(10L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().hasMax(1L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasMax(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasMax(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasMax(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).hasMax(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").hasMax(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1)).hasMax(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1), "Message").hasMax(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).hasMax(null);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasMax(Long.valueOf("1"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, 25L, 10L, 1L})).hasMax(Long.valueOf("25"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L})).hasMax(Long.valueOf("9223372036854775807"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE})).hasMax(Long.valueOf("9223372036854775807"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MAX_VALUE, 100L, 100L})).hasMax(Long.valueOf("9223372036854775807"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 1)).hasMax(Long.valueOf("25"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 2)).hasMax(Long.valueOf("25"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 3)).hasMax(Long.valueOf("10"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().hasMax(Long.valueOf("1")).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasMax(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasMax(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasMax(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L}), "Message").hasMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).hasMax(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").hasMax(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1)).hasMax(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1), "Message").hasMax(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<1L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxPrimitiveTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasRewindAndMax(1L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, 25L, 10L, 1L})).hasRewindAndMax(25L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L})).hasRewindAndMax(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE})).hasRewindAndMax(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MAX_VALUE, 100L, 100L})).hasRewindAndMax(Long.MAX_VALUE);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 1)).hasRewindAndMax(30L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 2)).hasRewindAndMax(30L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 3)).hasRewindAndMax(30L);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().hasRewindAndMax(1L).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasRewindAndMax(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndMax(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndMax(0L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).hasRewindAndMax(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").hasRewindAndMax(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1)).hasRewindAndMax(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1), "Message").hasRewindAndMax(4L);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxObjectTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).hasRewindAndMax(null);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasRewindAndMax(Long.valueOf("1"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, 25L, 10L, 1L})).hasRewindAndMax(Long.valueOf("25"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{Long.MAX_VALUE, 100L, -100L, 100L, 100L})).hasRewindAndMax(Long.valueOf("9223372036854775807"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, 100L, 100L, Long.MAX_VALUE})).hasRewindAndMax(Long.valueOf("9223372036854775807"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{100L, -100L, Long.MAX_VALUE, 100L, 100L})).hasRewindAndMax(Long.valueOf("9223372036854775807"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 1)).hasRewindAndMax(Long.valueOf("30"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 2)).hasRewindAndMax(Long.valueOf("30"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{30L, 15L, 25L, 10L, 1L}, 3)).hasRewindAndMax(Long.valueOf("30"));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).isNotNull().hasRewindAndMax(Long.valueOf("1")).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasRewindAndMax(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndMax(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndMax(Long.valueOf("0"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L})).hasRewindAndMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L}), "Message").hasRewindAndMax(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L})).hasRewindAndMax(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}), "Message").hasRewindAndMax(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1)).hasRewindAndMax(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{2L, 1L}, 1), "Message").hasRewindAndMax(Long.valueOf("4"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4L> but was:<2L>");
        }
    }

}
