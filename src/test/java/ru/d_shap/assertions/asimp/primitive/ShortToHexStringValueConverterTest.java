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
 * Tests for {@link ShortToHexStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortToHexStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortToHexStringValueConverterTest() {
        super();
    }

    /**
     * {@link ShortToHexStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ShortToHexStringValueConverter().getValueClass()).isEqualTo(Short.class);
    }

    /**
     * {@link ShortToHexStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ShortToHexStringValueConverter().getTargetClass()).isEqualTo(HexString.class);
    }

    /**
     * {@link ShortToHexStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 0)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 0), Raw.charSequenceAssertion()).isEqualTo("0000");
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 0)).as(Raw.charSequenceAssertion()).isEqualTo("0000");

        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 1)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 1), Raw.charSequenceAssertion()).isEqualTo("0001");
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 1)).as(Raw.charSequenceAssertion()).isEqualTo("0001");

        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 31)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 31), Raw.charSequenceAssertion()).isEqualTo("001f");
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 31)).as(Raw.charSequenceAssertion()).isEqualTo("001f");

        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 479)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 479), Raw.charSequenceAssertion()).isEqualTo("01df");
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 479)).as(Raw.charSequenceAssertion()).isEqualTo("01df");

        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 7311)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 7311), Raw.charSequenceAssertion()).isEqualTo("1c8f");
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 7311)).as(Raw.charSequenceAssertion()).isEqualTo("1c8f");

        Assertions.assertThat(new ShortToHexStringValueConverter().convert(Short.MAX_VALUE)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ShortToHexStringValueConverter().convert(Short.MAX_VALUE), Raw.charSequenceAssertion()).isEqualTo("7fff");
        Assertions.assertThat(new ShortToHexStringValueConverter().convert(Short.MAX_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("7fff");

        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 65535)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 65535), Raw.charSequenceAssertion()).isEqualTo("ffff");
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) 65535)).as(Raw.charSequenceAssertion()).isEqualTo("ffff");

        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) -100)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) -100), Raw.charSequenceAssertion()).isEqualTo("ff9c");
        Assertions.assertThat(new ShortToHexStringValueConverter().convert((short) -100)).as(Raw.charSequenceAssertion()).isEqualTo("ff9c");

        Assertions.assertThat(new ShortToHexStringValueConverter().convert(Short.MIN_VALUE)).isInstanceOf(HexString.class);
        Assertions.assertThat(new ShortToHexStringValueConverter().convert(Short.MIN_VALUE), Raw.charSequenceAssertion()).isEqualTo("8000");
        Assertions.assertThat(new ShortToHexStringValueConverter().convert(Short.MIN_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("8000");
    }

    /**
     * {@link ShortToHexStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ShortToHexStringValueConverter().convert(null);
    }

    /**
     * {@link ShortToHexStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new ShortToHexStringValueConverter().convert(new Object());
    }

    /**
     * {@link ShortToHexStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() {
        new ShortToHexStringValueConverter().convert((short) 0, new Object());
    }

}
