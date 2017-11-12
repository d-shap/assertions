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
import ru.d_shap.assertions.FailDescription;

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
        new StringAssertion("", new FailDescription()).isEmpty();

        try {
            new StringAssertion(null, new FailDescription()).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription("Message")).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new StringAssertion(" ", new FailDescription()).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:< >.");
        }
        try {
            new StringAssertion(" ", new FailDescription("Message")).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:< >.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription("Message")).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new StringAssertion(null, new FailDescription()).isNullOrEmpty();
        new StringAssertion("", new FailDescription()).isNullOrEmpty();

        try {
            new StringAssertion(" ", new FailDescription()).isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:< >.");
        }
        try {
            new StringAssertion(" ", new FailDescription("Message")).isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:< >.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription("Message")).isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new StringAssertion(" ", new FailDescription()).isNotEmpty();
        new StringAssertion("value", new FailDescription()).isNotEmpty();

        try {
            new StringAssertion(null, new FailDescription()).isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription("Message")).isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new StringAssertion("", new FailDescription()).isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new StringAssertion("", new FailDescription("Message")).isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isBlankTest() {
        new StringAssertion("", new FailDescription()).isBlank();
        new StringAssertion(" ", new FailDescription()).isBlank();
        new StringAssertion("\t", new FailDescription()).isBlank();
        new StringAssertion("   \t   \t", new FailDescription()).isBlank();

        try {
            new StringAssertion(null, new FailDescription()).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription("Message")).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription("Message")).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be blank. Actual:<value>.");
        }
        try {
            new StringAssertion("v   ", new FailDescription()).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<v   >.");
        }
        try {
            new StringAssertion("v   ", new FailDescription("Message")).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be blank. Actual:<v   >.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNullOrBlankTest() {
        new StringAssertion(null, new FailDescription()).isNullOrBlank();
        new StringAssertion("", new FailDescription()).isNullOrBlank();
        new StringAssertion(" ", new FailDescription()).isNullOrBlank();
        new StringAssertion("\t", new FailDescription()).isNullOrBlank();
        new StringAssertion("   \t   \t", new FailDescription()).isNullOrBlank();

        try {
            new StringAssertion("value", new FailDescription()).isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription("Message")).isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or blank. Actual:<value>.");
        }
        try {
            new StringAssertion("v   ", new FailDescription()).isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<v   >.");
        }
        try {
            new StringAssertion("v   ", new FailDescription("Message")).isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or blank. Actual:<v   >.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotBlankTest() {
        new StringAssertion("value", new FailDescription()).isNotBlank();
        new StringAssertion("v   ", new FailDescription()).isNotBlank();

        try {
            new StringAssertion(null, new FailDescription()).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription("Message")).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new StringAssertion("", new FailDescription()).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new StringAssertion("", new FailDescription("Message")).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
        try {
            new StringAssertion(" ", new FailDescription()).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new StringAssertion(" ", new FailDescription("Message")).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
        try {
            new StringAssertion("\t", new FailDescription()).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new StringAssertion("\t", new FailDescription("Message")).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
        try {
            new StringAssertion("   \t   \t", new FailDescription()).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new StringAssertion("   \t   \t", new FailDescription("Message")).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new StringAssertion("value", new FailDescription()).isEqualTo("value");
        new StringAssertion("ЗНАЧЕНИЕ", new FailDescription()).isEqualTo("ЗНАЧЕНИЕ");
        new StringAssertion("значение", new FailDescription()).isEqualTo("значение");
        new StringAssertion("", new FailDescription()).isEqualTo("");

        try {
            new StringAssertion(null, new FailDescription()).isEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isEqualTo("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<value>.");
        }
        try {
            new StringAssertion("value1", new FailDescription()).isEqualTo("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>.");
        }
        try {
            new StringAssertion("value1", new FailDescription()).isEqualTo("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualToIgnoreCase("Values should be the same. Expected:<value2> but was:<value1>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<значение>.");
        }
        try {
            new StringAssertion("ЗНАЧЕНИЕ", new FailDescription()).isEqualTo("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<ЗНАЧЕНИЕ>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEqualToIgnoreCaseTest() {
        new StringAssertion("valUe", new FailDescription()).isEqualToIgnoreCase("vALue");
        new StringAssertion("ЗНАЧЕНИЕ", new FailDescription()).isEqualToIgnoreCase("значение");
        new StringAssertion("значение", new FailDescription()).isEqualToIgnoreCase("ЗНАЧЕНИЕ");
        new StringAssertion("", new FailDescription()).isEqualToIgnoreCase("");

        try {
            new StringAssertion(null, new FailDescription()).isEqualToIgnoreCase("vALue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vALue", new FailDescription()).isEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vALue", new FailDescription()).isEqualToIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<vALue>.");
        }
        try {
            new StringAssertion("value1", new FailDescription()).isEqualToIgnoreCase("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isEqualToIgnoreCase("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isEqualToIgnoreCase("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<value>.");
        }
        try {
            new StringAssertion("ЗнаЧеНИЕ", new FailDescription()).isEqualToIgnoreCase("vaLUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<vaLUE> but was:<ЗнаЧеНИЕ>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new StringAssertion("value", new FailDescription()).isNotEqualTo("значение");
        new StringAssertion("value", new FailDescription()).isNotEqualTo("ЗНАЧЕНИЕ");
        new StringAssertion("значение", new FailDescription()).isNotEqualTo("value");
        new StringAssertion("ЗНАЧЕНИЕ", new FailDescription()).isNotEqualTo("value");
        new StringAssertion("ЗНАЧЕНИЕ", new FailDescription()).isNotEqualTo("");

        try {
            new StringAssertion(null, new FailDescription()).isNotEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", new FailDescription()).isNotEqualTo("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).isNotEqualTo("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<значение>.");
        }
        try {
            new StringAssertion("ЗНАЧЕНИЕ", new FailDescription()).isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНАЧЕНИЕ>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotEqualToIgnoreCaseTest() {
        new StringAssertion("vaLUe", new FailDescription()).isNotEqualToIgnoreCase("знАЧенИЕ");
        new StringAssertion("VAluE", new FailDescription()).isNotEqualToIgnoreCase("ЗНачЕНие");
        new StringAssertion("знАЧенИЕ", new FailDescription()).isNotEqualToIgnoreCase("vaLUe");
        new StringAssertion("ЗНачЕНие", new FailDescription()).isNotEqualToIgnoreCase("VAluE");
        new StringAssertion("ЗНачЕНие", new FailDescription()).isNotEqualToIgnoreCase("");

        try {
            new StringAssertion(null, new FailDescription()).isNotEqualToIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vaLUe", new FailDescription()).isNotEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", new FailDescription()).isNotEqualToIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
        try {
            new StringAssertion("знАЧенИЕ", new FailDescription()).isNotEqualToIgnoreCase("ЗНачЕНие");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<знАЧенИЕ>.");
        }
        try {
            new StringAssertion("ЗНачЕНие", new FailDescription()).isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНачЕНие>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new StringAssertion("value", new FailDescription()).isGreaterThan("aaa");
        new StringAssertion("value", new FailDescription()).isGreaterThan("vai");
        new StringAssertion("value", new FailDescription()).isGreaterThan("valuazzz");
        new StringAssertion("value", new FailDescription()).isGreaterThan("VALUE");
        new StringAssertion("value", new FailDescription()).isGreaterThan("XYZ");

        try {
            new StringAssertion(null, new FailDescription()).isGreaterThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThan(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThan("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThan("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThan("x");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isGreaterThanIgnoreCaseTest() {
        new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("aaa");
        new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("vai");
        new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("vAi");
        new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("valuazzz");
        new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("vAlUazzz");

        try {
            new StringAssertion(null, new FailDescription()).isGreaterThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("VALUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<VALUE> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("XYZ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<XYZ> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("x");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("aaa");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("vai");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("valuazzz");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("VALUE");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("XYZ");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("value");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("");
        new StringAssertion("", new FailDescription()).isGreaterThanOrEqualTo("");

        try {
            new StringAssertion(null, new FailDescription()).isGreaterThanOrEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("x");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToIgnoreCaseTest() {
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("aaa");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("vai");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("vAi");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("valuazzz");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("vAlUazzz");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("value");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("VALUE");
        new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("");
        new StringAssertion("", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("");

        try {
            new StringAssertion(null, new FailDescription()).isGreaterThanOrEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("XYZ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<XYZ> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("x");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new StringAssertion("value", new FailDescription()).isLessThan("yyy");
        new StringAssertion("value", new FailDescription()).isLessThan("vam");
        new StringAssertion("value", new FailDescription()).isLessThan("valuezzz");
        new StringAssertion("VALUE", new FailDescription()).isLessThan("value");
        new StringAssertion("XYZ", new FailDescription()).isLessThan("value");

        try {
            new StringAssertion(null, new FailDescription()).isLessThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThan(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThan("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThan("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThan("c");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isLessThanIgnoreCaseTest() {
        new StringAssertion("value", new FailDescription()).isLessThanIgnoreCase("yyy");
        new StringAssertion("value", new FailDescription()).isLessThanIgnoreCase("vam");
        new StringAssertion("vAlue", new FailDescription()).isLessThanIgnoreCase("vam");
        new StringAssertion("value", new FailDescription()).isLessThanIgnoreCase("valuezzz");
        new StringAssertion("vAlUe", new FailDescription()).isLessThanIgnoreCase("valuezzz");

        try {
            new StringAssertion(null, new FailDescription()).isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>.");
        }
        try {
            new StringAssertion("VALUE", new FailDescription()).isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<VALUE>.");
        }
        try {
            new StringAssertion("XYZ", new FailDescription()).isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<XYZ>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanIgnoreCase("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanIgnoreCase("c");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new StringAssertion("value", new FailDescription()).isLessThanOrEqualTo("yyy");
        new StringAssertion("value", new FailDescription()).isLessThanOrEqualTo("vam");
        new StringAssertion("value", new FailDescription()).isLessThanOrEqualTo("valuezzz");
        new StringAssertion("VALUE", new FailDescription()).isLessThanOrEqualTo("value");
        new StringAssertion("XYZ", new FailDescription()).isLessThanOrEqualTo("value");
        new StringAssertion("value", new FailDescription()).isLessThanOrEqualTo("value");
        new StringAssertion("", new FailDescription()).isLessThanOrEqualTo("");

        try {
            new StringAssertion(null, new FailDescription()).isLessThanOrEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanOrEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanOrEqualTo("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanOrEqualTo("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanOrEqualTo("c");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToIgnoreCaseTest() {
        new StringAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("yyy");
        new StringAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("vam");
        new StringAssertion("vAlue", new FailDescription()).isLessThanOrEqualToIgnoreCase("vam");
        new StringAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("valuezzz");
        new StringAssertion("vAlUe", new FailDescription()).isLessThanOrEqualToIgnoreCase("valuezzz");
        new StringAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("value");
        new StringAssertion("VALUE", new FailDescription()).isLessThanOrEqualToIgnoreCase("value");
        new StringAssertion("", new FailDescription()).isLessThanOrEqualToIgnoreCase("");

        try {
            new StringAssertion(null, new FailDescription()).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>.");
        }
        try {
            new StringAssertion("XYZ", new FailDescription()).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<value> but was:<XYZ>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("c");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new StringAssertion("value", new FailDescription()).isInRange("v", "valuex");
        new StringAssertion("value", new FailDescription()).isInRange("a", "z");
        new StringAssertion("value", new FailDescription()).isInRange("A", "z");
        new StringAssertion("value", new FailDescription()).isInRange("value", "z");
        new StringAssertion("value", new FailDescription()).isInRange("VALUE", "z");
        new StringAssertion("value", new FailDescription()).isInRange("", "z");
        new StringAssertion("", new FailDescription()).isInRange("", "z");

        try {
            new StringAssertion(null, new FailDescription()).isInRange("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRange(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRange("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRange("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRange("A", "Z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:Z> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRange("a", "test");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRange("A", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRange("A", "vaLUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRange("xxx", "yyy");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<xxx:yyy> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isInRangeIgnoreCaseTest() {
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("v", "valuex");
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("a", "z");
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("a", "Z");
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("A", "z");
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("A", "Z");
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("value", "z");
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("value", "Z");
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("VALUE", "z");
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("VALUE", "Z");
        new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("", "Z");
        new StringAssertion("", new FailDescription()).isInRangeIgnoreCase("", "Z");

        try {
            new StringAssertion(null, new FailDescription()).isInRangeIgnoreCase("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("a", "test");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("A", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("A", "vaLUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("xxx", "yyy");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<xxx:yyy> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isInRangeIgnoreCase("XXX", "YYY");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<XXX:YYY> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new StringAssertion("value", new FailDescription()).isNotInRange("A", "Z");
        new StringAssertion("value", new FailDescription()).isNotInRange("a", "test");
        new StringAssertion("value", new FailDescription()).isNotInRange("A", "value");
        new StringAssertion("value", new FailDescription()).isNotInRange("A", "vaLUE");
        new StringAssertion("value", new FailDescription()).isNotInRange("VALUE", "Z");
        new StringAssertion("value", new FailDescription()).isNotInRange("xxx", "yyy");
        new StringAssertion("value", new FailDescription()).isNotInRange("XXX", "YYY");
        new StringAssertion("value", new FailDescription()).isNotInRange("", "aaa");

        try {
            new StringAssertion(null, new FailDescription()).isNotInRange("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRange(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRange("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRange("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRange("v", "valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRange("a", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRange("A", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRange("value", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRange("VALUE", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotInRangeIgnoreCaseTest() {
        new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("a", "test");
        new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("A", "value");
        new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("A", "vaLUE");
        new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("xxx", "yyy");
        new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("XXX", "YYY");
        new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("", "AAA");

        try {
            new StringAssertion(null, new FailDescription()).isNotInRangeIgnoreCase("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("A", "Z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:Z> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("v", "valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("a", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("A", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("value", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("VALUE", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("VALUE", "Z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:Z> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void containsTest() {
        new StringAssertion("value", new FailDescription()).contains("val");
        new StringAssertion("value", new FailDescription()).contains("alu");
        new StringAssertion("value", new FailDescription()).contains("lue");
        new StringAssertion("значение", new FailDescription()).contains("знач");
        new StringAssertion("значение", new FailDescription()).contains("ен");
        new StringAssertion("значение", new FailDescription()).contains("ие");

        try {
            new StringAssertion(null, new FailDescription()).contains("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).contains(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).contains("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", new FailDescription()).contains("VAL");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAL> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).contains("v.*ue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).contains("знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<знач> but was:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).contains("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<value> but was:<значение>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).contains("\\w+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<\\w+> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).contains(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<.+> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void containsIgnoreCaseTest() {
        new StringAssertion("value", new FailDescription()).containsIgnoreCase("VAL");
        new StringAssertion("VAlUE", new FailDescription()).containsIgnoreCase("aLu");
        new StringAssertion("VAlue", new FailDescription()).containsIgnoreCase("luE");
        new StringAssertion("значение", new FailDescription()).containsIgnoreCase("ЗНАЧ");
        new StringAssertion("ЗНАчЕнИЕ", new FailDescription()).containsIgnoreCase("еН");
        new StringAssertion("ЗНАЧЕние", new FailDescription()).containsIgnoreCase("Ие");

        try {
            new StringAssertion(null, new FailDescription()).containsIgnoreCase("VAlue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("VAlue", new FailDescription()).containsIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("VAlue", new FailDescription()).containsIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", new FailDescription()).containsIgnoreCase("VAE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAE> but was:<value>.");
        }
        try {
            new StringAssertion("vaLUe", new FailDescription()).containsIgnoreCase("v.*ue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<vaLUe>.");
        }
        try {
            new StringAssertion("vaLue", new FailDescription()).containsIgnoreCase("зНАч");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<зНАч> but was:<vaLue>.");
        }
        try {
            new StringAssertion("знАЧЕние", new FailDescription()).containsIgnoreCase("valUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<valUE> but was:<знАЧЕние>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).containsIgnoreCase("\\w+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<\\w+> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).containsIgnoreCase(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<.+> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new StringAssertion("value", new FailDescription()).doesNotContain("vaue");
        new StringAssertion("value", new FailDescription()).doesNotContain("VAL");
        new StringAssertion("value", new FailDescription()).doesNotContain("UE");
        new StringAssertion("значение", new FailDescription()).doesNotContain("ЗНАЧ");
        new StringAssertion("значение", new FailDescription()).doesNotContain("кени");
        new StringAssertion("значение", new FailDescription()).doesNotContain("НИЕ");

        try {
            new StringAssertion(null, new FailDescription()).doesNotContain("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotContain(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotContain("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotContain("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotContain("alu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<alu> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotContain("lue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lue> but was:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).doesNotContain("знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<значение>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).doesNotContain("ение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<ение> but was:<значение>.");
        }
        try {
            new StringAssertion("...", new FailDescription()).doesNotContain(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<.> but was:<...>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotContainIgnoreCaseTest() {
        new StringAssertion("value", new FailDescription()).doesNotContainIgnoreCase("vaUE");
        new StringAssertion("valUE", new FailDescription()).doesNotContainIgnoreCase("1VAL");
        new StringAssertion("valUE", new FailDescription()).doesNotContainIgnoreCase("UE1");
        new StringAssertion("знАчеНие", new FailDescription()).doesNotContainIgnoreCase("ЗНАН");
        new StringAssertion("знАчеНие", new FailDescription()).doesNotContainIgnoreCase("кени");
        new StringAssertion("знАчеНие", new FailDescription()).doesNotContainIgnoreCase("чИЕ");

        try {
            new StringAssertion(null, new FailDescription()).doesNotContainIgnoreCase("valUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("valUE", new FailDescription()).doesNotContainIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("valUE", new FailDescription()).doesNotContainIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("vaLUe", new FailDescription()).doesNotContainIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<vaLUe>.");
        }
        try {
            new StringAssertion("vaLUe", new FailDescription()).doesNotContainIgnoreCase("VAL");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<VAL> but was:<vaLUe>.");
        }
        try {
            new StringAssertion("vaLUe", new FailDescription()).doesNotContainIgnoreCase("lUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lUE> but was:<vaLUe>.");
        }
        try {
            new StringAssertion("зНАчеНИе", new FailDescription()).doesNotContainIgnoreCase("знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<зНАчеНИе>.");
        }
        try {
            new StringAssertion("зНАчеНИе", new FailDescription()).doesNotContainIgnoreCase("еНИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<еНИе> but was:<зНАчеНИе>.");
        }
        try {
            new StringAssertion("...", new FailDescription()).doesNotContainIgnoreCase(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<.> but was:<...>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isPartOfTest() {
        new StringAssertion("val", new FailDescription()).isPartOf("value");
        new StringAssertion("alu", new FailDescription()).isPartOf("value");
        new StringAssertion("lue", new FailDescription()).isPartOf("value");
        new StringAssertion("знач", new FailDescription()).isPartOf("значение");
        new StringAssertion("ен", new FailDescription()).isPartOf("значение");
        new StringAssertion("ие", new FailDescription()).isPartOf("значение");
        new StringAssertion("", new FailDescription()).isPartOf("");

        try {
            new StringAssertion(null, new FailDescription()).isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isPartOf(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isPartOf("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<value>.");
        }
        try {
            new StringAssertion("VAL", new FailDescription()).isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<VAL>.");
        }
        try {
            new StringAssertion("vue", new FailDescription()).isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<vue>.");
        }
        try {
            new StringAssertion("ЗнАЧ", new FailDescription()).isPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<ЗнАЧ>.");
        }
        try {
            new StringAssertion("чача", new FailDescription()).isPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<чача>.");
        }
        try {
            new StringAssertion("\\w+", new FailDescription()).isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<\\w+>.");
        }
        try {
            new StringAssertion(".+", new FailDescription()).isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<.+>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isPartOfIgnoreCaseTest() {
        new StringAssertion("vAl", new FailDescription()).isPartOfIgnoreCase("vaLUe");
        new StringAssertion("Alu", new FailDescription()).isPartOfIgnoreCase("vaLUe");
        new StringAssertion("luE", new FailDescription()).isPartOfIgnoreCase("vaLUe");
        new StringAssertion("знАЧ", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
        new StringAssertion("Ен", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
        new StringAssertion("иЕ", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
        new StringAssertion("", new FailDescription()).isPartOfIgnoreCase("");

        try {
            new StringAssertion(null, new FailDescription()).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vaLUe", new FailDescription()).isPartOfIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vaLUe", new FailDescription()).isPartOfIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<vaLUe>.");
        }
        try {
            new StringAssertion("VAe", new FailDescription()).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<VAe>.");
        }
        try {
            new StringAssertion("vUe", new FailDescription()).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<vUe>.");
        }
        try {
            new StringAssertion("ЗАЧ", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<ЗАЧ>.");
        }
        try {
            new StringAssertion("чача", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<чача>.");
        }
        try {
            new StringAssertion("\\w+", new FailDescription()).isPartOfIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<\\w+>.");
        }
        try {
            new StringAssertion(".+", new FailDescription()).isPartOfIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<.+>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotPartOfTest() {
        new StringAssertion("vae", new FailDescription()).isNotPartOf("value");
        new StringAssertion("aLu", new FailDescription()).isNotPartOf("value");
        new StringAssertion("vue", new FailDescription()).isNotPartOf("value");
        new StringAssertion("знаач", new FailDescription()).isNotPartOf("значение");
        new StringAssertion("еНИ", new FailDescription()).isNotPartOf("значение");
        new StringAssertion("чие", new FailDescription()).isNotPartOf("значение");
        new StringAssertion("чие", new FailDescription()).isNotPartOf("");

        try {
            new StringAssertion(null, new FailDescription()).isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).isNotPartOf(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", new FailDescription()).isNotPartOf("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>.");
        }
        try {
            new StringAssertion("val", new FailDescription()).isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<val>.");
        }
        try {
            new StringAssertion("lue", new FailDescription()).isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<lue>.");
        }
        try {
            new StringAssertion("знач", new FailDescription()).isNotPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<знач>.");
        }
        try {
            new StringAssertion("ение", new FailDescription()).isNotPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<ение>.");
        }
        try {
            new StringAssertion(".", new FailDescription()).isNotPartOf("...");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<...> but was:<.>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotPartOfIgnoreCaseTest() {
        new StringAssertion("vAe", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
        new StringAssertion("aLe", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
        new StringAssertion("vuE", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
        new StringAssertion("знААч", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
        new StringAssertion("еНе", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
        new StringAssertion("чИЕ", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
        new StringAssertion("чИЕ", new FailDescription()).isNotPartOfIgnoreCase("");

        try {
            new StringAssertion(null, new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vaLUe", new FailDescription()).isNotPartOfIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", new FailDescription()).isNotPartOfIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>.");
        }
        try {
            new StringAssertion("VAL", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<VAL>.");
        }
        try {
            new StringAssertion("LuE", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<LuE>.");
        }
        try {
            new StringAssertion("зНАч", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<зНАч>.");
        }
        try {
            new StringAssertion("ЕниЕ", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<ЕниЕ>.");
        }
        try {
            new StringAssertion(".", new FailDescription()).isNotPartOfIgnoreCase("...");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<...> but was:<.>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void matchesTest() {
        new StringAssertion("value", new FailDescription()).matches("v.*e");
        new StringAssertion("value", new FailDescription()).matches("v[aA].{2}[eE]");
        new StringAssertion("value", new FailDescription()).matches("\\w+");
        new StringAssertion("value", new FailDescription()).matches("\\w{4,6}");
        new StringAssertion("значение", new FailDescription()).matches("\\p{L}+");
        new StringAssertion("", new FailDescription()).matches("");

        try {
            new StringAssertion(null, new FailDescription()).matches("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).matches(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).matches("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).matches("\\d+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\d+> but was:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).matches("\\w+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\w+> but was:<значение>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotMatchTest() {
        new StringAssertion("value", new FailDescription()).doesNotMatch("valu.+e");
        new StringAssertion("value", new FailDescription()).doesNotMatch("v[zZ].{2}[eE]");
        new StringAssertion("value", new FailDescription()).doesNotMatch("\\s\\w+");
        new StringAssertion("value", new FailDescription()).doesNotMatch("\\w{8}");
        new StringAssertion("значение", new FailDescription()).doesNotMatch("\\w+");
        new StringAssertion("значение", new FailDescription()).doesNotMatch("");

        try {
            new StringAssertion(null, new FailDescription()).doesNotMatch("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotMatch(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("", new FailDescription()).doesNotMatch("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<> but was:<>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotMatch("\\w+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\w+> but was:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).doesNotMatch("\\p{L}{8}");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\p{L}{8}> but was:<значение>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void startsWithTest() {
        new StringAssertion("value", new FailDescription()).startsWith("va");
        new StringAssertion("value", new FailDescription()).startsWith("val");
        new StringAssertion("value", new FailDescription()).startsWith("value");
        new StringAssertion("значение", new FailDescription()).startsWith("зна");
        new StringAssertion("значение", new FailDescription()).startsWith("значе");
        new StringAssertion("значение", new FailDescription()).startsWith("значение");

        try {
            new StringAssertion(null, new FailDescription()).startsWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).startsWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).startsWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", new FailDescription()).startsWith("lue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lue> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).startsWith("Val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Val> but was:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).startsWith("ачен");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<ачен> but was:<значение>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).startsWith("Знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Знач> but was:<значение>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).startsWith("va?");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<va?> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).startsWith(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<.+> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void startsWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("vA");
        new StringAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("VAl");
        new StringAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("vaLUe");
        new StringAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("зНа");
        new StringAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("зНаче");
        new StringAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("зНачение");

        try {
            new StringAssertion(null, new FailDescription()).startsWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("lUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lUe> but was:<vAlUe>.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("Vau");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Vau> but was:<vAlUe>.");
        }
        try {
            new StringAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("аЧен");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<аЧен> but was:<знАчЕнИе>.");
        }
        try {
            new StringAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("Значи");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Значи> but was:<знАчЕнИе>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).startsWithIgnoreCase("va?");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<va?> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).startsWithIgnoreCase(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<.+> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotStartWithTest() {
        new StringAssertion("value", new FailDescription()).doesNotStartWith("VA");
        new StringAssertion("value", new FailDescription()).doesNotStartWith("VaL");
        new StringAssertion("value", new FailDescription()).doesNotStartWith("vale");
        new StringAssertion("значение", new FailDescription()).doesNotStartWith("ЗНА");
        new StringAssertion("значение", new FailDescription()).doesNotStartWith("Знач");
        new StringAssertion("значение", new FailDescription()).doesNotStartWith("чение");

        try {
            new StringAssertion(null, new FailDescription()).doesNotStartWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotStartWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotStartWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotStartWith("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotStartWith("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<valu> but was:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).doesNotStartWith("зн");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<значение>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).doesNotStartWith("значен");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значен> but was:<значение>.");
        }
        try {
            new StringAssertion("...", new FailDescription()).doesNotStartWith(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<.> but was:<...>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotStartWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("Vu");
        new StringAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("Vue");
        new StringAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("ale");
        new StringAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("НА");
        new StringAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("Знч");
        new StringAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("чние");

        try {
            new StringAssertion(null, new FailDescription()).doesNotStartWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<vAlUe>.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("VALUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<VALUe> but was:<vAlUe>.");
        }
        try {
            new StringAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("зн");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<знАчЕнИе>.");
        }
        try {
            new StringAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значение> but was:<знАчЕнИе>.");
        }
        try {
            new StringAssertion("...", new FailDescription()).doesNotStartWithIgnoreCase(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<.> but was:<...>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void endsWithTest() {
        new StringAssertion("value", new FailDescription()).endsWith("alue");
        new StringAssertion("value", new FailDescription()).endsWith("lue");
        new StringAssertion("value", new FailDescription()).endsWith("ue");
        new StringAssertion("значение", new FailDescription()).endsWith("ачение");
        new StringAssertion("значение", new FailDescription()).endsWith("ние");
        new StringAssertion("значение", new FailDescription()).endsWith("е");

        try {
            new StringAssertion(null, new FailDescription()).endsWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).endsWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).endsWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("value", new FailDescription()).endsWith("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).endsWith("LuE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<LuE> but was:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).endsWith("значе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<значе> but was:<значение>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).endsWith("ЧенИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ЧенИе> but was:<значение>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).endsWith("ue?");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ue?> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).endsWith(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<.+> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void endsWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("vaLue");
        new StringAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("Lue");
        new StringAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("E");
        new StringAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("значеНИЕ");
        new StringAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("чеНИЕ");
        new StringAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("Е");
        new StringAssertion("aaaxxxxx", new FailDescription()).endsWithIgnoreCase("xxx");

        try {
            new StringAssertion(null, new FailDescription()).endsWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<vAlUe>.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("vUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<vUe> but was:<vAlUe>.");
        }
        try {
            new StringAssertion("", new FailDescription()).endsWithIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<>.");
        }
        try {
            new StringAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("знАчЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАчЕ> but was:<знАчЕнИе>.");
        }
        try {
            new StringAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("знАИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАИе> but was:<знАчЕнИе>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).endsWithIgnoreCase("ue?");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ue?> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).endsWithIgnoreCase(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<.+> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotEndWithTest() {
        new StringAssertion("value", new FailDescription()).doesNotEndWith("aLue");
        new StringAssertion("value", new FailDescription()).doesNotEndWith("vue");
        new StringAssertion("value", new FailDescription()).doesNotEndWith("val");
        new StringAssertion("значение", new FailDescription()).doesNotEndWith("ачЕниЕ");
        new StringAssertion("значение", new FailDescription()).doesNotEndWith("зние");
        new StringAssertion("значение", new FailDescription()).doesNotEndWith("зна");

        try {
            new StringAssertion(null, new FailDescription()).doesNotEndWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotEndWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotEndWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotEndWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<value> but was:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription()).doesNotEndWith("alue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<alue> but was:<value>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).doesNotEndWith("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<значение> but was:<значение>.");
        }
        try {
            new StringAssertion("значение", new FailDescription()).doesNotEndWith("ие");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<ие> but was:<значение>.");
        }
        try {
            new StringAssertion("...", new FailDescription()).doesNotEndWith(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<.> but was:<...>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotEndWithIgnoreCaseTest() {
        new StringAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("aLe");
        new StringAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("vue");
        new StringAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("val");
        new StringAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("зачЕниЕ");
        new StringAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("зние");
        new StringAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("зна");
        new StringAssertion("", new FailDescription()).doesNotEndWithIgnoreCase("val");

        try {
            new StringAssertion(null, new FailDescription()).doesNotEndWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("vaLue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<vaLue> but was:<vAlUe>.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("aLue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<aLue> but was:<vAlUe>.");
        }
        try {
            new StringAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("знАчение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<знАчение> but was:<знАчЕнИе>.");
        }
        try {
            new StringAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("е");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<е> but was:<знАчЕнИе>.");
        }
        try {
            new StringAssertion("aaaxxxxx", new FailDescription()).doesNotEndWithIgnoreCase("xxx");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<xxx> but was:<aaaxxxxx>.");
        }
        try {
            new StringAssertion("...", new FailDescription()).doesNotEndWithIgnoreCase(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<.> but was:<...>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new StringAssertion("vAlUe", new FailDescription()).toLength().isEqualTo(5);
        new StringAssertion("vAlUe", new FailDescription()).toLength().isGreaterThan(3);
        new StringAssertion("vAlUe", new FailDescription()).toLength().isLessThan(7);

        new StringAssertion("знАчЕнИе", new FailDescription()).toLength().isEqualTo(8);
        new StringAssertion("знАчЕнИе", new FailDescription()).toLength().isGreaterThan(5);
        new StringAssertion("знАчЕнИе", new FailDescription()).toLength().isLessThan(10);

        try {
            new StringAssertion(null, new FailDescription()).toLength();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription("Message")).toLength();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription()).toLength().isEqualTo(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription("Message")).toLength().isEqualTo(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value length. Values should be the same. Expected:<6> but was:<5>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new StringAssertion("vAlUe", new FailDescription()).hasLength(5);
        new StringAssertion("знАчЕнИе", new FailDescription()).hasLength(8);

        try {
            new StringAssertion("vAlUe", new FailDescription()).hasLength(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            new StringAssertion("vAlUe", new FailDescription("Message")).hasLength(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value length. Values should be the same. Expected:<6> but was:<5>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void toTokensTest() {
        new StringAssertion("value1 value2 value3", new FailDescription()).toTokens().containsAll("value1", "value2", "value3");
        new StringAssertion("value1|value2|value3", new FailDescription()).toTokens().containsAll("value1|value2|value3");
        new StringAssertion("value1|value2|value3", new FailDescription()).toTokens("|").containsAll("value1", "value2", "value3");
        new StringAssertion("value1|value2|value3", new FailDescription()).toTokens("|", false).containsAll("value1", "value2", "value3");
        new StringAssertion("value1|value2|value3", new FailDescription()).toTokens("|", true).containsAll("value1", "value2", "value3", "|", "|");

        try {
            new StringAssertion(null, new FailDescription()).toTokens();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription("Message")).toTokens();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription()).toTokens("|");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription("Message")).toTokens("|");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new StringAssertion("value1|value2|value3", new FailDescription()).toTokens(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value1|value2|value3", new FailDescription("Message")).toTokens(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription()).toTokens("|", false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new StringAssertion(null, new FailDescription("Message")).toTokens("|", false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new StringAssertion("value1|value2|value3", new FailDescription()).toTokens(null, false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new StringAssertion("value1|value2|value3", new FailDescription("Message")).toTokens(null, false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            new StringAssertion("value1 value2 value3", new FailDescription()).toTokens().hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new StringAssertion("value1 value2 value3", new FailDescription("Message")).toTokens().hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new StringAssertion("value1|value2|value3", new FailDescription()).toTokens("|").hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new StringAssertion("value1|value2|value3", new FailDescription("Message")).toTokens("|").hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new StringAssertion("value1|value2|value3", new FailDescription()).toTokens("|", true).hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<5>.");
        }
        try {
            new StringAssertion("value1|value2|value3", new FailDescription("Message")).toTokens("|", true).hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<5>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new StringAssertion(null, new FailDescription()).isNull();

        try {
            new StringAssertion("value", new FailDescription()).isNull();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<value>.");
        }
        try {
            new StringAssertion("value", new FailDescription("Message")).isNull();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        String value = "value";
        new StringAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new StringAssertion(value, new FailDescription()).isSameAs("va" + new StringBuilder("lue"));
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value> but was:<value>.");
        }
        try {
            new StringAssertion(value, new FailDescription("Message")).isSameAs("va" + new StringBuilder("lue"));
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<value> but was:<value>.");
        }
        try {
            new StringAssertion(value, new FailDescription()).isSameAs(new StringBuilder("value"));
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value> but was:<value>.");
        }
        try {
            new StringAssertion(value, new FailDescription("Message")).isSameAs(new StringBuilder("value"));
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<value> but was:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        String value = "value";
        new StringAssertion(value, new FailDescription()).isNotSameAs("va" + new StringBuilder("lue"));
        new StringAssertion(value, new FailDescription()).isNotSameAs(new StringBuilder("value"));

        try {
            new StringAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
        try {
            new StringAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<value>.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(new StringAssertion("vAlUe", new FailDescription()).asString(null));
            Assertions.fail("StringAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(new StringAssertion("vAlUe", new FailDescription()).asString("vAlUe")).isEqualTo("vAlUe");
        Assertions.assertThat(new StringAssertion("vAlUe", new FailDescription()).asString("знАчЕнИе")).isEqualTo("знАчЕнИе");
        Assertions.assertThat(new StringAssertion("vAlUe", new FailDescription()).asString(1)).isEqualTo("1");
    }

}
