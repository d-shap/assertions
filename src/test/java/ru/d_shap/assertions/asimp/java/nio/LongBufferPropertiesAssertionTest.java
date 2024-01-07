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

import java.nio.ByteBuffer;
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
public final class LongBufferPropertiesAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongBufferPropertiesAssertionTest() {
        super();
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition().isGreaterThan(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition().isLessThan(6);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition().isEqualTo(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition().isGreaterThan(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition().isLessThan(4);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition().isLessThan(5);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().toPosition().isEqualTo(3);

        try {
            Raw.longBufferAssertion().toPosition();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toPosition();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toPosition();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition()).isEqualTo(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toPosition()).isEqualTo(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition().isEqualTo(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toPosition().isEqualTo(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toPositionMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition(Matchers.equalTo(1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition(Matchers.greaterThan(0));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).toPosition(Matchers.lessThan(2));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition(Matchers.equalTo(3));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition(Matchers.greaterThan(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toPosition(Matchers.lessThan(4));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().toPosition(Matchers.is(Matchers.equalTo(3))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toPosition(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toPosition(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toPosition(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toPosition(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toPosition(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toPosition(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toPosition(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toPosition(Matchers.equalTo(4));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toPosition(Matchers.equalTo(4));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasPosition(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).hasPosition(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).hasPosition(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().hasPosition(3).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasPosition(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasPosition(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasPosition(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasPosition(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasPosition(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit().isGreaterThan(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit().isLessThan(6);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit().isEqualTo(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit().isGreaterThan(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit().isLessThan(4);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit().isLessThan(5);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().toLimit().isEqualTo(3);

        try {
            Raw.longBufferAssertion().toLimit();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toLimit();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toLimit();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit()).isEqualTo(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toLimit()).isEqualTo(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit().isEqualTo(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toLimit().isEqualTo(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toLimitMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit(Matchers.equalTo(1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit(Matchers.greaterThan(0));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toLimit(Matchers.lessThan(2));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit(Matchers.equalTo(3));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit(Matchers.greaterThan(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toLimit(Matchers.lessThan(4));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().toLimit(Matchers.is(Matchers.equalTo(3))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toLimit(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toLimit(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toLimit(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toLimit(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toLimit(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toLimit(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toLimit(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toLimit(Matchers.equalTo(4));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toLimit(Matchers.equalTo(4));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasLimit(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).hasLimit(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).hasLimit(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().hasLimit(3).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasLimit(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasLimit(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasLimit(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasLimit(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasLimit(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity().isGreaterThan(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity().isLessThan(6);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity().isEqualTo(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity().isGreaterThan(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity().isLessThan(6);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity().isEqualTo(5);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity().isLessThan(7);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().toCapacity().isEqualTo(3);

        try {
            Raw.longBufferAssertion().toCapacity();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toCapacity();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toCapacity();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity()).isEqualTo(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toCapacity()).isEqualTo(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity().isEqualTo(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toCapacity().isEqualTo(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toCapacityMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity(Matchers.equalTo(3));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity(Matchers.greaterThan(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).toCapacity(Matchers.lessThan(4));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity(Matchers.equalTo(5));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity(Matchers.greaterThan(4));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).toCapacity(Matchers.lessThan(6));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().toCapacity(Matchers.is(Matchers.equalTo(3))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toCapacity(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toCapacity(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toCapacity(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toCapacity(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toCapacity(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toCapacity(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toCapacity(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toCapacity(Matchers.equalTo(4));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").toCapacity(Matchers.equalTo(4));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasCapacity(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 1)).hasCapacity(3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).hasCapacity(5);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().hasCapacity(3).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasCapacity(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasCapacity(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasCapacity(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasCapacity(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasCapacity(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasProperties(3, 3, 3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1)).hasProperties(1, 3, 3);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 3, 5)).hasProperties(3, 3, 5);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().hasProperties(3, 3, 3).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasProperties(1, 1, 1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasProperties(1, 1, 1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasProperties(1, 1, 1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasProperties(4, 3, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasProperties(4, 3, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasProperties(3, 4, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasProperties(3, 4, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasProperties(3, 3, 4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3), "Message").hasProperties(3, 3, 4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining().isEqualTo(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining().isGreaterThan(-1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining().isLessThan(3);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining().isEqualTo(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining().isLessThan(5);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining().isEqualTo(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining().isGreaterThan(-1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining().isLessThan(3);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining().isEqualTo(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining().isGreaterThan(1);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining().isLessThan(5);

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().toRemaining().isEqualTo(0);

        try {
            Raw.longBufferAssertion().toRemaining();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRemaining();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRemaining();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3)).toRemaining()).isEqualTo(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3), "Message").toRemaining()).isEqualTo(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3)).toRemaining().isEqualTo(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3), "Message").toRemaining().isEqualTo(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRemainingMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining(Matchers.is(Matchers.greaterThan(-1)));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).toRemaining(Matchers.is(Matchers.lessThan(1)));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining(Matchers.equalTo(0));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining(Matchers.greaterThan(-1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).toRemaining(Matchers.lessThan(1));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().toRemaining(Matchers.is(Matchers.equalTo(0))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toRemaining(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRemaining(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRemaining(Matchers.equalTo(0));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRemaining(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRemaining(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{})).toRemaining(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{}), "Message").toRemaining(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3)).toRemaining(Matchers.equalTo(4));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3), "Message").toRemaining(Matchers.equalTo(4));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).hasRemaining(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 1, 3)).hasRemaining(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 4, 2, 5)).hasRemaining(0);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 2, 4, 5)).hasRemaining(2);
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 3)).isNotNull().hasRemaining(0).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasRemaining(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRemaining(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRemaining(1);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3)).hasRemaining(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L}, 0, 3, 3), "Message").hasRemaining(4);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        initialize(Raw.longBufferAssertion(), ByteBuffer.allocateDirect(12).asLongBuffer()).isDirect();
        initialize(Raw.longBufferAssertion(), ByteBuffer.allocateDirect(12).asLongBuffer()).isNotNull().isDirect().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), ByteBuffer.allocate(12).asLongBuffer()).isDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be direct.");
        }
        try {
            initialize(Raw.longBufferAssertion(), ByteBuffer.allocate(12).asLongBuffer(), "Message").isDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be direct.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        initialize(Raw.longBufferAssertion(), ByteBuffer.allocate(12).asLongBuffer()).isNotDirect();
        initialize(Raw.longBufferAssertion(), ByteBuffer.allocate(12).asLongBuffer()).isNotNull().isNotDirect().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isNotDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isNotDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isNotDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), ByteBuffer.allocateDirect(12).asLongBuffer()).isNotDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be direct.");
        }
        try {
            initialize(Raw.longBufferAssertion(), ByteBuffer.allocateDirect(12).asLongBuffer(), "Message").isNotDirect();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be direct.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        LongBuffer buffer = ByteBuffer.allocate(12).asLongBuffer();
        LongBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.longBufferAssertion(), readOnlyBuffer).isReadOnly();
        initialize(Raw.longBufferAssertion(), readOnlyBuffer).isNotNull().isReadOnly().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), buffer).isReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be read only.");
        }
        try {
            initialize(Raw.longBufferAssertion(), buffer, "Message").isReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be read only.");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        LongBuffer buffer = ByteBuffer.allocate(12).asLongBuffer();
        LongBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.longBufferAssertion(), buffer).isNotReadOnly();
        initialize(Raw.longBufferAssertion(), buffer).isNotNull().isNotReadOnly().isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().isNotReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).isNotReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").isNotReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), readOnlyBuffer).isNotReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be read only.");
        }
        try {
            initialize(Raw.longBufferAssertion(), readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be read only.");
        }
    }

}
