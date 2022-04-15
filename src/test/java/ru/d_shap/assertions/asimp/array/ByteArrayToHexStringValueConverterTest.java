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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.HexString;

/**
 * Tests for {@link ByteArrayToHexStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteArrayToHexStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteArrayToHexStringValueConverterTest() {
        super();
    }

    /**
     * {@link ByteArrayToHexStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().getValueClass()).isEqualTo(byte[].class);
    }

    /**
     * {@link ByteArrayToHexStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().getTargetClass()).isEqualTo(HexString.class);
    }

    /**
     * {@link ByteArrayToHexStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{}, 0, 0)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{}, 0, 0), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{}, 0, 0)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 0, 0)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 0, 0), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 0, 0)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 0, 1)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 0, 1), Raw.charSequenceAssertion()).isEqualTo("01");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 0, 1)).as(Raw.charSequenceAssertion()).isEqualTo("01");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 1, 2)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 1, 2), Raw.charSequenceAssertion()).isEqualTo("02");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 1, 2)).as(Raw.charSequenceAssertion()).isEqualTo("02");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 0, 2)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 0, 2), Raw.charSequenceAssertion()).isEqualTo("0102");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, 0, 2)).as(Raw.charSequenceAssertion()).isEqualTo("0102");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, -1, 3)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, -1, 3), Raw.charSequenceAssertion()).isEqualTo("0102");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{1, 2}, -1, 3)).as(Raw.charSequenceAssertion()).isEqualTo("0102");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, -2, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, -2, 4), Raw.charSequenceAssertion()).isEqualTo("6378fd0f");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, -2, 4)).as(Raw.charSequenceAssertion()).isEqualTo("6378fd0f");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 0, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 0, 4), Raw.charSequenceAssertion()).isEqualTo("6378fd0f");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 0, 4)).as(Raw.charSequenceAssertion()).isEqualTo("6378fd0f");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 3, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 3, 4), Raw.charSequenceAssertion()).isEqualTo("0f");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 3, 4)).as(Raw.charSequenceAssertion()).isEqualTo("0f");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 4, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 4, 4), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 4, 4)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 5, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 5, 4), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 5, 4)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 1, 3)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 1, 3), Raw.charSequenceAssertion()).isEqualTo("78fd");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 1, 3)).as(Raw.charSequenceAssertion()).isEqualTo("78fd");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 2, 2)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 2, 2), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 2, 2)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 3, 1)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 3, 1), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 3, 1)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, -2, 15)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, -2, 15), Raw.charSequenceAssertion()).isEqualTo("6378fd0f");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, -2, 15)).as(Raw.charSequenceAssertion()).isEqualTo("6378fd0f");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 4, 15)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 4, 15), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, 4, 15)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, -2, -1)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, -2, -1), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new ByteArrayToHexStringValueConverter().convert(new byte[]{99, 120, -3, 15}, -2, -1)).as(Raw.charSequenceAssertion()).isEqualTo("");
    }

    /**
     * {@link ByteArrayToHexStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ByteArrayToHexStringValueConverter().convert(null);
    }

    /**
     * {@link ByteArrayToHexStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new ByteArrayToHexStringValueConverter().convert(new Object());
    }

    /**
     * {@link ByteArrayToHexStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new ByteArrayToHexStringValueConverter().convert(new byte[]{});
    }

    /**
     * {@link ByteArrayToHexStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount3FailTest() {
        new ByteArrayToHexStringValueConverter().convert(new byte[]{}, new Object(), new Object(), new Object());
    }

}
