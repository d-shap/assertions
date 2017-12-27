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

import org.junit.Test;

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
            Assertions.assertThat(ex).hasMessage("Actual value should be null. Actual:<reference>");
        }
        try {
            createReferenceAssertion("reference", "Message").isNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should be null. Actual:<reference>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).isSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").isSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).isSameAs(new StringBuilder("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same. Expected:<value> but was:<value>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").isSameAs(new StringBuilder("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual and expected values should be the same. Expected:<value> but was:<value>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).isNotSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").isNotSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            StringBuilder value = new StringBuilder("value");
            createReferenceAssertion(value).isNotSameAs(value);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different. Actual:<value>");
        }
        try {
            StringBuilder value = new StringBuilder("value");
            createReferenceAssertion(value, "Message").isNotSameAs(value);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual and expected values should be different. Actual:<value>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new StringBuilder("value")).toClass()).isSameAs(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new StringBuilder("value"), "Message").toClass()).isSameAs(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).toClass().isSameAs(String.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual and expected values should be the same. Expected:<java.lang.String> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").toClass().isSameAs(String.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual and expected values should be the same. Expected:<java.lang.String> but was:<java.lang.StringBuilder>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).hasClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").hasClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).hasClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual and expected values should be the same. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new Object(), "Message").hasClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual and expected values should be the same. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).hasClass(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual and expected values should be the same. Expected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").hasClass(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual and expected values should be the same. Expected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).hasClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual and expected values should be the same. Expected:<java.lang.Object> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").hasClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual and expected values should be the same. Expected:<java.lang.Object> but was:<java.lang.StringBuilder>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).hasNotClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").hasNotClass(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).hasNotClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual and expected values should be different. Actual:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new Object(), "Message").hasNotClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual and expected values should be different. Actual:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).hasNotClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual and expected values should be different. Actual:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").hasNotClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual and expected values should be different. Actual:<java.lang.StringBuilder>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(Object.class).isInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion(Object.class, "Message").isInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).isInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new Object(), "Message").isInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(Object.class).isNotInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion(Object.class, "Message").isNotInstanceOf(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new Object(), "Message").isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.Object>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).isNotInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual value should not be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").isNotInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual value should not be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).isNotInstanceOf(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual value should not be the subtype of the expected value. Expected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").isNotInstanceOf(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual value should not be the subtype of the expected value. Expected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value")).isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's class. Actual value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.StringBuilder>");
        }
        try {
            createReferenceAssertion(new StringBuilder("value"), "Message").isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's class. Actual value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.StringBuilder>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion("reference").toToString()).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation. Actual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion("reference", "Message").toToString()).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's string representation. Actual value should not be null.");
        }
        try {
            createReferenceAssertion("reference").toToString().isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation. Actual and expected values should be the same. Expected:<value> but was:<reference>");
        }
        try {
            createReferenceAssertion("reference", "Message").toToString().isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's string representation. Actual and expected values should be the same. Expected:<value> but was:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isToStringEqualToTest() {
        createReferenceAssertion("reference").isToStringEqualTo("reference");

        try {
            createReferenceAssertion().isToStringEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).isToStringEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isToStringEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null).isToStringEqualTo(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isToStringEqualTo(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion("reference").isToStringEqualTo(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion("reference", "Message").isToStringEqualTo(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            createReferenceAssertion("reference").isToStringEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation. Actual and expected values should be the same. Expected:<value> but was:<reference>");
        }
        try {
            createReferenceAssertion("reference", "Message").isToStringEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's string representation. Actual and expected values should be the same. Expected:<value> but was:<reference>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion("value").toStringContains(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion("value", "Message").toStringContains(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            createReferenceAssertion("reference").toStringContains("FEREN");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's string representation. Actual value should contain the expected value. Expected:<FEREN> but was:<reference>");
        }
        try {
            createReferenceAssertion("reference", "Message").toStringContains("FEREN");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's string representation. Actual value should contain the expected value. Expected:<FEREN> but was:<reference>");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion("reference").toHashCode()).isEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hash code. Actual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion("reference", "Message").toHashCode()).isEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's hash code. Actual value should not be null.");
        }
        try {
            createReferenceAssertion("reference").toHashCode().isEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hash code. Actual and expected values should be the same. Expected:<1> but was:<-925155509>");
        }
        try {
            createReferenceAssertion("reference", "Message").toHashCode().isEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's hash code. Actual and expected values should be the same. Expected:<1> but was:<-925155509>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isHashCodeEqualToTest() {
        createReferenceAssertion("reference").isHashCodeEqualTo(-925155509);

        try {
            createReferenceAssertion().isHashCodeEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            createReferenceAssertion(null).isHashCodeEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").isHashCodeEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion("reference").isHashCodeEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hash code. Actual and expected values should be the same. Expected:<1> but was:<-925155509>");
        }
        try {
            createReferenceAssertion("reference", "Message").isHashCodeEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's hash code. Actual and expected values should be the same. Expected:<1> but was:<-925155509>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toFieldObjectAssertionTest() {
        createReferenceAssertion(new ToFieldParentClass()).toField("_nullField").isNull();
        createReferenceAssertion(new ToFieldParentClass()).toField("_parentField").isNotNull();
        createReferenceAssertion(new ToFieldParentClass()).toField("_parentField").isEqualTo("parentField");

        createReferenceAssertion(new ToFieldChildClass()).toField("_nullField").isNull();
        createReferenceAssertion(new ToFieldChildClass()).toField("_parentField").isNotNull();
        createReferenceAssertion(new ToFieldChildClass()).toField("_parentField").isEqualTo("parentField");
        createReferenceAssertion(new ToFieldChildClass()).toField("_childField").isNotNull();
        createReferenceAssertion(new ToFieldChildClass()).toField("_childField").isEqualTo("childField");

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new ToFieldParentClass()).toField(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion(new ToFieldParentClass(), "Message").toField(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            createReferenceAssertion(new ToFieldParentClass()).toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected field. Expected:<wrongFieldName>");
        }
        try {
            createReferenceAssertion(new ToFieldParentClass(), "Message").toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain the expected field. Expected:<wrongFieldName>");
        }
        try {
            createReferenceAssertion(new ToFieldChildClass()).toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected field. Expected:<wrongFieldName>");
        }
        try {
            createReferenceAssertion(new ToFieldChildClass(), "Message").toField("wrongFieldName");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should contain the expected field. Expected:<wrongFieldName>");
        }
        try {
            clearActual(createReferenceAssertion(new ToFieldParentClass()).toField("_parentField")).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _parentField. Actual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ToFieldParentClass(), "Message").toField("_parentField")).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's field: _parentField. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new ToFieldParentClass()).toField("_parentField").isEqualTo("wrongFieldValue");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _parentField. Actual and expected values should be the same. Expected:<wrongFieldValue> but was:<parentField>");
        }
        try {
            createReferenceAssertion(new ToFieldParentClass(), "Message").toField("_parentField").isEqualTo("wrongFieldValue");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's field: _parentField. Actual and expected values should be the same. Expected:<wrongFieldValue> but was:<parentField>");
        }
        try {
            createReferenceAssertion(new ToFieldChildClass()).toField("_childField").isEqualTo("wrongFieldValue");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _childField. Actual and expected values should be the same. Expected:<wrongFieldValue> but was:<childField>");
        }
        try {
            createReferenceAssertion(new ToFieldChildClass(), "Message").toField("_childField").isEqualTo("wrongFieldValue");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's field: _childField. Actual and expected values should be the same. Expected:<wrongFieldValue> but was:<childField>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toFieldSpecifiedAssertionTest() {
        createReferenceAssertion(new ToFieldParentClass()).toField("_nullField", Raw.stringAssertion()).isNull();
        createReferenceAssertion(new ToFieldParentClass()).toField("_nullField", Raw.classAssertion()).isNull();
        createReferenceAssertion(new ToFieldParentClass()).toField("_parentField", Raw.stringAssertion()).isEqualTo("parentField");

        createReferenceAssertion(new ToFieldChildClass()).toField("_nullField", Raw.stringAssertion()).isNull();
        createReferenceAssertion(new ToFieldChildClass()).toField("_nullField", Raw.classAssertion()).isNull();
        createReferenceAssertion(new ToFieldChildClass()).toField("_parentField", Raw.stringAssertion()).isEqualTo("parentField");
        createReferenceAssertion(new ToFieldChildClass()).toField("_childField", Raw.stringAssertion()).isEqualTo("childField");

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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null).toField("value", null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            createReferenceAssertion(null, "Message").toField("value", null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toField(null, Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toField(null, Raw.objectAssertion());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object()).toField("value", null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            createReferenceAssertion(new Object(), "Message").toField("value", null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ToFieldParentClass()).toField("_parentField", Raw.stringAssertion())).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _parentField. Actual value should not be null.");
        }
        try {
            clearActual(createReferenceAssertion(new ToFieldParentClass(), "Message").toField("_parentField", Raw.stringAssertion())).isEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's field: _parentField. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new ToFieldParentClass()).toField("_nullField", Raw.stringAssertion()).isNotNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's field: _nullField. Actual value should not be null.");
        }
        try {
            createReferenceAssertion(new ToFieldParentClass(), "Message").toField("_nullField", Raw.stringAssertion()).isNotNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check actual value's field: _nullField. Actual value should not be null.");
        }
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ToFieldParentClass {

        private String _nullField;

        private String _parentField = "parentField";

        ToFieldParentClass() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ToFieldChildClass extends ToFieldParentClass {

        private String _childField = "childField";

        ToFieldChildClass() {
            super();
        }

    }

}
