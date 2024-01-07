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

import java.nio.LongBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LongBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongBufferHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongBufferHexStringAssertionTest() {
        super();
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString().isEqualTo("00000000000000010000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toHexString().isEqualTo("000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).toHexString().isEqualTo("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 2)).toHexString().isEqualTo("0000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString().isEqualTo("00000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().toHexString().isEqualTo("00000000000000010000000000000002");

        try {
            Raw.longBufferAssertion().toHexString();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toHexString();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toHexString();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toHexString()).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toHexString()).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toHexString().isEqualTo("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<00000000000000040000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toHexString().isEqualTo("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<00000000000000040000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).toHexString().isEqualTo("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<000000000000000100000000000000020000000000000003>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), "Message").toHexString().isEqualTo("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<000000000000000100000000000000020000000000000003>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 0).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 1).isEqualTo("0000000000000001");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 2).isEqualTo("00000000000000010000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(1, 1).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(1, 2).isEqualTo("0000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toHexString(0, 3).isEqualTo("000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toHexString(2, 3).isEqualTo("0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).toHexString(0, 4).isEqualTo("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(0, 0).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(0, 1).isEqualTo("0000000000000005");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(0, 2).isEqualTo("00000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(1, 1).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(1, 2).isEqualTo("0000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(2, 2).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().toHexString(0, 2).isEqualTo("00000000000000010000000000000002");

        try {
            Raw.longBufferAssertion().toHexString(0, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toHexString(0, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toHexString(0, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toHexString(-1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toHexString(-1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(-1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(-1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(-1, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(-1, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(0, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(3, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(3, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 0)).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(0, 0)).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toHexString(1, 2).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<0000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toHexString(1, 2).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<0000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4)).toHexString(1, 3).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000030000000000000004>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4), "Message").toHexString(1, 3).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000030000000000000004>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(Matchers.is(Matchers.equalTo("00000000000000010000000000000002")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toHexString(Matchers.is(Matchers.equalTo("000000000000000ffffffffffffffffd0000000000000007")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).toHexString(Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000ffffffffffffffeb")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 2)).toHexString(Matchers.is(Matchers.equalTo("0000000000000000ffffffffffffffeb")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(Matchers.is(Matchers.equalTo("00000000000000050000000000000000")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().toHexString(Matchers.is(Matchers.equalTo("00000000000000010000000000000002"))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toHexString(Matchers.equalTo("00000000000000030000000000000004"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00000000000000030000000000000004\"\n     but: was \"00000000000000040000000000000005\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toHexString(Matchers.equalTo("00000000000000030000000000000004"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00000000000000030000000000000004\"\n     but: was \"00000000000000040000000000000005\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).toHexString(Matchers.equalTo("00000000000000030000000000000004"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00000000000000030000000000000004\"\n     but: was \"000000000000000100000000000000020000000000000003\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), "Message").toHexString(Matchers.equalTo("00000000000000030000000000000004"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00000000000000030000000000000004\"\n     but: was \"000000000000000100000000000000020000000000000003\"");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 1, Matchers.is(Matchers.equalTo("0000000000000001")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 2, Matchers.is(Matchers.equalTo("00000000000000010000000000000002")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(1, 2, Matchers.is(Matchers.equalTo("0000000000000002")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toHexString(0, 3, Matchers.is(Matchers.equalTo("000000000000000ffffffffffffffffd0000000000000007")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toHexString(2, 3, Matchers.is(Matchers.equalTo("0000000000000007")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).toHexString(0, 4, Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000ffffffffffffffeb")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(0, 1, Matchers.is(Matchers.equalTo("0000000000000005")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(0, 2, Matchers.is(Matchers.equalTo("00000000000000050000000000000000")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(1, 2, Matchers.is(Matchers.equalTo("0000000000000000")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().toHexString(0, 2, Matchers.is(Matchers.equalTo("00000000000000010000000000000002"))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 3, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(0, 3, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toHexString(0, 0, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toHexString(0, 0, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toHexString(1, 2, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"0000000000000005\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toHexString(1, 2, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"0000000000000005\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4)).toHexString(1, 3, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"00000000000000030000000000000004\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4), "Message").toHexString(1, 3, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"00000000000000030000000000000004\"");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString().isEqualTo("00000000000000010000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toRewindAndHexString().isEqualTo("000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).toRewindAndHexString().isEqualTo("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 2)).toRewindAndHexString().isEqualTo("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString().isEqualTo("000000000000006300000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().toRewindAndHexString().isEqualTo("00000000000000010000000000000002");

        try {
            Raw.longBufferAssertion().toRewindAndHexString();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndHexString();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndHexString();
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toRewindAndHexString()).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toRewindAndHexString()).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toRewindAndHexString().isEqualTo("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<00000000000000010000000000000002000000000000000300000000000000040000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toRewindAndHexString().isEqualTo("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<00000000000000010000000000000002000000000000000300000000000000040000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).toRewindAndHexString().isEqualTo("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<000000000000000100000000000000020000000000000003>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), "Message").toRewindAndHexString().isEqualTo("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<000000000000000100000000000000020000000000000003>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 1).isEqualTo("0000000000000001");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 2).isEqualTo("00000000000000010000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(1, 2).isEqualTo("0000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toRewindAndHexString(0, 3).isEqualTo("000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toRewindAndHexString(2, 3).isEqualTo("0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).toRewindAndHexString(0, 4).isEqualTo("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(0, 1).isEqualTo("0000000000000063");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(0, 2).isEqualTo("00000000000000630000000000000005");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(0, 3).isEqualTo("000000000000006300000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(1, 2).isEqualTo("0000000000000005");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(1, 3).isEqualTo("00000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(2, 3).isEqualTo("0000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(3, 3).isEqualTo("");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().toRewindAndHexString(0, 2).isEqualTo("00000000000000010000000000000002");

        try {
            Raw.longBufferAssertion().toRewindAndHexString(0, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndHexString(0, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndHexString(0, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndHexString(-1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(-1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(-1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(-1, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(-1, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(0, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(3, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(3, 3);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(1, 0);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 0)).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(0, 0)).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toRewindAndHexString(1, 2).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<0000000000000002>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toRewindAndHexString(1, 2).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<0000000000000002>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4)).toRewindAndHexString(1, 3).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000020000000000000003>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4), "Message").toRewindAndHexString(1, 3).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000020000000000000003>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(Matchers.is(Matchers.equalTo("00000000000000010000000000000002")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000000000000ffffffffffffffffd0000000000000007")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000ffffffffffffffeb")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 2)).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000ffffffffffffffeb")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().toRewindAndHexString(Matchers.is(Matchers.equalTo("00000000000000010000000000000002"))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toRewindAndHexString(Matchers.equalTo("00000000000000030000000000000004"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00000000000000030000000000000004\"\n     but: was \"00000000000000010000000000000002000000000000000300000000000000040000000000000005\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toRewindAndHexString(Matchers.equalTo("00000000000000030000000000000004"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00000000000000030000000000000004\"\n     but: was \"00000000000000010000000000000002000000000000000300000000000000040000000000000005\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).toRewindAndHexString(Matchers.equalTo("00000000000000030000000000000004"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00000000000000030000000000000004\"\n     but: was \"000000000000000100000000000000020000000000000003\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), "Message").toRewindAndHexString(Matchers.equalTo("00000000000000030000000000000004"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00000000000000030000000000000004\"\n     but: was \"000000000000000100000000000000020000000000000003\"");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartMatcherTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("0000000000000001")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("00000000000000010000000000000002")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("0000000000000002")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("000000000000000ffffffffffffffffd0000000000000007")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("0000000000000007")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).toRewindAndHexString(0, 4, Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000ffffffffffffffeb")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("0000000000000063")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("00000000000000630000000000000005")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("0000000000000005")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(1, 3, Matchers.is(Matchers.equalTo("00000000000000050000000000000000")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("0000000000000000")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).toRewindAndHexString(3, 3, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("00000000000000010000000000000002"))).isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 3, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(0, 3, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).toRewindAndHexString(0, 0, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").toRewindAndHexString(0, 0, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).toRewindAndHexString(1, 2, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"0000000000000002\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").toRewindAndHexString(1, 2, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"0000000000000002\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4)).toRewindAndHexString(1, 3, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"00000000000000020000000000000003\"");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4), "Message").toRewindAndHexString(1, 3, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"00000000000000020000000000000003\"");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString("00000000000000010000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).hasHexString("000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).hasHexString("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 2)).hasHexString("0000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasHexString("00000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().hasHexString("00000000000000010000000000000002").isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasHexString("");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasHexString("");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasHexString("");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).hasHexString("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<00000000000000040000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").hasHexString("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<00000000000000040000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).hasHexString("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<000000000000000100000000000000020000000000000003>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), "Message").hasHexString("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<000000000000000100000000000000020000000000000003>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(0, 0, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(0, 1, "0000000000000001");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(0, 2, "00000000000000010000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(1, 1, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(1, 2, "0000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(2, 2, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).hasHexString(0, 3, "000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).hasHexString(2, 2, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).hasHexString(2, 3, "0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).hasHexString(0, 4, "000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasHexString(0, 0, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasHexString(0, 1, "0000000000000005");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasHexString(0, 2, "00000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasHexString(1, 1, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasHexString(1, 2, "0000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasHexString(2, 2, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().hasHexString(0, 2, "00000000000000010000000000000002").isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasHexString(0, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasHexString(0, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasHexString(0, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasHexString(-1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasHexString(-1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(-1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasHexString(-1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(-1, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasHexString(-1, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(0, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasHexString(0, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(3, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasHexString(3, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasHexString(1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(0, 3, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasHexString(0, 3, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasHexString(0, 0, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasHexString(0, 0, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).hasHexString(1, 2, "00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<0000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").hasHexString(1, 2, "00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<0000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4)).hasHexString(1, 3, "00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000030000000000000004>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4), "Message").hasHexString(1, 3, "00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000030000000000000004>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString("00000000000000010000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).hasRewindAndHexString("000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).hasRewindAndHexString("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 2)).hasRewindAndHexString("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString("000000000000006300000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().hasRewindAndHexString("00000000000000010000000000000002").isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasRewindAndHexString("");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndHexString("");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndHexString("");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndHexString(null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).hasRewindAndHexString("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<00000000000000010000000000000002000000000000000300000000000000040000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").hasRewindAndHexString("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<00000000000000010000000000000002000000000000000300000000000000040000000000000005>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3)).hasRewindAndHexString("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<000000000000000100000000000000020000000000000003>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 0, 3), "Message").hasRewindAndHexString("00000000000000030000000000000004");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000030000000000000004> but was:<000000000000000100000000000000020000000000000003>");
        }
    }

    /**
     * {@link LongBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringPartTest() {
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(0, 0, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(0, 1, "0000000000000001");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(0, 2, "00000000000000010000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(1, 1, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(1, 2, "0000000000000002");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).hasRewindAndHexString(0, 3, "000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{15L, -3L, 7L})).hasRewindAndHexString(2, 3, "0000000000000007");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L})).hasRewindAndHexString(0, 4, "000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(0, 0, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(0, 1, "0000000000000063");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(0, 2, "00000000000000630000000000000005");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(0, 3, "000000000000006300000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(1, 1, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(1, 2, "0000000000000005");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(1, 3, "00000000000000050000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(2, 2, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(2, 3, "0000000000000000");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{99L, 5L, 0L, -21L}, 1, 3)).hasRewindAndHexString(3, 3, "");
        initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).isNotNull().hasRewindAndHexString(0, 2, "00000000000000010000000000000002").isInstanceOf(LongBuffer.class);

        try {
            Raw.longBufferAssertion().hasRewindAndHexString(0, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndHexString(0, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndHexString(0, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null).hasRewindAndHexString(-1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), null, "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(-1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(-1, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndHexString(-1, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(0, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndHexString(0, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(3, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndHexString(3, 3, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndHexString(1, 0, "");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(0, 3, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndHexString(0, 3, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L})).hasRewindAndHexString(0, 0, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L}), "Message").hasRewindAndHexString(0, 0, null);
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3)).hasRewindAndHexString(1, 2, "00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<0000000000000002>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 3), "Message").hasRewindAndHexString(1, 2, "00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<0000000000000002>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4)).hasRewindAndHexString(1, 3, "00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000020000000000000003>");
        }
        try {
            initialize(Raw.longBufferAssertion(), createLongBuffer(new long[]{1L, 2L, 3L, 4L, 5L}, 1, 4), "Message").hasRewindAndHexString(1, 3, "00000000000000000000000000000000");
            Assertions.fail(LongBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000020000000000000003>");
        }
    }

}
