///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.primitive;

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
            initialize(Raw.charAssertion(), new Object());
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.charAssertion(), new Object(), "Message");
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.charAssertion(), 'a').isEqualTo('a');
        initialize(Raw.charAssertion(), 'Z').isEqualTo('Z');
        initialize(Raw.charAssertion(), 'Й').isEqualTo('Й');
        initialize(Raw.charAssertion(), '5').isEqualTo('5');

        try {
            Raw.charAssertion().isEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isEqualTo('Z');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<Z(90)> but was:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isEqualTo('Z');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<Z(90)> but was:<a(97)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.charAssertion(), 'a').isNotEqualTo('b');
        initialize(Raw.charAssertion(), 'Z').isNotEqualTo('X');
        initialize(Raw.charAssertion(), '1').isNotEqualTo('2');
        initialize(Raw.charAssertion(), 'Й').isNotEqualTo('Ё');

        try {
            Raw.charAssertion().isNotEqualTo('b');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotEqualTo('b');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotEqualTo('b');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isNotEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isNotEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<a(97)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.charAssertion(), 'b').isGreaterThan('a');
        initialize(Raw.charAssertion(), '7').isGreaterThan('0');
        initialize(Raw.charAssertion(), 'Z').isGreaterThan('F');

        try {
            Raw.charAssertion().isGreaterThan('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isGreaterThan('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isGreaterThan('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'x').isGreaterThan('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 'x', "Message").isGreaterThan('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isGreaterThan('t');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<t(116)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isGreaterThan('t');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<t(116)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.charAssertion(), 'b').isGreaterThanOrEqualTo('a');
        initialize(Raw.charAssertion(), '7').isGreaterThanOrEqualTo('7');
        initialize(Raw.charAssertion(), 'Z').isGreaterThanOrEqualTo('F');

        try {
            Raw.charAssertion().isGreaterThanOrEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isGreaterThanOrEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isGreaterThanOrEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'x').isGreaterThanOrEqualTo('y');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<y(121)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 'x', "Message").isGreaterThanOrEqualTo('y');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<y(121)> but was:<x(120)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.charAssertion(), 'a').isLessThan('b');
        initialize(Raw.charAssertion(), '0').isLessThan('7');
        initialize(Raw.charAssertion(), 'F').isLessThan('Z');

        try {
            Raw.charAssertion().isLessThan('b');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLessThan('b');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLessThan('b');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'x').isLessThan('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 'x', "Message").isLessThan('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<x(120)> but was:<x(120)>");
        }
        try {
            initialize(Raw.charAssertion(), 't').isLessThan('s');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<s(115)> but was:<t(116)>");
        }
        try {
            initialize(Raw.charAssertion(), 't', "Message").isLessThan('s');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<s(115)> but was:<t(116)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.charAssertion(), 'a').isLessThanOrEqualTo('b');
        initialize(Raw.charAssertion(), '7').isLessThanOrEqualTo('7');
        initialize(Raw.charAssertion(), 'F').isLessThanOrEqualTo('Z');

        try {
            Raw.charAssertion().isLessThanOrEqualTo('b');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLessThanOrEqualTo('b');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLessThanOrEqualTo('b');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'y').isLessThanOrEqualTo('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<x(120)> but was:<y(121)>");
        }
        try {
            initialize(Raw.charAssertion(), 'y', "Message").isLessThanOrEqualTo('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<x(120)> but was:<y(121)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.charAssertion(), 's').isInRange('p', 'x');
        initialize(Raw.charAssertion(), 's').isInRange('s', 'x');
        initialize(Raw.charAssertion(), 's').isInRange('a', 'x');

        try {
            Raw.charAssertion().isInRange('p', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isInRange('p', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isInRange('p', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 's').isInRange('a', 's');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a(97):s(115)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isInRange('a', 's');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<a(97):s(115)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isInRange('t', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<t(116):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isInRange('t', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<t(116):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isInRange('a', 'c');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a(97):c(99)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isInRange('a', 'c');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<a(97):c(99)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.charAssertion(), 's').isNotInRange('a', 's');
        initialize(Raw.charAssertion(), 's').isNotInRange('t', 'x');
        initialize(Raw.charAssertion(), 's').isNotInRange('a', 'c');

        try {
            Raw.charAssertion().isNotInRange('a', 's');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isNotInRange('a', 's');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isNotInRange('a', 's');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 's').isNotInRange('p', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<p(112):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isNotInRange('p', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<p(112):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isNotInRange('s', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<s(115):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isNotInRange('s', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<s(115):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's').isNotInRange('a', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a(97):x(120)> but was:<s(115)>");
        }
        try {
            initialize(Raw.charAssertion(), 's', "Message").isNotInRange('a', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<a(97):x(120)> but was:<s(115)>");
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

        try {
            Raw.charAssertion().isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '7').isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the alphabetic symbol. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the alphabetic symbol. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the alphabetic symbol. Actual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the alphabetic symbol. Actual:< (10)>");
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

        try {
            Raw.charAssertion().isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the digit. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the digit. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й').isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the digit. Actual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й', "Message").isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the digit. Actual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the digit. Actual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the digit. Actual:< (10)>");
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

        try {
            Raw.charAssertion().isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '7').isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the letter. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the letter. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the letter. Actual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the letter. Actual:< (10)>");
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

        try {
            Raw.charAssertion().isLetterOrDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLetterOrDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLetterOrDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isLetterOrDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the letter or the digit. Actual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isLetterOrDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the letter or the digit. Actual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isControlTest() {
        initialize(Raw.charAssertion(), '\n').isControl();
        initialize(Raw.charAssertion(), '\r').isControl();

        try {
            Raw.charAssertion().isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the control symbol. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the control symbol. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й').isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the control symbol. Actual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й', "Message").isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the control symbol. Actual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), '7').isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the control symbol. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the control symbol. Actual:<7(55)>");
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

        try {
            Raw.charAssertion().isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'A').isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:<A(65)>");
        }
        try {
            initialize(Raw.charAssertion(), 'A', "Message").isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the lower case symbol. Actual:<A(65)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й').isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), 'Й', "Message").isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the lower case symbol. Actual:<Й(1049)>");
        }
        try {
            initialize(Raw.charAssertion(), '7').isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the lower case symbol. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the lower case symbol. Actual:< (10)>");
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

        try {
            Raw.charAssertion().isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the upper case symbol. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й').isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й', "Message").isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the upper case symbol. Actual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), '7').isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the upper case symbol. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n').isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:< (10)>");
        }
        try {
            initialize(Raw.charAssertion(), '\n', "Message").isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the upper case symbol. Actual:< (10)>");
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

        try {
            Raw.charAssertion().isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charAssertion(), null).isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), null, "Message").isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charAssertion(), 'a').isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the whitespace symbol. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the whitespace symbol. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й').isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the whitespace symbol. Actual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), 'й', "Message").isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the whitespace symbol. Actual:<й(1081)>");
        }
        try {
            initialize(Raw.charAssertion(), '7').isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the whitespace symbol. Actual:<7(55)>");
        }
        try {
            initialize(Raw.charAssertion(), '7', "Message").isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the whitespace symbol. Actual:<7(55)>");
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
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<a(97)>");
        }
        try {
            initialize(Raw.charAssertion(), 'a', "Message").isNull();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<a(97)>");
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
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:< (10000)> but was:< (10000)>");
        }
        try {
            initialize(Raw.charAssertion(), value, "Message").isSameAs((char) 10000);
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:< (10000)> but was:< (10000)>");
        }
        try {
            initialize(Raw.charAssertion(), value).isSameAs("test");
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:< (10000)>");
        }
        try {
            initialize(Raw.charAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:< (10000)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Character value = (char) 10000;
        initialize(Raw.charAssertion(), value).isNotSameAs((char) 10000);
        initialize(Raw.charAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.charAssertion(), value).isNotSameAs(value);
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:< (10000)>");
        }
        try {
            initialize(Raw.charAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:< (10000)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.charAssertion(), 'a').asString(null));
            Assertions.fail("CharAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.charAssertion(), 'a').asString('a')).isEqualTo("a(97)");
        Assertions.assertThat(initialize(Raw.charAssertion(), 'a').asString('7')).isEqualTo("7(55)");
        Assertions.assertThat(initialize(Raw.charAssertion(), 'a').asString('F')).isEqualTo("F(70)");
        Assertions.assertThat(initialize(Raw.charAssertion(), 'a').asString(10)).isEqualTo(" (10)");
        Assertions.assertThat(initialize(Raw.charAssertion(), 'a').asString(100000)).isEqualTo(" (100000)");
        Assertions.assertThat(initialize(Raw.charAssertion(), 'a').asString(Integer.MAX_VALUE)).isEqualTo(" (2147483647)");
        Assertions.assertThat(initialize(Raw.charAssertion(), 'a').asString("test")).isEqualTo("test");
    }

}
