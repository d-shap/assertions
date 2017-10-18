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
        new CharSequenceAssertion("", new FailDescription()).isEmpty();

        try {
            new CharSequenceAssertion(null, new FailDescription()).isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion(" ", new FailDescription()).isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:< >.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new CharSequenceAssertion(null, new FailDescription()).isNullOrEmpty();
        new CharSequenceAssertion("", new FailDescription()).isNullOrEmpty();

        try {
            new CharSequenceAssertion(" ", new FailDescription()).isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:< >.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new CharSequenceAssertion(" ", new FailDescription()).isNotEmpty();
        new CharSequenceAssertion("value", new FailDescription()).isNotEmpty();

        try {
            new CharSequenceAssertion(null, new FailDescription()).isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("", new FailDescription()).isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new CharSequenceAssertion("", new FailDescription("Message")).isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isBlankTest() {
        new CharSequenceAssertion("", new FailDescription()).isBlank();
        new CharSequenceAssertion(" ", new FailDescription()).isBlank();
        new CharSequenceAssertion("\t", new FailDescription()).isBlank();
        new CharSequenceAssertion("   \t   \t", new FailDescription()).isBlank();

        try {
            new CharSequenceAssertion(null, new FailDescription()).isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<value>.");
        }
        try {
            new CharSequenceAssertion("v   ", new FailDescription()).isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<v   >.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be blank. Actual:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNullOrBlankTest() {
        new CharSequenceAssertion(null, new FailDescription()).isNullOrBlank();
        new CharSequenceAssertion("", new FailDescription()).isNullOrBlank();
        new CharSequenceAssertion(" ", new FailDescription()).isNullOrBlank();
        new CharSequenceAssertion("\t", new FailDescription()).isNullOrBlank();
        new CharSequenceAssertion("   \t   \t", new FailDescription()).isNullOrBlank();

        try {
            new CharSequenceAssertion("value", new FailDescription()).isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<value>.");
        }
        try {
            new CharSequenceAssertion("v   ", new FailDescription()).isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<v   >.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or blank. Actual:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotBlankTest() {
        new CharSequenceAssertion("value", new FailDescription()).isNotBlank();

        try {
            new CharSequenceAssertion(null, new FailDescription()).isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("", new FailDescription()).isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new CharSequenceAssertion(" ", new FailDescription()).isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new CharSequenceAssertion("\t", new FailDescription()).isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new CharSequenceAssertion("   \t   \t", new FailDescription()).isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            new CharSequenceAssertion("   \t   \t", new FailDescription("Message")).isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new CharSequenceAssertion("value", new FailDescription()).isEqualTo("value");
        new CharSequenceAssertion("ЗНАЧЕНИЕ", new FailDescription()).isEqualTo("ЗНАЧЕНИЕ");
        new CharSequenceAssertion("значение", new FailDescription()).isEqualTo("значение");
        new CharSequenceAssertion("", new FailDescription()).isEqualTo("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isEqualTo("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value1", new FailDescription()).isEqualTo("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>.");
        }
        try {
            new CharSequenceAssertion("value1", new FailDescription()).isEqualTo("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualToIgnoreCase("Values should be the same. Expected:<value2> but was:<value1>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("ЗНАЧЕНИЕ", new FailDescription()).isEqualTo("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<ЗНАЧЕНИЕ>.");
        }
        try {
            new CharSequenceAssertion("ЗНАЧЕНИЕ", new FailDescription("Message")).isEqualTo("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<значение> but was:<ЗНАЧЕНИЕ>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEqualToIgnoreCaseTest() {
        new CharSequenceAssertion("valUe", new FailDescription()).isEqualToIgnoreCase("vALue");
        new CharSequenceAssertion("ЗНАЧЕНИЕ", new FailDescription()).isEqualToIgnoreCase("значение");
        new CharSequenceAssertion("значение", new FailDescription()).isEqualToIgnoreCase("ЗНАЧЕНИЕ");
        new CharSequenceAssertion("", new FailDescription()).isEqualToIgnoreCase("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isEqualToIgnoreCase("vALue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vALue", new FailDescription()).isEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vALue", new FailDescription()).isEqualToIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<vALue>.");
        }
        try {
            new CharSequenceAssertion("value1", new FailDescription()).isEqualToIgnoreCase("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isEqualToIgnoreCase("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isEqualToIgnoreCase("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("ЗнаЧеНИЕ", new FailDescription()).isEqualToIgnoreCase("vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<vaLUE> but was:<ЗнаЧеНИЕ>.");
        }
        try {
            new CharSequenceAssertion("ЗнаЧеНИЕ", new FailDescription("Message")).isEqualToIgnoreCase("vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<vaLUE> but was:<ЗнаЧеНИЕ>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new CharSequenceAssertion("value", new FailDescription()).isNotEqualTo("значение");
        new CharSequenceAssertion("value", new FailDescription()).isNotEqualTo("ЗНАЧЕНИЕ");
        new CharSequenceAssertion("значение", new FailDescription()).isNotEqualTo("value");
        new CharSequenceAssertion("ЗНАЧЕНИЕ", new FailDescription()).isNotEqualTo("value");
        new CharSequenceAssertion("ЗНАЧЕНИЕ", new FailDescription()).isNotEqualTo("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isNotEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("", new FailDescription()).isNotEqualTo("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).isNotEqualTo("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<значение>.");
        }
        try {
            new CharSequenceAssertion("ЗНАЧЕНИЕ", new FailDescription()).isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНАЧЕНИЕ>.");
        }
        try {
            new CharSequenceAssertion("ЗНАЧЕНИЕ", new FailDescription("Message")).isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<ЗНАЧЕНИЕ>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEqualToIgnoreCaseTest() {
        new CharSequenceAssertion("vaLUe", new FailDescription()).isNotEqualToIgnoreCase("знАЧенИЕ");
        new CharSequenceAssertion("VAluE", new FailDescription()).isNotEqualToIgnoreCase("ЗНачЕНие");
        new CharSequenceAssertion("знАЧенИЕ", new FailDescription()).isNotEqualToIgnoreCase("vaLUe");
        new CharSequenceAssertion("ЗНачЕНие", new FailDescription()).isNotEqualToIgnoreCase("VAluE");
        new CharSequenceAssertion("ЗНачЕНие", new FailDescription()).isNotEqualToIgnoreCase("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isNotEqualToIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vaLUe", new FailDescription()).isNotEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("", new FailDescription()).isNotEqualToIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
        try {
            new CharSequenceAssertion("знАЧенИЕ", new FailDescription()).isNotEqualToIgnoreCase("ЗНачЕНие");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<знАЧенИЕ>.");
        }
        try {
            new CharSequenceAssertion("ЗНачЕНие", new FailDescription()).isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНачЕНие>.");
        }
        try {
            new CharSequenceAssertion("ЗНачЕНие", new FailDescription("Message")).isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<ЗНачЕНие>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThan("aaa");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThan("vai");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThan("valuazzz");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThan("VALUE");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThan("XYZ");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isGreaterThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThan("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThan("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isGreaterThan("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<x> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanIgnoreCaseTest() {
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("aaa");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("vai");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("vAi");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("valuazzz");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("vAlUazzz");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isGreaterThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("VALUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<VALUE> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("XYZ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<XYZ> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isGreaterThanIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<x> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("aaa");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("vai");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("valuazzz");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("VALUE");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("XYZ");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("value");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("");
        new CharSequenceAssertion("", new FailDescription()).isGreaterThanOrEqualTo("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isGreaterThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualTo("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isGreaterThanOrEqualTo("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<x> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToIgnoreCaseTest() {
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("aaa");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("vai");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("vAi");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("valuazzz");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("vAlUazzz");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("value");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("VALUE");
        new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("");
        new CharSequenceAssertion("", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isGreaterThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("XYZ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<XYZ> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isGreaterThanOrEqualToIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isGreaterThanOrEqualToIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<x> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new CharSequenceAssertion("value", new FailDescription()).isLessThan("yyy");
        new CharSequenceAssertion("value", new FailDescription()).isLessThan("vam");
        new CharSequenceAssertion("value", new FailDescription()).isLessThan("valuezzz");
        new CharSequenceAssertion("VALUE", new FailDescription()).isLessThan("value");
        new CharSequenceAssertion("XYZ", new FailDescription()).isLessThan("value");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isLessThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThan("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThan("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isLessThan("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<c> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanIgnoreCaseTest() {
        new CharSequenceAssertion("value", new FailDescription()).isLessThanIgnoreCase("yyy");
        new CharSequenceAssertion("value", new FailDescription()).isLessThanIgnoreCase("vam");
        new CharSequenceAssertion("vAlue", new FailDescription()).isLessThanIgnoreCase("vam");
        new CharSequenceAssertion("value", new FailDescription()).isLessThanIgnoreCase("valuezzz");
        new CharSequenceAssertion("vAlUe", new FailDescription()).isLessThanIgnoreCase("valuezzz");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("VALUE", new FailDescription()).isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<VALUE>.");
        }
        try {
            new CharSequenceAssertion("XYZ", new FailDescription()).isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<XYZ>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanIgnoreCase("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isLessThanIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<c> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualTo("yyy");
        new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualTo("vam");
        new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualTo("valuezzz");
        new CharSequenceAssertion("VALUE", new FailDescription()).isLessThanOrEqualTo("value");
        new CharSequenceAssertion("XYZ", new FailDescription()).isLessThanOrEqualTo("value");
        new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualTo("value");
        new CharSequenceAssertion("", new FailDescription()).isLessThanOrEqualTo("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isLessThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualTo("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualTo("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualTo("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isLessThanOrEqualTo("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<c> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToIgnoreCaseTest() {
        new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("yyy");
        new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("vam");
        new CharSequenceAssertion("vAlue", new FailDescription()).isLessThanOrEqualToIgnoreCase("vam");
        new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("valuezzz");
        new CharSequenceAssertion("vAlUe", new FailDescription()).isLessThanOrEqualToIgnoreCase("valuezzz");
        new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("value");
        new CharSequenceAssertion("VALUE", new FailDescription()).isLessThanOrEqualToIgnoreCase("value");
        new CharSequenceAssertion("", new FailDescription()).isLessThanOrEqualToIgnoreCase("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("XYZ", new FailDescription()).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<value> but was:<XYZ>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isLessThanOrEqualToIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isLessThanOrEqualToIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<c> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new CharSequenceAssertion("value", new FailDescription()).isInRange("v", "valuex");
        new CharSequenceAssertion("value", new FailDescription()).isInRange("a", "z");
        new CharSequenceAssertion("value", new FailDescription()).isInRange("A", "z");
        new CharSequenceAssertion("value", new FailDescription()).isInRange("value", "z");
        new CharSequenceAssertion("value", new FailDescription()).isInRange("VALUE", "z");
        new CharSequenceAssertion("value", new FailDescription()).isInRange("", "z");
        new CharSequenceAssertion("", new FailDescription()).isInRange("", "z");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRange("A", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:Z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRange("a", "test");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRange("A", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRange("A", "vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRange("xxx", "yyy");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<xxx:yyy> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isInRange("xxx", "yyy");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<xxx:yyy> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isInRangeIgnoreCaseTest() {
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("v", "valuex");
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("a", "z");
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("a", "Z");
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("A", "z");
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("A", "Z");
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("value", "z");
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("value", "Z");
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("VALUE", "z");
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("VALUE", "Z");
        new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("", "Z");
        new CharSequenceAssertion("", new FailDescription()).isInRangeIgnoreCase("", "Z");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("a", "test");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("A", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("A", "vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("xxx", "yyy");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<xxx:yyy> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isInRangeIgnoreCase("XXX", "YYY");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<XXX:YYY> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isInRangeIgnoreCase("XXX", "YYY");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<XXX:YYY> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new CharSequenceAssertion("value", new FailDescription()).isNotInRange("A", "Z");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRange("a", "test");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRange("A", "value");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRange("A", "vaLUE");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRange("VALUE", "Z");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRange("xxx", "yyy");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRange("XXX", "YYY");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRange("", "aaa");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isNotInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRange("v", "valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRange("a", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRange("A", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRange("value", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRange("VALUE", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isNotInRange("VALUE", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<VALUE:z> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotInRangeIgnoreCaseTest() {
        new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("a", "test");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("A", "value");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("A", "vaLUE");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("xxx", "yyy");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("XXX", "YYY");
        new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("", "AAA");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isNotInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("A", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:Z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("v", "valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("a", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("A", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("value", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("VALUE", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotInRangeIgnoreCase("VALUE", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:Z> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription("Message")).isNotInRangeIgnoreCase("VALUE", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<VALUE:Z> but was:<value>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void containsTest() {
        new CharSequenceAssertion("value", new FailDescription()).contains("val");
        new CharSequenceAssertion("value", new FailDescription()).contains("alu");
        new CharSequenceAssertion("value", new FailDescription()).contains("lue");
        new CharSequenceAssertion("значение", new FailDescription()).contains("знач");
        new CharSequenceAssertion("значение", new FailDescription()).contains("ен");
        new CharSequenceAssertion("значение", new FailDescription()).contains("ие");

        try {
            new CharSequenceAssertion(null, new FailDescription()).contains("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).contains(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).contains("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).contains("VAL");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAL> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).contains("v.*ue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).contains("знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<знач> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).contains("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<value> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription("Message")).contains("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<value> but was:<значение>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void containsIgnoreCaseTest() {
        new CharSequenceAssertion("value", new FailDescription()).containsIgnoreCase("VAL");
        new CharSequenceAssertion("VAlUE", new FailDescription()).containsIgnoreCase("aLu");
        new CharSequenceAssertion("VAlue", new FailDescription()).containsIgnoreCase("luE");
        new CharSequenceAssertion("значение", new FailDescription()).containsIgnoreCase("ЗНАЧ");
        new CharSequenceAssertion("ЗНАчЕнИЕ", new FailDescription()).containsIgnoreCase("еН");
        new CharSequenceAssertion("ЗНАЧЕние", new FailDescription()).containsIgnoreCase("Ие");

        try {
            new CharSequenceAssertion(null, new FailDescription()).containsIgnoreCase("VAlue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("VAlue", new FailDescription()).containsIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("VAlue", new FailDescription()).containsIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).containsIgnoreCase("VAE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAE> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("vaLUe", new FailDescription()).containsIgnoreCase("v.*ue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<vaLUe>.");
        }
        try {
            new CharSequenceAssertion("vaLue", new FailDescription()).containsIgnoreCase("зНАч");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<зНАч> but was:<vaLue>.");
        }
        try {
            new CharSequenceAssertion("знАЧЕние", new FailDescription()).containsIgnoreCase("valUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<valUE> but was:<знАЧЕние>.");
        }
        try {
            new CharSequenceAssertion("знАЧЕние", new FailDescription("Message")).containsIgnoreCase("valUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<valUE> but was:<знАЧЕние>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new CharSequenceAssertion("value", new FailDescription()).doesNotContain("vaue");
        new CharSequenceAssertion("value", new FailDescription()).doesNotContain("VAL");
        new CharSequenceAssertion("value", new FailDescription()).doesNotContain("UE");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotContain("ЗНАЧ");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotContain("кени");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotContain("НИЕ");

        try {
            new CharSequenceAssertion(null, new FailDescription()).doesNotContain("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotContain(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotContain("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotContain("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotContain("alu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<alu> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotContain("lue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lue> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).doesNotContain("знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).doesNotContain("ение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<ение> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription("Message")).doesNotContain("ение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<ение> but was:<значение>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotContainIgnoreCaseTest() {
        new CharSequenceAssertion("value", new FailDescription()).doesNotContainIgnoreCase("vaUE");
        new CharSequenceAssertion("valUE", new FailDescription()).doesNotContainIgnoreCase("1VAL");
        new CharSequenceAssertion("valUE", new FailDescription()).doesNotContainIgnoreCase("UE1");
        new CharSequenceAssertion("знАчеНие", new FailDescription()).doesNotContainIgnoreCase("ЗНАН");
        new CharSequenceAssertion("знАчеНие", new FailDescription()).doesNotContainIgnoreCase("кени");
        new CharSequenceAssertion("знАчеНие", new FailDescription()).doesNotContainIgnoreCase("чИЕ");

        try {
            new CharSequenceAssertion(null, new FailDescription()).doesNotContainIgnoreCase("valUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("valUE", new FailDescription()).doesNotContainIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("valUE", new FailDescription()).doesNotContainIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("vaLUe", new FailDescription()).doesNotContainIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<vaLUe>.");
        }
        try {
            new CharSequenceAssertion("vaLUe", new FailDescription()).doesNotContainIgnoreCase("VAL");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<VAL> but was:<vaLUe>.");
        }
        try {
            new CharSequenceAssertion("vaLUe", new FailDescription()).doesNotContainIgnoreCase("lUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lUE> but was:<vaLUe>.");
        }
        try {
            new CharSequenceAssertion("зНАчеНИе", new FailDescription()).doesNotContainIgnoreCase("знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<зНАчеНИе>.");
        }
        try {
            new CharSequenceAssertion("зНАчеНИе", new FailDescription()).doesNotContainIgnoreCase("еНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<еНИе> but was:<зНАчеНИе>.");
        }
        try {
            new CharSequenceAssertion("зНАчеНИе", new FailDescription("Message")).doesNotContainIgnoreCase("еНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<еНИе> but was:<зНАчеНИе>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isPartOfTest() {
        new CharSequenceAssertion("val", new FailDescription()).isPartOf("value");
        new CharSequenceAssertion("alu", new FailDescription()).isPartOf("value");
        new CharSequenceAssertion("lue", new FailDescription()).isPartOf("value");
        new CharSequenceAssertion("знач", new FailDescription()).isPartOf("значение");
        new CharSequenceAssertion("ен", new FailDescription()).isPartOf("значение");
        new CharSequenceAssertion("ие", new FailDescription()).isPartOf("значение");
        new CharSequenceAssertion("", new FailDescription()).isPartOf("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isPartOf("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("VAL", new FailDescription()).isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<VAL>.");
        }
        try {
            new CharSequenceAssertion("vue", new FailDescription()).isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<vue>.");
        }
        try {
            new CharSequenceAssertion("ЗнАЧ", new FailDescription()).isPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<ЗнАЧ>.");
        }
        try {
            new CharSequenceAssertion("чача", new FailDescription()).isPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<чача>.");
        }
        try {
            new CharSequenceAssertion("чача", new FailDescription("Message")).isPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the part of the expected value. Expected:<значение> but was:<чача>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isPartOfIgnoreCaseTest() {
        new CharSequenceAssertion("vAl", new FailDescription()).isPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("Alu", new FailDescription()).isPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("luE", new FailDescription()).isPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("знАЧ", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
        new CharSequenceAssertion("Ен", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
        new CharSequenceAssertion("иЕ", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
        new CharSequenceAssertion("", new FailDescription()).isPartOfIgnoreCase("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vaLUe", new FailDescription()).isPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vaLUe", new FailDescription()).isPartOfIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<vaLUe>.");
        }
        try {
            new CharSequenceAssertion("VAe", new FailDescription()).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<VAe>.");
        }
        try {
            new CharSequenceAssertion("vUe", new FailDescription()).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<vUe>.");
        }
        try {
            new CharSequenceAssertion("ЗАЧ", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<ЗАЧ>.");
        }
        try {
            new CharSequenceAssertion("чача", new FailDescription()).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<чача>.");
        }
        try {
            new CharSequenceAssertion("чача", new FailDescription("Message")).isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<чача>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotPartOfTest() {
        new CharSequenceAssertion("vae", new FailDescription()).isNotPartOf("value");
        new CharSequenceAssertion("aLu", new FailDescription()).isNotPartOf("value");
        new CharSequenceAssertion("vue", new FailDescription()).isNotPartOf("value");
        new CharSequenceAssertion("знаач", new FailDescription()).isNotPartOf("значение");
        new CharSequenceAssertion("еНИ", new FailDescription()).isNotPartOf("значение");
        new CharSequenceAssertion("чие", new FailDescription()).isNotPartOf("значение");
        new CharSequenceAssertion("чие", new FailDescription()).isNotPartOf("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).isNotPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("", new FailDescription()).isNotPartOf("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>.");
        }
        try {
            new CharSequenceAssertion("val", new FailDescription()).isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<val>.");
        }
        try {
            new CharSequenceAssertion("lue", new FailDescription()).isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<lue>.");
        }
        try {
            new CharSequenceAssertion("знач", new FailDescription()).isNotPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<знач>.");
        }
        try {
            new CharSequenceAssertion("ение", new FailDescription()).isNotPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<ение>.");
        }
        try {
            new CharSequenceAssertion("ение", new FailDescription("Message")).isNotPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be the part of the expected value. Expected:<значение> but was:<ение>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotPartOfIgnoreCaseTest() {
        new CharSequenceAssertion("vAe", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("aLe", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("vuE", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
        new CharSequenceAssertion("знААч", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
        new CharSequenceAssertion("еНе", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
        new CharSequenceAssertion("чИЕ", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
        new CharSequenceAssertion("чИЕ", new FailDescription()).isNotPartOfIgnoreCase("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vaLUe", new FailDescription()).isNotPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("", new FailDescription()).isNotPartOfIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>.");
        }
        try {
            new CharSequenceAssertion("VAL", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<VAL>.");
        }
        try {
            new CharSequenceAssertion("LuE", new FailDescription()).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<LuE>.");
        }
        try {
            new CharSequenceAssertion("зНАч", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<зНАч>.");
        }
        try {
            new CharSequenceAssertion("ЕниЕ", new FailDescription()).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<ЕниЕ>.");
        }
        try {
            new CharSequenceAssertion("ЕниЕ", new FailDescription("Message")).isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be the part of the expected value. Expected:<знАченИе> but was:<ЕниЕ>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void matchesTest() {
        new CharSequenceAssertion("value", new FailDescription()).matches("v.*e");
        new CharSequenceAssertion("value", new FailDescription()).matches("v[aA].{2}[eE]");
        new CharSequenceAssertion("value", new FailDescription()).matches("\\w+");
        new CharSequenceAssertion("value", new FailDescription()).matches("\\w{4,6}");
        new CharSequenceAssertion("значение", new FailDescription()).matches("\\p{L}+");
        new CharSequenceAssertion("", new FailDescription()).matches("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).matches("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).matches(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).matches("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).matches("\\d+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\d+> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).matches("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\w+> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription("Message")).matches("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the expected value. Expected:<\\w+> but was:<значение>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotMatchTest() {
        new CharSequenceAssertion("value", new FailDescription()).doesNotMatch("valu.+e");
        new CharSequenceAssertion("value", new FailDescription()).doesNotMatch("v[zZ].{2}[eE]");
        new CharSequenceAssertion("value", new FailDescription()).doesNotMatch("\\s\\w+");
        new CharSequenceAssertion("value", new FailDescription()).doesNotMatch("\\w{8}");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotMatch("\\w+");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotMatch("");

        try {
            new CharSequenceAssertion(null, new FailDescription()).doesNotMatch("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotMatch(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("", new FailDescription()).doesNotMatch("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<> but was:<>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotMatch("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\w+> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).doesNotMatch("\\p{L}{8}");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\p{L}{8}> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription("Message")).doesNotMatch("\\p{L}{8}");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not match the expected value. Expected:<\\p{L}{8}> but was:<значение>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void startsWithTest() {
        new CharSequenceAssertion("value", new FailDescription()).startsWith("va");
        new CharSequenceAssertion("value", new FailDescription()).startsWith("val");
        new CharSequenceAssertion("value", new FailDescription()).startsWith("value");
        new CharSequenceAssertion("значение", new FailDescription()).startsWith("зна");
        new CharSequenceAssertion("значение", new FailDescription()).startsWith("значе");
        new CharSequenceAssertion("значение", new FailDescription()).startsWith("значение");

        try {
            new CharSequenceAssertion(null, new FailDescription()).startsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).startsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).startsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).startsWith("lue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lue> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).startsWith("Val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Val> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).startsWith("ачен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<ачен> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).startsWith("Знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Знач> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription("Message")).startsWith("Знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should start with the expected value. Expected:<Знач> but was:<значение>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void startsWithIgnoreCaseTest() {
        new CharSequenceAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("vA");
        new CharSequenceAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("VAl");
        new CharSequenceAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("vaLUe");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("зНа");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("зНаче");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("зНачение");

        try {
            new CharSequenceAssertion(null, new FailDescription()).startsWithIgnoreCase("vAlUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("lUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lUe> but was:<vAlUe>.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).startsWithIgnoreCase("Vau");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Vau> but was:<vAlUe>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("аЧен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<аЧен> but was:<знАчЕнИе>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription()).startsWithIgnoreCase("Значи");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Значи> but was:<знАчЕнИе>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription("Message")).startsWithIgnoreCase("Значи");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should start with the expected value. Expected:<Значи> but was:<знАчЕнИе>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotStartWithTest() {
        new CharSequenceAssertion("value", new FailDescription()).doesNotStartWith("VA");
        new CharSequenceAssertion("value", new FailDescription()).doesNotStartWith("VaL");
        new CharSequenceAssertion("value", new FailDescription()).doesNotStartWith("vale");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotStartWith("ЗНА");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotStartWith("Знач");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotStartWith("чение");

        try {
            new CharSequenceAssertion(null, new FailDescription()).doesNotStartWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotStartWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotStartWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotStartWith("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotStartWith("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<valu> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).doesNotStartWith("зн");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).doesNotStartWith("значен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значен> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription("Message")).doesNotStartWith("значен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not start with the expected value. Expected:<значен> but was:<значение>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotStartWithIgnoreCaseTest() {
        new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("Vu");
        new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("Vue");
        new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("ale");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("НА");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("Знч");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("чние");

        try {
            new CharSequenceAssertion(null, new FailDescription()).doesNotStartWithIgnoreCase("vAlUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<vAlUe>.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotStartWithIgnoreCase("VALUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<VALUe> but was:<vAlUe>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("зн");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<знАчЕнИе>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotStartWithIgnoreCase("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значение> but was:<знАчЕнИе>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription("Message")).doesNotStartWithIgnoreCase("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not start with the expected value. Expected:<значение> but was:<знАчЕнИе>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void endsWithTest() {
        new CharSequenceAssertion("value", new FailDescription()).endsWith("alue");
        new CharSequenceAssertion("value", new FailDescription()).endsWith("lue");
        new CharSequenceAssertion("value", new FailDescription()).endsWith("ue");
        new CharSequenceAssertion("значение", new FailDescription()).endsWith("ачение");
        new CharSequenceAssertion("значение", new FailDescription()).endsWith("ние");
        new CharSequenceAssertion("значение", new FailDescription()).endsWith("е");

        try {
            new CharSequenceAssertion(null, new FailDescription()).endsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).endsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).endsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).endsWith("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).endsWith("LuE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<LuE> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).endsWith("значе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<значе> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).endsWith("ЧенИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ЧенИе> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription("Message")).endsWith("ЧенИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should end with the expected value. Expected:<ЧенИе> but was:<значение>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void endsWithIgnoreCaseTest() {
        new CharSequenceAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("vaLue");
        new CharSequenceAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("Lue");
        new CharSequenceAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("E");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("значеНИЕ");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("чеНИЕ");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("Е");
        new CharSequenceAssertion("aaaxxxxx", new FailDescription()).endsWithIgnoreCase("xxx");

        try {
            new CharSequenceAssertion(null, new FailDescription()).endsWithIgnoreCase("vAlUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<vAlUe>.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).endsWithIgnoreCase("vUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<vUe> but was:<vAlUe>.");
        }
        try {
            new CharSequenceAssertion("", new FailDescription()).endsWithIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("знАчЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАчЕ> but was:<знАчЕнИе>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription()).endsWithIgnoreCase("знАИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАИе> but was:<знАчЕнИе>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription("Message")).endsWithIgnoreCase("знАИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should end with the expected value. Expected:<знАИе> but was:<знАчЕнИе>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotEndWithTest() {
        new CharSequenceAssertion("value", new FailDescription()).doesNotEndWith("aLue");
        new CharSequenceAssertion("value", new FailDescription()).doesNotEndWith("vue");
        new CharSequenceAssertion("value", new FailDescription()).doesNotEndWith("val");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotEndWith("ачЕниЕ");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotEndWith("зние");
        new CharSequenceAssertion("значение", new FailDescription()).doesNotEndWith("зна");

        try {
            new CharSequenceAssertion(null, new FailDescription()).doesNotEndWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotEndWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotEndWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotEndWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<value> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("value", new FailDescription()).doesNotEndWith("alue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<alue> but was:<value>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).doesNotEndWith("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<значение> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription()).doesNotEndWith("ие");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<ие> but was:<значение>.");
        }
        try {
            new CharSequenceAssertion("значение", new FailDescription("Message")).doesNotEndWith("ие");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not end with the expected value. Expected:<ие> but was:<значение>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotEndWithIgnoreCaseTest() {
        new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("aLe");
        new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("vue");
        new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("val");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("зачЕниЕ");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("зние");
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("зна");
        new CharSequenceAssertion("", new FailDescription()).doesNotEndWithIgnoreCase("val");

        try {
            new CharSequenceAssertion(null, new FailDescription()).doesNotEndWithIgnoreCase("vAlUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("vaLue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<vaLue> but was:<vAlUe>.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).doesNotEndWithIgnoreCase("aLue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<aLue> but was:<vAlUe>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("знАчение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<знАчение> but was:<знАчЕнИе>.");
        }
        try {
            new CharSequenceAssertion("знАчЕнИе", new FailDescription()).doesNotEndWithIgnoreCase("е");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<е> but was:<знАчЕнИе>.");
        }
        try {
            new CharSequenceAssertion("aaaxxxxx", new FailDescription()).doesNotEndWithIgnoreCase("xxx");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<xxx> but was:<aaaxxxxx>.");
        }
        try {
            new CharSequenceAssertion("aaaxxxxx", new FailDescription("Message")).doesNotEndWithIgnoreCase("xxx");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not end with the expected value. Expected:<xxx> but was:<aaaxxxxx>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        new CharSequenceAssertion("vAlUe", new FailDescription()).toLength().isEqualTo(5);
        new CharSequenceAssertion("vAlUe", new FailDescription()).toLength().isGreaterThan(3);
        new CharSequenceAssertion("vAlUe", new FailDescription()).toLength().isLessThan(7);

        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).toLength().isEqualTo(8);
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).toLength().isGreaterThan(5);
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).toLength().isLessThan(10);

        try {
            new CharSequenceAssertion(null, new FailDescription()).toLength();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).toLength().isEqualTo(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription("Message")).toLength().isEqualTo(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value length. Values should be the same. Expected:<6> but was:<5>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        new CharSequenceAssertion("vAlUe", new FailDescription()).hasLength(5);
        new CharSequenceAssertion("знАчЕнИе", new FailDescription()).hasLength(8);

        try {
            new CharSequenceAssertion(null, new FailDescription()).hasLength(5);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription()).hasLength(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value length. Values should be the same. Expected:<6> but was:<5>.");
        }
        try {
            new CharSequenceAssertion("vAlUe", new FailDescription("Message")).hasLength(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value length. Values should be the same. Expected:<6> but was:<5>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensTest() {
        new CharSequenceAssertion("value1 value2 value3", new FailDescription()).toTokens().containsAll("value1", "value2", "value3");
        new CharSequenceAssertion("value1|value2|value3", new FailDescription()).toTokens().containsAll("value1|value2|value3");
        new CharSequenceAssertion("value1|value2|value3", new FailDescription()).toTokens("|").containsAll("value1", "value2", "value3");
        new CharSequenceAssertion("value1|value2|value3", new FailDescription()).toTokens("|", false).containsAll("value1", "value2", "value3");
        new CharSequenceAssertion("value1|value2|value3", new FailDescription()).toTokens("|", true).containsAll("value1", "value2", "value3", "|", "|");

        try {
            new CharSequenceAssertion(null, new FailDescription()).toTokens();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion(null, new FailDescription()).toTokens("|");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value1|value2|value3", new FailDescription()).toTokens(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion(null, new FailDescription()).toTokens("|", false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharSequenceAssertion("value1|value2|value3", new FailDescription()).toTokens(null, false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharSequenceAssertion("value1 value2 value3", new FailDescription()).toTokens().hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new CharSequenceAssertion("value1 value2 value3", new FailDescription("Message")).toTokens().hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new CharSequenceAssertion("value1|value2|value3", new FailDescription()).toTokens("|").hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new CharSequenceAssertion("value1|value2|value3", new FailDescription("Message")).toTokens("|").hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new CharSequenceAssertion("value1|value2|value3", new FailDescription()).toTokens("|", true).hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<5>.");
        }
        try {
            new CharSequenceAssertion("value1|value2|value3", new FailDescription("Message")).toTokens("|", true).hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value tokens. Check value size. Values should be the same. Expected:<4> but was:<5>.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", new FailDescription()).asString("vAlUe", true)).isEqualTo("vAlUe");
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", new FailDescription()).asString("знАчЕнИе", true)).isEqualTo("знАчЕнИе");
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", new FailDescription()).asString(1, true)).isEqualTo("1");

        Assertions.assertThat(new CharSequenceAssertion("vAlUe", new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", new FailDescription()).asString("vAlUe", false)).isEqualTo("vAlUe");
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", new FailDescription()).asString("знАчЕнИе", false)).isEqualTo("знАчЕнИе");
        Assertions.assertThat(new CharSequenceAssertion("vAlUe", new FailDescription()).asString(1, false)).isEqualTo("1");
    }

}
