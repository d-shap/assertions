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
package ru.d_shap.assertions.asimp.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LongArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongArrayHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongArrayHexStringAssertionTest() {
        super();
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString().isEqualTo("00000000000000010000000000000002");
        initialize(Raw.longArrayAssertion(), new long[]{15, -3, 7}).toHexString().isEqualTo("000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString().isEqualTo("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).isNotNull().toHexString().isEqualTo("000000000000006300000000000000050000000000000000ffffffffffffffeb");

        try {
            Raw.longArrayAssertion().toHexString();
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toHexString();
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toHexString();
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString()).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString()).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString().isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000010000000000000002>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString().isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000010000000000000002>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(0, 2).isEqualTo("00000000000000010000000000000002");
        initialize(Raw.longArrayAssertion(), new long[]{15, -3, 7}).toHexString(0, 3).isEqualTo("000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 0).isEqualTo("");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 1).isEqualTo("0000000000000063");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 2).isEqualTo("00000000000000630000000000000005");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 3).isEqualTo("000000000000006300000000000000050000000000000000");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 4).isEqualTo("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(1, 1).isEqualTo("");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(1, 2).isEqualTo("0000000000000005");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(1, 3).isEqualTo("00000000000000050000000000000000");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(1, 4).isEqualTo("00000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(2, 2).isEqualTo("");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(2, 3).isEqualTo("0000000000000000");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(2, 4).isEqualTo("0000000000000000ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(3, 3).isEqualTo("");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(3, 4).isEqualTo("ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(4, 4).isEqualTo("");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).isNotNull().toHexString(4, 4).isEqualTo("");

        try {
            Raw.longArrayAssertion().toHexString(0, 0);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toHexString(0, 0);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toHexString(0, 0);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toHexString(-1, 0);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toHexString(-1, 0);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(-1, 0);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(-1, 0);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(-1, 3);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(-1, 3);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(0, 3);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(0, 3);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(3, 3);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(3, 3);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(1, 0);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(1, 0);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(0, 0)).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(0, 0)).isEqualTo("00000000000000000000000000000000");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2, 3, 4}).toHexString(1, 3).isEqualTo("00000000000000010000000000000002");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000010000000000000002> but was:<00000000000000020000000000000003>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2, 3, 4}, "Message").toHexString(1, 3).isEqualTo("00000000000000010000000000000002");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000010000000000000002> but was:<00000000000000020000000000000003>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(Matchers.is(Matchers.equalTo("00000000000000010000000000000002")));
        initialize(Raw.longArrayAssertion(), new long[]{15, -3, 7}).toHexString(Matchers.is(Matchers.equalTo("000000000000000ffffffffffffffffd0000000000000007")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000ffffffffffffffeb")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).isNotNull().toHexString(Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000ffffffffffffffeb"))).isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toHexString(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toHexString(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"00000000000000010000000000000002\"");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00000000000000000000000000000000\"\n     but: was \"00000000000000010000000000000002\"");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(0, 2, Matchers.is(Matchers.equalTo("00000000000000010000000000000002")));
        initialize(Raw.longArrayAssertion(), new long[]{15, -3, 7}).toHexString(0, 3, Matchers.is(Matchers.equalTo("000000000000000ffffffffffffffffd0000000000000007")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 1, Matchers.is(Matchers.equalTo("0000000000000063")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 2, Matchers.is(Matchers.equalTo("00000000000000630000000000000005")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 3, Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(0, 4, Matchers.is(Matchers.equalTo("000000000000006300000000000000050000000000000000ffffffffffffffeb")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(1, 2, Matchers.is(Matchers.equalTo("0000000000000005")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(1, 3, Matchers.is(Matchers.equalTo("00000000000000050000000000000000")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(1, 4, Matchers.is(Matchers.equalTo("00000000000000050000000000000000ffffffffffffffeb")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(2, 3, Matchers.is(Matchers.equalTo("0000000000000000")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(2, 4, Matchers.is(Matchers.equalTo("0000000000000000ffffffffffffffeb")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(3, 3, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(3, 4, Matchers.is(Matchers.equalTo("ffffffffffffffeb")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).toHexString(4, 4, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).isNotNull().toHexString(4, 4, Matchers.is(Matchers.equalTo(""))).isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().toHexString(0, 0, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toHexString(0, 0, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toHexString(0, 0, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).toHexString(-1, 0, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").toHexString(-1, 0, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(-1, 0, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(-1, 0, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(-1, 3, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(-1, 3, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(0, 3, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(0, 3, Matchers.equalTo("00000000000000000000000000000000"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(3, 3, Matchers.equalTo("00"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(3, 3, Matchers.equalTo("00"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(1, 0, Matchers.equalTo("00"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(1, 0, Matchers.equalTo("00"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(0, 3, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(0, 3, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).toHexString(0, 2, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").toHexString(0, 2, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2, 3, 4}).toHexString(1, 3, Matchers.equalTo("00000000000000010000000000000002"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"00000000000000010000000000000002\"\n     but: was \"00000000000000020000000000000003\"");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2, 3, 4}, "Message").toHexString(1, 3, Matchers.equalTo("00000000000000010000000000000002"));
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"00000000000000010000000000000002\"\n     but: was \"00000000000000020000000000000003\"");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString("00000000000000010000000000000002");
        initialize(Raw.longArrayAssertion(), new long[]{15, -3, 7}).hasHexString("000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString("000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).isNotNull().hasHexString("000000000000006300000000000000050000000000000000ffffffffffffffeb").isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().hasHexString("");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasHexString("");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasHexString("");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasHexString(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasHexString(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString("00000000000000000000000000000000");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000010000000000000002>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString("00000000000000000000000000000000");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000000000000000000000> but was:<00000000000000010000000000000002>");
        }
    }

    /**
     * {@link LongArrayAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(0, 2, "00000000000000010000000000000002");
        initialize(Raw.longArrayAssertion(), new long[]{15, -3, 7}).hasHexString(0, 3, "000000000000000ffffffffffffffffd0000000000000007");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(0, 0, "");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(0, 1, "0000000000000063");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(0, 2, "00000000000000630000000000000005");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(0, 3, "000000000000006300000000000000050000000000000000");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(0, 4, "000000000000006300000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(1, 1, "");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(1, 2, "0000000000000005");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(1, 3, "00000000000000050000000000000000");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(1, 4, "00000000000000050000000000000000ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(2, 2, "");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(2, 3, "0000000000000000");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(2, 4, "0000000000000000ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(3, 3, "");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(3, 4, "ffffffffffffffeb");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).hasHexString(4, 4, "");
        initialize(Raw.longArrayAssertion(), new long[]{99, 5, 0, -21}).isNotNull().hasHexString(4, 4, "").isInstanceOf(long[].class);

        try {
            Raw.longArrayAssertion().hasHexString(0, 0, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasHexString(0, 0, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasHexString(0, 0, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null).hasHexString(-1, 0, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), null, "Message").hasHexString(-1, 0, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(-1, 0, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(-1, 0, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(-1, 3, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(-1, 3, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(0, 3, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(0, 3, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(3, 3, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(3, 3, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(3, 3, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(3, 3, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(1, 0, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(1, 0, "");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(1, 0, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(1, 0, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(0, 3, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(0, 3, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}).hasHexString(0, 2, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2}, "Message").hasHexString(0, 2, null);
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2, 3, 4}).hasHexString(1, 3, "00000000000000010000000000000002");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000010000000000000002> but was:<00000000000000020000000000000003>");
        }
        try {
            initialize(Raw.longArrayAssertion(), new long[]{1, 2, 3, 4}, "Message").hasHexString(1, 3, "00000000000000010000000000000002");
            Assertions.fail(LongArrayAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000000000010000000000000002> but was:<00000000000000020000000000000003>");
        }
    }

}
