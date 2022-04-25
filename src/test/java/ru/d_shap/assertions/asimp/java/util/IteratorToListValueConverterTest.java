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
package ru.d_shap.assertions.asimp.java.util;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator(), -1)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator(), -1), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator(), -1)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1"), -1)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1"), -1), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1"), -1)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3"), -1)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3"), -1), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3"), -1)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), -1)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), -1), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), -1)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator(), 0)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator(), 0), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator(), 0)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1"), 0)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1"), 0), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1"), 0)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3"), 0)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3"), 0), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3"), 0)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), 0)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), 0), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), 0)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator(), 3)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator(), 3), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator(), 3)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1"), 3)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1"), 3), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1"), 3)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3"), 3)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3"), 3), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3"), 3)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), 3)).isInstanceOf(List.class);
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), 3), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new IteratorToListValueConverter().convert(DataHelper.createIterator("val1", "val2", "val3", "val4", "val5"), 3)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new IteratorToListValueConverter().convert(null);
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new IteratorToListValueConverter().convert(new Object());
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new IteratorToListValueConverter().convert(DataHelper.createIterator());
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount2FailTest() {
        new IteratorToListValueConverter().convert(DataHelper.createIterator(), new Object(), new Object());
    }

    /**
     * {@link IteratorToListValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentTypeFailTest() {
        new IteratorToListValueConverter().convert(DataHelper.createIterator(), new Object());
    }

}
