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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.ByteBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ByteBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteBufferHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteBufferHexStringAssertionTest() {
        super();
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString().isEqualTo("0102");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toHexString().isEqualTo("0ffd07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).toHexString().isEqualTo("630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 2)).toHexString().isEqualTo("00eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString().isEqualTo("0500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().toHexString().isEqualTo("0102");

        try {
            Raw.byteBufferAssertion().toHexString();
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toHexString();
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toHexString();
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toHexString()).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toHexString()).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toHexString().isEqualTo("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<0405>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toHexString().isEqualTo("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<0405>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).toHexString().isEqualTo("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<010203>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString().isEqualTo("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<010203>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 0).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 1).isEqualTo("01");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 2).isEqualTo("0102");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(1, 1).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(1, 2).isEqualTo("02");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toHexString(0, 3).isEqualTo("0ffd07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toHexString(2, 3).isEqualTo("07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).toHexString(0, 4).isEqualTo("630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1).isEqualTo("05");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2).isEqualTo("0500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2).isEqualTo("00");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().toHexString(0, 2).isEqualTo("0102");

        try {
            Raw.byteBufferAssertion().toHexString(0, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toHexString(0, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toHexString(0, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toHexString(-1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toHexString(-1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(-1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(-1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(-1, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(-1, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(0, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(3, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(3, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 0)).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(0, 0)).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<05>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<05>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0304>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0304>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(Matchers.is(Matchers.equalTo("0102")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toHexString(Matchers.is(Matchers.equalTo("0ffd07")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).toHexString(Matchers.is(Matchers.equalTo("630500eb")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 2)).toHexString(Matchers.is(Matchers.equalTo("00eb")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(Matchers.is(Matchers.equalTo("0500")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().toHexString(Matchers.is(Matchers.equalTo("0102"))).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toHexString(Matchers.equalTo("0304"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0304\"\n     but: was \"0405\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(Matchers.equalTo("0304"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0304\"\n     but: was \"0405\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).toHexString(Matchers.equalTo("0304"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0304\"\n     but: was \"010203\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString(Matchers.equalTo("0304"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0304\"\n     but: was \"010203\"");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 1, Matchers.is(Matchers.equalTo("01")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 2, Matchers.is(Matchers.equalTo("0102")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(1, 2, Matchers.is(Matchers.equalTo("02")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toHexString(0, 3, Matchers.is(Matchers.equalTo("0ffd07")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toHexString(2, 3, Matchers.is(Matchers.equalTo("07")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).toHexString(0, 4, Matchers.is(Matchers.equalTo("630500eb")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1, Matchers.is(Matchers.equalTo("05")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2, Matchers.is(Matchers.equalTo("0500")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2, Matchers.is(Matchers.equalTo("00")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().toHexString(0, 2, Matchers.is(Matchers.equalTo("0102"))).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 3, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(0, 3, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toHexString(0, 0, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toHexString(0, 0, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2, Matchers.equalTo("0000"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"0000\"\n     but: was \"05\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2, Matchers.equalTo("0000"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"0000\"\n     but: was \"05\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3, Matchers.equalTo("0000"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"0000\"\n     but: was \"0304\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3, Matchers.equalTo("0000"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"0000\"\n     but: was \"0304\"");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString().isEqualTo("0102");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toRewindAndHexString().isEqualTo("0ffd07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).toRewindAndHexString().isEqualTo("630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 2)).toRewindAndHexString().isEqualTo("630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString().isEqualTo("630500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().toRewindAndHexString().isEqualTo("0102");

        try {
            Raw.byteBufferAssertion().toRewindAndHexString();
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndHexString();
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndHexString();
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString()).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString()).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString().isEqualTo("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<0102030405>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString().isEqualTo("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<0102030405>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString().isEqualTo("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<010203>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString().isEqualTo("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<010203>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 1).isEqualTo("01");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 2).isEqualTo("0102");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(1, 2).isEqualTo("02");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toRewindAndHexString(0, 3).isEqualTo("0ffd07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toRewindAndHexString(2, 3).isEqualTo("07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).toRewindAndHexString(0, 4).isEqualTo("630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1).isEqualTo("63");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2).isEqualTo("6305");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3).isEqualTo("630500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2).isEqualTo("05");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3).isEqualTo("0500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3).isEqualTo("00");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3).isEqualTo("");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().toRewindAndHexString(0, 2).isEqualTo("0102");

        try {
            Raw.byteBufferAssertion().toRewindAndHexString(0, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndHexString(0, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndHexString(0, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndHexString(-1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(-1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(-1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(-1, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(-1, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(0, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(3, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(3, 3);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(1, 0);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 0)).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(0, 0)).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<02>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<02>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0203>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3).isEqualTo("0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0203>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(Matchers.is(Matchers.equalTo("0102")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toRewindAndHexString(Matchers.is(Matchers.equalTo("0ffd07")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).toRewindAndHexString(Matchers.is(Matchers.equalTo("630500eb")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 2)).toRewindAndHexString(Matchers.is(Matchers.equalTo("630500eb")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(Matchers.is(Matchers.equalTo("630500")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().toRewindAndHexString(Matchers.is(Matchers.equalTo("0102"))).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(Matchers.equalTo("0304"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0304\"\n     but: was \"0102030405\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(Matchers.equalTo("0304"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0304\"\n     but: was \"0102030405\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString(Matchers.equalTo("0304"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0304\"\n     but: was \"010203\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString(Matchers.equalTo("0304"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0304\"\n     but: was \"010203\"");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartMatcherTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("01")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("0102")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("02")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("0ffd07")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("07")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).toRewindAndHexString(0, 4, Matchers.is(Matchers.equalTo("630500eb")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("63")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("6305")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("630500")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("05")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3, Matchers.is(Matchers.equalTo("0500")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("00")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("0102"))).isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 3, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(0, 3, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).toRewindAndHexString(0, 0, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").toRewindAndHexString(0, 0, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2, Matchers.equalTo("0000"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"0000\"\n     but: was \"02\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2, Matchers.equalTo("0000"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"0000\"\n     but: was \"02\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3, Matchers.equalTo("0000"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"0000\"\n     but: was \"0203\"");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3, Matchers.equalTo("0000"));
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"0000\"\n     but: was \"0203\"");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString("0102");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).hasHexString("0ffd07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).hasHexString("630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 2)).hasHexString("00eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasHexString("0500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().hasHexString("0102").isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasHexString("");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasHexString("");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasHexString("");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).hasHexString("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<0405>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<0405>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).hasHexString("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<010203>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasHexString("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<010203>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(0, 0, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(0, 1, "01");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(0, 2, "0102");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(1, 1, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(1, 2, "02");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(2, 2, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).hasHexString(0, 3, "0ffd07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).hasHexString(2, 2, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).hasHexString(2, 3, "07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).hasHexString(0, 4, "630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 0, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 1, "05");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 2, "0500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 1, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 2, "00");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasHexString(2, 2, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().hasHexString(0, 2, "0102").isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasHexString(0, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasHexString(0, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasHexString(0, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasHexString(-1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasHexString(-1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(-1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasHexString(-1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(-1, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasHexString(-1, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(0, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasHexString(0, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(3, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasHexString(3, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasHexString(1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(0, 3, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasHexString(0, 3, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasHexString(0, 0, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasHexString(0, 0, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).hasHexString(1, 2, "0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<05>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString(1, 2, "0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<05>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4)).hasHexString(1, 3, "0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0304>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasHexString(1, 3, "0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0304>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString("0102");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).hasRewindAndHexString("0ffd07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).hasRewindAndHexString("630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 2)).hasRewindAndHexString("630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString("630500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().hasRewindAndHexString("0102").isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasRewindAndHexString("");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndHexString("");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndHexString("");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndHexString(null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<0102030405>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<0102030405>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3)).hasRewindAndHexString("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<010203>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasRewindAndHexString("0304");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0304> but was:<010203>");
        }
    }

    /**
     * {@link ByteBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringPartTest() {
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(0, 0, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(0, 1, "01");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(0, 2, "0102");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(1, 1, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(1, 2, "02");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).hasRewindAndHexString(0, 3, "0ffd07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{15, -3, 7})).hasRewindAndHexString(2, 3, "07");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21})).hasRewindAndHexString(0, 4, "630500eb");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 0, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 1, "63");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 2, "6305");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 3, "630500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 1, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 2, "05");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 3, "0500");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 2, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 3, "00");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(3, 3, "");
        initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).isNotNull().hasRewindAndHexString(0, 2, "0102").isInstanceOf(ByteBuffer.class);

        try {
            Raw.byteBufferAssertion().hasRewindAndHexString(0, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndHexString(0, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndHexString(0, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null).hasRewindAndHexString(-1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), null, "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(-1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(-1, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndHexString(-1, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(0, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndHexString(0, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(3, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndHexString(3, 3, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndHexString(1, 0, "");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(0, 3, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndHexString(0, 3, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2})).hasRewindAndHexString(0, 0, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2}), "Message").hasRewindAndHexString(0, 0, null);
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString(1, 2, "0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<02>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString(1, 2, "0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<02>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4)).hasRewindAndHexString(1, 3, "0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0203>");
        }
        try {
            initialize(Raw.byteBufferAssertion(), createByteBuffer(new byte[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasRewindAndHexString(1, 3, "0000");
            Assertions.fail(ByteBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0203>");
        }
    }

}
