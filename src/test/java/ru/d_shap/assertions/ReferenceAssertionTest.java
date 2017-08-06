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
            Assertions.fail("Reference assertion test fail");
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
            Assertions.fail("Reference assertion test fail");
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
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).isSameAs(null);
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value"), null).isSameAs(new StringBuilder("value"));
            Assertions.fail("Reference assertion test fail");
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
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new Object(), null).isNotSameAs(null);
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            StringBuilder value = new StringBuilder("value");
            new ReferenceAssertionImpl(value, null).isNotSameAs(value);
            Assertions.fail("Reference assertion test fail");
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
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
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
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isToStringEqualToTest() {
        new ReferenceAssertionImpl("reference", null).isToStringEqualTo("reference");

        try {
            new ReferenceAssertionImpl(null, null).isToStringEqualTo("reference");
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl("reference", null).isToStringEqualTo("value");
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value> but was:<reference>");
        }
        try {
            new ReferenceAssertionImpl("reference", "Message").isToStringEqualTo("value");
            Assertions.fail("Reference assertion test fail");
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
            new ReferenceAssertionImpl(null, null).toStringContains("feren");
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl("reference", null).toStringContains("FEREN");
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<FEREN> but was:<reference>");
        }
        try {
            new ReferenceAssertionImpl("reference", "Message").toStringContains("FEREN");
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<FEREN> but was:<reference>");
        }
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isHashCodeEqualToTest() {
        new ReferenceAssertionImpl("reference", null).isHashCodeEqualTo(-925155509);

        try {
            new ReferenceAssertionImpl(null, null).isHashCodeEqualTo(-925155509);
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl("reference", null).isHashCodeEqualTo(1);
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<1> but was:<-925155509>");
        }
        try {
            new ReferenceAssertionImpl("reference", "Message").isHashCodeEqualTo(1);
            Assertions.fail("Reference assertion test fail");
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
