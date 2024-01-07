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

import java.nio.IntBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link IntBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntBufferHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntBufferHexStringAssertionTest() {
        super();
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString().isEqualTo("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString().isEqualTo("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toHexString().isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).toHexString().isEqualTo("00000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString().isEqualTo("0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toHexString().isEqualTo("0000000100000002");

        try {
            Raw.intBufferAssertion().toHexString();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString()).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString()).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString().isEqualTo("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString().isEqualTo("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).toHexString().isEqualTo("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString().isEqualTo("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 0).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 1).isEqualTo("00000001");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 2).isEqualTo("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 1).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 2).isEqualTo("00000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(0, 3).isEqualTo("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(2, 3).isEqualTo("00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toHexString(0, 4).isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1).isEqualTo("00000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2).isEqualTo("0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2).isEqualTo("00000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toHexString(0, 2).isEqualTo("0000000100000002");

        try {
            Raw.intBufferAssertion().toHexString(0, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(0, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(0, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(-1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(-1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(-1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(-1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(-1, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(-1, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(3, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(3, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 0)).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 0)).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000300000004>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000300000004>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(Matchers.is(Matchers.equalTo("0000000100000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(Matchers.is(Matchers.equalTo("0000000ffffffffd00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toHexString(Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).toHexString(Matchers.is(Matchers.equalTo("00000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(Matchers.is(Matchers.equalTo("0000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toHexString(Matchers.is(Matchers.equalTo("0000000100000002"))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"0000000400000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"0000000400000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).toHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"000000010000000200000003\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"000000010000000200000003\"");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 1, Matchers.is(Matchers.equalTo("00000001")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 2, Matchers.is(Matchers.equalTo("0000000100000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 2, Matchers.is(Matchers.equalTo("00000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(0, 3, Matchers.is(Matchers.equalTo("0000000ffffffffd00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toHexString(2, 3, Matchers.is(Matchers.equalTo("00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toHexString(0, 4, Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1, Matchers.is(Matchers.equalTo("00000005")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2, Matchers.is(Matchers.equalTo("0000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2, Matchers.is(Matchers.equalTo("00000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toHexString(0, 2, Matchers.is(Matchers.equalTo("0000000100000002"))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 3, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 3, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toHexString(0, 0, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toHexString(0, 0, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2, Matchers.equalTo("0000000000000000"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"0000000000000000\"\n     but: was \"00000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2, Matchers.equalTo("0000000000000000"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"0000000000000000\"\n     but: was \"00000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3, Matchers.equalTo("0000000000000000"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"0000000000000000\"\n     but: was \"0000000300000004\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3, Matchers.equalTo("0000000000000000"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"0000000000000000\"\n     but: was \"0000000300000004\"");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString().isEqualTo("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString().isEqualTo("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toRewindAndHexString().isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).toRewindAndHexString().isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString().isEqualTo("000000630000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toRewindAndHexString().isEqualTo("0000000100000002");

        try {
            Raw.intBufferAssertion().toRewindAndHexString();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString();
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString()).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString()).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString().isEqualTo("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000100000002000000030000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString().isEqualTo("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000100000002000000030000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString().isEqualTo("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString().isEqualTo("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 1).isEqualTo("00000001");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 2).isEqualTo("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 2).isEqualTo("00000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(0, 3).isEqualTo("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(2, 3).isEqualTo("00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toRewindAndHexString(0, 4).isEqualTo("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1).isEqualTo("00000063");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2).isEqualTo("0000006300000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3).isEqualTo("000000630000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2).isEqualTo("00000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3).isEqualTo("0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3).isEqualTo("00000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3).isEqualTo("");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toRewindAndHexString(0, 2).isEqualTo("0000000100000002");

        try {
            Raw.intBufferAssertion().toRewindAndHexString(0, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(0, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(0, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(-1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(-1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(-1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(-1, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(-1, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(3, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(3, 3);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(1, 0);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 0)).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 0)).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000002>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000002>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3).isEqualTo("0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(Matchers.is(Matchers.equalTo("0000000100000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(Matchers.is(Matchers.equalTo("0000000ffffffffd00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(Matchers.is(Matchers.equalTo("000000630000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toRewindAndHexString(Matchers.is(Matchers.equalTo("0000000100000002"))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"0000000100000002000000030000000400000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"0000000100000002000000030000000400000005\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"000000010000000200000003\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString(Matchers.equalTo("0000000300000004"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000300000004\"\n     but: was \"000000010000000200000003\"");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartMatcherTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("00000001")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("0000000100000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("00000002")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("0000000ffffffffd00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("00000007")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).toRewindAndHexString(0, 4, Matchers.is(Matchers.equalTo("000000630000000500000000ffffffeb")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("00000063")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("0000006300000005")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("000000630000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("00000005")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3, Matchers.is(Matchers.equalTo("0000000500000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("00000000")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("0000000100000002"))).isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 3, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 3, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).toRewindAndHexString(0, 0, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").toRewindAndHexString(0, 0, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2, Matchers.equalTo("0000000000000000"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"0000000000000000\"\n     but: was \"00000002\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2, Matchers.equalTo("0000000000000000"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"0000000000000000\"\n     but: was \"00000002\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3, Matchers.equalTo("0000000000000000"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"0000000000000000\"\n     but: was \"0000000200000003\"");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3, Matchers.equalTo("0000000000000000"));
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"0000000000000000\"\n     but: was \"0000000200000003\"");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasHexString("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).hasHexString("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).hasHexString("00000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString("0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().hasHexString("0000000100000002").isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasHexString("");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasHexString("");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasHexString("");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).hasHexString("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).hasHexString("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasHexString("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 0, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 1, "00000001");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 2, "0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(1, 1, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(1, 2, "00000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasHexString(0, 3, "0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasHexString(2, 3, "00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).hasHexString(0, 4, "000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 0, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 1, "00000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 2, "0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 1, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 2, "00000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().hasHexString(0, 2, "0000000100000002").isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasHexString(0, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasHexString(0, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasHexString(0, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasHexString(-1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasHexString(-1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(-1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(-1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(-1, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(-1, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(0, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(3, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(3, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 3, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(0, 3, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasHexString(0, 0, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasHexString(0, 0, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).hasHexString(1, 2, "0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString(1, 2, "0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).hasHexString(1, 3, "0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000300000004>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasHexString(1, 3, "0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000300000004>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString("0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasRewindAndHexString("0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).hasRewindAndHexString("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 2)).hasRewindAndHexString("000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString("000000630000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().hasRewindAndHexString("0000000100000002").isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasRewindAndHexString("");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndHexString("");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndHexString("");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000100000002000000030000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<0000000100000002000000030000000400000005>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3)).hasRewindAndHexString("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasRewindAndHexString("0000000300000004");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000300000004> but was:<000000010000000200000003>");
        }
    }

    /**
     * {@link IntBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringPartTest() {
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 0, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 1, "00000001");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 2, "0000000100000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(1, 1, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(1, 2, "00000002");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasRewindAndHexString(0, 3, "0000000ffffffffd00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{15, -3, 7})).hasRewindAndHexString(2, 3, "00000007");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21})).hasRewindAndHexString(0, 4, "000000630000000500000000ffffffeb");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 0, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 1, "00000063");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 2, "0000006300000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 3, "000000630000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 1, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 2, "00000005");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 3, "0000000500000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 2, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 3, "00000000");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(3, 3, "");
        initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).isNotNull().hasRewindAndHexString(0, 2, "0000000100000002").isInstanceOf(IntBuffer.class);

        try {
            Raw.intBufferAssertion().hasRewindAndHexString(0, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndHexString(0, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndHexString(0, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null).hasRewindAndHexString(-1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), null, "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(-1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(-1, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(-1, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(0, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(3, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(3, 3, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(1, 0, "");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 3, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(0, 3, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2})).hasRewindAndHexString(0, 0, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2}), "Message").hasRewindAndHexString(0, 0, null);
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString(1, 2, "0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000002>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString(1, 2, "0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<00000002>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4)).hasRewindAndHexString(1, 3, "0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000200000003>");
        }
        try {
            initialize(Raw.intBufferAssertion(), createIntBuffer(new int[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasRewindAndHexString(1, 3, "0000000000000000");
            Assertions.fail(IntBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000000> but was:<0000000200000003>");
        }
    }

}
