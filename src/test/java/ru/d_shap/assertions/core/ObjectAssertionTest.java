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
package ru.d_shap.assertions.core;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ObjectAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectAssertionTest {

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
        new ObjectAssertion("value", null).isEqualTo("value");

        try {
            new ObjectAssertion(null, null).isEqualTo("value");
            Assertions.fail("Object assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectAssertion("value", null).isEqualTo(null);
            Assertions.fail("Object assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectAssertion("value1", null).isEqualTo("value2");
            Assertions.fail("Object assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ObjectAssertion("value1", null).isNotEqualTo("value2");
        new ObjectAssertion("value2", null).isNotEqualTo("value1");

        try {
            new ObjectAssertion(null, null).isNotEqualTo("value");
            Assertions.fail("Object assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectAssertion("value", null).isNotEqualTo(null);
            Assertions.fail("Object assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectAssertion("value", null).isNotEqualTo("value");
            Assertions.fail("Object assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ObjectAssertion(new Object(), null).asString(null)).isNull();
        Assertions.assertThat(new ObjectAssertion(new Object(), null).asString("value")).isEqualTo("value");
        Assertions.assertThat(new ObjectAssertion(new Object(), null).asString(1)).isEqualTo("1");
        Assertions.assertThat(new ObjectAssertion(new Object(), null).asString(new StringBuilder("builder"))).isEqualTo("builder");
    }

}
