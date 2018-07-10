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
package ru.d_shap.assertions;

import java.util.LinkedList;
import java.util.List;

import ru.d_shap.assertions.array.BooleanArrayAsStringConverter;
import ru.d_shap.assertions.array.ByteArrayAsStringConverter;
import ru.d_shap.assertions.array.CharArrayAsStringConverter;
import ru.d_shap.assertions.array.DoubleArrayAsStringConverter;
import ru.d_shap.assertions.array.FloatArrayAsStringConverter;
import ru.d_shap.assertions.array.IntArrayAsStringConverter;
import ru.d_shap.assertions.array.LongArrayAsStringConverter;
import ru.d_shap.assertions.array.ObjectArrayAsStringConverter;
import ru.d_shap.assertions.array.ShortArrayAsStringConverter;
import ru.d_shap.assertions.collection.CollectionAsStringConverter;
import ru.d_shap.assertions.collection.MapAsStringConverter;
import ru.d_shap.assertions.core.ClassAsStringConverter;
import ru.d_shap.assertions.core.IterableAsStringConverter;
import ru.d_shap.assertions.nio.ByteBufferAsStringConverter;
import ru.d_shap.assertions.nio.CharBufferAsStringConverter;
import ru.d_shap.assertions.nio.DoubleBufferAsStringConverter;
import ru.d_shap.assertions.nio.FloatBufferAsStringConverter;
import ru.d_shap.assertions.nio.IntBufferAsStringConverter;
import ru.d_shap.assertions.nio.LongBufferAsStringConverter;
import ru.d_shap.assertions.nio.ShortBufferAsStringConverter;
import ru.d_shap.assertions.primitive.BooleanAsStringConverter;
import ru.d_shap.assertions.primitive.CharAsStringConverter;

/**
 * Class to convert the value to the string representation.
 *
 * @author Dmitry Shapovalov
 */
final class AsStringConverter {

    private static final List<BaseAsStringConverter> CONVERTERS;

    static {
        CONVERTERS = new LinkedList<>();

        registerValueConverter(new BooleanAsStringConverter());
        registerValueConverter(new CharAsStringConverter());

        registerValueConverter(new ClassAsStringConverter());
        registerValueConverter(new IterableAsStringConverter());

        registerValueConverter(new CollectionAsStringConverter());
        registerValueConverter(new MapAsStringConverter());

        registerValueConverter(new BooleanArrayAsStringConverter());
        registerValueConverter(new ByteArrayAsStringConverter());
        registerValueConverter(new CharArrayAsStringConverter());
        registerValueConverter(new DoubleArrayAsStringConverter());
        registerValueConverter(new FloatArrayAsStringConverter());
        registerValueConverter(new IntArrayAsStringConverter());
        registerValueConverter(new LongArrayAsStringConverter());
        registerValueConverter(new ObjectArrayAsStringConverter());
        registerValueConverter(new ShortArrayAsStringConverter());

        registerValueConverter(new ByteBufferAsStringConverter());
        registerValueConverter(new CharBufferAsStringConverter());
        registerValueConverter(new DoubleBufferAsStringConverter());
        registerValueConverter(new FloatBufferAsStringConverter());
        registerValueConverter(new IntBufferAsStringConverter());
        registerValueConverter(new LongBufferAsStringConverter());
        registerValueConverter(new ShortBufferAsStringConverter());
    }

    private AsStringConverter() {
        super();
    }

    static void registerValueConverter(final BaseAsStringConverter asStringConverter) {
        CONVERTERS.add(asStringConverter);
    }

    static String asString(final Object value) throws ConvertionException {
        if (value == null) {
            return null;
        }
        Class<?> valueClass = value.getClass();
        for (BaseAsStringConverter asStringConverter : CONVERTERS) {
            if (asStringConverter.getValueClass().isAssignableFrom(valueClass)) {
                return asStringConverter.asString(value);
            }
        }
        return value.toString();
    }

    static String asString(final Object value, final Class<?> targetClass, final Object... arguments) throws ConvertionException {
        Object convertedValue = ValueConverter.convert(value, targetClass, arguments);
        return asString(convertedValue);
    }

}
