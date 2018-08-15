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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.ConversionException;

/**
 * Tests for {@link CollectionAsStringConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class CollectionAsStringConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CollectionAsStringConverterTest() {
        super();
    }

    /**
     * {@link CollectionAsStringConverter} class test.
     */
    @Test
    public void getValueClassTest() {
        Assertions.assertThat(new CollectionAsStringConverter().getValueClass()).isEqualTo(Collection.class);
    }

    /**
     * {@link CollectionAsStringConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test
    public void asStringTest() throws ConversionException {
        List<String> list = new ArrayList<>();
        Assertions.assertThat(new CollectionAsStringConverter().asString(list)).isEqualTo("[]");

        list.add("val1");
        Assertions.assertThat(new CollectionAsStringConverter().asString(list)).isEqualTo("[val1]");

        list.add("val2");
        list.add("val3");
        Assertions.assertThat(new CollectionAsStringConverter().asString(list)).isEqualTo("[val1, val2, val3]");

        list.add("val4");
        list.add("val5");
        Assertions.assertThat(new CollectionAsStringConverter().asString(list)).isEqualTo("[val1, val2, val3, val4, val5]");
    }

    /**
     * {@link CollectionAsStringConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = NullPointerException.class)
    public void asStringNullValueFailTest() throws ConversionException {
        new CollectionAsStringConverter().asString(null);
    }

    /**
     * {@link CollectionAsStringConverter} class test.
     *
     * @throws ru.d_shap.assertions.ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @Test(expected = ClassCastException.class)
    public void asStringWrongValueTypeFailTest() throws ConversionException {
        new CollectionAsStringConverter().asString(new Object());
    }

}
