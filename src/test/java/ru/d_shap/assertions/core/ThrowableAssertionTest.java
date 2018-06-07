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
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.throwableAssertion(), new Object(), "Message");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
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
            initialize(Raw.throwableAssertion(), new Exception("value")).hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null.");
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
            initialize(Raw.throwableAssertion(), new Exception("value")).messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception("value"), "Message").messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null.");
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
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).toCause().toCause().isNull();

        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().isInstanceOf(Error.class);
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().isInstanceOf(Throwable.class);
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).toCause().toCause().isNull();

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
    public void isCauseInstanceOfTest() {
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).isCauseInstanceOf(RuntimeException.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).isCauseInstanceOf(Exception.class);
        initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).isCauseInstanceOf(Throwable.class);

        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).isCauseInstanceOf(Error.class);
        initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).isCauseInstanceOf(Throwable.class);

        try {
            Raw.throwableAssertion().isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Assertion should be initialized.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null).isCauseInstanceOf(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), null, "Message").isCauseInstanceOf(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).isCauseInstanceOf(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").isCauseInstanceOf(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value"))).isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new Error("value")), "Message").isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tCheck actual value's cause.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
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
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null.");
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
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value"))).causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            initialize(Raw.throwableAssertion(), new Exception(new RuntimeException("value")), "Message").causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tArgument should not be null.");
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
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual and expected values should be the same.\n\tExpected:<java.lang.Exception: value> but was:<java.lang.Exception: value>");
        }
        try {
            initialize(Raw.throwableAssertion(), value, "Message").isSameAs(new Exception("value"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.Exception: value> but was:<java.lang.Exception: value>");
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
            Assertions.assertThat(ex).toMessage().isEqualTo("Actual and expected values should be different.\n\tActual:<java.lang.Exception: value>");
        }
        try {
            initialize(Raw.throwableAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message.\n\tActual and expected values should be different.\n\tActual:<java.lang.Exception: value>");
        }
    }

}
