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

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link ObjectToClassValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ObjectToClassValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ObjectToClassValueConverterTest() {
        super();
    }

    /**
     * {@link ObjectToClassValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ObjectToClassValueConverter().getValueClass()).isEqualTo(Object.class);
    }

    /**
     * {@link ObjectToClassValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ObjectToClassValueConverter().getTargetClass()).isEqualTo(Class.class);
    }

    /**
     * {@link ObjectToClassValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new ObjectToClassValueConverter().convert("value")).isInstanceOf(Class.class);
        Assertions.assertThat(new ObjectToClassValueConverter().convert("value"), Raw.classAssertion()).isEqualTo(String.class);
        Assertions.assertThat(new ObjectToClassValueConverter().convert("value")).as(Raw.classAssertion()).isEqualTo(String.class);

        Assertions.assertThat(new ObjectToClassValueConverter().convert(DataHelper.createDate(2020, Calendar.SEPTEMBER, 20, 1, 2, 3))).isInstanceOf(Class.class);
        Assertions.assertThat(new ObjectToClassValueConverter().convert(DataHelper.createDate(2020, Calendar.SEPTEMBER, 20, 1, 2, 3)), Raw.classAssertion()).isEqualTo(Date.class);
        Assertions.assertThat(new ObjectToClassValueConverter().convert(DataHelper.createDate(2020, Calendar.SEPTEMBER, 20, 1, 2, 3))).as(Raw.classAssertion()).isEqualTo(Date.class);

        Assertions.assertThat(new ObjectToClassValueConverter().convert(5)).isInstanceOf(Class.class);
        Assertions.assertThat(new ObjectToClassValueConverter().convert(5), Raw.classAssertion()).isEqualTo(Integer.class);
        Assertions.assertThat(new ObjectToClassValueConverter().convert(5)).as(Raw.classAssertion()).isEqualTo(Integer.class);
    }

    /**
     * {@link ObjectToClassValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ObjectToClassValueConverter().convert(null);
    }

    /**
     * {@link ObjectToClassValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCountFailTest() {
        new ObjectToClassValueConverter().convert("value", new Object());
    }

}
