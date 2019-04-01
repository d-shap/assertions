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

import ru.d_shap.assertions.asimp.array.BooleanArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.BooleanArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.ByteArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.ByteArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.CharArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.CharArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.DoubleArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.DoubleArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.FloatArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.FloatArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.IntArrayToByteArrayValueConverter;
import ru.d_shap.assertions.asimp.array.IntArrayToCharArrayValueConverter;
import ru.d_shap.assertions.asimp.array.IntArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.IntArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.IntArrayToShortArrayValueConverter;
import ru.d_shap.assertions.asimp.array.LongArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.LongArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.ObjectArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.ShortArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.ShortArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.java.io.InputStreamToByteArrayValueConverter;
import ru.d_shap.assertions.asimp.java.io.InputStreamToIntValueConverter;
import ru.d_shap.assertions.asimp.java.io.ReaderToCharArrayValueConverter;
import ru.d_shap.assertions.asimp.java.io.ReaderToIntValueConverter;
import ru.d_shap.assertions.asimp.java.lang.IterableToListValueConverter;
import ru.d_shap.assertions.asimp.java.nio.ByteBufferToByteArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.CharBufferToCharArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.DoubleBufferToDoubleArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.FloatBufferToFloatArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.IntBufferToIntArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.LongBufferToLongArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.ShortBufferToShortArrayValueConverter;
import ru.d_shap.assertions.asimp.java.util.IteratorToListValueConverter;
import ru.d_shap.assertions.asimp.java.util.SetToListValueConverter;
import ru.d_shap.assertions.asimp.primitive.IntToByteValueConverter;
import ru.d_shap.assertions.asimp.primitive.IntToCharValueConverter;
import ru.d_shap.assertions.asimp.primitive.IntToShortValueConverter;

/**
 * Class to convert the value to the value with the target class.
 *
 * @author Dmitry Shapovalov
 */
public final class ValueConverter {

    private static final List<BaseValueConverter> CONVERTERS;

    static {
        CONVERTERS = new LinkedList<>();

        registerValueConverter(new IntToByteValueConverter());
        registerValueConverter(new IntToCharValueConverter());
        registerValueConverter(new IntToShortValueConverter());

        registerValueConverter(new IterableToListValueConverter());

        registerValueConverter(new IteratorToListValueConverter());
        registerValueConverter(new SetToListValueConverter());

        registerValueConverter(new BooleanArrayToListValueConverter());
        registerValueConverter(new BooleanArrayToObjectArrayValueConverter());
        registerValueConverter(new ByteArrayToListValueConverter());
        registerValueConverter(new ByteArrayToObjectArrayValueConverter());
        registerValueConverter(new CharArrayToListValueConverter());
        registerValueConverter(new CharArrayToObjectArrayValueConverter());
        registerValueConverter(new DoubleArrayToListValueConverter());
        registerValueConverter(new DoubleArrayToObjectArrayValueConverter());
        registerValueConverter(new FloatArrayToListValueConverter());
        registerValueConverter(new FloatArrayToObjectArrayValueConverter());
        registerValueConverter(new IntArrayToByteArrayValueConverter());
        registerValueConverter(new IntArrayToCharArrayValueConverter());
        registerValueConverter(new IntArrayToListValueConverter());
        registerValueConverter(new IntArrayToObjectArrayValueConverter());
        registerValueConverter(new IntArrayToShortArrayValueConverter());
        registerValueConverter(new LongArrayToListValueConverter());
        registerValueConverter(new LongArrayToObjectArrayValueConverter());
        registerValueConverter(new ObjectArrayToListValueConverter());
        registerValueConverter(new ShortArrayToListValueConverter());
        registerValueConverter(new ShortArrayToObjectArrayValueConverter());

        registerValueConverter(new ByteBufferToByteArrayValueConverter());
        registerValueConverter(new CharBufferToCharArrayValueConverter());
        registerValueConverter(new DoubleBufferToDoubleArrayValueConverter());
        registerValueConverter(new FloatBufferToFloatArrayValueConverter());
        registerValueConverter(new IntBufferToIntArrayValueConverter());
        registerValueConverter(new LongBufferToLongArrayValueConverter());
        registerValueConverter(new ShortBufferToShortArrayValueConverter());

        registerValueConverter(new InputStreamToByteArrayValueConverter());
        registerValueConverter(new InputStreamToIntValueConverter());
        registerValueConverter(new ReaderToCharArrayValueConverter());
        registerValueConverter(new ReaderToIntValueConverter());
    }

    private ValueConverter() {
        super();
    }

    static void registerValueConverter(final BaseValueConverter valueConverter) {
        ((LinkedList<BaseValueConverter>) CONVERTERS).addFirst(valueConverter);
    }

    @SuppressWarnings("unchecked")
    public static <V> V convert(final Object value, final Class<?> targetClass, final Object... arguments) throws ConversionException {
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
