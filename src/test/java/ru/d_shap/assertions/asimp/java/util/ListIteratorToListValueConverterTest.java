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

import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link ListIteratorToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ListIteratorToListValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ListIteratorToListValueConverterTest() {
        super();
    }

    /**
     * {@link ListIteratorToListValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ListIteratorToListValueConverter().getValueClass()).isEqualTo(ListIterator.class);
    }

    /**
     * {@link ListIteratorToListValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ListIteratorToListValueConverter().getTargetClass()).isEqualTo(List.class);
    }

    /**
     * {@link ListIteratorToListValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), -1, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), -1, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), -1, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), -1, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), -1, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), -1, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), -1, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), -1, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), -1, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), -1, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), -1, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), -1, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), -1, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), -1, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), -1, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), -1, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), -1, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), -1, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), -1, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), -1, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), -1, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 0, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 0, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 0, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 0, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 0, true), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 0, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 0, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 0, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 0, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 0, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 0, true), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 0, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 0, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 0, true), Raw.<String>listAssertion()).containsExactlyInOrder("val2", "val3");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 0, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val2", "val3");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 0, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 0, true), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 0, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3", "val4", "val5");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 0, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 0, true), Raw.<String>listAssertion()).containsExactlyInOrder("val4", "val5");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 0, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val4", "val5");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 3, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 3, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 3, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 3, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 3, true), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 3, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 3, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 3, true), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 3, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 3, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 3, true), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 3, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 3, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 3, true), Raw.<String>listAssertion()).containsExactlyInOrder("val2", "val3");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 3, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val2", "val3");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 3, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 3, true), Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 3, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1", "val2", "val3");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 3, true)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 3, true), Raw.<String>listAssertion()).containsExactlyInOrder("val4", "val5");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 3, true)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val4", "val5");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), -1, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), -1, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), -1, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), -1, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), -1, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), -1, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), -1, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), -1, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), -1, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), -1, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), -1, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), -1, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), -1, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), -1, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), -1, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), -1, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), -1, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), -1, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), -1, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), -1, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), -1, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 0, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 0, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 0, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 0, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 0, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 0, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 0, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 0, false), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 0, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 0, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 0, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 0, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 0, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 0, false), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 0, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 0, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 0, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 0, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 0, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 0, false), Raw.<String>listAssertion()).containsExactlyInOrder("val3", "val2", "val1");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 0, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val3", "val2", "val1");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 3, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 3, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 3, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 3, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 3, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1"), 3, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 3, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 3, false), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1"), 3, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 3, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 3, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3"), 3, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 3, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 3, false), Raw.<String>listAssertion()).containsExactlyInOrder("val1");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(1, "val1", "val2", "val3"), 3, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val1");

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 3, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 3, false), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0, "val1", "val2", "val3", "val4", "val5"), 3, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 3, false)).isInstanceOf(List.class);
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 3, false), Raw.<String>listAssertion()).containsExactlyInOrder("val3", "val2", "val1");
        Assertions.assertThat(new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(3, "val1", "val2", "val3", "val4", "val5"), 3, false)).as(Raw.<String>listAssertion()).containsExactlyInOrder("val3", "val2", "val1");
    }

    /**
     * {@link ListIteratorToListValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ListIteratorToListValueConverter().convert(null);
    }

    /**
     * {@link ListIteratorToListValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new ListIteratorToListValueConverter().convert(new Object());
    }

    /**
     * {@link ListIteratorToListValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount0FailTest() {
        new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0));
    }

    /**
     * {@link ListIteratorToListValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount3FailTest() {
        new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), new Object(), new Object(), new Object());
    }

    /**
     * {@link ListIteratorToListValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentType1FailTest() {
        new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), new Object(), new Object());
    }

    /**
     * {@link ListIteratorToListValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongArgumentType2FailTest() {
        new ListIteratorToListValueConverter().convert(DataHelper.createListIterator(0), 5, new Object());
    }

}
