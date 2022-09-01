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
 * Tests for {@link ShortAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortHexStringAssertionTest() {
        super();
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.shortAssertion(), (short) 0).toHexString().isEqualTo("0000");
        initialize(Raw.shortAssertion(), (short) 1).toHexString().isEqualTo("0001");
        initialize(Raw.shortAssertion(), (short) 31).toHexString().isEqualTo("001f");
        initialize(Raw.shortAssertion(), (short) 50).toHexString().isEqualTo("0032");
        initialize(Raw.shortAssertion(), (short) 100).toHexString().isEqualTo("0064");
        initialize(Raw.shortAssertion(), (short) 479).toHexString().isEqualTo("01df");
        initialize(Raw.shortAssertion(), (short) 7311).toHexString().isEqualTo("1c8f");
        initialize(Raw.shortAssertion(), (short) 32767).toHexString().isEqualTo("7fff");
        initialize(Raw.shortAssertion(), (short) -1).toHexString().isEqualTo("ffff");
        initialize(Raw.shortAssertion(), (short) -32767).toHexString().isEqualTo("8001");
        initialize(Raw.shortAssertion(), (short) 31).isNotNull().toHexString().isEqualTo("001f");

        try {
            Raw.shortAssertion().toHexString();
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).toHexString();
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").toHexString();
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortAssertion(), (short) 11).toHexString()).isEqualTo("0011");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortAssertion(), (short) 11, "Message").toHexString()).isEqualTo("0011");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).toHexString().isEqualTo("0011");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0011> but was:<000b>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").toHexString().isEqualTo("0011");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0011> but was:<000b>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.shortAssertion(), (short) 0).toHexString(Matchers.is(Matchers.equalTo("0000")));
        initialize(Raw.shortAssertion(), (short) 1).toHexString(Matchers.is(Matchers.equalTo("0001")));
        initialize(Raw.shortAssertion(), (short) 31).toHexString(Matchers.is(Matchers.equalTo("001f")));
        initialize(Raw.shortAssertion(), (short) 50).toHexString(Matchers.is(Matchers.equalTo("0032")));
        initialize(Raw.shortAssertion(), (short) 100).toHexString(Matchers.is(Matchers.equalTo("0064")));
        initialize(Raw.shortAssertion(), (short) 479).toHexString(Matchers.is(Matchers.equalTo("01df")));
        initialize(Raw.shortAssertion(), (short) 7311).toHexString(Matchers.is(Matchers.equalTo("1c8f")));
        initialize(Raw.shortAssertion(), (short) 32767).toHexString(Matchers.is(Matchers.equalTo("7fff")));
        initialize(Raw.shortAssertion(), (short) -1).toHexString(Matchers.is(Matchers.equalTo("ffff")));
        initialize(Raw.shortAssertion(), (short) -32767).toHexString(Matchers.is(Matchers.equalTo("8001")));
        initialize(Raw.shortAssertion(), (short) 31).isNotNull().toHexString(Matchers.is(Matchers.equalTo("001f"))).isInstanceOf(Short.class);

        try {
            Raw.shortAssertion().toHexString(Matchers.equalTo("0"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).toHexString(Matchers.equalTo("0"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").toHexString(Matchers.equalTo("0"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null).toHexString(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").toHexString(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1).toHexString(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 1, "Message").toHexString(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).toHexString(Matchers.equalTo("0011"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0011\"\n     but: was \"000b\"");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").toHexString(Matchers.equalTo("0011"));
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0011\"\n     but: was \"000b\"");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.shortAssertion(), (short) 0).hasHexString("0000");
        initialize(Raw.shortAssertion(), (short) 1).hasHexString("0001");
        initialize(Raw.shortAssertion(), (short) 31).hasHexString("001f");
        initialize(Raw.shortAssertion(), (short) 50).hasHexString("0032");
        initialize(Raw.shortAssertion(), (short) 100).hasHexString("0064");
        initialize(Raw.shortAssertion(), (short) 479).hasHexString("01df");
        initialize(Raw.shortAssertion(), (short) 7311).hasHexString("1c8f");
        initialize(Raw.shortAssertion(), (short) 32767).hasHexString("7fff");
        initialize(Raw.shortAssertion(), (short) -1).hasHexString("ffff");
        initialize(Raw.shortAssertion(), (short) -32767).hasHexString("8001");
        initialize(Raw.shortAssertion(), (short) 31).isNotNull().hasHexString("001f").isInstanceOf(Short.class);

        try {
            Raw.shortAssertion().hasHexString("0");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortAssertion(), null).hasHexString("0");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").hasHexString("0");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null).hasHexString(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), null, "Message").hasHexString(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).hasHexString(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").hasHexString(null);
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11).hasHexString("0011");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0011> but was:<000b>");
        }
        try {
            initialize(Raw.shortAssertion(), (short) 11, "Message").hasHexString("0011");
            Assertions.fail("ShortAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0011> but was:<000b>");
        }
    }

}
