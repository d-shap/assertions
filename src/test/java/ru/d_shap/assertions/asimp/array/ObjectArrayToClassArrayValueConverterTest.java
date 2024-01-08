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

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link ObjectArrayToClassArrayValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectArrayToClassArrayValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ObjectArrayToClassArrayValueConverterTest() {
        super();
    }

    /**
     * {@link ObjectArrayToClassArrayValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().getValueClass()).isEqualTo(Object[].class);
    }

    /**
     * {@link ObjectArrayToClassArrayValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().getTargetClass()).isEqualTo(Class[].class);
    }

    /**
     * {@link ObjectArrayToClassArrayValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().convert(new Object[]{})).isInstanceOf(Class[].class);
        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().convert(new Object[]{}), Raw.objectArrayAssertion()).containsExactlyInOrder();
        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().convert(new Object[]{})).as(Raw.objectArrayAssertion()).containsExactlyInOrder();

        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().convert(new Object[]{"param"})).isInstanceOf(Class[].class);
        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().convert(new Object[]{"param"}), Raw.objectArrayAssertion()).containsExactlyInOrder(String.class);
        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().convert(new Object[]{"param"})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(String.class);

        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().convert(new Object[]{DataHelper.createDate(2020, Calendar.SEPTEMBER, 20, 1, 1, 1), 1})).isInstanceOf(Class[].class);
        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().convert(new Object[]{DataHelper.createDate(2020, Calendar.SEPTEMBER, 20, 1, 1, 1), 1}), Raw.objectArrayAssertion()).containsExactlyInOrder(Date.class, Integer.class);
        Assertions.assertThat(new ObjectArrayToClassArrayValueConverter().convert(new Object[]{DataHelper.createDate(2020, Calendar.SEPTEMBER, 20, 1, 1, 1), 1})).as(Raw.objectArrayAssertion()).containsExactlyInOrder(Date.class, Integer.class);
    }

    /**
     * {@link ObjectArrayToClassArrayValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ObjectArrayToClassArrayValueConverter().convert(null);
    }

    /**
     * {@link ObjectArrayToClassArrayValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new ObjectArrayToClassArrayValueConverter().convert(new Object());
    }

    /**
     * {@link ObjectArrayToClassArrayValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount1FailTest() {
        new ObjectArrayToClassArrayValueConverter().convert(new Object[]{}, new Object());
    }

}
