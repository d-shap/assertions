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
package ru.d_shap.assertions.asimp.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link CharAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharAssertionTest() {
        super();
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.charAssertion(), 'a');

        try {
            initializeWithRawActual(Raw.charAssertion(), new Object());
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Character> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.charAssertion(), new Object(), "Message");
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Character> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isEqualToPrimitiveTest() {
        initialize(Raw.charAssertion(), 'a').isEqualTo('a');
        initialize(Raw.charAssertion(), 'Z').isEqualTo('Z');
        initialize(Raw.charAssertion(), 'Й').isEqualTo('Й');
        initialize(Raw.charAssertion(), '5').isEqualTo('5');
        initialize(Raw.charAssertion(), 'a').isNotNull().isEqualTo('a').isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isEqualTo('Z');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<Z(90)> but was:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isEqualTo('Z');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<Z(90)> but was:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isEqualTo(10000);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:< (10000)> but was:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isEqualTo(10000);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:< (10000)> but was:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isEqualTo(100000);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<100000> but was:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isEqualTo(100000);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<100000> but was:<a(97)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isEqualToObjectTest() {
        initialize(Raw.charAssertion(), null).isEqualTo(null);
        initialize(Raw.charAssertion(), 'a').isEqualTo(Character.valueOf('a'));
        initialize(Raw.charAssertion(), 'Z').isEqualTo(Character.valueOf('Z'));
        initialize(Raw.charAssertion(), 'Й').isEqualTo(Character.valueOf('Й'));
        initialize(Raw.charAssertion(), '5').isEqualTo(Character.valueOf('5'));
        initialize(Raw.charAssertion(), 'a').isNotNull().isEqualTo(Character.valueOf('a')).isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1(49)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isEqualTo(Character.valueOf('Z'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<Z(90)> but was:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isEqualTo(Character.valueOf('Z'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<Z(90)> but was:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isEqualTo(Character.valueOf((char) 10000));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:< (10000)> but was:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isEqualTo(Character.valueOf((char) 10000));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:< (10000)> but was:<a(97)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotEqualToPrimitiveTest() {
        initialize(Raw.charAssertion(), null).isNotEqualTo('1');
        initialize(Raw.charAssertion(), 'a').isNotEqualTo('b');
        initialize(Raw.charAssertion(), 'Z').isNotEqualTo('X');
        initialize(Raw.charAssertion(), '1').isNotEqualTo('2');
        initialize(Raw.charAssertion(), 'Й').isNotEqualTo('Ё');
        initialize(Raw.charAssertion(), 'a').isNotNull().isNotEqualTo('b').isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isNotEqualTo('a');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isNotEqualTo('a');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<a(97)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotEqualToObjectTest() {
        initialize(Raw.charAssertion(), null).isNotEqualTo(Character.valueOf('1'));
        initialize(Raw.charAssertion(), '1').isNotEqualTo(null);
        initialize(Raw.charAssertion(), 'a').isNotEqualTo(Character.valueOf('b'));
        initialize(Raw.charAssertion(), 'Z').isNotEqualTo(Character.valueOf('X'));
        initialize(Raw.charAssertion(), '1').isNotEqualTo(Character.valueOf('2'));
        initialize(Raw.charAssertion(), 'Й').isNotEqualTo(Character.valueOf('Ё'));
        initialize(Raw.charAssertion(), 'a').isNotNull().isNotEqualTo(Character.valueOf('b')).isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isNotEqualTo(Character.valueOf('a'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isNotEqualTo(Character.valueOf('a'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<a(97)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanPrimitiveTest() {
        initialize(Raw.charAssertion(), 'b').isGreaterThan('a');
        initialize(Raw.charAssertion(), '7').isGreaterThan('0');
        initialize(Raw.charAssertion(), 'Z').isGreaterThan('F');
        initialize(Raw.charAssertion(), 'b').isNotNull().isGreaterThan('a').isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isGreaterThan('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isGreaterThan('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isGreaterThan('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'x').isGreaterThan('x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 'x', "Message").isGreaterThan('x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isGreaterThan('t');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<t(116)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isGreaterThan('t');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<t(116)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanObjectTest() {
        initialize(Raw.charAssertion(), 'b').isGreaterThan(Character.valueOf('a'));
        initialize(Raw.charAssertion(), '7').isGreaterThan(Character.valueOf('0'));
        initialize(Raw.charAssertion(), 'Z').isGreaterThan(Character.valueOf('F'));
        initialize(Raw.charAssertion(), 'b').isNotNull().isGreaterThan(Character.valueOf('a')).isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isGreaterThan(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isGreaterThan(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isGreaterThan(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null).isGreaterThan(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isGreaterThan(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isGreaterThan(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charAssertion(), 'x').isGreaterThan(Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 'x', "Message").isGreaterThan(Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isGreaterThan(Character.valueOf('t'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<t(116)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isGreaterThan(Character.valueOf('t'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<t(116)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToPrimitiveTest() {
        initialize(Raw.charAssertion(), 'b').isGreaterThanOrEqualTo('a');
        initialize(Raw.charAssertion(), '7').isGreaterThanOrEqualTo('7');
        initialize(Raw.charAssertion(), 'Z').isGreaterThanOrEqualTo('F');
        initialize(Raw.charAssertion(), 'b').isNotNull().isGreaterThanOrEqualTo('a').isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isGreaterThanOrEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isGreaterThanOrEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isGreaterThanOrEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'x').isGreaterThanOrEqualTo('y');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<y(121)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 'x', "Message").isGreaterThanOrEqualTo('y');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<y(121)> but was:<x(120)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToObjectTest() {
        initialize(Raw.charAssertion(), 'b').isGreaterThanOrEqualTo(Character.valueOf('a'));
        initialize(Raw.charAssertion(), '7').isGreaterThanOrEqualTo(Character.valueOf('7'));
        initialize(Raw.charAssertion(), 'Z').isGreaterThanOrEqualTo(Character.valueOf('F'));
        initialize(Raw.charAssertion(), 'b').isNotNull().isGreaterThanOrEqualTo(Character.valueOf('a')).isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isGreaterThanOrEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isGreaterThanOrEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isGreaterThanOrEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isGreaterThanOrEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charAssertion(), 'x').isGreaterThanOrEqualTo(Character.valueOf('y'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<y(121)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 'x', "Message").isGreaterThanOrEqualTo(Character.valueOf('y'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<y(121)> but was:<x(120)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanPrimitiveTest() {
        initialize(Raw.charAssertion(), 'a').isLessThan('b');
        initialize(Raw.charAssertion(), '0').isLessThan('7');
        initialize(Raw.charAssertion(), 'F').isLessThan('Z');
        initialize(Raw.charAssertion(), 'a').isNotNull().isLessThan('b').isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isLessThan('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLessThan('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLessThan('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'x').isLessThan('x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 'x', "Message").isLessThan('x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 't').isLessThan('s');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<s(115)> but was:<t(116)>");
        }
        try {
            initialize(Raw.charAssertion(), 't', "Message").isLessThan('s');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<s(115)> but was:<t(116)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanObjectTest() {
        initialize(Raw.charAssertion(), 'a').isLessThan(Character.valueOf('b'));
        initialize(Raw.charAssertion(), '0').isLessThan(Character.valueOf('7'));
        initialize(Raw.charAssertion(), 'F').isLessThan(Character.valueOf('Z'));
        initialize(Raw.charAssertion(), 'a').isNotNull().isLessThan(Character.valueOf('b')).isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isLessThan(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLessThan(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLessThan(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLessThan(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLessThan(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isLessThan(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isLessThan(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charAssertion(), 'x').isLessThan(Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 'x', "Message").isLessThan(Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 't').isLessThan(Character.valueOf('s'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<s(115)> but was:<t(116)>");
        }
        try {
            initialize(Raw.charAssertion(), 't', "Message").isLessThan(Character.valueOf('s'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<s(115)> but was:<t(116)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToPrimitiveTest() {
        initialize(Raw.charAssertion(), 'a').isLessThanOrEqualTo('b');
        initialize(Raw.charAssertion(), '7').isLessThanOrEqualTo('7');
        initialize(Raw.charAssertion(), 'F').isLessThanOrEqualTo('Z');
        initialize(Raw.charAssertion(), 'a').isNotNull().isLessThanOrEqualTo('b').isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isLessThanOrEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLessThanOrEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLessThanOrEqualTo('1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'y').isLessThanOrEqualTo('x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<x(120)> but was:<y(121)>");
        }
        try {
            initialize(Raw.charAssertion(), 'y', "Message").isLessThanOrEqualTo('x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<x(120)> but was:<y(121)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToObjectTest() {
        initialize(Raw.charAssertion(), 'a').isLessThanOrEqualTo(Character.valueOf('b'));
        initialize(Raw.charAssertion(), '7').isLessThanOrEqualTo(Character.valueOf('7'));
        initialize(Raw.charAssertion(), 'F').isLessThanOrEqualTo(Character.valueOf('Z'));
        initialize(Raw.charAssertion(), 'a').isNotNull().isLessThanOrEqualTo(Character.valueOf('b')).isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isLessThanOrEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLessThanOrEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLessThanOrEqualTo(Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isLessThanOrEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isLessThanOrEqualTo(null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charAssertion(), 'y').isLessThanOrEqualTo(Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<x(120)> but was:<y(121)>");
        }
        try {
            initialize(Raw.charAssertion(), 'y', "Message").isLessThanOrEqualTo(Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<x(120)> but was:<y(121)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isInRangePrimitiveTest() {
        initialize(Raw.charAssertion(), 's').isInRange('p', 'x');
        initialize(Raw.charAssertion(), 's').isInRange('s', 'x');
        initialize(Raw.charAssertion(), 's').isInRange('a', 'x');
        initialize(Raw.charAssertion(), 's').isNotNull().isInRange('p', 'x').isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isInRange('1', '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isInRange('1', '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isInRange('1', '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 's').isInRange('a', 's');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<a(97):s(115)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isInRange('a', 's');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<a(97):s(115)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isInRange('t', 'x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<t(116):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isInRange('t', 'x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<t(116):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isInRange('a', 'c');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<a(97):c(99)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isInRange('a', 'c');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<a(97):c(99)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isInRangeObjectTest() {
        initialize(Raw.charAssertion(), 's').isInRange(Character.valueOf('p'), Character.valueOf('x'));
        initialize(Raw.charAssertion(), 's').isInRange(Character.valueOf('s'), Character.valueOf('x'));
        initialize(Raw.charAssertion(), 's').isInRange(Character.valueOf('a'), Character.valueOf('x'));
        initialize(Raw.charAssertion(), 's').isNotNull().isInRange(Character.valueOf('p'), Character.valueOf('x')).isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isInRange(Character.valueOf('1'), Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isInRange(Character.valueOf('1'), Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isInRange(Character.valueOf('1'), Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null).isInRange(null, '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isInRange(null, '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isInRange(null, '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isInRange(null, '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isInRange(null, null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isInRange(null, null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isInRange('1', null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isInRange('1', null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charAssertion(), 's').isInRange(Character.valueOf('a'), Character.valueOf('s'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<a(97):s(115)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isInRange(Character.valueOf('a'), Character.valueOf('s'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<a(97):s(115)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isInRange(Character.valueOf('t'), Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<t(116):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isInRange(Character.valueOf('t'), Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<t(116):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isInRange(Character.valueOf('a'), Character.valueOf('c'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<a(97):c(99)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isInRange(Character.valueOf('a'), Character.valueOf('c'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<a(97):c(99)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotInRangePrimitiveTest() {
        initialize(Raw.charAssertion(), 's').isNotInRange('a', 's');
        initialize(Raw.charAssertion(), 's').isNotInRange('t', 'x');
        initialize(Raw.charAssertion(), 's').isNotInRange('a', 'c');
        initialize(Raw.charAssertion(), 's').isNotNull().isNotInRange('a', 's').isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotInRange('1', '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotInRange('1', '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotInRange('1', '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 's').isNotInRange('p', 'x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<p(112):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isNotInRange('p', 'x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<p(112):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isNotInRange('s', 'x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<s(115):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isNotInRange('s', 'x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<s(115):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isNotInRange('a', 'x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<a(97):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isNotInRange('a', 'x');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<a(97):x(120)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotInRangeObjectTest() {
        initialize(Raw.charAssertion(), 's').isNotInRange(Character.valueOf('a'), Character.valueOf('s'));
        initialize(Raw.charAssertion(), 's').isNotInRange(Character.valueOf('t'), Character.valueOf('x'));
        initialize(Raw.charAssertion(), 's').isNotInRange(Character.valueOf('a'), Character.valueOf('c'));
        initialize(Raw.charAssertion(), 's').isNotNull().isNotInRange(Character.valueOf('a'), Character.valueOf('s')).isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotInRange(Character.valueOf('1'), Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotInRange(Character.valueOf('1'), Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotInRange(Character.valueOf('1'), Character.valueOf('1'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotInRange(null, '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotInRange(null, '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isNotInRange(null, '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isNotInRange(null, '1');
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isNotInRange(null, null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isNotInRange(null, null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charAssertion(), '1').isNotInRange('1', null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charAssertion(), '1', "Message").isNotInRange('1', null);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charAssertion(), 's').isNotInRange(Character.valueOf('p'), Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<p(112):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isNotInRange(Character.valueOf('p'), Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<p(112):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isNotInRange(Character.valueOf('s'), Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<s(115):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isNotInRange(Character.valueOf('s'), Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<s(115):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isNotInRange(Character.valueOf('a'), Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<a(97):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isNotInRange(Character.valueOf('a'), Character.valueOf('x'));
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<a(97):x(120)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isAlphabeticTest() {
        initialize(Raw.charAssertion(), 'a').isAlphabetic();
        initialize(Raw.charAssertion(), 'F').isAlphabetic();
        initialize(Raw.charAssertion(), 'Й').isAlphabetic();
        initialize(Raw.charAssertion(), 'ё').isAlphabetic();
        initialize(Raw.charAssertion(), 'a').isNotNull().isAlphabetic().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '7').isAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the alphabetic symbol.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the alphabetic symbol.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the alphabetic symbol.\n\tActual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the alphabetic symbol.\n\tActual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotAlphabeticTest() {
        initialize(Raw.charAssertion(), '7').isNotAlphabetic();
        initialize(Raw.charAssertion(), '\n').isNotAlphabetic();
        initialize(Raw.charAssertion(), ' ').isNotAlphabetic();
        initialize(Raw.charAssertion(), '\t').isNotAlphabetic();
        initialize(Raw.charAssertion(), '7').isNotNull().isNotAlphabetic().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isNotAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the alphabetic symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isNotAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the alphabetic symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Ё').isNotAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the alphabetic symbol.\n\tActual:<Ё(1025)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Ё', "Message").isNotAlphabetic();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the alphabetic symbol.\n\tActual:<Ё(1025)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLetterTest() {
        initialize(Raw.charAssertion(), 'a').isLetter();
        initialize(Raw.charAssertion(), 'F').isLetter();
        initialize(Raw.charAssertion(), 'Й').isLetter();
        initialize(Raw.charAssertion(), 'ё').isLetter();
        initialize(Raw.charAssertion(), 'a').isNotNull().isLetter().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '7').isLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the letter.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the letter.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the letter.\n\tActual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the letter.\n\tActual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotLetterTest() {
        initialize(Raw.charAssertion(), '7').isNotLetter();
        initialize(Raw.charAssertion(), '\n').isNotLetter();
        initialize(Raw.charAssertion(), ' ').isNotLetter();
        initialize(Raw.charAssertion(), '\t').isNotLetter();
        initialize(Raw.charAssertion(), '7').isNotNull().isNotLetter().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isNotLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the letter.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isNotLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the letter.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Ё').isNotLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the letter.\n\tActual:<Ё(1025)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Ё', "Message").isNotLetter();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the letter.\n\tActual:<Ё(1025)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isDigitTest() {
        initialize(Raw.charAssertion(), '1').isDigit();
        initialize(Raw.charAssertion(), '7').isDigit();
        initialize(Raw.charAssertion(), '0').isDigit();
        initialize(Raw.charAssertion(), '1').isNotNull().isDigit().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the digit.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the digit.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й').isDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the digit.\n\tActual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й', "Message").isDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the digit.\n\tActual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the digit.\n\tActual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the digit.\n\tActual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotDigitTest() {
        initialize(Raw.charAssertion(), 'a').isNotDigit();
        initialize(Raw.charAssertion(), 'Ё').isNotDigit();
        initialize(Raw.charAssertion(), '\n').isNotDigit();
        initialize(Raw.charAssertion(), ' ').isNotDigit();
        initialize(Raw.charAssertion(), '\t').isNotDigit();
        initialize(Raw.charAssertion(), 'a').isNotNull().isNotDigit().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '0').isNotDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the digit.\n\tActual:<0(48)>");
        }
        try {
            initialize(Raw.charAssertion(), '0', "Message").isNotDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the digit.\n\tActual:<0(48)>");
        }
        try {
            initialize(Raw.charAssertion(), '7').isNotDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the digit.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isNotDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the digit.\n\tActual:<7(55)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isWhitespaceTest() {
        initialize(Raw.charAssertion(), ' ').isWhitespace();
        initialize(Raw.charAssertion(), '\t').isWhitespace();
        initialize(Raw.charAssertion(), '\n').isWhitespace();
        initialize(Raw.charAssertion(), ' ').isNotNull().isWhitespace().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the whitespace symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the whitespace symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й').isWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the whitespace symbol.\n\tActual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й', "Message").isWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the whitespace symbol.\n\tActual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), '7').isWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the whitespace symbol.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the whitespace symbol.\n\tActual:<7(55)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotWhitespaceTest() {
        initialize(Raw.charAssertion(), 'a').isNotWhitespace();
        initialize(Raw.charAssertion(), 'й').isNotWhitespace();
        initialize(Raw.charAssertion(), '7').isNotWhitespace();
        initialize(Raw.charAssertion(), 'a').isNotNull().isNotWhitespace().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), ' ').isNotWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the whitespace symbol.\n\tActual:< (32)>");
        }
        try {
            initialize(Raw.charAssertion(), ' ', "Message").isNotWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the whitespace symbol.\n\tActual:< (32)>");
        }
        try {
            initialize(Raw.charAssertion(), '\t').isNotWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the whitespace symbol.\n\tActual:< (9)>");
        }
        try {
            initialize(Raw.charAssertion(), '\t', "Message").isNotWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the whitespace symbol.\n\tActual:< (9)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isNotWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the whitespace symbol.\n\tActual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isNotWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the whitespace symbol.\n\tActual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLetterOrDigitTest() {
        initialize(Raw.charAssertion(), 'a').isLetterOrDigit();
        initialize(Raw.charAssertion(), 'F').isLetterOrDigit();
        initialize(Raw.charAssertion(), 'Й').isLetterOrDigit();
        initialize(Raw.charAssertion(), 'ё').isLetterOrDigit();
        initialize(Raw.charAssertion(), '7').isLetterOrDigit();
        initialize(Raw.charAssertion(), 'a').isNotNull().isLetterOrDigit().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isLetterOrDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLetterOrDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLetterOrDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isLetterOrDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the letter or the digit.\n\tActual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isLetterOrDigit();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the letter or the digit.\n\tActual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLetterOrWhitespaceTest() {
        initialize(Raw.charAssertion(), 'a').isLetterOrWhitespace();
        initialize(Raw.charAssertion(), 'F').isLetterOrWhitespace();
        initialize(Raw.charAssertion(), 'Й').isLetterOrWhitespace();
        initialize(Raw.charAssertion(), ' ').isLetterOrWhitespace();
        initialize(Raw.charAssertion(), '\t').isLetterOrWhitespace();
        initialize(Raw.charAssertion(), 'a').isNotNull().isLetterOrWhitespace().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isLetterOrWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLetterOrWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLetterOrWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '7').isLetterOrWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the letter or the whitespace symbol.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isLetterOrWhitespace();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the letter or the whitespace symbol.\n\tActual:<7(55)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isControlTest() {
        initialize(Raw.charAssertion(), '\n').isControl();
        initialize(Raw.charAssertion(), '\r').isControl();
        initialize(Raw.charAssertion(), '\n').isNotNull().isControl().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the control symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the control symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й').isControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the control symbol.\n\tActual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й', "Message").isControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the control symbol.\n\tActual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), '7').isControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the control symbol.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the control symbol.\n\tActual:<7(55)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotControlTest() {
        initialize(Raw.charAssertion(), 'a').isNotControl();
        initialize(Raw.charAssertion(), 'Й').isNotControl();
        initialize(Raw.charAssertion(), '7').isNotControl();
        initialize(Raw.charAssertion(), ' ').isNotControl();
        initialize(Raw.charAssertion(), 'a').isNotNull().isNotControl().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isNotControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the control symbol.\n\tActual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isNotControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the control symbol.\n\tActual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\r').isNotControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the control symbol.\n\tActual:< (13)>");
        }
        try {
            initialize(Raw.charAssertion(), '\r', "Message").isNotControl();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the control symbol.\n\tActual:< (13)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLowerCaseTest() {
        initialize(Raw.charAssertion(), 'a').isLowerCase();
        initialize(Raw.charAssertion(), 'f').isLowerCase();
        initialize(Raw.charAssertion(), 'й').isLowerCase();
        initialize(Raw.charAssertion(), 'ё').isLowerCase();
        initialize(Raw.charAssertion(), 'a').isNotNull().isLowerCase().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'A').isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the lower case symbol.\n\tActual:<A(65)>");
        }
        try {
            initialize(Raw.charAssertion(), 'A', "Message").isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the lower case symbol.\n\tActual:<A(65)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й').isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the lower case symbol.\n\tActual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й', "Message").isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the lower case symbol.\n\tActual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), '7').isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the lower case symbol.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the lower case symbol.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the lower case symbol.\n\tActual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the lower case symbol.\n\tActual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotLowerCaseTest() {
        initialize(Raw.charAssertion(), 'A').isNotLowerCase();
        initialize(Raw.charAssertion(), 'Й').isNotLowerCase();
        initialize(Raw.charAssertion(), '7').isNotLowerCase();
        initialize(Raw.charAssertion(), '\n').isNotLowerCase();
        initialize(Raw.charAssertion(), 'A').isNotNull().isNotLowerCase().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the lower case symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the lower case symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'f').isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the lower case symbol.\n\tActual:<f(102)>");
        }
        try {
            initialize(Raw.charAssertion(), 'f', "Message").isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the lower case symbol.\n\tActual:<f(102)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й').isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the lower case symbol.\n\tActual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й', "Message").isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the lower case symbol.\n\tActual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), 'ё').isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the lower case symbol.\n\tActual:<ё(1105)>");
        }
        try {
            initialize(Raw.charAssertion(), 'ё', "Message").isNotLowerCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the lower case symbol.\n\tActual:<ё(1105)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isUpperCaseTest() {
        initialize(Raw.charAssertion(), 'A').isUpperCase();
        initialize(Raw.charAssertion(), 'F').isUpperCase();
        initialize(Raw.charAssertion(), 'Й').isUpperCase();
        initialize(Raw.charAssertion(), 'Ё').isUpperCase();
        initialize(Raw.charAssertion(), 'A').isNotNull().isUpperCase().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the upper case symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the upper case symbol.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й').isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the upper case symbol.\n\tActual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й', "Message").isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the upper case symbol.\n\tActual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), '7').isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the upper case symbol.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the upper case symbol.\n\tActual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the upper case symbol.\n\tActual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the upper case symbol.\n\tActual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotUpperCaseTest() {
        initialize(Raw.charAssertion(), 'a').isNotUpperCase();
        initialize(Raw.charAssertion(), 'й').isNotUpperCase();
        initialize(Raw.charAssertion(), '7').isNotUpperCase();
        initialize(Raw.charAssertion(), '\n').isNotUpperCase();
        initialize(Raw.charAssertion(), 'a').isNotNull().isNotUpperCase().isInstanceOf(Character.class);

        try {
            Raw.charAssertion().isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'A').isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the upper case symbol.\n\tActual:<A(65)>");
        }
        try {
            initialize(Raw.charAssertion(), 'A', "Message").isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the upper case symbol.\n\tActual:<A(65)>");
        }
        try {
            initialize(Raw.charAssertion(), 'F').isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the upper case symbol.\n\tActual:<F(70)>");
        }
        try {
            initialize(Raw.charAssertion(), 'F', "Message").isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the upper case symbol.\n\tActual:<F(70)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й').isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the upper case symbol.\n\tActual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й', "Message").isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the upper case symbol.\n\tActual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Ё').isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the upper case symbol.\n\tActual:<Ё(1025)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Ё', "Message").isNotUpperCase();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the upper case symbol.\n\tActual:<Ё(1025)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.charAssertion(), null).isNull();

        try {
            initialize(Raw.charAssertion(), 'a').isNull();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isNull();
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<a(97)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Character value = (char) 10000;
        initialize(Raw.charAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.charAssertion(), value).isSameAs((char) 10000);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:< (10000)> but was:< (10000)>");
        }
        try {
            initialize(Raw.charAssertion(), value, "Message").isSameAs((char) 10000);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:< (10000)> but was:< (10000)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Character value = (char) 10000;
        initialize(Raw.charAssertion(), value).isNotSameAs((char) 10000);

        try {
            initialize(Raw.charAssertion(), value).isNotSameAs(value);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:< (10000)>");
        }
        try {
            initialize(Raw.charAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(CharAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:< (10000)>");
        }
    }

}
