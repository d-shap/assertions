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
    public void constructorTest() {
        new EnumAssertion(null, new FailDescription()).isNull();
        new EnumAssertion(Values.class, new FailDescription()).isNotNull();

        try {
            new EnumAssertion(String.class, new FailDescription());
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be the enum. Actual:<java.lang.String>.");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void toValueCountTest() {
        new EnumAssertion(Values.class, new FailDescription()).toValueCount().isEqualTo(3);
        new EnumAssertion(Values.class, new FailDescription()).toValueCount().isGreaterThan(2);
        new EnumAssertion(Values.class, new FailDescription()).toValueCount().isLessThan(4);

        try {
            new EnumAssertion(null, new FailDescription()).toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new EnumAssertion(Values.class, new FailDescription()).toValueCount().isEqualTo(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check enum value count. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new EnumAssertion(Values.class, new FailDescription("Message")).toValueCount().isEqualTo(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check enum value count. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void hasValueCountTest() {
        new EnumAssertion(Values.class, new FailDescription()).hasValueCount(3);

        try {
            new EnumAssertion(null, new FailDescription()).hasValueCount(3);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new EnumAssertion(Values.class, new FailDescription()).hasValueCount(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check enum value count. Values should be the same. Expected:<4> but was:<3>.");
        }
        try {
            new EnumAssertion(Values.class, new FailDescription("Message")).hasValueCount(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check enum value count. Values should be the same. Expected:<4> but was:<3>.");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void callReflectionCatchStatemensTest() {
        try {
            new EnumAssertion(Values.class, new FailDescription(), "wrongMethodName", "valueOf").toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).isCauseInstanceOf(NoSuchMethodException.class);
        }
        try {
            new EnumAssertion(Values.class, new FailDescription(), "values", "wrongMethodName").toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).isCauseInstanceOf(NoSuchMethodException.class);
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
