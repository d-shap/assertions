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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LongToStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongToStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongToStringValueConverterTest() {
        super();
    }

    /**
     * {@link LongToStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new LongToStringValueConverter().getValueClass()).isEqualTo(Long.class);
    }

    /**
     * {@link LongToStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new LongToStringValueConverter().getTargetClass()).isEqualTo(String.class);
    }

    /**
     * {@link LongToStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new LongToStringValueConverter().convert(0L, (Boolean) null)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(0L, (Boolean) null), Raw.charSequenceAssertion()).isEqualTo("0");
        Assertions.assertThat(new LongToStringValueConverter().convert(0L, (Boolean) null)).as(Raw.charSequenceAssertion()).isEqualTo("0");

        Assertions.assertThat(new LongToStringValueConverter().convert(100L, (Boolean) null)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(100L, (Boolean) null), Raw.charSequenceAssertion()).isEqualTo("100");
        Assertions.assertThat(new LongToStringValueConverter().convert(100L, (Boolean) null)).as(Raw.charSequenceAssertion()).isEqualTo("100");

        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MAX_VALUE, (Boolean) null)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MAX_VALUE, (Boolean) null), Raw.charSequenceAssertion()).isEqualTo("9223372036854775807");
        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MAX_VALUE, (Boolean) null)).as(Raw.charSequenceAssertion()).isEqualTo("9223372036854775807");

        Assertions.assertThat(new LongToStringValueConverter().convert(0L, false)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(0L, false), Raw.charSequenceAssertion()).isEqualTo("0");
        Assertions.assertThat(new LongToStringValueConverter().convert(0L, false)).as(Raw.charSequenceAssertion()).isEqualTo("0");

        Assertions.assertThat(new LongToStringValueConverter().convert(100L, false)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(100L, false), Raw.charSequenceAssertion()).isEqualTo("100");
        Assertions.assertThat(new LongToStringValueConverter().convert(100L, false)).as(Raw.charSequenceAssertion()).isEqualTo("100");

        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MAX_VALUE, false)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MAX_VALUE, false), Raw.charSequenceAssertion()).isEqualTo("9223372036854775807");
        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MAX_VALUE, false)).as(Raw.charSequenceAssertion()).isEqualTo("9223372036854775807");

        Assertions.assertThat(new LongToStringValueConverter().convert(0L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(0L, true), Raw.charSequenceAssertion()).isEqualTo("0000000000000000");
        Assertions.assertThat(new LongToStringValueConverter().convert(0L, true)).as(Raw.charSequenceAssertion()).isEqualTo("0000000000000000");

        Assertions.assertThat(new LongToStringValueConverter().convert(1L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(1L, true), Raw.charSequenceAssertion()).isEqualTo("0000000000000001");
        Assertions.assertThat(new LongToStringValueConverter().convert(1L, true)).as(Raw.charSequenceAssertion()).isEqualTo("0000000000000001");

        Assertions.assertThat(new LongToStringValueConverter().convert(31L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(31L, true), Raw.charSequenceAssertion()).isEqualTo("000000000000001f");
        Assertions.assertThat(new LongToStringValueConverter().convert(31L, true)).as(Raw.charSequenceAssertion()).isEqualTo("000000000000001f");

        Assertions.assertThat(new LongToStringValueConverter().convert(479L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(479L, true), Raw.charSequenceAssertion()).isEqualTo("00000000000001df");
        Assertions.assertThat(new LongToStringValueConverter().convert(479L, true)).as(Raw.charSequenceAssertion()).isEqualTo("00000000000001df");

        Assertions.assertThat(new LongToStringValueConverter().convert(7311L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(7311L, true), Raw.charSequenceAssertion()).isEqualTo("0000000000001c8f");
        Assertions.assertThat(new LongToStringValueConverter().convert(7311L, true)).as(Raw.charSequenceAssertion()).isEqualTo("0000000000001c8f");

        Assertions.assertThat(new LongToStringValueConverter().convert(102351L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(102351L, true), Raw.charSequenceAssertion()).isEqualTo("0000000000018fcf");
        Assertions.assertThat(new LongToStringValueConverter().convert(102351L, true)).as(Raw.charSequenceAssertion()).isEqualTo("0000000000018fcf");

        Assertions.assertThat(new LongToStringValueConverter().convert(1300879L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(1300879L, true), Raw.charSequenceAssertion()).isEqualTo("000000000013d98f");
        Assertions.assertThat(new LongToStringValueConverter().convert(1300879L, true)).as(Raw.charSequenceAssertion()).isEqualTo("000000000013d98f");

        Assertions.assertThat(new LongToStringValueConverter().convert(26461823L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(26461823L, true), Raw.charSequenceAssertion()).isEqualTo("000000000193c67f");
        Assertions.assertThat(new LongToStringValueConverter().convert(26461823L, true)).as(Raw.charSequenceAssertion()).isEqualTo("000000000193c67f");

        Assertions.assertThat(new LongToStringValueConverter().convert(5663606399L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(5663606399L, true), Raw.charSequenceAssertion()).isEqualTo("000000015193c67f");
        Assertions.assertThat(new LongToStringValueConverter().convert(5663606399L, true)).as(Raw.charSequenceAssertion()).isEqualTo("000000015193c67f");

        Assertions.assertThat(new LongToStringValueConverter().convert(1998528431743L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(1998528431743L, true), Raw.charSequenceAssertion()).isEqualTo("000001d15193c67f");
        Assertions.assertThat(new LongToStringValueConverter().convert(1998528431743L, true)).as(Raw.charSequenceAssertion()).isEqualTo("000001d15193c67f");

        Assertions.assertThat(new LongToStringValueConverter().convert(459395365586559L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(459395365586559L, true), Raw.charSequenceAssertion()).isEqualTo("0001a1d15193c67f");
        Assertions.assertThat(new LongToStringValueConverter().convert(459395365586559L, true)).as(Raw.charSequenceAssertion()).isEqualTo("0001a1d15193c67f");

        Assertions.assertThat(new LongToStringValueConverter().convert(78149847602153087L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(78149847602153087L, true), Raw.charSequenceAssertion()).isEqualTo("0115a4df5193c67f");
        Assertions.assertThat(new LongToStringValueConverter().convert(78149847602153087L, true)).as(Raw.charSequenceAssertion()).isEqualTo("0115a4df5193c67f");

        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MAX_VALUE, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MAX_VALUE, true), Raw.charSequenceAssertion()).isEqualTo("7fffffffffffffff");
        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MAX_VALUE, true)).as(Raw.charSequenceAssertion()).isEqualTo("7fffffffffffffff");

        Assertions.assertThat(new LongToStringValueConverter().convert(-1L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(-1L, true), Raw.charSequenceAssertion()).isEqualTo("ffffffffffffffff");
        Assertions.assertThat(new LongToStringValueConverter().convert(-1L, true)).as(Raw.charSequenceAssertion()).isEqualTo("ffffffffffffffff");

        Assertions.assertThat(new LongToStringValueConverter().convert(-100L, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(-100L, true), Raw.charSequenceAssertion()).isEqualTo("ffffffffffffff9c");
        Assertions.assertThat(new LongToStringValueConverter().convert(-100L, true)).as(Raw.charSequenceAssertion()).isEqualTo("ffffffffffffff9c");

        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MIN_VALUE, true)).isInstanceOf(String.class);
        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MIN_VALUE, true), Raw.charSequenceAssertion()).isEqualTo("8000000000000000");
        Assertions.assertThat(new LongToStringValueConverter().convert(Long.MIN_VALUE, true)).as(Raw.charSequenceAssertion()).isEqualTo("8000000000000000");
    }

    /**
     * {@link LongToStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new LongToStringValueConverter().convert(null);
    }

    /**
     * {@link LongToStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new LongToStringValueConverter().convert(new Object());
    }

    /**
     * {@link LongToStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new LongToStringValueConverter().convert(0L);
    }

    /**
     * {@link LongToStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() {
        new LongToStringValueConverter().convert(0L, new Object(), new Object());
    }

}
