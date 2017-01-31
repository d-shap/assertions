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
package ru.d_shap.assertions.core;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link CharSequenceAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharSequenceAssertionTest {

    /**
     * Test class constructor.
     */
    public CharSequenceAssertionTest() {
        super();
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new CharSequenceAssertion("", null).isEmpty();

        try {
            new CharSequenceAssertion(null, null).isEmpty();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion(" ", null).isEmpty();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:< >");
        }
        try {
            new CharSequenceAssertion("value", null).isEmpty();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new CharSequenceAssertion(null, null).isNullOrEmpty();
        new CharSequenceAssertion("", null).isNullOrEmpty();

        try {
            new CharSequenceAssertion(" ", null).isNullOrEmpty();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:< >");
        }
        try {
            new CharSequenceAssertion("value", null).isNullOrEmpty();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new CharSequenceAssertion(" ", null).isNotEmpty();
        new CharSequenceAssertion("value", null).isNotEmpty();

        try {
            new CharSequenceAssertion(null, null).isNotEmpty();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("", null).isNotEmpty();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isBlankTest() {
        new CharSequenceAssertion("", null).isBlank();
        new CharSequenceAssertion(" ", null).isBlank();
        new CharSequenceAssertion("\t", null).isBlank();
        new CharSequenceAssertion("   \t   \t", null).isBlank();

        try {
            new CharSequenceAssertion(null, null).isBlank();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isBlank();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNullOrBlankTest() {
        new CharSequenceAssertion(null, null).isNullOrBlank();
        new CharSequenceAssertion("", null).isNullOrBlank();
        new CharSequenceAssertion(" ", null).isNullOrBlank();
        new CharSequenceAssertion("\t", null).isNullOrBlank();
        new CharSequenceAssertion("   \t   \t", null).isNullOrBlank();

        try {
            new CharSequenceAssertion("value", null).isNullOrBlank();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotBlankTest() {
        new CharSequenceAssertion("value", null).isNotBlank();

        try {
            new CharSequenceAssertion(null, null).isNotBlank();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("", null).isNotBlank();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new CharSequenceAssertion(" ", null).isNotBlank();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new CharSequenceAssertion("\t", null).isNotBlank();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new CharSequenceAssertion("   \t   \t", null).isNotBlank();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new CharSequenceAssertion("value", null).isEqualTo("value");
        new CharSequenceAssertion("ЗНАЧЕНИЕ", null).isEqualTo("ЗНАЧЕНИЕ");
        new CharSequenceAssertion("значение", null).isEqualTo("значение");

        try {
            new CharSequenceAssertion(null, null).isEqualTo("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isEqualTo(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value1", null).isEqualTo("value2");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            new CharSequenceAssertion("value", null).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<значение>");
        }
        try {
            new CharSequenceAssertion("ЗНАЧЕНИЕ", null).isEqualTo("значение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEqualToIgnoreCaseTest() {
        new CharSequenceAssertion("valUe", null).isEqualToIgnoreCase("vALue");
        new CharSequenceAssertion("ЗНАЧЕНИЕ", null).isEqualToIgnoreCase("значение");
        new CharSequenceAssertion("значение", null).isEqualToIgnoreCase("ЗНАЧЕНИЕ");

        try {
            new CharSequenceAssertion(null, null).isEqualToIgnoreCase("vALue");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vALue", null).isEqualToIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value1", null).isEqualToIgnoreCase("value2");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            new CharSequenceAssertion("value", null).isEqualToIgnoreCase("ЗНАЧЕНИЕ");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isEqualToIgnoreCase("значение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<value>");
        }
        try {
            new CharSequenceAssertion("ЗнаЧеНИЕ", null).isEqualToIgnoreCase("vaLUE");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<vaLUE> but was:<ЗнаЧеНИЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new CharSequenceAssertion("value", null).isNotEqualTo("значение");
        new CharSequenceAssertion("value", null).isNotEqualTo("ЗНАЧЕНИЕ");
        new CharSequenceAssertion("значение", null).isNotEqualTo("value");
        new CharSequenceAssertion("ЗНАЧЕНИЕ", null).isNotEqualTo("value");

        try {
            new CharSequenceAssertion(null, null).isNotEqualTo("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotEqualTo(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotEqualTo("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).isNotEqualTo("значение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<значение>");
        }
        try {
            new CharSequenceAssertion("ЗНАЧЕНИЕ", null).isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEqualToIgnoreCaseTest() {
        new CharSequenceAssertion("vaLUe", null).isNotEqualToIgnoreCase("знАЧенИЕ");
        new CharSequenceAssertion("VAluE", null).isNotEqualToIgnoreCase("ЗНачЕНие");
        new CharSequenceAssertion("знАЧенИЕ", null).isNotEqualToIgnoreCase("vaLUe");
        new CharSequenceAssertion("ЗНачЕНие", null).isNotEqualToIgnoreCase("VAluE");

        try {
            new CharSequenceAssertion(null, null).isNotEqualToIgnoreCase("vaLUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vaLUe", null).isNotEqualToIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotEqualToIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            new CharSequenceAssertion("знАЧенИЕ", null).isNotEqualToIgnoreCase("ЗНачЕНие");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<знАЧенИЕ>");
        }
        try {
            new CharSequenceAssertion("ЗНачЕНие", null).isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНачЕНие>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new CharSequenceAssertion("value", null).isGreaterThan("aaa");
        new CharSequenceAssertion("value", null).isGreaterThan("vai");
        new CharSequenceAssertion("value", null).isGreaterThan("valuazzz");
        new CharSequenceAssertion("value", null).isGreaterThan("VALUE");
        new CharSequenceAssertion("value", null).isGreaterThan("XYZ");

        try {
            new CharSequenceAssertion(null, null).isGreaterThan("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThan(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThan("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThan("valuea");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThan("x");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanIgnoreCaseTest() {
        new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("aaa");
        new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("vai");
        new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("vAi");
        new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("valuazzz");
        new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("vAlUazzz");

        try {
            new CharSequenceAssertion(null, null).isGreaterThanIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("VALUE");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<VALUE> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("XYZ");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<XYZ> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("valuea");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanIgnoreCase("x");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualTo("aaa");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualTo("vai");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualTo("valuazzz");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualTo("VALUE");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualTo("XYZ");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualTo("value");

        try {
            new CharSequenceAssertion(null, null).isGreaterThanOrEqualTo("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanOrEqualTo(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanOrEqualTo("valuea");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanOrEqualTo("x");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToIgnoreCaseTest() {
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("aaa");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("vai");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("vAi");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("valuazzz");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("vAlUazzz");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("value");
        new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("VALUE");

        try {
            new CharSequenceAssertion(null, null).isGreaterThanOrEqualToIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("XYZ");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<XYZ> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("valuea");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("x");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new CharSequenceAssertion("value", null).isLessThan("yyy");
        new CharSequenceAssertion("value", null).isLessThan("vam");
        new CharSequenceAssertion("value", null).isLessThan("valuezzz");
        new CharSequenceAssertion("VALUE", null).isLessThan("value");
        new CharSequenceAssertion("XYZ", null).isLessThan("value");

        try {
            new CharSequenceAssertion(null, null).isLessThan("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThan(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThan("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThan("valu");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThan("c");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanIgnoreCaseTest() {
        new CharSequenceAssertion("value", null).isLessThanIgnoreCase("yyy");
        new CharSequenceAssertion("value", null).isLessThanIgnoreCase("vam");
        new CharSequenceAssertion("vAlue", null).isLessThanIgnoreCase("vam");
        new CharSequenceAssertion("value", null).isLessThanIgnoreCase("valuezzz");
        new CharSequenceAssertion("vAlUe", null).isLessThanIgnoreCase("valuezzz");

        try {
            new CharSequenceAssertion(null, null).isLessThanIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>");
        }
        try {
            new CharSequenceAssertion("VALUE", null).isLessThanIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<VALUE>");
        }
        try {
            new CharSequenceAssertion("XYZ", null).isLessThanIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<XYZ>");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanIgnoreCase("valu");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanIgnoreCase("c");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new CharSequenceAssertion("value", null).isLessThanOrEqualTo("yyy");
        new CharSequenceAssertion("value", null).isLessThanOrEqualTo("vam");
        new CharSequenceAssertion("value", null).isLessThanOrEqualTo("valuezzz");
        new CharSequenceAssertion("VALUE", null).isLessThanOrEqualTo("value");
        new CharSequenceAssertion("XYZ", null).isLessThanOrEqualTo("value");
        new CharSequenceAssertion("value", null).isLessThanOrEqualTo("value");

        try {
            new CharSequenceAssertion(null, null).isLessThanOrEqualTo("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanOrEqualTo(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanOrEqualTo("valu");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanOrEqualTo("c");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToIgnoreCaseTest() {
        new CharSequenceAssertion("value", null).isLessThanOrEqualToIgnoreCase("yyy");
        new CharSequenceAssertion("value", null).isLessThanOrEqualToIgnoreCase("vam");
        new CharSequenceAssertion("vAlue", null).isLessThanOrEqualToIgnoreCase("vam");
        new CharSequenceAssertion("value", null).isLessThanOrEqualToIgnoreCase("valuezzz");
        new CharSequenceAssertion("vAlUe", null).isLessThanOrEqualToIgnoreCase("valuezzz");
        new CharSequenceAssertion("value", null).isLessThanOrEqualToIgnoreCase("value");
        new CharSequenceAssertion("VALUE", null).isLessThanOrEqualToIgnoreCase("value");

        try {
            new CharSequenceAssertion(null, null).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("XYZ", null).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<value> but was:<XYZ>");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanOrEqualToIgnoreCase("valu");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isLessThanOrEqualToIgnoreCase("c");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new CharSequenceAssertion("value", null).isInRange("v", "valuex");
        new CharSequenceAssertion("value", null).isInRange("a", "z");
        new CharSequenceAssertion("value", null).isInRange("A", "z");
        new CharSequenceAssertion("value", null).isInRange("value", "z");
        new CharSequenceAssertion("value", null).isInRange("VALUE", "z");

        try {
            new CharSequenceAssertion(null, null).isInRange("value", "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isInRange(null, "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isInRange("value", null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isInRange("A", "Z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:Z> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isInRange("a", "test");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isInRange("A", "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isInRange("A", "vaLUE");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isInRangeIgnoreCaseTest() {
        new CharSequenceAssertion("value", null).isInRangeIgnoreCase("v", "valuex");
        new CharSequenceAssertion("value", null).isInRangeIgnoreCase("a", "z");
        new CharSequenceAssertion("value", null).isInRangeIgnoreCase("a", "Z");
        new CharSequenceAssertion("value", null).isInRangeIgnoreCase("A", "z");
        new CharSequenceAssertion("value", null).isInRangeIgnoreCase("A", "Z");
        new CharSequenceAssertion("value", null).isInRangeIgnoreCase("value", "z");
        new CharSequenceAssertion("value", null).isInRangeIgnoreCase("value", "Z");
        new CharSequenceAssertion("value", null).isInRangeIgnoreCase("VALUE", "z");
        new CharSequenceAssertion("value", null).isInRangeIgnoreCase("VALUE", "Z");

        try {
            new CharSequenceAssertion(null, null).isInRangeIgnoreCase("value", "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isInRangeIgnoreCase(null, "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isInRangeIgnoreCase("value", null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isInRangeIgnoreCase("a", "test");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isInRangeIgnoreCase("A", "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isInRangeIgnoreCase("A", "vaLUE");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new CharSequenceAssertion("value", null).isNotInRange("A", "Z");
        new CharSequenceAssertion("value", null).isNotInRange("a", "test");
        new CharSequenceAssertion("value", null).isNotInRange("A", "value");
        new CharSequenceAssertion("value", null).isNotInRange("A", "vaLUE");
        new CharSequenceAssertion("value", null).isNotInRange("VALUE", "Z");

        try {
            new CharSequenceAssertion(null, null).isNotInRange("value", "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRange(null, "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRange("value", null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRange("v", "valuea");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRange("a", "z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRange("A", "z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRange("value", "z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRange("VALUE", "z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotInRangeIgnoreCaseTest() {
        new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("a", "test");
        new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("A", "value");
        new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("A", "vaLUE");

        try {
            new CharSequenceAssertion(null, null).isNotInRangeIgnoreCase("value", "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("value", null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("A", "Z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:Z> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("v", "valuea");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("a", "z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("A", "z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("value", "z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("VALUE", "z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).isNotInRangeIgnoreCase("VALUE", "Z");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:Z> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void containsTest() {
        new CharSequenceAssertion("value", null).contains("val");
        new CharSequenceAssertion("value", null).contains("alu");
        new CharSequenceAssertion("value", null).contains("lue");
        new CharSequenceAssertion("значение", null).contains("знач");
        new CharSequenceAssertion("значение", null).contains("ен");
        new CharSequenceAssertion("значение", null).contains("ие");

        try {
            new CharSequenceAssertion(null, null).contains("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).contains(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).contains("VAL");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAL> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).contains("v.*ue");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).contains("знач");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<знач> but was:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).contains("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<value> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void containsIgnoreCaseTest() {
        new CharSequenceAssertion("value", null).containsIgnoreCase("VAL");
        new CharSequenceAssertion("VAlUE", null).containsIgnoreCase("aLu");
        new CharSequenceAssertion("VAlue", null).containsIgnoreCase("luE");
        new CharSequenceAssertion("значение", null).containsIgnoreCase("ЗНАЧ");
        new CharSequenceAssertion("ЗНАчЕнИЕ", null).containsIgnoreCase("еН");
        new CharSequenceAssertion("ЗНАЧЕние", null).containsIgnoreCase("Ие");

        try {
            new CharSequenceAssertion(null, null).containsIgnoreCase("VAlue");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("VAlue", null).containsIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).containsIgnoreCase("VAE");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAE> but was:<value>");
        }
        try {
            new CharSequenceAssertion("vaLUe", null).containsIgnoreCase("v.*ue");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<vaLUe>");
        }
        try {
            new CharSequenceAssertion("vaLue", null).containsIgnoreCase("зНАч");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<зНАч> but was:<vaLue>");
        }
        try {
            new CharSequenceAssertion("знАЧЕние", null).containsIgnoreCase("valUE");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<valUE> but was:<знАЧЕние>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new CharSequenceAssertion("value", null).doesNotContain("vaue");
        new CharSequenceAssertion("value", null).doesNotContain("VAL");
        new CharSequenceAssertion("value", null).doesNotContain("UE");
        new CharSequenceAssertion("значение", null).doesNotContain("ЗНАЧ");
        new CharSequenceAssertion("значение", null).doesNotContain("кени");
        new CharSequenceAssertion("значение", null).doesNotContain("НИЕ");

        try {
            new CharSequenceAssertion(null, null).doesNotContain("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotContain(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotContain("val");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotContain("alu");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<alu> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotContain("lue");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lue> but was:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).doesNotContain("знач");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<значение>");
        }
        try {
            new CharSequenceAssertion("значение", null).doesNotContain("ение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<ение> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotContainIgnoreCaseTest() {
        new CharSequenceAssertion("value", null).doesNotContainIgnoreCase("vaUE");
        new CharSequenceAssertion("valUE", null).doesNotContainIgnoreCase("1VAL");
        new CharSequenceAssertion("valUE", null).doesNotContainIgnoreCase("UE1");
        new CharSequenceAssertion("знАчеНие", null).doesNotContainIgnoreCase("ЗНАН");
        new CharSequenceAssertion("знАчеНие", null).doesNotContainIgnoreCase("кени");
        new CharSequenceAssertion("знАчеНие", null).doesNotContainIgnoreCase("чИЕ");

        try {
            new CharSequenceAssertion(null, null).doesNotContainIgnoreCase("valUE");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("valUE", null).doesNotContainIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vaLUe", null).doesNotContainIgnoreCase("val");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<vaLUe>");
        }
        try {
            new CharSequenceAssertion("vaLUe", null).doesNotContainIgnoreCase("VAL");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<VAL> but was:<vaLUe>");
        }
        try {
            new CharSequenceAssertion("vaLUe", null).doesNotContainIgnoreCase("lUE");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lUE> but was:<vaLUe>");
        }
        try {
            new CharSequenceAssertion("зНАчеНИе", null).doesNotContainIgnoreCase("знач");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<зНАчеНИе>");
        }
        try {
            new CharSequenceAssertion("зНАчеНИе", null).doesNotContainIgnoreCase("еНИе");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<еНИе> but was:<зНАчеНИе>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isPartOfTest() {
        new CharSequenceAssertion("val", null).isPartOf("value");
        new CharSequenceAssertion("alu", null).isPartOf("value");
        new CharSequenceAssertion("lue", null).isPartOf("value");
        new CharSequenceAssertion("знач", null).isPartOf("значение");
        new CharSequenceAssertion("ен", null).isPartOf("значение");
        new CharSequenceAssertion("ие", null).isPartOf("значение");

        try {
            new CharSequenceAssertion(null, null).isPartOf("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isPartOf(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("VAL", null).isPartOf("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<VAL>");
        }
        try {
            new CharSequenceAssertion("vue", null).isPartOf("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<vue>");
        }
        try {
            new CharSequenceAssertion("ЗнАЧ", null).isPartOf("значение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<ЗнАЧ>");
        }
        try {
            new CharSequenceAssertion("чача", null).isPartOf("значение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<чача>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isPartOfIgnoreCaseTest() {
        new CharSequenceAssertion("vAl", null).isPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("Alu", null).isPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("luE", null).isPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("знАЧ", null).isPartOfIgnoreCase("зНАчеНИе");
        new CharSequenceAssertion("Ен", null).isPartOfIgnoreCase("зНАчеНИе");
        new CharSequenceAssertion("иЕ", null).isPartOfIgnoreCase("зНАчеНИе");

        try {
            new CharSequenceAssertion(null, null).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vaLUe", null).isPartOfIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("VAe", null).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<VAe>");
        }
        try {
            new CharSequenceAssertion("vUe", null).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<vUe>");
        }
        try {
            new CharSequenceAssertion("ЗАЧ", null).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<ЗАЧ>");
        }
        try {
            new CharSequenceAssertion("чача", null).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<чача>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotPartOfTest() {
        new CharSequenceAssertion("vae", null).isNotPartOf("value");
        new CharSequenceAssertion("aLu", null).isNotPartOf("value");
        new CharSequenceAssertion("vue", null).isNotPartOf("value");
        new CharSequenceAssertion("знаач", null).isNotPartOf("значение");
        new CharSequenceAssertion("еНИ", null).isNotPartOf("значение");
        new CharSequenceAssertion("чие", null).isNotPartOf("значение");

        try {
            new CharSequenceAssertion(null, null).isNotPartOf("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).isNotPartOf(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("val", null).isNotPartOf("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<val>");
        }
        try {
            new CharSequenceAssertion("lue", null).isNotPartOf("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<lue>");
        }
        try {
            new CharSequenceAssertion("знач", null).isNotPartOf("значение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<знач>");
        }
        try {
            new CharSequenceAssertion("ение", null).isNotPartOf("значение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<ение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotPartOfIgnoreCaseTest() {
        new CharSequenceAssertion("vAe", null).isNotPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("aLe", null).isNotPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("vuE", null).isNotPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("знААч", null).isNotPartOfIgnoreCase("знАченИе");
        new CharSequenceAssertion("еНе", null).isNotPartOfIgnoreCase("знАченИе");
        new CharSequenceAssertion("чИЕ", null).isNotPartOfIgnoreCase("знАченИе");

        try {
            new CharSequenceAssertion(null, null).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vaLUe", null).isNotPartOfIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("VAL", null).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<VAL>");
        }
        try {
            new CharSequenceAssertion("LuE", null).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<LuE>");
        }
        try {
            new CharSequenceAssertion("зНАч", null).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<зНАч>");
        }
        try {
            new CharSequenceAssertion("ЕниЕ", null).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<ЕниЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void matchesTest() {
        new CharSequenceAssertion("value", null).matches("v.*e");
        new CharSequenceAssertion("value", null).matches("v[aA].{2}[eE]");
        new CharSequenceAssertion("value", null).matches("\\w+");
        new CharSequenceAssertion("value", null).matches("\\w{4,6}");
        new CharSequenceAssertion("значение", null).matches("\\p{L}+");

        try {
            new CharSequenceAssertion(null, null).matches("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).matches(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).matches("\\d+");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\d+> but was:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).matches("\\w+");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\w+> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotMatchTest() {
        new CharSequenceAssertion("value", null).doesNotMatch("valu.+e");
        new CharSequenceAssertion("value", null).doesNotMatch("v[zZ].{2}[eE]");
        new CharSequenceAssertion("value", null).doesNotMatch("\\s\\w+");
        new CharSequenceAssertion("value", null).doesNotMatch("\\w{8}");
        new CharSequenceAssertion("значение", null).doesNotMatch("\\w+");

        try {
            new CharSequenceAssertion(null, null).doesNotMatch("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotMatch(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotMatch("\\w+");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\w+> but was:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).doesNotMatch("\\p{L}{8}");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\p{L}{8}> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void startsWithTest() {
        new CharSequenceAssertion("value", null).startsWith("va");
        new CharSequenceAssertion("value", null).startsWith("val");
        new CharSequenceAssertion("value", null).startsWith("value");
        new CharSequenceAssertion("значение", null).startsWith("зна");
        new CharSequenceAssertion("значение", null).startsWith("значе");
        new CharSequenceAssertion("значение", null).startsWith("значение");

        try {
            new CharSequenceAssertion(null, null).startsWith("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).startsWith(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).startsWith("lue");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lue> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).startsWith("Val");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Val> but was:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).startsWith("ачен");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<ачен> but was:<значение>");
        }
        try {
            new CharSequenceAssertion("значение", null).startsWith("Знач");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Знач> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void startsWithIgnoreCaseTest() {
        new CharSequenceAssertion("vAlUe", null).startsWithIgnoreCase("vA");
        new CharSequenceAssertion("vAlUe", null).startsWithIgnoreCase("VAl");
        new CharSequenceAssertion("vAlUe", null).startsWithIgnoreCase("vaLUe");
        new CharSequenceAssertion("знАчЕнИе", null).startsWithIgnoreCase("зНа");
        new CharSequenceAssertion("знАчЕнИе", null).startsWithIgnoreCase("зНаче");
        new CharSequenceAssertion("знАчЕнИе", null).startsWithIgnoreCase("зНачение");

        try {
            new CharSequenceAssertion(null, null).startsWithIgnoreCase("vAlUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).startsWithIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).startsWithIgnoreCase("lUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lUe> but was:<vAlUe>");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).startsWithIgnoreCase("Vau");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Vau> but was:<vAlUe>");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", null).startsWithIgnoreCase("аЧен");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<аЧен> but was:<знАчЕнИе>");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", null).startsWithIgnoreCase("Значи");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Значи> but was:<знАчЕнИе>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotStartWithTest() {
        new CharSequenceAssertion("value", null).doesNotStartWith("VA");
        new CharSequenceAssertion("value", null).doesNotStartWith("VaL");
        new CharSequenceAssertion("value", null).doesNotStartWith("vale");
        new CharSequenceAssertion("значение", null).doesNotStartWith("ЗНА");
        new CharSequenceAssertion("значение", null).doesNotStartWith("Знач");
        new CharSequenceAssertion("значение", null).doesNotStartWith("чение");

        try {
            new CharSequenceAssertion(null, null).doesNotStartWith("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotStartWith(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotStartWith("val");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotStartWith("valu");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<valu> but was:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).doesNotStartWith("зн");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<значение>");
        }
        try {
            new CharSequenceAssertion("значение", null).doesNotStartWith("значен");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значен> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotStartWithIgnoreCaseTest() {
        new CharSequenceAssertion("vAlUe", null).doesNotStartWithIgnoreCase("Vu");
        new CharSequenceAssertion("vAlUe", null).doesNotStartWithIgnoreCase("Vue");
        new CharSequenceAssertion("vAlUe", null).doesNotStartWithIgnoreCase("ale");
        new CharSequenceAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("НА");
        new CharSequenceAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("Знч");
        new CharSequenceAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("чние");

        try {
            new CharSequenceAssertion(null, null).doesNotStartWithIgnoreCase("vAlUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).doesNotStartWithIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).doesNotStartWithIgnoreCase("val");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<vAlUe>");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).doesNotStartWithIgnoreCase("VALUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<VALUe> but was:<vAlUe>");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("зн");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<знАчЕнИе>");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("значение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значение> but was:<знАчЕнИе>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void endsWithTest() {
        new CharSequenceAssertion("value", null).endsWith("alue");
        new CharSequenceAssertion("value", null).endsWith("lue");
        new CharSequenceAssertion("value", null).endsWith("ue");
        new CharSequenceAssertion("значение", null).endsWith("ачение");
        new CharSequenceAssertion("значение", null).endsWith("ние");
        new CharSequenceAssertion("значение", null).endsWith("е");

        try {
            new CharSequenceAssertion(null, null).endsWith("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).endsWith(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).endsWith("val");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).endsWith("LuE");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<LuE> but was:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).endsWith("значе");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<значе> but was:<значение>");
        }
        try {
            new CharSequenceAssertion("значение", null).endsWith("ЧенИе");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ЧенИе> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void endsWithIgnoreCaseTest() {
        new CharSequenceAssertion("vAlUe", null).endsWithIgnoreCase("vaLue");
        new CharSequenceAssertion("vAlUe", null).endsWithIgnoreCase("Lue");
        new CharSequenceAssertion("vAlUe", null).endsWithIgnoreCase("E");
        new CharSequenceAssertion("знАчЕнИе", null).endsWithIgnoreCase("значеНИЕ");
        new CharSequenceAssertion("знАчЕнИе", null).endsWithIgnoreCase("чеНИЕ");
        new CharSequenceAssertion("знАчЕнИе", null).endsWithIgnoreCase("Е");
        new CharSequenceAssertion("aaaxxxxx", null).endsWithIgnoreCase("xxx");

        try {
            new CharSequenceAssertion(null, null).endsWithIgnoreCase("vAlUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).endsWithIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).endsWithIgnoreCase("val");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<vAlUe>");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).endsWithIgnoreCase("vUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<vUe> but was:<vAlUe>");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", null).endsWithIgnoreCase("знАчЕ");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАчЕ> but was:<знАчЕнИе>");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", null).endsWithIgnoreCase("знАИе");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАИе> but was:<знАчЕнИе>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotEndWithTest() {
        new CharSequenceAssertion("value", null).doesNotEndWith("aLue");
        new CharSequenceAssertion("value", null).doesNotEndWith("vue");
        new CharSequenceAssertion("value", null).doesNotEndWith("val");
        new CharSequenceAssertion("значение", null).doesNotEndWith("ачЕниЕ");
        new CharSequenceAssertion("значение", null).doesNotEndWith("зние");
        new CharSequenceAssertion("значение", null).doesNotEndWith("зна");

        try {
            new CharSequenceAssertion(null, null).doesNotEndWith("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotEndWith(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotEndWith("value");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<value> but was:<value>");
        }
        try {
            new CharSequenceAssertion("value", null).doesNotEndWith("alue");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<alue> but was:<value>");
        }
        try {
            new CharSequenceAssertion("значение", null).doesNotEndWith("значение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<значение> but was:<значение>");
        }
        try {
            new CharSequenceAssertion("значение", null).doesNotEndWith("ие");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<ие> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotEndWithIgnoreCaseTest() {
        new CharSequenceAssertion("vAlUe", null).doesNotEndWithIgnoreCase("aLe");
        new CharSequenceAssertion("vAlUe", null).doesNotEndWithIgnoreCase("vue");
        new CharSequenceAssertion("vAlUe", null).doesNotEndWithIgnoreCase("val");
        new CharSequenceAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("зачЕниЕ");
        new CharSequenceAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("зние");
        new CharSequenceAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("зна");

        try {
            new CharSequenceAssertion(null, null).doesNotEndWithIgnoreCase("vAlUe");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).doesNotEndWithIgnoreCase(null);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).doesNotEndWithIgnoreCase("vaLue");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<vaLue> but was:<vAlUe>");
        }
        try {
            new CharSequenceAssertion("vAlUe", null).doesNotEndWithIgnoreCase("aLue");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<aLue> but was:<vAlUe>");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("знАчение");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<знАчение> but was:<знАчЕнИе>");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("е");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<е> but was:<знАчЕнИе>");
        }
        try {
            new CharSequenceAssertion("aaaxxxxx", null).doesNotEndWithIgnoreCase("xxx");
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<xxx> but was:<aaaxxxxx>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new CharSequenceAssertion("vAlUe", null).toLength().isEqualTo(5);
        new CharSequenceAssertion("vAlUe", null).toLength().isGreaterThan(3);
        new CharSequenceAssertion("vAlUe", null).toLength().isLessThan(7);

        new CharSequenceAssertion("знАчЕнИе", null).toLength().isEqualTo(8);
        new CharSequenceAssertion("знАчЕнИе", null).toLength().isGreaterThan(5);
        new CharSequenceAssertion("знАчЕнИе", null).toLength().isLessThan(10);

        try {
            new CharSequenceAssertion(null, null).toLength();
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new CharSequenceAssertion("vAlUe", null).hasLength(5);
        new CharSequenceAssertion("знАчЕнИе", null).hasLength(8);

        try {
            new CharSequenceAssertion(null, null).hasLength(5);
            Assertions.fail("Char sequence assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", null).asString(null)).isNull();
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", null).asString("vAlUe")).isNull();
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", null).asString("знАчЕнИе")).isNull();
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", null).asString(1)).isNull();
    }

}
