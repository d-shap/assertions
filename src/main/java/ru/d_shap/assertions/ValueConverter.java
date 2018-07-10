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

import ru.d_shap.assertions.array.BooleanArrayToListValueConverter;
import ru.d_shap.assertions.array.ByteArrayToListValueConverter;
import ru.d_shap.assertions.array.CharArrayToListValueConverter;
import ru.d_shap.assertions.array.DoubleArrayToListValueConverter;
import ru.d_shap.assertions.array.FloatArrayToListValueConverter;
import ru.d_shap.assertions.array.IntArrayToByteArrayValueConverter;
import ru.d_shap.assertions.array.IntArrayToCharArrayValueConverter;
import ru.d_shap.assertions.array.IntArrayToListValueConverter;
import ru.d_shap.assertions.array.IntArrayToShortArrayValueConverter;
import ru.d_shap.assertions.array.LongArrayToListValueConverter;
import ru.d_shap.assertions.array.ObjectArrayToListValueConverter;
import ru.d_shap.assertions.array.ShortArrayToListValueConverter;
import ru.d_shap.assertions.collection.IteratorToListValueConverter;
import ru.d_shap.assertions.collection.SetToListValueConverter;
import ru.d_shap.assertions.collection.SortedMapToMapValueConverter;
import ru.d_shap.assertions.collection.SortedSetToSetValueConverter;
import ru.d_shap.assertions.core.IterableToListValueConverter;
import ru.d_shap.assertions.io.InputStreamToByteArrayValueConverter;
import ru.d_shap.assertions.io.InputStreamToIntValueConverter;
import ru.d_shap.assertions.io.InputStreamToLongValueConverter;
import ru.d_shap.assertions.io.ReaderToCharArrayValueConverter;
import ru.d_shap.assertions.io.ReaderToIntValueConverter;
import ru.d_shap.assertions.io.ReaderToLongValueConverter;
import ru.d_shap.assertions.nio.ByteBufferToByteArrayValueConverter;
import ru.d_shap.assertions.nio.CharBufferToCharArrayValueConverter;
import ru.d_shap.assertions.nio.DoubleBufferToDoubleArrayValueConverter;
import ru.d_shap.assertions.nio.FloatBufferToFloatArrayValueConverter;
import ru.d_shap.assertions.nio.IntBufferToIntArrayValueConverter;
import ru.d_shap.assertions.nio.LongBufferToLongArrayValueConverter;
import ru.d_shap.assertions.nio.ShortBufferToShortArrayValueConverter;
import ru.d_shap.assertions.primitive.IntToByteValueConverter;
import ru.d_shap.assertions.primitive.IntToCharValueConverter;
import ru.d_shap.assertions.primitive.IntToShortValueConverter;

/**
 * Class to convert the value to the value with the target class.
 *
 * @author Dmitry Shapovalov
 */
final class ValueConverter {

    private static final List<BaseValueConverter> CONVERTERS;

    static {
        CONVERTERS = new LinkedList<>();

        registerValueConverter(new IntToByteValueConverter());
        registerValueConverter(new IntToCharValueConverter());
        registerValueConverter(new IntToShortValueConverter());

        registerValueConverter(new IterableToListValueConverter());

        registerValueConverter(new IteratorToListValueConverter());
        registerValueConverter(new SetToListValueConverter());
        registerValueConverter(new SortedSetToSetValueConverter());
        registerValueConverter(new SortedMapToMapValueConverter());

        registerValueConverter(new BooleanArrayToListValueConverter());
        registerValueConverter(new ByteArrayToListValueConverter());
        registerValueConverter(new CharArrayToListValueConverter());
        registerValueConverter(new DoubleArrayToListValueConverter());
        registerValueConverter(new FloatArrayToListValueConverter());
        registerValueConverter(new IntArrayToByteArrayValueConverter());
        registerValueConverter(new IntArrayToCharArrayValueConverter());
        registerValueConverter(new IntArrayToListValueConverter());
        registerValueConverter(new IntArrayToShortArrayValueConverter());
        registerValueConverter(new LongArrayToListValueConverter());
        registerValueConverter(new ObjectArrayToListValueConverter());
        registerValueConverter(new ShortArrayToListValueConverter());

        registerValueConverter(new ByteBufferToByteArrayValueConverter());
        registerValueConverter(new CharBufferToCharArrayValueConverter());
        registerValueConverter(new DoubleBufferToDoubleArrayValueConverter());
        registerValueConverter(new FloatBufferToFloatArrayValueConverter());
        registerValueConverter(new IntBufferToIntArrayValueConverter());
        registerValueConverter(new LongBufferToLongArrayValueConverter());
        registerValueConverter(new ShortBufferToShortArrayValueConverter());

        registerValueConverter(new InputStreamToByteArrayValueConverter());
        registerValueConverter(new InputStreamToIntValueConverter());
        registerValueConverter(new InputStreamToLongValueConverter());
        registerValueConverter(new ReaderToCharArrayValueConverter());
        registerValueConverter(new ReaderToIntValueConverter());
        registerValueConverter(new ReaderToLongValueConverter());
    }

    private ValueConverter() {
        super();
    }

    static void registerValueConverter(final BaseValueConverter valueConverter) {
        CONVERTERS.add(0, valueConverter);
    }

    @SuppressWarnings("unchecked")
    static <V> V convert(final Object value, final Class<?> targetClass, final Object... arguments) throws ConvertionException {
        if (value == null) {
            return null;
        }
        Class<?> valueClass = value.getClass();
        for (BaseValueConverter valueConverter : CONVERTERS) {
            boolean valueClassValid = valueConverter.getValueClass().isAssignableFrom(valueClass);
            boolean targetClassValid = valueConverter.getTargetClass().isAssignableFrom(targetClass);
            if (valueClassValid && targetClassValid) {
                boolean canConvert = valueConverter.canConvert(value, arguments);
                if (canConvert) {
                    return (V) valueConverter.convert(value, arguments);
                } else {
                    return (V) value;
                }
            }
        }
        return (V) value;
    }

}
