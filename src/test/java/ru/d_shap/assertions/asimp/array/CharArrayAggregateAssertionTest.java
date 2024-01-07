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
 * Tests for {@link CharArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharArrayAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharArrayAggregateAssertionTest() {
        super();
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.charArrayAssertion(), new char[]{}).toMin().isNull();
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).toMin().isEqualTo('1');
        initialize(Raw.charArrayAssertion(), new char[]{'1', 'a', '5', 'F'}).toMin().isEqualTo('1');
        initialize(Raw.charArrayAssertion(), new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'}).toMin().isEqualTo(Character.MIN_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE}).toMin().isEqualTo(Character.MIN_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'}).toMin().isEqualTo(Character.MIN_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).isNotNull().toMin().isEqualTo('1');

        try {
            Raw.charArrayAssertion().toMin();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).toMin();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").toMin();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toMin()).isEqualTo('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").toMin()).isEqualTo('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toMin().isEqualTo('4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").toMin().isEqualTo('4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.charArrayAssertion(), new char[]{}).toMin(Matchers.nullValue());
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).toMin(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charArrayAssertion(), new char[]{'1', 'a', '5', 'F'}).toMin(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charArrayAssertion(), new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'}).toMin(Matchers.is(Matchers.equalTo(Character.MIN_VALUE)));
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE}).toMin(Matchers.is(Matchers.equalTo(Character.MIN_VALUE)));
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'}).toMin(Matchers.is(Matchers.equalTo(Character.MIN_VALUE)));
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).isNotNull().toMin(Matchers.is(Matchers.equalTo('1'))).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().toMin(Matchers.equalTo('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).toMin(Matchers.equalTo('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").toMin(Matchers.equalTo('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).toMin(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").toMin(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).toMin(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").toMin(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toMin(Matchers.equalTo('4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").toMin(Matchers.equalTo('4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).hasMin('1');
        initialize(Raw.charArrayAssertion(), new char[]{'1', 'a', '5', 'F'}).hasMin('1');
        initialize(Raw.charArrayAssertion(), new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'}).hasMin(Character.MIN_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE}).hasMin(Character.MIN_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'}).hasMin(Character.MIN_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).isNotNull().hasMin('1').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().hasMin('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).hasMin('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").hasMin('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).hasMin('4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").hasMin('4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.charArrayAssertion(), new char[]{}).hasMin(null);
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).hasMin(Character.valueOf('1'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', 'a', '5', 'F'}).hasMin(Character.valueOf('1'));
        initialize(Raw.charArrayAssertion(), new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'}).hasMin(Character.valueOf(Character.MIN_VALUE));
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE}).hasMin(Character.valueOf(Character.MIN_VALUE));
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'}).hasMin(Character.valueOf(Character.MIN_VALUE));
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).isNotNull().hasMin(Character.valueOf('1')).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().hasMin(Character.valueOf('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).hasMin(Character.valueOf('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").hasMin(Character.valueOf('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).hasMin(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").hasMin(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1'}).hasMin(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1'}, "Message").hasMin(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).hasMin(Character.valueOf('4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").hasMin(Character.valueOf('4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.charArrayAssertion(), new char[]{}).toMax().isNull();
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).toMax().isEqualTo('1');
        initialize(Raw.charArrayAssertion(), new char[]{'1', 'a', '5', 'F'}).toMax().isEqualTo('a');
        initialize(Raw.charArrayAssertion(), new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'}).toMax().isEqualTo(Character.MAX_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE}).toMax().isEqualTo(Character.MAX_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'}).toMax().isEqualTo(Character.MAX_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).isNotNull().toMax().isEqualTo('1');

        try {
            Raw.charArrayAssertion().toMax();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).toMax();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").toMax();
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toMax()).isEqualTo('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").toMax()).isEqualTo('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toMax().isEqualTo('4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").toMax().isEqualTo('4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.charArrayAssertion(), new char[]{}).toMax(Matchers.nullValue());
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).toMax(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charArrayAssertion(), new char[]{'1', 'a', '5', 'F'}).toMax(Matchers.is(Matchers.equalTo('a')));
        initialize(Raw.charArrayAssertion(), new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'}).toMax(Matchers.is(Matchers.equalTo(Character.MAX_VALUE)));
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE}).toMax(Matchers.is(Matchers.equalTo(Character.MAX_VALUE)));
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'}).toMax(Matchers.is(Matchers.equalTo(Character.MAX_VALUE)));
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).isNotNull().toMax(Matchers.is(Matchers.equalTo('1'))).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().toMax(Matchers.equalTo('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).toMax(Matchers.equalTo('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").toMax(Matchers.equalTo('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).toMax(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").toMax(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}).toMax(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{}, "Message").toMax(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).toMax(Matchers.equalTo('4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").toMax(Matchers.equalTo('4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).hasMax('1');
        initialize(Raw.charArrayAssertion(), new char[]{'1', 'a', '5', 'F'}).hasMax('a');
        initialize(Raw.charArrayAssertion(), new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'}).hasMax(Character.MAX_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE}).hasMax(Character.MAX_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'}).hasMax(Character.MAX_VALUE);
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).isNotNull().hasMax('1').isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().hasMax('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).hasMax('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").hasMax('0');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).hasMax('4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").hasMax('4');
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
    }

    /**
     * {@link CharArrayAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.charArrayAssertion(), new char[]{}).hasMax(null);
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).hasMax(Character.valueOf('1'));
        initialize(Raw.charArrayAssertion(), new char[]{'1', 'a', '5', 'F'}).hasMax(Character.valueOf('a'));
        initialize(Raw.charArrayAssertion(), new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'}).hasMax(Character.valueOf(Character.MAX_VALUE));
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE}).hasMax(Character.valueOf(Character.MAX_VALUE));
        initialize(Raw.charArrayAssertion(), new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'}).hasMax(Character.valueOf(Character.MAX_VALUE));
        initialize(Raw.charArrayAssertion(), new char[]{'1'}).isNotNull().hasMax(Character.valueOf('1')).isInstanceOf(char[].class);

        try {
            Raw.charArrayAssertion().hasMax(Character.valueOf('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).hasMax(Character.valueOf('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").hasMax(Character.valueOf('0'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null).hasMax(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), null, "Message").hasMax(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1'}).hasMax(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1'}, "Message").hasMax(null);
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}).hasMax(Character.valueOf('4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charArrayAssertion(), new char[]{'1', '2'}, "Message").hasMax(Character.valueOf('4'));
            Assertions.fail(CharArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
    }

}
