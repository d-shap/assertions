///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
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

}
