///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasMessageTest() {
        new ThrowableAssertion(new Exception("value"), null).hasMessage("value");
        new ThrowableAssertion(new Exception("some exception value"), null).hasMessage("some exception value");
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
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasCauseInstanceOfTest() {
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).hasCauseInstanceOf(RuntimeException.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).hasCauseInstanceOf(Exception.class);
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).hasCauseInstanceOf(Throwable.class);

        new ThrowableAssertion(new Exception(new Error("value")), null).hasCauseInstanceOf(Error.class);
        new ThrowableAssertion(new Exception(new Error("value")), null).hasCauseInstanceOf(Throwable.class);
    }

    /**
     * {@link ThrowableAssertion} class test.
     */
    @Test
    public void hasCauseMessageTest() {
        new ThrowableAssertion(new Exception(new RuntimeException("value")), null).hasCauseMessage("value");
        new ThrowableAssertion(new Exception(new RuntimeException("some exception value")), null).hasCauseMessage("some exception value");
    }

}
