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

import java.nio.DoubleBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link DoubleBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleBufferAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleBufferAggregateAssertionTest() {
        super();
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toMin().isNull();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).toMin().isEqualTo(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).toMin().isEqualTo(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).toMin().isEqualTo(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).toMin().isEqualTo(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).toMin().isEqualTo(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).toMin().isEqualTo(2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).toMin().isEqualTo(2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).toMin().isEqualTo(15.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().toMin().isEqualTo(1.0);

        try {
            Raw.doubleBufferAssertion().toMin();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toMin();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toMin();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).toMin()).isEqualTo(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").toMin()).isEqualTo(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).toMin().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").toMin().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).toMin().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").toMin().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toMin(Matchers.nullValue());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).toMin(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).toMin(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).toMin(Matchers.is(Matchers.equalTo(-Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).toMin(Matchers.is(Matchers.equalTo(-Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).toMin(Matchers.is(Matchers.equalTo(-Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).toMin(Matchers.is(Matchers.equalTo(2.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).toMin(Matchers.is(Matchers.equalTo(2.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).toMin(Matchers.is(Matchers.equalTo(15.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().toMin(Matchers.is(Matchers.equalTo(1.0))).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().toMin(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toMin(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toMin(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").toMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).toMin(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").toMin(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).toMin(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").toMin(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toRewindAndMin().isNull();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).toRewindAndMin().isEqualTo(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).toRewindAndMin().isEqualTo(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).toRewindAndMin().isEqualTo(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).toRewindAndMin().isEqualTo(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).toRewindAndMin().isEqualTo(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).toRewindAndMin().isEqualTo(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).toRewindAndMin().isEqualTo(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).toRewindAndMin().isEqualTo(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().toRewindAndMin().isEqualTo(1.0);

        try {
            Raw.doubleBufferAssertion().toRewindAndMin();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toRewindAndMin();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toRewindAndMin();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).toRewindAndMin()).isEqualTo(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").toRewindAndMin()).isEqualTo(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).toRewindAndMin().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").toRewindAndMin().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).toRewindAndMin().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").toRewindAndMin().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinMatcherTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toRewindAndMin(Matchers.nullValue());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).toRewindAndMin(Matchers.is(Matchers.equalTo(-Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).toRewindAndMin(Matchers.is(Matchers.equalTo(-Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).toRewindAndMin(Matchers.is(Matchers.equalTo(-Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).toRewindAndMin(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().toRewindAndMin(Matchers.is(Matchers.equalTo(1.0))).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().toRewindAndMin(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toRewindAndMin(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toRewindAndMin(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toRewindAndMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toRewindAndMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toRewindAndMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").toRewindAndMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).toRewindAndMin(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").toRewindAndMin(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).toRewindAndMin(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").toRewindAndMin(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasMinDefaultDeltaPrimitiveTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMin(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasMin(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasMin(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).hasMin(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).hasMin(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).hasMin(2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).hasMin(2.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).hasMin(15.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasMin(1.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasMin(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMin(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMin(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).hasMin(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").hasMin(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).hasMin(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").hasMin(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasMinDefaultDeltaObjectTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).hasMin(null);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMin(Double.valueOf(1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasMin(Double.valueOf(1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasMin(Double.valueOf(-Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).hasMin(Double.valueOf(-Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).hasMin(Double.valueOf(-Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).hasMin(Double.valueOf(2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).hasMin(Double.valueOf(2.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).hasMin(Double.valueOf(15.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasMin(Double.valueOf(1.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasMin(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMin(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMin(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0}), "Message").hasMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).hasMin(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").hasMin(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).hasMin(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").hasMin(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasMinSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMin(1.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasMin(1.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasMin(0.95, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasMin(1.05, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasMin(-Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).hasMin(-Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).hasMin(-Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).hasMin(2.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).hasMin(2.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).hasMin(15.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasMin(1.0, 0.1).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasMin(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMin(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMin(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).hasMin(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").hasMin(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).hasMin(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").hasMin(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasMinSpecifiedDeltaObjectTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).hasMin(null, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMin(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasMin(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasMin(Double.valueOf(0.95), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasMin(Double.valueOf(1.05), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasMin(Double.valueOf(-Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).hasMin(Double.valueOf(-Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).hasMin(Double.valueOf(-Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).hasMin(Double.valueOf(2.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).hasMin(Double.valueOf(2.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).hasMin(Double.valueOf(15.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasMin(Double.valueOf(1.0), 0.1).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasMin(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMin(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMin(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMin(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMin(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMin(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0}), "Message").hasMin(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).hasMin(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").hasMin(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).hasMin(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").hasMin(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinDefaultDeltaPrimitiveTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMin(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasRewindAndMin(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasRewindAndMin(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).hasRewindAndMin(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).hasRewindAndMin(-Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).hasRewindAndMin(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).hasRewindAndMin(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).hasRewindAndMin(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasRewindAndMin(1.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasRewindAndMin(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMin(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMin(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).hasRewindAndMin(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").hasRewindAndMin(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).hasRewindAndMin(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").hasRewindAndMin(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinDefaultDeltaObjectTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).hasRewindAndMin(null);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMin(Double.valueOf(1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasRewindAndMin(Double.valueOf(1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasRewindAndMin(Double.valueOf(-Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).hasRewindAndMin(Double.valueOf(-Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).hasRewindAndMin(Double.valueOf(-Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).hasRewindAndMin(Double.valueOf(1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).hasRewindAndMin(Double.valueOf(1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).hasRewindAndMin(Double.valueOf(1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasRewindAndMin(Double.valueOf(1.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasRewindAndMin(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMin(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMin(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0}), "Message").hasRewindAndMin(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).hasRewindAndMin(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").hasRewindAndMin(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).hasRewindAndMin(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").hasRewindAndMin(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMin(1.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasRewindAndMin(1.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasRewindAndMin(0.95, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasRewindAndMin(1.05, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasRewindAndMin(-Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).hasRewindAndMin(-Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).hasRewindAndMin(-Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).hasRewindAndMin(1.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).hasRewindAndMin(1.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).hasRewindAndMin(1.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasRewindAndMin(1.0, 0.1).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasRewindAndMin(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMin(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMin(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).hasRewindAndMin(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").hasRewindAndMin(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).hasRewindAndMin(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").hasRewindAndMin(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinSpecifiedDeltaObjectTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).hasRewindAndMin(null, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMin(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasRewindAndMin(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasRewindAndMin(Double.valueOf(0.95), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{10.0, 1.0, 15.0, 25.0})).hasRewindAndMin(Double.valueOf(1.05), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasRewindAndMin(Double.valueOf(-Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE})).hasRewindAndMin(Double.valueOf(-Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0})).hasRewindAndMin(Double.valueOf(-Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 1)).hasRewindAndMin(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 2)).hasRewindAndMin(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 10.0, 2.0, 15.0, 25.0}, 3)).hasRewindAndMin(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasRewindAndMin(Double.valueOf(1.0), 0.1).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasRewindAndMin(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMin(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMin(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMin(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMin(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMin(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0}), "Message").hasRewindAndMin(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0})).hasRewindAndMin(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}), "Message").hasRewindAndMin(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1)).hasRewindAndMin(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0, 2.0}, 1), "Message").hasRewindAndMin(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toMax().isNull();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).toMax().isEqualTo(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).toMax().isEqualTo(25.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).toMax().isEqualTo(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).toMax().isEqualTo(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).toMax().isEqualTo(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).toMax().isEqualTo(25.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).toMax().isEqualTo(25.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).toMax().isEqualTo(10.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().toMax().isEqualTo(1.0);

        try {
            Raw.doubleBufferAssertion().toMax();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toMax();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toMax();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).toMax()).isEqualTo(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").toMax()).isEqualTo(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).toMax().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").toMax().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).toMax().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").toMax().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toMax(Matchers.nullValue());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).toMax(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).toMax(Matchers.is(Matchers.equalTo(25.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).toMax(Matchers.is(Matchers.equalTo(Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).toMax(Matchers.is(Matchers.equalTo(Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).toMax(Matchers.is(Matchers.equalTo(Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).toMax(Matchers.is(Matchers.equalTo(25.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).toMax(Matchers.is(Matchers.equalTo(25.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).toMax(Matchers.is(Matchers.equalTo(10.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().toMax(Matchers.is(Matchers.equalTo(1.0))).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().toMax(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toMax(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toMax(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{}), "Message").toMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).toMax(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").toMax(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).toMax(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").toMax(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toRewindAndMax().isNull();
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).toRewindAndMax().isEqualTo(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).toRewindAndMax().isEqualTo(25.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).toRewindAndMax().isEqualTo(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).toRewindAndMax().isEqualTo(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).toRewindAndMax().isEqualTo(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).toRewindAndMax().isEqualTo(30.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).toRewindAndMax().isEqualTo(30.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).toRewindAndMax().isEqualTo(30.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().toRewindAndMax().isEqualTo(1.0);

        try {
            Raw.doubleBufferAssertion().toRewindAndMax();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toRewindAndMax();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toRewindAndMax();
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).toRewindAndMax()).isEqualTo(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").toRewindAndMax()).isEqualTo(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).toRewindAndMax().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").toRewindAndMax().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).toRewindAndMax().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").toRewindAndMax().isEqualTo(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxMatcherTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).toRewindAndMax(Matchers.nullValue());
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).toRewindAndMax(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).toRewindAndMax(Matchers.is(Matchers.equalTo(25.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).toRewindAndMax(Matchers.is(Matchers.equalTo(Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).toRewindAndMax(Matchers.is(Matchers.equalTo(Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).toRewindAndMax(Matchers.is(Matchers.equalTo(Double.MAX_VALUE)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).toRewindAndMax(Matchers.is(Matchers.equalTo(30.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).toRewindAndMax(Matchers.is(Matchers.equalTo(30.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).toRewindAndMax(Matchers.is(Matchers.equalTo(30.0)));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().toRewindAndMax(Matchers.is(Matchers.equalTo(1.0))).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().toRewindAndMax(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toRewindAndMax(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toRewindAndMax(Matchers.equalTo(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).toRewindAndMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").toRewindAndMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).toRewindAndMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0}), "Message").toRewindAndMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).toRewindAndMax(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").toRewindAndMax(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).toRewindAndMax(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").toRewindAndMax(Matchers.equalTo(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasMaxDefaultDeltaPrimitiveTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMax(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasMax(25.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasMax(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).hasMax(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).hasMax(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).hasMax(25.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).hasMax(25.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).hasMax(10.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasMax(1.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasMax(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMax(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMax(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).hasMax(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").hasMax(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).hasMax(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").hasMax(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasMaxDefaultDeltaObjectTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).hasMax(null);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMax(Double.valueOf(1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasMax(Double.valueOf(25.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasMax(Double.valueOf(Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).hasMax(Double.valueOf(Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).hasMax(Double.valueOf(Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).hasMax(Double.valueOf(25.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).hasMax(Double.valueOf(25.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).hasMax(Double.valueOf(10.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasMax(Double.valueOf(1.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasMax(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMax(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMax(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0}), "Message").hasMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).hasMax(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").hasMax(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).hasMax(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").hasMax(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasMaxSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMax(1.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasMax(25.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasMax(24.95, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasMax(25.05, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasMax(Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).hasMax(Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).hasMax(Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).hasMax(25.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).hasMax(25.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).hasMax(10.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasMax(1.0, 0.1).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasMax(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMax(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMax(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).hasMax(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").hasMax(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).hasMax(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").hasMax(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasMaxSpecifiedDeltaObjectTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).hasMax(null, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMax(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasMax(Double.valueOf(25.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasMax(Double.valueOf(24.95), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasMax(Double.valueOf(25.05), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasMax(Double.valueOf(Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).hasMax(Double.valueOf(Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).hasMax(Double.valueOf(Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).hasMax(Double.valueOf(25.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).hasMax(Double.valueOf(25.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).hasMax(Double.valueOf(10.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasMax(Double.valueOf(1.0), 0.1).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasMax(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMax(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMax(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasMax(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasMax(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasMax(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0}), "Message").hasMax(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).hasMax(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").hasMax(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).hasMax(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").hasMax(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxDefaultDeltaPrimitiveTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMax(1.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasRewindAndMax(25.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasRewindAndMax(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).hasRewindAndMax(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).hasRewindAndMax(Double.MAX_VALUE);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).hasRewindAndMax(30.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).hasRewindAndMax(30.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).hasRewindAndMax(30.0);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasRewindAndMax(1.0).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasRewindAndMax(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMax(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMax(0.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).hasRewindAndMax(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").hasRewindAndMax(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).hasRewindAndMax(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").hasRewindAndMax(4.0);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxDefaultDeltaObjectTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).hasRewindAndMax(null);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMax(Double.valueOf(1.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasRewindAndMax(Double.valueOf(25.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasRewindAndMax(Double.valueOf(Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).hasRewindAndMax(Double.valueOf(Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).hasRewindAndMax(Double.valueOf(Double.MAX_VALUE));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).hasRewindAndMax(Double.valueOf(30.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).hasRewindAndMax(Double.valueOf(30.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).hasRewindAndMax(Double.valueOf(30.0));
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasRewindAndMax(Double.valueOf(1.0)).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasRewindAndMax(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMax(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMax(Double.valueOf(0.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0}), "Message").hasRewindAndMax(null);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).hasRewindAndMax(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").hasRewindAndMax(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).hasRewindAndMax(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").hasRewindAndMax(Double.valueOf(4.0));
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMax(1.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasRewindAndMax(25.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasRewindAndMax(24.95, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasRewindAndMax(25.05, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasRewindAndMax(Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).hasRewindAndMax(Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).hasRewindAndMax(Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).hasRewindAndMax(30.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).hasRewindAndMax(30.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).hasRewindAndMax(30.0, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasRewindAndMax(1.0, 0.1).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasRewindAndMax(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMax(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMax(0.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).hasRewindAndMax(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").hasRewindAndMax(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).hasRewindAndMax(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").hasRewindAndMax(4.0, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxSpecifiedDeltaObjectTest() {
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{})).hasRewindAndMax(null, 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMax(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasRewindAndMax(Double.valueOf(25.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasRewindAndMax(Double.valueOf(24.95), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{15.0, 25.0, 10.0, 1.0})).hasRewindAndMax(Double.valueOf(25.05), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0})).hasRewindAndMax(Double.valueOf(Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE})).hasRewindAndMax(Double.valueOf(Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0})).hasRewindAndMax(Double.valueOf(Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 1)).hasRewindAndMax(Double.valueOf(30.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 2)).hasRewindAndMax(Double.valueOf(30.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{30.0, 15.0, 25.0, 10.0, 1.0}, 3)).hasRewindAndMax(Double.valueOf(30.0), 0.1);
        initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).isNotNull().hasRewindAndMax(Double.valueOf(1.0), 0.1).isInstanceOf(DoubleBuffer.class);

        try {
            Raw.doubleBufferAssertion().hasRewindAndMax(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMax(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMax(Double.valueOf(0.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null).hasRewindAndMax(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), null, "Message").hasRewindAndMax(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0})).hasRewindAndMax(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{1.0}), "Message").hasRewindAndMax(null, 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0})).hasRewindAndMax(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}), "Message").hasRewindAndMax(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1)).hasRewindAndMax(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleBufferAssertion(), createDoubleBuffer(new double[]{2.0, 1.0}, 1), "Message").hasRewindAndMax(Double.valueOf(4.0), 0.1);
            Assertions.fail(DoubleBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
    }

}
