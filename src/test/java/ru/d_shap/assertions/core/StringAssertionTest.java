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
 * Tests for {@link StringAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class StringAssertionTest extends AssertionTest {

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
    public void actualValueValidatorTest() {
        initialize(Raw.stringAssertion(), "");

        try {
            initializeWithRawActual(Raw.stringAssertion(), new Object());
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.stringAssertion(), new Object(), "Message");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.stringAssertion(), "").isEmpty();

        try {
            Raw.stringAssertion().isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), " ").isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:< >");
        }
        try {
            initialize(Raw.stringAssertion(), " ", "Message").isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:< >");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value", "Message").isEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.stringAssertion(), null).isNullOrEmpty();
        initialize(Raw.stringAssertion(), "").isNullOrEmpty();

        try {
            Raw.stringAssertion().isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), " ").isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:< >");
        }
        try {
            initialize(Raw.stringAssertion(), " ", "Message").isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:< >");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value", "Message").isNullOrEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.stringAssertion(), " ").isNotEmpty();
        initialize(Raw.stringAssertion(), "value").isNotEmpty();

        try {
            Raw.stringAssertion().isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "").isNotEmpty();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.stringAssertion(), "", "Message").isNotEmpty();
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
        initialize(Raw.stringAssertion(), "").isBlank();
        initialize(Raw.stringAssertion(), " ").isBlank();
        initialize(Raw.stringAssertion(), "\t").isBlank();
        initialize(Raw.stringAssertion(), "   \t   \t").isBlank();

        try {
            Raw.stringAssertion().isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value", "Message").isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be blank. Actual:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "v   ").isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be blank. Actual:<v   >");
        }
        try {
            initialize(Raw.stringAssertion(), "v   ", "Message").isBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be blank. Actual:<v   >");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNullOrBlankTest() {
        initialize(Raw.stringAssertion(), null).isNullOrBlank();
        initialize(Raw.stringAssertion(), "").isNullOrBlank();
        initialize(Raw.stringAssertion(), " ").isNullOrBlank();
        initialize(Raw.stringAssertion(), "\t").isNullOrBlank();
        initialize(Raw.stringAssertion(), "   \t   \t").isNullOrBlank();

        try {
            Raw.stringAssertion().isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value", "Message").isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or blank. Actual:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "v   ").isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or blank. Actual:<v   >");
        }
        try {
            initialize(Raw.stringAssertion(), "v   ", "Message").isNullOrBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or blank. Actual:<v   >");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotBlankTest() {
        initialize(Raw.stringAssertion(), "value").isNotBlank();
        initialize(Raw.stringAssertion(), "v   ").isNotBlank();

        try {
            Raw.stringAssertion().isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "").isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            initialize(Raw.stringAssertion(), "", "Message").isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
        try {
            initialize(Raw.stringAssertion(), " ").isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            initialize(Raw.stringAssertion(), " ", "Message").isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
        try {
            initialize(Raw.stringAssertion(), "\t").isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            initialize(Raw.stringAssertion(), "\t", "Message").isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be blank.");
        }
        try {
            initialize(Raw.stringAssertion(), "   \t   \t").isNotBlank();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be blank.");
        }
        try {
            initialize(Raw.stringAssertion(), "   \t   \t", "Message").isNotBlank();
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
        initialize(Raw.stringAssertion(), "value").isEqualTo("value");
        initialize(Raw.stringAssertion(), "ЗНАЧЕНИЕ").isEqualTo("ЗНАЧЕНИЕ");
        initialize(Raw.stringAssertion(), "значение").isEqualTo("значение");
        initialize(Raw.stringAssertion(), "").isEqualTo("");

        try {
            Raw.stringAssertion().isEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isEqualTo("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value1").isEqualTo("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.stringAssertion(), "value1").isEqualTo("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "ЗНАЧЕНИЕ").isEqualTo("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEqualToMutationTest() {
        try {
            initialize(Raw.stringAssertion(), "value1").isEqualTo("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualToIgnoreCase("Values should be the same. Expected:<value2> but was:<value1>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isEqualToIgnoreCaseTest() {
        initialize(Raw.stringAssertion(), "valUe").isEqualToIgnoreCase("vALue");
        initialize(Raw.stringAssertion(), "ЗНАЧЕНИЕ").isEqualToIgnoreCase("значение");
        initialize(Raw.stringAssertion(), "значение").isEqualToIgnoreCase("ЗНАЧЕНИЕ");
        initialize(Raw.stringAssertion(), "").isEqualToIgnoreCase("");

        try {
            Raw.stringAssertion().isEqualToIgnoreCase("vALue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isEqualToIgnoreCase("vALue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vALue").isEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vALue").isEqualToIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<> but was:<vALue>");
        }
        try {
            initialize(Raw.stringAssertion(), "value1").isEqualToIgnoreCase("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isEqualToIgnoreCase("ЗНАЧЕНИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isEqualToIgnoreCase("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<значение> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "ЗнаЧеНИЕ").isEqualToIgnoreCase("vaLUE");
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
        initialize(Raw.stringAssertion(), "value").isNotEqualTo("значение");
        initialize(Raw.stringAssertion(), "value").isNotEqualTo("ЗНАЧЕНИЕ");
        initialize(Raw.stringAssertion(), "значение").isNotEqualTo("value");
        initialize(Raw.stringAssertion(), "ЗНАЧЕНИЕ").isNotEqualTo("value");
        initialize(Raw.stringAssertion(), "ЗНАЧЕНИЕ").isNotEqualTo("");

        try {
            Raw.stringAssertion().isNotEqualTo("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isNotEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "").isNotEqualTo("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").isNotEqualTo("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "ЗНАЧЕНИЕ").isNotEqualTo("ЗНАЧЕНИЕ");
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
        initialize(Raw.stringAssertion(), "vaLUe").isNotEqualToIgnoreCase("знАЧенИЕ");
        initialize(Raw.stringAssertion(), "VAluE").isNotEqualToIgnoreCase("ЗНачЕНие");
        initialize(Raw.stringAssertion(), "знАЧенИЕ").isNotEqualToIgnoreCase("vaLUe");
        initialize(Raw.stringAssertion(), "ЗНачЕНие").isNotEqualToIgnoreCase("VAluE");
        initialize(Raw.stringAssertion(), "ЗНачЕНие").isNotEqualToIgnoreCase("");

        try {
            Raw.stringAssertion().isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isNotEqualToIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vaLUe").isNotEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "").isNotEqualToIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАЧенИЕ").isNotEqualToIgnoreCase("ЗНачЕНие");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<знАЧенИЕ>");
        }
        try {
            initialize(Raw.stringAssertion(), "ЗНачЕНие").isNotEqualToIgnoreCase("знАЧенИЕ");
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
        initialize(Raw.stringAssertion(), "value").isGreaterThan("aaa");
        initialize(Raw.stringAssertion(), "value").isGreaterThan("vai");
        initialize(Raw.stringAssertion(), "value").isGreaterThan("valuazzz");
        initialize(Raw.stringAssertion(), "value").isGreaterThan("VALUE");
        initialize(Raw.stringAssertion(), "value").isGreaterThan("XYZ");

        try {
            Raw.stringAssertion().isGreaterThan("aaa");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isGreaterThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThan(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThan("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThan("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThan("x");
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
        initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("aaa");
        initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("vai");
        initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("vAi");
        initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("valuazzz");
        initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("vAlUazzz");

        try {
            Raw.stringAssertion().isGreaterThanIgnoreCase("aaa");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isGreaterThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("VALUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<VALUE> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("XYZ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<XYZ> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanIgnoreCase("x");
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
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo("aaa");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo("vai");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo("valuazzz");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo("VALUE");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo("XYZ");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo("value");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo("");
        initialize(Raw.stringAssertion(), "").isGreaterThanOrEqualTo("");

        try {
            Raw.stringAssertion().isGreaterThanOrEqualTo("aaa");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isGreaterThanOrEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualTo("x");
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
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("aaa");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("vai");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("vAi");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("valuazzz");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("vAlUazzz");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("value");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("VALUE");
        initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("");
        initialize(Raw.stringAssertion(), "").isGreaterThanOrEqualToIgnoreCase("");

        try {
            Raw.stringAssertion().isGreaterThanOrEqualToIgnoreCase("aaa");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isGreaterThanOrEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("XYZ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<XYZ> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("x");
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
        initialize(Raw.stringAssertion(), "value").isLessThan("yyy");
        initialize(Raw.stringAssertion(), "value").isLessThan("vam");
        initialize(Raw.stringAssertion(), "value").isLessThan("valuezzz");
        initialize(Raw.stringAssertion(), "VALUE").isLessThan("value");
        initialize(Raw.stringAssertion(), "XYZ").isLessThan("value");

        try {
            Raw.stringAssertion().isLessThan("yyy");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isLessThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThan(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThan("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThan("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThan("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThan("c");
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
        initialize(Raw.stringAssertion(), "value").isLessThanIgnoreCase("yyy");
        initialize(Raw.stringAssertion(), "value").isLessThanIgnoreCase("vam");
        initialize(Raw.stringAssertion(), "vAlue").isLessThanIgnoreCase("vam");
        initialize(Raw.stringAssertion(), "value").isLessThanIgnoreCase("valuezzz");
        initialize(Raw.stringAssertion(), "vAlUe").isLessThanIgnoreCase("valuezzz");

        try {
            Raw.stringAssertion().isLessThanIgnoreCase("yyy");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "VALUE").isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<VALUE>");
        }
        try {
            initialize(Raw.stringAssertion(), "XYZ").isLessThanIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<value> but was:<XYZ>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanIgnoreCase("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanIgnoreCase("c");
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
        initialize(Raw.stringAssertion(), "value").isLessThanOrEqualTo("yyy");
        initialize(Raw.stringAssertion(), "value").isLessThanOrEqualTo("vam");
        initialize(Raw.stringAssertion(), "value").isLessThanOrEqualTo("valuezzz");
        initialize(Raw.stringAssertion(), "VALUE").isLessThanOrEqualTo("value");
        initialize(Raw.stringAssertion(), "XYZ").isLessThanOrEqualTo("value");
        initialize(Raw.stringAssertion(), "value").isLessThanOrEqualTo("value");
        initialize(Raw.stringAssertion(), "").isLessThanOrEqualTo("");

        try {
            Raw.stringAssertion().isLessThanOrEqualTo("yyy");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isLessThanOrEqualTo("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanOrEqualTo(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanOrEqualTo("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanOrEqualTo("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanOrEqualTo("c");
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
        initialize(Raw.stringAssertion(), "value").isLessThanOrEqualToIgnoreCase("yyy");
        initialize(Raw.stringAssertion(), "value").isLessThanOrEqualToIgnoreCase("vam");
        initialize(Raw.stringAssertion(), "vAlue").isLessThanOrEqualToIgnoreCase("vam");
        initialize(Raw.stringAssertion(), "value").isLessThanOrEqualToIgnoreCase("valuezzz");
        initialize(Raw.stringAssertion(), "vAlUe").isLessThanOrEqualToIgnoreCase("valuezzz");
        initialize(Raw.stringAssertion(), "value").isLessThanOrEqualToIgnoreCase("value");
        initialize(Raw.stringAssertion(), "VALUE").isLessThanOrEqualToIgnoreCase("value");
        initialize(Raw.stringAssertion(), "").isLessThanOrEqualToIgnoreCase("");

        try {
            Raw.stringAssertion().isLessThanOrEqualToIgnoreCase("yyy");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanOrEqualToIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "XYZ").isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<value> but was:<XYZ>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanOrEqualToIgnoreCase("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isLessThanOrEqualToIgnoreCase("c");
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
        initialize(Raw.stringAssertion(), "value").isInRange("v", "valuex");
        initialize(Raw.stringAssertion(), "value").isInRange("a", "z");
        initialize(Raw.stringAssertion(), "value").isInRange("A", "z");
        initialize(Raw.stringAssertion(), "value").isInRange("value", "z");
        initialize(Raw.stringAssertion(), "value").isInRange("VALUE", "z");
        initialize(Raw.stringAssertion(), "value").isInRange("", "z");
        initialize(Raw.stringAssertion(), "").isInRange("", "z");

        try {
            Raw.stringAssertion().isInRange("v", "valuex");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isInRange("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRange(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRange("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRange("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRange("A", "Z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:Z> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRange("a", "test");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRange("A", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRange("A", "vaLUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRange("xxx", "yyy");
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
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("v", "valuex");
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("a", "z");
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("a", "Z");
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("A", "z");
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("A", "Z");
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("value", "z");
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("value", "Z");
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("VALUE", "z");
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("VALUE", "Z");
        initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("", "Z");
        initialize(Raw.stringAssertion(), "").isInRangeIgnoreCase("", "Z");

        try {
            Raw.stringAssertion().isInRangeIgnoreCase("v", "valuex");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isInRangeIgnoreCase("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("a", "test");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<a:test> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("A", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:value> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("A", "vaLUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<A:vaLUE> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("xxx", "yyy");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<xxx:yyy> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isInRangeIgnoreCase("XXX", "YYY");
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
        initialize(Raw.stringAssertion(), "value").isNotInRange("A", "Z");
        initialize(Raw.stringAssertion(), "value").isNotInRange("a", "test");
        initialize(Raw.stringAssertion(), "value").isNotInRange("A", "value");
        initialize(Raw.stringAssertion(), "value").isNotInRange("A", "vaLUE");
        initialize(Raw.stringAssertion(), "value").isNotInRange("VALUE", "Z");
        initialize(Raw.stringAssertion(), "value").isNotInRange("xxx", "yyy");
        initialize(Raw.stringAssertion(), "value").isNotInRange("XXX", "YYY");
        initialize(Raw.stringAssertion(), "value").isNotInRange("", "aaa");

        try {
            Raw.stringAssertion().isNotInRange("A", "Z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isNotInRange("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRange(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRange("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRange("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRange("v", "valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRange("a", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRange("A", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRange("value", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRange("VALUE", "z");
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
        initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("a", "test");
        initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("A", "value");
        initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("A", "vaLUE");
        initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("xxx", "yyy");
        initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("XXX", "YYY");
        initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("", "AAA");

        try {
            Raw.stringAssertion().isNotInRangeIgnoreCase("a", "test");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isNotInRangeIgnoreCase("value", "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("value", null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("value", "");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("A", "Z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:Z> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("v", "valuea");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<v:valuea> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("a", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<a:z> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("A", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<A:z> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("value", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<value:z> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("VALUE", "z");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<VALUE:z> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotInRangeIgnoreCase("VALUE", "Z");
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
        initialize(Raw.stringAssertion(), "value").contains("val");
        initialize(Raw.stringAssertion(), "value").contains("alu");
        initialize(Raw.stringAssertion(), "value").contains("lue");
        initialize(Raw.stringAssertion(), "значение").contains("знач");
        initialize(Raw.stringAssertion(), "значение").contains("ен");
        initialize(Raw.stringAssertion(), "значение").contains("ие");

        try {
            Raw.stringAssertion().contains("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).contains("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").contains(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").contains("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").contains("VAL");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAL> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").contains("v.*ue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").contains("знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<знач> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").contains("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<value> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").contains("\\w+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<\\w+> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").contains(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void containsIgnoreCaseTest() {
        initialize(Raw.stringAssertion(), "value").containsIgnoreCase("VAL");
        initialize(Raw.stringAssertion(), "VAlUE").containsIgnoreCase("aLu");
        initialize(Raw.stringAssertion(), "VAlue").containsIgnoreCase("luE");
        initialize(Raw.stringAssertion(), "значение").containsIgnoreCase("ЗНАЧ");
        initialize(Raw.stringAssertion(), "ЗНАчЕнИЕ").containsIgnoreCase("еН");
        initialize(Raw.stringAssertion(), "ЗНАЧЕние").containsIgnoreCase("Ие");

        try {
            Raw.stringAssertion().containsIgnoreCase("VAL");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).containsIgnoreCase("VAlue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "VAlue").containsIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "VAlue").containsIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").containsIgnoreCase("VAE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<VAE> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "vaLUe").containsIgnoreCase("v.*ue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<v.*ue> but was:<vaLUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "vaLue").containsIgnoreCase("зНАч");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<зНАч> but was:<vaLue>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАЧЕние").containsIgnoreCase("valUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<valUE> but was:<знАЧЕние>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").containsIgnoreCase("\\w+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<\\w+> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").containsIgnoreCase(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.stringAssertion(), "value").doesNotContain("vaue");
        initialize(Raw.stringAssertion(), "value").doesNotContain("VAL");
        initialize(Raw.stringAssertion(), "value").doesNotContain("UE");
        initialize(Raw.stringAssertion(), "значение").doesNotContain("ЗНАЧ");
        initialize(Raw.stringAssertion(), "значение").doesNotContain("кени");
        initialize(Raw.stringAssertion(), "значение").doesNotContain("НИЕ");

        try {
            Raw.stringAssertion().doesNotContain("vaue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).doesNotContain("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotContain(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotContain("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotContain("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotContain("alu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<alu> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotContain("lue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lue> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").doesNotContain("знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").doesNotContain("ение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<ение> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "...").doesNotContain(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotContainIgnoreCaseTest() {
        initialize(Raw.stringAssertion(), "value").doesNotContainIgnoreCase("vaUE");
        initialize(Raw.stringAssertion(), "valUE").doesNotContainIgnoreCase("1VAL");
        initialize(Raw.stringAssertion(), "valUE").doesNotContainIgnoreCase("UE1");
        initialize(Raw.stringAssertion(), "знАчеНие").doesNotContainIgnoreCase("ЗНАН");
        initialize(Raw.stringAssertion(), "знАчеНие").doesNotContainIgnoreCase("кени");
        initialize(Raw.stringAssertion(), "знАчеНие").doesNotContainIgnoreCase("чИЕ");

        try {
            Raw.stringAssertion().doesNotContainIgnoreCase("vaUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).doesNotContainIgnoreCase("valUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "valUE").doesNotContainIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "valUE").doesNotContainIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "vaLUe").doesNotContainIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<val> but was:<vaLUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "vaLUe").doesNotContainIgnoreCase("VAL");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<VAL> but was:<vaLUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "vaLUe").doesNotContainIgnoreCase("lUE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<lUE> but was:<vaLUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "зНАчеНИе").doesNotContainIgnoreCase("знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<знач> but was:<зНАчеНИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "зНАчеНИе").doesNotContainIgnoreCase("еНИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<еНИе> but was:<зНАчеНИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "...").doesNotContainIgnoreCase(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isPartOfTest() {
        initialize(Raw.stringAssertion(), "val").isPartOf("value");
        initialize(Raw.stringAssertion(), "alu").isPartOf("value");
        initialize(Raw.stringAssertion(), "lue").isPartOf("value");
        initialize(Raw.stringAssertion(), "знач").isPartOf("значение");
        initialize(Raw.stringAssertion(), "ен").isPartOf("значение");
        initialize(Raw.stringAssertion(), "ие").isPartOf("значение");
        initialize(Raw.stringAssertion(), "").isPartOf("");

        try {
            Raw.stringAssertion().isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isPartOf(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isPartOf("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "VAL").isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<VAL>");
        }
        try {
            initialize(Raw.stringAssertion(), "vue").isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<vue>");
        }
        try {
            initialize(Raw.stringAssertion(), "ЗнАЧ").isPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<ЗнАЧ>");
        }
        try {
            initialize(Raw.stringAssertion(), "чача").isPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<значение> but was:<чача>");
        }
        try {
            initialize(Raw.stringAssertion(), "\\w+").isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<\\w+>");
        }
        try {
            initialize(Raw.stringAssertion(), ".+").isPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<.+>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isPartOfIgnoreCaseTest() {
        initialize(Raw.stringAssertion(), "vAl").isPartOfIgnoreCase("vaLUe");
        initialize(Raw.stringAssertion(), "Alu").isPartOfIgnoreCase("vaLUe");
        initialize(Raw.stringAssertion(), "luE").isPartOfIgnoreCase("vaLUe");
        initialize(Raw.stringAssertion(), "знАЧ").isPartOfIgnoreCase("зНАчеНИе");
        initialize(Raw.stringAssertion(), "Ен").isPartOfIgnoreCase("зНАчеНИе");
        initialize(Raw.stringAssertion(), "иЕ").isPartOfIgnoreCase("зНАчеНИе");
        initialize(Raw.stringAssertion(), "").isPartOfIgnoreCase("");

        try {
            Raw.stringAssertion().isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vaLUe").isPartOfIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vaLUe").isPartOfIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<> but was:<vaLUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "VAe").isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<VAe>");
        }
        try {
            initialize(Raw.stringAssertion(), "vUe").isPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<vaLUe> but was:<vUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "ЗАЧ").isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<ЗАЧ>");
        }
        try {
            initialize(Raw.stringAssertion(), "чача").isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<зНАчеНИе> but was:<чача>");
        }
        try {
            initialize(Raw.stringAssertion(), "\\w+").isPartOfIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<\\w+>");
        }
        try {
            initialize(Raw.stringAssertion(), ".+").isPartOfIgnoreCase("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the part of the expected value. Expected:<value> but was:<.+>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotPartOfTest() {
        initialize(Raw.stringAssertion(), "vae").isNotPartOf("value");
        initialize(Raw.stringAssertion(), "aLu").isNotPartOf("value");
        initialize(Raw.stringAssertion(), "vue").isNotPartOf("value");
        initialize(Raw.stringAssertion(), "знаач").isNotPartOf("значение");
        initialize(Raw.stringAssertion(), "еНИ").isNotPartOf("значение");
        initialize(Raw.stringAssertion(), "чие").isNotPartOf("значение");
        initialize(Raw.stringAssertion(), "чие").isNotPartOf("");

        try {
            Raw.stringAssertion().isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").isNotPartOf(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "").isNotPartOf("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>");
        }
        try {
            initialize(Raw.stringAssertion(), "val").isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<val>");
        }
        try {
            initialize(Raw.stringAssertion(), "lue").isNotPartOf("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<value> but was:<lue>");
        }
        try {
            initialize(Raw.stringAssertion(), "знач").isNotPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<знач>");
        }
        try {
            initialize(Raw.stringAssertion(), "ение").isNotPartOf("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<значение> but was:<ение>");
        }
        try {
            initialize(Raw.stringAssertion(), ".").isNotPartOf("...");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<...> but was:<.>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotPartOfIgnoreCaseTest() {
        initialize(Raw.stringAssertion(), "vAe").isNotPartOfIgnoreCase("vaLUe");
        initialize(Raw.stringAssertion(), "aLe").isNotPartOfIgnoreCase("vaLUe");
        initialize(Raw.stringAssertion(), "vuE").isNotPartOfIgnoreCase("vaLUe");
        initialize(Raw.stringAssertion(), "знААч").isNotPartOfIgnoreCase("знАченИе");
        initialize(Raw.stringAssertion(), "еНе").isNotPartOfIgnoreCase("знАченИе");
        initialize(Raw.stringAssertion(), "чИЕ").isNotPartOfIgnoreCase("знАченИе");
        initialize(Raw.stringAssertion(), "чИЕ").isNotPartOfIgnoreCase("");

        try {
            Raw.stringAssertion().isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vaLUe").isNotPartOfIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "").isNotPartOfIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<> but was:<>");
        }
        try {
            initialize(Raw.stringAssertion(), "VAL").isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<VAL>");
        }
        try {
            initialize(Raw.stringAssertion(), "LuE").isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<vaLUe> but was:<LuE>");
        }
        try {
            initialize(Raw.stringAssertion(), "зНАч").isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<зНАч>");
        }
        try {
            initialize(Raw.stringAssertion(), "ЕниЕ").isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<знАченИе> but was:<ЕниЕ>");
        }
        try {
            initialize(Raw.stringAssertion(), ".").isNotPartOfIgnoreCase("...");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the part of the expected value. Expected:<...> but was:<.>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void matchesTest() {
        initialize(Raw.stringAssertion(), "value").matches("v.*e");
        initialize(Raw.stringAssertion(), "value").matches("v[aA].{2}[eE]");
        initialize(Raw.stringAssertion(), "value").matches("\\w+");
        initialize(Raw.stringAssertion(), "value").matches("\\w{4,6}");
        initialize(Raw.stringAssertion(), "значение").matches("\\p{L}+");
        initialize(Raw.stringAssertion(), "").matches("");

        try {
            Raw.stringAssertion().matches("v.*e");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).matches("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").matches(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").matches("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").matches("\\d+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the expected value. Expected:<\\d+> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").matches("\\w+");
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
        initialize(Raw.stringAssertion(), "value").doesNotMatch("valu.+e");
        initialize(Raw.stringAssertion(), "value").doesNotMatch("v[zZ].{2}[eE]");
        initialize(Raw.stringAssertion(), "value").doesNotMatch("\\s\\w+");
        initialize(Raw.stringAssertion(), "value").doesNotMatch("\\w{8}");
        initialize(Raw.stringAssertion(), "значение").doesNotMatch("\\w+");
        initialize(Raw.stringAssertion(), "значение").doesNotMatch("");

        try {
            Raw.stringAssertion().doesNotMatch("valu.+e");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).doesNotMatch("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotMatch(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "").doesNotMatch("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<> but was:<>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotMatch("\\w+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not match the expected value. Expected:<\\w+> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").doesNotMatch("\\p{L}{8}");
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
        initialize(Raw.stringAssertion(), "value").startsWith("va");
        initialize(Raw.stringAssertion(), "value").startsWith("val");
        initialize(Raw.stringAssertion(), "value").startsWith("value");
        initialize(Raw.stringAssertion(), "значение").startsWith("зна");
        initialize(Raw.stringAssertion(), "значение").startsWith("значе");
        initialize(Raw.stringAssertion(), "значение").startsWith("значение");

        try {
            Raw.stringAssertion().startsWith("va");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).startsWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").startsWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").startsWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").startsWith("lue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lue> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").startsWith("Val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Val> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").startsWith("ачен");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<ачен> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").startsWith("Знач");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Знач> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").startsWith("va?");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<va?> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").startsWith(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void startsWithIgnoreCaseTest() {
        initialize(Raw.stringAssertion(), "vAlUe").startsWithIgnoreCase("vA");
        initialize(Raw.stringAssertion(), "vAlUe").startsWithIgnoreCase("VAl");
        initialize(Raw.stringAssertion(), "vAlUe").startsWithIgnoreCase("vaLUe");
        initialize(Raw.stringAssertion(), "знАчЕнИе").startsWithIgnoreCase("зНа");
        initialize(Raw.stringAssertion(), "знАчЕнИе").startsWithIgnoreCase("зНаче");
        initialize(Raw.stringAssertion(), "знАчЕнИе").startsWithIgnoreCase("зНачение");

        try {
            Raw.stringAssertion().startsWithIgnoreCase("vA");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).startsWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").startsWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").startsWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").startsWithIgnoreCase("lUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<lUe> but was:<vAlUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").startsWithIgnoreCase("Vau");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Vau> but was:<vAlUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАчЕнИе").startsWithIgnoreCase("аЧен");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<аЧен> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАчЕнИе").startsWithIgnoreCase("Значи");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<Значи> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").startsWithIgnoreCase("va?");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<va?> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").startsWithIgnoreCase(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should start with the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotStartWithTest() {
        initialize(Raw.stringAssertion(), "value").doesNotStartWith("VA");
        initialize(Raw.stringAssertion(), "value").doesNotStartWith("VaL");
        initialize(Raw.stringAssertion(), "value").doesNotStartWith("vale");
        initialize(Raw.stringAssertion(), "значение").doesNotStartWith("ЗНА");
        initialize(Raw.stringAssertion(), "значение").doesNotStartWith("Знач");
        initialize(Raw.stringAssertion(), "значение").doesNotStartWith("чение");

        try {
            Raw.stringAssertion().doesNotStartWith("VA");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).doesNotStartWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotStartWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotStartWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotStartWith("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotStartWith("valu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").doesNotStartWith("зн");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").doesNotStartWith("значен");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значен> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "...").doesNotStartWith(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotStartWithIgnoreCaseTest() {
        initialize(Raw.stringAssertion(), "vAlUe").doesNotStartWithIgnoreCase("Vu");
        initialize(Raw.stringAssertion(), "vAlUe").doesNotStartWithIgnoreCase("Vue");
        initialize(Raw.stringAssertion(), "vAlUe").doesNotStartWithIgnoreCase("ale");
        initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("НА");
        initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("Знч");
        initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("чние");

        try {
            Raw.stringAssertion().doesNotStartWithIgnoreCase("Vu");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).doesNotStartWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").doesNotStartWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").doesNotStartWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").doesNotStartWithIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<val> but was:<vAlUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").doesNotStartWithIgnoreCase("VALUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<VALUe> but was:<vAlUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("зн");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<зн> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<значение> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "...").doesNotStartWithIgnoreCase(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not start with the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void endsWithTest() {
        initialize(Raw.stringAssertion(), "value").endsWith("alue");
        initialize(Raw.stringAssertion(), "value").endsWith("lue");
        initialize(Raw.stringAssertion(), "value").endsWith("ue");
        initialize(Raw.stringAssertion(), "значение").endsWith("ачение");
        initialize(Raw.stringAssertion(), "значение").endsWith("ние");
        initialize(Raw.stringAssertion(), "значение").endsWith("е");

        try {
            Raw.stringAssertion().endsWith("alue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).endsWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").endsWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").endsWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").endsWith("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").endsWith("LuE");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<LuE> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").endsWith("значе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<значе> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").endsWith("ЧенИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ЧенИе> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").endsWith("ue?");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ue?> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").endsWith(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void endsWithIgnoreCaseTest() {
        initialize(Raw.stringAssertion(), "vAlUe").endsWithIgnoreCase("vaLue");
        initialize(Raw.stringAssertion(), "vAlUe").endsWithIgnoreCase("Lue");
        initialize(Raw.stringAssertion(), "vAlUe").endsWithIgnoreCase("E");
        initialize(Raw.stringAssertion(), "знАчЕнИе").endsWithIgnoreCase("значеНИЕ");
        initialize(Raw.stringAssertion(), "знАчЕнИе").endsWithIgnoreCase("чеНИЕ");
        initialize(Raw.stringAssertion(), "знАчЕнИе").endsWithIgnoreCase("Е");
        initialize(Raw.stringAssertion(), "aaaxxxxx").endsWithIgnoreCase("xxx");

        try {
            Raw.stringAssertion().endsWithIgnoreCase("vaLue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).endsWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").endsWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").endsWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").endsWithIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<vAlUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").endsWithIgnoreCase("vUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<vUe> but was:<vAlUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "").endsWithIgnoreCase("val");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<val> but was:<>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАчЕнИе").endsWithIgnoreCase("знАчЕ");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАчЕ> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАчЕнИе").endsWithIgnoreCase("знАИе");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<знАИе> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").endsWithIgnoreCase("ue?");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<ue?> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").endsWithIgnoreCase(".+");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should end with the expected value. Expected:<.+> but was:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotEndWithTest() {
        initialize(Raw.stringAssertion(), "value").doesNotEndWith("aLue");
        initialize(Raw.stringAssertion(), "value").doesNotEndWith("vue");
        initialize(Raw.stringAssertion(), "value").doesNotEndWith("val");
        initialize(Raw.stringAssertion(), "значение").doesNotEndWith("ачЕниЕ");
        initialize(Raw.stringAssertion(), "значение").doesNotEndWith("зние");
        initialize(Raw.stringAssertion(), "значение").doesNotEndWith("зна");

        try {
            Raw.stringAssertion().doesNotEndWith("aLue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).doesNotEndWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotEndWith(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotEndWith("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotEndWith("value");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<value> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value").doesNotEndWith("alue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<alue> but was:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").doesNotEndWith("значение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<значение> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "значение").doesNotEndWith("ие");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<ие> but was:<значение>");
        }
        try {
            initialize(Raw.stringAssertion(), "...").doesNotEndWith(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void doesNotEndWithIgnoreCaseTest() {
        initialize(Raw.stringAssertion(), "vAlUe").doesNotEndWithIgnoreCase("aLe");
        initialize(Raw.stringAssertion(), "vAlUe").doesNotEndWithIgnoreCase("vue");
        initialize(Raw.stringAssertion(), "vAlUe").doesNotEndWithIgnoreCase("val");
        initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("зачЕниЕ");
        initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("зние");
        initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("зна");
        initialize(Raw.stringAssertion(), "").doesNotEndWithIgnoreCase("val");

        try {
            Raw.stringAssertion().doesNotEndWithIgnoreCase("aLe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).doesNotEndWithIgnoreCase("vAlUe");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").doesNotEndWithIgnoreCase(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").doesNotEndWithIgnoreCase("");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").doesNotEndWithIgnoreCase("vaLue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<vaLue> but was:<vAlUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").doesNotEndWithIgnoreCase("aLue");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<aLue> but was:<vAlUe>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("знАчение");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<знАчение> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("е");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<е> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.stringAssertion(), "aaaxxxxx").doesNotEndWithIgnoreCase("xxx");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<xxx> but was:<aaaxxxxx>");
        }
        try {
            initialize(Raw.stringAssertion(), "...").doesNotEndWithIgnoreCase(".");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not end with the expected value. Expected:<.> but was:<...>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.stringAssertion(), "vAlUe").toLength().isEqualTo(5);
        initialize(Raw.stringAssertion(), "vAlUe").toLength().isGreaterThan(3);
        initialize(Raw.stringAssertion(), "vAlUe").toLength().isLessThan(7);

        initialize(Raw.stringAssertion(), "знАчЕнИе").toLength().isEqualTo(8);
        initialize(Raw.stringAssertion(), "знАчЕнИе").toLength().isGreaterThan(5);
        initialize(Raw.stringAssertion(), "знАчЕнИе").toLength().isLessThan(10);

        try {
            Raw.stringAssertion().toLength();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).toLength();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").toLength();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe").toLength().isEqualTo(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's length. Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe", "Message").toLength().isEqualTo(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's length. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.stringAssertion(), "vAlUe").hasLength(5);
        initialize(Raw.stringAssertion(), "знАчЕнИе").hasLength(8);

        try {
            initialize(Raw.stringAssertion(), "vAlUe").hasLength(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's length. Values should be the same. Expected:<6> but was:<5>");
        }
        try {
            initialize(Raw.stringAssertion(), "vAlUe", "Message").hasLength(6);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's length. Values should be the same. Expected:<6> but was:<5>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void toTokensDefaultTest() {
        initialize(Raw.stringAssertion(), "value1 value2 value3").toTokens().containsAll("value1", "value2", "value3");
        initialize(Raw.stringAssertion(), "value1|value2|value3").toTokens().containsAll("value1|value2|value3");

        try {
            Raw.stringAssertion().toTokens();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).toTokens();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").toTokens();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value1 value2 value3").toTokens().hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.stringAssertion(), "value1 value2 value3", "Message").toTokens().hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void toTokensSpecifiedTest() {
        initialize(Raw.stringAssertion(), "value1 value2 value3").toTokens("|").containsAll("value1 value2 value3");
        initialize(Raw.stringAssertion(), "value1|value2|value3").toTokens("|").containsAll("value1", "value2", "value3");

        try {
            Raw.stringAssertion().toTokens("|");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).toTokens("|");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").toTokens("|");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null).toTokens(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").toTokens(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value1|value2|value3").toTokens(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value1|value2|value3", "Message").toTokens(null);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value1|value2|value3").toTokens("|").hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.stringAssertion(), "value1|value2|value3", "Message").toTokens("|").hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void toTokensWithDelimitersTest() {
        initialize(Raw.stringAssertion(), "value1 value2 value3").toTokens("|", false).containsAll("value1 value2 value3");
        initialize(Raw.stringAssertion(), "value1 value2 value3").toTokens("|", true).containsAll("value1 value2 value3");
        initialize(Raw.stringAssertion(), "value1|value2|value3").toTokens("|", false).containsAll("value1", "value2", "value3");
        initialize(Raw.stringAssertion(), "value1|value2|value3").toTokens("|", true).containsAll("value1", "value2", "value3", "|", "|");

        try {
            Raw.stringAssertion().toTokens("|", false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.stringAssertion(), null).toTokens("|", false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").toTokens("|", false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null).toTokens(null, false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), null, "Message").toTokens(null, false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value1|value2|value3").toTokens(null, false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value1|value2|value3", "Message").toTokens(null, false);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.stringAssertion(), "value1|value2|value3").toTokens("|", true).hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<5>");
        }
        try {
            initialize(Raw.stringAssertion(), "value1|value2|value3", "Message").toTokens("|", true).hasSize(4);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's tokens. Check value's size. Values should be the same. Expected:<4> but was:<5>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.stringAssertion(), null).isNull();

        try {
            initialize(Raw.stringAssertion(), "value").isNull();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<value>");
        }
        try {
            initialize(Raw.stringAssertion(), "value", "Message").isNull();
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<value>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        String value = "value1";
        initialize(Raw.stringAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.stringAssertion(), value).isSameAs("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.stringAssertion(), value, "Message").isSameAs("value2");
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<value2> but was:<value1>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        String value = "value1";
        initialize(Raw.stringAssertion(), value).isNotSameAs("value2");

        try {
            initialize(Raw.stringAssertion(), value).isNotSameAs(value);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value1>");
        }
        try {
            initialize(Raw.stringAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("StringAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<value1>");
        }
    }

    /**
     * {@link StringAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.stringAssertion(), "vAlUe").asString(null));
            Assertions.fail("StringAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.stringAssertion(), "vAlUe").asString("vAlUe")).isEqualTo("vAlUe");
        Assertions.assertThat(initialize(Raw.stringAssertion(), "vAlUe").asString("знАчЕнИе")).isEqualTo("знАчЕнИе");
        Assertions.assertThat(initialize(Raw.stringAssertion(), "vAlUe").asString(1)).isEqualTo("1");
    }

}
