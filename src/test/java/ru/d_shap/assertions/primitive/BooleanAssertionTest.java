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
package ru.d_shap.assertions.primitive;

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
            initialize(Raw.booleanAssertion(), new Object());
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.booleanAssertion(), new Object(), "Message");
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void isTrueTest() {
        initialize(Raw.booleanAssertion(), true).isTrue();

        try {
            initialize(Raw.booleanAssertion(), false).isTrue();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be true.");
        }
        try {
            initialize(Raw.booleanAssertion(), false, "Message").isTrue();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be true.");
        }
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void isFalseTest() {
        initialize(Raw.booleanAssertion(), false).isFalse();

        try {
            initialize(Raw.booleanAssertion(), true).isFalse();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be false.");
        }
        try {
            initialize(Raw.booleanAssertion(), true, "Message").isFalse();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be false.");
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
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<true>");
        }
        try {
            initialize(Raw.booleanAssertion(), true, "Message").isNull();
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<true>");
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
            initialize(Raw.booleanAssertion(), value).isSameAs("test");
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<true>");
        }
        try {
            initialize(Raw.booleanAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<true>");
        }
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Boolean value = true;
        initialize(Raw.booleanAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.booleanAssertion(), value).isNotSameAs(value);
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<true>");
        }
        try {
            initialize(Raw.booleanAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("BooleanAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<true>");
        }
    }

    /**
     * {@link BooleanAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.booleanAssertion(), true).asString(null));
            Assertions.fail("BooleanAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.booleanAssertion(), true).asString(true)).isEqualTo("true");
        Assertions.assertThat(initialize(Raw.booleanAssertion(), true).asString(false)).isEqualTo("false");
        Assertions.assertThat(initialize(Raw.booleanAssertion(), true).asString("test")).isEqualTo("test");
    }

}
