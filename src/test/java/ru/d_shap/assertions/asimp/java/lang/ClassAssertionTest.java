///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions library provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions library.
//
// Assertions library is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.asimp.java.lang;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.ReflectionException;

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
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Class> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.classAssertion(), new Object(), "Message");
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Class> but was:<java.lang.Object>");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNotEqualTo(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNotSubtypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
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
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNotSupertypeOf(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
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
    public void isInterfaceTest() {
        initialize(Raw.classAssertion(), Collection.class).isInterface();
        initialize(Raw.classAssertion(), List.class).isInterface();
        initialize(Raw.classAssertion(), Set.class).isInterface();
        initialize(Raw.classAssertion(), Map.class).isInterface();

        try {
            Raw.classAssertion().isInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), ArrayList.class).isInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the interface type.\n\tActual:<java.util.ArrayList>");
        }
        try {
            initialize(Raw.classAssertion(), ArrayList.class, "Message").isInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the interface type.\n\tActual:<java.util.ArrayList>");
        }
        try {
            initialize(Raw.classAssertion(), HashSet.class).isInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the interface type.\n\tActual:<java.util.HashSet>");
        }
        try {
            initialize(Raw.classAssertion(), HashSet.class, "Message").isInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the interface type.\n\tActual:<java.util.HashSet>");
        }
        try {
            initialize(Raw.classAssertion(), HashMap.class).isInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the interface type.\n\tActual:<java.util.HashMap>");
        }
        try {
            initialize(Raw.classAssertion(), HashMap.class, "Message").isInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the interface type.\n\tActual:<java.util.HashMap>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNotInterfaceTest() {
        initialize(Raw.classAssertion(), ArrayList.class).isNotInterface();
        initialize(Raw.classAssertion(), HashSet.class).isNotInterface();
        initialize(Raw.classAssertion(), HashMap.class).isNotInterface();

        try {
            Raw.classAssertion().isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Collection.class).isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the interface type.\n\tActual:<java.util.Collection>");
        }
        try {
            initialize(Raw.classAssertion(), Collection.class, "Message").isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the interface type.\n\tActual:<java.util.Collection>");
        }
        try {
            initialize(Raw.classAssertion(), List.class).isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the interface type.\n\tActual:<java.util.List>");
        }
        try {
            initialize(Raw.classAssertion(), List.class, "Message").isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the interface type.\n\tActual:<java.util.List>");
        }
        try {
            initialize(Raw.classAssertion(), Set.class).isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the interface type.\n\tActual:<java.util.Set>");
        }
        try {
            initialize(Raw.classAssertion(), Set.class, "Message").isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the interface type.\n\tActual:<java.util.Set>");
        }
        try {
            initialize(Raw.classAssertion(), Map.class).isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the interface type.\n\tActual:<java.util.Map>");
        }
        try {
            initialize(Raw.classAssertion(), Map.class, "Message").isNotInterface();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the interface type.\n\tActual:<java.util.Map>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isArrayTest() {
        initialize(Raw.classAssertion(), Object[].class).isArray();
        initialize(Raw.classAssertion(), Object[][].class).isArray();
        initialize(Raw.classAssertion(), String[].class).isArray();
        initialize(Raw.classAssertion(), String[][].class).isArray();
        initialize(Raw.classAssertion(), int[].class).isArray();
        initialize(Raw.classAssertion(), int[][].class).isArray();

        try {
            Raw.classAssertion().isArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the array type.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the array type.\n\tActual:<java.lang.Object>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNotArrayTest() {
        initialize(Raw.classAssertion(), Object.class).isNotArray();
        initialize(Raw.classAssertion(), String.class).isNotArray();
        initialize(Raw.classAssertion(), int.class).isNotArray();

        try {
            Raw.classAssertion().isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class).isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the array type.\n\tActual:<[Ljava.lang.Object;>");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class, "Message").isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the array type.\n\tActual:<[Ljava.lang.Object;>");
        }
        try {
            initialize(Raw.classAssertion(), Object[][].class).isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the array type.\n\tActual:<[[Ljava.lang.Object;>");
        }
        try {
            initialize(Raw.classAssertion(), Object[][].class, "Message").isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the array type.\n\tActual:<[[Ljava.lang.Object;>");
        }
        try {
            initialize(Raw.classAssertion(), String[].class).isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the array type.\n\tActual:<[Ljava.lang.String;>");
        }
        try {
            initialize(Raw.classAssertion(), String[].class, "Message").isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the array type.\n\tActual:<[Ljava.lang.String;>");
        }
        try {
            initialize(Raw.classAssertion(), int[].class).isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the array type.\n\tActual:<[I>");
        }
        try {
            initialize(Raw.classAssertion(), int[].class, "Message").isNotArray();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the array type.\n\tActual:<[I>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isEnumTest() {
        initialize(Raw.classAssertion(), Values.class).isEnum();

        try {
            Raw.classAssertion().isEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).isEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the enum type.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the enum type.\n\tActual:<java.lang.Object>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void isNotEnumTest() {
        initialize(Raw.classAssertion(), Object.class).isNotEnum();
        initialize(Raw.classAssertion(), String.class).isNotEnum();
        initialize(Raw.classAssertion(), int.class).isNotEnum();

        try {
            Raw.classAssertion().isNotEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).isNotEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").isNotEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Values.class).isNotEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be the enum type.\n\tActual:<ru.d_shap.assertions.AssertionTest$Values>");
        }
        try {
            initialize(Raw.classAssertion(), Values.class, "Message").isNotEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be the enum type.\n\tActual:<ru.d_shap.assertions.AssertionTest$Values>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void toComponentTypeTest() {
        initialize(Raw.classAssertion(), Object[].class).toComponentType().isEqualTo(Object.class);
        initialize(Raw.classAssertion(), Object[][].class).toComponentType().isEqualTo(Object[].class);
        initialize(Raw.classAssertion(), String[].class).toComponentType().isEqualTo(String.class);
        initialize(Raw.classAssertion(), String[][].class).toComponentType().isEqualTo(String[].class);
        initialize(Raw.classAssertion(), int[].class).toComponentType().isEqualTo(int.class);
        initialize(Raw.classAssertion(), int[][].class).toComponentType().isEqualTo(int[].class);

        try {
            Raw.classAssertion().toComponentType();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).toComponentType();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").toComponentType();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).toComponentType();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the array type.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").toComponentType();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the array type.\n\tActual:<java.lang.Object>");
        }
        try {
            clearActual(initialize(Raw.classAssertion(), Object[].class).toComponentType()).isEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's component type.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.classAssertion(), Object[].class, "Message").toComponentType()).isEqualTo(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's component type.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class).toComponentType().isEqualTo(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's component type.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class, "Message").toComponentType().isEqualTo(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's component type.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void toComponentTypeMatcherTest() {
        initialize(Raw.classAssertion(), Object[].class).toComponentType(Matchers.is(Matchers.equalTo(Object.class)));
        initialize(Raw.classAssertion(), Object[][].class).toComponentType(Matchers.is(Matchers.equalTo(Object[].class)));
        initialize(Raw.classAssertion(), String[].class).toComponentType(Matchers.is(Matchers.equalTo(String.class)));
        initialize(Raw.classAssertion(), String[][].class).toComponentType(Matchers.is(Matchers.equalTo(String[].class)));
        initialize(Raw.classAssertion(), int[].class).toComponentType(Matchers.is(Matchers.equalTo(int.class)));
        initialize(Raw.classAssertion(), int[][].class).toComponentType(Matchers.is(Matchers.equalTo(int[].class)));

        try {
            Raw.classAssertion().toComponentType(Matchers.is(Matchers.equalTo(Object.class)));
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).toComponentType(Matchers.is(Matchers.equalTo(Object.class)));
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").toComponentType(Matchers.is(Matchers.equalTo(Object.class)));
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null).toComponentType(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").toComponentType(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class).toComponentType(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class, "Message").toComponentType(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).toComponentType(Matchers.is(Matchers.equalTo(Object.class)));
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the array type.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").toComponentType(Matchers.is(Matchers.equalTo(Object.class)));
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the array type.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class).toComponentType(Matchers.is(Matchers.equalTo(String.class)));
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's component type.\nExpected: is <class java.lang.String>\n     but: was <class java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class, "Message").toComponentType(Matchers.is(Matchers.equalTo(String.class)));
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's component type.\nExpected: is <class java.lang.String>\n     but: was <class java.lang.Object>");
        }
    }

    /**
     * {@link ClassAssertion} class test.
     */
    @Test
    public void hasComponentTypeTest() {
        initialize(Raw.classAssertion(), Object[].class).hasComponentType(Object.class);
        initialize(Raw.classAssertion(), Object[][].class).hasComponentType(Object[].class);
        initialize(Raw.classAssertion(), String[].class).hasComponentType(String.class);
        initialize(Raw.classAssertion(), String[][].class).hasComponentType(String[].class);
        initialize(Raw.classAssertion(), int[].class).hasComponentType(int.class);
        initialize(Raw.classAssertion(), int[][].class).hasComponentType(int[].class);

        try {
            Raw.classAssertion().hasComponentType(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.classAssertion(), null).hasComponentType(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").hasComponentType(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null).hasComponentType(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), null, "Message").hasComponentType(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class).hasComponentType(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class, "Message").hasComponentType(null);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.classAssertion(), Object.class).hasComponentType(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the array type.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").hasComponentType(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the array type.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class).hasComponentType(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's component type.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object[].class, "Message").hasComponentType(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's component type.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
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
            initialize(Raw.classAssertion(), Object.class, "Message").hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value's constructor should not be acccessible.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), AbstractClass.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageContains("Actual value's constructor should be callable.\n\tActual:");
            Assertions.assertThat(ex).messageContains("$AbstractClass>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(InstantiationException.class);
        }
        try {
            initialize(Raw.classAssertion(), FailConstructorClass.class).hasOnePrivateConstructor();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageContains("Actual value's constructor should be callable.\n\tActual:");
            Assertions.assertThat(ex).messageContains("$FailConstructorClass>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(InvocationTargetException.class);
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
            initialize(Raw.classAssertion(), Object.class).asEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be the enum type.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").asEnum();
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be the enum type.\n\tActual:<java.lang.Object>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isSameAs(String.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<java.lang.String> but was:<java.lang.Object>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<java.lang.Object>");
        }
        try {
            initialize(Raw.classAssertion(), Object.class, "Message").isNotSameAs(Object.class);
            Assertions.fail("ClassAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<java.lang.Object>");
        }
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
