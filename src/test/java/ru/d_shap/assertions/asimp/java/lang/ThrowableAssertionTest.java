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

import java.io.IOException;

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

        initialize(Raw.throwableAssertion(), new Exception("value")).isNotNull().toMessage().isEqualTo("value");

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

        initialize(Raw.throwableAssertion(), new Exception("value")).isNotNull().toMessage(Matchers.is(Matchers.equalTo("value"))).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().toMessage(Matchers.equalTo(""));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toMessage(Matchers.equalTo(""));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toMessage(Matchers.equalTo(""));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).toMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").toMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).toMessage(Matchers.equalTo("test"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\nExpected: \"test\"\n     but: was \"value\"");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").toMessage(Matchers.equalTo("test"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\nExpected: \"test\"\n     but: was \"value\"");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNullTest() {
        initialize(Raw.throwableAssertion(), new Exception()).messageIsNull();
        initialize(Raw.throwableAssertion(), new Exception()).isNotNull().messageIsNull().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("")).messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should be null.\n\tActual:<>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(""), "Message").messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:<>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should be null.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" "), "Message").messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:<value>");
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
        initialize(Raw.throwableAssertion(), new Exception("value")).isNotNull().messageIsNotNull().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsEmptyTest() {
        initialize(Raw.throwableAssertion(), new Exception("")).messageIsEmpty();
        initialize(Raw.throwableAssertion(), new Exception("")).isNotNull().messageIsEmpty().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" "), "Message").messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should be empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNullOrEmptyTest() {
        initialize(Raw.throwableAssertion(), new Exception()).messageIsNullOrEmpty();
        initialize(Raw.throwableAssertion(), new Exception("")).messageIsNullOrEmpty();
        initialize(Raw.throwableAssertion(), new Exception("")).isNotNull().messageIsNullOrEmpty().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" "), "Message").messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should be null or empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNotEmptyTest() {
        initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNotEmpty();
        initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNotEmpty();
        initialize(Raw.throwableAssertion(), new Exception("value")).isNotNull().messageIsNotEmpty().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("")).messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(""), "Message").messageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsBlankTest() {
        initialize(Raw.throwableAssertion(), new Exception("")).messageIsBlank();
        initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsBlank();
        initialize(Raw.throwableAssertion(), new Exception(" ")).isNotNull().messageIsBlank().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should be blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should be blank.\n\tActual:<value>");
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
        initialize(Raw.throwableAssertion(), new Exception(" ")).isNotNull().messageIsNullOrBlank().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should be null or blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should be null or blank.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageIsNotBlankTest() {
        initialize(Raw.throwableAssertion(), new Exception("value")).messageIsNotBlank();
        initialize(Raw.throwableAssertion(), new Exception("value")).isNotNull().messageIsNotBlank().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("")).messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(""), "Message").messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" ")).messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(" "), "Message").messageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasMessageTest() {
        initialize(Raw.throwableAssertion(), new Exception("value")).hasMessage("value");
        initialize(Raw.throwableAssertion(), new Exception("some exception value")).hasMessage("some exception value");
        initialize(Raw.throwableAssertion(), new Exception("some exception value")).isNotNull().hasMessage("some exception value").isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().hasMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).hasMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").hasMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasMessageMutationTest() {
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
        initialize(Raw.throwableAssertion(), new Exception("value")).isNotNull().messageContains("e").isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageContains("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageContains("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageContains("LU");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<LU> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageContains("LU");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<LU> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageContainsIgnoreCaseTest() {
        initialize(Raw.throwableAssertion(), new Exception("value")).messageContainsIgnoreCase("value");
        initialize(Raw.throwableAssertion(), new Exception("value")).messageContainsIgnoreCase("va");
        initialize(Raw.throwableAssertion(), new Exception("value")).messageContainsIgnoreCase("lu");
        initialize(Raw.throwableAssertion(), new Exception("value")).messageContainsIgnoreCase("LU");
        initialize(Raw.throwableAssertion(), new Exception("value")).messageContainsIgnoreCase("e");
        initialize(Raw.throwableAssertion(), new Exception("value")).isNotNull().messageContainsIgnoreCase("e").isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageContainsIgnoreCase("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageContainsIgnoreCase("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageContainsIgnoreCase("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageContainsIgnoreCase(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageContainsIgnoreCase(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageContainsIgnoreCase(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageContainsIgnoreCase(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageContainsIgnoreCase("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should contain the expected value ignoring case.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageContainsIgnoreCase("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should contain the expected value ignoring case.\n\tExpected:<vae> but was:<value>");
        }
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
        initialize(Raw.throwableAssertion(), new Exception("value")).isNotNull().messageMatches("va.*").isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().messageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).messageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's message.\n\tActual value should match the expected value.\n\tExpected:<va\\s*> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's message.\n\tActual value should match the expected value.\n\tExpected:<va\\s*> but was:<value>");
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
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause().toCause().isNull();

        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().isInstanceOf(Error.class);
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().isInstanceOf(Throwable.class);
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().toCause().isNull();

        initialize(Raw.throwableAssertion(), new Exception()).toCause().isNull();

        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).isNotNull().toCause().isInstanceOf(RuntimeException.class);

        try {
            Raw.throwableAssertion().toCause();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toCause();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toCause();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause()).isInstanceOf(Exception.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").toCause()).isInstanceOf(Exception.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().isInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").toCause().isInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toCauseMatcherTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause(Matchers.instanceOf(RuntimeException.class));
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause(Matchers.instanceOf(Exception.class));
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause(Matchers.instanceOf(Throwable.class));
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause().toCause(Matchers.nullValue(Throwable.class));

        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause(Matchers.instanceOf(Error.class));
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause(Matchers.instanceOf(Throwable.class));
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().toCause(Matchers.nullValue(Throwable.class));

        initialize(Raw.throwableAssertion(), new Exception()).toCause(Matchers.nullValue(Throwable.class));

        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).isNotNull().toCause(Matchers.instanceOf(RuntimeException.class)).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().toCause(Matchers.instanceOf(Throwable.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toCause(Matchers.instanceOf(Throwable.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toCause(Matchers.instanceOf(Throwable.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).toCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").toCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause(Matchers.instanceOf(RuntimeException.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\nExpected: an instance of java.lang.RuntimeException\n     but: <java.lang.Error: value> is a java.lang.Error");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").toCause(Matchers.instanceOf(RuntimeException.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\nExpected: an instance of java.lang.RuntimeException\n     but: <java.lang.Error: value> is a java.lang.Error");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeIsNullTest() {
        initialize(Raw.throwableAssertion(), new Exception()).causeIsNull();
        initialize(Raw.throwableAssertion(), new Exception()).isNotNull().causeIsNull().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).causeIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should be null.\n\tActual:<java.lang.Error: value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").causeIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should be null.\n\tActual:<java.lang.Error: value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeIsNotNullTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeIsNotNull();
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).causeIsNotNull();
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).isNotNull().causeIsNotNull().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).causeIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").causeIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
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

        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).isNotNull().hasCause(Error.class).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).hasCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").hasCause(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").hasCause(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasCausesTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).hasCauses(RuntimeException.class, Error.class, IOException.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).hasCauses(Exception.class, Error.class, IOException.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).hasCauses(Throwable.class, Error.class, IOException.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).hasCauses(RuntimeException.class, Error.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).hasCauses(RuntimeException.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).hasCauses(Exception.class, Throwable.class, Exception.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).hasCauses(Throwable.class, Throwable.class, Throwable.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).hasCauses(Throwable.class, Throwable.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).hasCauses(Throwable.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(new Error(new IOException("value"))))).isNotNull().hasCauses(Throwable.class).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().hasCauses(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCauses(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCauses(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCauses((Class<?>[]) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCauses((Class<?>[]) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).hasCauses((Class<?>[]) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").hasCauses((Class<?>[]) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).hasCauses();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").hasCauses();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).hasCauses((Class<?>) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").hasCauses((Class<?>) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error())).hasCauses((Class<?>) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error()), "Message").hasCauses((Class<?>) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error(new IOException("value")))).hasCauses(Error.class, RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.io.IOException>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error(new IOException("value"))), "Message").hasCauses(Error.class, RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.io.IOException>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error(new IOException("value")))).hasCauses(RuntimeException.class, RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error(new IOException("value"))), "Message").hasCauses(RuntimeException.class, RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error())).hasCauses(Error.class, RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error()), "Message").hasCauses(Error.class, RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNullTest() {
        initialize(Raw.throwableAssertion(), new Exception(new Error())).causeMessageIsNull();
        initialize(Raw.throwableAssertion(), new Exception(new Error())).isNotNull().causeMessageIsNull().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).causeMessageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").causeMessageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).causeMessageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").causeMessageIsNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNotNullTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageIsNotNull();
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).causeMessageIsNotNull();
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).isNotNull().causeMessageIsNotNull().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value")).causeMessageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").causeMessageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error())).causeMessageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error()), "Message").causeMessageIsNotNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsEmptyTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(""))).causeMessageIsEmpty();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(""))).isNotNull().causeMessageIsEmpty().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException())).causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException()), "Message").causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" "))).causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" ")), "Message").causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageIsEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNullOrEmptyTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException())).causeMessageIsNullOrEmpty();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(""))).causeMessageIsNullOrEmpty();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(""))).isNotNull().causeMessageIsNullOrEmpty().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" "))).causeMessageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" ")), "Message").causeMessageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageIsNullOrEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNotEmptyTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" "))).causeMessageIsNotEmpty();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageIsNotEmpty();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).isNotNull().causeMessageIsNotEmpty().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException())).causeMessageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException()), "Message").causeMessageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(""))).causeMessageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("")), "Message").causeMessageIsNotEmpty();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsBlankTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(""))).causeMessageIsBlank();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" "))).causeMessageIsBlank();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" "))).isNotNull().causeMessageIsBlank().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException())).causeMessageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException()), "Message").causeMessageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should be blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageIsBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should be blank.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNullOrBlankTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException())).causeMessageIsNullOrBlank();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(""))).causeMessageIsNullOrBlank();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" "))).causeMessageIsNullOrBlank();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" "))).isNotNull().causeMessageIsNullOrBlank().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should be null or blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageIsNullOrBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should be null or blank.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageIsNotBlankTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageIsNotBlank();
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).isNotNull().causeMessageIsNotBlank().isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException())).causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException()), "Message").causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(""))).causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("")), "Message").causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" "))).causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException(" ")), "Message").causeMessageIsNotBlank();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasCauseMessageTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).hasCauseMessage("value");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("some exception value"))).hasCauseMessage("some exception value");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("some exception value"))).isNotNull().hasCauseMessage("some exception value").isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().hasCauseMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCauseMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCauseMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).hasCauseMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").hasCauseMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test> but was:<value>");
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
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).isNotNull().causeMessageContains("e").isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageContains(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException())).causeMessageContains("v");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException()), "Message").causeMessageContains("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContains("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageContains("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContains("LU");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<LU> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageContains("LU");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value.\n\tExpected:<LU> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageContainsIgnoreCaseTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContainsIgnoreCase("value");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContainsIgnoreCase("va");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContainsIgnoreCase("lu");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContainsIgnoreCase("LU");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContainsIgnoreCase("e");
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).isNotNull().causeMessageContainsIgnoreCase("e").isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageContainsIgnoreCase("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageContainsIgnoreCase("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageContainsIgnoreCase("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageContainsIgnoreCase(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageContainsIgnoreCase(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageContainsIgnoreCase(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageContainsIgnoreCase(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageContainsIgnoreCase("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageContainsIgnoreCase("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException())).causeMessageContainsIgnoreCase("v");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException()), "Message").causeMessageContainsIgnoreCase("v");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageContainsIgnoreCase("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value ignoring case.\n\tExpected:<vae> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageContainsIgnoreCase("vae");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should contain the expected value ignoring case.\n\tExpected:<vae> but was:<value>");
        }
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
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("some exception value"))).isNotNull().causeMessageMatches("some\\s+\\w+\\s+\\w+\\s*").isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception()).causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(), "Message").causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException())).causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException()), "Message").causeMessageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's cause.\n\tCheck actual value's message.\n\tActual value should match the expected value.\n\tExpected:<va\\s*> but was:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's cause.\n\tCheck actual value's message.\n\tActual value should match the expected value.\n\tExpected:<va\\s*> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toSuppressedCountTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressedCount().isEqualTo(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).toSuppressedCount().isEqualTo(1);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error())).toSuppressedCount().isEqualTo(2);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressedCount().isEqualTo(3);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).isNotNull().toSuppressedCount().isEqualTo(0);

        try {
            Raw.throwableAssertion().toSuppressedCount();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toSuppressedCount();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toSuppressedCount();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressedCount()).isEqualTo(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed count.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").toSuppressedCount()).isEqualTo(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed count.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressedCount().isEqualTo(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").toSuppressedCount().isEqualTo(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error())).toSuppressedCount().isEqualTo(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error()), "Message").toSuppressedCount().isEqualTo(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toSuppressedCountMatcherTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressedCount(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).toSuppressedCount(Matchers.is(Matchers.equalTo(1)));
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error())).toSuppressedCount(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressedCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).isNotNull().toSuppressedCount(Matchers.is(Matchers.equalTo(0))).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().toSuppressedCount(Matchers.equalTo(0));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toSuppressedCount(Matchers.equalTo(0));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toSuppressedCount(Matchers.equalTo(0));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toSuppressedCount(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toSuppressedCount(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressedCount(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").toSuppressedCount(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressedCount(Matchers.equalTo(1));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed count.\nExpected: <1>\n     but: was <0>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").toSuppressedCount(Matchers.equalTo(1));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed count.\nExpected: <1>\n     but: was <0>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error())).toSuppressedCount(Matchers.equalTo(1));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed count.\nExpected: <1>\n     but: was <2>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error()), "Message").toSuppressedCount(Matchers.equalTo(1));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed count.\nExpected: <1>\n     but: was <2>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasSuppressedCountTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).hasSuppressedCount(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).hasSuppressedCount(1);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error())).hasSuppressedCount(2);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).hasSuppressedCount(3);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).isNotNull().hasSuppressedCount(1).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().hasSuppressedCount(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasSuppressedCount(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasSuppressedCount(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).hasSuppressedCount(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").hasSuppressedCount(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error())).hasSuppressedCount(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error()), "Message").hasSuppressedCount(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<2>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toSuppressedTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).toSuppressed(0).isInstanceOf(RuntimeException.class);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(0).isInstanceOf(RuntimeException.class);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(1).isInstanceOf(Error.class);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(2).isInstanceOf(IOException.class);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).isNotNull().toSuppressed(0).isInstanceOf(RuntimeException.class);

        try {
            Raw.throwableAssertion().toSuppressed(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toSuppressed(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toSuppressed(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressed(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").toSuppressed(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressed(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 0.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").toSuppressed(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 0.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(3);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 3.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException()), "Message").toSuppressed(3);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 3.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(4);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 3.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException()), "Message").toSuppressed(4);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 3.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(2)).isInstanceOf(IOException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 2.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException()), "Message").toSuppressed(2)).isInstanceOf(IOException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 2.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(2).isInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 2.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.io.IOException>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException()), "Message").toSuppressed(2).isInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 2.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.io.IOException>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toSuppressedMatcherTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).toSuppressed(0, Matchers.is(Matchers.instanceOf(RuntimeException.class)));
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(0, Matchers.is(Matchers.instanceOf(RuntimeException.class)));
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(1, Matchers.is(Matchers.instanceOf(Error.class)));
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(2, Matchers.is(Matchers.instanceOf(IOException.class)));
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).isNotNull().toSuppressed(0, Matchers.is(Matchers.instanceOf(RuntimeException.class))).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().toSuppressed(0, null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).toSuppressed(0, null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").toSuppressed(0, null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressed(-1, null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").toSuppressed(-1, null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).toSuppressed(0, null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 0.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").toSuppressed(0, null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 0.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).toSuppressed(0, null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException()), "Message").toSuppressed(0, null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(3, Matchers.instanceOf(Throwable.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 3.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException()), "Message").toSuppressed(3, Matchers.instanceOf(Throwable.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 3.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).toSuppressed(2, Matchers.instanceOf(RuntimeException.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 2.\nExpected: an instance of java.lang.RuntimeException\n     but: <java.io.IOException> is a java.io.IOException");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException()), "Message").toSuppressed(2, Matchers.instanceOf(RuntimeException.class));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 2.\nExpected: an instance of java.lang.RuntimeException\n     but: <java.io.IOException> is a java.io.IOException");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasSuppressedTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).hasSuppressed();
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).hasSuppressed(RuntimeException.class);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).hasSuppressed(RuntimeException.class, Error.class, IOException.class);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).isNotNull().hasSuppressed(RuntimeException.class).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().hasSuppressed();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasSuppressed();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasSuppressed();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).hasSuppressed((Class<?>[]) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").hasSuppressed((Class<?>[]) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).hasSuppressed((Class<?>[]) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").hasSuppressed((Class<?>[]) null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception())).hasSuppressed(Throwable.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception()), "Message").hasSuppressed(Throwable.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed count.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<0>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).hasSuppressed(IOException.class, Error.class, IOException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.io.IOException> but was:<java.lang.RuntimeException>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException()), "Message").hasSuppressed(IOException.class, Error.class, IOException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.io.IOException> but was:<java.lang.RuntimeException>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).hasSuppressed(RuntimeException.class, IOException.class, IOException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 1.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.io.IOException> but was:<java.lang.Error>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException()), "Message").hasSuppressed(RuntimeException.class, IOException.class, IOException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 1.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.io.IOException> but was:<java.lang.Error>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException())).hasSuppressed(RuntimeException.class, Error.class, RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 2.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.io.IOException>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(), new Error(), new IOException()), "Message").hasSuppressed(RuntimeException.class, Error.class, RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 2.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.io.IOException>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageIsNullTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsNull(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).isNotNull().suppressedMessageIsNull(0).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().suppressedMessageIsNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).suppressedMessageIsNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").suppressedMessageIsNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsNull(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException()), "Message").suppressedMessageIsNull(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsNull(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException()), "Message").suppressedMessageIsNull(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value")), "Message").suppressedMessageIsNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be null.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageIsNotNullTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsNotNull(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).isNotNull().suppressedMessageIsNotNull(0).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().suppressedMessageIsNotNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).suppressedMessageIsNotNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").suppressedMessageIsNotNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsNotNull(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value")), "Message").suppressedMessageIsNotNull(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsNotNull(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value")), "Message").suppressedMessageIsNotNull(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsNotNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException()), "Message").suppressedMessageIsNotNull(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageIsEmptyTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsEmpty(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).isNotNull().suppressedMessageIsEmpty(0).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().suppressedMessageIsEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).suppressedMessageIsEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").suppressedMessageIsEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsEmpty(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsEmpty(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsEmpty(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsEmpty(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException()), "Message").suppressedMessageIsEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" "))).suppressedMessageIsEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" ")), "Message").suppressedMessageIsEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value")), "Message").suppressedMessageIsEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageIsNullOrEmptyTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsNullOrEmpty(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNullOrEmpty(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).isNotNull().suppressedMessageIsNullOrEmpty(0).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().suppressedMessageIsNullOrEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).suppressedMessageIsNullOrEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").suppressedMessageIsNullOrEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNullOrEmpty(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNullOrEmpty(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNullOrEmpty(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNullOrEmpty(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" "))).suppressedMessageIsNullOrEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" ")), "Message").suppressedMessageIsNullOrEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:< >");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsNullOrEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value")), "Message").suppressedMessageIsNullOrEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be null or empty.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageIsNotEmptyTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" "))).suppressedMessageIsNotEmpty(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsNotEmpty(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" "))).isNotNull().suppressedMessageIsNotEmpty(0).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().suppressedMessageIsNotEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).suppressedMessageIsNotEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").suppressedMessageIsNotEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNotEmpty(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNotEmpty(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNotEmpty(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNotEmpty(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsNotEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException()), "Message").suppressedMessageIsNotEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNotEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be empty.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNotEmpty(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageIsBlankTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" "))).suppressedMessageIsBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("  "))).suppressedMessageIsBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("\t \t"))).suppressedMessageIsBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).isNotNull().suppressedMessageIsBlank(0).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().suppressedMessageIsBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).suppressedMessageIsBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").suppressedMessageIsBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsBlank(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsBlank(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsBlank(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsBlank(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException()), "Message").suppressedMessageIsBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value")), "Message").suppressedMessageIsBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be blank.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageIsNullOrBlankTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsNullOrBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNullOrBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" "))).suppressedMessageIsNullOrBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("  "))).suppressedMessageIsNullOrBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("\t \t"))).suppressedMessageIsNullOrBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).isNotNull().suppressedMessageIsNullOrBlank(0).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().suppressedMessageIsNullOrBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).suppressedMessageIsNullOrBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").suppressedMessageIsNullOrBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNullOrBlank(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNullOrBlank(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNullOrBlank(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNullOrBlank(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsNullOrBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be null or blank.\n\tActual:<value>");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value")), "Message").suppressedMessageIsNullOrBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should be null or blank.\n\tActual:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageIsNotBlankTest() {
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).suppressedMessageIsNotBlank(0);
        initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("value"))).isNotNull().suppressedMessageIsNotBlank(0).isInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNotBlank(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNotBlank(-1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNotBlank(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNotBlank(1);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: idx.\n\tThe argument's value should be less than the maximum value: 1.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException())).suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException()), "Message").suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(""))).suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("")), "Message").suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" "))).suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException(" ")), "Message").suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("\t \t"))).suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
        try {
            initialize(Raw.throwableAssertion(), addSuppressed(new Exception(), new RuntimeException("\t \t")), "Message").suppressedMessageIsNotBlank(0);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's suppressed 0.\n\tCheck actual value's message.\n\tActual value should not be blank.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasSuppressedMessageTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageContainsTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageContainsIgnoreCaseTest() {
        // TODO
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void suppressedMessageMatchesTest() {
        // TODO
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<java.lang.Exception: value>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").isNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<java.lang.Exception: value>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<java.lang.Exception: value> but was:<java.lang.Exception: value>");
        }
        try {
            initialize(Raw.throwableAssertion(), value, "Message").isSameAs(new Exception("value"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<java.lang.Exception: value> but was:<java.lang.Exception: value>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<java.lang.Exception: value>");
        }
        try {
            initialize(Raw.throwableAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<java.lang.Exception: value>");
        }
    }

    private static Throwable addSuppressed(final Throwable throwable, final Throwable... suppressed) {
        for (Throwable ex : suppressed) {
            throwable.addSuppressed(ex);
        }
        return throwable;
    }

}
