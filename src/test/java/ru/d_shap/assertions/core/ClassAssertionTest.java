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

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

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
    public void isSubtypeOfTest() {
        new ClassAssertion(Integer.class, null).isSubtypeOf(Integer.class);
        new ClassAssertion(Integer.class, null).isSubtypeOf(Object.class);
        new ClassAssertion(Integer.class, null).isSubtypeOf(Comparable.class);

        new ClassAssertion(String.class, null).isSubtypeOf(String.class);
        new ClassAssertion(String.class, null).isSubtypeOf(Object.class);
        new ClassAssertion(String.class, null).isSubtypeOf(Serializable.class);
        new ClassAssertion(String.class, null).isSubtypeOf(CharSequence.class);

        try {
            new ClassAssertion(String.class, null).isSubtypeOf(Integer.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should be the subtype of the expected class. Expected:<class java.lang.Integer> but was:<class java.lang.String>");
        }
        try {
            new ClassAssertion(Integer.class, null).isSubtypeOf(String.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should be the subtype of the expected class. Expected:<class java.lang.String> but was:<class java.lang.Integer>");
        }
        try {
            new ClassAssertion(Object.class, null).isSubtypeOf(Integer.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should be the subtype of the expected class. Expected:<class java.lang.Integer> but was:<class java.lang.Object>");
        }
        try {
            new ClassAssertion(Comparable.class, null).isSubtypeOf(Integer.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should be the subtype of the expected class. Expected:<class java.lang.Integer> but was:<interface java.lang.Comparable>");
        }
        try {
            new ClassAssertion(Object.class, null).isSubtypeOf(String.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should be the subtype of the expected class. Expected:<class java.lang.String> but was:<class java.lang.Object>");
        }
        try {
            new ClassAssertion(Serializable.class, null).isSubtypeOf(String.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should be the subtype of the expected class. Expected:<class java.lang.String> but was:<interface java.io.Serializable>");
        }
        try {
            new ClassAssertion(CharSequence.class, null).isSubtypeOf(String.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should be the subtype of the expected class. Expected:<class java.lang.String> but was:<interface java.lang.CharSequence>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNotSubtypeOfTest() {
        new ClassAssertion(String.class, null).isNotSubtypeOf(Integer.class);
        new ClassAssertion(Integer.class, null).isNotSubtypeOf(String.class);
        new ClassAssertion(Object.class, null).isNotSubtypeOf(Integer.class);
        new ClassAssertion(Comparable.class, null).isNotSubtypeOf(Integer.class);
        new ClassAssertion(Object.class, null).isNotSubtypeOf(String.class);
        new ClassAssertion(Serializable.class, null).isNotSubtypeOf(String.class);
        new ClassAssertion(CharSequence.class, null).isNotSubtypeOf(String.class);

        try {
            new ClassAssertion(Integer.class, null).isNotSubtypeOf(Integer.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should not be the subtype of the expected class. Expected:<class java.lang.Integer> but was:<class java.lang.Integer>");
        }
        try {
            new ClassAssertion(Integer.class, null).isNotSubtypeOf(Object.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should not be the subtype of the expected class. Expected:<class java.lang.Object> but was:<class java.lang.Integer>");
        }
        try {
            new ClassAssertion(Integer.class, null).isNotSubtypeOf(Comparable.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should not be the subtype of the expected class. Expected:<interface java.lang.Comparable> but was:<class java.lang.Integer>");
        }
        try {
            new ClassAssertion(String.class, null).isNotSubtypeOf(String.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should not be the subtype of the expected class. Expected:<class java.lang.String> but was:<class java.lang.String>");
        }
        try {
            new ClassAssertion(String.class, null).isNotSubtypeOf(Object.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should not be the subtype of the expected class. Expected:<class java.lang.Object> but was:<class java.lang.String>");
        }
        try {
            new ClassAssertion(String.class, null).isNotSubtypeOf(Serializable.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should not be the subtype of the expected class. Expected:<interface java.io.Serializable> but was:<class java.lang.String>");
        }
        try {
            new ClassAssertion(String.class, null).isNotSubtypeOf(CharSequence.class);
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should not be the subtype of the expected class. Expected:<interface java.lang.CharSequence> but was:<class java.lang.String>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void hasOnePrivateConstructorTest() {
        try {
            new ClassAssertion(int.class, null).hasOnePrivateConstructor();
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should have one default constructor.");
        }
        try {
            new ClassAssertion(Appendable.class, null).hasOnePrivateConstructor();
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should have one default constructor.");
        }
        try {
            new ClassAssertion(String.class, null).hasOnePrivateConstructor();
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should have one default constructor.");
        }
        try {
            new ClassAssertion(Character.class, null).hasOnePrivateConstructor();
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should have one default constructor.");
        }
        try {
            new ClassAssertion(Object.class, null).hasOnePrivateConstructor();
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class constructor should not be acccessible.");
        }
        try {
            new ClassAssertion(Number.class, null).hasOnePrivateConstructor();
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class constructor should not be acccessible.");
        }

        new ClassAssertion(Math.class, null).hasOnePrivateConstructor();

        try {
            new ClassAssertion(AbstractClass.class, null).hasOnePrivateConstructor();
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasCauseInstanceOf(InstantiationException.class);
        }
        try {
            new ClassAssertion(FailClass.class, null).hasOnePrivateConstructor();
            Assertions.fail("Class assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasCauseInstanceOf(InvocationTargetException.class);
        }
    }

    /**
     * Non-instantiatable class.
     *
     * @author Dmitry Shapovalov
     */
    private abstract static class AbstractClass {

        private AbstractClass() {
            super();
        }

    }

    /**
     * Non-instantiatable class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class FailClass {

        private FailClass() {
            super();
            throw new IllegalStateException("Exception in instantiation");
        }

    }

}
