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
 * Tests for {@link DoubleArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleArrayAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleArrayAggregateAssertionTest() {
        super();
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).toMin().isNull();
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).toMin().isEqualTo(1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).toMin().isEqualTo(1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).toMin().isEqualTo(-Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE}).toMin().isEqualTo(-Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0}).toMin().isEqualTo(-Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().toMin().isEqualTo(1.0);

        try {
            Raw.doubleArrayAssertion().toMin();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toMin();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toMin();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toMin()).isEqualTo(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toMin()).isEqualTo(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toMin().isEqualTo(4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toMin().isEqualTo(4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).toMin(Matchers.nullValue());
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).toMin(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).toMin(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleArrayAssertion(), new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).toMin(Matchers.is(Matchers.equalTo(-Double.MAX_VALUE)));
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE}).toMin(Matchers.is(Matchers.equalTo(-Double.MAX_VALUE)));
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0}).toMin(Matchers.is(Matchers.equalTo(-Double.MAX_VALUE)));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().toMin(Matchers.is(Matchers.equalTo(1.0))).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().toMin(Matchers.equalTo(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toMin(Matchers.equalTo(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toMin(Matchers.equalTo(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toMin(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toMin(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).toMin(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").toMin(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toMin(Matchers.equalTo(4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toMin(Matchers.equalTo(4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4.0>\n     but: was <1.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasMinDefaultDeltaPrimitiveTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMin(1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMin(1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).hasMin(-Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE}).hasMin(-Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0}).hasMin(-Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().hasMin(1.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().hasMin(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMin(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMin(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasMin(4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasMin(4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasMinDefaultDeltaObjectTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).hasMin(null);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMin(Double.valueOf(1.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMin(Double.valueOf(1.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).hasMin(Double.valueOf(-Double.MAX_VALUE));
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE}).hasMin(Double.valueOf(-Double.MAX_VALUE));
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0}).hasMin(Double.valueOf(-Double.MAX_VALUE));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().hasMin(Double.valueOf(1.0)).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().hasMin(Double.valueOf(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMin(Double.valueOf(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMin(Double.valueOf(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMin(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMin(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMin(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0}, "Message").hasMin(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasMin(Double.valueOf(4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasMin(Double.valueOf(4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasMinSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMin(1.0, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMin(1.0, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMin(0.95, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMin(1.05, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).hasMin(-Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE}).hasMin(-Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0}).hasMin(-Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().hasMin(1.0, 0.1).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().hasMin(0.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMin(0.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMin(0.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasMin(4.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasMin(4.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasMinSpecifiedDeltaObjectTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).hasMin(null, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMin(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMin(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMin(Double.valueOf(0.95), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMin(Double.valueOf(1.05), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{-Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).hasMin(Double.valueOf(-Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, -Double.MAX_VALUE}).hasMin(Double.valueOf(-Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, -Double.MAX_VALUE, 100.0, 100.0}).hasMin(Double.valueOf(-Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().hasMin(Double.valueOf(1.0), 0.1).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().hasMin(Double.valueOf(0.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMin(Double.valueOf(0.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMin(Double.valueOf(0.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMin(null, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMin(null, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMin(null, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0}, "Message").hasMin(null, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasMin(Double.valueOf(4.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasMin(Double.valueOf(4.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<1.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).toMax().isNull();
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).toMax().isEqualTo(1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).toMax().isEqualTo(25.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).toMax().isEqualTo(Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE}).toMax().isEqualTo(Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0}).toMax().isEqualTo(Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().toMax().isEqualTo(1.0);

        try {
            Raw.doubleArrayAssertion().toMax();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toMax();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toMax();
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toMax()).isEqualTo(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toMax()).isEqualTo(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toMax().isEqualTo(4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toMax().isEqualTo(4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).toMax(Matchers.nullValue());
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).toMax(Matchers.is(Matchers.equalTo(1.0)));
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).toMax(Matchers.is(Matchers.equalTo(25.0)));
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).toMax(Matchers.is(Matchers.equalTo(Double.MAX_VALUE)));
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE}).toMax(Matchers.is(Matchers.equalTo(Double.MAX_VALUE)));
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0}).toMax(Matchers.is(Matchers.equalTo(Double.MAX_VALUE)));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().toMax(Matchers.is(Matchers.equalTo(1.0))).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().toMax(Matchers.equalTo(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toMax(Matchers.equalTo(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toMax(Matchers.equalTo(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).toMax(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").toMax(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}).toMax(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{}, "Message").toMax(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).toMax(Matchers.equalTo(4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").toMax(Matchers.equalTo(4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4.0>\n     but: was <2.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasMaxDefaultDeltaPrimitiveTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMax(1.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMax(25.0);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).hasMax(Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE}).hasMax(Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0}).hasMax(Double.MAX_VALUE);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().hasMax(1.0).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().hasMax(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMax(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMax(0.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasMax(4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasMax(4.0);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasMaxDefaultDeltaObjectTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).hasMax(null);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMax(Double.valueOf(1.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMax(Double.valueOf(25.0));
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).hasMax(Double.valueOf(Double.MAX_VALUE));
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE}).hasMax(Double.valueOf(Double.MAX_VALUE));
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0}).hasMax(Double.valueOf(Double.MAX_VALUE));
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().hasMax(Double.valueOf(1.0)).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().hasMax(Double.valueOf(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMax(Double.valueOf(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMax(Double.valueOf(0.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMax(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMax(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMax(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0}, "Message").hasMax(null);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasMax(Double.valueOf(4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasMax(Double.valueOf(4.0));
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±9.999999960041972E-12> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasMaxSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMax(1.0, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMax(25.0, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMax(24.95, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMax(25.05, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).hasMax(Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE}).hasMax(Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0}).hasMax(Double.MAX_VALUE, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().hasMax(1.0, 0.1).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().hasMax(0.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMax(0.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMax(0.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasMax(4.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasMax(4.0, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
    }

    /**
     * {@link DoubleArrayAssertion} class test.
     */
    @Test
    public void hasMaxSpecifiedDeltaObjectTest() {
        initialize(Raw.doubleArrayAssertion(), new double[]{}).hasMax(null, 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMax(Double.valueOf(1.0), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMax(Double.valueOf(25.0), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMax(Double.valueOf(24.95), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{10.0, 1.0, 15.0, 25.0}).hasMax(Double.valueOf(25.05), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{Double.MAX_VALUE, 100.0, -100.0, 100.0, 100.0}).hasMax(Double.valueOf(Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, 100.0, 100.0, Double.MAX_VALUE}).hasMax(Double.valueOf(Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{100.0, -100.0, Double.MAX_VALUE, 100.0, 100.0}).hasMax(Double.valueOf(Double.MAX_VALUE), 0.1);
        initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).isNotNull().hasMax(Double.valueOf(1.0), 0.1).isInstanceOf(double[].class);

        try {
            Raw.doubleArrayAssertion().hasMax(Double.valueOf(0.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMax(Double.valueOf(0.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMax(Double.valueOf(0.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null).hasMax(null, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), null, "Message").hasMax(null, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0}).hasMax(null, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0}, "Message").hasMax(null, 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}).hasMax(Double.valueOf(4.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
        try {
            initialize(Raw.doubleArrayAssertion(), new double[]{1.0, 2.0}, "Message").hasMax(Double.valueOf(4.0), 0.1);
            Assertions.fail("DoubleArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4.0±0.1> but was:<2.0>");
        }
    }

}
