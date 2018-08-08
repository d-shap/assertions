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

import java.util.Map;
import java.util.SortedMap;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link SortedMapToMapValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class SortedMapToMapValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public SortedMapToMapValueConverterTest() {
        super();
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new SortedMapToMapValueConverter().getValueClass()).isEqualTo(SortedMap.class);
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new SortedMapToMapValueConverter().getTargetClass()).isEqualTo(Map.class);
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new SortedMapToMapValueConverter().canConvert(createTreeMap())).isTrue();
        Assertions.assertThat(new SortedMapToMapValueConverter().canConvert(createTreeMap("k1", "v1", "k2", "v2"))).isTrue();
        Assertions.assertThat(new SortedMapToMapValueConverter().canConvert(createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4"))).isTrue();
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new SortedMapToMapValueConverter().canConvert(null);
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new SortedMapToMapValueConverter().canConvert(new Object());
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new SortedMapToMapValueConverter().canConvert(createTreeMap(), new Object());
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new SortedMapToMapValueConverter().convert(createTreeMap())).isInstanceOf(Map.class);
        Assertions.assertThat(new SortedMapToMapValueConverter().convert(createTreeMap()), Raw.<String, String>mapAssertion()).isEmpty();
        Assertions.assertThat(new SortedMapToMapValueConverter().convert(createTreeMap())).as(Raw.<String, String>mapAssertion()).isEmpty();

        Assertions.assertThat(new SortedMapToMapValueConverter().convert(createTreeMap("k1", "v1", "k2", "v2"))).isInstanceOf(Map.class);
        Assertions.assertThat(new SortedMapToMapValueConverter().convert(createTreeMap("k1", "v1", "k2", "v2")), Raw.<String, String>mapAssertion()).containsExactlyInOrder("k1", "v1", "k2", "v2");
        Assertions.assertThat(new SortedMapToMapValueConverter().convert(createTreeMap("k1", "v1", "k2", "v2"))).as(Raw.<String, String>mapAssertion()).containsExactlyInOrder("k1", "v1", "k2", "v2");

        Assertions.assertThat(new SortedMapToMapValueConverter().convert(createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4"))).isInstanceOf(Map.class);
        Assertions.assertThat(new SortedMapToMapValueConverter().convert(createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")), Raw.<String, String>mapAssertion()).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        Assertions.assertThat(new SortedMapToMapValueConverter().convert(createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4"))).as(Raw.<String, String>mapAssertion()).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new SortedMapToMapValueConverter().convert(null);
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new SortedMapToMapValueConverter().convert(new Object());
    }

    /**
     * {@link SortedMapToMapValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new SortedMapToMapValueConverter().convert(createTreeMap(), new Object());
    }

}
