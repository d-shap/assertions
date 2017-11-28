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

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link EnumAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class EnumAssertionTest extends AssertionTest {

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
    public void actualValueValidatorTest() {
        initialize(Raw.enumAssertion(), Values.class);

        try {
            initialize(Raw.enumAssertion(), String.class);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.enumAssertion(), String.class, "Message");
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void constructorTest() {
        initialize(Raw.enumAssertion(), null).isNull();
        initialize(Raw.enumAssertion(), Values.class).isNotNull();

        try {
            initialize(Raw.enumAssertion(), String.class);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void toValueCountTest() {
        initialize(Raw.enumAssertion(), Values.class).toValueCount().isEqualTo(3);
        initialize(Raw.enumAssertion(), Values.class).toValueCount().isGreaterThan(2);
        initialize(Raw.enumAssertion(), Values.class).toValueCount().isLessThan(4);

        try {
            initialize(Raw.enumAssertion(), null).toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), null, "Message").toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class).toValueCount().isEqualTo(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check enum value count. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class, "Message").toValueCount().isEqualTo(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check enum value count. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void hasValueCountTest() {
        initialize(Raw.enumAssertion(), Values.class).hasValueCount(3);

        try {
            initialize(Raw.enumAssertion(), Values.class).hasValueCount(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check enum value count. Values should be the same. Expected:<4> but was:<3>");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class, "Message").hasValueCount(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check enum value count. Values should be the same. Expected:<4> but was:<3>");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void callReflectionCatchStatemensTest() {
        try {
            initialize(new EnumAssertion("wrongMethodName", "valueOf"), Values.class).toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).isCauseInstanceOf(NoSuchMethodException.class);
        }
        try {
            initialize(new EnumAssertion("values", "wrongMethodName"), Values.class).toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).isCauseInstanceOf(NoSuchMethodException.class);
        }
    }

}
