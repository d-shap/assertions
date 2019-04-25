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
 * Tests for {@link IntToCharValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IntToCharValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IntToCharValueConverterTest() {
        super();
    }

    /**
     * {@link IntToCharValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IntToCharValueConverter().getValueClass()).isEqualTo(Integer.class);
    }

    /**
     * {@link IntToCharValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IntToCharValueConverter().getTargetClass()).isEqualTo(Character.class);
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new IntToCharValueConverter().convert(0)).isInstanceOf(Character.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(0), Raw.charAssertion()).isEqualTo(0);
        Assertions.assertThat(new IntToCharValueConverter().convert(0)).as(Raw.charAssertion()).isEqualTo(0);

        Assertions.assertThat(new IntToCharValueConverter().convert(100)).isInstanceOf(Character.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(100), Raw.charAssertion()).isEqualTo(100);
        Assertions.assertThat(new IntToCharValueConverter().convert(100)).as(Raw.charAssertion()).isEqualTo(100);

        Assertions.assertThat(new IntToCharValueConverter().convert(65535)).isInstanceOf(Character.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(65535), Raw.charAssertion()).isEqualTo(65535);
        Assertions.assertThat(new IntToCharValueConverter().convert(65535)).as(Raw.charAssertion()).isEqualTo(65535);

        Assertions.assertThat(new IntToCharValueConverter().convert(65536)).isInstanceOf(Integer.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(65536), Raw.intAssertion()).isEqualTo(65536);
        Assertions.assertThat(new IntToCharValueConverter().convert(65536)).as(Raw.intAssertion()).isEqualTo(65536);

        Assertions.assertThat(new IntToCharValueConverter().convert(-1)).isInstanceOf(Integer.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(-1), Raw.intAssertion()).isEqualTo(-1);
        Assertions.assertThat(new IntToCharValueConverter().convert(-1)).as(Raw.intAssertion()).isEqualTo(-1);

        Assertions.assertThat(new IntToCharValueConverter().convert(-100)).isInstanceOf(Integer.class);
        Assertions.assertThat(new IntToCharValueConverter().convert(-100), Raw.intAssertion()).isEqualTo(-100);
        Assertions.assertThat(new IntToCharValueConverter().convert(-100)).as(Raw.intAssertion()).isEqualTo(-100);
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new IntToCharValueConverter().convert(null);
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new IntToCharValueConverter().convert(new Object());
    }

    /**
     * {@link IntToCharValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws Exception {
        new IntToCharValueConverter().convert(0, new Object());
    }

}
