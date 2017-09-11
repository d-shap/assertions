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
package ru.d_shap.assertions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.junit.Test;

import ru.d_shap.assertions.collection.CollectionAssertion;
import ru.d_shap.assertions.collection.ListAssertion;
import ru.d_shap.assertions.collection.MapAssertion;
import ru.d_shap.assertions.core.IterableAssertion;
import ru.d_shap.assertions.core.ObjectAssertion;

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
    public void asTest() {
        Object object = new Object();
        BaseAssertionImpl baseAssertion = new BaseAssertionImpl(object, null);
        Assertions.assertThat(baseAssertion.as(BaseAssertionImpl.class).getClass()).isEqualTo(BaseAssertionImpl.class);
        Assertions.assertThat(baseAssertion.as(BaseAssertionImpl.class)).isNotSameAs(baseAssertion);
        Assertions.assertThat(baseAssertion.as(BaseAssertionImpl.class).getActual()).isSameAs(object);

        Assertions.assertThat(baseAssertion.as(ObjectAssertion.class).getClass()).isEqualTo(ObjectAssertion.class);
        baseAssertion.as(ObjectAssertion.class).isSameAs(object);

        Assertions.assertThat(new ListAssertion(new ArrayList<String>(), null).as(ListAssertion.class)).hasClass(ListAssertion.class);
        Assertions.assertThat(new ListAssertion(new ArrayList<String>(), null).as(CollectionAssertion.class)).hasClass(CollectionAssertion.class);
        Assertions.assertThat(new ListAssertion(new ArrayList<String>(), null).as(IterableAssertion.class)).hasClass(IterableAssertion.class);
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asWrongConstructorFailTest() {
        try {
            new BaseAssertionImpl(new Object(), null).as(BaseAssertionWrongConstructorImpl.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionWrongConstructorImpl - class should have one constructor(Object.class, String.class)");
        }
        try {
            new ListAssertion(new ArrayList<String>(), null).as(MapAssertion.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.collection.MapAssertion - class should have one constructor(Object.class, String.class)");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asIllegalAccessFailTest() {
        try {
            new BaseAssertionImpl(new Object(), null).as(BaseAssertionIllegalAccessImpl.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionIllegalAccessImpl");
            Assertions.assertThat(ex).isCauseInstanceOf(IllegalAccessException.class);
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asInvocationTargetFailTest() {
        try {
            new BaseAssertionImpl(new Object(), null).as(BaseAssertionInvocationTargetImpl.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionInvocationTargetImpl");
            Assertions.assertThat(ex).isCauseInstanceOf(InvocationTargetException.class);
            Assertions.assertThat(ex).toCause().isCauseInstanceOf(RuntimeException.class);
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void asInstantiationFailTest() {
        try {
            new BaseAssertionImpl(new Object(), null).as(BaseAssertionInstantiationImpl.class);
            Assertions.fail("Base assertion test fail");
        } catch (WrongAssertionClassError ex) {
            Assertions.assertThat(ex).hasMessage("Wrong assertion class: ru.d_shap.assertions.BaseAssertionTest$BaseAssertionInstantiationImpl");
            Assertions.assertThat(ex).isCauseInstanceOf(InstantiationException.class);
        }
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
    public void checkArgumentIsNotEmptyTrueTest() {
        new BaseAssertionImpl(null, null).checkArgumentIsNotEmptyTrue(false);

        try {
            new BaseAssertionImpl(null, null).checkArgumentIsNotEmptyTrue(true);
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void checkArgumentIsNotEmptyFalseTest() {
        new BaseAssertionImpl(null, null).checkArgumentIsNotEmptyFalse(false);

        try {
            new BaseAssertionImpl(null, null).checkArgumentIsNotEmptyFalse(true);
            Assertions.fail("Base assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
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

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError((Throwable) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError((Throwable) null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError((Throwable) null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError((Throwable) null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError((Throwable) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError((Throwable) null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError((Throwable) null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void createAssertionErrorWithFailMessageAndThrowableTest() {
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError(null, new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", null).getMessage()).isEqualTo("fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", new RuntimeException()).getMessage()).isEqualTo("fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, null).createAssertionError("fail message", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError(null, new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", null).getMessage()).isEmpty();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", new RuntimeException()).getMessage()).isEqualTo("java.lang.RuntimeException");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("java.lang.RuntimeException: some runtime exception");

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", null).getMessage()).isEqualTo("fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", new RuntimeException()).getMessage()).isEqualTo("fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "").createAssertionError("fail message", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError(null, new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", null).getMessage()).isEqualTo("assertion message. fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", new RuntimeException()).getMessage()).isEqualTo("assertion message. fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message").createAssertionError("fail message", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message. fail message");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError(null, new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", null).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", new RuntimeException()).getMessage()).isEqualTo("assertion message.");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message.");

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", null).getCause()).isNull();
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", new RuntimeException()).getCause()).isInstanceOf(RuntimeException.class);
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", new RuntimeException("some runtime exception")).getCause()).isInstanceOf(RuntimeException.class);

        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", null).getMessage()).isEqualTo("assertion message. fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", new RuntimeException()).getMessage()).isEqualTo("assertion message. fail message");
        Assertions.assertThat(new BaseAssertionImpl(null, "assertion message.").createAssertionError("fail message", new RuntimeException("some runtime exception")).getMessage()).isEqualTo("assertion message. fail message");
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

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionWrongConstructorImpl extends BaseAssertion {

        BaseAssertionWrongConstructorImpl(final Object actual) {
            super(actual, null);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionIllegalAccessImpl extends BaseAssertion {

        private BaseAssertionIllegalAccessImpl(final Object actual, final String message) {
            super(actual, message);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class BaseAssertionInvocationTargetImpl extends BaseAssertion {

        BaseAssertionInvocationTargetImpl(final Object actual, final String message) {
            super(actual, message);
            throw new RuntimeException();
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static abstract class BaseAssertionInstantiationImpl extends BaseAssertion {

        BaseAssertionInstantiationImpl(final Object actual, final String message) {
            super(actual, message);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

}
