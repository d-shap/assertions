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
package ru.d_shap.assertions.collection;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link SetToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class SetToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public SetToListValueConverterTest() {
        super();
    }

    /**
     * {@link SetToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new SetToListValueConverter().getValueClass()).isEqualTo(Set.class);
    }

    /**
     * {@link SetToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new SetToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link SetToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new SetToListValueConverter().canConvert(createHashSet())).isTrue();
        Assertions.assertThat(new SetToListValueConverter().canConvert(createHashSet("val1", "val2"))).isTrue();
        Assertions.assertThat(new SetToListValueConverter().canConvert(createHashSet("val1", "val2", "val3", "val4"))).isTrue();
    }

    /**
     * {@link SetToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new SetToListValueConverter().canConvert(null);
    }

    /**
     * {@link SetToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new SetToListValueConverter().canConvert(new Object());
    }

    /**
     * {@link SetToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new SetToListValueConverter().canConvert(createHashSet(), new Object());
    }

    /**
     * {@link SetToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new SetToListValueConverter().convert(createHashSet())).isInstanceOf(List.class);
        Assertions.assertThat(new SetToListValueConverter().convert(createHashSet()), Raw.<String>listAssertion()).isEmpty();
        Assertions.assertThat(new SetToListValueConverter().convert(createHashSet())).as(Raw.<String>listAssertion()).isEmpty();

        Assertions.assertThat(new SetToListValueConverter().convert(createHashSet("val1", "val2"))).isInstanceOf(List.class);
        Assertions.assertThat(new SetToListValueConverter().convert(createHashSet("val1", "val2")), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2");
        Assertions.assertThat(new SetToListValueConverter().convert(createHashSet("val1", "val2"))).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2");

        Assertions.assertThat(new SetToListValueConverter().convert(createHashSet("val1", "val2", "val3", "val4"))).isInstanceOf(List.class);
        Assertions.assertThat(new SetToListValueConverter().convert(createHashSet("val1", "val2", "val3", "val4")), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4");
        Assertions.assertThat(new SetToListValueConverter().convert(createHashSet("val1", "val2", "val3", "val4"))).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4");
    }

    /**
     * {@link SetToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new SetToListValueConverter().convert(null);
    }

    /**
     * {@link SetToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new SetToListValueConverter().convert(new Object());
    }

    /**
     * {@link SetToListValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new SetToListValueConverter().convert(createHashSet(), new Object());
    }

}
