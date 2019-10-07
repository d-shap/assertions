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

import org.hamcrest.Matchers;
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
            initializeWithRawActual(Raw.enumAssertion(), String.class);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Enum> but was:<java.lang.Class>");
        }
        try {
            initializeWithRawActual(Raw.enumAssertion(), String.class, "Message");
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Enum> but was:<java.lang.Class>");
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
            Raw.enumAssertion().toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.enumAssertion(), null).toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), null, "Message").toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.enumAssertion(), Values.class).toValueCount()).isEqualTo(1);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value count.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.enumAssertion(), Values.class, "Message").toValueCount()).isEqualTo(1);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's value count.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class).toValueCount().isEqualTo(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value count.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class, "Message").toValueCount().isEqualTo(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's value count.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void toValueCountMatcherTest() {
        initialize(Raw.enumAssertion(), Values.class).toValueCount(Matchers.is(Matchers.equalTo(3)));
        initialize(Raw.enumAssertion(), Values.class).toValueCount(Matchers.is(Matchers.greaterThan(2)));
        initialize(Raw.enumAssertion(), Values.class).toValueCount(Matchers.is(Matchers.lessThan(4)));

        try {
            Raw.enumAssertion().toValueCount(Matchers.equalTo(0));
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.enumAssertion(), null).toValueCount(Matchers.equalTo(0));
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), null, "Message").toValueCount(Matchers.equalTo(0));
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), null).toValueCount(null);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), null, "Message").toValueCount(null);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class).toValueCount(null);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class, "Message").toValueCount(null);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class).toValueCount(Matchers.equalTo(4));
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value count.\nExpected: <4>\n     but: was <3>");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class, "Message").toValueCount(Matchers.equalTo(4));
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's value count.\nExpected: <4>\n     but: was <3>");
        }
    }

    /**
     * {@link EnumAssertion} class test.
     */
    @Test
    public void hasValueCountTest() {
        initialize(Raw.enumAssertion(), Values.class).hasValueCount(3);

        try {
            Raw.enumAssertion().hasValueCount(1);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.enumAssertion(), null).hasValueCount(1);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), null, "Message").hasValueCount(1);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class).hasValueCount(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's value count.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
        }
        try {
            initialize(Raw.enumAssertion(), Values.class, "Message").hasValueCount(4);
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's value count.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<3>");
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
            Assertions.assertThat(ex).hasCause(NoSuchMethodException.class);
        }
        try {
            initialize(new EnumAssertion("values", "wrongMethodName"), Values.class).toValueCount();
            Assertions.fail("EnumAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasCause(NoSuchMethodException.class);
        }
    }

}
