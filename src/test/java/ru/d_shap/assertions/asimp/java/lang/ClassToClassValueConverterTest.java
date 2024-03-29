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

import java.util.Date;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ClassToClassValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ClassToClassValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ClassToClassValueConverterTest() {
        super();
    }

    /**
     * {@link ClassToClassValueConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new ClassToClassValueConverter().getValueClass()).isEqualTo(Class.class);
    }

    /**
     * {@link ClassToClassValueConverter} class test.
     */
    @Test
    public void getTargetClassTest() {
        Assertions.assertThat(new ClassToClassValueConverter().getTargetClass()).isEqualTo(Class.class);
    }

    /**
     * {@link ClassToClassValueConverter} class test.
     */
    @Test
    public void convertTest() {
        Assertions.assertThat(new ClassToClassValueConverter().convert(String.class)).isInstanceOf(Class.class);
        Assertions.assertThat(new ClassToClassValueConverter().convert(String.class), Raw.classAssertion()).isEqualTo(String.class);
        Assertions.assertThat(new ClassToClassValueConverter().convert(String.class)).as(Raw.classAssertion()).isEqualTo(String.class);

        Assertions.assertThat(new ClassToClassValueConverter().convert(Date.class)).isInstanceOf(Class.class);
        Assertions.assertThat(new ClassToClassValueConverter().convert(Date.class), Raw.classAssertion()).isEqualTo(Date.class);
        Assertions.assertThat(new ClassToClassValueConverter().convert(Date.class)).as(Raw.classAssertion()).isEqualTo(Date.class);

        Assertions.assertThat(new ClassToClassValueConverter().convert(Integer.class)).isInstanceOf(Class.class);
        Assertions.assertThat(new ClassToClassValueConverter().convert(Integer.class), Raw.classAssertion()).isEqualTo(Integer.class);
        Assertions.assertThat(new ClassToClassValueConverter().convert(Integer.class)).as(Raw.classAssertion()).isEqualTo(Integer.class);
    }

    /**
     * {@link ClassToClassValueConverter} class test.
     */
    @Test(expected = NullPointerException.class)
    public void convertNullValueFailTest() {
        new ClassToClassValueConverter().convert(null);
    }

    /**
     * {@link ClassToClassValueConverter} class test.
     */
    @Test(expected = ClassCastException.class)
    public void convertWrongValueTypeFailTest() {
        new ClassToClassValueConverter().convert(new Object());
    }

    /**
     * {@link ClassToClassValueConverter} class test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void convertWrongArgumentCount1FailTest() {
        new ClassToClassValueConverter().convert(String.class, new Object());
    }

}
