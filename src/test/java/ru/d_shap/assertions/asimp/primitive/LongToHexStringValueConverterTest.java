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
import ru.d_shap.assertions.asimp.HexString;

/**
 * Tests for {@link LongToHexStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongToHexStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongToHexStringValueConverterTest() {
        super();
    }

    /**
     * {@link LongToHexStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new LongToHexStringValueConverter().getValueClass()).isEqualTo(Long.class);
    }

    /**
     * {@link LongToHexStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new LongToHexStringValueConverter().getTargetClass()).isEqualTo(HexString.class);
    }

    /**
     * {@link LongToHexStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new LongToHexStringValueConverter().convert(0L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(0L), Raw.charSequenceAssertion()).isEqualTo("0000000000000000");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(0L)).as(Raw.charSequenceAssertion()).isEqualTo("0000000000000000");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(1L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(1L), Raw.charSequenceAssertion()).isEqualTo("0000000000000001");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(1L)).as(Raw.charSequenceAssertion()).isEqualTo("0000000000000001");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(31L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(31L), Raw.charSequenceAssertion()).isEqualTo("000000000000001f");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(31L)).as(Raw.charSequenceAssertion()).isEqualTo("000000000000001f");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(479L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(479L), Raw.charSequenceAssertion()).isEqualTo("00000000000001df");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(479L)).as(Raw.charSequenceAssertion()).isEqualTo("00000000000001df");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(7311L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(7311L), Raw.charSequenceAssertion()).isEqualTo("0000000000001c8f");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(7311L)).as(Raw.charSequenceAssertion()).isEqualTo("0000000000001c8f");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(102351L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(102351L), Raw.charSequenceAssertion()).isEqualTo("0000000000018fcf");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(102351L)).as(Raw.charSequenceAssertion()).isEqualTo("0000000000018fcf");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(1300879L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(1300879L), Raw.charSequenceAssertion()).isEqualTo("000000000013d98f");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(1300879L)).as(Raw.charSequenceAssertion()).isEqualTo("000000000013d98f");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(26461823L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(26461823L), Raw.charSequenceAssertion()).isEqualTo("000000000193c67f");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(26461823L)).as(Raw.charSequenceAssertion()).isEqualTo("000000000193c67f");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(5663606399L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(5663606399L), Raw.charSequenceAssertion()).isEqualTo("000000015193c67f");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(5663606399L)).as(Raw.charSequenceAssertion()).isEqualTo("000000015193c67f");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(1998528431743L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(1998528431743L), Raw.charSequenceAssertion()).isEqualTo("000001d15193c67f");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(1998528431743L)).as(Raw.charSequenceAssertion()).isEqualTo("000001d15193c67f");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(459395365586559L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(459395365586559L), Raw.charSequenceAssertion()).isEqualTo("0001a1d15193c67f");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(459395365586559L)).as(Raw.charSequenceAssertion()).isEqualTo("0001a1d15193c67f");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(78149847602153087L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(78149847602153087L), Raw.charSequenceAssertion()).isEqualTo("0115a4df5193c67f");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(78149847602153087L)).as(Raw.charSequenceAssertion()).isEqualTo("0115a4df5193c67f");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(Long.MAX_VALUE)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(Long.MAX_VALUE), Raw.charSequenceAssertion()).isEqualTo("7fffffffffffffff");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(Long.MAX_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("7fffffffffffffff");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(-1L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(-1L), Raw.charSequenceAssertion()).isEqualTo("ffffffffffffffff");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(-1L)).as(Raw.charSequenceAssertion()).isEqualTo("ffffffffffffffff");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(-100L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(-100L), Raw.charSequenceAssertion()).isEqualTo("ffffffffffffff9c");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(-100L)).as(Raw.charSequenceAssertion()).isEqualTo("ffffffffffffff9c");

        Assertions.assertThat(new LongToHexStringValueConverter().convert(Long.MIN_VALUE)).isInstanceOf(HexString.class);
        Assertions.assertThat(new LongToHexStringValueConverter().convert(Long.MIN_VALUE), Raw.charSequenceAssertion()).isEqualTo("8000000000000000");
        Assertions.assertThat(new LongToHexStringValueConverter().convert(Long.MIN_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("8000000000000000");
    }

    /**
     * {@link LongToHexStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new LongToHexStringValueConverter().convert(null);
    }

    /**
     * {@link LongToHexStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new LongToHexStringValueConverter().convert(new Object());
    }

    /**
     * {@link LongToHexStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new LongToHexStringValueConverter().convert(0L, new Object());
    }

}
