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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ObjectAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ObjectAssertionTest() {
        super();
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.objectAssertion(), null).isEqualTo(null);
        initialize(Raw.objectAssertion(), "value").isEqualTo("value");
        initialize(Raw.objectAssertion(), "value").isNotNull().isEqualTo("value").isInstanceOf(Object.class);

        try {
            Raw.objectAssertion().isEqualTo("value");
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.objectAssertion(), null).isEqualTo("value");
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), null, "Message").isEqualTo("value");
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), "value").isEqualTo(null);
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.objectAssertion(), "value", "Message").isEqualTo(null);
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.objectAssertion(), "value1").isEqualTo("value2");
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<value2> but was:<value1>");
        }
        try {
            initialize(Raw.objectAssertion(), "value1", "Message").isEqualTo("value2");
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<value2> but was:<value1>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.objectAssertion(), null).isNotEqualTo("value");
        initialize(Raw.objectAssertion(), "value").isNotEqualTo(null);
        initialize(Raw.objectAssertion(), "value1").isNotEqualTo("value2");
        initialize(Raw.objectAssertion(), "value2").isNotEqualTo("value1");
        initialize(Raw.objectAssertion(), "value2").isNotNull().isNotEqualTo("value1").isInstanceOf(Object.class);

        try {
            Raw.objectAssertion().isNotEqualTo("value");
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.objectAssertion(), null).isNotEqualTo(null);
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.objectAssertion(), "value").isNotEqualTo("value");
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<value>");
        }
        try {
            initialize(Raw.objectAssertion(), "value", "Message").isNotEqualTo("value");
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<value>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.objectAssertion(), null).isNull();

        try {
            initialize(Raw.objectAssertion(), "value").isNull();
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<value>");
        }
        try {
            initialize(Raw.objectAssertion(), "value", "Message").isNull();
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<value>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Object value = new Object();
        initialize(Raw.objectAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.objectAssertion(), value).isSameAs(new Object());
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should point to the same object.\n\tExpected:<java.lang.Object@.*> but was:<java.lang.Object@.*>");
        }
        try {
            initialize(Raw.objectAssertion(), value, "Message").isSameAs(new Object());
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<java.lang.Object@.*> but was:<java.lang.Object@.*>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Object value = new Object();
        initialize(Raw.objectAssertion(), value).isNotSameAs(new Object());

        try {
            initialize(Raw.objectAssertion(), value).isNotSameAs(value);
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should point to the different objects.\n\tActual:<java.lang.Object@.*>");
        }
        try {
            initialize(Raw.objectAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(ObjectAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<java.lang.Object@.*>");
        }
    }

}
