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

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntHexStringAssertionTest() {
        super();
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.intAssertion(), 0).toHexString().isEqualTo("00000000");
        initialize(Raw.intAssertion(), 1).toHexString().isEqualTo("00000001");
        initialize(Raw.intAssertion(), 31).toHexString().isEqualTo("0000001f");
        initialize(Raw.intAssertion(), 50).toHexString().isEqualTo("00000032");
        initialize(Raw.intAssertion(), 100).toHexString().isEqualTo("00000064");
        initialize(Raw.intAssertion(), 479).toHexString().isEqualTo("000001df");
        initialize(Raw.intAssertion(), 7311).toHexString().isEqualTo("00001c8f");
        initialize(Raw.intAssertion(), 102351).toHexString().isEqualTo("00018fcf");
        initialize(Raw.intAssertion(), 1300879).toHexString().isEqualTo("0013d98f");
        initialize(Raw.intAssertion(), 26461823).toHexString().isEqualTo("0193c67f");
        initialize(Raw.intAssertion(), Integer.MAX_VALUE).toHexString().isEqualTo("7fffffff");
        initialize(Raw.intAssertion(), -1).toHexString().isEqualTo("ffffffff");
        initialize(Raw.intAssertion(), Integer.MIN_VALUE).toHexString().isEqualTo("80000000");
        initialize(Raw.intAssertion(), 31).isNotNull().toHexString().isEqualTo("0000001f");

        try {
            Raw.intAssertion().toHexString();
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).toHexString();
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").toHexString();
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intAssertion(), 11).toHexString()).isEqualTo("00000011");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intAssertion(), 11, "Message").toHexString()).isEqualTo("00000011");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 11).toHexString().isEqualTo("00000011");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000011> but was:<0000000b>");
        }
        try {
            initialize(Raw.intAssertion(), 11, "Message").toHexString().isEqualTo("00000011");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000011> but was:<0000000b>");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.intAssertion(), 0).toHexString(Matchers.is(Matchers.equalTo("00000000")));
        initialize(Raw.intAssertion(), 1).toHexString(Matchers.is(Matchers.equalTo("00000001")));
        initialize(Raw.intAssertion(), 31).toHexString(Matchers.is(Matchers.equalTo("0000001f")));
        initialize(Raw.intAssertion(), 50).toHexString(Matchers.is(Matchers.equalTo("00000032")));
        initialize(Raw.intAssertion(), 100).toHexString(Matchers.is(Matchers.equalTo("00000064")));
        initialize(Raw.intAssertion(), 479).toHexString(Matchers.is(Matchers.equalTo("000001df")));
        initialize(Raw.intAssertion(), 7311).toHexString(Matchers.is(Matchers.equalTo("00001c8f")));
        initialize(Raw.intAssertion(), 102351).toHexString(Matchers.is(Matchers.equalTo("00018fcf")));
        initialize(Raw.intAssertion(), 1300879).toHexString(Matchers.is(Matchers.equalTo("0013d98f")));
        initialize(Raw.intAssertion(), 26461823).toHexString(Matchers.is(Matchers.equalTo("0193c67f")));
        initialize(Raw.intAssertion(), Integer.MAX_VALUE).toHexString(Matchers.is(Matchers.equalTo("7fffffff")));
        initialize(Raw.intAssertion(), -1).toHexString(Matchers.is(Matchers.equalTo("ffffffff")));
        initialize(Raw.intAssertion(), Integer.MIN_VALUE).toHexString(Matchers.is(Matchers.equalTo("80000000")));
        initialize(Raw.intAssertion(), 31).isNotNull().toHexString(Matchers.is(Matchers.equalTo("0000001f"))).isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().toHexString(Matchers.equalTo("0"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).toHexString(Matchers.equalTo("0"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").toHexString(Matchers.equalTo("0"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null).toHexString(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").toHexString(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 1).toHexString(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intAssertion(), 1, "Message").toHexString(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intAssertion(), 11).toHexString(Matchers.equalTo("00000011"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00000011\"\n     but: was \"0000000b\"");
        }
        try {
            initialize(Raw.intAssertion(), 11, "Message").toHexString(Matchers.equalTo("00000011"));
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00000011\"\n     but: was \"0000000b\"");
        }
    }

    /**
     * {@link IntAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.intAssertion(), 0).hasHexString("00000000");
        initialize(Raw.intAssertion(), 1).hasHexString("00000001");
        initialize(Raw.intAssertion(), 31).hasHexString("0000001f");
        initialize(Raw.intAssertion(), 50).hasHexString("00000032");
        initialize(Raw.intAssertion(), 100).hasHexString("00000064");
        initialize(Raw.intAssertion(), 479).hasHexString("000001df");
        initialize(Raw.intAssertion(), 7311).hasHexString("00001c8f");
        initialize(Raw.intAssertion(), 102351).hasHexString("00018fcf");
        initialize(Raw.intAssertion(), 1300879).hasHexString("0013d98f");
        initialize(Raw.intAssertion(), 26461823).hasHexString("0193c67f");
        initialize(Raw.intAssertion(), Integer.MAX_VALUE).hasHexString("7fffffff");
        initialize(Raw.intAssertion(), -1).hasHexString("ffffffff");
        initialize(Raw.intAssertion(), Integer.MIN_VALUE).hasHexString("80000000");
        initialize(Raw.intAssertion(), 31).isNotNull().hasHexString("0000001f").isInstanceOf(Integer.class);

        try {
            Raw.intAssertion().hasHexString("0");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intAssertion(), null).hasHexString("0");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").hasHexString("0");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null).hasHexString(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), null, "Message").hasHexString(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intAssertion(), 11).hasHexString(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 11, "Message").hasHexString(null);
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intAssertion(), 11).hasHexString("00000011");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000011> but was:<0000000b>");
        }
        try {
            initialize(Raw.intAssertion(), 11, "Message").hasHexString("00000011");
            Assertions.fail(IntAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000011> but was:<0000000b>");
        }
    }

}
