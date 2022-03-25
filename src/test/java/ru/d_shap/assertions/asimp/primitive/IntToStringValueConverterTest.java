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
 * Tests for {@link IntToStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntToStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntToStringValueConverterTest() {
        super();
    }

    /**
     * {@link IntToStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntToStringValueConverter().getValueClass()).isEqualTo(Integer.class);
    }

    /**
     * {@link IntToStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntToStringValueConverter().getTargetClass()).isEqualTo(String.class);
    }

    /**
     * {@link IntToStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new IntToStringValueConverter().convert(0)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(0), Raw.charSequenceAssertion()).isEqualTo("00000000");
        Assertions.assertThat(new IntToStringValueConverter().convert(0)).as(Raw.charSequenceAssertion()).isEqualTo("00000000");

        Assertions.assertThat(new IntToStringValueConverter().convert(1)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(1), Raw.charSequenceAssertion()).isEqualTo("00000001");
        Assertions.assertThat(new IntToStringValueConverter().convert(1)).as(Raw.charSequenceAssertion()).isEqualTo("00000001");

        Assertions.assertThat(new IntToStringValueConverter().convert(31)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(31), Raw.charSequenceAssertion()).isEqualTo("0000001f");
        Assertions.assertThat(new IntToStringValueConverter().convert(31)).as(Raw.charSequenceAssertion()).isEqualTo("0000001f");

        Assertions.assertThat(new IntToStringValueConverter().convert(479)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(479), Raw.charSequenceAssertion()).isEqualTo("000001df");
        Assertions.assertThat(new IntToStringValueConverter().convert(479)).as(Raw.charSequenceAssertion()).isEqualTo("000001df");

        Assertions.assertThat(new IntToStringValueConverter().convert(7311)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(7311), Raw.charSequenceAssertion()).isEqualTo("00001c8f");
        Assertions.assertThat(new IntToStringValueConverter().convert(7311)).as(Raw.charSequenceAssertion()).isEqualTo("00001c8f");

        Assertions.assertThat(new IntToStringValueConverter().convert(102351)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(102351), Raw.charSequenceAssertion()).isEqualTo("00018fcf");
        Assertions.assertThat(new IntToStringValueConverter().convert(102351)).as(Raw.charSequenceAssertion()).isEqualTo("00018fcf");

        Assertions.assertThat(new IntToStringValueConverter().convert(1300879)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(1300879), Raw.charSequenceAssertion()).isEqualTo("0013d98f");
        Assertions.assertThat(new IntToStringValueConverter().convert(1300879)).as(Raw.charSequenceAssertion()).isEqualTo("0013d98f");

        Assertions.assertThat(new IntToStringValueConverter().convert(26461823)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(26461823), Raw.charSequenceAssertion()).isEqualTo("0193c67f");
        Assertions.assertThat(new IntToStringValueConverter().convert(26461823)).as(Raw.charSequenceAssertion()).isEqualTo("0193c67f");

        Assertions.assertThat(new IntToStringValueConverter().convert(Integer.MAX_VALUE)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(Integer.MAX_VALUE), Raw.charSequenceAssertion()).isEqualTo("7fffffff");
        Assertions.assertThat(new IntToStringValueConverter().convert(Integer.MAX_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("7fffffff");

        Assertions.assertThat(new IntToStringValueConverter().convert((int) 4294967295L)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert((int) 4294967295L), Raw.charSequenceAssertion()).isEqualTo("ffffffff");
        Assertions.assertThat(new IntToStringValueConverter().convert((int) 4294967295L)).as(Raw.charSequenceAssertion()).isEqualTo("ffffffff");

        Assertions.assertThat(new IntToStringValueConverter().convert(-100)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(-100), Raw.charSequenceAssertion()).isEqualTo("ffffff9c");
        Assertions.assertThat(new IntToStringValueConverter().convert(-100)).as(Raw.charSequenceAssertion()).isEqualTo("ffffff9c");

        Assertions.assertThat(new IntToStringValueConverter().convert(Integer.MIN_VALUE)).isInstanceOf(String.class);
        Assertions.assertThat(new IntToStringValueConverter().convert(Integer.MIN_VALUE), Raw.charSequenceAssertion()).isEqualTo("80000000");
        Assertions.assertThat(new IntToStringValueConverter().convert(Integer.MIN_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("80000000");
    }

    /**
     * {@link IntToStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new IntToStringValueConverter().convert(null);
    }

    /**
     * {@link IntToStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new IntToStringValueConverter().convert(new Object());
    }

    /**
     * {@link IntToStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() {
        new IntToStringValueConverter().convert(0, new Object());
    }

}
