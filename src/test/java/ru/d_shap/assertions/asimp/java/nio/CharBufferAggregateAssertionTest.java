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

import java.nio.CharBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link CharBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharBufferAggregateAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharBufferAggregateAssertionTest() {
        super();
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void toMinTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toMin().isNull();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).toMin().isEqualTo('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '5', 'F'})).toMin().isEqualTo('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'})).toMin().isEqualTo(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE})).toMin().isEqualTo(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'})).toMin().isEqualTo(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 1)).toMin().isEqualTo('2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 2)).toMin().isEqualTo('2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 3)).toMin().isEqualTo('5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().toMin().isEqualTo('1');

        try {
            Raw.charBufferAssertion().toMin();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toMin();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toMin();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).toMin()).isEqualTo('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").toMin()).isEqualTo('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).toMin().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").toMin().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).toMin().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").toMin().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void toMinMatcherTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toMin(Matchers.nullValue());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).toMin(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '5', 'F'})).toMin(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'})).toMin(Matchers.is(Matchers.equalTo(Character.MIN_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE})).toMin(Matchers.is(Matchers.equalTo(Character.MIN_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'})).toMin(Matchers.is(Matchers.equalTo(Character.MIN_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 1)).toMin(Matchers.is(Matchers.equalTo('2')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 2)).toMin(Matchers.is(Matchers.equalTo('2')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 3)).toMin(Matchers.is(Matchers.equalTo('5')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().toMin(Matchers.is(Matchers.equalTo('1'))).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().toMin(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toMin(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toMin(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").toMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).toMin(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").toMin(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).toMin(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").toMin(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toRewindAndMin().isNull();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).toRewindAndMin().isEqualTo('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '5', 'F'})).toRewindAndMin().isEqualTo('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'})).toRewindAndMin().isEqualTo(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE})).toRewindAndMin().isEqualTo(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'})).toRewindAndMin().isEqualTo(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 1)).toRewindAndMin().isEqualTo('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 2)).toRewindAndMin().isEqualTo('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 3)).toRewindAndMin().isEqualTo('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().toRewindAndMin().isEqualTo('1');

        try {
            Raw.charBufferAssertion().toRewindAndMin();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toRewindAndMin();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toRewindAndMin();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).toRewindAndMin()).isEqualTo('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").toRewindAndMin()).isEqualTo('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).toRewindAndMin().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").toRewindAndMin().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).toRewindAndMin().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").toRewindAndMin().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMinMatcherTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toRewindAndMin(Matchers.nullValue());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).toRewindAndMin(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '5', 'F'})).toRewindAndMin(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'})).toRewindAndMin(Matchers.is(Matchers.equalTo(Character.MIN_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE})).toRewindAndMin(Matchers.is(Matchers.equalTo(Character.MIN_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'})).toRewindAndMin(Matchers.is(Matchers.equalTo(Character.MIN_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 1)).toRewindAndMin(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 2)).toRewindAndMin(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 3)).toRewindAndMin(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().toRewindAndMin(Matchers.is(Matchers.equalTo('1'))).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().toRewindAndMin(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toRewindAndMin(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toRewindAndMin(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toRewindAndMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toRewindAndMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toRewindAndMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").toRewindAndMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).toRewindAndMin(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").toRewindAndMin(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).toRewindAndMin(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").toRewindAndMin(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void hasMinPrimitiveTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasMin('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '5', 'F'})).hasMin('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'})).hasMin(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE})).hasMin(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'})).hasMin(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 1)).hasMin('2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 2)).hasMin('2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 3)).hasMin('5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().hasMin('1').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().hasMin('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasMin('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasMin('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).hasMin('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").hasMin('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).hasMin('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").hasMin('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void hasMinObjectTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).hasMin(null);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasMin(Character.valueOf('1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '5', 'F'})).hasMin(Character.valueOf('1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'})).hasMin(Character.valueOf(Character.MIN_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE})).hasMin(Character.valueOf(Character.MIN_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'})).hasMin(Character.valueOf(Character.MIN_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 1)).hasMin(Character.valueOf('2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 2)).hasMin(Character.valueOf('2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 3)).hasMin(Character.valueOf('5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().hasMin(Character.valueOf('1')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().hasMin(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasMin(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasMin(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'}), "Message").hasMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).hasMin(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").hasMin(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).hasMin(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").hasMin(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinPrimitiveTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasRewindAndMin('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '5', 'F'})).hasRewindAndMin('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'})).hasRewindAndMin(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE})).hasRewindAndMin(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'})).hasRewindAndMin(Character.MIN_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 1)).hasRewindAndMin('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 2)).hasRewindAndMin('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 3)).hasRewindAndMin('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().hasRewindAndMin('1').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().hasRewindAndMin('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasRewindAndMin('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasRewindAndMin('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).hasRewindAndMin('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").hasRewindAndMin('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).hasRewindAndMin('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").hasRewindAndMin('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMinObjectTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).hasRewindAndMin(null);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasRewindAndMin(Character.valueOf('1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '5', 'F'})).hasRewindAndMin(Character.valueOf('1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MIN_VALUE, 'a', 'X', 'a', 'a'})).hasRewindAndMin(Character.valueOf(Character.MIN_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MIN_VALUE})).hasRewindAndMin(Character.valueOf(Character.MIN_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MIN_VALUE, 'a', 'a'})).hasRewindAndMin(Character.valueOf(Character.MIN_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 1)).hasRewindAndMin(Character.valueOf('1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 2)).hasRewindAndMin(Character.valueOf('1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', 'a', '2', '5', 'F'}, 3)).hasRewindAndMin(Character.valueOf('1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().hasRewindAndMin(Character.valueOf('1')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().hasRewindAndMin(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasRewindAndMin(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasRewindAndMin(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasRewindAndMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasRewindAndMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasRewindAndMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'}), "Message").hasRewindAndMin(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).hasRewindAndMin(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").hasRewindAndMin(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).hasRewindAndMin(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").hasRewindAndMin(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's minimum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void toMaxTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toMax().isNull();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).toMax().isEqualTo('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'F', 'a', '5', '1'})).toMax().isEqualTo('a');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'})).toMax().isEqualTo(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE})).toMax().isEqualTo(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'})).toMax().isEqualTo(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 1)).toMax().isEqualTo('a');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 2)).toMax().isEqualTo('a');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 3)).toMax().isEqualTo('5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().toMax().isEqualTo('1');

        try {
            Raw.charBufferAssertion().toMax();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toMax();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toMax();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).toMax()).isEqualTo('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").toMax()).isEqualTo('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).toMax().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").toMax().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1)).toMax().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1), "Message").toMax().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void toMaxMatcherTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toMax(Matchers.nullValue());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).toMax(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'F', 'a', '5', '1'})).toMax(Matchers.is(Matchers.equalTo('a')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'})).toMax(Matchers.is(Matchers.equalTo(Character.MAX_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE})).toMax(Matchers.is(Matchers.equalTo(Character.MAX_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'})).toMax(Matchers.is(Matchers.equalTo(Character.MAX_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 1)).toMax(Matchers.is(Matchers.equalTo('a')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 2)).toMax(Matchers.is(Matchers.equalTo('a')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 3)).toMax(Matchers.is(Matchers.equalTo('5')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().toMax(Matchers.is(Matchers.equalTo('1'))).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().toMax(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toMax(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toMax(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").toMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).toMax(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").toMax(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1)).toMax(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1), "Message").toMax(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: \"4\"\n     but: was \"1\"");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toRewindAndMax().isNull();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).toRewindAndMax().isEqualTo('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'F', 'a', '5', '1'})).toRewindAndMax().isEqualTo('a');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'})).toRewindAndMax().isEqualTo(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE})).toRewindAndMax().isEqualTo(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'})).toRewindAndMax().isEqualTo(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 1)).toRewindAndMax().isEqualTo('c');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 2)).toRewindAndMax().isEqualTo('c');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 3)).toRewindAndMax().isEqualTo('c');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().toRewindAndMax().isEqualTo('1');

        try {
            Raw.charBufferAssertion().toRewindAndMax();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toRewindAndMax();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toRewindAndMax();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).toRewindAndMax()).isEqualTo('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").toRewindAndMax()).isEqualTo('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).toRewindAndMax().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").toRewindAndMax().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1)).toRewindAndMax().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1), "Message").toRewindAndMax().isEqualTo('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void toRewindAndMaxMatcherTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).toRewindAndMax(Matchers.nullValue());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).toRewindAndMax(Matchers.is(Matchers.equalTo('1')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'F', 'a', '5', '1'})).toRewindAndMax(Matchers.is(Matchers.equalTo('a')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'})).toRewindAndMax(Matchers.is(Matchers.equalTo(Character.MAX_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE})).toRewindAndMax(Matchers.is(Matchers.equalTo(Character.MAX_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'})).toRewindAndMax(Matchers.is(Matchers.equalTo(Character.MAX_VALUE)));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 1)).toRewindAndMax(Matchers.is(Matchers.equalTo('c')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 2)).toRewindAndMax(Matchers.is(Matchers.equalTo('c')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 3)).toRewindAndMax(Matchers.is(Matchers.equalTo('c')));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().toRewindAndMax(Matchers.is(Matchers.equalTo('1'))).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().toRewindAndMax(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toRewindAndMax(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toRewindAndMax(Matchers.equalTo('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).toRewindAndMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").toRewindAndMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).toRewindAndMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'}), "Message").toRewindAndMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).toRewindAndMax(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").toRewindAndMax(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1)).toRewindAndMax(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1), "Message").toRewindAndMax(Matchers.equalTo('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\nExpected: \"4\"\n     but: was \"2\"");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void hasMaxPrimitiveTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasMax('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'F', 'a', '5', '1'})).hasMax('a');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'})).hasMax(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE})).hasMax(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'})).hasMax(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 1)).hasMax('a');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 2)).hasMax('a');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 3)).hasMax('5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().hasMax('1').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().hasMax('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasMax('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasMax('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).hasMax('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").hasMax('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1)).hasMax('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1), "Message").hasMax('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void hasMaxObjectTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).hasMax(null);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasMax(Character.valueOf('1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'F', 'a', '5', '1'})).hasMax(Character.valueOf('a'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'})).hasMax(Character.valueOf(Character.MAX_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE})).hasMax(Character.valueOf(Character.MAX_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'})).hasMax(Character.valueOf(Character.MAX_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 1)).hasMax(Character.valueOf('a'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 2)).hasMax(Character.valueOf('a'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 3)).hasMax(Character.valueOf('5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().hasMax(Character.valueOf('1')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().hasMax(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasMax(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasMax(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'}), "Message").hasMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).hasMax(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").hasMax(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1)).hasMax(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1), "Message").hasMax(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<1(49)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxPrimitiveTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasRewindAndMax('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'F', 'a', '5', '1'})).hasRewindAndMax('a');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'})).hasRewindAndMax(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE})).hasRewindAndMax(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'})).hasRewindAndMax(Character.MAX_VALUE);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 1)).hasRewindAndMax('c');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 2)).hasRewindAndMax('c');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 3)).hasRewindAndMax('c');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().hasRewindAndMax('1').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().hasRewindAndMax('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasRewindAndMax('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasRewindAndMax('0');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).hasRewindAndMax('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").hasRewindAndMax('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1)).hasRewindAndMax('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1), "Message").hasRewindAndMax('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndMaxObjectTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).hasRewindAndMax(null);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasRewindAndMax(Character.valueOf('1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'F', 'a', '5', '1'})).hasRewindAndMax(Character.valueOf('a'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{Character.MAX_VALUE, 'a', 'X', 'a', 'a'})).hasRewindAndMax(Character.valueOf(Character.MAX_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', 'a', 'a', Character.MAX_VALUE})).hasRewindAndMax(Character.valueOf(Character.MAX_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'a', 'X', Character.MAX_VALUE, 'a', 'a'})).hasRewindAndMax(Character.valueOf(Character.MAX_VALUE));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 1)).hasRewindAndMax(Character.valueOf('c'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 2)).hasRewindAndMax(Character.valueOf('c'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'c', 'F', 'a', '5', '1'}, 3)).hasRewindAndMax(Character.valueOf('c'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).isNotNull().hasRewindAndMax(Character.valueOf('1')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().hasRewindAndMax(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasRewindAndMax(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasRewindAndMax(Character.valueOf('0'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).hasRewindAndMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").hasRewindAndMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'})).hasRewindAndMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1'}), "Message").hasRewindAndMax(null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'})).hasRewindAndMax(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}), "Message").hasRewindAndMax(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1)).hasRewindAndMax(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'2', '1'}, 1), "Message").hasRewindAndMax(Character.valueOf('4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's maximum value.\n\tActual and expected values should be the same.\n\tExpected:<4(52)> but was:<2(50)>");
        }
    }

}
