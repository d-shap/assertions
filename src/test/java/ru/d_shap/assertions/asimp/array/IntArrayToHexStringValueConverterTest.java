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
 * Tests for {@link IntArrayToHexStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntArrayToHexStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntArrayToHexStringValueConverterTest() {
        super();
    }

    /**
     * {@link IntArrayToHexStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntArrayToHexStringValueConverter().getValueClass()).isEqualTo(int[].class);
    }

    /**
     * {@link IntArrayToHexStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntArrayToHexStringValueConverter().getTargetClass()).isEqualTo(HexString.class);
    }

    /**
     * {@link IntArrayToHexStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{}, 0, 0)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{}, 0, 0), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{}, 0, 0)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 0, 0)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 0, 0), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 0, 0)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 0, 1)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 0, 1), Raw.charSequenceAssertion()).isEqualTo("00000001");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 0, 1)).as(Raw.charSequenceAssertion()).isEqualTo("00000001");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 1, 2)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 1, 2), Raw.charSequenceAssertion()).isEqualTo("00000002");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 1, 2)).as(Raw.charSequenceAssertion()).isEqualTo("00000002");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 0, 2)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 0, 2), Raw.charSequenceAssertion()).isEqualTo("0000000100000002");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, 0, 2)).as(Raw.charSequenceAssertion()).isEqualTo("0000000100000002");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, -1, 3)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, -1, 3), Raw.charSequenceAssertion()).isEqualTo("0000000100000002");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{1, 2}, -1, 3)).as(Raw.charSequenceAssertion()).isEqualTo("0000000100000002");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, -2, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, -2, 4), Raw.charSequenceAssertion()).isEqualTo("0000006300000078fffffffd0000000f");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, -2, 4)).as(Raw.charSequenceAssertion()).isEqualTo("0000006300000078fffffffd0000000f");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 0, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 0, 4), Raw.charSequenceAssertion()).isEqualTo("0000006300000078fffffffd0000000f");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 0, 4)).as(Raw.charSequenceAssertion()).isEqualTo("0000006300000078fffffffd0000000f");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 3, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 3, 4), Raw.charSequenceAssertion()).isEqualTo("0000000f");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 3, 4)).as(Raw.charSequenceAssertion()).isEqualTo("0000000f");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 4, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 4, 4), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 4, 4)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 5, 4)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 5, 4), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 5, 4)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 1, 3)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 1, 3), Raw.charSequenceAssertion()).isEqualTo("00000078fffffffd");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 1, 3)).as(Raw.charSequenceAssertion()).isEqualTo("00000078fffffffd");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 2, 2)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 2, 2), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 2, 2)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 3, 1)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 3, 1), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 3, 1)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, -2, 15)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, -2, 15), Raw.charSequenceAssertion()).isEqualTo("0000006300000078fffffffd0000000f");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, -2, 15)).as(Raw.charSequenceAssertion()).isEqualTo("0000006300000078fffffffd0000000f");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 4, 15)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 4, 15), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, 4, 15)).as(Raw.charSequenceAssertion()).isEqualTo("");

        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, -2, -1)).isInstanceOf(HexString.class);
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, -2, -1), Raw.charSequenceAssertion()).isEqualTo("");
        Assertions.assertThat(new IntArrayToHexStringValueConverter().convert(new int[]{99, 120, -3, 15}, -2, -1)).as(Raw.charSequenceAssertion()).isEqualTo("");
    }

    /**
     * {@link IntArrayToHexStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new IntArrayToHexStringValueConverter().convert(null);
    }

    /**
     * {@link IntArrayToHexStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new IntArrayToHexStringValueConverter().convert(new Object());
    }

    /**
     * {@link IntArrayToHexStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new IntArrayToHexStringValueConverter().convert(new int[]{});
    }

    /**
     * {@link IntArrayToHexStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount3FailTest() {
        new IntArrayToHexStringValueConverter().convert(new int[]{}, new Object(), new Object(), new Object());
    }

    /**
     * {@link IntArrayToHexStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentType1FailTest() {
        new IntArrayToHexStringValueConverter().convert(new int[]{}, new Object(), new Object());
    }

    /**
     * {@link IntArrayToHexStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentType2FailTest() {
        new IntArrayToHexStringValueConverter().convert(new int[]{}, 5, new Object());
    }

}
