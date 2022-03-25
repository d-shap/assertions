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
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0, (Boolean) null)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0, (Boolean) null), Raw.charSequenceAssertion()).isEqualTo("0");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0, (Boolean) null)).as(Raw.charSequenceAssertion()).isEqualTo("0");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 100, (Boolean) null)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 100, (Boolean) null), Raw.charSequenceAssertion()).isEqualTo("100");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 100, (Boolean) null)).as(Raw.charSequenceAssertion()).isEqualTo("100");

        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE, (Boolean) null)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE, (Boolean) null), Raw.charSequenceAssertion()).isEqualTo("32767");
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE, (Boolean) null)).as(Raw.charSequenceAssertion()).isEqualTo("32767");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0, false)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0, false), Raw.charSequenceAssertion()).isEqualTo("0");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0, false)).as(Raw.charSequenceAssertion()).isEqualTo("0");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 100, false)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 100, false), Raw.charSequenceAssertion()).isEqualTo("100");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 100, false)).as(Raw.charSequenceAssertion()).isEqualTo("100");

        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE, false)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE, false), Raw.charSequenceAssertion()).isEqualTo("32767");
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE, false)).as(Raw.charSequenceAssertion()).isEqualTo("32767");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0, true), Raw.charSequenceAssertion()).isEqualTo("0000");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 0, true)).as(Raw.charSequenceAssertion()).isEqualTo("0000");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 1, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 1, true), Raw.charSequenceAssertion()).isEqualTo("0001");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 1, true)).as(Raw.charSequenceAssertion()).isEqualTo("0001");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 31, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 31, true), Raw.charSequenceAssertion()).isEqualTo("001f");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 31, true)).as(Raw.charSequenceAssertion()).isEqualTo("001f");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 479, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 479, true), Raw.charSequenceAssertion()).isEqualTo("01df");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 479, true)).as(Raw.charSequenceAssertion()).isEqualTo("01df");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 7311, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 7311, true), Raw.charSequenceAssertion()).isEqualTo("1c8f");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 7311, true)).as(Raw.charSequenceAssertion()).isEqualTo("1c8f");

        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE, true), Raw.charSequenceAssertion()).isEqualTo("7fff");
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MAX_VALUE, true)).as(Raw.charSequenceAssertion()).isEqualTo("7fff");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 65535, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 65535, true), Raw.charSequenceAssertion()).isEqualTo("ffff");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) 65535, true)).as(Raw.charSequenceAssertion()).isEqualTo("ffff");

        Assertions.assertThat(new ShortToStringValueConverter().convert((short) -100, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) -100, true), Raw.charSequenceAssertion()).isEqualTo("ff9c");
        Assertions.assertThat(new ShortToStringValueConverter().convert((short) -100, true)).as(Raw.charSequenceAssertion()).isEqualTo("ff9c");

        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MIN_VALUE, true)).isInstanceOf(String.class);
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MIN_VALUE, true), Raw.charSequenceAssertion()).isEqualTo("8000");
        Assertions.assertThat(new ShortToStringValueConverter().convert(Short.MIN_VALUE, true)).as(Raw.charSequenceAssertion()).isEqualTo("8000");
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
    public void convertWrongArgumentCount0FailTest() {
        new ShortToStringValueConverter().convert((short) 0);
    }

    /**
     * {@link ShortToStringValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() {
        new ShortToStringValueConverter().convert((short) 0, new Object(), new Object());
    }

}
