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

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link ClassAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ClassAssertionTest {

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
        new ClassAssertion(Integer.class, new FailDescription()).isEqualTo(Integer.class);
        new ClassAssertion(String.class, new FailDescription()).isEqualTo(String.class);

        try {
            new ClassAssertion(null, new FailDescription()).isEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription()).isEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ClassAssertion(String.class, new FailDescription()).isEqualTo(Integer.class);
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
        new ClassAssertion(Integer.class, new FailDescription()).isNotEqualTo(String.class);
        new ClassAssertion(String.class, new FailDescription()).isNotEqualTo(Object.class);

        try {
            new ClassAssertion(null, new FailDescription()).isNotEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription()).isNotEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ClassAssertion(String.class, new FailDescription()).isNotEqualTo(String.class);
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
        new ClassAssertion(Integer.class, new FailDescription()).isSubtypeOf(Integer.class);
        new ClassAssertion(Integer.class, new FailDescription()).isSubtypeOf(Object.class);
        new ClassAssertion(Integer.class, new FailDescription()).isSubtypeOf(Comparable.class);

        new ClassAssertion(String.class, new FailDescription()).isSubtypeOf(String.class);
        new ClassAssertion(String.class, new FailDescription()).isSubtypeOf(Object.class);
        new ClassAssertion(String.class, new FailDescription()).isSubtypeOf(Serializable.class);
        new ClassAssertion(String.class, new FailDescription()).isSubtypeOf(CharSequence.class);

        try {
            new ClassAssertion(null, new FailDescription()).isSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription()).isSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ClassAssertion(String.class, new FailDescription()).isSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.Integer> but was:<java.lang.String>.");
        }
        try {
            new ClassAssertion(Integer.class, new FailDescription()).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.String> but was:<java.lang.Integer>.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription()).isSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.Integer> but was:<java.lang.Object>.");
        }
        try {
            new ClassAssertion(Comparable.class, new FailDescription()).isSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.Integer> but was:<java.lang.Comparable>.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription()).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.String> but was:<java.lang.Object>.");
        }
        try {
            new ClassAssertion(Serializable.class, new FailDescription()).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.String> but was:<java.io.Serializable>.");
        }
        try {
            new ClassAssertion(CharSequence.class, new FailDescription()).isSubtypeOf(String.class);
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
        new ClassAssertion(String.class, new FailDescription()).isNotSubtypeOf(Integer.class);
        new ClassAssertion(Integer.class, new FailDescription()).isNotSubtypeOf(String.class);
        new ClassAssertion(Object.class, new FailDescription()).isNotSubtypeOf(Integer.class);
        new ClassAssertion(Comparable.class, new FailDescription()).isNotSubtypeOf(Integer.class);
        new ClassAssertion(Object.class, new FailDescription()).isNotSubtypeOf(String.class);
        new ClassAssertion(Serializable.class, new FailDescription()).isNotSubtypeOf(String.class);
        new ClassAssertion(CharSequence.class, new FailDescription()).isNotSubtypeOf(String.class);

        try {
            new ClassAssertion(null, new FailDescription()).isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription()).isNotSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ClassAssertion(Integer.class, new FailDescription()).isNotSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Integer> but was:<java.lang.Integer>.");
        }
        try {
            new ClassAssertion(Integer.class, new FailDescription()).isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.Integer>.");
        }
        try {
            new ClassAssertion(Integer.class, new FailDescription()).isNotSubtypeOf(Comparable.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Comparable> but was:<java.lang.Integer>.");
        }
        try {
            new ClassAssertion(String.class, new FailDescription()).isNotSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.String> but was:<java.lang.String>.");
        }
        try {
            new ClassAssertion(String.class, new FailDescription()).isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.String>.");
        }
        try {
            new ClassAssertion(String.class, new FailDescription()).isNotSubtypeOf(Serializable.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.io.Serializable> but was:<java.lang.String>.");
        }
        try {
            new ClassAssertion(String.class, new FailDescription()).isNotSubtypeOf(CharSequence.class);
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
        new ClassAssertion(Math.class, new FailDescription()).hasOnePrivateConstructor();

        try {
            new ClassAssertion(null, new FailDescription()).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ClassAssertion(int.class, new FailDescription()).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should have one default constructor. Actual:<int>.");
        }
        try {
            new ClassAssertion(Appendable.class, new FailDescription()).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should have one default constructor. Actual:<java.lang.Appendable>.");
        }
        try {
            new ClassAssertion(String.class, new FailDescription()).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should have one default constructor. Actual:<java.lang.String>.");
        }
        try {
            new ClassAssertion(Character.class, new FailDescription()).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should have one default constructor. Actual:<java.lang.Character>.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription()).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value constructor should not be acccessible. Actual:<java.lang.Object>.");
        }
        try {
            new ClassAssertion(Number.class, new FailDescription()).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value constructor should not be acccessible. Actual:<java.lang.Number>.");
        }
        try {
            new ClassAssertion(AbstractClass.class, new FailDescription()).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).isCauseInstanceOf(InstantiationException.class);
        }
        try {
            new ClassAssertion(FailConstructorClass.class, new FailDescription()).hasOnePrivateConstructor();
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
        new ClassAssertion(null, new FailDescription()).asEnum().isNull();
        new ClassAssertion(Values.class, new FailDescription()).asEnum().hasValueCount(3);

        try {
            new ClassAssertion(Values.class, new FailDescription()).asEnum().hasValueCount(4);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check enum value count. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new ClassAssertion(Values.class, new FailDescription("Message")).asEnum().hasValueCount(4);
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
        new ClassAssertion(null, new FailDescription()).isNull();

        try {
            new ClassAssertion(Object.class, new FailDescription()).isNull();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<java.lang.Object>.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription("Message")).isNull();
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
        new ClassAssertion(Object.class, new FailDescription()).isSameAs(Object.class);

        try {
            new ClassAssertion(Object.class, new FailDescription()).isSameAs(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<java.lang.String> but was:<java.lang.Object>.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription("Message")).isSameAs(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<java.lang.String> but was:<java.lang.Object>.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription()).isSameAs("test");
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<java.lang.Object>.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription("Message")).isSameAs("test");
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
        new ClassAssertion(Object.class, new FailDescription()).isNotSameAs(String.class);
        new ClassAssertion(Object.class, new FailDescription()).isNotSameAs("test");

        try {
            new ClassAssertion(Object.class, new FailDescription()).isNotSameAs(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<java.lang.Object>.");
        }
        try {
            new ClassAssertion(Object.class, new FailDescription("Message")).isNotSameAs(Object.class);
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
        Assertions.assertThat(new ClassAssertion(Values.class, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new ClassAssertion(Values.class, new FailDescription()).asString(Object.class)).isEqualTo("java.lang.Object");
        Assertions.assertThat(new ClassAssertion(Values.class, new FailDescription()).asString(Values.class)).isEqualTo("ru.d_shap.assertions.core.ClassAssertionTest$Values");
        Assertions.assertThat(new ClassAssertion(Values.class, new FailDescription()).asString("test")).isEqualTo("test");
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

    /**
     * Test enum.
     *
     * @author Dmitry Shapovalov
     */
    private enum Values {

        VALUE_1, VALUE_2, VALUE_3

    }

}
