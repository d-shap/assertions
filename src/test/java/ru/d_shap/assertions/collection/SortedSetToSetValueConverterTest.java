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

import java.util.Set;
import java.util.SortedSet;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConvertionException;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link SortedSetToSetValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class SortedSetToSetValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public SortedSetToSetValueConverterTest() {
        super();
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new SortedSetToSetValueConverter().getValueClass()).isEqualTo(SortedSet.class);
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new SortedSetToSetValueConverter().getTargetClass()).isEqualTo(Set.class);
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void canConvertTest() throws ConvertionException {
        Assertions.assertThat(new SortedSetToSetValueConverter().canConvert(createTreeSet())).isTrue();
        Assertions.assertThat(new SortedSetToSetValueConverter().canConvert(createTreeSet("val1", "val2"))).isTrue();
        Assertions.assertThat(new SortedSetToSetValueConverter().canConvert(createTreeSet("val1", "val2", "val3", "val4"))).isTrue();
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void canConvertNullValueFailTest() throws ConvertionException {
        new SortedSetToSetValueConverter().canConvert(null);
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void canConvertWrongValueTypeFailTest() throws ConvertionException {
        new SortedSetToSetValueConverter().canConvert(new Object());
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void canConvertWrongArgumentCountFailTest() throws ConvertionException {
        new SortedSetToSetValueConverter().canConvert(createTreeSet(), new Object());
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConvertionException {
        Assertions.assertThat(new SortedSetToSetValueConverter().convert(createTreeSet())).isInstanceOf(Set.class);
        Assertions.assertThat(new SortedSetToSetValueConverter().convert(createTreeSet()), Raw.<String>setAssertion()).isEmpty();
        Assertions.assertThat(new SortedSetToSetValueConverter().convert(createTreeSet())).as(Raw.<String>setAssertion()).isEmpty();

        Assertions.assertThat(new SortedSetToSetValueConverter().convert(createTreeSet("val1", "val2"))).isInstanceOf(Set.class);
        Assertions.assertThat(new SortedSetToSetValueConverter().convert(createTreeSet("val1", "val2")), Raw.<String>setAssertion()).containsExactlyInOrder("val1", "val2");
        Assertions.assertThat(new SortedSetToSetValueConverter().convert(createTreeSet("val1", "val2"))).as(Raw.<String>setAssertion()).containsExactlyInOrder("val1", "val2");

        Assertions.assertThat(new SortedSetToSetValueConverter().convert(createTreeSet("val1", "val2", "val3", "val4"))).isInstanceOf(Set.class);
        Assertions.assertThat(new SortedSetToSetValueConverter().convert(createTreeSet("val1", "val2", "val3", "val4")), Raw.<String>setAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4");
        Assertions.assertThat(new SortedSetToSetValueConverter().convert(createTreeSet("val1", "val2", "val3", "val4"))).as(Raw.<String>setAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4");
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConvertionException {
        new SortedSetToSetValueConverter().convert(null);
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConvertionException {
        new SortedSetToSetValueConverter().convert(new Object());
    }

    /**
     * {@link SortedSetToSetValueConverter} class test.
     *
     * @throws ConvertionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws ConvertionException {
        new SortedSetToSetValueConverter().convert(createTreeSet(), new Object());
    }

}
