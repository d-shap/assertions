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

import java.nio.ShortBuffer;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ShortBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortBufferHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortBufferHexStringAssertionTest() {
        super();
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString().isEqualTo("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString().isEqualTo("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toHexString().isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).toHexString().isEqualTo("0000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString().isEqualTo("00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toHexString().isEqualTo("00010002");

        try {
            Raw.shortBufferAssertion().toHexString();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString()).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString()).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString().isEqualTo("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString().isEqualTo("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).toHexString().isEqualTo("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString().isEqualTo("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 0).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 1).isEqualTo("0001");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 2).isEqualTo("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 1).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 2).isEqualTo("0002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(0, 3).isEqualTo("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(2, 3).isEqualTo("0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toHexString(0, 4).isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1).isEqualTo("0005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2).isEqualTo("00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2).isEqualTo("0000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toHexString(0, 2).isEqualTo("00010002");

        try {
            Raw.shortBufferAssertion().toHexString(0, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(0, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(0, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(-1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(-1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(-1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(-1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(-1, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(-1, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(3, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(3, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00030004>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00030004>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toHexString(Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).toHexString(Matchers.is(Matchers.equalTo("0000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(Matchers.is(Matchers.equalTo("00050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toHexString(Matchers.is(Matchers.equalTo("00010002"))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString(Matchers.equalTo("00030004"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"00040005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(Matchers.equalTo("00030004"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"00040005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).toHexString(Matchers.equalTo("00030004"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"000100020003\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").toHexString(Matchers.equalTo("00030004"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"000100020003\"");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 1, Matchers.is(Matchers.equalTo("0001")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 2, Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 2, Matchers.is(Matchers.equalTo("0002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(0, 3, Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toHexString(2, 3, Matchers.is(Matchers.equalTo("0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toHexString(0, 4, Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 1, Matchers.is(Matchers.equalTo("0005")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(0, 2, Matchers.is(Matchers.equalTo("00050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(1, 2, Matchers.is(Matchers.equalTo("0000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toHexString(0, 2, Matchers.is(Matchers.equalTo("00010002"))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 3, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 3, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toHexString(0, 0, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toHexString(0, 0, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toHexString(1, 2, Matchers.equalTo("00000000"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"00000000\"\n     but: was \"0005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toHexString(1, 2, Matchers.equalTo("00000000"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"00000000\"\n     but: was \"0005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).toHexString(1, 3, Matchers.equalTo("00000000"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"00000000\"\n     but: was \"00030004\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").toHexString(1, 3, Matchers.equalTo("00000000"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"00000000\"\n     but: was \"00030004\"");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString().isEqualTo("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString().isEqualTo("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toRewindAndHexString().isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).toRewindAndHexString().isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString().isEqualTo("006300050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toRewindAndHexString().isEqualTo("00010002");

        try {
            Raw.shortBufferAssertion().toRewindAndHexString();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString();
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString()).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString()).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString().isEqualTo("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00010002000300040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString().isEqualTo("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00010002000300040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString().isEqualTo("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString().isEqualTo("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 1).isEqualTo("0001");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 2).isEqualTo("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 2).isEqualTo("0002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(0, 3).isEqualTo("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(2, 3).isEqualTo("0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toRewindAndHexString(0, 4).isEqualTo("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1).isEqualTo("0063");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2).isEqualTo("00630005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3).isEqualTo("006300050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2).isEqualTo("0005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3).isEqualTo("00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3).isEqualTo("0000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3).isEqualTo("");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toRewindAndHexString(0, 2).isEqualTo("00010002");

        try {
            Raw.shortBufferAssertion().toRewindAndHexString(0, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(0, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(0, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(-1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(-1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(-1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(-1, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(-1, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(3, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(3, 3);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(1, 0);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 0)).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0002>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0002>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3).isEqualTo("00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toRewindAndHexString(Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).toRewindAndHexString(Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(Matchers.is(Matchers.equalTo("006300050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toRewindAndHexString(Matchers.is(Matchers.equalTo("00010002"))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(Matchers.equalTo("00030004"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"00010002000300040005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(Matchers.equalTo("00030004"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"00010002000300040005\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).toRewindAndHexString(Matchers.equalTo("00030004"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"000100020003\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").toRewindAndHexString(Matchers.equalTo("00030004"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"00030004\"\n     but: was \"000100020003\"");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void toRewindAndHexStringPartMatcherTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("0001")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("00010002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("0002")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("000ffffd0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("0007")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).toRewindAndHexString(0, 4, Matchers.is(Matchers.equalTo("006300050000ffeb")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 1, Matchers.is(Matchers.equalTo("0063")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("00630005")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(0, 3, Matchers.is(Matchers.equalTo("006300050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 2, Matchers.is(Matchers.equalTo("0005")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(1, 3, Matchers.is(Matchers.equalTo("00050000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(2, 3, Matchers.is(Matchers.equalTo("0000")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).toRewindAndHexString(3, 3, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().toRewindAndHexString(0, 2, Matchers.is(Matchers.equalTo("00010002"))).isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(0, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(-1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(-1, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(3, 3, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(1, 0, Matchers.equalTo(""));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 3, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 3, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).toRewindAndHexString(0, 0, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").toRewindAndHexString(0, 0, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).toRewindAndHexString(1, 2, Matchers.equalTo("00000000"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\nExpected: \"00000000\"\n     but: was \"0002\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").toRewindAndHexString(1, 2, Matchers.equalTo("00000000"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\nExpected: \"00000000\"\n     but: was \"0002\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).toRewindAndHexString(1, 3, Matchers.equalTo("00000000"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"00000000\"\n     but: was \"00020003\"");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").toRewindAndHexString(1, 3, Matchers.equalTo("00000000"));
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"00000000\"\n     but: was \"00020003\"");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasHexString("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).hasHexString("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).hasHexString("0000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString("00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().hasHexString("00010002").isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasHexString("");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasHexString("");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasHexString("");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).hasHexString("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).hasHexString("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasHexString("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 0, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 1, "0001");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 2, "00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(1, 1, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(1, 2, "0002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasHexString(0, 3, "000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasHexString(2, 3, "0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).hasHexString(0, 4, "006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 0, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 1, "0005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(0, 2, "00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 1, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(1, 2, "0000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().hasHexString(0, 2, "00010002").isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasHexString(0, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasHexString(0, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasHexString(0, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasHexString(-1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasHexString(-1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(-1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(-1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(-1, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(-1, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(0, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(3, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(3, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 3, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(0, 3, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasHexString(0, 0, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasHexString(0, 0, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).hasHexString(1, 2, "00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").hasHexString(1, 2, "00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).hasHexString(1, 3, "00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00030004>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasHexString(1, 3, "00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00030004>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString("00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasRewindAndHexString("000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).hasRewindAndHexString("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 2)).hasRewindAndHexString("006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString("006300050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().hasRewindAndHexString("00010002").isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasRewindAndHexString("");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndHexString("");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndHexString("");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00010002000300040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<00010002000300040005>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3)).hasRewindAndHexString("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 0, 3), "Message").hasRewindAndHexString("00030004");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<00030004> but was:<000100020003>");
        }
    }

    /**
     * {@link ShortBufferAssertion} class test.
     */
    @Test
    public void hasRewindAndHexStringPartTest() {
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 0, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 1, "0001");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 2, "00010002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(1, 1, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(1, 2, "0002");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasRewindAndHexString(0, 3, "000ffffd0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasRewindAndHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{15, -3, 7})).hasRewindAndHexString(2, 3, "0007");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21})).hasRewindAndHexString(0, 4, "006300050000ffeb");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 0, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 1, "0063");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 2, "00630005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(0, 3, "006300050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 1, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 2, "0005");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(1, 3, "00050000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 2, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(2, 3, "0000");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{99, 5, 0, -21}, 1, 3)).hasRewindAndHexString(3, 3, "");
        initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).isNotNull().hasRewindAndHexString(0, 2, "00010002").isInstanceOf(ShortBuffer.class);

        try {
            Raw.shortBufferAssertion().hasRewindAndHexString(0, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndHexString(0, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndHexString(0, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null).hasRewindAndHexString(-1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), null, "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(-1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(-1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(-1, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(-1, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(0, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(3, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(3, 3, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(1, 0, "");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 3, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(0, 3, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2})).hasRewindAndHexString(0, 0, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2}), "Message").hasRewindAndHexString(0, 0, null);
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3)).hasRewindAndHexString(1, 2, "00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0002>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 3), "Message").hasRewindAndHexString(1, 2, "00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:2.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<0002>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4)).hasRewindAndHexString(1, 3, "00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00020003>");
        }
        try {
            initialize(Raw.shortBufferAssertion(), createShortBuffer(new short[]{1, 2, 3, 4, 5}, 1, 4), "Message").hasRewindAndHexString(1, 3, "00000000");
            Assertions.fail(ShortBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<00000000> but was:<00020003>");
        }
    }

}
