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
package ru.d_shap.assertions.core;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link EnumAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class EnumAssertionTest {

    /**
     * Test class constructor.
     */
    public EnumAssertionTest() {
        super();
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void toValueCountTest() {
        new EnumAssertion(Values.class, null).toValueCount().isEqualTo(3);
        new EnumAssertion(Values.class, null).toValueCount().isGreaterThan(2);
        new EnumAssertion(Values.class, null).toValueCount().isLessThan(4);

        try {
            new EnumAssertion(null, null).toValueCount();
            Assertions.fail("Enum assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new EnumAssertion(Values.class, null).toValueCount().isEqualTo(4);
            Assertions.fail("Enum assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new EnumAssertion(Values.class, "Message").toValueCount().isEqualTo(4);
            Assertions.fail("Enum assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void hasValueCountTest() {
        new EnumAssertion(Values.class, null).hasValueCount(3);

        try {
            new EnumAssertion(null, null).hasValueCount(3);
            Assertions.fail("Enum assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new EnumAssertion(Values.class, null).hasValueCount(4);
            Assertions.fail("Enum assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            new EnumAssertion(Values.class, "Message").hasValueCount(4);
            Assertions.fail("Enum assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void callReflectionCatchStatemensTest() {
        try {
            new EnumAssertion(Values.class, null, "wrongMethodName", "valueOf").toValueCount();
            Assertions.fail("Enum assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasCauseInstanceOf(NoSuchMethodException.class);
        }
        try {
            new EnumAssertion(Values.class, null, "values", "wrongMethodName").toValueCount();
            Assertions.fail("Enum assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasCauseInstanceOf(NoSuchMethodException.class);
        }
    }

    /**
     * Test enum.
     *
     * @author Dmitry Shapovalov
     */
    private enum Values {

        VALUE_1, VALUE_2, VALUE_3

    }

}
