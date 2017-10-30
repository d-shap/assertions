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
 * Tests for {@link ThrowableAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ThrowableAssertionTest {

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
    public void toMessageTest() {
        new ThrowableAssertion(new Exception("value"), new FailDescription()).toMessage().isEqualTo("value");
        new ThrowableAssertion(new Exception("value"), new FailDescription()).toMessage().contains("alu");

        new ThrowableAssertion(new Exception("some exception value"), new FailDescription()).toMessage().isEqualTo("some exception value");
        new ThrowableAssertion(new Exception("some exception value"), new FailDescription()).toMessage().contains("exception");

        try {
            new ThrowableAssertion(null, new FailDescription()).toMessage();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).toMessage();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription()).toMessage().isEqualTo("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check throwable message. Values should be the same. Expected:<test> but was:<value>.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription("Message")).toMessage().isEqualTo("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Check throwable message. Values should be the same. Expected:<test> but was:<value>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasMessageTest() {
        new ThrowableAssertion(new Exception("value"), new FailDescription()).hasMessage("value");
        new ThrowableAssertion(new Exception("some exception value"), new FailDescription()).hasMessage("some exception value");

        try {
            new ThrowableAssertion(null, new FailDescription()).hasMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).hasMessage("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription()).hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription()).hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription("Message")).hasMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription()).hasMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check throwable message. Values should be the same. Expected:<test> but was:<value>.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription("Message")).hasMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Check throwable message. Values should be the same. Expected:<test> but was:<value>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void messageMatchesTest() {
        new ThrowableAssertion(new Exception("value"), new FailDescription()).messageMatches("value");
        new ThrowableAssertion(new Exception("value"), new FailDescription()).messageMatches("va.*");
        new ThrowableAssertion(new Exception("some exception value"), new FailDescription()).messageMatches("some exception value");
        new ThrowableAssertion(new Exception("some exception value"), new FailDescription()).messageMatches("some\\s+\\w+\\s+\\w+\\s*");

        try {
            new ThrowableAssertion(null, new FailDescription()).messageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).messageMatches("value");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription()).messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription()).messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription("Message")).messageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription()).messageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check throwable message. Value should match the expected value. Expected:<va\\s*> but was:<value>.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription("Message")).messageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Check throwable message. Value should match the expected value. Expected:<va\\s*> but was:<value>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toCauseTest() {
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).toCause().isInstanceOf(RuntimeException.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).toCause().isInstanceOf(Exception.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).toCause().isInstanceOf(Throwable.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).toCause().toCause().isNull();

        new ThrowableAssertion(new Exception(new Error("value")), new FailDescription()).toCause().isInstanceOf(Error.class);
        new ThrowableAssertion(new Exception(new Error("value")), new FailDescription()).toCause().isInstanceOf(Throwable.class);
        new ThrowableAssertion(new Exception(new Error("value")), new FailDescription()).toCause().toCause().isNull();

        new ThrowableAssertion(new Exception(), new FailDescription()).toCause().isNull();

        try {
            new ThrowableAssertion(null, new FailDescription()).toCause();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).toCause();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), new FailDescription()).toCause().isInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check throwable cause. Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.Error>.");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), new FailDescription("Message")).toCause().isInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Check throwable cause. Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.Error>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void isCauseInstanceOfTest() {
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).isCauseInstanceOf(RuntimeException.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).isCauseInstanceOf(Exception.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).isCauseInstanceOf(Throwable.class);

        new ThrowableAssertion(new Exception(new Error("value")), new FailDescription()).isCauseInstanceOf(Error.class);
        new ThrowableAssertion(new Exception(new Error("value")), new FailDescription()).isCauseInstanceOf(Throwable.class);

        try {
            new ThrowableAssertion(null, new FailDescription()).isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription()).isCauseInstanceOf(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).isCauseInstanceOf(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), new FailDescription()).isCauseInstanceOf(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), new FailDescription("Message")).isCauseInstanceOf(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), new FailDescription()).isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check throwable cause. Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.Error>.");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), new FailDescription("Message")).isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Check throwable cause. Check value class. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.Error>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasCauseMessageTest() {
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).hasCauseMessage("value");
        new ThrowableAssertion(new Exception(new RuntimeException("some exception value")), new FailDescription()).hasCauseMessage("some exception value");

        try {
            new ThrowableAssertion(null, new FailDescription()).hasCauseMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).hasCauseMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription()).hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription("Message")).hasCauseMessage(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).hasCauseMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check throwable cause. Check throwable message. Values should be the same. Expected:<test> but was:<value>.");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription("Message")).hasCauseMessage("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Check throwable cause. Check throwable message. Values should be the same. Expected:<test> but was:<value>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void causeMessageMatchesTest() {
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).causeMessageMatches("value");
        new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).causeMessageMatches("va.*");
        new ThrowableAssertion(new Exception(new RuntimeException("some exception value")), new FailDescription()).causeMessageMatches("some exception value");
        new ThrowableAssertion(new Exception(new RuntimeException("some exception value")), new FailDescription()).causeMessageMatches("some\\s+\\w+\\s+\\w+\\s*");

        try {
            new ThrowableAssertion(null, new FailDescription()).causeMessageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).causeMessageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription()).causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(null, new FailDescription("Message")).causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription("Message")).causeMessageMatches(null);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Argument should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription()).causeMessageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Check throwable cause. Check throwable message. Value should match the expected value. Expected:<va\\s*> but was:<value>.");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), new FailDescription("Message")).causeMessageMatches("va\\s*");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Check throwable cause. Check throwable message. Value should match the expected value. Expected:<va\\s*> but was:<value>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new ThrowableAssertion(null, new FailDescription()).isNull();

        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription()).isNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should be null. Actual:<java.lang.Exception: value>.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), new FailDescription("Message")).isNull();
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should be null. Actual:<java.lang.Exception: value>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Throwable value = new Exception("value");
        new ThrowableAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new ThrowableAssertion(value, new FailDescription()).isSameAs(new Exception("value"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Values should be the same. Expected:<java.lang.Exception: value> but was:<java.lang.Exception: value>.");
        }
        try {
            new ThrowableAssertion(value, new FailDescription("Message")).isSameAs(new Exception("value"));
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Values should be the same. Expected:<java.lang.Exception: value> but was:<java.lang.Exception: value>.");
        }
        try {
            new ThrowableAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Values should be the same. Expected:<test> but was:<java.lang.Exception: value>.");
        }
        try {
            new ThrowableAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Values should be the same. Expected:<test> but was:<java.lang.Exception: value>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Throwable value = new Exception("value");
        new ThrowableAssertion(value, new FailDescription()).isNotSameAs(new Exception("value"));
        new ThrowableAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new ThrowableAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Values should be different. Actual:<java.lang.Exception: value>.");
        }
        try {
            new ThrowableAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("ThrowableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Values should be different. Actual:<java.lang.Exception: value>.");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), new FailDescription()).asString(new Throwable())).isEqualTo("java.lang.Throwable");
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), new FailDescription()).asString(new Exception())).isEqualTo("java.lang.Exception");
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), new FailDescription()).asString(new RuntimeException())).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), new FailDescription()).asString(new RuntimeException("exception message"))).isEqualTo("java.lang.RuntimeException: exception message");
    }

}
