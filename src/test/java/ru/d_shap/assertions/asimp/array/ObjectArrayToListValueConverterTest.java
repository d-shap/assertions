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
package ru.d_shap.assertions.asimp.array;

import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ObjectArrayToListValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectArrayToListValueConverterTest extends AssertionTest {

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
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{})).isInstanceOf(List.class);
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{}), Raw.<String>listAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ObjectArrayToListValueConverter().convert(new String[]{})).as(Raw.<String>listAssertion()).containsExactlyInOrder();

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
     * @throws Exception exception in test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() throws Exception {
        new ObjectArrayToListValueConverter().convert(null);
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() throws Exception {
        new ObjectArrayToListValueConverter().convert(new Object());
    }

    /**
     * {@link ObjectArrayToListValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() throws Exception {
        new ObjectArrayToListValueConverter().convert(new String[]{}, new Object());
    }

}
