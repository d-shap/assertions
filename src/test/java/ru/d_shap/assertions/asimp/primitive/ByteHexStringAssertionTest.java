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
 * Tests for {@link ByteAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteHexStringAssertionTest() {
        super();
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.byteAssertion(), (byte) 0).toHexString().isEqualTo("00");
        initialize(Raw.byteAssertion(), (byte) 1).toHexString().isEqualTo("01");
        initialize(Raw.byteAssertion(), (byte) 31).toHexString().isEqualTo("1f");
        initialize(Raw.byteAssertion(), (byte) 50).toHexString().isEqualTo("32");
        initialize(Raw.byteAssertion(), (byte) 100).toHexString().isEqualTo("64");
        initialize(Raw.byteAssertion(), (byte) 101).toHexString().isEqualTo("65");
        initialize(Raw.byteAssertion(), (byte) -1).toHexString().isEqualTo("ff");
        initialize(Raw.byteAssertion(), (byte) -127).toHexString().isEqualTo("81");
        initialize(Raw.byteAssertion(), (byte) 31).isNotNull().toHexString().isEqualTo("1f");

        try {
            Raw.byteAssertion().toHexString();
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).toHexString();
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").toHexString();
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteAssertion(), (byte) 11).toHexString()).isEqualTo("11");
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteAssertion(), (byte) 11, "Message").toHexString()).isEqualTo("11");
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).toHexString().isEqualTo("11");
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<0b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").toHexString().isEqualTo("11");
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<0b>");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.byteAssertion(), (byte) 0).toHexString(Matchers.is(Matchers.equalTo("00")));
        initialize(Raw.byteAssertion(), (byte) 1).toHexString(Matchers.is(Matchers.equalTo("01")));
        initialize(Raw.byteAssertion(), (byte) 31).toHexString(Matchers.is(Matchers.equalTo("1f")));
        initialize(Raw.byteAssertion(), (byte) 50).toHexString(Matchers.is(Matchers.equalTo("32")));
        initialize(Raw.byteAssertion(), (byte) 100).toHexString(Matchers.is(Matchers.equalTo("64")));
        initialize(Raw.byteAssertion(), (byte) 101).toHexString(Matchers.is(Matchers.equalTo("65")));
        initialize(Raw.byteAssertion(), (byte) -1).toHexString(Matchers.is(Matchers.equalTo("ff")));
        initialize(Raw.byteAssertion(), (byte) -127).toHexString(Matchers.is(Matchers.equalTo("81")));
        initialize(Raw.byteAssertion(), (byte) 31).isNotNull().toHexString(Matchers.is(Matchers.equalTo("1f"))).isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().toHexString(Matchers.equalTo("0"));
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).toHexString(Matchers.equalTo("0"));
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").toHexString(Matchers.equalTo("0"));
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).toHexString(null);
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").toHexString(null);
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1).toHexString(null);
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 1, "Message").toHexString(null);
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).toHexString(Matchers.equalTo("11"));
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"11\"\n     but: was \"0b\"");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").toHexString(Matchers.equalTo("11"));
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"11\"\n     but: was \"0b\"");
        }
    }

    /**
     * {@link ByteAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.byteAssertion(), (byte) 0).hasHexString("00");
        initialize(Raw.byteAssertion(), (byte) 1).hasHexString("01");
        initialize(Raw.byteAssertion(), (byte) 31).hasHexString("1f");
        initialize(Raw.byteAssertion(), (byte) 50).hasHexString("32");
        initialize(Raw.byteAssertion(), (byte) 100).hasHexString("64");
        initialize(Raw.byteAssertion(), (byte) 101).hasHexString("65");
        initialize(Raw.byteAssertion(), (byte) -1).hasHexString("ff");
        initialize(Raw.byteAssertion(), (byte) -127).hasHexString("81");
        initialize(Raw.byteAssertion(), (byte) 31).isNotNull().hasHexString("1f").isInstanceOf(Byte.class);

        try {
            Raw.byteAssertion().hasHexString("0");
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteAssertion(), null).hasHexString("0");
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").hasHexString("0");
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null).hasHexString(null);
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), null, "Message").hasHexString(null);
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).hasHexString(null);
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").hasHexString(null);
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11).hasHexString("11");
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<0b>");
        }
        try {
            initialize(Raw.byteAssertion(), (byte) 11, "Message").hasHexString("11");
            Assertions.fail(ByteAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<11> but was:<0b>");
        }
    }

}
