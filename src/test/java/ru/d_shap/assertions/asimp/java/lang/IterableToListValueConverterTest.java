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
package ru.d_shap.assertions.asimp.java.lang;

import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link IterableToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IterableToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IterableToListValueConverterTest() {
        super();
    }

    /**
     * {@link IterableToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IterableToListValueConverter().getValueClass()).isEqualTo(Iterable.class);
    }

    /**
     * {@link IterableToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IterableToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link IterableToListValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable())).isInstanceOf(List.class);
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable()), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable())).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable(""))).isInstanceOf(List.class);
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("")), Raw.<String>listAssertion()).containsExactlyInOrder("");
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable(""))).as(Raw.<String>listAssertion()).containsExactlyInOrder("");

        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("val1"))).isInstanceOf(List.class);
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("val1")), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("val1"))).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("val1", "val2", "val3"))).isInstanceOf(List.class);
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("val1", "val2", "val3")), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("val1", "val2", "val3"))).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"))).isInstanceOf(List.class);
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5")), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        Assertions.assertThat(new IterableToListValueConverter().convert(DataHelper.createIterable("val1", "val2", "val3", "val4", "val5"))).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");

        Iterable<String> iterable = DataHelper.createIterable("val1", "val2", "val3", "val4", "val5");
        Assertions.assertThat(new IterableToListValueConverter().convert(iterable)).isNotSameAs(iterable);

        List<String> list = DataHelper.createArrayList("val1", "val2", "val3", "val4", "val5");
        Assertions.assertThat(new IterableToListValueConverter().convert(list)).isSameAs(list);
    }

    /**
     * {@link IterableToListValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new IterableToListValueConverter().convert(null);
    }

    /**
     * {@link IterableToListValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new IterableToListValueConverter().convert(new Object());
    }

    /**
     * {@link IterableToListValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount1FailTest() {
        new IterableToListValueConverter().convert(DataHelper.createIterable(), new Object());
    }

}
