///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
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
    public void getActualTest() {
        Object object = new Object();
        Assertions.assertThat(new BaseAssertionImpl(object, null).getActual()).isNotNull();
        Assertions.assertThat(new BaseAssertionImpl(object, null).getActual()).isSameAs(object);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void getMessageTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, null).getMessage()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "some message").getMessage()).isEqualTo("some message");

        try {
            Assertions.assertThat(new BaseAssertionImpl(null, "some message").getMessage()).isEqualTo("some other message");
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<some other message> but was:<some message>");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkActualIsNotNullTest() {
        new BaseAssertionImpl(new Object(), null).checkActualIsNotNull();
        new BaseAssertionImpl("test", null).checkActualIsNotNull();

        try {
            new BaseAssertionImpl(null, null).checkActualIsNotNull();
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotNullTest() {
        new BaseAssertionImpl(null, null).checkArgumentIsNotNull(new Object());
        new BaseAssertionImpl(null, null).checkArgumentIsNotNull("test");
        new BaseAssertionImpl(null, null).checkArgumentIsNotNull(1);

        try {
            new BaseAssertionImpl(null, null).checkArgumentIsNotNull(null);
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotEmpty() {
        new BaseAssertionImpl(null, null).checkArgumentIsNotEmpty(false);

        try {
            new BaseAssertionImpl(null, null).checkArgumentIsNotEmpty(true);
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithFailMessageTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError((String) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("").getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message").getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError((String) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("").getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message").getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError((String) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("").getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message").getMessage()).isEqualTo("assertion message. fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError((String) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("").getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message").getMessage()).isEqualTo("assertion message. fail message");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithThrowableTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError((Throwable) null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError((Throwable) null).getMessage()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError((Throwable) null).getMessage()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError((Throwable) null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError((Throwable) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError((Throwable) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void actualAsStringTest() {
        Assertions.assertThat(new BaseAssertionImpl("value", null).actualAsString()).isEqualTo("value");
        Assertions.assertThat(new BaseAssertionImpl(1, null).actualAsString()).isEqualTo("1");
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionImpl extends BaseAssertion {

        BaseAssertionImpl(final Object actual, final String message) {
            super(actual, message);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

}
