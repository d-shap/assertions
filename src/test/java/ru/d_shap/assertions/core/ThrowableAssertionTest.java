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
        new ThrowableAssertion(new Exception("value"), null).toMessage().isEqualTo("value");
        new ThrowableAssertion(new Exception("value"), null).toMessage().contains("alu");

        new ThrowableAssertion(new Exception("some exception value"), null).toMessage().isEqualTo("some exception value");
        new ThrowableAssertion(new Exception("some exception value"), null).toMessage().contains("exception");

        try {
            new ThrowableAssertion(null, null).toMessage();
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), null).toMessage().isEqualTo("test");
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Values should be the same. Expected:<test> but was:<value>");
        }
        try {
            new ThrowableAssertion(new Exception("value"), "Message").toMessage().isEqualTo("test");
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Values should be the same. Expected:<test> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasMessageTest() {
        new ThrowableAssertion(new Exception("value"), null).hasMessage("value");
        new ThrowableAssertion(new Exception("some exception value"), null).hasMessage("some exception value");

        try {
            new ThrowableAssertion(null, null).hasMessage("value");
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception("value"), null).hasMessage("test");
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Values should be the same. Expected:<test> but was:<value>");
        }
        try {
            new ThrowableAssertion(new Exception("value"), "Message").hasMessage("test");
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Values should be the same. Expected:<test> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void toCauseTest() {
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).toCause().isInstanceOf(RuntimeException.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).toCause().isInstanceOf(Exception.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).toCause().isInstanceOf(Throwable.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).toCause().toCause().isNull();

        new ThrowableAssertion(new Exception(new Error("value")), null).toCause().isInstanceOf(Error.class);
        new ThrowableAssertion(new Exception(new Error("value")), null).toCause().isInstanceOf(Throwable.class);
        new ThrowableAssertion(new Exception(new Error("value")), null).toCause().toCause().isNull();

        new ThrowableAssertion(new Exception(), null).toCause().isNull();

        try {
            new ThrowableAssertion(null, null).toCause();
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), null).toCause().isInstanceOf(RuntimeException.class);
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), "Message").toCause().isInstanceOf(RuntimeException.class);
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void isCauseInstanceOfTest() {
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).isCauseInstanceOf(RuntimeException.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).isCauseInstanceOf(Exception.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).isCauseInstanceOf(Throwable.class);

        new ThrowableAssertion(new Exception(new Error("value")), null).isCauseInstanceOf(Error.class);
        new ThrowableAssertion(new Exception(new Error("value")), null).isCauseInstanceOf(Throwable.class);

        try {
            new ThrowableAssertion(null, null).isCauseInstanceOf(Throwable.class);
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), null).isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
        try {
            new ThrowableAssertion(new Exception(new Error("value")), "Message").isCauseInstanceOf(RuntimeException.class);
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Value should be the subtype of the expected value. Expected:<java.lang.RuntimeException> but was:<java.lang.Error>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasCauseMessageTest() {
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).hasCauseMessage("value");
        new ThrowableAssertion(new Exception(new RuntimeException("some exception value")), null).hasCauseMessage("some exception value");

        try {
            new ThrowableAssertion(null, null).hasCauseMessage("value");
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Value should not be null.");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), null).hasCauseMessage("test");
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Values should be the same. Expected:<test> but was:<value>");
        }
        try {
            new ThrowableAssertion(new Exception(new RuntimeException("value")), "Message").hasCauseMessage("test");
            Assertions.fail("Throwable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).toMessage().isEqualTo("Message. Values should be the same. Expected:<test> but was:<value>");
        }
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), null).asString(null)).isNull();
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), null).asString(new Throwable())).isEqualTo("java.lang.Throwable");
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), null).asString(new Exception())).isEqualTo("java.lang.Exception");
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), null).asString(new RuntimeException())).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new ThrowableAssertion(new Throwable(), null).asString(new RuntimeException("exception message"))).isEqualTo("java.lang.RuntimeException: exception message");
    }

}
