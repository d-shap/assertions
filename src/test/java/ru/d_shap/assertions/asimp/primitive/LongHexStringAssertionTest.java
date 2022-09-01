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
 * Tests for {@link LongAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongHexStringAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongHexStringAssertionTest() {
        super();
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.longAssertion(), 0L).toHexString().isEqualTo("0000000000000000");
        initialize(Raw.longAssertion(), 1L).toHexString().isEqualTo("0000000000000001");
        initialize(Raw.longAssertion(), 31L).toHexString().isEqualTo("000000000000001f");
        initialize(Raw.longAssertion(), 50L).toHexString().isEqualTo("0000000000000032");
        initialize(Raw.longAssertion(), 100L).toHexString().isEqualTo("0000000000000064");
        initialize(Raw.longAssertion(), 479L).toHexString().isEqualTo("00000000000001df");
        initialize(Raw.longAssertion(), 7311L).toHexString().isEqualTo("0000000000001c8f");
        initialize(Raw.longAssertion(), 102351L).toHexString().isEqualTo("0000000000018fcf");
        initialize(Raw.longAssertion(), 1300879L).toHexString().isEqualTo("000000000013d98f");
        initialize(Raw.longAssertion(), 26461823L).toHexString().isEqualTo("000000000193c67f");
        initialize(Raw.longAssertion(), 5663606399L).toHexString().isEqualTo("000000015193c67f");
        initialize(Raw.longAssertion(), 1998528431743L).toHexString().isEqualTo("000001d15193c67f");
        initialize(Raw.longAssertion(), 459395365586559L).toHexString().isEqualTo("0001a1d15193c67f");
        initialize(Raw.longAssertion(), 78149847602153087L).toHexString().isEqualTo("0115a4df5193c67f");
        initialize(Raw.longAssertion(), Long.MAX_VALUE).toHexString().isEqualTo("7fffffffffffffff");
        initialize(Raw.longAssertion(), -1L).toHexString().isEqualTo("ffffffffffffffff");
        initialize(Raw.longAssertion(), Long.MIN_VALUE).toHexString().isEqualTo("8000000000000000");
        initialize(Raw.longAssertion(), 31L).isNotNull().toHexString().isEqualTo("000000000000001f");

        try {
            Raw.longAssertion().toHexString();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).toHexString();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").toHexString();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longAssertion(), 11L).toHexString()).isEqualTo("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.longAssertion(), 11L, "Message").toHexString()).isEqualTo("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).toHexString().isEqualTo("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000011> but was:<000000000000000b>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").toHexString().isEqualTo("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000011> but was:<000000000000000b>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.longAssertion(), 0L).toHexString(Matchers.is(Matchers.equalTo("0000000000000000")));
        initialize(Raw.longAssertion(), 1L).toHexString(Matchers.is(Matchers.equalTo("0000000000000001")));
        initialize(Raw.longAssertion(), 31L).toHexString(Matchers.is(Matchers.equalTo("000000000000001f")));
        initialize(Raw.longAssertion(), 50L).toHexString(Matchers.is(Matchers.equalTo("0000000000000032")));
        initialize(Raw.longAssertion(), 100L).toHexString(Matchers.is(Matchers.equalTo("0000000000000064")));
        initialize(Raw.longAssertion(), 479L).toHexString(Matchers.is(Matchers.equalTo("00000000000001df")));
        initialize(Raw.longAssertion(), 7311L).toHexString(Matchers.is(Matchers.equalTo("0000000000001c8f")));
        initialize(Raw.longAssertion(), 102351L).toHexString(Matchers.is(Matchers.equalTo("0000000000018fcf")));
        initialize(Raw.longAssertion(), 1300879L).toHexString(Matchers.is(Matchers.equalTo("000000000013d98f")));
        initialize(Raw.longAssertion(), 26461823L).toHexString(Matchers.is(Matchers.equalTo("000000000193c67f")));
        initialize(Raw.longAssertion(), 5663606399L).toHexString(Matchers.is(Matchers.equalTo("000000015193c67f")));
        initialize(Raw.longAssertion(), 1998528431743L).toHexString(Matchers.is(Matchers.equalTo("000001d15193c67f")));
        initialize(Raw.longAssertion(), 459395365586559L).toHexString(Matchers.is(Matchers.equalTo("0001a1d15193c67f")));
        initialize(Raw.longAssertion(), 78149847602153087L).toHexString(Matchers.is(Matchers.equalTo("0115a4df5193c67f")));
        initialize(Raw.longAssertion(), Long.MAX_VALUE).toHexString(Matchers.is(Matchers.equalTo("7fffffffffffffff")));
        initialize(Raw.longAssertion(), -1L).toHexString(Matchers.is(Matchers.equalTo("ffffffffffffffff")));
        initialize(Raw.longAssertion(), Long.MIN_VALUE).toHexString(Matchers.is(Matchers.equalTo("8000000000000000")));
        initialize(Raw.longAssertion(), 31L).isNotNull().toHexString(Matchers.is(Matchers.equalTo("000000000000001f"))).isInstanceOf(Long.class);

        try {
            Raw.longAssertion().toHexString(Matchers.equalTo("0"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).toHexString(Matchers.equalTo("0"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").toHexString(Matchers.equalTo("0"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).toHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").toHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 1L).toHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.longAssertion(), 1L, "Message").toHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).toHexString(Matchers.equalTo("0000000000000011"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000000000000011\"\n     but: was \"000000000000000b\"");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").toHexString(Matchers.equalTo("0000000000000011"));
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000000000000011\"\n     but: was \"000000000000000b\"");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.longAssertion(), 0L).hasHexString("0000000000000000");
        initialize(Raw.longAssertion(), 1L).hasHexString("0000000000000001");
        initialize(Raw.longAssertion(), 31L).hasHexString("000000000000001f");
        initialize(Raw.longAssertion(), 50L).hasHexString("0000000000000032");
        initialize(Raw.longAssertion(), 100L).hasHexString("0000000000000064");
        initialize(Raw.longAssertion(), 479L).hasHexString("00000000000001df");
        initialize(Raw.longAssertion(), 7311L).hasHexString("0000000000001c8f");
        initialize(Raw.longAssertion(), 102351L).hasHexString("0000000000018fcf");
        initialize(Raw.longAssertion(), 1300879L).hasHexString("000000000013d98f");
        initialize(Raw.longAssertion(), 26461823L).hasHexString("000000000193c67f");
        initialize(Raw.longAssertion(), 5663606399L).hasHexString("000000015193c67f");
        initialize(Raw.longAssertion(), 1998528431743L).hasHexString("000001d15193c67f");
        initialize(Raw.longAssertion(), 459395365586559L).hasHexString("0001a1d15193c67f");
        initialize(Raw.longAssertion(), 78149847602153087L).hasHexString("0115a4df5193c67f");
        initialize(Raw.longAssertion(), Long.MAX_VALUE).hasHexString("7fffffffffffffff");
        initialize(Raw.longAssertion(), -1L).hasHexString("ffffffffffffffff");
        initialize(Raw.longAssertion(), Long.MIN_VALUE).hasHexString("8000000000000000");
        initialize(Raw.longAssertion(), 31L).isNotNull().hasHexString("000000000000001f").isInstanceOf(Long.class);

        try {
            Raw.longAssertion().hasHexString("0");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).hasHexString("0");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").hasHexString("0");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null).hasHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").hasHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).hasHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").hasHexString(null);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).hasHexString("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000011> but was:<000000000000000b>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").hasHexString("0000000000000011");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000000000000011> but was:<000000000000000b>");
        }
    }

}
