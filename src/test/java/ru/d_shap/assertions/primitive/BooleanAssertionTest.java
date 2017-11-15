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
