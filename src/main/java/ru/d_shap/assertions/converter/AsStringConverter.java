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
package ru.d_shap.assertions.converter;

import java.util.LinkedList;
import java.util.List;

import ru.d_shap.assertions.asimp.array.BooleanArrayAsStringConverter;
import ru.d_shap.assertions.asimp.array.ByteArrayAsStringConverter;
import ru.d_shap.assertions.asimp.array.CharArrayAsStringConverter;
import ru.d_shap.assertions.asimp.array.DoubleArrayAsStringConverter;
import ru.d_shap.assertions.asimp.array.FloatArrayAsStringConverter;
import ru.d_shap.assertions.asimp.array.IntArrayAsStringConverter;
import ru.d_shap.assertions.asimp.array.LongArrayAsStringConverter;
import ru.d_shap.assertions.asimp.array.ObjectArrayAsStringConverter;
import ru.d_shap.assertions.asimp.array.ShortArrayAsStringConverter;
import ru.d_shap.assertions.asimp.java.lang.ClassAsStringConverter;
import ru.d_shap.assertions.asimp.java.lang.IterableAsStringConverter;
import ru.d_shap.assertions.asimp.java.nio.ByteBufferAsStringConverter;
import ru.d_shap.assertions.asimp.java.nio.CharBufferAsStringConverter;
import ru.d_shap.assertions.asimp.java.nio.DoubleBufferAsStringConverter;
import ru.d_shap.assertions.asimp.java.nio.FloatBufferAsStringConverter;
import ru.d_shap.assertions.asimp.java.nio.IntBufferAsStringConverter;
import ru.d_shap.assertions.asimp.java.nio.LongBufferAsStringConverter;
import ru.d_shap.assertions.asimp.java.nio.ShortBufferAsStringConverter;
import ru.d_shap.assertions.asimp.java.util.CollectionAsStringConverter;
import ru.d_shap.assertions.asimp.java.util.MapAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.BooleanAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.ByteAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.CharAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.DoubleAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.FloatAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.LongAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.ShortAsStringConverter;

/**
 * Class to convert the value to the string representation.
 *
 * @author Dmitry Shapovalov
 */
public final class AsStringConverter {

    private static final List<BaseAsStringConverter> CONVERTERS;

    static {
        CONVERTERS = new LinkedList<>();

        registerAsStringConverter(new BooleanAsStringConverter());
        registerAsStringConverter(new ByteAsStringConverter());
        registerAsStringConverter(new CharAsStringConverter());
        registerAsStringConverter(new DoubleAsStringConverter());
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
        ((LinkedList<BaseAsStringConverter>) CONVERTERS).addFirst(asStringConverter);
    }

    public static String asString(final Object value) throws ConversionException {
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

    public static String asString(final Object value, final Class<?> targetClass, final Object... arguments) throws ConversionException {
        Object convertedValue = ValueConverter.convert(value, targetClass, arguments);
        return asString(convertedValue);
    }

}
