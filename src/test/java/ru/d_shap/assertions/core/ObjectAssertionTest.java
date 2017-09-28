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
import ru.d_shap.assertions.FailDescription;

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
        new ObjectAssertion("value", new FailDescription()).isEqualTo("value");

        try {
            new ObjectAssertion(null, new FailDescription()).isEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectAssertion("value", new FailDescription()).isEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectAssertion("value1", new FailDescription()).isEqualTo("value2");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<value2> but was:<value1>.");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ObjectAssertion("value1", new FailDescription()).isNotEqualTo("value2");
        new ObjectAssertion("value2", new FailDescription()).isNotEqualTo("value1");

        try {
            new ObjectAssertion(null, new FailDescription()).isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ObjectAssertion("value", new FailDescription()).isNotEqualTo(null);
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ObjectAssertion("value", new FailDescription()).isNotEqualTo("value");
            Assertions.fail("ObjectAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<value>.");
        }
    }

    /**
     * {@link ObjectAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString("value", true)).isEqualTo("value");
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString(1, true)).isEqualTo("1");
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString(new StringBuilder("builder"), true)).isEqualTo("builder");

        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString("value", false)).isEqualTo("value");
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString(1, false)).isEqualTo("1");
        Assertions.assertThat(new ObjectAssertion(new Object(), new FailDescription()).asString(new StringBuilder("builder"), false)).isEqualTo("builder");
    }

}
