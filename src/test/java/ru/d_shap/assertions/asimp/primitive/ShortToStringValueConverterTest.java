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
 * Tests for {@link ShortToStringValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortToStringValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ShortToStringValueConverterTest() {
        super();
    }

    /**
     * {@link ShortToStringValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ShortToStringValueConverter().getValueClass()).isEqualTo(Short.class);
    }

    /**
     * {@link ShortToStringValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ShortToStringValueConverter().getTargetClass()).isEqualTo(String.class);
    }

    /**
     * {@link ShortToStringValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0), Raw.charSequenceAssertion()).isEqualTo("0000");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0)).as(Raw.charSequenceAssertion()).isEqualTo("0000");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 1)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 1), Raw.charSequenceAssertion()).isEqualTo("0001");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 1)).as(Raw.charSequenceAssertion()).isEqualTo("0001");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 31)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 31), Raw.charSequenceAssertion()).isEqualTo("001f");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 31)).as(Raw.charSequenceAssertion()).isEqualTo("001f");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 479)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 479), Raw.charSequenceAssertion()).isEqualTo("01df");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 479)).as(Raw.charSequenceAssertion()).isEqualTo("01df");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 7311)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 7311), Raw.charSequenceAssertion()).isEqualTo("1c8f");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 7311)).as(Raw.charSequenceAssertion()).isEqualTo("1c8f");

        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE), Raw.charSequenceAssertion()).isEqualTo("7fff");
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("7fff");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 65535)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 65535), Raw.charSequenceAssertion()).isEqualTo("ffff");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 65535)).as(Raw.charSequenceAssertion()).isEqualTo("ffff");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) -100)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) -100), Raw.charSequenceAssertion()).isEqualTo("ff9c");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) -100)).as(Raw.charSequenceAssertion()).isEqualTo("ff9c");

        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MIN_VALUE)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MIN_VALUE), Raw.charSequenceAssertion()).isEqualTo("8000");
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MIN_VALUE)).as(Raw.charSequenceAssertion()).isEqualTo("8000");
    }

    /**
     * {@link ShortToStringValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ShortToStringValueConverter().convert(null);
    }

    /**
     * {@link ShortToStringValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new ShortToStringValueConverter().convert(new Object());
    }

    /**
     * {@link ShortToStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() {
        new ShortToStringValueConverter().convert((short) 0, new Object());
    }

}
