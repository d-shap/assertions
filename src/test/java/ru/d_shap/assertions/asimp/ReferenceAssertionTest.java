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
package ru.d_shap.assertions.asimp;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.BaseAssertion;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.data.ReflectionException;

/**
 * Tests for {@link ReferenceAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ReferenceAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ReferenceAssertionTest() {
        super();
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNullTest() {
        createReferenceAssertion(null).isNull();

        try {
            createReferenceAssertion().isNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion("reference").isNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<reference>");
        }
        try {
            createReferenceAssertion("reference", "Message").isNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNotNullTest() {
        createReferenceAssertion(new Object()).isNotNull();
        createReferenceAssertion("reference").isNotNull();

        try {
            createReferenceAssertion().isNotNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).isNotNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isNotNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Object object = new Object();
        createReferenceAssertion(object).isSameAs(object);

        try {
            createReferenceAssertion().isSameAs(new Object());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).isSameAs(new Object());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isSameAs(new Object());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).isSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).isSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").isSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).isSameAs(new StringBuilder("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<value> but was:<value>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").isSameAs(new StringBuilder("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<value> but was:<value>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        createReferenceAssertion(new Object()).isNotSameAs(new Object());
        createReferenceAssertion(new StringBuilder("value")).isNotSameAs(new StringBuilder("value"));

        try {
            createReferenceAssertion().isNotSameAs(new Object());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).isNotSameAs(new Object());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isNotSameAs(new Object());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).isNotSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isNotSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).isNotSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").isNotSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            StringBuilder value = new StringBuilder("value");
            createReferenceAssertion(value).isNotSameAs(value);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<value>");
        }
        try {
            StringBuilder value = new StringBuilder("value");
            createReferenceAssertion(value, "Message").isNotSameAs(value);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<value>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toClassTest() {
        createReferenceAssertion(new Object()).toClass().isSameAs(Object.class);
        createReferenceAssertion(new Object()).toClass().isSubtypeOf(Object.class);

        createReferenceAssertion(new StringBuilder("value")).toClass().isSameAs(StringBuilder.class);
        createReferenceAssertion(new StringBuilder("value")).toClass().isSubtypeOf(StringBuilder.class);
        createReferenceAssertion(new StringBuilder("value")).toClass().isSubtypeOf(CharSequence.class);
        createReferenceAssertion(new StringBuilder("value")).toClass().isSubtypeOf(Object.class);

        try {
            createReferenceAssertion().toClass();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toClass();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toClass();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new StringBuilder("value")).toClass()).isSameAs(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new StringBuilder("value"), "Message").toClass()).isSameAs(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).toClass().isSameAs(String.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual and expected values should point to the same object.\n\tExpected:<java.lang.String> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").toClass().isSameAs(String.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual and expected values should point to the same object.\n\tExpected:<java.lang.String> but was:<java.lang.StringBuilder>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toClassMatcherTest() {
        createReferenceAssertion(new Object()).toClass(Matchers.typeCompatibleWith(Object.class));

        createReferenceAssertion(new StringBuilder("value")).toClass(Matchers.typeCompatibleWith(StringBuilder.class));
        createReferenceAssertion(new StringBuilder("value")).toClass(Matchers.typeCompatibleWith(CharSequence.class));
        createReferenceAssertion(new StringBuilder("value")).toClass(Matchers.typeCompatibleWith(Object.class));

        try {
            createReferenceAssertion().toClass(Matchers.typeCompatibleWith(Object.class));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toClass(Matchers.typeCompatibleWith(Object.class));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toClass(Matchers.typeCompatibleWith(Object.class));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).toClass(Matchers.typeCompatibleWith(String.class));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\nExpected: type < java.lang.String\n     but: \"java.lang.StringBuilder\"");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").toClass(Matchers.typeCompatibleWith(String.class));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\nExpected: type < java.lang.String\n     but: \"java.lang.StringBuilder\"");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void hasClassTest() {
        createReferenceAssertion(new Object()).hasClass(Object.class);
        createReferenceAssertion(new StringBuilder("value")).hasClass(StringBuilder.class);

        try {
            createReferenceAssertion().hasClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).hasClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").hasClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).hasClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").hasClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).hasClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").hasClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object()).hasClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new Object(), "Message").hasClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).hasClass(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").hasClass(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).hasClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.Object> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").hasClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual and expected values should be the same.\n\tExpected:<java.lang.Object> but was:<java.lang.StringBuilder>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void hasNotClassTest() {
        createReferenceAssertion(new Object()).hasNotClass(StringBuilder.class);
        createReferenceAssertion(new StringBuilder("value")).hasNotClass(CharSequence.class);
        createReferenceAssertion(new StringBuilder("value")).hasNotClass(Object.class);

        try {
            createReferenceAssertion().hasNotClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).hasNotClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").hasNotClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).hasNotClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").hasNotClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).hasNotClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").hasNotClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object()).hasNotClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual and expected values should be different.\n\tActual:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new Object(), "Message").hasNotClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual and expected values should be different.\n\tActual:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).hasNotClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual and expected values should be different.\n\tActual:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").hasNotClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual and expected values should be different.\n\tActual:<java.lang.StringBuilder>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isInstanceOfTest() {
        createReferenceAssertion(new Object()).isInstanceOf(Object.class);

        createReferenceAssertion(new StringBuilder("value")).isInstanceOf(StringBuilder.class);
        createReferenceAssertion(new StringBuilder("value")).isInstanceOf(CharSequence.class);
        createReferenceAssertion(new StringBuilder("value")).isInstanceOf(Object.class);

        try {
            createReferenceAssertion().isInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).isInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).isInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).isInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").isInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object()).isInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new Object(), "Message").isInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNotInstanceOfTest() {
        createReferenceAssertion(new Object()).isNotInstanceOf(StringBuilder.class);

        try {
            createReferenceAssertion().isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).isNotInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isNotInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).isNotInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").isNotInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object()).isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.lang.Object> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new Object(), "Message").isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.lang.Object> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).isNotInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").isNotInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.lang.StringBuilder> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).isNotInstanceOf(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").isNotInstanceOf(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.lang.Object> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's class.\n\tActual value should not be the subtype of the expected value.\n\tExpected:<java.lang.Object> but was:<java.lang.StringBuilder>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toToStringTest() {
        createReferenceAssertion("reference").toToString().isEqualTo("reference");
        createReferenceAssertion("reference").toToString().startsWith("ref");
        createReferenceAssertion("reference").toToString().endsWith("ce");

        try {
            createReferenceAssertion().toToString();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toToString();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toToString();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion("reference").toToString()).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion("reference", "Message").toToString()).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's string representation.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion("reference").toToString().isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation.\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<reference>");
        }
        try {
            createReferenceAssertion("reference", "Message").toToString().isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's string representation.\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toToStringMatcherTest() {
        createReferenceAssertion("reference").toToString(Matchers.equalTo("reference"));
        createReferenceAssertion("reference").toToString(Matchers.startsWith("ref"));
        createReferenceAssertion("reference").toToString(Matchers.endsWith("ce"));

        try {
            createReferenceAssertion().toToString(Matchers.equalTo(""));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toToString(Matchers.equalTo(""));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toToString(Matchers.equalTo(""));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toToString(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toToString(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toToString(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toToString(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion("reference").toToString(Matchers.equalTo("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation.\nExpected: \"value\"\n     but: was \"reference\"");
        }
        try {
            createReferenceAssertion("reference", "Message").toToString(Matchers.equalTo("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's string representation.\nExpected: \"value\"\n     but: was \"reference\"");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void hasToStringTest() {
        createReferenceAssertion("reference").hasToString("reference");

        try {
            createReferenceAssertion().hasToString("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).hasToString("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").hasToString("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).hasToString(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").hasToString(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).hasToString(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").hasToString(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            createReferenceAssertion("reference").hasToString("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation.\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<reference>");
        }
        try {
            createReferenceAssertion("reference", "Message").hasToString("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's string representation.\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toStringContainsTest() {
        createReferenceAssertion("reference").toStringContains("feren");

        try {
            createReferenceAssertion().toStringContains("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toStringContains("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toStringContains("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toStringContains(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toStringContains(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toStringContains(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toStringContains(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            createReferenceAssertion("reference").toStringContains("FEREN");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation.\n\tActual value should contain the expected value.\n\tExpected:<FEREN> but was:<reference>");
        }
        try {
            createReferenceAssertion("reference", "Message").toStringContains("FEREN");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's string representation.\n\tActual value should contain the expected value.\n\tExpected:<FEREN> but was:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toStringMatchesTest() {
        createReferenceAssertion("reference").toStringMatches("re.*ce");

        try {
            createReferenceAssertion().toStringMatches("v.*e");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toStringMatches("v.*e");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toStringMatches("v.*e");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toStringMatches(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toStringMatches(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toStringMatches(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toStringMatches(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            createReferenceAssertion("reference").toStringMatches("rE.*cE");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation.\n\tActual value should match the expected value.\n\tExpected:<rE.*cE> but was:<reference>");
        }
        try {
            createReferenceAssertion("reference", "Message").toStringMatches("rE.*cE");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's string representation.\n\tActual value should match the expected value.\n\tExpected:<rE.*cE> but was:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toHashCodeTest() {
        createReferenceAssertion("reference").toHashCode().isEqualTo(-925155509);
        createReferenceAssertion("reference").toHashCode().isLessThan(0);
        createReferenceAssertion("reference").toHashCode().isNotInRange(1, 10);

        try {
            createReferenceAssertion().toHashCode();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toHashCode();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toHashCode();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion("reference").toHashCode()).isEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hash code.\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion("reference", "Message").toHashCode()).isEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hash code.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion("reference").toHashCode().isEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hash code.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<-925155509>");
        }
        try {
            createReferenceAssertion("reference", "Message").toHashCode().isEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hash code.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<-925155509>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toHashCodeMatcherTest() {
        createReferenceAssertion("reference").toHashCode(Matchers.equalTo(-925155509));
        createReferenceAssertion("reference").toHashCode(Matchers.lessThan(0));
        createReferenceAssertion("reference").toHashCode(Matchers.not(Matchers.allOf(Matchers.greaterThan(1), Matchers.lessThan(10))));

        try {
            createReferenceAssertion().toHashCode(Matchers.equalTo(0));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toHashCode(Matchers.equalTo(0));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toHashCode(Matchers.equalTo(0));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toHashCode(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toHashCode(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toHashCode(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toHashCode(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion("reference").toHashCode(Matchers.equalTo(1));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hash code.\nExpected: <1>\n     but: was <-925155509>");
        }
        try {
            createReferenceAssertion("reference", "Message").toHashCode(Matchers.equalTo(1));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hash code.\nExpected: <1>\n     but: was <-925155509>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void hasHashCodeTest() {
        createReferenceAssertion("reference").hasHashCode(-925155509);

        try {
            createReferenceAssertion().hasHashCode(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).hasHashCode(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").hasHashCode(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion("reference").hasHashCode(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hash code.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<-925155509>");
        }
        try {
            createReferenceAssertion("reference", "Message").hasHashCode(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hash code.\n\tActual and expected values should be the same.\n\tExpected:<1> but was:<-925155509>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toFieldTest() {
        createReferenceAssertion(new ParentClass()).toField("_nullField").isNull();
        createReferenceAssertion(new ParentClass()).toField("_parentField").isNotNull();
        createReferenceAssertion(new ParentClass()).toField("_parentField").isEqualTo("parentField");

        createReferenceAssertion(new ChildClass()).toField("_nullField").isNull();
        createReferenceAssertion(new ChildClass()).toField("_parentField").isNotNull();
        createReferenceAssertion(new ChildClass()).toField("_parentField").isEqualTo("parentField");
        createReferenceAssertion(new ChildClass()).toField("_childField").isNotNull();
        createReferenceAssertion(new ChildClass()).toField("_childField").isEqualTo("childField");

        try {
            createReferenceAssertion().toField("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toField("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toField("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toField(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toField(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toField(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toField(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected field.\n\tExpected:<wrongFieldName>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(NoSuchFieldException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected field.\n\tExpected:<wrongFieldName>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(NoSuchFieldException.class);
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass()).toField("_parentField")).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _parentField.\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass(), "Message").toField("_parentField")).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's field: _parentField.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toField("_parentField").isEqualTo("wrongFieldValue");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _parentField.\n\tActual and expected values should be the same.\n\tExpected:<wrongFieldValue> but was:<parentField>");
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toField("_parentField").isEqualTo("wrongFieldValue");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's field: _parentField.\n\tActual and expected values should be the same.\n\tExpected:<wrongFieldValue> but was:<parentField>");
        }
        try {
            createReferenceAssertion(new ChildClass()).toField("_childField").isEqualTo("wrongFieldValue");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _childField.\n\tActual and expected values should be the same.\n\tExpected:<wrongFieldValue> but was:<childField>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toField("_childField").isEqualTo("wrongFieldValue");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's field: _childField.\n\tActual and expected values should be the same.\n\tExpected:<wrongFieldValue> but was:<childField>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toFieldAssertionTest() {
        createReferenceAssertion(new ParentClass()).toField("_nullField", Raw.charSequenceAssertion()).isNull();
        createReferenceAssertion(new ParentClass()).toField("_nullField", Raw.classAssertion()).isNull();
        createReferenceAssertion(new ParentClass()).toField("_parentField", Raw.charSequenceAssertion()).isEqualTo("parentField");

        createReferenceAssertion(new ChildClass()).toField("_nullField", Raw.charSequenceAssertion()).isNull();
        createReferenceAssertion(new ChildClass()).toField("_nullField", Raw.classAssertion()).isNull();
        createReferenceAssertion(new ChildClass()).toField("_parentField", Raw.charSequenceAssertion()).isEqualTo("parentField");
        createReferenceAssertion(new ChildClass()).toField("_childField", Raw.charSequenceAssertion()).isEqualTo("childField");

        try {
            createReferenceAssertion().toField("value", Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toField("value", Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toField("value", Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toField(null, Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toField(null, Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toField(null, Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toField(null, Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new Object()).toField(null, (BaseAssertion<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toField(null, (BaseAssertion<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new Object()).toField("value", (BaseAssertion<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: assertion.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toField("value", (BaseAssertion<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: assertion.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass()).toField("_parentField", Raw.charSequenceAssertion())).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _parentField.\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass(), "Message").toField("_parentField", Raw.charSequenceAssertion())).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's field: _parentField.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toField("_nullField", Raw.charSequenceAssertion()).isNotNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _nullField.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toField("_nullField", Raw.charSequenceAssertion()).isNotNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's field: _nullField.\n\tActual value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toFieldMatcherTest() {
        createReferenceAssertion(new ParentClass()).toField("_nullField", Matchers.nullValue());
        createReferenceAssertion(new ParentClass()).toField("_parentField", Matchers.equalTo("parentField"));

        createReferenceAssertion(new ChildClass()).toField("_nullField", Matchers.nullValue());
        createReferenceAssertion(new ChildClass()).toField("_parentField", Matchers.equalTo("parentField"));
        createReferenceAssertion(new ChildClass()).toField("_childField", Matchers.equalTo("childField"));

        try {
            createReferenceAssertion().toField("value", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toField("value", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toField("value", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toField(null, Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toField(null, Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toField(null, Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toField(null, Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new Object()).toField(null, (Matcher<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toField(null, (Matcher<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: fieldName.");
        }
        try {
            createReferenceAssertion(new Object()).toField("value", (Matcher<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toField("value", (Matcher<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toField("wrongFieldName", Matchers.not(Matchers.nullValue()));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected field.\n\tExpected:<wrongFieldName>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(NoSuchFieldException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toField("wrongFieldName", Matchers.not(Matchers.nullValue()));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected field.\n\tExpected:<wrongFieldName>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(NoSuchFieldException.class);
        }
        try {
            createReferenceAssertion(new ParentClass()).toField("_nullField", Matchers.not(Matchers.nullValue()));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _nullField.\nExpected: not null\n     but: was null");
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toField("_nullField", Matchers.not(Matchers.nullValue()));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's field: _nullField.\nExpected: not null\n     but: was null");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultWithParameterTypesTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", new Class<?>[]{}, new Object[]{}).isEqualTo("parentMethod");

        createReferenceAssertion(new ChildClass()).toMethodCallResult("parentMethod", new Class<?>[]{}, new Object[]{}).isEqualTo("parentMethod");
        createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", new Class<?>[]{String.class}, new Object[]{"param"}).isEqualTo("childMethod:param");
        createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", new Class<?>[]{String.class, int.class}, new Object[]{"param", 5}).isEqualTo("childMethod:param,5");

        try {
            createReferenceAssertion().toMethodCallResult("method", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult("method", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult("method", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult(null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult(null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, (Class<?>[]) null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, (Class<?>[]) null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (Class<?>[]) null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (Class<?>[]) null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (Class<?>[]) null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (Class<?>[]) null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallResult("wrongMethodName", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("wrongMethodName", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childFailMethod", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should call the expected method.\n\tExpected:<childFailMethod>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childFailMethod", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should call the expected method.\n\tExpected:<childFailMethod>");
            Assertions.assertThat(ex).hasCause(ReflectionException.class);
            Assertions.assertThat(ex).toCause().hasCause(InvocationTargetException.class);
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", new Class<?>[]{}, new Object[]{})).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: parentMethod<EMPTY>.\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("parentMethod", new Class<?>[]{}, new Object[]{})).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: parentMethod<EMPTY>.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", new Class<?>[]{String.class}, new Object[]{"param"}).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: childMethod[param].\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<childMethod:param>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", new Class<?>[]{String.class}, new Object[]{"param"}).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: childMethod[param].\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<childMethod:param>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultTest() {
        // TODO
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultAssertionWithParameterTypesTest() {
        // TODO
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultAssertionTest() {
        // TODO
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultMatcherWithParameterTypesTest() {
        // TODO
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultMatcherTest() {
        // TODO
    }

    /**
     * {@link ReferenceAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void setAccessibleTest() throws Exception {
        ChildClass privateField = new ChildClass();
        Field field = privateField.getClass().getDeclaredField("_childField");
        try {
            field.get(privateField);
            Assertions.fail("PrivateAccessor test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).toMessage().contains("with modifiers \"private final\"");
        }
        createReferenceAssertion(new Object()).setAccessible(field);
        Object value = field.get(privateField);
        Assertions.assertThat(value).isEqualTo("childField");
    }

    private ReferenceAssertion<Object> createReferenceAssertion() {
        return new ReferenceAssertionImpl();
    }

    private ReferenceAssertion<Object> createReferenceAssertion(final Object actual) {
        return initialize(createReferenceAssertion(), actual);
    }

    private ReferenceAssertion<Object> createReferenceAssertion(final Object actual, final String message) {
        return initialize(createReferenceAssertion(), actual, message);
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ReferenceAssertionImpl extends ReferenceAssertion<Object> {

        ReferenceAssertionImpl() {
            super();
        }

        @Override
        protected Class<Object> getActualValueClass() {
            return Object.class;
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ParentClass {

        private final String _nullField;

        private final String _parentField;

        ParentClass() {
            super();
            _nullField = null;
            _parentField = "parentField";
        }

        private String getNullField() {
            return _nullField;
        }

        private String getParentField() {
            return _parentField;
        }

        private String parentMethod() {
            return "parentMethod";
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ChildClass extends ParentClass {

        private final String _childField;

        ChildClass() {
            super();
            _childField = "childField";
        }

        private String getChildField() {
            return _childField;
        }

        private String childMethod(final String param) {
            return "childMethod:" + param;
        }

        private String childMethod(final String param1, final int param2) {
            return "childMethod:" + param1 + "," + param2;
        }

        private void childFailMethod() {
            throw new RuntimeException("test exception");
        }

    }

}
