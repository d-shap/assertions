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
package ru.d_shap.assertions;

import org.junit.Test;

/**
 * Tests for {@link BaseAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BaseAssertionTest {

    /**
     * Test class constructor.
     */
    public BaseAssertionTest() {
        super();
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void getMessageTest() {
        Assertions.assertThat(new BaseAssertion(null).getMessage()).isNull();
        Assertions.assertThat(new BaseAssertion("some message").getMessage()).isEqualTo("some message");

        try {
            Assertions.assertThat(new BaseAssertion("some message").getMessage()).isEqualTo("some other message");
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<some other message> but was:<some message>");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithFailMessageTest() {
        Assertions.assertThat(new BaseAssertion(null).createAssertionError((String) null).getMessage()).isEqualTo("");
        Assertions.assertThat(new BaseAssertion(null).createAssertionError("").getMessage()).isEqualTo("");
        Assertions.assertThat(new BaseAssertion(null).createAssertionError("fail message").getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertion("").createAssertionError((String) null).getMessage()).isEqualTo("");
        Assertions.assertThat(new BaseAssertion("").createAssertionError("").getMessage()).isEqualTo("");
        Assertions.assertThat(new BaseAssertion("").createAssertionError("fail message").getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertion("assertion message").createAssertionError((String) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertion("assertion message").createAssertionError("").getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertion("assertion message").createAssertionError("fail message").getMessage()).isEqualTo("assertion message. fail message");

        Assertions.assertThat(new BaseAssertion("assertion message.").createAssertionError((String) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertion("assertion message.").createAssertionError("").getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertion("assertion message.").createAssertionError("fail message").getMessage()).isEqualTo("assertion message. fail message");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithThrowableTest() {
        Assertions.assertThat(new BaseAssertion(null).createAssertionError((Throwable) null).getMessage()).isNull();
        Assertions.assertThat(new BaseAssertion(null).createAssertionError(new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertion(null).createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertion("").createAssertionError((Throwable) null).getMessage()).isNull();
        Assertions.assertThat(new BaseAssertion("").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertion("").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertion("assertion message").createAssertionError((Throwable) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertion("assertion message").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertion("assertion message").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertion("assertion message.").createAssertionError((Throwable) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertion("assertion message.").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertion("assertion message.").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");
    }

}
