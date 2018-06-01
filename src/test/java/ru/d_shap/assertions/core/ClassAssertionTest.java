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
    public void actualValueValidatorTest() {
        initialize(Raw.classAssertion(), String.class);

        try {
            initializeWithRawActual(Raw.classAssertion(), new Object());
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.classAssertion(), new Object(), "Message");
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.classAssertion(), Integer.class).isEqualTo(Integer.class);
        initialize(Raw.classAssertion(), String.class).isEqualTo(String.class);

        try {
            Raw.classAssertion().isEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null).isEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isEqualTo(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<java.lang.Integer> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), String.class, "Message").isEqualTo(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.Integer> but was:<java.lang.String>");
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
            Raw.classAssertion().isNotEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isNotEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isNotEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null).isNotEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isNotEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNotEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotEqualTo(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), String.class, "Message").isNotEqualTo(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<java.lang.String>");
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
            Raw.classAssertion().isSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null).isSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.Integer> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.Integer>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.Integer> but was:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Comparable.class).isSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.Integer> but was:<java.lang.Comparable>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Serializable.class).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.String> but was:<java.io.Serializable>");
        }
        try {
            initialize(Raw.classAssertion(), CharSequence.class).isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the subtype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.CharSequence>");
        }
        try {
            initialize(Raw.classAssertion(), CharSequence.class, "Message").isSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.CharSequence>");
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
            Raw.classAssertion().isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null).isNotSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isNotSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isNotSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNotSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isNotSubtypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the subtype of the expected value.\n\tExpected:<java.lang.Integer> but was:<java.lang.Integer>");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the subtype of the expected value.\n\tExpected:<java.lang.Object> but was:<java.lang.Integer>");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isNotSubtypeOf(Comparable.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the subtype of the expected value.\n\tExpected:<java.lang.Comparable> but was:<java.lang.Integer>");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotSubtypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the subtype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotSubtypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the subtype of the expected value.\n\tExpected:<java.lang.Object> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotSubtypeOf(Serializable.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the subtype of the expected value.\n\tExpected:<java.io.Serializable> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotSubtypeOf(CharSequence.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the subtype of the expected value.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), String.class, "Message").isNotSubtypeOf(CharSequence.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.String>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isSupertypeOfTest() {
        initialize(Raw.classAssertion(), Integer.class).isSupertypeOf(Integer.class);
        initialize(Raw.classAssertion(), Object.class).isSupertypeOf(Integer.class);
        initialize(Raw.classAssertion(), Comparable.class).isSupertypeOf(Integer.class);

        initialize(Raw.classAssertion(), String.class).isSupertypeOf(String.class);
        initialize(Raw.classAssertion(), Object.class).isSupertypeOf(String.class);
        initialize(Raw.classAssertion(), Serializable.class).isSupertypeOf(String.class);
        initialize(Raw.classAssertion(), CharSequence.class).isSupertypeOf(String.class);

        try {
            Raw.classAssertion().isSupertypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isSupertypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isSupertypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null).isSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isSupertypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the supertype of the expected value.\n\tExpected:<java.lang.Integer> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isSupertypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the supertype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.Integer>");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isSupertypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the supertype of the expected value.\n\tExpected:<java.lang.Object> but was:<java.lang.Integer>");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isSupertypeOf(Comparable.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the supertype of the expected value.\n\tExpected:<java.lang.Comparable> but was:<java.lang.Integer>");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isSupertypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the supertype of the expected value.\n\tExpected:<java.lang.Object> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isSupertypeOf(Serializable.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the supertype of the expected value.\n\tExpected:<java.io.Serializable> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isSupertypeOf(CharSequence.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the supertype of the expected value.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), String.class, "Message").isSupertypeOf(CharSequence.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the supertype of the expected value.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.String>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNotSupertypeOfTest() {
        initialize(Raw.classAssertion(), String.class).isNotSupertypeOf(Integer.class);
        initialize(Raw.classAssertion(), Integer.class).isNotSupertypeOf(String.class);
        initialize(Raw.classAssertion(), Integer.class).isNotSupertypeOf(Object.class);
        initialize(Raw.classAssertion(), Integer.class).isNotSupertypeOf(Comparable.class);
        initialize(Raw.classAssertion(), String.class).isNotSupertypeOf(Object.class);
        initialize(Raw.classAssertion(), String.class).isNotSupertypeOf(Serializable.class);
        initialize(Raw.classAssertion(), String.class).isNotSupertypeOf(CharSequence.class);

        try {
            Raw.classAssertion().isNotSupertypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isNotSupertypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isNotSupertypeOf(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null).isNotSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isNotSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isNotSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNotSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Integer.class).isNotSupertypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the supertype of the expected value.\n\tExpected:<java.lang.Integer> but was:<java.lang.Integer>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isNotSupertypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the supertype of the expected value.\n\tExpected:<java.lang.Integer> but was:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Comparable.class).isNotSupertypeOf(Integer.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the supertype of the expected value.\n\tExpected:<java.lang.Integer> but was:<java.lang.Comparable>");
        }
        try {
            initialize(Raw.classAssertion(), String.class).isNotSupertypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the supertype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isNotSupertypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the supertype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Serializable.class).isNotSupertypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the supertype of the expected value.\n\tExpected:<java.lang.String> but was:<java.io.Serializable>");
        }
        try {
            initialize(Raw.classAssertion(), CharSequence.class).isNotSupertypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the supertype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.CharSequence>");
        }
        try {
            initialize(Raw.classAssertion(), CharSequence.class, "Message").isNotSupertypeOf(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the supertype of the expected value.\n\tExpected:<java.lang.String> but was:<java.lang.CharSequence>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void hasOnePrivateConstructorTest() {
        initialize(Raw.classAssertion(), Math.class).hasOnePrivateConstructor();

        try {
            Raw.classAssertion().hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), int.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have one default constructor.\n\tActual:<int>");
        }
        try {
            initialize(Raw.classAssertion(), Appendable.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have one default constructor.\n\tActual:<java.lang.Appendable>");
        }
        try {
            initialize(Raw.classAssertion(), String.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have one default constructor.\n\tActual:<java.lang.String>");
        }
        try {
            initialize(Raw.classAssertion(), Character.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have one default constructor.\n\tActual:<java.lang.Character>");
        }
        try {
            initialize(Raw.classAssertion(), Character.class, "Message").hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have one default constructor.\n\tActual:<java.lang.Character>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value's constructor should not be acccessible.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Number.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value's constructor should not be acccessible.\n\tActual:<java.lang.Number>");
        }
        try {
            initialize(Raw.classAssertion(), Number.class, "Message").hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value's constructor should not be acccessible.\n\tActual:<java.lang.Number>");
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
            Raw.classAssertion().asEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), Values.class).asEnum().hasValueCount(4);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value count.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.classAssertion(), Values.class, "Message").asEnum().hasValueCount(4);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's value count.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNull();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<java.lang.Object>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isSameAs(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        initialize(Raw.classAssertion(), Object.class).isNotSameAs(String.class);

        try {
            initialize(Raw.classAssertion(), Object.class).isNotSameAs(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNotSameAs(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<java.lang.Object>");
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
        Assertions.assertThat(initialize(Raw.classAssertion(), Values.class).asString(Values.class)).isEqualTo("ru.d_shap.assertions.AssertionTest$Values");
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
