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

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ThrowableAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ThrowableAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ThrowableAssertionTest() {
        super();
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.throwableAssertion(), new Exception("value"));

        try {
            initializeWithRawActual(Raw.throwableAssertion(), new Object());
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Throwable> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.throwableAssertion(), new Object(), "Message");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Throwable> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toMessageTest() {
        initialize(Raw.throwableAssertion(), new Exception("value")).toMessage().isEqualTo("value");
        initialize(Raw.throwableAssertion(), new Exception("value")).toMessage().contains("alu");

        initialize(Raw.throwableAssertion(), new Exception("some exception value")).toMessage().isEqualTo("some exception value");
        initialize(Raw.throwableAssertion(), new Exception("some exception value")).toMessage().contains("exception");

        try {
            Raw.throwableAssertion().toMessage();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toMessage();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toMessage();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), new Exception("value")).toMessage()).isEqualTo("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), new Exception("value"), "Message").toMessage()).isEqualTo("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).toMessage().isEqualTo("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").toMessage().isEqualTo("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toMessageMatcherTest() {
        initialize(Raw.throwableAssertion(), new Exception("value")).toMessage(Matchers.is(Matchers.equalTo("value")));
        initialize(Raw.throwableAssertion(), new Exception("value")).toMessage(Matchers.containsString("alu"));

        initialize(Raw.throwableAssertion(), new Exception("some exception value")).toMessage(Matchers.equalTo("some exception value"));
        initialize(Raw.throwableAssertion(), new Exception("some exception value")).toMessage(Matchers.containsString("exception"));

        try {
            Raw.throwableAssertion().toMessage(Matchers.equalTo(""));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toMessage(Matchers.equalTo(""));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toMessage(Matchers.equalTo(""));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).toMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").toMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).toMessage(Matchers.equalTo("test"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\nExpected: \"test\"\n     but: was \"value\"");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").toMessage(Matchers.equalTo("test"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\nExpected: \"test\"\n     but: was \"value\"");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNullTest() {
        initialize(Raw.throwableAssertion(), new Exception()).messageIsNull();

        try {
            Raw.throwableAssertion().messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("")).messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should be null.\n\tActual:<>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(""), "Message").messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:<>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should be null.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" "), "Message").messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNotNullTest() {
        initialize(Raw.throwableAssertion(), new Exception("")).messageIsNotNull();
        initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNotNull();
        initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNotNull();

        try {
            Raw.throwableAssertion().messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsEmptyTest() {
        initialize(Raw.throwableAssertion(), new Exception("")).messageIsEmpty();

        try {
            Raw.throwableAssertion().messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" "), "Message").messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should be empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNullOrEmptyTest() {
        initialize(Raw.throwableAssertion(), new Exception()).messageIsNullOrEmpty();
        initialize(Raw.throwableAssertion(), new Exception("")).messageIsNullOrEmpty();

        try {
            Raw.throwableAssertion().messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" "), "Message").messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should be null or empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNotEmptyTest() {
        initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNotEmpty();
        initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNotEmpty();

        try {
            Raw.throwableAssertion().messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("")).messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(""), "Message").messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsBlankTest() {
        initialize(Raw.throwableAssertion(), new Exception("")).messageIsBlank();
        initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsBlank();

        try {
            Raw.throwableAssertion().messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should be blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should be blank.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNullOrBlankTest() {
        initialize(Raw.throwableAssertion(), new Exception()).messageIsNullOrBlank();
        initialize(Raw.throwableAssertion(), new Exception("")).messageIsNullOrBlank();
        initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNullOrBlank();

        try {
            Raw.throwableAssertion().messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should be null or blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should be null or blank.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNotBlankTest() {
        initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNotBlank();

        try {
            Raw.throwableAssertion().messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("")).messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(""), "Message").messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" "), "Message").messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasMessageTest() {
        initialize(Raw.throwableAssertion(), new Exception("value")).hasMessage("value");
        initialize(Raw.throwableAssertion(), new Exception("some exception value")).hasMessage("some exception value");

        try {
            Raw.throwableAssertion().hasMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).hasMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").hasMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageContainsTest() {
        initialize(Raw.throwableAssertion(), new Exception("value")).messageContains("value");
        initialize(Raw.throwableAssertion(), new Exception("value")).messageContains("va");
        initialize(Raw.throwableAssertion(), new Exception("value")).messageContains("lu");
        initialize(Raw.throwableAssertion(), new Exception("value")).messageContains("e");

        try {
            Raw.throwableAssertion().messageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageContains("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageContains("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageContains("LU");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<LU> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageContains("LU");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<LU> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageContainsIgnoreCaseTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageMatchesTest() {
        initialize(Raw.throwableAssertion(), new Exception("value")).messageMatches("value");
        initialize(Raw.throwableAssertion(), new Exception("value")).messageMatches("va.*");
        initialize(Raw.throwableAssertion(), new Exception("some exception value")).messageMatches("some exception value");
        initialize(Raw.throwableAssertion(), new Exception("some exception value")).messageMatches("some\\s+\\w+\\s+\\w+\\s*");

        try {
            Raw.throwableAssertion().messageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's message.\n\tActual value should match the expected value.\n\tExpected:<va\\s*> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's message.\n\tActual value should match the expected value.\n\tExpected:<va\\s*> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toCauseTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause().isInstanceOf(RuntimeException.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause().isInstanceOf(Exception.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause().isInstanceOf(Throwable.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause().causeIsNull();

        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().isInstanceOf(Error.class);
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().isInstanceOf(Throwable.class);
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().causeIsNull();

        initialize(Raw.throwableAssertion(), new Exception()).toCause().isNull();

        try {
            Raw.throwableAssertion().toCause();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toCause();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toCause();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause()).isInstanceOf(Exception.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").toCause()).isInstanceOf(Exception.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().isInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").toCause().isInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toCauseMatcherTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause(Matchers.<Throwable>instanceOf(RuntimeException.class));
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause(Matchers.<Throwable>instanceOf(Exception.class));
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause(Matchers.<Throwable>instanceOf(Throwable.class));
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause().toCause(Matchers.nullValue(Throwable.class));

        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause(Matchers.<Throwable>instanceOf(Error.class));
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause(Matchers.<Throwable>instanceOf(Throwable.class));
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().toCause(Matchers.nullValue(Throwable.class));

        initialize(Raw.throwableAssertion(), new Exception()).toCause(Matchers.nullValue(Throwable.class));

        try {
            Raw.throwableAssertion().toCause(Matchers.<Throwable>instanceOf(Throwable.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toCause(Matchers.<Throwable>instanceOf(Throwable.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toCause(Matchers.<Throwable>instanceOf(Throwable.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).toCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").toCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause(Matchers.<Throwable>instanceOf(RuntimeException.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's cause.\nExpected: an instance of java.lang.RuntimeException\n     but: <java.lang.Error: value> is a java.lang.Error");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").toCause(Matchers.<Throwable>instanceOf(RuntimeException.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's cause.\nExpected: an instance of java.lang.RuntimeException\n     but: <java.lang.Error: value> is a java.lang.Error");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeIsNullTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasCauseTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).hasCause(RuntimeException.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).hasCause(Exception.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).hasCause(Throwable.class);

        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).hasCause(Error.class);
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).hasCause(Throwable.class);

        try {
            Raw.throwableAssertion().hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).hasCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").hasCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNullTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsEmptyTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNullOrEmptyTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNotEmptyTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsBlankTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNullOrBlankTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNotBlankTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasCauseMessageTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).hasCauseMessage("value");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("some exception value"))).hasCauseMessage("some exception value");

        try {
            Raw.throwableAssertion().hasCauseMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCauseMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCauseMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).hasCauseMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's cause.\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").hasCauseMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageContainsTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContains("value");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContains("va");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContains("lu");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContains("e");

        try {
            Raw.throwableAssertion().causeMessageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContains("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageContains("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContains("LU");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<LU> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageContains("LU");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<LU> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageContainsIgnoreCaseTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageMatchesTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageMatches("value");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageMatches("va.*");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("some exception value"))).causeMessageMatches("some exception value");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("some exception value"))).causeMessageMatches("some\\s+\\w+\\s+\\w+\\s*");

        try {
            Raw.throwableAssertion().causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should match the expected value.\n\tExpected:<va\\s*> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should match the expected value.\n\tExpected:<va\\s*> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.throwableAssertion(), null).isNull();

        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).isNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should be null.\n\tActual:<java.lang.Exception: value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").isNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should be null.\n\tActual:<java.lang.Exception: value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Throwable value = new Exception("value");
        initialize(Raw.throwableAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.throwableAssertion(), value).isSameAs(new Exception("value"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual and expected values should point to the same object.\n\tExpected:<java.lang.Exception: value> but was:<java.lang.Exception: value>");
        }
        try {
            initialize(Raw.throwableAssertion(), value, "Message").isSameAs(new Exception("value"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<java.lang.Exception: value> but was:<java.lang.Exception: value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Throwable value = new Exception("value");
        initialize(Raw.throwableAssertion(), value).isNotSameAs(new Exception("value"));

        try {
            initialize(Raw.throwableAssertion(), value).isNotSameAs(value);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual and expected values should point to the different objects.\n\tActual:<java.lang.Exception: value>");
        }
        try {
            initialize(Raw.throwableAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<java.lang.Exception: value>");
        }
    }

}
