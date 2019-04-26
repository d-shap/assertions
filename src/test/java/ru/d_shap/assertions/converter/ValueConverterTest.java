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
package ru.d_shap.assertions.converter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.PrivateAccessor;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ValueConverter}.
 *
 * @author Dmitry Shapovalov
 */
public final class ValueConverterTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ValueConverterTest() {
        super();
    }

    /**
     * {@link ValueConverter} class test.
     */
    @Test
    public void constructorTest() {
        Assertions.assertThat(ValueConverter.class).hasOnePrivateConstructor();
    }

    /**
     * {@link ValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void convertTest() throws Exception {
        Assertions.assertThat(ValueConverter.convert(null, String.class)).isNull();

        Assertions.assertThat(ValueConverter.convert(100, Character.class)).isInstanceOf(Character.class);
        Assertions.assertThat(ValueConverter.convert(100, Character.class)).isEqualTo((char) 100);
        Assertions.assertThat(ValueConverter.convert(100000, Character.class)).isInstanceOf(Integer.class);
        Assertions.assertThat(ValueConverter.convert(100000, Character.class)).isEqualTo(100000);

        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 6)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 6), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 5)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 5), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4, 5);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 4)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 4), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3, 4);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 3)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 3), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2, 3);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 2)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 2), Raw.<Integer>listAssertion()).containsExactlyInOrder(1, 2);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 1)).isInstanceOf(List.class);
        Assertions.assertThat(ValueConverter.convert(createIterator(1, 2, 3, 4, 5), List.class, 1), Raw.<Integer>listAssertion()).containsExactlyInOrder(1);

        Assertions.assertThat(ValueConverter.convert(Arrays.asList(1, 2, 3, 4, 5), Map.class)).isInstanceOf(List.class);
    }

    /**
     * {@link ValueConverter} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void converterSelectTest() throws Exception {
        List<ValueConverterProvider> converterProviders = (List<ValueConverterProvider>) PrivateAccessor.getFieldValue(ValueConverter.class, null, "CONVERTER_PROVIDERS");
        converterProviders.add(new ClassAToClassXConverter());
        converterProviders.add(new ClassAToClassYConverter());
        converterProviders.add(new ClassBToClassXConverter());
        converterProviders.add(new ClassBToClassYConverter());

        Assertions.assertThat(ValueConverter.convert(new FromClassA(), ToClassX.class)).hasClass(ToClassX.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassA(), ToClassY.class)).hasClass(ToClassY.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassB(), ToClassX.class)).hasClass(ToClassX.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassB(), ToClassY.class)).hasClass(ToClassY.class);
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class FromClassA {

        FromClassA() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class FromClassB extends FromClassA {

        FromClassB() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ToClassX {

        ToClassX() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ToClassY extends ToClassX {

        ToClassY() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ClassAToClassXConverter implements ValueConverterProvider {

        ClassAToClassXConverter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return FromClassA.class;
        }

        @Override
        public Class<?> getTargetClass() {
            return ToClassX.class;
        }

        @Override
        public Object convert(final Object value, final Object... arguments) throws ConversionException {
            return new ToClassX();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ClassAToClassYConverter implements ValueConverterProvider {

        ClassAToClassYConverter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return FromClassA.class;
        }

        @Override
        public Class<?> getTargetClass() {
            return ToClassY.class;
        }

        @Override
        public Object convert(final Object value, final Object... arguments) throws ConversionException {
            return new ToClassY();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ClassBToClassXConverter implements ValueConverterProvider {

        ClassBToClassXConverter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return FromClassB.class;
        }

        @Override
        public Class<?> getTargetClass() {
            return ToClassX.class;
        }

        @Override
        public Object convert(final Object value, final Object... arguments) throws ConversionException {
            return new ToClassX();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ClassBToClassYConverter implements ValueConverterProvider {

        ClassBToClassYConverter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return FromClassB.class;
        }

        @Override
        public Class<?> getTargetClass() {
            return ToClassY.class;
        }

        @Override
        public Object convert(final Object value, final Object... arguments) throws ConversionException {
            return new ToClassY();
        }

    }

}
