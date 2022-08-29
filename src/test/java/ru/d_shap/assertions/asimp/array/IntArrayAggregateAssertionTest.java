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
 * Tests for {@link IntArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayAggregateAssertionTest() {
        super();
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.intArrayAssertion(), new int[]{}).toMin().isNull();
        initialize(Raw.intArrayAssertion(), new int[]{1}).toMin().isEqualTo(1);
        initialize(Raw.intArrayAssertion(), new int[]{10, 1, 15, 25}).toMin().isEqualTo(1);
        initialize(Raw.intArrayAssertion(), new int[]{Integer.MIN_VALUE, 100, -100, 100, 100}).toMin().isEqualTo(Integer.MIN_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, 100, 100, Integer.MIN_VALUE}).toMin().isEqualTo(Integer.MIN_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, Integer.MIN_VALUE, 100, 100}).toMin().isEqualTo(Integer.MIN_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{1}).isNotNull().toMin().isEqualTo(1);

        try {
            Raw.intArrayAssertion().toMin();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).toMin();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").toMin();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toMin()).isEqualTo(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").toMin()).isEqualTo(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toMin().isEqualTo(4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").toMin().isEqualTo(4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.intArrayAssertion(), new int[]{}).toMin(Matchers.nullValue());
        initialize(Raw.intArrayAssertion(), new int[]{1}).toMin(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intArrayAssertion(), new int[]{10, 1, 15, 25}).toMin(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intArrayAssertion(), new int[]{Integer.MIN_VALUE, 100, -100, 100, 100}).toMin(Matchers.is(Matchers.equalTo(Integer.MIN_VALUE)));
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, 100, 100, Integer.MIN_VALUE}).toMin(Matchers.is(Matchers.equalTo(Integer.MIN_VALUE)));
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, Integer.MIN_VALUE, 100, 100}).toMin(Matchers.is(Matchers.equalTo(Integer.MIN_VALUE)));
        initialize(Raw.intArrayAssertion(), new int[]{1}).isNotNull().toMin(Matchers.is(Matchers.equalTo(1))).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().toMin(Matchers.equalTo(0));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).toMin(Matchers.equalTo(0));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").toMin(Matchers.equalTo(0));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).toMin(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").toMin(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).toMin(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").toMin(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toMin(Matchers.equalTo(4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").toMin(Matchers.equalTo(4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: <4>\n     but: was <1>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1}).hasMin(1);
        initialize(Raw.intArrayAssertion(), new int[]{10, 1, 15, 25}).hasMin(1);
        initialize(Raw.intArrayAssertion(), new int[]{Integer.MIN_VALUE, 100, -100, 100, 100}).hasMin(Integer.MIN_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, 100, 100, Integer.MIN_VALUE}).hasMin(Integer.MIN_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, Integer.MIN_VALUE, 100, 100}).hasMin(Integer.MIN_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{1}).isNotNull().hasMin(1).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().hasMin(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).hasMin(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").hasMin(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).hasMin(4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").hasMin(4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.intArrayAssertion(), new int[]{}).hasMin(null);
        initialize(Raw.intArrayAssertion(), new int[]{1}).hasMin(Integer.valueOf("1"));
        initialize(Raw.intArrayAssertion(), new int[]{10, 1, 15, 25}).hasMin(Integer.valueOf("1"));
        initialize(Raw.intArrayAssertion(), new int[]{Integer.MIN_VALUE, 100, -100, 100, 100}).hasMin(Integer.valueOf("-2147483648"));
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, 100, 100, Integer.MIN_VALUE}).hasMin(Integer.valueOf("-2147483648"));
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, Integer.MIN_VALUE, 100, 100}).hasMin(Integer.valueOf("-2147483648"));
        initialize(Raw.intArrayAssertion(), new int[]{1}).isNotNull().hasMin(Integer.valueOf("1")).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().hasMin(Integer.valueOf("0"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).hasMin(Integer.valueOf("0"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").hasMin(Integer.valueOf("0"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).hasMin(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").hasMin(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1}).hasMin(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1}, "Message").hasMin(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).hasMin(Integer.valueOf("4"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").hasMin(Integer.valueOf("4"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<1>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.intArrayAssertion(), new int[]{}).toMax().isNull();
        initialize(Raw.intArrayAssertion(), new int[]{1}).toMax().isEqualTo(1);
        initialize(Raw.intArrayAssertion(), new int[]{10, 1, 15, 25}).toMax().isEqualTo(25);
        initialize(Raw.intArrayAssertion(), new int[]{Integer.MAX_VALUE, 100, -100, 100, 100}).toMax().isEqualTo(Integer.MAX_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, 100, 100, Integer.MAX_VALUE}).toMax().isEqualTo(Integer.MAX_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, Integer.MAX_VALUE, 100, 100}).toMax().isEqualTo(Integer.MAX_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{1}).isNotNull().toMax().isEqualTo(1);

        try {
            Raw.intArrayAssertion().toMax();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).toMax();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").toMax();
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toMax()).isEqualTo(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").toMax()).isEqualTo(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toMax().isEqualTo(4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").toMax().isEqualTo(4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.intArrayAssertion(), new int[]{}).toMax(Matchers.nullValue());
        initialize(Raw.intArrayAssertion(), new int[]{1}).toMax(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.intArrayAssertion(), new int[]{10, 1, 15, 25}).toMax(Matchers.is(Matchers.equalTo(25)));
        initialize(Raw.intArrayAssertion(), new int[]{Integer.MAX_VALUE, 100, -100, 100, 100}).toMax(Matchers.is(Matchers.equalTo(Integer.MAX_VALUE)));
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, 100, 100, Integer.MAX_VALUE}).toMax(Matchers.is(Matchers.equalTo(Integer.MAX_VALUE)));
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, Integer.MAX_VALUE, 100, 100}).toMax(Matchers.is(Matchers.equalTo(Integer.MAX_VALUE)));
        initialize(Raw.intArrayAssertion(), new int[]{1}).isNotNull().toMax(Matchers.is(Matchers.equalTo(1))).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().toMax(Matchers.equalTo(0));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).toMax(Matchers.equalTo(0));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").toMax(Matchers.equalTo(0));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).toMax(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").toMax(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}).toMax(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{}, "Message").toMax(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).toMax(Matchers.equalTo(4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").toMax(Matchers.equalTo(4));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.intArrayAssertion(), new int[]{1}).hasMax(1);
        initialize(Raw.intArrayAssertion(), new int[]{10, 1, 15, 25}).hasMax(25);
        initialize(Raw.intArrayAssertion(), new int[]{Integer.MAX_VALUE, 100, -100, 100, 100}).hasMax(Integer.MAX_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, 100, 100, Integer.MAX_VALUE}).hasMax(Integer.MAX_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, Integer.MAX_VALUE, 100, 100}).hasMax(Integer.MAX_VALUE);
        initialize(Raw.intArrayAssertion(), new int[]{1}).isNotNull().hasMax(1).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().hasMax(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).hasMax(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").hasMax(0);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).hasMax(4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").hasMax(4);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link IntArrayAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.intArrayAssertion(), new int[]{}).hasMax(null);
        initialize(Raw.intArrayAssertion(), new int[]{1}).hasMax(Integer.valueOf("1"));
        initialize(Raw.intArrayAssertion(), new int[]{10, 1, 15, 25}).hasMax(Integer.valueOf("25"));
        initialize(Raw.intArrayAssertion(), new int[]{Integer.MAX_VALUE, 100, -100, 100, 100}).hasMax(Integer.valueOf("2147483647"));
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, 100, 100, Integer.MAX_VALUE}).hasMax(Integer.valueOf("2147483647"));
        initialize(Raw.intArrayAssertion(), new int[]{100, -100, Integer.MAX_VALUE, 100, 100}).hasMax(Integer.valueOf("2147483647"));
        initialize(Raw.intArrayAssertion(), new int[]{1}).isNotNull().hasMax(Integer.valueOf("1")).isInstanceOf(int[].class);

        try {
            Raw.intArrayAssertion().hasMax(Integer.valueOf("0"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).hasMax(Integer.valueOf("0"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").hasMax(Integer.valueOf("0"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null).hasMax(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), null, "Message").hasMax(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1}).hasMax(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1}, "Message").hasMax(null);
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}).hasMax(Integer.valueOf("4"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.intArrayAssertion(), new int[]{1, 2}, "Message").hasMax(Integer.valueOf("4"));
            Assertions.fail("IntArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

}
