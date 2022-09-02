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

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.BaseAssertion;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;
import ru.d_shap.assertions.util.ReflectionException;

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
        createReferenceAssertion(null).isNull().isNull();

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
        createReferenceAssertion("reference").isNotNull().isInstanceOf(Object.class);

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
        createReferenceAssertion(object).isSameAs(object).isInstanceOf(Object.class);

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
        createReferenceAssertion(new Object()).isNotSameAs(new Object()).isInstanceOf(Object.class);

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

        createReferenceAssertion(new Object()).toClass(Matchers.typeCompatibleWith(Object.class)).isInstanceOf(Object.class);

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
        createReferenceAssertion(new Object()).hasClass(Object.class).isInstanceOf(Object.class);

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
        createReferenceAssertion(new Object()).hasNotClass(StringBuilder.class).isInstanceOf(Object.class);

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

        createReferenceAssertion(new Object()).isInstanceOf(Object.class).isInstanceOf(Object.class);

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
        createReferenceAssertion(new Object()).isNotInstanceOf(StringBuilder.class).isInstanceOf(Object.class);

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
        createReferenceAssertion("reference").toToString(Matchers.equalTo("reference")).isInstanceOf(Object.class);

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
        createReferenceAssertion("reference").hasToString("reference").isInstanceOf(Object.class);

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
        createReferenceAssertion("reference").toStringContains("feren").isInstanceOf(Object.class);

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
        createReferenceAssertion("reference").toStringMatches("re.*ce").isInstanceOf(Object.class);

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
        createReferenceAssertion("reference").toHashCode(Matchers.equalTo(-925155509)).isInstanceOf(Object.class);

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
        createReferenceAssertion("reference").hasHashCode(-925155509).isInstanceOf(Object.class);

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
            createReferenceAssertion(new ParentClass()).toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected field.\n\tExpected:<wrongFieldName>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchFieldException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected field.\n\tExpected:<wrongFieldName>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchFieldException.class);
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

        createReferenceAssertion(new ParentClass()).toField("_parentField", Matchers.equalTo("parentField")).isInstanceOf(Object.class);

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
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchFieldException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toField("wrongFieldName", Matchers.not(Matchers.nullValue()));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected field.\n\tExpected:<wrongFieldName>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchFieldException.class);
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
            clearActual(createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", new Class<?>[]{}, new Object[]{})).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: parentMethod().\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("parentMethod", new Class<?>[]{}, new Object[]{})).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: parentMethod().\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallResult("wrongMethodName", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("wrongMethodName", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childFailMethod", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childFailMethod", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", new Class<?>[]{String.class}, new Object[]{"param"}).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: childMethod(java.lang.String).\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<childMethod:param>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", new Class<?>[]{String.class}, new Object[]{"param"}).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: childMethod(java.lang.String).\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<childMethod:param>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultWithParametersTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod").isEqualTo("parentMethod");

        createReferenceAssertion(new ChildClass()).toMethodCallResult("parentMethod").isEqualTo("parentMethod");
        createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", "param").isEqualTo("childMethod:param");

        try {
            createReferenceAssertion().toMethodCallResult("method");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult("method");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult("method");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod")).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: parentMethod().\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("parentMethod")).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: parentMethod().\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallResult("wrongMethodName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("wrongMethodName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childFailMethod");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childFailMethod");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", "param").isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: childMethod(java.lang.String).\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<childMethod:param>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", "param").isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: childMethod(java.lang.String).\n\tActual and expected values should be the same.\n\tExpected:<value> but was:<childMethod:param>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultAssertionWithParameterTypesTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", Raw.charSequenceAssertion(), new Class<?>[]{}, new Object[]{}).isEqualToIgnoreCase("ParentMethod");

        createReferenceAssertion(new ChildClass()).toMethodCallResult("parentMethod", Raw.charSequenceAssertion(), new Class<?>[]{}, new Object[]{}).isEqualToIgnoreCase("ParentMethod");
        createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Raw.charSequenceAssertion(), new Class<?>[]{String.class}, new Object[]{"param"}).isEqualToIgnoreCase("ChildMethod:Param");
        createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Raw.charSequenceAssertion(), new Class<?>[]{String.class, int.class}, new Object[]{"param", 5}).isEqualToIgnoreCase("ChildMethod:Param,5");

        try {
            createReferenceAssertion().toMethodCallResult("method", Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult("method", Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult("method", Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult(null, Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult(null, Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, Raw.objectAssertion(), null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, Raw.objectAssertion(), null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", Raw.objectAssertion(), null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", Raw.objectAssertion(), null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", Raw.objectAssertion(), null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", Raw.objectAssertion(), null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", Raw.objectAssertion(), new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", Raw.objectAssertion(), new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (BaseAssertion<?>) null, new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (BaseAssertion<?>) null, new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (BaseAssertion<?>) null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: assertion.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (BaseAssertion<?>) null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: assertion.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", Raw.objectAssertion(), new Class<?>[]{}, new Object[]{})).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: parentMethod().\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("parentMethod", Raw.objectAssertion(), new Class<?>[]{}, new Object[]{})).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: parentMethod().\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallResult("wrongMethodName", Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("wrongMethodName", Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Raw.objectAssertion(), new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Raw.objectAssertion(), new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childFailMethod", Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childFailMethod", Raw.objectAssertion(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Raw.charSequenceAssertion(), new Class<?>[]{String.class}, new Object[]{"param"}).isEqualToIgnoreCase("vaLUe");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: childMethod(java.lang.String).\n\tActual and expected values should be the same ignoring case.\n\tExpected:<vaLUe> but was:<childMethod:param>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Raw.charSequenceAssertion(), new Class<?>[]{String.class}, new Object[]{"param"}).isEqualToIgnoreCase("vaLUe");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: childMethod(java.lang.String).\n\tActual and expected values should be the same ignoring case.\n\tExpected:<vaLUe> but was:<childMethod:param>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultAssertionWithParametersTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", Raw.charSequenceAssertion()).isEqualToIgnoreCase("ParentMethod");

        createReferenceAssertion(new ChildClass()).toMethodCallResult("parentMethod", Raw.charSequenceAssertion()).isEqualToIgnoreCase("ParentMethod");
        createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Raw.charSequenceAssertion(), "param").isEqualToIgnoreCase("ChildMethod:Param");

        try {
            createReferenceAssertion().toMethodCallResult("method", Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult("method", Raw.objectAssertion(), "arg");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult("method", Raw.objectAssertion(), "arg");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult(null, Raw.objectAssertion(), "arg");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult(null, Raw.objectAssertion(), "arg");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, Raw.objectAssertion(), "arg");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, Raw.objectAssertion(), "arg");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, Raw.objectAssertion(), (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, Raw.objectAssertion(), (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", Raw.objectAssertion(), (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", Raw.objectAssertion(), (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (BaseAssertion<?>) null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (BaseAssertion<?>) null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (BaseAssertion<?>) null, "arg");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: assertion.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (BaseAssertion<?>) null, "arg");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: assertion.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", Raw.objectAssertion())).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: parentMethod().\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("parentMethod", Raw.objectAssertion())).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: parentMethod().\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallResult("wrongMethodName", Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("wrongMethodName", Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Raw.objectAssertion(), 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Raw.objectAssertion(), 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Raw.objectAssertion(), "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Raw.objectAssertion(), "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childFailMethod", Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childFailMethod", Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Raw.charSequenceAssertion(), "param").isEqualToIgnoreCase("vaLUe");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: childMethod(java.lang.String).\n\tActual and expected values should be the same ignoring case.\n\tExpected:<vaLUe> but was:<childMethod:param>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Raw.charSequenceAssertion(), "param").isEqualToIgnoreCase("vaLUe");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: childMethod(java.lang.String).\n\tActual and expected values should be the same ignoring case.\n\tExpected:<vaLUe> but was:<childMethod:param>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultMatcherWithParameterTypesTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", Matchers.equalTo("parentMethod"), new Class<?>[]{}, new Object[]{});

        createReferenceAssertion(new ChildClass()).toMethodCallResult("parentMethod", Matchers.equalTo("parentMethod"), new Class<?>[]{}, new Object[]{});
        createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Matchers.equalTo("childMethod:param"), new Class<?>[]{String.class}, new Object[]{"param"});
        createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Matchers.equalTo("childMethod:param,5"), new Class<?>[]{String.class, int.class}, new Object[]{"param", 5});

        createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", Matchers.equalTo("parentMethod"), new Class<?>[]{}, new Object[]{}).isInstanceOf(Object.class);

        try {
            createReferenceAssertion().toMethodCallResult("method", Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult("method", Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult("method", Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult(null, Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult(null, Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, (Matcher<?>) null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, (Matcher<?>) null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (Matcher<?>) null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (Matcher<?>) null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (Matcher<?>) null, null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (Matcher<?>) null, null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", Matchers.nullValue(), null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", Matchers.nullValue(), null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", Matchers.nullValue(), null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", Matchers.nullValue(), null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", Matchers.nullValue(), new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", Matchers.nullValue(), new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallResult("wrongMethodName", Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("wrongMethodName", Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Matchers.nullValue(), new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Matchers.nullValue(), new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childFailMethod", Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childFailMethod", Matchers.nullValue(), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Matchers.equalTo("value"), new Class<?>[]{String.class}, new Object[]{"param"});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: childMethod(java.lang.String).\nExpected: \"value\"\n     but: was \"childMethod:param\"");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Matchers.equalTo("value"), new Class<?>[]{String.class}, new Object[]{"param"});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: childMethod(java.lang.String).\nExpected: \"value\"\n     but: was \"childMethod:param\"");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallResultMatcherWithParametersTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", Matchers.equalTo("parentMethod"));

        createReferenceAssertion(new ChildClass()).toMethodCallResult("parentMethod", Matchers.equalTo("parentMethod"));
        createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Matchers.equalTo("childMethod:param"), "param");

        createReferenceAssertion(new ParentClass()).toMethodCallResult("parentMethod", Matchers.equalTo("parentMethod")).isInstanceOf(Object.class);

        try {
            createReferenceAssertion().toMethodCallResult("method", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult("method", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult("method", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallResult(null, Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallResult(null, Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult(null, (Matcher<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult(null, (Matcher<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (Matcher<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (Matcher<?>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", (Matcher<?>) null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", (Matcher<?>) null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallResult("method", Matchers.nullValue(), (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallResult("method", Matchers.nullValue(), (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallResult("wrongMethodName", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallResult("wrongMethodName", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Matchers.nullValue(), 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Matchers.nullValue(), 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Matchers.nullValue(), "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Matchers.nullValue(), "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childFailMethod", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childFailMethod", Matchers.nullValue());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should call the expected method.\n\tExpected:<childFailMethod()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, InvocationTargetException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallResult("childMethod", Matchers.equalTo("value"), "param");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: childMethod(java.lang.String).\nExpected: \"value\"\n     but: was \"childMethod:param\"");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallResult("childMethod", Matchers.equalTo("value"), "param");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: childMethod(java.lang.String).\nExpected: \"value\"\n     but: was \"childMethod:param\"");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallExceptionWithParameterTypesTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallException("parentFailMethod", new Class<?>[]{}, new Object[]{}).hasMessage("test io exception");

        createReferenceAssertion(new ChildClass()).toMethodCallException("parentFailMethod", new Class<?>[]{}, new Object[]{}).hasMessage("test io exception");
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", new Class<?>[]{}, new Object[]{}).hasMessage("test rt exception");
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", new Class<?>[]{String.class}, new Object[]{"param"}).hasMessage("test rt exception: param");
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", new Class<?>[]{String.class, int.class}, new Object[]{"param", 5}).hasMessage("test rt exception: param,5");

        try {
            createReferenceAssertion().toMethodCallException("method", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallException("method", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallException("method", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallException(null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallException(null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException(null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException(null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException(null, (Class<?>[]) null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException(null, (Class<?>[]) null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", (Class<?>[]) null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", (Class<?>[]) null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", (Class<?>[]) null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", (Class<?>[]) null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass()).toMethodCallException("parentFailMethod", new Class<?>[]{}, new Object[]{})).hasMessage("test io exception");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call exception: parentFailMethod().\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass(), "Message").toMethodCallException("parentFailMethod", new Class<?>[]{}, new Object[]{})).hasMessage("test io exception");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call exception: parentFailMethod().\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallException("wrongMethodName", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallException("wrongMethodName", new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childFailMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childFailMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childMethod", new Class<?>[]{String.class}, new Object[]{"param"});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should fail to call the expected method.\n\tExpected:<childMethod(java.lang.String)>");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childMethod", new Class<?>[]{String.class}, new Object[]{"param"});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should fail to call the expected method.\n\tExpected:<childMethod(java.lang.String)>");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", new Class<?>[]{String.class}, new Object[]{"param"}).hasMessage("test exception");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call exception: childFailMethod(java.lang.String).\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test exception> but was:<test rt exception: param>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", new Class<?>[]{String.class}, new Object[]{"param"}).hasMessage("test exception");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call exception: childFailMethod(java.lang.String).\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test exception> but was:<test rt exception: param>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallExceptionWithParametersTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallException("parentFailMethod").hasMessage("test io exception");

        createReferenceAssertion(new ChildClass()).toMethodCallException("parentFailMethod").hasMessage("test io exception");
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod").hasMessage("test rt exception");
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", "param").hasMessage("test rt exception: param");

        try {
            createReferenceAssertion().toMethodCallException("method");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallException("method");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallException("method");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallException(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallException(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException(null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException(null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass()).toMethodCallException("parentFailMethod")).hasMessage("test io exception");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call exception: parentFailMethod().\n\tActual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ParentClass(), "Message").toMethodCallException("parentFailMethod")).hasMessage("test io exception");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call exception: parentFailMethod().\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallException("wrongMethodName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallException("wrongMethodName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childFailMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childFailMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childFailMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childFailMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childMethod", "param");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should fail to call the expected method.\n\tExpected:<childMethod(java.lang.String)>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childMethod", "param");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should fail to call the expected method.\n\tExpected:<childMethod(java.lang.String)>");
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", "param").hasMessage("test exception");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call exception: childFailMethod(java.lang.String).\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test exception> but was:<test rt exception: param>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", "param").hasMessage("test exception");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call exception: childFailMethod(java.lang.String).\n\tCheck actual value's message.\n\tActual and expected values should be the same.\n\tExpected:<test exception> but was:<test rt exception: param>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallExceptionMatcherWithParameterTypesTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallException("parentFailMethod", exceptionMessage("test io exception"), new Class<?>[]{}, new Object[]{});

        createReferenceAssertion(new ChildClass()).toMethodCallException("parentFailMethod", exceptionMessage("test io exception"), new Class<?>[]{}, new Object[]{});
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage("test rt exception"), new Class<?>[]{}, new Object[]{});
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage("test rt exception: param"), new Class<?>[]{String.class}, new Object[]{"param"});
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage("test rt exception: param,5"), new Class<?>[]{String.class, int.class}, new Object[]{"param", 5});

        createReferenceAssertion(new ParentClass()).toMethodCallException("parentFailMethod", exceptionMessage("test io exception"), new Class<?>[]{}, new Object[]{}).isInstanceOf(Object.class);

        try {
            createReferenceAssertion().toMethodCallException("method", exceptionMessage(null), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallException("method", exceptionMessage(null), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallException("method", exceptionMessage(null), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallException(null, exceptionMessage(null), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallException(null, exceptionMessage(null), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException(null, exceptionMessage(null), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException(null, exceptionMessage(null), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException(null, null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException(null, null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", null, new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", null, null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", null, null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", exceptionMessage(null), null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", exceptionMessage(null), null, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", exceptionMessage(null), null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", exceptionMessage(null), null, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: parameterTypes.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", exceptionMessage(null), new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", exceptionMessage(null), new Class<?>[]{}, null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallException("wrongMethodName", exceptionMessage(null), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallException("wrongMethodName", exceptionMessage(null), new Class<?>[]{}, new Object[]{});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage(null), new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childFailMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", exceptionMessage(null), new Class<?>[]{int.class}, new Object[]{5});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childFailMethod(int)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childMethod", exceptionMessage(null), new Class<?>[]{String.class}, new Object[]{"param"});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should fail to call the expected method.\n\tExpected:<childMethod(java.lang.String)>");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childMethod", exceptionMessage(null), new Class<?>[]{String.class}, new Object[]{"param"});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should fail to call the expected method.\n\tExpected:<childMethod(java.lang.String)>");
            Assertions.assertThat(ex).causeIsNull();
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage("test exception"), new Class<?>[]{String.class}, new Object[]{"param"});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: childFailMethod(java.lang.String).\nExpected: is \"test exception\"\n     but: was <java.lang.RuntimeException: test rt exception: param>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", exceptionMessage("test exception"), new Class<?>[]{String.class}, new Object[]{"param"});
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: childFailMethod(java.lang.String).\nExpected: is \"test exception\"\n     but: was <java.lang.RuntimeException: test rt exception: param>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toMethodCallExceptionMatcherWithParametersTest() {
        createReferenceAssertion(new ParentClass()).toMethodCallException("parentFailMethod", exceptionMessage("test io exception"));

        createReferenceAssertion(new ChildClass()).toMethodCallException("parentFailMethod", exceptionMessage("test io exception"));
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage("test rt exception"));
        createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage("test rt exception: param"), "param");

        createReferenceAssertion(new ParentClass()).toMethodCallException("parentFailMethod", exceptionMessage("test io exception")).isInstanceOf(Object.class);

        try {
            createReferenceAssertion().toMethodCallException("method", exceptionMessage(null));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).toMethodCallException("method", exceptionMessage(null));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallException("method", exceptionMessage(null));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toMethodCallException(null, exceptionMessage(null));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toMethodCallException(null, exceptionMessage(null));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException(null, exceptionMessage(null));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException(null, exceptionMessage(null));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException(null, (Matcher<Throwable>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException(null, (Matcher<Throwable>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: methodName.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", (Matcher<Throwable>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", (Matcher<Throwable>) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", (Matcher<Throwable>) null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", (Matcher<Throwable>) null, (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            createReferenceAssertion(new Object()).toMethodCallException("method", exceptionMessage(null), (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toMethodCallException("method", exceptionMessage(null), (Object[]) null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: arguments.");
        }
        try {
            createReferenceAssertion(new ParentClass()).toMethodCallException("wrongMethodName", exceptionMessage(null));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ParentClass(), "Message").toMethodCallException("wrongMethodName", exceptionMessage(null));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<wrongMethodName()>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage(null), 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childFailMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", exceptionMessage(null), 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childFailMethod(java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage(null), "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected method.\n\tExpected:<childFailMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", exceptionMessage(null), "param", 5);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected method.\n\tExpected:<childFailMethod(java.lang.String, java.lang.Integer)>");
            Assertions.assertThat(ex).hasCauses(ReflectionException.class, NoSuchMethodException.class);
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childMethod", exceptionMessage(null), "param");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should fail to call the expected method.\n\tExpected:<childMethod(java.lang.String)>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childMethod", exceptionMessage(null), "param");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should fail to call the expected method.\n\tExpected:<childMethod(java.lang.String)>");
        }
        try {
            createReferenceAssertion(new ChildClass()).toMethodCallException("childFailMethod", exceptionMessage("test exception"), "param");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's method call result: childFailMethod(java.lang.String).\nExpected: is \"test exception\"\n     but: was <java.lang.RuntimeException: test rt exception: param>");
        }
        try {
            createReferenceAssertion(new ChildClass(), "Message").toMethodCallException("childFailMethod", exceptionMessage("test exception"), "param");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's method call result: childFailMethod(java.lang.String).\nExpected: is \"test exception\"\n     but: was <java.lang.RuntimeException: test rt exception: param>");
        }
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
            Assertions.fail("ReferenceAssertion test fail");
        } catch (IllegalAccessException ex) {
            Assertions.assertThat(ex).messageContains("with modifiers \"private final\"");
        }
        createReferenceAssertion(new Object()).setAccessible(field);
        Object value = field.get(privateField);
        Assertions.assertThat(value).isEqualTo("childField");
    }

    /**
     * {@link BaseAssertion} class test.
     */
    @Test
    public void chainMessageTest() {
        createReferenceAssertion(DataHelper.createArrayList()).isNotNull().isInstanceOf(Object.class).hasToString("[]");
        try {
            createReferenceAssertion(null).isNotNull().isInstanceOf(Object.class).hasToString("[]");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(DataHelper.createArrayList()).isNotNull().isInstanceOf(Set.class).hasToString("[]");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.util.Set> but was:<java.util.ArrayList>");
        }
        try {
            createReferenceAssertion(DataHelper.createArrayList()).isNotNull().isInstanceOf(Object.class).hasToString("{}");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation.\n\tActual and expected values should be the same.\n\tExpected:<{}> but was:<[]>");
        }
    }

    private ReferenceAssertionImpl createReferenceAssertion() {
        return new ReferenceAssertionImpl();
    }

    private ReferenceAssertionImpl createReferenceAssertion(final Object actual) {
        return initialize(createReferenceAssertion(), actual);
    }

    private ReferenceAssertionImpl createReferenceAssertion(final Object actual, final String message) {
        return initialize(createReferenceAssertion(), actual, message);
    }

    private <E extends Throwable> Matcher<E> exceptionMessage(final String message) {
        return new ExceptionMessageMatcher<>(Matchers.is(message));
    }

    private static final class ReferenceAssertionImpl extends ReferenceAssertion<ReferenceAssertionImpl, Object> {

        ReferenceAssertionImpl() {
            super();
        }

        @Override
        protected Class<Object> getActualValueClass() {
            return Object.class;
        }

    }

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

        private void parentFailMethod() throws IOException {
            throw new IOException("test io exception");
        }

    }

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
            throw new RuntimeException("test rt exception");
        }

        private void childFailMethod(final String param) {
            throw new RuntimeException("test rt exception: " + param);
        }

        private void childFailMethod(final String param1, final int param2) {
            throw new RuntimeException("test rt exception: " + param1 + "," + param2);
        }

    }

    private static final class ExceptionMessageMatcher<E extends Throwable> extends TypeSafeMatcher<E> {

        private final Matcher<? super String> _matcher;

        ExceptionMessageMatcher(final Matcher<? super String> matcher) {
            super();
            _matcher = matcher;
        }

        @Override
        protected boolean matchesSafely(final E throwable) {
            return _matcher.matches(throwable.getMessage());
        }

        @Override
        public void describeTo(final Description description) {
            description.appendDescriptionOf(_matcher);
        }

    }

}
