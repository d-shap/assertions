///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
        new CharAssertion('a', null).isEqualTo('a');
        new CharAssertion('Z', null).isEqualTo('Z');
        new CharAssertion('Й', null).isEqualTo('Й');
        new CharAssertion('5', null).isEqualTo('5');

        try {
            new CharAssertion('a', null).isEqualTo('Z');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<Z(90)> but was:<a(97)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new CharAssertion('a', null).isNotEqualTo('b');
        new CharAssertion('Z', null).isNotEqualTo('X');
        new CharAssertion('1', null).isNotEqualTo('2');
        new CharAssertion('Й', null).isNotEqualTo('Ё');

        try {
            new CharAssertion('a', null).isNotEqualTo('a');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<a(97)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new CharAssertion('b', null).isGreaterThan('a');
        new CharAssertion('7', null).isGreaterThan('0');
        new CharAssertion('Z', null).isGreaterThan('F');

        try {
            new CharAssertion('x', null).isGreaterThan('x');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x(120)> but was:<x(120)>");
        }
        try {
            new CharAssertion('s', null).isGreaterThan('t');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<t(116)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new CharAssertion('b', null).isGreaterThanOrEqualTo('a');
        new CharAssertion('7', null).isGreaterThanOrEqualTo('7');
        new CharAssertion('Z', null).isGreaterThanOrEqualTo('F');

        try {
            new CharAssertion('x', null).isGreaterThanOrEqualTo('y');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<y(121)> but was:<x(120)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new CharAssertion('a', null).isLessThan('b');
        new CharAssertion('0', null).isLessThan('7');
        new CharAssertion('F', null).isLessThan('Z');

        try {
            new CharAssertion('x', null).isLessThan('x');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<x(120)> but was:<x(120)>");
        }
        try {
            new CharAssertion('t', null).isLessThan('s');
            Assertions.fail("Byte assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<s(115)> but was:<t(116)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new CharAssertion('a', null).isLessThanOrEqualTo('b');
        new CharAssertion('7', null).isLessThanOrEqualTo('7');
        new CharAssertion('F', null).isLessThanOrEqualTo('Z');

        try {
            new CharAssertion('y', null).isLessThanOrEqualTo('x');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<x(120)> but was:<y(121)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new CharAssertion('s', null).isInRange('p', 'x');
        new CharAssertion('s', null).isInRange('s', 'x');
        new CharAssertion('s', null).isInRange('a', 'x');

        try {
            new CharAssertion('s', null).isInRange('a', 's');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a(97):s(115)> but was:<s(115)>");
        }
        try {
            new CharAssertion('s', null).isInRange('t', 'x');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<t(116):x(120)> but was:<s(115)>");
        }
        try {
            new CharAssertion('s', null).isInRange('a', 'c');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a(97):c(99)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new CharAssertion('s', null).isNotInRange('a', 's');
        new CharAssertion('s', null).isNotInRange('t', 'x');
        new CharAssertion('s', null).isNotInRange('a', 'c');

        try {
            new CharAssertion('s', null).isNotInRange('p', 'x');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<p(112):x(120)> but was:<s(115)>");
        }
        try {
            new CharAssertion('s', null).isNotInRange('s', 'x');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<s(115):x(120)> but was:<s(115)>");
        }
        try {
            new CharAssertion('s', null).isNotInRange('a', 'x');
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a(97):x(120)> but was:<s(115)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isAlphabeticTest() {
        new CharAssertion('a', null).isAlphabetic();
        new CharAssertion('F', null).isAlphabetic();
        new CharAssertion('Й', null).isAlphabetic();
        new CharAssertion('ё', null).isAlphabetic();

        try {
            new CharAssertion('7', null).isAlphabetic();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the alphabetic symbol. Actual:<7(55)>");
        }
        try {
            new CharAssertion('\n', null).isAlphabetic();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the alphabetic symbol. Actual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isDigitTest() {
        new CharAssertion('1', null).isDigit();
        new CharAssertion('7', null).isDigit();
        new CharAssertion('0', null).isDigit();

        try {
            new CharAssertion('a', null).isDigit();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the digit. Actual:<a(97)>");
        }
        try {
            new CharAssertion('Й', null).isDigit();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the digit. Actual:<Й(1049)>");
        }
        try {
            new CharAssertion('\n', null).isDigit();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the digit. Actual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLetterTest() {
        new CharAssertion('a', null).isLetter();
        new CharAssertion('F', null).isLetter();
        new CharAssertion('Й', null).isLetter();
        new CharAssertion('ё', null).isLetter();

        try {
            new CharAssertion('7', null).isLetter();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the letter. Actual:<7(55)>");
        }
        try {
            new CharAssertion('\n', null).isLetter();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the letter. Actual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLetterOrDigitTest() {
        new CharAssertion('a', null).isLetterOrDigit();
        new CharAssertion('F', null).isLetterOrDigit();
        new CharAssertion('Й', null).isLetterOrDigit();
        new CharAssertion('ё', null).isLetterOrDigit();
        new CharAssertion('7', null).isLetterOrDigit();

        try {
            new CharAssertion('\n', null).isLetterOrDigit();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the letter or the digit. Actual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isControlTest() {
        new CharAssertion('\n', null).isControl();
        new CharAssertion('\r', null).isControl();

        try {
            new CharAssertion('a', null).isControl();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the control symbol. Actual:<a(97)>");
        }
        try {
            new CharAssertion('Й', null).isControl();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the control symbol. Actual:<Й(1049)>");
        }
        try {
            new CharAssertion('7', null).isControl();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the control symbol. Actual:<7(55)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isLowerCaseTest() {
        new CharAssertion('a', null).isLowerCase();
        new CharAssertion('f', null).isLowerCase();
        new CharAssertion('й', null).isLowerCase();
        new CharAssertion('ё', null).isLowerCase();

        try {
            new CharAssertion('A', null).isLowerCase();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:<A(65)>");
        }
        try {
            new CharAssertion('Й', null).isLowerCase();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:<Й(1049)>");
        }
        try {
            new CharAssertion('7', null).isLowerCase();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:<7(55)>");
        }
        try {
            new CharAssertion('\n', null).isLowerCase();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the lower case symbol. Actual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isUpperCaseTest() {
        new CharAssertion('A', null).isUpperCase();
        new CharAssertion('F', null).isUpperCase();
        new CharAssertion('Й', null).isUpperCase();
        new CharAssertion('Ё', null).isUpperCase();

        try {
            new CharAssertion('a', null).isUpperCase();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:<a(97)>");
        }
        try {
            new CharAssertion('й', null).isUpperCase();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:<й(1081)>");
        }
        try {
            new CharAssertion('7', null).isUpperCase();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:<7(55)>");
        }
        try {
            new CharAssertion('\n', null).isUpperCase();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the upper case symbol. Actual:< (10)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void isWhitespaceTest() {
        new CharAssertion(' ', null).isWhitespace();
        new CharAssertion('\t', null).isWhitespace();
        new CharAssertion('\n', null).isWhitespace();

        try {
            new CharAssertion('a', null).isWhitespace();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the whitespace symbol. Actual:<a(97)>");
        }
        try {
            new CharAssertion('й', null).isWhitespace();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the whitespace symbol. Actual:<й(1081)>");
        }
        try {
            new CharAssertion('7', null).isWhitespace();
            Assertions.fail("Char assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the whitespace symbol. Actual:<7(55)>");
        }
    }

    /**
     * {@link CharAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new CharAssertion('a', null).asString(null)).isNull();
        Assertions.assertThat(new CharAssertion('a', null).asString('a')).isEqualTo("a(97)");
        Assertions.assertThat(new CharAssertion('a', null).asString('7')).isEqualTo("7(55)");
        Assertions.assertThat(new CharAssertion('a', null).asString('F')).isEqualTo("F(70)");
        Assertions.assertThat(new CharAssertion('a', null).asString(10)).isEqualTo(" (10)");
        Assertions.assertThat(new CharAssertion('a', null).asString(100000)).isEqualTo(" (100000)");
        Assertions.assertThat(new CharAssertion('a', null).asString(Integer.MAX_VALUE)).isEqualTo(" (2147483647)");
        Assertions.assertThat(new CharAssertion('a', null).asString("test")).isEqualTo("test");
    }

}
