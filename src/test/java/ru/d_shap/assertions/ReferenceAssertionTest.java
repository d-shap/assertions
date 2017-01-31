///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
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
        new ReferenceAssertionImpl(null).isNull();

        try {
            new ReferenceAssertionImpl("reference").isNull();
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
        new ReferenceAssertionImpl(new Object()).isNotNull();
        new ReferenceAssertionImpl("reference").isNotNull();

        try {
            new ReferenceAssertionImpl(null).isNotNull();
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
        new ReferenceAssertionImpl(object).isSameAs(object);

        try {
            new ReferenceAssertionImpl(null).isSameAs(new StringBuilder("value"));
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value")).isSameAs(null);
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new StringBuilder("value")).isSameAs(new StringBuilder("value"));
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
        new ReferenceAssertionImpl(new Object()).isNotSameAs(new Object());
        new ReferenceAssertionImpl(new StringBuilder("value")).isNotSameAs(new StringBuilder("value"));

        try {
            new ReferenceAssertionImpl(null).isNotSameAs(new Object());
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReferenceAssertionImpl(new Object()).isNotSameAs(null);
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            StringBuilder value = new StringBuilder("value");
            new ReferenceAssertionImpl(value).isNotSameAs(value);
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
        new ReferenceAssertionImpl(new Object()).toClass().isSameAs(Object.class);
        new ReferenceAssertionImpl(new Object()).toClass().isSubtypeOf(Object.class);

        new ReferenceAssertionImpl(new StringBuilder("value")).toClass().isSameAs(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value")).toClass().isSubtypeOf(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value")).toClass().isSubtypeOf(CharSequence.class);
        new ReferenceAssertionImpl(new StringBuilder("value")).toClass().isSubtypeOf(Object.class);

        try {
            new ReferenceAssertionImpl(null).toClass();
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
        new ReferenceAssertionImpl(new Object()).isInstanceOf(Object.class);

        new ReferenceAssertionImpl(new StringBuilder("value")).isInstanceOf(StringBuilder.class);
        new ReferenceAssertionImpl(new StringBuilder("value")).isInstanceOf(CharSequence.class);
        new ReferenceAssertionImpl(new StringBuilder("value")).isInstanceOf(Object.class);

        try {
            new ReferenceAssertionImpl(new Object()).isInstanceOf(StringBuilder.class);
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the subtype of the expected value. Expected:<java.lang.StringBuilder> but was:<java.lang.Object>");
        }
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ReferenceAssertionImpl extends ReferenceAssertion {

        ReferenceAssertionImpl(final Object actual) {
            super(actual, null);
        }

        @Override
        protected String asString(final Object value) {
            return String.valueOf(value);
        }

    }

}
