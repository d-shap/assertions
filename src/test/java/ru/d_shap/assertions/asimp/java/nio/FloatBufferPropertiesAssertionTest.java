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
import java.nio.FloatBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link FloatBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class FloatBufferPropertiesAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public FloatBufferPropertiesAssertionTest() {
        super();
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toPositionTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition().isGreaterThan(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition().isLessThan(6);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition().isEqualTo(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition().isGreaterThan(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition().isLessThan(4);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition().isLessThan(5);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().toPosition().isEqualTo(3);

        try {
            Raw.floatBufferAssertion().toPosition();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toPosition();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toPosition();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toPosition()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toPosition().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toPositionMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition(Matchers.equalTo(1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition(Matchers.greaterThan(0));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).toPosition(Matchers.lessThan(2));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition(Matchers.equalTo(3));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition(Matchers.greaterThan(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toPosition(Matchers.lessThan(4));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().toPosition(Matchers.is(Matchers.equalTo(3))).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().toPosition(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toPosition(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toPosition(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toPosition(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toPosition(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toPosition(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toPosition(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toPosition(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toPosition(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasPositionTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasPosition(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).hasPosition(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).hasPosition(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().hasPosition(3).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasPosition(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasPosition(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasPosition(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasPosition(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasPosition(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toLimitTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit().isGreaterThan(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit().isLessThan(6);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit().isEqualTo(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit().isGreaterThan(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit().isLessThan(4);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit().isLessThan(5);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().toLimit().isEqualTo(3);

        try {
            Raw.floatBufferAssertion().toLimit();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toLimit();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toLimit();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toLimit()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toLimit().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toLimitMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit(Matchers.equalTo(1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit(Matchers.greaterThan(0));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toLimit(Matchers.lessThan(2));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit(Matchers.equalTo(3));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit(Matchers.greaterThan(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toLimit(Matchers.lessThan(4));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().toLimit(Matchers.is(Matchers.equalTo(3))).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().toLimit(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toLimit(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toLimit(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toLimit(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toLimit(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toLimit(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toLimit(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toLimit(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toLimit(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasLimitTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasLimit(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).hasLimit(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).hasLimit(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().hasLimit(3).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasLimit(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasLimit(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasLimit(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasLimit(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasLimit(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toCapacityTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity().isGreaterThan(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity().isLessThan(6);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity().isEqualTo(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity().isGreaterThan(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity().isLessThan(6);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity().isEqualTo(5);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity().isLessThan(7);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().toCapacity().isEqualTo(3);

        try {
            Raw.floatBufferAssertion().toCapacity();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toCapacity();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toCapacity();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toCapacity()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toCapacity().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toCapacityMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity(Matchers.is(Matchers.lessThan(4)));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity(Matchers.equalTo(3));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity(Matchers.greaterThan(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).toCapacity(Matchers.lessThan(4));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity(Matchers.equalTo(5));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity(Matchers.greaterThan(4));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).toCapacity(Matchers.lessThan(6));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().toCapacity(Matchers.is(Matchers.equalTo(3))).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().toCapacity(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toCapacity(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toCapacity(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toCapacity(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toCapacity(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toCapacity(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toCapacity(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toCapacity(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").toCapacity(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasCapacityTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasCapacity(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 1)).hasCapacity(3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).hasCapacity(5);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().hasCapacity(3).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasCapacity(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasCapacity(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasCapacity(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasCapacity(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasCapacity(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasPropertiesTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasProperties(3, 3, 3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1)).hasProperties(1, 3, 3);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 3, 5)).hasProperties(3, 3, 5);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().hasProperties(3, 3, 3).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasProperties(1, 1, 1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasProperties(1, 1, 1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasProperties(1, 1, 1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasProperties(4, 3, 3);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasProperties(4, 3, 3);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's position.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasProperties(3, 4, 3);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasProperties(3, 4, 3);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's limit.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasProperties(3, 3, 4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3), "Message").hasProperties(3, 3, 4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's capacity.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toRemainingTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining().isEqualTo(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining().isGreaterThan(-1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining().isLessThan(3);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining().isEqualTo(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining().isLessThan(5);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining().isEqualTo(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining().isGreaterThan(-1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining().isLessThan(3);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining().isEqualTo(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining().isGreaterThan(1);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining().isLessThan(5);

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().toRemaining().isEqualTo(0);

        try {
            Raw.floatBufferAssertion().toRemaining();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRemaining();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRemaining();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3)).toRemaining()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3), "Message").toRemaining()).isEqualTo(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3)).toRemaining().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3), "Message").toRemaining().isEqualTo(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void toRemainingMatcherTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining(Matchers.is(Matchers.greaterThan(-1)));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).toRemaining(Matchers.is(Matchers.lessThan(1)));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining(Matchers.equalTo(0));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining(Matchers.greaterThan(-1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).toRemaining(Matchers.lessThan(1));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining(Matchers.equalTo(2));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining(Matchers.greaterThan(1));
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).toRemaining(Matchers.lessThan(3));

        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().toRemaining(Matchers.is(Matchers.equalTo(0))).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().toRemaining(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRemaining(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRemaining(Matchers.equalTo(0));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).toRemaining(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").toRemaining(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{})).toRemaining(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{}), "Message").toRemaining(null);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3)).toRemaining(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3), "Message").toRemaining(Matchers.equalTo(4));
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void hasRemainingTest() {
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).hasRemaining(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 1, 3)).hasRemaining(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 4, 2, 5)).hasRemaining(0);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 2, 4, 5)).hasRemaining(2);
        initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 3)).isNotNull().hasRemaining(0).isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().hasRemaining(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).hasRemaining(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").hasRemaining(1);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3)).hasRemaining(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.floatBufferAssertion(), createFloatBuffer(new float[]{1.0f, 2.0f, 3.0f}, 0, 3, 3), "Message").hasRemaining(4);
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's remaining.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isDirectTest() {
        initialize(Raw.floatBufferAssertion(), ByteBuffer.allocateDirect(12).asFloatBuffer()).isDirect();
        initialize(Raw.floatBufferAssertion(), ByteBuffer.allocateDirect(12).asFloatBuffer()).isNotNull().isDirect().isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), ByteBuffer.allocate(12).asFloatBuffer()).isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be direct.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), ByteBuffer.allocate(12).asFloatBuffer(), "Message").isDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be direct.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNotDirectTest() {
        initialize(Raw.floatBufferAssertion(), ByteBuffer.allocate(12).asFloatBuffer()).isNotDirect();
        initialize(Raw.floatBufferAssertion(), ByteBuffer.allocate(12).asFloatBuffer()).isNotNull().isNotDirect().isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), ByteBuffer.allocateDirect(12).asFloatBuffer()).isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be direct.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), ByteBuffer.allocateDirect(12).asFloatBuffer(), "Message").isNotDirect();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be direct.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isReadOnlyTest() {
        FloatBuffer buffer = ByteBuffer.allocate(12).asFloatBuffer();
        FloatBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.floatBufferAssertion(), readOnlyBuffer).isReadOnly();
        initialize(Raw.floatBufferAssertion(), readOnlyBuffer).isNotNull().isReadOnly().isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), buffer).isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be read only.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), buffer, "Message").isReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be read only.");
        }
    }

    /**
     * {@link FloatBufferAssertion} class test.
     */
    @Test
    public void isNotReadOnlyTest() {
        FloatBuffer buffer = ByteBuffer.allocate(12).asFloatBuffer();
        FloatBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        initialize(Raw.floatBufferAssertion(), buffer).isNotReadOnly();
        initialize(Raw.floatBufferAssertion(), buffer).isNotNull().isNotReadOnly().isInstanceOf(FloatBuffer.class);

        try {
            Raw.floatBufferAssertion().isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null).isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), null, "Message").isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), readOnlyBuffer).isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be read only.");
        }
        try {
            initialize(Raw.floatBufferAssertion(), readOnlyBuffer, "Message").isNotReadOnly();
            Assertions.fail("FloatBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be read only.");
        }
    }

}
