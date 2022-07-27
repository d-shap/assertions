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
package ru.d_shap.assertions.asimp.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link BooleanAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BooleanAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BooleanAssertionTest() {
        super();
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.booleanAssertion(), true);

        try {
            initializeWithRawActual(Raw.booleanAssertion(), new Object());
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Boolean> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.booleanAssertion(), new Object(), "Message");
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Boolean> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void isTrueTest() {
        initialize(Raw.booleanAssertion(), true).isTrue();
        initialize(Raw.booleanAssertion(), true).isNotNull().isTrue().isInstanceOf(Boolean.class).isNotInstanceOf(boolean.class);

        try {
            Raw.booleanAssertion().isTrue();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanAssertion(), null).isTrue();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanAssertion(), null, "Message").isTrue();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanAssertion(), false).isTrue();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be true.");
        }
        try {
            initialize(Raw.booleanAssertion(), false, "Message").isTrue();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be true.");
        }
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void isFalseTest() {
        initialize(Raw.booleanAssertion(), false).isFalse();
        initialize(Raw.booleanAssertion(), false).isNotNull().isFalse().isInstanceOf(Boolean.class).isNotInstanceOf(boolean.class);

        try {
            Raw.booleanAssertion().isFalse();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.booleanAssertion(), null).isFalse();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.booleanAssertion(), null, "Message").isFalse();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.booleanAssertion(), true).isFalse();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be false.");
        }
        try {
            initialize(Raw.booleanAssertion(), true, "Message").isFalse();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be false.");
        }
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.booleanAssertion(), null).isNull();

        try {
            initialize(Raw.booleanAssertion(), true).isNull();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<T>");
        }
        try {
            initialize(Raw.booleanAssertion(), true, "Message").isNull();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<T>");
        }
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Boolean value = true;
        initialize(Raw.booleanAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.booleanAssertion(), value).isSameAs(false);
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<F> but was:<T>");
        }
        try {
            initialize(Raw.booleanAssertion(), value, "Message").isSameAs(false);
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<F> but was:<T>");
        }
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Boolean value = true;
        initialize(Raw.booleanAssertion(), value).isNotSameAs(false);

        try {
            initialize(Raw.booleanAssertion(), value).isNotSameAs(value);
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<T>");
        }
        try {
            initialize(Raw.booleanAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<T>");
        }
    }

}
