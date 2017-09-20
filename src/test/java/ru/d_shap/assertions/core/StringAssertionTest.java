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
package ru.d_shap.assertions.core;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link StringAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class StringAssertionTest {

    /**
     * Test class constructor.
     */
    public StringAssertionTest() {
        super();
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new StringAssertion("", null).isEmpty();

        try {
            new StringAssertion(null, null).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(" ", null).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:< >");
        }
        try {
            new StringAssertion("value", null).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new StringAssertion(null, null).isNullOrEmpty();
        new StringAssertion("", null).isNullOrEmpty();

        try {
            new StringAssertion(" ", null).isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:< >");
        }
        try {
            new StringAssertion("value", null).isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new StringAssertion(" ", null).isNotEmpty();
        new StringAssertion("value", null).isNotEmpty();

        try {
            new StringAssertion(null, null).isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("", null).isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isBlankTest() {
        new StringAssertion("", null).isBlank();
        new StringAssertion(" ", null).isBlank();
        new StringAssertion("\t", null).isBlank();
        new StringAssertion("   \t   \t", null).isBlank();

        try {
            new StringAssertion(null, null).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<value>");
        }
        try {
            new StringAssertion("v   ", null).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<v   >");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNullOrBlankTest() {
        new StringAssertion(null, null).isNullOrBlank();
        new StringAssertion("", null).isNullOrBlank();
        new StringAssertion(" ", null).isNullOrBlank();
        new StringAssertion("\t", null).isNullOrBlank();
        new StringAssertion("   \t   \t", null).isNullOrBlank();

        try {
            new StringAssertion("value", null).isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<value>");
        }
        try {
            new StringAssertion("v   ", null).isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<v   >");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotBlankTest() {
        new StringAssertion("value", null).isNotBlank();
        new StringAssertion("v   ", null).isNotBlank();

        try {
            new StringAssertion(null, null).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("", null).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new StringAssertion(" ", null).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new StringAssertion("\t", null).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new StringAssertion("   \t   \t", null).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new StringAssertion("value", null).isEqualTo("value");
        new StringAssertion("ЗНАЧЕНИЕ", null).isEqualTo("ЗНАЧЕНИЕ");
        new StringAssertion("значение", null).isEqualTo("значение");
        new StringAssertion("", null).isEqualTo("");

        try {
            new StringAssertion(null, null).isEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isEqualTo("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<value>");
        }
        try {
            new StringAssertion("value1", null).isEqualTo("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            new StringAssertion("value1", null).isEqualTo("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualToIgnoreCase("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            new StringAssertion("value", null).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<значение>");
        }
        try {
            new StringAssertion("ЗНАЧЕНИЕ", null).isEqualTo("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEqualToIgnoreCaseTest() {
        new StringAssertion("valUe", null).isEqualToIgnoreCase("vALue");
        new StringAssertion("ЗНАЧЕНИЕ", null).isEqualToIgnoreCase("значение");
        new StringAssertion("значение", null).isEqualToIgnoreCase("ЗНАЧЕНИЕ");
        new StringAssertion("", null).isEqualToIgnoreCase("");

        try {
            new StringAssertion(null, null).isEqualToIgnoreCase("vALue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vALue", null).isEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vALue", null).isEqualToIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<vALue>");
        }
        try {
            new StringAssertion("value1", null).isEqualToIgnoreCase("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            new StringAssertion("value", null).isEqualToIgnoreCase("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isEqualToIgnoreCase("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<value>");
        }
        try {
            new StringAssertion("ЗнаЧеНИЕ", null).isEqualToIgnoreCase("vaLUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<vaLUE> but was:<ЗнаЧеНИЕ>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new StringAssertion("value", null).isNotEqualTo("значение");
        new StringAssertion("value", null).isNotEqualTo("ЗНАЧЕНИЕ");
        new StringAssertion("значение", null).isNotEqualTo("value");
        new StringAssertion("ЗНАЧЕНИЕ", null).isNotEqualTo("value");
        new StringAssertion("ЗНАЧЕНИЕ", null).isNotEqualTo("");

        try {
            new StringAssertion(null, null).isNotEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isNotEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", null).isNotEqualTo("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>");
        }
        try {
            new StringAssertion("value", null).isNotEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            new StringAssertion("значение", null).isNotEqualTo("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<значение>");
        }
        try {
            new StringAssertion("ЗНАЧЕНИЕ", null).isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotEqualToIgnoreCaseTest() {
        new StringAssertion("vaLUe", null).isNotEqualToIgnoreCase("знАЧенИЕ");
        new StringAssertion("VAluE", null).isNotEqualToIgnoreCase("ЗНачЕНие");
        new StringAssertion("знАЧенИЕ", null).isNotEqualToIgnoreCase("vaLUe");
        new StringAssertion("ЗНачЕНие", null).isNotEqualToIgnoreCase("VAluE");
        new StringAssertion("ЗНачЕНие", null).isNotEqualToIgnoreCase("");

        try {
            new StringAssertion(null, null).isNotEqualToIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vaLUe", null).isNotEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", null).isNotEqualToIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>");
        }
        try {
            new StringAssertion("value", null).isNotEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            new StringAssertion("знАЧенИЕ", null).isNotEqualToIgnoreCase("ЗНачЕНие");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<знАЧенИЕ>");
        }
        try {
            new StringAssertion("ЗНачЕНие", null).isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНачЕНие>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new StringAssertion("value", null).isGreaterThan("aaa");
        new StringAssertion("value", null).isGreaterThan("vai");
        new StringAssertion("value", null).isGreaterThan("valuazzz");
        new StringAssertion("value", null).isGreaterThan("VALUE");
        new StringAssertion("value", null).isGreaterThan("XYZ");

        try {
            new StringAssertion(null, null).isGreaterThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isGreaterThan(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isGreaterThan("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", null).isGreaterThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isGreaterThan("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isGreaterThan("x");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isGreaterThanIgnoreCaseTest() {
        new StringAssertion("value", null).isGreaterThanIgnoreCase("aaa");
        new StringAssertion("value", null).isGreaterThanIgnoreCase("vai");
        new StringAssertion("value", null).isGreaterThanIgnoreCase("vAi");
        new StringAssertion("value", null).isGreaterThanIgnoreCase("valuazzz");
        new StringAssertion("value", null).isGreaterThanIgnoreCase("vAlUazzz");

        try {
            new StringAssertion(null, null).isGreaterThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isGreaterThanIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isGreaterThanIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", null).isGreaterThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isGreaterThanIgnoreCase("VALUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<VALUE> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isGreaterThanIgnoreCase("XYZ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<XYZ> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isGreaterThanIgnoreCase("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isGreaterThanIgnoreCase("x");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new StringAssertion("value", null).isGreaterThanOrEqualTo("aaa");
        new StringAssertion("value", null).isGreaterThanOrEqualTo("vai");
        new StringAssertion("value", null).isGreaterThanOrEqualTo("valuazzz");
        new StringAssertion("value", null).isGreaterThanOrEqualTo("VALUE");
        new StringAssertion("value", null).isGreaterThanOrEqualTo("XYZ");
        new StringAssertion("value", null).isGreaterThanOrEqualTo("value");
        new StringAssertion("value", null).isGreaterThanOrEqualTo("");
        new StringAssertion("", null).isGreaterThanOrEqualTo("");

        try {
            new StringAssertion(null, null).isGreaterThanOrEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isGreaterThanOrEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isGreaterThanOrEqualTo("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isGreaterThanOrEqualTo("x");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToIgnoreCaseTest() {
        new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("aaa");
        new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("vai");
        new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("vAi");
        new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("valuazzz");
        new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("vAlUazzz");
        new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("value");
        new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("VALUE");
        new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("");
        new StringAssertion("", null).isGreaterThanOrEqualToIgnoreCase("");

        try {
            new StringAssertion(null, null).isGreaterThanOrEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("XYZ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<XYZ> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isGreaterThanOrEqualToIgnoreCase("x");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new StringAssertion("value", null).isLessThan("yyy");
        new StringAssertion("value", null).isLessThan("vam");
        new StringAssertion("value", null).isLessThan("valuezzz");
        new StringAssertion("VALUE", null).isLessThan("value");
        new StringAssertion("XYZ", null).isLessThan("value");

        try {
            new StringAssertion(null, null).isLessThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isLessThan(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isLessThan("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", null).isLessThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isLessThan("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isLessThan("c");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isLessThanIgnoreCaseTest() {
        new StringAssertion("value", null).isLessThanIgnoreCase("yyy");
        new StringAssertion("value", null).isLessThanIgnoreCase("vam");
        new StringAssertion("vAlue", null).isLessThanIgnoreCase("vam");
        new StringAssertion("value", null).isLessThanIgnoreCase("valuezzz");
        new StringAssertion("vAlUe", null).isLessThanIgnoreCase("valuezzz");

        try {
            new StringAssertion(null, null).isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isLessThanIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isLessThanIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", null).isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>");
        }
        try {
            new StringAssertion("VALUE", null).isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<VALUE>");
        }
        try {
            new StringAssertion("XYZ", null).isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<XYZ>");
        }
        try {
            new StringAssertion("value", null).isLessThanIgnoreCase("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isLessThanIgnoreCase("c");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new StringAssertion("value", null).isLessThanOrEqualTo("yyy");
        new StringAssertion("value", null).isLessThanOrEqualTo("vam");
        new StringAssertion("value", null).isLessThanOrEqualTo("valuezzz");
        new StringAssertion("VALUE", null).isLessThanOrEqualTo("value");
        new StringAssertion("XYZ", null).isLessThanOrEqualTo("value");
        new StringAssertion("value", null).isLessThanOrEqualTo("value");
        new StringAssertion("", null).isLessThanOrEqualTo("");

        try {
            new StringAssertion(null, null).isLessThanOrEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isLessThanOrEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isLessThanOrEqualTo("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isLessThanOrEqualTo("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isLessThanOrEqualTo("c");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToIgnoreCaseTest() {
        new StringAssertion("value", null).isLessThanOrEqualToIgnoreCase("yyy");
        new StringAssertion("value", null).isLessThanOrEqualToIgnoreCase("vam");
        new StringAssertion("vAlue", null).isLessThanOrEqualToIgnoreCase("vam");
        new StringAssertion("value", null).isLessThanOrEqualToIgnoreCase("valuezzz");
        new StringAssertion("vAlUe", null).isLessThanOrEqualToIgnoreCase("valuezzz");
        new StringAssertion("value", null).isLessThanOrEqualToIgnoreCase("value");
        new StringAssertion("VALUE", null).isLessThanOrEqualToIgnoreCase("value");
        new StringAssertion("", null).isLessThanOrEqualToIgnoreCase("");

        try {
            new StringAssertion(null, null).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isLessThanOrEqualToIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>");
        }
        try {
            new StringAssertion("XYZ", null).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<value> but was:<XYZ>");
        }
        try {
            new StringAssertion("value", null).isLessThanOrEqualToIgnoreCase("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isLessThanOrEqualToIgnoreCase("c");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new StringAssertion("value", null).isInRange("v", "valuex");
        new StringAssertion("value", null).isInRange("a", "z");
        new StringAssertion("value", null).isInRange("A", "z");
        new StringAssertion("value", null).isInRange("value", "z");
        new StringAssertion("value", null).isInRange("VALUE", "z");
        new StringAssertion("value", null).isInRange("", "z");
        new StringAssertion("", null).isInRange("", "z");

        try {
            new StringAssertion(null, null).isInRange("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isInRange(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isInRange("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isInRange("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", null).isInRange("A", "Z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:Z> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isInRange("a", "test");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isInRange("A", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isInRange("A", "vaLUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isInRange("xxx", "yyy");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<xxx:yyy> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isInRangeIgnoreCaseTest() {
        new StringAssertion("value", null).isInRangeIgnoreCase("v", "valuex");
        new StringAssertion("value", null).isInRangeIgnoreCase("a", "z");
        new StringAssertion("value", null).isInRangeIgnoreCase("a", "Z");
        new StringAssertion("value", null).isInRangeIgnoreCase("A", "z");
        new StringAssertion("value", null).isInRangeIgnoreCase("A", "Z");
        new StringAssertion("value", null).isInRangeIgnoreCase("value", "z");
        new StringAssertion("value", null).isInRangeIgnoreCase("value", "Z");
        new StringAssertion("value", null).isInRangeIgnoreCase("VALUE", "z");
        new StringAssertion("value", null).isInRangeIgnoreCase("VALUE", "Z");
        new StringAssertion("value", null).isInRangeIgnoreCase("", "Z");
        new StringAssertion("", null).isInRangeIgnoreCase("", "Z");

        try {
            new StringAssertion(null, null).isInRangeIgnoreCase("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isInRangeIgnoreCase(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isInRangeIgnoreCase("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isInRangeIgnoreCase("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", null).isInRangeIgnoreCase("a", "test");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isInRangeIgnoreCase("A", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isInRangeIgnoreCase("A", "vaLUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isInRangeIgnoreCase("xxx", "yyy");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<xxx:yyy> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isInRangeIgnoreCase("XXX", "YYY");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<XXX:YYY> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new StringAssertion("value", null).isNotInRange("A", "Z");
        new StringAssertion("value", null).isNotInRange("a", "test");
        new StringAssertion("value", null).isNotInRange("A", "value");
        new StringAssertion("value", null).isNotInRange("A", "vaLUE");
        new StringAssertion("value", null).isNotInRange("VALUE", "Z");
        new StringAssertion("value", null).isNotInRange("xxx", "yyy");
        new StringAssertion("value", null).isNotInRange("XXX", "YYY");
        new StringAssertion("value", null).isNotInRange("", "aaa");

        try {
            new StringAssertion(null, null).isNotInRange("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isNotInRange(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isNotInRange("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isNotInRange("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", null).isNotInRange("v", "valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRange("a", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRange("A", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRange("value", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRange("VALUE", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotInRangeIgnoreCaseTest() {
        new StringAssertion("value", null).isNotInRangeIgnoreCase("a", "test");
        new StringAssertion("value", null).isNotInRangeIgnoreCase("A", "value");
        new StringAssertion("value", null).isNotInRangeIgnoreCase("A", "vaLUE");
        new StringAssertion("value", null).isNotInRangeIgnoreCase("xxx", "yyy");
        new StringAssertion("value", null).isNotInRangeIgnoreCase("XXX", "YYY");
        new StringAssertion("value", null).isNotInRangeIgnoreCase("", "AAA");

        try {
            new StringAssertion(null, null).isNotInRangeIgnoreCase("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase("A", "Z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:Z> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase("v", "valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase("a", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase("A", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase("value", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase("VALUE", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>");
        }
        try {
            new StringAssertion("value", null).isNotInRangeIgnoreCase("VALUE", "Z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:Z> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void containsTest() {
        new StringAssertion("value", null).contains("val");
        new StringAssertion("value", null).contains("alu");
        new StringAssertion("value", null).contains("lue");
        new StringAssertion("значение", null).contains("знач");
        new StringAssertion("значение", null).contains("ен");
        new StringAssertion("значение", null).contains("ие");

        try {
            new StringAssertion(null, null).contains("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).contains(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).contains("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", null).contains("VAL");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAL> but was:<value>");
        }
        try {
            new StringAssertion("value", null).contains("v.*ue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<value>");
        }
        try {
            new StringAssertion("value", null).contains("знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<знач> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).contains("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<value> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void containsIgnoreCaseTest() {
        new StringAssertion("value", null).containsIgnoreCase("VAL");
        new StringAssertion("VAlUE", null).containsIgnoreCase("aLu");
        new StringAssertion("VAlue", null).containsIgnoreCase("luE");
        new StringAssertion("значение", null).containsIgnoreCase("ЗНАЧ");
        new StringAssertion("ЗНАчЕнИЕ", null).containsIgnoreCase("еН");
        new StringAssertion("ЗНАЧЕние", null).containsIgnoreCase("Ие");

        try {
            new StringAssertion(null, null).containsIgnoreCase("VAlue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("VAlue", null).containsIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("VAlue", null).containsIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", null).containsIgnoreCase("VAE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAE> but was:<value>");
        }
        try {
            new StringAssertion("vaLUe", null).containsIgnoreCase("v.*ue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<vaLUe>");
        }
        try {
            new StringAssertion("vaLue", null).containsIgnoreCase("зНАч");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<зНАч> but was:<vaLue>");
        }
        try {
            new StringAssertion("знАЧЕние", null).containsIgnoreCase("valUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<valUE> but was:<знАЧЕние>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new StringAssertion("value", null).doesNotContain("vaue");
        new StringAssertion("value", null).doesNotContain("VAL");
        new StringAssertion("value", null).doesNotContain("UE");
        new StringAssertion("значение", null).doesNotContain("ЗНАЧ");
        new StringAssertion("значение", null).doesNotContain("кени");
        new StringAssertion("значение", null).doesNotContain("НИЕ");

        try {
            new StringAssertion(null, null).doesNotContain("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).doesNotContain(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).doesNotContain("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", null).doesNotContain("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<value>");
        }
        try {
            new StringAssertion("value", null).doesNotContain("alu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<alu> but was:<value>");
        }
        try {
            new StringAssertion("value", null).doesNotContain("lue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lue> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).doesNotContain("знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).doesNotContain("ение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<ение> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotContainIgnoreCaseTest() {
        new StringAssertion("value", null).doesNotContainIgnoreCase("vaUE");
        new StringAssertion("valUE", null).doesNotContainIgnoreCase("1VAL");
        new StringAssertion("valUE", null).doesNotContainIgnoreCase("UE1");
        new StringAssertion("знАчеНие", null).doesNotContainIgnoreCase("ЗНАН");
        new StringAssertion("знАчеНие", null).doesNotContainIgnoreCase("кени");
        new StringAssertion("знАчеНие", null).doesNotContainIgnoreCase("чИЕ");

        try {
            new StringAssertion(null, null).doesNotContainIgnoreCase("valUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("valUE", null).doesNotContainIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("valUE", null).doesNotContainIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("vaLUe", null).doesNotContainIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<vaLUe>");
        }
        try {
            new StringAssertion("vaLUe", null).doesNotContainIgnoreCase("VAL");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<VAL> but was:<vaLUe>");
        }
        try {
            new StringAssertion("vaLUe", null).doesNotContainIgnoreCase("lUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lUE> but was:<vaLUe>");
        }
        try {
            new StringAssertion("зНАчеНИе", null).doesNotContainIgnoreCase("знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<зНАчеНИе>");
        }
        try {
            new StringAssertion("зНАчеНИе", null).doesNotContainIgnoreCase("еНИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<еНИе> but was:<зНАчеНИе>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isPartOfTest() {
        new StringAssertion("val", null).isPartOf("value");
        new StringAssertion("alu", null).isPartOf("value");
        new StringAssertion("lue", null).isPartOf("value");
        new StringAssertion("знач", null).isPartOf("значение");
        new StringAssertion("ен", null).isPartOf("значение");
        new StringAssertion("ие", null).isPartOf("значение");
        new StringAssertion("", null).isPartOf("");

        try {
            new StringAssertion(null, null).isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isPartOf(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).isPartOf("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<value>");
        }
        try {
            new StringAssertion("VAL", null).isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<VAL>");
        }
        try {
            new StringAssertion("vue", null).isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<vue>");
        }
        try {
            new StringAssertion("ЗнАЧ", null).isPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<ЗнАЧ>");
        }
        try {
            new StringAssertion("чача", null).isPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<чача>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isPartOfIgnoreCaseTest() {
        new StringAssertion("vAl", null).isPartOfIgnoreCase("vaLUe");
        new StringAssertion("Alu", null).isPartOfIgnoreCase("vaLUe");
        new StringAssertion("luE", null).isPartOfIgnoreCase("vaLUe");
        new StringAssertion("знАЧ", null).isPartOfIgnoreCase("зНАчеНИе");
        new StringAssertion("Ен", null).isPartOfIgnoreCase("зНАчеНИе");
        new StringAssertion("иЕ", null).isPartOfIgnoreCase("зНАчеНИе");
        new StringAssertion("", null).isPartOfIgnoreCase("");

        try {
            new StringAssertion(null, null).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vaLUe", null).isPartOfIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vaLUe", null).isPartOfIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<vaLUe>");
        }
        try {
            new StringAssertion("VAe", null).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<VAe>");
        }
        try {
            new StringAssertion("vUe", null).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<vUe>");
        }
        try {
            new StringAssertion("ЗАЧ", null).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<ЗАЧ>");
        }
        try {
            new StringAssertion("чача", null).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<чача>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotPartOfTest() {
        new StringAssertion("vae", null).isNotPartOf("value");
        new StringAssertion("aLu", null).isNotPartOf("value");
        new StringAssertion("vue", null).isNotPartOf("value");
        new StringAssertion("знаач", null).isNotPartOf("значение");
        new StringAssertion("еНИ", null).isNotPartOf("значение");
        new StringAssertion("чие", null).isNotPartOf("значение");
        new StringAssertion("чие", null).isNotPartOf("");

        try {
            new StringAssertion(null, null).isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).isNotPartOf(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", null).isNotPartOf("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>");
        }
        try {
            new StringAssertion("val", null).isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<val>");
        }
        try {
            new StringAssertion("lue", null).isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<lue>");
        }
        try {
            new StringAssertion("знач", null).isNotPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<знач>");
        }
        try {
            new StringAssertion("ение", null).isNotPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<ение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotPartOfIgnoreCaseTest() {
        new StringAssertion("vAe", null).isNotPartOfIgnoreCase("vaLUe");
        new StringAssertion("aLe", null).isNotPartOfIgnoreCase("vaLUe");
        new StringAssertion("vuE", null).isNotPartOfIgnoreCase("vaLUe");
        new StringAssertion("знААч", null).isNotPartOfIgnoreCase("знАченИе");
        new StringAssertion("еНе", null).isNotPartOfIgnoreCase("знАченИе");
        new StringAssertion("чИЕ", null).isNotPartOfIgnoreCase("знАченИе");
        new StringAssertion("чИЕ", null).isNotPartOfIgnoreCase("");

        try {
            new StringAssertion(null, null).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vaLUe", null).isNotPartOfIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", null).isNotPartOfIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>");
        }
        try {
            new StringAssertion("VAL", null).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<VAL>");
        }
        try {
            new StringAssertion("LuE", null).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<LuE>");
        }
        try {
            new StringAssertion("зНАч", null).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<зНАч>");
        }
        try {
            new StringAssertion("ЕниЕ", null).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<ЕниЕ>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void matchesTest() {
        new StringAssertion("value", null).matches("v.*e");
        new StringAssertion("value", null).matches("v[aA].{2}[eE]");
        new StringAssertion("value", null).matches("\\w+");
        new StringAssertion("value", null).matches("\\w{4,6}");
        new StringAssertion("значение", null).matches("\\p{L}+");
        new StringAssertion("", null).matches("");

        try {
            new StringAssertion(null, null).matches("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).matches(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).matches("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<> but was:<value>");
        }
        try {
            new StringAssertion("value", null).matches("\\d+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\d+> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).matches("\\w+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\w+> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotMatchTest() {
        new StringAssertion("value", null).doesNotMatch("valu.+e");
        new StringAssertion("value", null).doesNotMatch("v[zZ].{2}[eE]");
        new StringAssertion("value", null).doesNotMatch("\\s\\w+");
        new StringAssertion("value", null).doesNotMatch("\\w{8}");
        new StringAssertion("значение", null).doesNotMatch("\\w+");
        new StringAssertion("значение", null).doesNotMatch("");

        try {
            new StringAssertion(null, null).doesNotMatch("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).doesNotMatch(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", null).doesNotMatch("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<> but was:<>");
        }
        try {
            new StringAssertion("value", null).doesNotMatch("\\w+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\w+> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).doesNotMatch("\\p{L}{8}");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\p{L}{8}> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void startsWithTest() {
        new StringAssertion("value", null).startsWith("va");
        new StringAssertion("value", null).startsWith("val");
        new StringAssertion("value", null).startsWith("value");
        new StringAssertion("значение", null).startsWith("зна");
        new StringAssertion("значение", null).startsWith("значе");
        new StringAssertion("значение", null).startsWith("значение");

        try {
            new StringAssertion(null, null).startsWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).startsWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).startsWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", null).startsWith("lue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lue> but was:<value>");
        }
        try {
            new StringAssertion("value", null).startsWith("Val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Val> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).startsWith("ачен");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<ачен> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).startsWith("Знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Знач> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void startsWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", null).startsWithIgnoreCase("vA");
        new StringAssertion("vAlUe", null).startsWithIgnoreCase("VAl");
        new StringAssertion("vAlUe", null).startsWithIgnoreCase("vaLUe");
        new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("зНа");
        new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("зНаче");
        new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("зНачение");

        try {
            new StringAssertion(null, null).startsWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).startsWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).startsWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("vAlUe", null).startsWithIgnoreCase("lUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lUe> but was:<vAlUe>");
        }
        try {
            new StringAssertion("vAlUe", null).startsWithIgnoreCase("Vau");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Vau> but was:<vAlUe>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("аЧен");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<аЧен> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).startsWithIgnoreCase("Значи");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Значи> but was:<знАчЕнИе>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotStartWithTest() {
        new StringAssertion("value", null).doesNotStartWith("VA");
        new StringAssertion("value", null).doesNotStartWith("VaL");
        new StringAssertion("value", null).doesNotStartWith("vale");
        new StringAssertion("значение", null).doesNotStartWith("ЗНА");
        new StringAssertion("значение", null).doesNotStartWith("Знач");
        new StringAssertion("значение", null).doesNotStartWith("чение");

        try {
            new StringAssertion(null, null).doesNotStartWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).doesNotStartWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).doesNotStartWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", null).doesNotStartWith("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<value>");
        }
        try {
            new StringAssertion("value", null).doesNotStartWith("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<valu> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).doesNotStartWith("зн");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).doesNotStartWith("значен");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значен> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotStartWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", null).doesNotStartWithIgnoreCase("Vu");
        new StringAssertion("vAlUe", null).doesNotStartWithIgnoreCase("Vue");
        new StringAssertion("vAlUe", null).doesNotStartWithIgnoreCase("ale");
        new StringAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("НА");
        new StringAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("Знч");
        new StringAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("чние");

        try {
            new StringAssertion(null, null).doesNotStartWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).doesNotStartWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).doesNotStartWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("vAlUe", null).doesNotStartWithIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<vAlUe>");
        }
        try {
            new StringAssertion("vAlUe", null).doesNotStartWithIgnoreCase("VALUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<VALUe> but was:<vAlUe>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("зн");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).doesNotStartWithIgnoreCase("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значение> but was:<знАчЕнИе>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void endsWithTest() {
        new StringAssertion("value", null).endsWith("alue");
        new StringAssertion("value", null).endsWith("lue");
        new StringAssertion("value", null).endsWith("ue");
        new StringAssertion("значение", null).endsWith("ачение");
        new StringAssertion("значение", null).endsWith("ние");
        new StringAssertion("значение", null).endsWith("е");

        try {
            new StringAssertion(null, null).endsWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).endsWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).endsWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", null).endsWith("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<value>");
        }
        try {
            new StringAssertion("value", null).endsWith("LuE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<LuE> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).endsWith("значе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<значе> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).endsWith("ЧенИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ЧенИе> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void endsWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", null).endsWithIgnoreCase("vaLue");
        new StringAssertion("vAlUe", null).endsWithIgnoreCase("Lue");
        new StringAssertion("vAlUe", null).endsWithIgnoreCase("E");
        new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("значеНИЕ");
        new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("чеНИЕ");
        new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("Е");
        new StringAssertion("aaaxxxxx", null).endsWithIgnoreCase("xxx");

        try {
            new StringAssertion(null, null).endsWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).endsWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).endsWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("vAlUe", null).endsWithIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<vAlUe>");
        }
        try {
            new StringAssertion("vAlUe", null).endsWithIgnoreCase("vUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<vUe> but was:<vAlUe>");
        }
        try {
            new StringAssertion("", null).endsWithIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("знАчЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАчЕ> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).endsWithIgnoreCase("знАИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАИе> but was:<знАчЕнИе>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotEndWithTest() {
        new StringAssertion("value", null).doesNotEndWith("aLue");
        new StringAssertion("value", null).doesNotEndWith("vue");
        new StringAssertion("value", null).doesNotEndWith("val");
        new StringAssertion("значение", null).doesNotEndWith("ачЕниЕ");
        new StringAssertion("значение", null).doesNotEndWith("зние");
        new StringAssertion("значение", null).doesNotEndWith("зна");

        try {
            new StringAssertion(null, null).doesNotEndWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", null).doesNotEndWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", null).doesNotEndWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", null).doesNotEndWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<value> but was:<value>");
        }
        try {
            new StringAssertion("value", null).doesNotEndWith("alue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<alue> but was:<value>");
        }
        try {
            new StringAssertion("значение", null).doesNotEndWith("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<значение> but was:<значение>");
        }
        try {
            new StringAssertion("значение", null).doesNotEndWith("ие");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<ие> but was:<значение>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotEndWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", null).doesNotEndWithIgnoreCase("aLe");
        new StringAssertion("vAlUe", null).doesNotEndWithIgnoreCase("vue");
        new StringAssertion("vAlUe", null).doesNotEndWithIgnoreCase("val");
        new StringAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("зачЕниЕ");
        new StringAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("зние");
        new StringAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("зна");
        new StringAssertion("", null).doesNotEndWithIgnoreCase("val");

        try {
            new StringAssertion(null, null).doesNotEndWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).doesNotEndWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).doesNotEndWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("vAlUe", null).doesNotEndWithIgnoreCase("vaLue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<vaLue> but was:<vAlUe>");
        }
        try {
            new StringAssertion("vAlUe", null).doesNotEndWithIgnoreCase("aLue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<aLue> but was:<vAlUe>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("знАчение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<знАчение> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("знАчЕнИе", null).doesNotEndWithIgnoreCase("е");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<е> but was:<знАчЕнИе>");
        }
        try {
            new StringAssertion("aaaxxxxx", null).doesNotEndWithIgnoreCase("xxx");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<xxx> but was:<aaaxxxxx>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new StringAssertion("vAlUe", null).toLength().isEqualTo(5);
        new StringAssertion("vAlUe", null).toLength().isGreaterThan(3);
        new StringAssertion("vAlUe", null).toLength().isLessThan(7);

        new StringAssertion("знАчЕнИе", null).toLength().isEqualTo(8);
        new StringAssertion("знАчЕнИе", null).toLength().isGreaterThan(5);
        new StringAssertion("знАчЕнИе", null).toLength().isLessThan(10);

        try {
            new StringAssertion(null, null).toLength();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).toLength().isEqualTo(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            new StringAssertion("vAlUe", "Message").toLength().isEqualTo(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new StringAssertion("vAlUe", null).hasLength(5);
        new StringAssertion("знАчЕнИе", null).hasLength(8);

        try {
            new StringAssertion(null, null).hasLength(5);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", null).hasLength(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            new StringAssertion("vAlUe", "Message").hasLength(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void toTokensTest() {
        new StringAssertion("value1 value2 value3", null).toTokens().containsAll("value1", "value2", "value3");
        new StringAssertion("value1|value2|value3", null).toTokens().containsAll("value1|value2|value3");
        new StringAssertion("value1|value2|value3", null).toTokens("|").containsAll("value1", "value2", "value3");
        new StringAssertion("value1|value2|value3", null).toTokens("|", false).containsAll("value1", "value2", "value3");
        new StringAssertion("value1|value2|value3", null).toTokens("|", true).containsAll("value1", "value2", "value3", "|", "|");

        try {
            new StringAssertion(null, null).toTokens();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(null, null).toTokens("|");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value1|value2|value3", null).toTokens(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion(null, null).toTokens("|", false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value1|value2|value3", null).toTokens(null, false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value1 value2 value3", null).toTokens().hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new StringAssertion("value1 value2 value3", "Message").toTokens().hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new StringAssertion("value1|value2|value3", null).toTokens("|").hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new StringAssertion("value1|value2|value3", "Message").toTokens("|").hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new StringAssertion("value1|value2|value3", null).toTokens("|", true).hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<5>");
        }
        try {
            new StringAssertion("value1|value2|value3", "Message").toTokens("|", true).hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<5>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new StringAssertion("vAlUe", null).asString(null)).isNull();
        Assertions.assertThat(new StringAssertion("vAlUe", null).asString("vAlUe")).isEqualTo("vAlUe");
        Assertions.assertThat(new StringAssertion("vAlUe", null).asString("знАчЕнИе")).isEqualTo("знАчЕнИе");
        Assertions.assertThat(new StringAssertion("vAlUe", null).asString(1)).isEqualTo("1");
    }

}
