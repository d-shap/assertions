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
public final class ReferenceAssertionTest {

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
        new ReferenceAssertionImpl(null, null).isNull();

        try {
            new ReferenceAssertionImpl("reference", null).isNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNotNullTest() {
        new ReferenceAssertionImpl(new Object(), null).isNotNull();
        new ReferenceAssertionImpl("reference", null).isNotNull();

        try {
            new ReferenceAssertionImpl(null, null).isNotNull();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Object object = new Object();
        new ReferenceAssertionImpl(object, null).isSameAs(object);

        try {
            new ReferenceAssertionImpl(null, null).isSameAs(new StringBuilder("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).isSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).isSameAs(new StringBuilder("value"));
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value> but was:<value>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        new ReferenceAssertionImpl(new Object(), null).isNotSameAs(new Object());
        new ReferenceAssertionImpl(new StringBuilder("value"), null).isNotSameAs(new StringBuilder("value"));

        try {
            new ReferenceAssertionImpl(null, null).isNotSameAs(new Object());
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new Object(), null).isNotSameAs(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            StringBuilder value = new StringBuilder("value");
            new ReferenceAssertionImpl(value, null).isNotSameAs(value);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toClassTest() {
        new ReferenceAssertionImpl(new Object(), null).toClass().isSameAs(Object.class);
        new ReferenceAssertionImpl(new Object(), null).toClass().isSubtypeOf(Object.class);

        new ReferenceAssertionImpl(new StringBuilder("value"), null).toClass().isSameAs(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), null).toClass().isSubtypeOf(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), null).toClass().isSubtypeOf(CharSequence.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), null).toClass().isSubtypeOf(Object.class);

        try {
            new ReferenceAssertionImpl(null, null).toClass();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void hasClassTest() {
        new ReferenceAssertionImpl(new Object(), null).hasClass(Object.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), null).hasClass(StringBuilder.class);

        try {
            new ReferenceAssertionImpl(new Object(), null).hasClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).hasClass(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).hasClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<java.lang.Object> but was:<java.lang.StringBuilder>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void hasNotClassTest() {
        new ReferenceAssertionImpl(new Object(), null).hasNotClass(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), null).hasNotClass(CharSequence.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), null).hasNotClass(Object.class);

        try {
            new ReferenceAssertionImpl(new Object(), null).hasNotClass(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<java.lang.Object>");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).hasNotClass(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<java.lang.StringBuilder>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isInstanceOfTest() {
        new ReferenceAssertionImpl(new Object(), null).isInstanceOf(Object.class);

        new ReferenceAssertionImpl(new StringBuilder("value"), null).isInstanceOf(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), null).isInstanceOf(CharSequence.class);
        new ReferenceAssertionImpl(new StringBuilder("value"), null).isInstanceOf(Object.class);

        try {
            new ReferenceAssertionImpl(new Object(), null).isInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNotInstanceOfTest() {
        new ReferenceAssertionImpl(new Object(), null).isNotInstanceOf(StringBuilder.class);

        try {
            new ReferenceAssertionImpl(new Object(), null).isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.Object>");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).isNotInstanceOf(StringBuilder.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.StringBuilder>");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).isNotInstanceOf(CharSequence.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.CharSequence> but was:<java.lang.StringBuilder>");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).isNotInstanceOf(Object.class);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be the subtype of the expected value. Expected:<java.lang.Object> but was:<java.lang.StringBuilder>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toToStringTest() {
        new ReferenceAssertionImpl("reference", null).toToString().isEqualTo("reference");
        new ReferenceAssertionImpl("reference", null).toToString().startsWith("ref");
        new ReferenceAssertionImpl("reference", null).toToString().endsWith("ce");

        try {
            new ReferenceAssertionImpl(null, null).toToString();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isToStringEqualToTest() {
        new ReferenceAssertionImpl("reference", null).isToStringEqualTo("reference");

        try {
            new ReferenceAssertionImpl("reference", null).isToStringEqualTo(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReferenceAssertionImpl("reference", null).isToStringEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value> but was:<reference>");
        }
        try {
            new ReferenceAssertionImpl("reference", "Message").isToStringEqualTo("value");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<value> but was:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toStringContainsTest() {
        new ReferenceAssertionImpl("reference", null).toStringContains("feren");

        try {
            new ReferenceAssertionImpl("reference", null).toStringContains("FEREN");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<FEREN> but was:<reference>");
        }
        try {
            new ReferenceAssertionImpl("reference", null).toStringContains(null);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReferenceAssertionImpl("reference", "Message").toStringContains("FEREN");
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<FEREN> but was:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void toHashCodeTest() {
        new ReferenceAssertionImpl("reference", null).toHashCode().isEqualTo(-925155509);
        new ReferenceAssertionImpl("reference", null).toHashCode().isLessThan(0);
        new ReferenceAssertionImpl("reference", null).toHashCode().isNotInRange(1, 10);

        try {
            new ReferenceAssertionImpl(null, null).toHashCode();
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isHashCodeEqualToTest() {
        new ReferenceAssertionImpl("reference", null).isHashCodeEqualTo(-925155509);

        try {
            new ReferenceAssertionImpl("reference", null).isHashCodeEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<1> but was:<-925155509>");
        }
        try {
            new ReferenceAssertionImpl("reference", "Message").isHashCodeEqualTo(1);
            Assertions.fail("ReferenceAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<1> but was:<-925155509>");
        }
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ReferenceAssertionImpl extends ReferenceAssertion {

        ReferenceAssertionImpl(final Object actual, final String message) {
            super(actual, message);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

}
