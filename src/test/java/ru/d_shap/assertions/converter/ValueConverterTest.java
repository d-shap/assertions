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
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.data.ReflectionHelper;

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
     */
    @Test
    public void convertTest() {
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
     */
    @Test
    @SuppressWarnings("unchecked")
    public void converterSelectTest() {
        List<ValueConverterProvider> converterProviders = (List<ValueConverterProvider>) ReflectionHelper.getFieldValue(ValueConverter.class, null, "CONVERTER_PROVIDERS");
        converterProviders.add(new FromClassAToClassXConverter());
        converterProviders.add(new FromClassAToClassYConverter());
        converterProviders.add(new FromClassBToClassXConverter());
        converterProviders.add(new FromClassBToClassYConverter());

        converterProviders.add(new InterfaceAToClassZ1Converter());
        converterProviders.add(new InterfaceBToClassZ1Converter());
        converterProviders.add(new FromClassC1InterfaceAConverter());
        converterProviders.add(new FromClassC1InterfaceBConverter());

        Assertions.assertThat(ValueConverter.convert(new FromClassA(), ToClassX.class)).hasClass(ToClassX.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassA(), ToClassY.class)).hasClass(ToClassY.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassB(), ToClassX.class)).hasClass(ToClassX.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassB(), ToClassY.class)).hasClass(ToClassY.class);

        Assertions.assertThat(ValueConverter.convert(new FromClassC1(), ToClassZ1.class)).hasClass(ToClassZ1.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC2(), ToClassZ1.class)).hasClass(ToClassZ2.class);

        Assertions.assertThat(ValueConverter.convert(new FromClassC1(), InterfaceA.class)).hasClass(ToClassZ1.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC1(), InterfaceB.class)).hasClass(ToClassZ2.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC1(), InterfaceC.class)).hasClass(ToClassZ2.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC1(), InterfaceD.class)).hasClass(ToClassZ2.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC1(), InterfaceE.class)).hasClass(ToClassZ2.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC2(), InterfaceA.class)).hasClass(ToClassZ1.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC2(), InterfaceB.class)).hasClass(ToClassZ2.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC2(), InterfaceC.class)).hasClass(ToClassZ2.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC2(), InterfaceD.class)).hasClass(ToClassZ2.class);
        Assertions.assertThat(ValueConverter.convert(new FromClassC2(), InterfaceE.class)).hasClass(ToClassZ2.class);
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private interface InterfaceA {

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private interface InterfaceB extends InterfaceA {

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private interface InterfaceC extends InterfaceB {

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private interface InterfaceD extends InterfaceC {

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private interface InterfaceE extends InterfaceD {

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
    private static class FromClassC1 implements InterfaceA {

        FromClassC1() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class FromClassC2 extends FromClassC1 implements InterfaceE {

        FromClassC2() {
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
    private static class ToClassZ1 implements InterfaceA {

        ToClassZ1() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static class ToClassZ2 extends ToClassZ1 implements InterfaceE {

        ToClassZ2() {
            super();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class FromClassAToClassXConverter implements ValueConverterProvider {

        FromClassAToClassXConverter() {
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
        public Object convert(final Object value, final Object... arguments) {
            return new ToClassX();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class FromClassAToClassYConverter implements ValueConverterProvider {

        FromClassAToClassYConverter() {
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
        public Object convert(final Object value, final Object... arguments) {
            return new ToClassY();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class FromClassBToClassXConverter implements ValueConverterProvider {

        FromClassBToClassXConverter() {
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
        public Object convert(final Object value, final Object... arguments) {
            return new ToClassX();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class FromClassBToClassYConverter implements ValueConverterProvider {

        FromClassBToClassYConverter() {
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
        public Object convert(final Object value, final Object... arguments) {
            return new ToClassY();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class InterfaceAToClassZ1Converter implements ValueConverterProvider {

        InterfaceAToClassZ1Converter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return InterfaceA.class;
        }

        @Override
        public Class<?> getTargetClass() {
            return ToClassZ1.class;
        }

        @Override
        public Object convert(final Object value, final Object... arguments) {
            return new ToClassZ1();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class InterfaceBToClassZ1Converter implements ValueConverterProvider {

        InterfaceBToClassZ1Converter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return InterfaceB.class;
        }

        @Override
        public Class<?> getTargetClass() {
            return ToClassZ1.class;
        }

        @Override
        public Object convert(final Object value, final Object... arguments) {
            return new ToClassZ2();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class FromClassC1InterfaceAConverter implements ValueConverterProvider {

        FromClassC1InterfaceAConverter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return FromClassC1.class;
        }

        @Override
        public Class<?> getTargetClass() {
            return InterfaceA.class;
        }

        @Override
        public Object convert(final Object value, final Object... arguments) {
            return new ToClassZ1();
        }

    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class FromClassC1InterfaceBConverter implements ValueConverterProvider {

        FromClassC1InterfaceBConverter() {
            super();
        }

        @Override
        public Class<?> getValueClass() {
            return FromClassC1.class;
        }

        @Override
        public Class<?> getTargetClass() {
            return InterfaceB.class;
        }

        @Override
        public Object convert(final Object value, final Object... arguments) {
            return new ToClassZ2();
        }

    }

}
