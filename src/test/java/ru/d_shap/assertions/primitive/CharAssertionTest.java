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

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link CharAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharAssertionTest {

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
    public void isEqualToTest() {
        new CharAssertion('a', new FailDescription()).isEqualTo('a');
        new CharAssertion('Z', new FailDescription()).isEqualTo('Z');
        new CharAssertion('Й', new FailDescription()).isEqualTo('Й');
        new CharAssertion('5', new FailDescription()).isEqualTo('5');

        try {
            new CharAssertion('a', new FailDescription()).isEqualTo('Z');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<Z(90)> but was:<a(97)>.");
        }
        try {
            new CharAssertion('a', new FailDescription().addMessage("Message")).isEqualTo('Z');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<Z(90)> but was:<a(97)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new CharAssertion('a', new FailDescription()).isNotEqualTo('b');
        new CharAssertion('Z', new FailDescription()).isNotEqualTo('X');
        new CharAssertion('1', new FailDescription()).isNotEqualTo('2');
        new CharAssertion('Й', new FailDescription()).isNotEqualTo('Ё');

        try {
            new CharAssertion('a', new FailDescription()).isNotEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<a(97)>.");
        }
        try {
            new CharAssertion('a', new FailDescription().addMessage("Message")).isNotEqualTo('a');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<a(97)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new CharAssertion('b', new FailDescription()).isGreaterThan('a');
        new CharAssertion('7', new FailDescription()).isGreaterThan('0');
        new CharAssertion('Z', new FailDescription()).isGreaterThan('F');

        try {
            new CharAssertion('x', new FailDescription()).isGreaterThan('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x(120)> but was:<x(120)>.");
        }
        try {
            new CharAssertion('x', new FailDescription().addMessage("Message")).isGreaterThan('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<x(120)> but was:<x(120)>.");
        }
        try {
            new CharAssertion('s', new FailDescription()).isGreaterThan('t');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<t(116)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription().addMessage("Message")).isGreaterThan('t');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<t(116)> but was:<s(115)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new CharAssertion('b', new FailDescription()).isGreaterThanOrEqualTo('a');
        new CharAssertion('7', new FailDescription()).isGreaterThanOrEqualTo('7');
        new CharAssertion('Z', new FailDescription()).isGreaterThanOrEqualTo('F');

        try {
            new CharAssertion('x', new FailDescription()).isGreaterThanOrEqualTo('y');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<y(121)> but was:<x(120)>.");
        }
        try {
            new CharAssertion('x', new FailDescription().addMessage("Message")).isGreaterThanOrEqualTo('y');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<y(121)> but was:<x(120)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new CharAssertion('a', new FailDescription()).isLessThan('b');
        new CharAssertion('0', new FailDescription()).isLessThan('7');
        new CharAssertion('F', new FailDescription()).isLessThan('Z');

        try {
            new CharAssertion('x', new FailDescription()).isLessThan('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<x(120)> but was:<x(120)>.");
        }
        try {
            new CharAssertion('x', new FailDescription().addMessage("Message")).isLessThan('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<x(120)> but was:<x(120)>.");
        }
        try {
            new CharAssertion('t', new FailDescription()).isLessThan('s');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<s(115)> but was:<t(116)>.");
        }
        try {
            new CharAssertion('t', new FailDescription().addMessage("Message")).isLessThan('s');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<s(115)> but was:<t(116)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new CharAssertion('a', new FailDescription()).isLessThanOrEqualTo('b');
        new CharAssertion('7', new FailDescription()).isLessThanOrEqualTo('7');
        new CharAssertion('F', new FailDescription()).isLessThanOrEqualTo('Z');

        try {
            new CharAssertion('y', new FailDescription()).isLessThanOrEqualTo('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<x(120)> but was:<y(121)>.");
        }
        try {
            new CharAssertion('y', new FailDescription().addMessage("Message")).isLessThanOrEqualTo('x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<x(120)> but was:<y(121)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new CharAssertion('s', new FailDescription()).isInRange('p', 'x');
        new CharAssertion('s', new FailDescription()).isInRange('s', 'x');
        new CharAssertion('s', new FailDescription()).isInRange('a', 'x');

        try {
            new CharAssertion('s', new FailDescription()).isInRange('a', 's');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a(97):s(115)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription().addMessage("Message")).isInRange('a', 's');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<a(97):s(115)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription()).isInRange('t', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<t(116):x(120)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription().addMessage("Message")).isInRange('t', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<t(116):x(120)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription()).isInRange('a', 'c');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a(97):c(99)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription().addMessage("Message")).isInRange('a', 'c');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<a(97):c(99)> but was:<s(115)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new CharAssertion('s', new FailDescription()).isNotInRange('a', 's');
        new CharAssertion('s', new FailDescription()).isNotInRange('t', 'x');
        new CharAssertion('s', new FailDescription()).isNotInRange('a', 'c');

        try {
            new CharAssertion('s', new FailDescription()).isNotInRange('p', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<p(112):x(120)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription().addMessage("Message")).isNotInRange('p', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<p(112):x(120)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription()).isNotInRange('s', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<s(115):x(120)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription().addMessage("Message")).isNotInRange('s', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<s(115):x(120)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription()).isNotInRange('a', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a(97):x(120)> but was:<s(115)>.");
        }
        try {
            new CharAssertion('s', new FailDescription().addMessage("Message")).isNotInRange('a', 'x');
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<a(97):x(120)> but was:<s(115)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isAlphabeticTest() {
        new CharAssertion('a', new FailDescription()).isAlphabetic();
        new CharAssertion('F', new FailDescription()).isAlphabetic();
        new CharAssertion('Й', new FailDescription()).isAlphabetic();
        new CharAssertion('ё', new FailDescription()).isAlphabetic();

        try {
            new CharAssertion('7', new FailDescription()).isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the alphabetic symbol. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('7', new FailDescription().addMessage("Message")).isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the alphabetic symbol. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription()).isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the alphabetic symbol. Actual:< (10)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription().addMessage("Message")).isAlphabetic();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the alphabetic symbol. Actual:< (10)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isDigitTest() {
        new CharAssertion('1', new FailDescription()).isDigit();
        new CharAssertion('7', new FailDescription()).isDigit();
        new CharAssertion('0', new FailDescription()).isDigit();

        try {
            new CharAssertion('a', new FailDescription()).isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the digit. Actual:<a(97)>.");
        }
        try {
            new CharAssertion('a', new FailDescription().addMessage("Message")).isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the digit. Actual:<a(97)>.");
        }
        try {
            new CharAssertion('Й', new FailDescription()).isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the digit. Actual:<Й(1049)>.");
        }
        try {
            new CharAssertion('Й', new FailDescription().addMessage("Message")).isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the digit. Actual:<Й(1049)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription()).isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the digit. Actual:< (10)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription().addMessage("Message")).isDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the digit. Actual:< (10)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLetterTest() {
        new CharAssertion('a', new FailDescription()).isLetter();
        new CharAssertion('F', new FailDescription()).isLetter();
        new CharAssertion('Й', new FailDescription()).isLetter();
        new CharAssertion('ё', new FailDescription()).isLetter();

        try {
            new CharAssertion('7', new FailDescription()).isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the letter. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('7', new FailDescription().addMessage("Message")).isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the letter. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription()).isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the letter. Actual:< (10)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription().addMessage("Message")).isLetter();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the letter. Actual:< (10)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLetterOrDigitTest() {
        new CharAssertion('a', new FailDescription()).isLetterOrDigit();
        new CharAssertion('F', new FailDescription()).isLetterOrDigit();
        new CharAssertion('Й', new FailDescription()).isLetterOrDigit();
        new CharAssertion('ё', new FailDescription()).isLetterOrDigit();
        new CharAssertion('7', new FailDescription()).isLetterOrDigit();

        try {
            new CharAssertion('\n', new FailDescription()).isLetterOrDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the letter or the digit. Actual:< (10)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription().addMessage("Message")).isLetterOrDigit();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the letter or the digit. Actual:< (10)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isControlTest() {
        new CharAssertion('\n', new FailDescription()).isControl();
        new CharAssertion('\r', new FailDescription()).isControl();

        try {
            new CharAssertion('a', new FailDescription()).isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the control symbol. Actual:<a(97)>.");
        }
        try {
            new CharAssertion('a', new FailDescription().addMessage("Message")).isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the control symbol. Actual:<a(97)>.");
        }
        try {
            new CharAssertion('Й', new FailDescription()).isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the control symbol. Actual:<Й(1049)>.");
        }
        try {
            new CharAssertion('Й', new FailDescription().addMessage("Message")).isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the control symbol. Actual:<Й(1049)>.");
        }
        try {
            new CharAssertion('7', new FailDescription()).isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the control symbol. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('7', new FailDescription().addMessage("Message")).isControl();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the control symbol. Actual:<7(55)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLowerCaseTest() {
        new CharAssertion('a', new FailDescription()).isLowerCase();
        new CharAssertion('f', new FailDescription()).isLowerCase();
        new CharAssertion('й', new FailDescription()).isLowerCase();
        new CharAssertion('ё', new FailDescription()).isLowerCase();

        try {
            new CharAssertion('A', new FailDescription()).isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:<A(65)>.");
        }
        try {
            new CharAssertion('A', new FailDescription().addMessage("Message")).isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the lower case symbol. Actual:<A(65)>.");
        }
        try {
            new CharAssertion('Й', new FailDescription()).isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:<Й(1049)>.");
        }
        try {
            new CharAssertion('Й', new FailDescription().addMessage("Message")).isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the lower case symbol. Actual:<Й(1049)>.");
        }
        try {
            new CharAssertion('7', new FailDescription()).isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('7', new FailDescription().addMessage("Message")).isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the lower case symbol. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription()).isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:< (10)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription().addMessage("Message")).isLowerCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the lower case symbol. Actual:< (10)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isUpperCaseTest() {
        new CharAssertion('A', new FailDescription()).isUpperCase();
        new CharAssertion('F', new FailDescription()).isUpperCase();
        new CharAssertion('Й', new FailDescription()).isUpperCase();
        new CharAssertion('Ё', new FailDescription()).isUpperCase();

        try {
            new CharAssertion('a', new FailDescription()).isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:<a(97)>.");
        }
        try {
            new CharAssertion('a', new FailDescription().addMessage("Message")).isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the upper case symbol. Actual:<a(97)>.");
        }
        try {
            new CharAssertion('й', new FailDescription()).isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:<й(1081)>.");
        }
        try {
            new CharAssertion('й', new FailDescription().addMessage("Message")).isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the upper case symbol. Actual:<й(1081)>.");
        }
        try {
            new CharAssertion('7', new FailDescription()).isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('7', new FailDescription().addMessage("Message")).isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the upper case symbol. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription()).isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:< (10)>.");
        }
        try {
            new CharAssertion('\n', new FailDescription().addMessage("Message")).isUpperCase();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the upper case symbol. Actual:< (10)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isWhitespaceTest() {
        new CharAssertion(' ', new FailDescription()).isWhitespace();
        new CharAssertion('\t', new FailDescription()).isWhitespace();
        new CharAssertion('\n', new FailDescription()).isWhitespace();

        try {
            new CharAssertion('a', new FailDescription()).isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the whitespace symbol. Actual:<a(97)>.");
        }
        try {
            new CharAssertion('a', new FailDescription().addMessage("Message")).isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the whitespace symbol. Actual:<a(97)>.");
        }
        try {
            new CharAssertion('й', new FailDescription()).isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the whitespace symbol. Actual:<й(1081)>.");
        }
        try {
            new CharAssertion('й', new FailDescription().addMessage("Message")).isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the whitespace symbol. Actual:<й(1081)>.");
        }
        try {
            new CharAssertion('7', new FailDescription()).isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the whitespace symbol. Actual:<7(55)>.");
        }
        try {
            new CharAssertion('7', new FailDescription().addMessage("Message")).isWhitespace();
            Assertions.fail("CharAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the whitespace symbol. Actual:<7(55)>.");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString('a', true)).isEqualTo("a(97)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString('7', true)).isEqualTo("7(55)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString('F', true)).isEqualTo("F(70)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString(10, true)).isEqualTo(" (10)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString(100000, true)).isEqualTo(" (100000)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString(Integer.MAX_VALUE, true)).isEqualTo(" (2147483647)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString("test", true)).isEqualTo("test");

        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString('a', false)).isEqualTo("a(97)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString('7', false)).isEqualTo("7(55)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString('F', false)).isEqualTo("F(70)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString(10, false)).isEqualTo(" (10)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString(100000, false)).isEqualTo(" (100000)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString(Integer.MAX_VALUE, false)).isEqualTo(" (2147483647)");
        Assertions.assertThat(new CharAssertion('a', new FailDescription()).asString("test", false)).isEqualTo("test");
    }

}
