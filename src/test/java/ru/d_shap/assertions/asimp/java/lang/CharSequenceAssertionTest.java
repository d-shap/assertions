///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.asimp.java.lang;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
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
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.charSequenceAssertion(), new Object(), "Message");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.charSequenceAssertion(), "").isEmpty();
        initialize(Raw.charSequenceAssertion(), "").isNotNull().isEmpty().isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ", "Message").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.charSequenceAssertion(), null).isNullOrEmpty();
        initialize(Raw.charSequenceAssertion(), "").isNullOrEmpty();
        initialize(Raw.charSequenceAssertion(), "").isNotNull().isNullOrEmpty().isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ", "Message").isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNullOrEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.charSequenceAssertion(), " ").isNotEmpty();
        initialize(Raw.charSequenceAssertion(), "value").isNotEmpty();
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isNotEmpty().isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotEmpty();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
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
        initialize(Raw.charSequenceAssertion(), "   \t   \t").isNotNull().isBlank().isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "v   ").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be blank.\n\tActual:<v   >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "v   ", "Message").isBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be blank.\n\tActual:<v   >");
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
        initialize(Raw.charSequenceAssertion(), "   \t   \t").isNotNull().isNullOrBlank().isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should be null or blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "v   ").isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or blank.\n\tActual:<v   >");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "v   ", "Message").isNullOrBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or blank.\n\tActual:<v   >");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotBlankTest() {
        initialize(Raw.charSequenceAssertion(), "value").isNotBlank();
        initialize(Raw.charSequenceAssertion(), "v   ").isNotBlank();
        initialize(Raw.charSequenceAssertion(), "v   ").isNotNull().isNotBlank().isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), " ", "Message").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "\t").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "\t", "Message").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "   \t   \t").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be blank.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "   \t   \t", "Message").isNotBlank();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be blank.");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.charSequenceAssertion(), null).isEqualTo(null);
        initialize(Raw.charSequenceAssertion(), "value").isEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isEqualTo("ЗНАЧЕНИЕ");
        initialize(Raw.charSequenceAssertion(), "значение").isEqualTo("значение");
        initialize(Raw.charSequenceAssertion(), "value's").isEqualTo("value's");
        initialize(Raw.charSequenceAssertion(), "").isEqualTo("");
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isEqualTo("value").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualTo("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1").isEqualTo("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").isEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<ЗНАЧЕНИЕ> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value's").isEqualTo("values");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<values> but was:<value's>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "values").isEqualTo("value's");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<value's> but was:<values>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isEqualTo("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<значение> but was:<ЗНАЧЕНИЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ", "Message").isEqualTo("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<значение> but was:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEqualToMutationTest() {
        try {
            initialize(Raw.charSequenceAssertion(), "value1").isEqualTo("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualToIgnoreCase("Actual and expected values should be the same.\n\tExpected:<value2> but was:<value1>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isEqualToIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), null).isEqualToIgnoreCase(null);
        initialize(Raw.charSequenceAssertion(), "valUe").isEqualToIgnoreCase("vALue");
        initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isEqualToIgnoreCase("значение");
        initialize(Raw.charSequenceAssertion(), "значение").isEqualToIgnoreCase("ЗНАЧЕНИЕ");
        initialize(Raw.charSequenceAssertion(), "valUe's").isEqualToIgnoreCase("vALue's");
        initialize(Raw.charSequenceAssertion(), "").isEqualToIgnoreCase("");
        initialize(Raw.charSequenceAssertion(), "valUe").isNotNull().isEqualToIgnoreCase("vALue").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vALue").isEqualToIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same ignoring case.\n\tExpected:<> but was:<vALue>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1").isEqualToIgnoreCase("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same ignoring case.\n\tExpected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualToIgnoreCase("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same ignoring case.\n\tExpected:<ЗНАЧЕНИЕ> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isEqualToIgnoreCase("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same ignoring case.\n\tExpected:<значение> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "valUe's").isEqualToIgnoreCase("vALues");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same ignoring case.\n\tExpected:<vALues> but was:<valUe's>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "valUes").isEqualToIgnoreCase("vALue's");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same ignoring case.\n\tExpected:<vALue's> but was:<valUes>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗнаЧеНИЕ").isEqualToIgnoreCase("vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same ignoring case.\n\tExpected:<vaLUE> but was:<ЗнаЧеНИЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗнаЧеНИЕ", "Message").isEqualToIgnoreCase("vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same ignoring case.\n\tExpected:<vaLUE> but was:<ЗнаЧеНИЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.charSequenceAssertion(), null).isNotEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "value").isNotEqualTo(null);
        initialize(Raw.charSequenceAssertion(), "value").isNotEqualTo("значение");
        initialize(Raw.charSequenceAssertion(), "value").isNotEqualTo("ЗНАЧЕНИЕ");
        initialize(Raw.charSequenceAssertion(), "значение").isNotEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isNotEqualTo("value");
        initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isNotEqualTo("");
        initialize(Raw.charSequenceAssertion(), "value's").isNotEqualTo("values");
        initialize(Raw.charSequenceAssertion(), "values").isNotEqualTo("value's");
        initialize(Raw.charSequenceAssertion(), "value's").isNotNull().isNotEqualTo("values").isInstanceOf(String.class);

        try {
            Raw.charSequenceAssertion().isNotEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotEqualTo("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value's").isNotEqualTo("value's");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<value's>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").isNotEqualTo("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ").isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<ЗНАЧЕНИЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНАЧЕНИЕ", "Message").isNotEqualTo("ЗНАЧЕНИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<ЗНАЧЕНИЕ>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void isNotEqualToIgnoreCaseTest() {
        initialize(Raw.charSequenceAssertion(), null).isNotEqualToIgnoreCase("value");
        initialize(Raw.charSequenceAssertion(), "value").isNotEqualToIgnoreCase(null);
        initialize(Raw.charSequenceAssertion(), "vaLUe").isNotEqualToIgnoreCase("знАЧенИЕ");
        initialize(Raw.charSequenceAssertion(), "VAluE").isNotEqualToIgnoreCase("ЗНачЕНие");
        initialize(Raw.charSequenceAssertion(), "знАЧенИЕ").isNotEqualToIgnoreCase("vaLUe");
        initialize(Raw.charSequenceAssertion(), "ЗНачЕНие").isNotEqualToIgnoreCase("VAluE");
        initialize(Raw.charSequenceAssertion(), "ЗНачЕНие").isNotEqualToIgnoreCase("");
        initialize(Raw.charSequenceAssertion(), "vaLUe's").isNotEqualToIgnoreCase("VAluEs");
        initialize(Raw.charSequenceAssertion(), "vaLUes").isNotEqualToIgnoreCase("VAluE's");
        initialize(Raw.charSequenceAssertion(), "vaLUe's").isNotNull().isNotEqualToIgnoreCase("VAluEs").isInstanceOf(String.class);

        try {
            Raw.charSequenceAssertion().isNotEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotEqualToIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different ignoring case.\n\tActual:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different ignoring case.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value's").isNotEqualToIgnoreCase("value's");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different ignoring case.\n\tActual:<value's>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАЧенИЕ").isNotEqualToIgnoreCase("ЗНачЕНие");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different ignoring case.\n\tActual:<знАЧенИЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНачЕНие").isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different ignoring case.\n\tActual:<ЗНачЕНие>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗНачЕНие", "Message").isNotEqualToIgnoreCase("знАЧенИЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different ignoring case.\n\tActual:<ЗНачЕНие>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isGreaterThan("XYZ").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isGreaterThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isGreaterThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isGreaterThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isGreaterThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThan("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<x> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThan("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<x> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isGreaterThanIgnoreCase("vAlUazzz").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isGreaterThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isGreaterThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isGreaterThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isGreaterThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected ignoring case.\n\tExpected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("VALUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected ignoring case.\n\tExpected:<VALUE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("XYZ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected ignoring case.\n\tExpected:<XYZ> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected ignoring case.\n\tExpected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected ignoring case.\n\tExpected:<x> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected ignoring case.\n\tExpected:<x> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isGreaterThanOrEqualTo("aaa").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isGreaterThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualTo("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<x> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanOrEqualTo("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<x> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isGreaterThanOrEqualToIgnoreCase("aaa").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isGreaterThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("XYZ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected ignoring case.\n\tExpected:<XYZ> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected ignoring case.\n\tExpected:<valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isGreaterThanOrEqualToIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected ignoring case.\n\tExpected:<x> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isGreaterThanOrEqualToIgnoreCase("x");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected ignoring case.\n\tExpected:<x> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "XYZ").isNotNull().isLessThan("value").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isLessThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isLessThan(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isLessThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isLessThan("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThan("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThan("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThan("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<c> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThan("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<c> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "vAlUe").isNotNull().isLessThanIgnoreCase("valuezzz").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isLessThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isLessThanIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isLessThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isLessThanIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected ignoring case.\n\tExpected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VALUE").isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected ignoring case.\n\tExpected:<value> but was:<VALUE>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "XYZ").isLessThanIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected ignoring case.\n\tExpected:<value> but was:<XYZ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected ignoring case.\n\tExpected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected ignoring case.\n\tExpected:<c> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected ignoring case.\n\tExpected:<c> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isLessThanOrEqualTo("yyy").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanOrEqualTo("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isLessThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isLessThanOrEqualTo(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualTo("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<c> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanOrEqualTo("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<c> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isLessThanOrEqualToIgnoreCase("yyy").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isLessThanOrEqualToIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected ignoring case.\n\tExpected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "XYZ").isLessThanOrEqualToIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected ignoring case.\n\tExpected:<value> but was:<XYZ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected ignoring case.\n\tExpected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isLessThanOrEqualToIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected ignoring case.\n\tExpected:<c> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isLessThanOrEqualToIgnoreCase("c");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected ignoring case.\n\tExpected:<c> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isInRange("v", "valuex").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isInRange(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isInRange(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expectedTo.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expectedTo.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("A", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<A:Z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("a", "test");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<a:test> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("A", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<A:value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("A", "vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<A:vaLUE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRange("xxx", "yyy");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<xxx:yyy> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRange("xxx", "yyy");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<xxx:yyy> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isInRangeIgnoreCase("v", "valuex").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isInRangeIgnoreCase(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isInRangeIgnoreCase(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expectedTo.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expectedTo.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("a", "test");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range ignoring case.\n\tExpected:<a:test> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("A", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range ignoring case.\n\tExpected:<A:value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("A", "vaLUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range ignoring case.\n\tExpected:<A:vaLUE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("xxx", "yyy");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range ignoring case.\n\tExpected:<xxx:yyy> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isInRangeIgnoreCase("XXX", "YYY");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range ignoring case.\n\tExpected:<XXX:YYY> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isInRangeIgnoreCase("XXX", "YYY");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range ignoring case.\n\tExpected:<XXX:YYY> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isNotInRange("A", "Z").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRange("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotInRange(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotInRange(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotInRange(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotInRange("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expectedTo.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotInRange("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expectedTo.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("v", "valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<v:valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("a", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<a:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("A", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<A:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("value", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<value:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRange("VALUE", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<VALUE:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRange("VALUE", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<VALUE:z> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().isNotInRangeIgnoreCase("a", "test").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRangeIgnoreCase("value", "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotInRangeIgnoreCase(null, "value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotInRangeIgnoreCase(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotInRangeIgnoreCase(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotInRangeIgnoreCase("value", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expectedTo.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotInRangeIgnoreCase("value", "");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expectedTo.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("A", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range ignoring case.\n\tExpected:<A:Z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("v", "valuea");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range ignoring case.\n\tExpected:<v:valuea> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("a", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range ignoring case.\n\tExpected:<a:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("A", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range ignoring case.\n\tExpected:<A:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("value", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range ignoring case.\n\tExpected:<value:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("VALUE", "z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range ignoring case.\n\tExpected:<VALUE:z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isNotInRangeIgnoreCase("VALUE", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range ignoring case.\n\tExpected:<VALUE:Z> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNotInRangeIgnoreCase("VALUE", "Z");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range ignoring case.\n\tExpected:<VALUE:Z> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().contains("val").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").contains("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).contains(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").contains(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").contains(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").contains(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").contains("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").contains("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains("VAL");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<VAL> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains("v.*ue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<v.*ue> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains("знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<знач> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").contains("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<value> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<\\w+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").contains(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").contains(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<.+> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().containsIgnoreCase("VAL").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").containsIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).containsIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").containsIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").containsIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").containsIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").containsIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").containsIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").containsIgnoreCase("VAE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value ignoring case.\n\tExpected:<VAE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").containsIgnoreCase("v.*ue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value ignoring case.\n\tExpected:<v.*ue> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLue").containsIgnoreCase("зНАч");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value ignoring case.\n\tExpected:<зНАч> but was:<vaLue>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАЧЕние").containsIgnoreCase("valUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value ignoring case.\n\tExpected:<valUE> but was:<знАЧЕние>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").containsIgnoreCase("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value ignoring case.\n\tExpected:<\\w+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").containsIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value ignoring case.\n\tExpected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").containsIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value ignoring case.\n\tExpected:<.+> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().doesNotContain("vaue").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotContain("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotContain(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotContain(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotContain(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotContain(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotContain("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotContain("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotContain("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<val> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotContain("alu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<alu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotContain("lue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<lue> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotContain("знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<знач> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotContain("ение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<ение> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotContain(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotContain(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<.> but was:<...>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().doesNotContainIgnoreCase("vaUE").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotContainIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotContainIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotContainIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotContainIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotContainIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotContainIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotContainIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").doesNotContainIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value ignoring case.\n\tExpected:<val> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").doesNotContainIgnoreCase("VAL");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value ignoring case.\n\tExpected:<VAL> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").doesNotContainIgnoreCase("lUE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value ignoring case.\n\tExpected:<lUE> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "зНАчеНИе").doesNotContainIgnoreCase("знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value ignoring case.\n\tExpected:<знач> but was:<зНАчеНИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "зНАчеНИе").doesNotContainIgnoreCase("еНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value ignoring case.\n\tExpected:<еНИе> but was:<зНАчеНИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotContainIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value ignoring case.\n\tExpected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotContainIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value ignoring case.\n\tExpected:<.> but was:<...>");
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
        initialize(Raw.charSequenceAssertion(), "val").isNotNull().isPartOf("value").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").isPartOf("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value.\n\tExpected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAL").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value.\n\tExpected:<value> but was:<VAL>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vue").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value.\n\tExpected:<value> but was:<vue>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗнАЧ").isPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value.\n\tExpected:<значение> but was:<ЗнАЧ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "чача").isPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value.\n\tExpected:<значение> but was:<чача>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "\\w+").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value.\n\tExpected:<value> but was:<\\w+>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".+").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value.\n\tExpected:<value> but was:<.+>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".+", "Message").isPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the part of the expected value.\n\tExpected:<value> but was:<.+>");
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
        initialize(Raw.charSequenceAssertion(), "vAl").isNotNull().isPartOfIgnoreCase("vaLUe").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vaLUe").isPartOfIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value ignoring case.\n\tExpected:<> but was:<vaLUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAe").isPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value ignoring case.\n\tExpected:<vaLUe> but was:<VAe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vUe").isPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value ignoring case.\n\tExpected:<vaLUe> but was:<vUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЗАЧ").isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value ignoring case.\n\tExpected:<зНАчеНИе> but was:<ЗАЧ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "чача").isPartOfIgnoreCase("зНАчеНИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value ignoring case.\n\tExpected:<зНАчеНИе> but was:<чача>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "\\w+").isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value ignoring case.\n\tExpected:<value> but was:<\\w+>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".+").isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the part of the expected value ignoring case.\n\tExpected:<value> but was:<.+>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".+", "Message").isPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the part of the expected value ignoring case.\n\tExpected:<value> but was:<.+>");
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
        initialize(Raw.charSequenceAssertion(), "vae").isNotNull().isNotPartOf("value").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotPartOf(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotPartOf("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value.\n\tExpected:<> but was:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "val").isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value.\n\tExpected:<value> but was:<val>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "lue").isNotPartOf("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value.\n\tExpected:<value> but was:<lue>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знач").isNotPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value.\n\tExpected:<значение> but was:<знач>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ение").isNotPartOf("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value.\n\tExpected:<значение> but was:<ение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".").isNotPartOf("...");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value.\n\tExpected:<...> but was:<.>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".", "Message").isNotPartOf("...");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the part of the expected value.\n\tExpected:<...> but was:<.>");
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
        initialize(Raw.charSequenceAssertion(), "vAe").isNotNull().isNotPartOfIgnoreCase("vaLUe").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotPartOfIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).isNotPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").isNotPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").isNotPartOfIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").isNotPartOfIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value ignoring case.\n\tExpected:<> but was:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "VAL").isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value ignoring case.\n\tExpected:<vaLUe> but was:<VAL>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "LuE").isNotPartOfIgnoreCase("vaLUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value ignoring case.\n\tExpected:<vaLUe> but was:<LuE>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "зНАч").isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value ignoring case.\n\tExpected:<знАченИе> but was:<зНАч>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "ЕниЕ").isNotPartOfIgnoreCase("знАченИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value ignoring case.\n\tExpected:<знАченИе> but was:<ЕниЕ>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".").isNotPartOfIgnoreCase("...");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the part of the expected value ignoring case.\n\tExpected:<...> but was:<.>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), ".", "Message").isNotPartOfIgnoreCase("...");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the part of the expected value ignoring case.\n\tExpected:<...> but was:<.>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().matches("v.*e").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").matches("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).matches(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").matches(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").matches(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").matches(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").matches("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the expected value.\n\tExpected:<> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").matches("\\d+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the expected value.\n\tExpected:<\\d+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").matches("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the expected value.\n\tExpected:<\\w+> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение", "Message").matches("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the expected value.\n\tExpected:<\\w+> but was:<значение>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().doesNotMatch("valu.+e").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotMatch("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotMatch(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotMatch(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotMatch(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotMatch(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotMatch("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not match the expected value.\n\tExpected:<> but was:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotMatch("\\w+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not match the expected value.\n\tExpected:<\\w+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotMatch("\\p{L}{8}");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not match the expected value.\n\tExpected:<\\p{L}{8}> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение", "Message").doesNotMatch("\\p{L}{8}");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not match the expected value.\n\tExpected:<\\p{L}{8}> but was:<значение>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().startsWith("va").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").startsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).startsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").startsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").startsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").startsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").startsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").startsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith("lue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value.\n\tExpected:<lue> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith("Val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value.\n\tExpected:<Val> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").startsWith("ачен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value.\n\tExpected:<ачен> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").startsWith("Знач");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value.\n\tExpected:<Знач> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith("va?");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value.\n\tExpected:<va?> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWith(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value.\n\tExpected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").startsWith(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should start with the expected value.\n\tExpected:<.+> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "vAlUe").isNotNull().startsWithIgnoreCase("vA").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").startsWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).startsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").startsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").startsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").startsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").startsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").startsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").startsWithIgnoreCase("lUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value ignoring case.\n\tExpected:<lUe> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").startsWithIgnoreCase("Vau");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value ignoring case.\n\tExpected:<Vau> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").startsWithIgnoreCase("аЧен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value ignoring case.\n\tExpected:<аЧен> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").startsWithIgnoreCase("Значи");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value ignoring case.\n\tExpected:<Значи> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWithIgnoreCase("va?");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value ignoring case.\n\tExpected:<va?> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").startsWithIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should start with the expected value ignoring case.\n\tExpected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").startsWithIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should start with the expected value ignoring case.\n\tExpected:<.+> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().doesNotStartWith("VA").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotStartWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotStartWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotStartWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotStartWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotStartWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotStartWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotStartWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotStartWith("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value.\n\tExpected:<val> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotStartWith("valu");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value.\n\tExpected:<valu> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotStartWith("зн");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value.\n\tExpected:<зн> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotStartWith("значен");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value.\n\tExpected:<значен> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotStartWith(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value.\n\tExpected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotStartWith(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not start with the expected value.\n\tExpected:<.> but was:<...>");
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
        initialize(Raw.charSequenceAssertion(), "vAlUe").isNotNull().doesNotStartWithIgnoreCase("Vu").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotStartWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotStartWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotStartWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotStartWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotStartWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotStartWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotStartWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotStartWithIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value ignoring case.\n\tExpected:<val> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotStartWithIgnoreCase("VALUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value ignoring case.\n\tExpected:<VALUe> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("зн");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value ignoring case.\n\tExpected:<зн> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotStartWithIgnoreCase("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value ignoring case.\n\tExpected:<значение> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotStartWithIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not start with the expected value ignoring case.\n\tExpected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotStartWithIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not start with the expected value ignoring case.\n\tExpected:<.> but was:<...>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().endsWith("alue").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").endsWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).endsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").endsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").endsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").endsWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").endsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").endsWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value.\n\tExpected:<val> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith("LuE");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value.\n\tExpected:<LuE> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").endsWith("значе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value.\n\tExpected:<значе> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").endsWith("ЧенИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value.\n\tExpected:<ЧенИе> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith("ue?");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value.\n\tExpected:<ue?> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWith(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value.\n\tExpected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").endsWith(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should end with the expected value.\n\tExpected:<.+> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "vAlUe").isNotNull().endsWithIgnoreCase("vaLue").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").endsWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).endsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").endsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").endsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").endsWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").endsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").endsWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").endsWithIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value ignoring case.\n\tExpected:<val> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").endsWithIgnoreCase("vUe");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value ignoring case.\n\tExpected:<vUe> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").endsWithIgnoreCase("val");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value ignoring case.\n\tExpected:<val> but was:<>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").endsWithIgnoreCase("знАчЕ");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value ignoring case.\n\tExpected:<знАчЕ> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").endsWithIgnoreCase("знАИе");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value ignoring case.\n\tExpected:<знАИе> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWithIgnoreCase("ue?");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value ignoring case.\n\tExpected:<ue?> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").endsWithIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should end with the expected value ignoring case.\n\tExpected:<.+> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").endsWithIgnoreCase(".+");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should end with the expected value ignoring case.\n\tExpected:<.+> but was:<value>");
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
        initialize(Raw.charSequenceAssertion(), "value").isNotNull().doesNotEndWith("aLue").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotEndWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotEndWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotEndWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotEndWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotEndWith(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotEndWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotEndWith("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotEndWith("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value.\n\tExpected:<value> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value").doesNotEndWith("alue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value.\n\tExpected:<alue> but was:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotEndWith("значение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value.\n\tExpected:<значение> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "значение").doesNotEndWith("ие");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value.\n\tExpected:<ие> but was:<значение>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotEndWith(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value.\n\tExpected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotEndWith(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not end with the expected value.\n\tExpected:<.> but was:<...>");
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
        initialize(Raw.charSequenceAssertion(), "vAlUe").isNotNull().doesNotEndWithIgnoreCase("aLe").isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotEndWithIgnoreCase("value");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).doesNotEndWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").doesNotEndWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotEndWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotEndWithIgnoreCase(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").doesNotEndWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").doesNotEndWithIgnoreCase("");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotEndWithIgnoreCase("vaLue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value ignoring case.\n\tExpected:<vaLue> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").doesNotEndWithIgnoreCase("aLue");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value ignoring case.\n\tExpected:<aLue> but was:<vAlUe>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("знАчение");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value ignoring case.\n\tExpected:<знАчение> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "знАчЕнИе").doesNotEndWithIgnoreCase("е");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value ignoring case.\n\tExpected:<е> but was:<знАчЕнИе>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "aaaxxxxx").doesNotEndWithIgnoreCase("xxx");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value ignoring case.\n\tExpected:<xxx> but was:<aaaxxxxx>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...").doesNotEndWithIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not end with the expected value ignoring case.\n\tExpected:<.> but was:<...>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "...", "Message").doesNotEndWithIgnoreCase(".");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not end with the expected value ignoring case.\n\tExpected:<.> but was:<...>");
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

        initialize(Raw.charSequenceAssertion(), "vAlUe").isNotNull().toLength().isEqualTo(5);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toLength();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charSequenceAssertion(), "vAlUe").toLength()).isEqualTo(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").toLength()).isEqualTo(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").toLength().isEqualTo(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").toLength().isEqualTo(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.charSequenceAssertion(), "vAlUe").toLength(Matchers.is(Matchers.equalTo(5)));
        initialize(Raw.charSequenceAssertion(), "vAlUe").toLength(Matchers.is(Matchers.greaterThan(4)));
        initialize(Raw.charSequenceAssertion(), "vAlUe").toLength(Matchers.is(Matchers.lessThan(6)));

        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").toLength(Matchers.equalTo(8));
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").toLength(Matchers.greaterThan(7));
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").toLength(Matchers.lessThan(9));

        initialize(Raw.charSequenceAssertion(), "vAlUe").isNotNull().toLength(Matchers.is(Matchers.equalTo(5))).isInstanceOf(String.class);

        try {
            Raw.charSequenceAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toLength(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toLength(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toLength(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toLength(null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").toLength(Matchers.equalTo(6));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <6>\n     but: was <5>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").toLength(Matchers.equalTo(6));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <6>\n     but: was <5>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.charSequenceAssertion(), "vAlUe").hasLength(5);
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").hasLength(8);
        initialize(Raw.charSequenceAssertion(), "знАчЕнИе").isNotNull().hasLength(8).isInstanceOf(String.class);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").hasLength(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe").hasLength(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "vAlUe", "Message").hasLength(6);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensTest() {
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens().containsAll("value1", "value2", "value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens().containsAll("value1|value2|value3");
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").isNotNull().toTokens().containsAll("value1", "value2", "value3");

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens()).hasSize(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tokens.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charSequenceAssertion(), "value1 value2 value3", "Message").toTokens()).hasSize(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tokens.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens().hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tokens.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1 value2 value3", "Message").toTokens().hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tokens.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensSpecifiedTest() {
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("|").containsAll("value1 value2 value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|").containsAll("value1", "value2", "value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("").containsAll("value1|value2|value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").isNotNull().toTokens("|").containsAll("value1", "value2", "value3");

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens("|");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens((String) null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens((String) null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toTokens((String) null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toTokens((String) null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: delimiters.");
        }
        try {
            clearActual(initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|")).hasSize(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tokens.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens("|")).hasSize(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tokens.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|").hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tokens.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens("|").hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tokens.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensDelimitersTest() {
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("|", false).containsAll("value1 value2 value3");
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("|", true).containsAll("value1 value2 value3");
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("", false).containsAll("value1 value2 value3");
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("", true).containsAll("value1 value2 value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", false).containsAll("value1", "value2", "value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", true).containsAll("value1", "value2", "value3", "|", "|");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("", false).containsAll("value1|value2|value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("", true).containsAll("value1|value2|value3");
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").isNotNull().toTokens("|", false).containsAll("value1", "value2", "value3");

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens("|", false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens(null, false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens(null, false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toTokens(null, false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toTokens(null, false);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: delimiters.");
        }
        try {
            clearActual(initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", true)).hasSize(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tokens.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens("|", true)).hasSize(1);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tokens.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", true).hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tokens.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<5>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens("|", true).hasSize(4);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tokens.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<5>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensMatcherTest() {
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens(Matchers.hasItems("value1", "value2", "value3"));
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens(Matchers.hasItems("value1|value2|value3"));
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").isNotNull().toTokens(Matchers.hasItems("value1", "value2", "value3")).isInstanceOf(String.class);

        try {
            Raw.charSequenceAssertion().toTokens(Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens(Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens(Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens((Matcher<Iterable<String>>) null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens((Matcher<Iterable<String>>) null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toTokens((Matcher<Iterable<String>>) null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toTokens((Matcher<Iterable<String>>) null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens(Matchers.<String>iterableWithSize(4));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tokens.\nExpected: an iterable with size <4>\n     but: iterable size was <3>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1 value2 value3", "Message").toTokens(Matchers.<String>iterableWithSize(4));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tokens.\nExpected: an iterable with size <4>\n     but: iterable size was <3>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensSpecifiedMatcherTest() {
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("|", Matchers.hasItems("value1 value2 value3"));
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", Matchers.hasItems("value1", "value2", "value3"));
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("", Matchers.hasItems("value1|value2|value3"));
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").isNotNull().toTokens("|", Matchers.hasItems("value1", "value2", "value3")).isInstanceOf(String.class);

        try {
            Raw.charSequenceAssertion().toTokens("|", Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens("|", Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens("|", Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens(null, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens(null, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toTokens(null, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toTokens(null, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toTokens(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toTokens(null, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toTokens("|", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toTokens("|", null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", Matchers.<String>iterableWithSize(4));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tokens.\nExpected: an iterable with size <4>\n     but: iterable size was <3>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens("|", Matchers.<String>iterableWithSize(4));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tokens.\nExpected: an iterable with size <4>\n     but: iterable size was <3>");
        }
    }

    /**
     * {@link CharSequenceAssertion} class test.
     */
    @Test
    public void toTokensDelimitersMatcherTest() {
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("|", false, Matchers.hasItems("value1 value2 value3"));
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("|", true, Matchers.hasItems("value1 value2 value3"));
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("", false, Matchers.hasItems("value1 value2 value3"));
        initialize(Raw.charSequenceAssertion(), "value1 value2 value3").toTokens("", true, Matchers.hasItems("value1 value2 value3"));
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", false, Matchers.hasItems("value1", "value2", "value3"));
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", true, Matchers.hasItems("value1", "value2", "value3", "|", "|"));
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("", false, Matchers.hasItems("value1|value2|value3"));
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("", true, Matchers.hasItems("value1|value2|value3"));
        initialize(Raw.charSequenceAssertion(), "value1|value2|value3").isNotNull().toTokens("|", false, Matchers.hasItems("value1", "value2", "value3")).isInstanceOf(String.class);

        try {
            Raw.charSequenceAssertion().toTokens("|", false, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens("|", false, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens("|", false, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null).toTokens(null, false, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), null, "Message").toTokens(null, false, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toTokens(null, false, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toTokens(null, false, Matchers.hasItems(""));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toTokens(null, false, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toTokens(null, false, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: delimiters.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "").toTokens("|", false, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "", "Message").toTokens("|", false, null);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3").toTokens("|", true, Matchers.<String>iterableWithSize(4));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tokens.\nExpected: an iterable with size <4>\n     but: iterable size was <5>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value1|value2|value3", "Message").toTokens("|", true, Matchers.<String>iterableWithSize(4));
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tokens.\nExpected: an iterable with size <4>\n     but: iterable size was <5>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), "value", "Message").isNull();
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<value>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), value, "Message").isSameAs("value2");
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<value2> but was:<value1>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<value1>");
        }
        try {
            initialize(Raw.charSequenceAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("CharSequenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<value1>");
        }
    }

}
