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
package ru.d_shap.assertions.asimp.java.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.converter.ConversionException;

/**
 * Tests for {@link IteratorToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class IteratorToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public IteratorToListValueConverterTest() {
        super();
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new IteratorToListValueConverter().getValueClass()).isEqualTo(Iterator.class);
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new IteratorToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void convertTest() throws ConversionException {
        List<String> list = new ArrayList<>();

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator())).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator()), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator())).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        list.add("val1");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator())).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator()), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator())).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        list.add("val2");
        list.add("val3");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator())).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator()), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator())).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        list.add("val4");
        list.add("val5");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator())).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator()), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator())).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), (Object) null)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), -1)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 0)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");

        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new IteratorToListValueConverter().convert(list.iterator(), 3)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws ConversionException {
        new IteratorToListValueConverter().convert(null);
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws ConversionException {
        new IteratorToListValueConverter().convert(new Object());
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() throws ConversionException {
        new IteratorToListValueConverter().convert(new ArrayList<String>().iterator(), new Object(), new Object());
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() throws ConversionException {
        new IteratorToListValueConverter().convert(new ArrayList<String>().iterator(), new Object());
    }

}
