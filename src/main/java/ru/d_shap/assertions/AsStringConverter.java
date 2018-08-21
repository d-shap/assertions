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
import ru.d_shap.assertions.primitive.ByteAsStringConverter;
import ru.d_shap.assertions.primitive.CharAsStringConverter;
import ru.d_shap.assertions.primitive.FloatAsStringConverter;
import ru.d_shap.assertions.primitive.LongAsStringConverter;
import ru.d_shap.assertions.primitive.ShortAsStringConverter;

/**
 * Class to convert the value to the string representation.
 *
 * @author Dmitry Shapovalov
 */
final class AsStringConverter {

    private static final List<BaseAsStringConverter> CONVERTERS;

    static {
        CONVERTERS = new LinkedList<>();

        registerAsStringConverter(new BooleanAsStringConverter());
        registerAsStringConverter(new ByteAsStringConverter());
        registerAsStringConverter(new CharAsStringConverter());
        registerAsStringConverter(new FloatAsStringConverter());
        registerAsStringConverter(new LongAsStringConverter());
        registerAsStringConverter(new ShortAsStringConverter());

        registerAsStringConverter(new ClassAsStringConverter());
        registerAsStringConverter(new IterableAsStringConverter());

        registerAsStringConverter(new CollectionAsStringConverter());
        registerAsStringConverter(new MapAsStringConverter());

        registerAsStringConverter(new BooleanArrayAsStringConverter());
        registerAsStringConverter(new ByteArrayAsStringConverter());
        registerAsStringConverter(new CharArrayAsStringConverter());
        registerAsStringConverter(new DoubleArrayAsStringConverter());
        registerAsStringConverter(new FloatArrayAsStringConverter());
        registerAsStringConverter(new IntArrayAsStringConverter());
        registerAsStringConverter(new LongArrayAsStringConverter());
        registerAsStringConverter(new ObjectArrayAsStringConverter());
        registerAsStringConverter(new ShortArrayAsStringConverter());

        registerAsStringConverter(new ByteBufferAsStringConverter());
        registerAsStringConverter(new CharBufferAsStringConverter());
        registerAsStringConverter(new DoubleBufferAsStringConverter());
        registerAsStringConverter(new FloatBufferAsStringConverter());
        registerAsStringConverter(new IntBufferAsStringConverter());
        registerAsStringConverter(new LongBufferAsStringConverter());
        registerAsStringConverter(new ShortBufferAsStringConverter());
    }

    private AsStringConverter() {
        super();
    }

    static void registerAsStringConverter(final BaseAsStringConverter asStringConverter) {
        CONVERTERS.add(0, asStringConverter);
    }

    static String asString(final Object value) throws ConversionException {
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

    static String asString(final Object value, final Class<?> targetClass, final Object... arguments) throws ConversionException {
        Object convertedValue = ValueConverter.convert(value, targetClass, arguments);
        return asString(convertedValue);
    }

}
