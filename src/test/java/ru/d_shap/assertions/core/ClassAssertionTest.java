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

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ClassAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ClassAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ClassAssertionTest() {
        super();
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.classAssertion(), Integer.class).isEqualTo(Integer.class);
        initialize(Raw.classAssertion(), String.class).isEqualTo(String.class);

        try {
            initialize(Raw.classAssertion(), null).isEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isEqualTo(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<java.lang.Integer> but was:<java.lang.String>.");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.classAssertion(), Integer.class).isNotEqualTo(String.class);
        initialize(Raw.classAssertion(), String.class).isNotEqualTo(Object.class);

        try {
            initialize(Raw.classAssertion(), null).isNotEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isNotEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotEqualTo(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<java.lang.String>.");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isSubtypeOfTest() {
        initialize(Raw.classAssertion(), Integer.class).isSubtypeOf(Integer.class);
        initialize(Raw.classAssertion(), Integer.class).isSubtypeOf(Object.class);
        initialize(Raw.classAssertion(), Integer.class).isSubtypeOf(Comparable.class);

        initialize(Raw.classAssertion(), String.class).isSubtypeOf(String.class);
        initialize(Raw.classAssertion(), String.class).isSubtypeOf(Object.class);
        initialize(Raw.classAssertion(), String.class).isSubtypeOf(Serializable.class);
        initialize(Raw.classAssertion(), String.class).isSubtypeOf(CharSequence.class);

        try {
            initialize(Raw.classAssertion(), null).isSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.Integer> but was:<java.lang.String>.");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.String> but was:<java.lang.Integer>.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.Integer> but was:<java.lang.Object>.");
        }
        try {
            initialize(Raw.classAssertion(), Comparable.class).isSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.Integer> but was:<java.lang.Comparable>.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.String> but was:<java.lang.Object>.");
        }
        try {
            initialize(Raw.classAssertion(), Serializable.class).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.String> but was:<java.io.Serializable>.");
        }
        try {
            initialize(Raw.classAssertion(), CharSequence.class).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.String> but was:<java.lang.CharSequence>.");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNotSubtypeOfTest() {
        initialize(Raw.classAssertion(), String.class).isNotSubtypeOf(Integer.class);
        initialize(Raw.classAssertion(), Integer.class).isNotSubtypeOf(String.class);
        initialize(Raw.classAssertion(), Object.class).isNotSubtypeOf(Integer.class);
        initialize(Raw.classAssertion(), Comparable.class).isNotSubtypeOf(Integer.class);
        initialize(Raw.classAssertion(), Object.class).isNotSubtypeOf(String.class);
        initialize(Raw.classAssertion(), Serializable.class).isNotSubtypeOf(String.class);
        initialize(Raw.classAssertion(), CharSequence.class).isNotSubtypeOf(String.class);

        try {
            initialize(Raw.classAssertion(), null).isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isNotSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isNotSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Integer> but was:<java.lang.Integer>.");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.Integer>.");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isNotSubtypeOf(Comparable.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Comparable> but was:<java.lang.Integer>.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.String> but was:<java.lang.String>.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.String>.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotSubtypeOf(Serializable.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.io.Serializable> but was:<java.lang.String>.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotSubtypeOf(CharSequence.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.CharSequence> but was:<java.lang.String>.");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void hasOnePrivateConstructorTest() {
        initialize(Raw.classAssertion(), Math.class).hasOnePrivateConstructor();

        try {
            initialize(Raw.classAssertion(), null).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), int.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should have one default constructor. Actual:<int>.");
        }
        try {
            initialize(Raw.classAssertion(), Appendable.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should have one default constructor. Actual:<java.lang.Appendable>.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should have one default constructor. Actual:<java.lang.String>.");
        }
        try {
            initialize(Raw.classAssertion(), Character.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should have one default constructor. Actual:<java.lang.Character>.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value constructor should not be acccessible. Actual:<java.lang.Object>.");
        }
        try {
            initialize(Raw.classAssertion(), Number.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value constructor should not be acccessible. Actual:<java.lang.Number>.");
        }
        try {
            initialize(Raw.classAssertion(), AbstractClass.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).isCauseInstanceOf(InstantiationException.class);
        }
        try {
            initialize(Raw.classAssertion(), FailConstructorClass.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).isCauseInstanceOf(InvocationTargetException.class);
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void asEnumTest() {
        initialize(Raw.classAssertion(), null).asEnum().isNull();
        initialize(Raw.classAssertion(), Values.class).asEnum().hasValueCount(3);

        try {
            initialize(Raw.classAssertion(), Values.class).asEnum().hasValueCount(4);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check enum value count. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            initialize(Raw.classAssertion(), Values.class, "Message").asEnum().hasValueCount(4);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check enum value count. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.classAssertion(), null).isNull();

        try {
            initialize(Raw.classAssertion(), Object.class).isNull();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<java.lang.Object>.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNull();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<java.lang.Object>.");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        initialize(Raw.classAssertion(), Object.class).isSameAs(Object.class);

        try {
            initialize(Raw.classAssertion(), Object.class).isSameAs(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<java.lang.String> but was:<java.lang.Object>.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isSameAs(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<java.lang.String> but was:<java.lang.Object>.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isSameAs("test");
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<java.lang.Object>.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isSameAs("test");
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<java.lang.Object>.");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        initialize(Raw.classAssertion(), Object.class).isNotSameAs(String.class);
        initialize(Raw.classAssertion(), Object.class).isNotSameAs("test");

        try {
            initialize(Raw.classAssertion(), Object.class).isNotSameAs(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<java.lang.Object>.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNotSameAs(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<java.lang.Object>.");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.classAssertion(), Values.class).asString(null));
            Assertions.fail("ClassAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.classAssertion(), Values.class).asString(Object.class)).isEqualTo("java.lang.Object");
        Assertions.assertThat(initialize(Raw.classAssertion(), Values.class).asString(Values.class)).isEqualTo("ru.d_shap.assertions.core.ClassAssertionTest$Values");
        Assertions.assertThat(initialize(Raw.classAssertion(), Values.class).asString("test")).isEqualTo("test");
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private abstract static class AbstractClass {

        private AbstractClass() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class FailConstructorClass {

        private FailConstructorClass() {
            super();
            throw new RuntimeException("Exception in instantiation");
        }

    }

}
