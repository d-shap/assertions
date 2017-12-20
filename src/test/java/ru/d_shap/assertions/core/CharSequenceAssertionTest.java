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

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link CharSequenceAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharSequenceAssertionTest extends AssertionTest {

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
    public void actualValueValidatorTest() {
        initialize(Raw.charSequenceAssertion(), "");

        try {
            initializeWithRawActual(Raw.charSequenceAssertion(), new Object());
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.charSequenceAssertion(), new Object(), "Message");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.charSequenceAssertion(), "").isEmpty();

        try {
            Raw.charSequenceAssertion().isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:< >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ", "Message").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:< >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.charSequenceAssertion(), null).isNullOrEmpty();
        initialize(Raw.charSequenceAssertion(), "").isNullOrEmpty();

        try {
            Raw.charSequenceAssertion().isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ").isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:< >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ", "Message").isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:< >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.charSequenceAssertion(), " ").isNotEmpty();
        initialize(Raw.charSequenceAssertion(), "value").isNotEmpty();

        try {
            Raw.charSequenceAssertion().isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotEmpty();
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
        initialize(Raw.charSequenceAssertion(), "").isBlank();
        initialize(Raw.charSequenceAssertion(), " ").isBlank();
        initialize(Raw.charSequenceAssertion(), "\t").isBlank();
        initialize(Raw.charSequenceAssertion(), "   \t   \t").isBlank();

        try {
            Raw.charSequenceAssertion().isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be blank. Actual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "v   ").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<v   >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "v   ", "Message").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be blank. Actual:<v   >");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNullOrBlankTest() {
        initialize(Raw.charSequenceAssertion(), null).isNullOrBlank();
        initialize(Raw.charSequenceAssertion(), "").isNullOrBlank();
        initialize(Raw.charSequenceAssertion(), " ").isNullOrBlank();
        initialize(Raw.charSequenceAssertion(), "\t").isNullOrBlank();
        initialize(Raw.charSequenceAssertion(), "   \t   \t").isNullOrBlank();

        try {
            Raw.charSequenceAssertion().isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or blank. Actual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "v   ").isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<v   >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "v   ", "Message").isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or blank. Actual:<v   >");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotBlankTest() {
        initialize(Raw.charSequenceAssertion(), "value").isNotBlank();
        initialize(Raw.charSequenceAssertion(), "v   ").isNotBlank();

        try {
            Raw.charSequenceAssertion().isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ", "Message").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "\t").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "\t", "Message").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "   \t   \t").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "   \t   \t", "Message").isNotBlank();
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
        initialize(Raw.charSequenceAssertion(), "value").isEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isEqualTo("ЗНАЧЕНИЕ");
        initialize(Raw.charSequenceAssertion(), "значение").isEqualTo("значение");
        initialize(Raw.charSequenceAssertion(), "").isEqualTo("");

        try {
            Raw.charSequenceAssertion().isEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualTo("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1").isEqualTo("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1").isEqualTo("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isEqualTo("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<ЗНАЧЕНИЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ", "Message").isEqualTo("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<значение> but was:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEqualToIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "valUe").isEqualToIgnoreCase("vALue");
        initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isEqualToIgnoreCase("значение");
        initialize(Raw.charSequenceAssertion(), "значение").isEqualToIgnoreCase("ЗНАЧЕНИЕ");
        initialize(Raw.charSequenceAssertion(), "").isEqualToIgnoreCase("");

        try {
            Raw.charSequenceAssertion().isEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vALue").isEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vALue", "Message").isEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vALue").isEqualToIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<vALue>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1").isEqualToIgnoreCase("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualToIgnoreCase("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualToIgnoreCase("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗнаЧеНИЕ").isEqualToIgnoreCase("vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<vaLUE> but was:<ЗнаЧеНИЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗнаЧеНИЕ", "Message").isEqualToIgnoreCase("vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<vaLUE> but was:<ЗнаЧеНИЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.charSequenceAssertion(), "value").isNotEqualTo("значение");
        initialize(Raw.charSequenceAssertion(), "value").isNotEqualTo("ЗНАЧЕНИЕ");
        initialize(Raw.charSequenceAssertion(), "значение").isNotEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isNotEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isNotEqualTo("");

        try {
            Raw.charSequenceAssertion().isNotEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotEqualTo("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").isNotEqualTo("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНАЧЕНИЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ", "Message").isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEqualToIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "vaLUe").isNotEqualToIgnoreCase("знАЧенИЕ");
        initialize(Raw.charSequenceAssertion(), "VAluE").isNotEqualToIgnoreCase("ЗНачЕНие");
        initialize(Raw.charSequenceAssertion(), "знАЧенИЕ").isNotEqualToIgnoreCase("vaLUe");
        initialize(Raw.charSequenceAssertion(), "ЗНачЕНие").isNotEqualToIgnoreCase("VAluE");
        initialize(Raw.charSequenceAssertion(), "ЗНачЕНие").isNotEqualToIgnoreCase("");

        try {
            Raw.charSequenceAssertion().isNotEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").isNotEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe", "Message").isNotEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotEqualToIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАЧенИЕ").isNotEqualToIgnoreCase("ЗНачЕНие");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<знАЧенИЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНачЕНие").isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<ЗНачЕНие>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНачЕНие", "Message").isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<ЗНачЕНие>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("aaa");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("vai");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("valuazzz");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("VALUE");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("XYZ");

        try {
            Raw.charSequenceAssertion().isGreaterThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThan("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("aaa");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("vai");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("vAi");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("valuazzz");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("vAlUazzz");

        try {
            Raw.charSequenceAssertion().isGreaterThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("VALUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<VALUE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("XYZ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<XYZ> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<x> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("aaa");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("vai");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("valuazzz");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("VALUE");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("XYZ");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("");
        initialize(Raw.charSequenceAssertion(), "").isGreaterThanOrEqualTo("");

        try {
            Raw.charSequenceAssertion().isGreaterThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanOrEqualTo("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("aaa");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("vai");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("vAi");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("valuazzz");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("vAlUazzz");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("value");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("VALUE");
        initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("");
        initialize(Raw.charSequenceAssertion(), "").isGreaterThanOrEqualToIgnoreCase("");

        try {
            Raw.charSequenceAssertion().isGreaterThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("XYZ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<XYZ> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<x> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanOrEqualToIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be greater then or equal to the expected. Expected:<x> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.charSequenceAssertion(), "value").isLessThan("yyy");
        initialize(Raw.charSequenceAssertion(), "value").isLessThan("vam");
        initialize(Raw.charSequenceAssertion(), "value").isLessThan("valuezzz");
        initialize(Raw.charSequenceAssertion(), "VALUE").isLessThan("value");
        initialize(Raw.charSequenceAssertion(), "XYZ").isLessThan("value");

        try {
            Raw.charSequenceAssertion().isLessThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThan("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThan("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThan("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("yyy");
        initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("vam");
        initialize(Raw.charSequenceAssertion(), "vAlue").isLessThanIgnoreCase("vam");
        initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("valuezzz");
        initialize(Raw.charSequenceAssertion(), "vAlUe").isLessThanIgnoreCase("valuezzz");

        try {
            Raw.charSequenceAssertion().isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VALUE").isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<VALUE>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "XYZ").isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<XYZ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<c> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("yyy");
        initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("vam");
        initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("valuezzz");
        initialize(Raw.charSequenceAssertion(), "VALUE").isLessThanOrEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "XYZ").isLessThanOrEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "").isLessThanOrEqualTo("");

        try {
            Raw.charSequenceAssertion().isLessThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanOrEqualTo("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("yyy");
        initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("vam");
        initialize(Raw.charSequenceAssertion(), "vAlue").isLessThanOrEqualToIgnoreCase("vam");
        initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("valuezzz");
        initialize(Raw.charSequenceAssertion(), "vAlUe").isLessThanOrEqualToIgnoreCase("valuezzz");
        initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("value");
        initialize(Raw.charSequenceAssertion(), "VALUE").isLessThanOrEqualToIgnoreCase("value");
        initialize(Raw.charSequenceAssertion(), "").isLessThanOrEqualToIgnoreCase("");

        try {
            Raw.charSequenceAssertion().isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "XYZ").isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<value> but was:<XYZ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<c> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanOrEqualToIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<c> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.charSequenceAssertion(), "value").isInRange("v", "valuex");
        initialize(Raw.charSequenceAssertion(), "value").isInRange("a", "z");
        initialize(Raw.charSequenceAssertion(), "value").isInRange("A", "z");
        initialize(Raw.charSequenceAssertion(), "value").isInRange("value", "z");
        initialize(Raw.charSequenceAssertion(), "value").isInRange("VALUE", "z");
        initialize(Raw.charSequenceAssertion(), "value").isInRange("", "z");
        initialize(Raw.charSequenceAssertion(), "").isInRange("", "z");

        try {
            Raw.charSequenceAssertion().isInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("A", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:Z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("a", "test");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("A", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("A", "vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("xxx", "yyy");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<xxx:yyy> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRange("xxx", "yyy");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<xxx:yyy> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isInRangeIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("v", "valuex");
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("a", "z");
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("a", "Z");
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("A", "z");
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("A", "Z");
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("value", "z");
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("value", "Z");
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("VALUE", "z");
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("VALUE", "Z");
        initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("", "Z");
        initialize(Raw.charSequenceAssertion(), "").isInRangeIgnoreCase("", "Z");

        try {
            Raw.charSequenceAssertion().isInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("a", "test");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("A", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("A", "vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("xxx", "yyy");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<xxx:yyy> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("XXX", "YYY");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<XXX:YYY> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRangeIgnoreCase("XXX", "YYY");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be in the expected range. Expected:<XXX:YYY> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.charSequenceAssertion(), "value").isNotInRange("A", "Z");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRange("a", "test");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRange("A", "value");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRange("A", "vaLUE");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRange("VALUE", "Z");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRange("xxx", "yyy");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRange("XXX", "YYY");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRange("", "aaa");

        try {
            Raw.charSequenceAssertion().isNotInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("v", "valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("a", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("A", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("value", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("VALUE", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRange("VALUE", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<VALUE:z> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotInRangeIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("a", "test");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("A", "value");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("A", "vaLUE");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("xxx", "yyy");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("XXX", "YYY");
        initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("", "AAA");

        try {
            Raw.charSequenceAssertion().isNotInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("A", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:Z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("v", "valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("a", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("A", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("value", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("VALUE", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("VALUE", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:Z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRangeIgnoreCase("VALUE", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be in the expected range. Expected:<VALUE:Z> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.charSequenceAssertion(), "value").contains("val");
        initialize(Raw.charSequenceAssertion(), "value").contains("alu");
        initialize(Raw.charSequenceAssertion(), "value").contains("lue");
        initialize(Raw.charSequenceAssertion(), "значение").contains("знач");
        initialize(Raw.charSequenceAssertion(), "значение").contains("ен");
        initialize(Raw.charSequenceAssertion(), "значение").contains("ие");

        try {
            Raw.charSequenceAssertion().contains("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).contains("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").contains("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).contains(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").contains(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").contains(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").contains("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains("VAL");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAL> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains("v.*ue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains("знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<знач> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").contains("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<value> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<\\w+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").contains(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void containsIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "value").containsIgnoreCase("VAL");
        initialize(Raw.charSequenceAssertion(), "VAlUE").containsIgnoreCase("aLu");
        initialize(Raw.charSequenceAssertion(), "VAlue").containsIgnoreCase("luE");
        initialize(Raw.charSequenceAssertion(), "значение").containsIgnoreCase("ЗНАЧ");
        initialize(Raw.charSequenceAssertion(), "ЗНАчЕнИЕ").containsIgnoreCase("еН");
        initialize(Raw.charSequenceAssertion(), "ЗНАЧЕние").containsIgnoreCase("Ие");

        try {
            Raw.charSequenceAssertion().containsIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).containsIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").containsIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).containsIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").containsIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAlue").containsIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAlue", "Message").containsIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAlue").containsIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAlue", "Message").containsIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").containsIgnoreCase("VAE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").containsIgnoreCase("v.*ue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLue").containsIgnoreCase("зНАч");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<зНАч> but was:<vaLue>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАЧЕние").containsIgnoreCase("valUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<valUE> but was:<знАЧЕние>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").containsIgnoreCase("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<\\w+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").containsIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").containsIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.charSequenceAssertion(), "value").doesNotContain("vaue");
        initialize(Raw.charSequenceAssertion(), "value").doesNotContain("VAL");
        initialize(Raw.charSequenceAssertion(), "value").doesNotContain("UE");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotContain("ЗНАЧ");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotContain("кени");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotContain("НИЕ");

        try {
            Raw.charSequenceAssertion().doesNotContain("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotContain("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotContain("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotContain(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotContain(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotContain(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").doesNotContain(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotContain("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").doesNotContain("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotContain("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotContain("alu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<alu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotContain("lue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lue> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotContain("знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotContain("ение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<ение> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotContain(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotContain(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotContainIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "value").doesNotContainIgnoreCase("vaUE");
        initialize(Raw.charSequenceAssertion(), "valUE").doesNotContainIgnoreCase("1VAL");
        initialize(Raw.charSequenceAssertion(), "valUE").doesNotContainIgnoreCase("UE1");
        initialize(Raw.charSequenceAssertion(), "знАчеНие").doesNotContainIgnoreCase("ЗНАН");
        initialize(Raw.charSequenceAssertion(), "знАчеНие").doesNotContainIgnoreCase("кени");
        initialize(Raw.charSequenceAssertion(), "знАчеНие").doesNotContainIgnoreCase("чИЕ");

        try {
            Raw.charSequenceAssertion().doesNotContainIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotContainIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotContainIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotContainIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotContainIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "valUE").doesNotContainIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "valUE", "Message").doesNotContainIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "valUE").doesNotContainIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "valUE", "Message").doesNotContainIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").doesNotContainIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").doesNotContainIgnoreCase("VAL");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<VAL> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").doesNotContainIgnoreCase("lUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lUE> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "зНАчеНИе").doesNotContainIgnoreCase("знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<зНАчеНИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "зНАчеНИе").doesNotContainIgnoreCase("еНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<еНИе> but was:<зНАчеНИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotContainIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotContainIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isPartOfTest() {
        initialize(Raw.charSequenceAssertion(), "val").isPartOf("value");
        initialize(Raw.charSequenceAssertion(), "alu").isPartOf("value");
        initialize(Raw.charSequenceAssertion(), "lue").isPartOf("value");
        initialize(Raw.charSequenceAssertion(), "знач").isPartOf("значение");
        initialize(Raw.charSequenceAssertion(), "ен").isPartOf("значение");
        initialize(Raw.charSequenceAssertion(), "ие").isPartOf("значение");
        initialize(Raw.charSequenceAssertion(), "").isPartOf("");

        try {
            Raw.charSequenceAssertion().isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isPartOf("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAL").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<VAL>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vue").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<vue>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗнАЧ").isPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<ЗнАЧ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "чача").isPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<чача>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "\\w+").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<\\w+>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".+").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<.+>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".+", "Message").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the part of the expected value. Expected:<value> but was:<.+>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isPartOfIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "vAl").isPartOfIgnoreCase("vaLUe");
        initialize(Raw.charSequenceAssertion(), "Alu").isPartOfIgnoreCase("vaLUe");
        initialize(Raw.charSequenceAssertion(), "luE").isPartOfIgnoreCase("vaLUe");
        initialize(Raw.charSequenceAssertion(), "знАЧ").isPartOfIgnoreCase("зНАчеНИе");
        initialize(Raw.charSequenceAssertion(), "Ен").isPartOfIgnoreCase("зНАчеНИе");
        initialize(Raw.charSequenceAssertion(), "иЕ").isPartOfIgnoreCase("зНАчеНИе");
        initialize(Raw.charSequenceAssertion(), "").isPartOfIgnoreCase("");

        try {
            Raw.charSequenceAssertion().isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").isPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe", "Message").isPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").isPartOfIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAe").isPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<VAe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vUe").isPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<vUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗАЧ").isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<ЗАЧ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "чача").isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<чача>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "\\w+").isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<\\w+>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".+").isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<.+>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".+", "Message").isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be the part of the expected value. Expected:<value> but was:<.+>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotPartOfTest() {
        initialize(Raw.charSequenceAssertion(), "vae").isNotPartOf("value");
        initialize(Raw.charSequenceAssertion(), "aLu").isNotPartOf("value");
        initialize(Raw.charSequenceAssertion(), "vue").isNotPartOf("value");
        initialize(Raw.charSequenceAssertion(), "знаач").isNotPartOf("значение");
        initialize(Raw.charSequenceAssertion(), "еНИ").isNotPartOf("значение");
        initialize(Raw.charSequenceAssertion(), "чие").isNotPartOf("значение");
        initialize(Raw.charSequenceAssertion(), "чие").isNotPartOf("");

        try {
            Raw.charSequenceAssertion().isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotPartOf("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "val").isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<val>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "lue").isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<lue>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знач").isNotPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<знач>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ение").isNotPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<ение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".").isNotPartOf("...");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<...> but was:<.>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".", "Message").isNotPartOf("...");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be the part of the expected value. Expected:<...> but was:<.>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotPartOfIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "vAe").isNotPartOfIgnoreCase("vaLUe");
        initialize(Raw.charSequenceAssertion(), "aLe").isNotPartOfIgnoreCase("vaLUe");
        initialize(Raw.charSequenceAssertion(), "vuE").isNotPartOfIgnoreCase("vaLUe");
        initialize(Raw.charSequenceAssertion(), "знААч").isNotPartOfIgnoreCase("знАченИе");
        initialize(Raw.charSequenceAssertion(), "еНе").isNotPartOfIgnoreCase("знАченИе");
        initialize(Raw.charSequenceAssertion(), "чИЕ").isNotPartOfIgnoreCase("знАченИе");
        initialize(Raw.charSequenceAssertion(), "чИЕ").isNotPartOfIgnoreCase("");

        try {
            Raw.charSequenceAssertion().isNotPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").isNotPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe", "Message").isNotPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotPartOfIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAL").isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<VAL>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "LuE").isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<LuE>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "зНАч").isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<зНАч>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЕниЕ").isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<ЕниЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".").isNotPartOfIgnoreCase("...");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<...> but was:<.>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".", "Message").isNotPartOfIgnoreCase("...");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be the part of the expected value. Expected:<...> but was:<.>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void matchesTest() {
        initialize(Raw.charSequenceAssertion(), "value").matches("v.*e");
        initialize(Raw.charSequenceAssertion(), "value").matches("v[aA].{2}[eE]");
        initialize(Raw.charSequenceAssertion(), "value").matches("\\w+");
        initialize(Raw.charSequenceAssertion(), "value").matches("\\w{4,6}");
        initialize(Raw.charSequenceAssertion(), "значение").matches("\\p{L}+");
        initialize(Raw.charSequenceAssertion(), "").matches("");

        try {
            Raw.charSequenceAssertion().matches("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).matches("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").matches("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).matches(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").matches(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").matches(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").matches(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").matches("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").matches("\\d+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\d+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").matches("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\w+> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение", "Message").matches("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the expected value. Expected:<\\w+> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotMatchTest() {
        initialize(Raw.charSequenceAssertion(), "value").doesNotMatch("valu.+e");
        initialize(Raw.charSequenceAssertion(), "value").doesNotMatch("v[zZ].{2}[eE]");
        initialize(Raw.charSequenceAssertion(), "value").doesNotMatch("\\s\\w+");
        initialize(Raw.charSequenceAssertion(), "value").doesNotMatch("\\w{8}");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotMatch("\\w+");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotMatch("");

        try {
            Raw.charSequenceAssertion().doesNotMatch("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotMatch("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotMatch("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotMatch(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotMatch(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotMatch(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").doesNotMatch(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotMatch("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<> but was:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotMatch("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\w+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotMatch("\\p{L}{8}");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\p{L}{8}> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение", "Message").doesNotMatch("\\p{L}{8}");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not match the expected value. Expected:<\\p{L}{8}> but was:<значение>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void startsWithTest() {
        initialize(Raw.charSequenceAssertion(), "value").startsWith("va");
        initialize(Raw.charSequenceAssertion(), "value").startsWith("val");
        initialize(Raw.charSequenceAssertion(), "value").startsWith("value");
        initialize(Raw.charSequenceAssertion(), "значение").startsWith("зна");
        initialize(Raw.charSequenceAssertion(), "значение").startsWith("значе");
        initialize(Raw.charSequenceAssertion(), "значение").startsWith("значение");

        try {
            Raw.charSequenceAssertion().startsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).startsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").startsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).startsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").startsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").startsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").startsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith("lue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lue> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith("Val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Val> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").startsWith("ачен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<ачен> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").startsWith("Знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Знач> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith("va?");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<va?> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").startsWith(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should start with the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void startsWithIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "vAlUe").startsWithIgnoreCase("vA");
        initialize(Raw.charSequenceAssertion(), "vAlUe").startsWithIgnoreCase("VAl");
        initialize(Raw.charSequenceAssertion(), "vAlUe").startsWithIgnoreCase("vaLUe");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").startsWithIgnoreCase("зНа");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").startsWithIgnoreCase("зНаче");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").startsWithIgnoreCase("зНачение");

        try {
            Raw.charSequenceAssertion().startsWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).startsWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").startsWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).startsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").startsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").startsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").startsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").startsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").startsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").startsWithIgnoreCase("lUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lUe> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").startsWithIgnoreCase("Vau");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Vau> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").startsWithIgnoreCase("аЧен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<аЧен> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").startsWithIgnoreCase("Значи");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Значи> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWithIgnoreCase("va?");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<va?> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWithIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").startsWithIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should start with the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotStartWithTest() {
        initialize(Raw.charSequenceAssertion(), "value").doesNotStartWith("VA");
        initialize(Raw.charSequenceAssertion(), "value").doesNotStartWith("VaL");
        initialize(Raw.charSequenceAssertion(), "value").doesNotStartWith("vale");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotStartWith("ЗНА");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotStartWith("Знач");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotStartWith("чение");

        try {
            Raw.charSequenceAssertion().doesNotStartWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotStartWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotStartWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotStartWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotStartWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotStartWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").doesNotStartWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotStartWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").doesNotStartWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotStartWith("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotStartWith("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotStartWith("зн");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotStartWith("значен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значен> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotStartWith(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotStartWith(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not start with the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotStartWithIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotStartWithIgnoreCase("Vu");
        initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotStartWithIgnoreCase("Vue");
        initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotStartWithIgnoreCase("ale");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("НА");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("Знч");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("чние");

        try {
            Raw.charSequenceAssertion().doesNotStartWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotStartWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotStartWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotStartWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotStartWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotStartWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").doesNotStartWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotStartWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").doesNotStartWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotStartWithIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotStartWithIgnoreCase("VALUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<VALUe> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("зн");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значение> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotStartWithIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotStartWithIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not start with the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void endsWithTest() {
        initialize(Raw.charSequenceAssertion(), "value").endsWith("alue");
        initialize(Raw.charSequenceAssertion(), "value").endsWith("lue");
        initialize(Raw.charSequenceAssertion(), "value").endsWith("ue");
        initialize(Raw.charSequenceAssertion(), "значение").endsWith("ачение");
        initialize(Raw.charSequenceAssertion(), "значение").endsWith("ние");
        initialize(Raw.charSequenceAssertion(), "значение").endsWith("е");

        try {
            Raw.charSequenceAssertion().endsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).endsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").endsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).endsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").endsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").endsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").endsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith("LuE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<LuE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").endsWith("значе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<значе> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").endsWith("ЧенИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ЧенИе> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith("ue?");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ue?> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").endsWith(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should end with the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void endsWithIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "vAlUe").endsWithIgnoreCase("vaLue");
        initialize(Raw.charSequenceAssertion(), "vAlUe").endsWithIgnoreCase("Lue");
        initialize(Raw.charSequenceAssertion(), "vAlUe").endsWithIgnoreCase("E");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").endsWithIgnoreCase("значеНИЕ");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").endsWithIgnoreCase("чеНИЕ");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").endsWithIgnoreCase("Е");
        initialize(Raw.charSequenceAssertion(), "aaaxxxxx").endsWithIgnoreCase("xxx");

        try {
            Raw.charSequenceAssertion().endsWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).endsWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").endsWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).endsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").endsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").endsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").endsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").endsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").endsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").endsWithIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").endsWithIgnoreCase("vUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<vUe> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").endsWithIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").endsWithIgnoreCase("знАчЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАчЕ> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").endsWithIgnoreCase("знАИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАИе> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWithIgnoreCase("ue?");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ue?> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWithIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").endsWithIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should end with the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotEndWithTest() {
        initialize(Raw.charSequenceAssertion(), "value").doesNotEndWith("aLue");
        initialize(Raw.charSequenceAssertion(), "value").doesNotEndWith("vue");
        initialize(Raw.charSequenceAssertion(), "value").doesNotEndWith("val");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotEndWith("ачЕниЕ");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotEndWith("зние");
        initialize(Raw.charSequenceAssertion(), "значение").doesNotEndWith("зна");

        try {
            Raw.charSequenceAssertion().doesNotEndWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotEndWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotEndWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotEndWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotEndWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotEndWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").doesNotEndWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotEndWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").doesNotEndWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotEndWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotEndWith("alue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<alue> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotEndWith("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<значение> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotEndWith("ие");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<ие> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotEndWith(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotEndWith(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not end with the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void doesNotEndWithIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotEndWithIgnoreCase("aLe");
        initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotEndWithIgnoreCase("vue");
        initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotEndWithIgnoreCase("val");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("зачЕниЕ");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("зние");
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("зна");
        initialize(Raw.charSequenceAssertion(), "").doesNotEndWithIgnoreCase("val");

        try {
            Raw.charSequenceAssertion().doesNotEndWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotEndWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotEndWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotEndWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotEndWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotEndWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").doesNotEndWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotEndWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").doesNotEndWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotEndWithIgnoreCase("vaLue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<vaLue> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotEndWithIgnoreCase("aLue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<aLue> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("знАчение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<знАчение> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("е");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<е> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "aaaxxxxx").doesNotEndWithIgnoreCase("xxx");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<xxx> but was:<aaaxxxxx>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotEndWithIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotEndWithIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not end with the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.charSequenceAssertion(), "vAlUe").toLength().isEqualTo(5);
        initialize(Raw.charSequenceAssertion(), "vAlUe").toLength().isGreaterThan(3);
        initialize(Raw.charSequenceAssertion(), "vAlUe").toLength().isLessThan(7);

        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").toLength().isEqualTo(8);
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").toLength().isGreaterThan(5);
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").toLength().isLessThan(10);

        try {
            Raw.charSequenceAssertion().toLength();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toLength();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toLength();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").toLength().isEqualTo(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's length. Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").toLength().isEqualTo(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's length. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.charSequenceAssertion(), "vAlUe").hasLength(5);
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").hasLength(8);

        try {
            Raw.charSequenceAssertion().hasLength(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).hasLength(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").hasLength(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").hasLength(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's length. Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").hasLength(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's length. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensDefaultTest() {
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens().containsAll("value1", "value2", "value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens().containsAll("value1|value2|value3");

        try {
            Raw.charSequenceAssertion().toTokens();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens().hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1 value2 value3", "Message").toTokens().hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensSpecifiedTest() {
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("|").containsAll("value1 value2 value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|").containsAll("value1", "value2", "value3");

        try {
            Raw.charSequenceAssertion().toTokens("|");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens("|");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens("|");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|").hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens("|").hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensWithDelimitersTest() {
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("|", false).containsAll("value1 value2 value3");
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("|", true).containsAll("value1 value2 value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", false).containsAll("value1", "value2", "value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", true).containsAll("value1", "value2", "value3", "|", "|");

        try {
            Raw.charSequenceAssertion().toTokens("|", false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens("|", false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens("|", false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens(null, false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens(null, false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens(null, false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens(null, false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", true).hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<5>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens("|", true).hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<5>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.charSequenceAssertion(), null).isNull();

        try {
            initialize(Raw.charSequenceAssertion(), "value").isNull();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNull();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        String value = "value1";
        initialize(Raw.charSequenceAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.charSequenceAssertion(), value).isSameAs("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), value, "Message").isSameAs("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<value2> but was:<value1>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        String value = "value1";
        initialize(Raw.charSequenceAssertion(), value).isNotSameAs("value2");

        try {
            initialize(Raw.charSequenceAssertion(), value).isNotSameAs(value);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value1>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<value1>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.charSequenceAssertion(), "vAlUe").asString(null));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.charSequenceAssertion(), "vAlUe").asString("vAlUe")).isEqualTo("vAlUe");
        Assertions.assertThat(initialize(Raw.charSequenceAssertion(), "vAlUe").asString("знАчЕнИе")).isEqualTo("знАчЕнИе");
        Assertions.assertThat(initialize(Raw.charSequenceAssertion(), "vAlUe").asString(1)).isEqualTo("1");
    }

}
