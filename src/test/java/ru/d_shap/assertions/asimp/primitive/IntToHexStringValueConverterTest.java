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
 * Tests for {@link IntToHexStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntToHexStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntToHexStringValueConverterTest() {
        super();
    }

    /**
     * {@link IntToHexStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntToHexStringValueConverter().getValueClass()).isEqualTo(Integer.class);
    }

    /**
     * {@link IntToHexStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntToHexStringValueConverter().getTargetClass()).isEqualTo(HexString.class);
    }

    /**
     * {@link IntToHexStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new IntToHexStringValueConverter().convert(0)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(0), Raw.charSequenceAssertion()).isEqualTo("00000000");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(0)).as(Raw.charSequenceAssertion()).isEqualTo("00000000");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(1)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(1), Raw.charSequenceAssertion()).isEqualTo("00000001");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(1)).as(Raw.charSequenceAssertion()).isEqualTo("00000001");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(31)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(31), Raw.charSequenceAssertion()).isEqualTo("0000001f");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(31)).as(Raw.charSequenceAssertion()).isEqualTo("0000001f");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(479)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(479), Raw.charSequenceAssertion()).isEqualTo("000001df");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(479)).as(Raw.charSequenceAssertion()).isEqualTo("000001df");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(7311)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(7311), Raw.charSequenceAssertion()).isEqualTo("00001c8f");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(7311)).as(Raw.charSequenceAssertion()).isEqualTo("00001c8f");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(102351)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(102351), Raw.charSequenceAssertion()).isEqualTo("00018fcf");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(102351)).as(Raw.charSequenceAssertion()).isEqualTo("00018fcf");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(1300879)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(1300879), Raw.charSequenceAssertion()).isEqualTo("0013d98f");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(1300879)).as(Raw.charSequenceAssertion()).isEqualTo("0013d98f");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(26461823)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(26461823), Raw.charSequenceAssertion()).isEqualTo("0193c67f");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(26461823)).as(Raw.charSequenceAssertion()).isEqualTo("0193c67f");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(Integer.MAX_VALUE)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(Integer.MAX_VALUE), Raw.charSequenceAssertion()).isEqualTo("7fffffff");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(Integer.MAX_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("7fffffff");

        Assertions.assertThat(new IntToHexStringValueConverter().convert((int) 4294967295L)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert((int) 4294967295L), Raw.charSequenceAssertion()).isEqualTo("ffffffff");
        Assertions.assertThat(new IntToHexStringValueConverter().convert((int) 4294967295L)).as(Raw.charSequenceAssertion()).isEqualTo("ffffffff");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(-100)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(-100), Raw.charSequenceAssertion()).isEqualTo("ffffff9c");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(-100)).as(Raw.charSequenceAssertion()).isEqualTo("ffffff9c");

        Assertions.assertThat(new IntToHexStringValueConverter().convert(Integer.MIN_VALUE)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntToHexStringValueConverter().convert(Integer.MIN_VALUE), Raw.charSequenceAssertion()).isEqualTo("80000000");
        Assertions.assertThat(new IntToHexStringValueConverter().convert(Integer.MIN_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("80000000");
    }

    /**
     * {@link IntToHexStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new IntToHexStringValueConverter().convert(null);
    }

    /**
     * {@link IntToHexStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new IntToHexStringValueConverter().convert(new Object());
    }

    /**
     * {@link IntToHexStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount1FailTest() {
        new IntToHexStringValueConverter().convert(0, new Object());
    }

}
