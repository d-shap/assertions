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
package ru.d_shap.assertions;

import org.junit.Test;

import ru.d_shap.assertions.core.ObjectAssertion;

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
    public void getActualTest() {
        Object object = new Object();
        Assertions.assertThat(new ObjectAssertion(object, null).getActual()).isNotNull();
        Assertions.assertThat(new ObjectAssertion(object, null).getActual()).isSameAs(object);
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new ObjectAssertion(null, null).isNull();

        try {
            new ObjectAssertion("reference", null).isNull();
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
        new ObjectAssertion(new Object(), null).isNotNull();
        new ObjectAssertion("reference", null).isNotNull();

        try {
            new ObjectAssertion(null, null).isNotNull();
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
        new ObjectAssertion(object, null).isSameAs(object);

        try {
            new ObjectAssertion(new StringBuilder("value"), null).isSameAs(new StringBuilder("value"));
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
        new ObjectAssertion(new Object(), null).isNotSameAs(new Object());
        new ObjectAssertion(new StringBuilder("value"), null).isNotSameAs(new StringBuilder("value"));

        try {
            StringBuilder value = new StringBuilder("value");
            new ObjectAssertion(value, null).isNotSameAs(value);
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
        new ObjectAssertion(new Object(), null).toClass().isSameAs(Object.class);

        new ObjectAssertion(new StringBuilder("value"), null).toClass().isSameAs(StringBuilder.class);
        new ObjectAssertion(new StringBuilder("value"), null).toClass().isSubtypeOf(StringBuilder.class);
        new ObjectAssertion(new StringBuilder("value"), null).toClass().isSubtypeOf(CharSequence.class);
    }

    /**
     * {@link ReferenceAssertion} class test.
     */
    @Test
    public void isInstanceOfTest() {
        new ObjectAssertion(new Object(), null).isInstanceOf(Object.class);

        new ObjectAssertion(new StringBuilder("value"), null).isInstanceOf(StringBuilder.class);
        new ObjectAssertion(new StringBuilder("value"), null).isInstanceOf(CharSequence.class);

        try {
            new ObjectAssertion(new Object(), null).isInstanceOf(StringBuilder.class);
            Assertions.fail("Reference assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Class should be the subtype of the expected class. Expected:<class java.lang.StringBuilder> but was:<class java.lang.Object>");
        }
    }

}
