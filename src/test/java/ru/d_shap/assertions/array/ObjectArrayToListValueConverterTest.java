///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.array;

import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ObjectArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectArrayToListValueConverterTest {

    /**
     * Test class constructor.
     */
    public ObjectArrayToListValueConverterTest() {
        super();
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ObjectArrayToListValueConverter().getValueClass()).isEqualTo(Object[].class);
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ObjectArrayToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new ObjectArrayToListValueConverter().canConvert(new String[0])).isTrue();
        Assertions.assertThat(new ObjectArrayToListValueConverter().canConvert(new String[]{"val1", "val2"})).isTrue();
        Assertions.assertThat(new ObjectArrayToListValueConverter().canConvert(new String[]{"val1", "val2", "val3", "val4"})).isTrue();
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new ObjectArrayToListValueConverter().canConvert(null);
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new ObjectArrayToListValueConverter().canConvert(new Object());
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{}), Raw.<String>listAssertion()).isEmpty();
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{})).as(Raw.<String>listAssertion()).isEmpty();

        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{"val1", "val2"})).isInstanceOf(List.class);
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{"val1", "val2"}), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2");
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{"val1", "val2"})).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2");

        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{"val1", "val2", "val3", "val4"})).isInstanceOf(List.class);
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{"val1", "val2", "val3", "val4"}), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4");
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{"val1", "val2", "val3", "val4"})).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4");
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new ObjectArrayToListValueConverter().convert(null);
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new ObjectArrayToListValueConverter().convert(new Object());
    }

}
