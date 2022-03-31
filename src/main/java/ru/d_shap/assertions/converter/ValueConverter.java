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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ru.d_shap.assertions.asimp.array.BooleanArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.BooleanArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.ByteArrayToHexStringValueConverter;
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
import ru.d_shap.assertions.asimp.array.IntArrayToHexStringValueConverter;
import ru.d_shap.assertions.asimp.array.IntArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.IntArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.IntArrayToShortArrayValueConverter;
import ru.d_shap.assertions.asimp.array.LongArrayToHexStringValueConverter;
import ru.d_shap.assertions.asimp.array.LongArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.LongArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.array.ObjectArrayToClassArrayValueConverter;
import ru.d_shap.assertions.asimp.array.ObjectArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.ShortArrayToHexStringValueConverter;
import ru.d_shap.assertions.asimp.array.ShortArrayToListValueConverter;
import ru.d_shap.assertions.asimp.array.ShortArrayToObjectArrayValueConverter;
import ru.d_shap.assertions.asimp.java.io.BufferedReaderToStringArrayValueConverter;
import ru.d_shap.assertions.asimp.java.io.InputStreamToByteArrayValueConverter;
import ru.d_shap.assertions.asimp.java.io.ReaderToCharArrayValueConverter;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceToDocumentValueConverter;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceToElementValueConverter;
import ru.d_shap.assertions.asimp.java.lang.ClassToClassValueConverter;
import ru.d_shap.assertions.asimp.java.lang.IterableToListValueConverter;
import ru.d_shap.assertions.asimp.java.lang.ObjectToClassValueConverter;
import ru.d_shap.assertions.asimp.java.nio.ByteBufferToByteArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.CharBufferToCharArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.DoubleBufferToDoubleArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.FloatBufferToFloatArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.IntBufferToIntArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.LongBufferToLongArrayValueConverter;
import ru.d_shap.assertions.asimp.java.nio.ShortBufferToShortArrayValueConverter;
import ru.d_shap.assertions.asimp.java.util.DateToCalendarValueConverter;
import ru.d_shap.assertions.asimp.java.util.IteratorToListValueConverter;
import ru.d_shap.assertions.asimp.javax.xml.datatype.XMLGregorianCalendarToCalendarValueConverter;
import ru.d_shap.assertions.asimp.primitive.ByteToHexStringValueConverter;
import ru.d_shap.assertions.asimp.primitive.IntToByteValueConverter;
import ru.d_shap.assertions.asimp.primitive.IntToCharValueConverter;
import ru.d_shap.assertions.asimp.primitive.IntToHexStringValueConverter;
import ru.d_shap.assertions.asimp.primitive.IntToShortValueConverter;
import ru.d_shap.assertions.asimp.primitive.LongToHexStringValueConverter;
import ru.d_shap.assertions.asimp.primitive.ShortToHexStringValueConverter;

/**
 * Class to convert the value to the value with the target class.
 *
 * @author Dmitry Shapovalov
 */
public final class ValueConverter {

    private static final List<ValueConverterProvider> CONVERTER_PROVIDERS;

    static {
        CONVERTER_PROVIDERS = new LinkedList<>();

        CONVERTER_PROVIDERS.add(new ByteToHexStringValueConverter());
        CONVERTER_PROVIDERS.add(new IntToByteValueConverter());
        CONVERTER_PROVIDERS.add(new IntToCharValueConverter());
        CONVERTER_PROVIDERS.add(new IntToHexStringValueConverter());
        CONVERTER_PROVIDERS.add(new IntToShortValueConverter());
        CONVERTER_PROVIDERS.add(new LongToHexStringValueConverter());
        CONVERTER_PROVIDERS.add(new ShortToHexStringValueConverter());

        CONVERTER_PROVIDERS.add(new CharSequenceToDocumentValueConverter());
        CONVERTER_PROVIDERS.add(new CharSequenceToElementValueConverter());
        CONVERTER_PROVIDERS.add(new ClassToClassValueConverter());
        CONVERTER_PROVIDERS.add(new IterableToListValueConverter());
        CONVERTER_PROVIDERS.add(new ObjectToClassValueConverter());

        CONVERTER_PROVIDERS.add(new DateToCalendarValueConverter());
        CONVERTER_PROVIDERS.add(new IteratorToListValueConverter());

        CONVERTER_PROVIDERS.add(new BooleanArrayToListValueConverter());
        CONVERTER_PROVIDERS.add(new BooleanArrayToObjectArrayValueConverter());
        CONVERTER_PROVIDERS.add(new ByteArrayToHexStringValueConverter());
        CONVERTER_PROVIDERS.add(new ByteArrayToListValueConverter());
        CONVERTER_PROVIDERS.add(new ByteArrayToObjectArrayValueConverter());
        CONVERTER_PROVIDERS.add(new CharArrayToListValueConverter());
        CONVERTER_PROVIDERS.add(new CharArrayToObjectArrayValueConverter());
        CONVERTER_PROVIDERS.add(new DoubleArrayToListValueConverter());
        CONVERTER_PROVIDERS.add(new DoubleArrayToObjectArrayValueConverter());
        CONVERTER_PROVIDERS.add(new FloatArrayToListValueConverter());
        CONVERTER_PROVIDERS.add(new FloatArrayToObjectArrayValueConverter());
        CONVERTER_PROVIDERS.add(new IntArrayToByteArrayValueConverter());
        CONVERTER_PROVIDERS.add(new IntArrayToCharArrayValueConverter());
        CONVERTER_PROVIDERS.add(new IntArrayToHexStringValueConverter());
        CONVERTER_PROVIDERS.add(new IntArrayToListValueConverter());
        CONVERTER_PROVIDERS.add(new IntArrayToObjectArrayValueConverter());
        CONVERTER_PROVIDERS.add(new IntArrayToShortArrayValueConverter());
        CONVERTER_PROVIDERS.add(new LongArrayToHexStringValueConverter());
        CONVERTER_PROVIDERS.add(new LongArrayToListValueConverter());
        CONVERTER_PROVIDERS.add(new LongArrayToObjectArrayValueConverter());
        CONVERTER_PROVIDERS.add(new ObjectArrayToClassArrayValueConverter());
        CONVERTER_PROVIDERS.add(new ObjectArrayToListValueConverter());
        CONVERTER_PROVIDERS.add(new ShortArrayToHexStringValueConverter());
        CONVERTER_PROVIDERS.add(new ShortArrayToListValueConverter());
        CONVERTER_PROVIDERS.add(new ShortArrayToObjectArrayValueConverter());

        CONVERTER_PROVIDERS.add(new BufferedReaderToStringArrayValueConverter());
        CONVERTER_PROVIDERS.add(new InputStreamToByteArrayValueConverter());
        CONVERTER_PROVIDERS.add(new ReaderToCharArrayValueConverter());

        CONVERTER_PROVIDERS.add(new ByteBufferToByteArrayValueConverter());
        CONVERTER_PROVIDERS.add(new CharBufferToCharArrayValueConverter());
        CONVERTER_PROVIDERS.add(new DoubleBufferToDoubleArrayValueConverter());
        CONVERTER_PROVIDERS.add(new FloatBufferToFloatArrayValueConverter());
        CONVERTER_PROVIDERS.add(new IntBufferToIntArrayValueConverter());
        CONVERTER_PROVIDERS.add(new LongBufferToLongArrayValueConverter());
        CONVERTER_PROVIDERS.add(new ShortBufferToShortArrayValueConverter());

        CONVERTER_PROVIDERS.add(new XMLGregorianCalendarToCalendarValueConverter());
    }

    private static final Map<ConverterKey, ValueConverterProvider> CONVERTER_MAP = new HashMap<>();

    private static final ConverterSelector.ClassExtractor<ValueConverterProvider> VALUE_CLASS_EXTRACTOR = new ValueClassExtractor();

    private static final ConverterSelector.ClassExtractor<ValueConverterProvider> TARGET_CLASS_EXTRACTOR = new TargetClassExtractor();

    private ValueConverter() {
        super();
    }

    /**
     * Get the value converted to the target class (or the same value if conversion cannot be performed).
     *
     * @param value       the value.
     * @param targetClass the target class.
     * @param arguments   the conversion arguments.
     * @param <V>         the generic type of the value converted to the target class.
     *
     * @return the value converted to the target class (or the same value if conversion cannot be performed).
     */
    @SuppressWarnings("unchecked")
    public static <V> V convert(final Object value, final Class<?> targetClass, final Object... arguments) {
        if (value == null) {
            return null;
        }
        Class<?> valueClass = value.getClass();
        ValueConverterProvider converterProvider = getConverterProvider(valueClass, targetClass);
        if (converterProvider == null) {
            return (V) value;
        } else {
            return (V) converterProvider.convert(value, arguments);
        }
    }

    private static ValueConverterProvider getConverterProvider(final Class<?> valueClass, final Class<?> targetClass) {
        ConverterKey converterKey = new ConverterKey(valueClass, targetClass);
        if (CONVERTER_MAP.containsKey(converterKey)) {
            return CONVERTER_MAP.get(converterKey);
        } else {
            ValueConverterProvider converterProvider = findConverterProvider(valueClass, targetClass);
            CONVERTER_MAP.put(converterKey, converterProvider);
            return converterProvider;
        }
    }

    private static ValueConverterProvider findConverterProvider(final Class<?> valueClass, final Class<?> targetClass) {
        List<ValueConverterProvider> converterProviders = new LinkedList<>();
        for (ValueConverterProvider converterProvider : CONVERTER_PROVIDERS) {
            boolean valueClassValid = converterProvider.getValueClass().isAssignableFrom(valueClass);
            boolean targetClassValid = converterProvider.getTargetClass().isAssignableFrom(targetClass);
            if (valueClassValid && targetClassValid) {
                converterProviders.add(converterProvider);
            }
        }
        ConverterSelector.retainSubclassConverters(converterProviders, VALUE_CLASS_EXTRACTOR);
        ConverterSelector.retainSubclassConverters(converterProviders, TARGET_CLASS_EXTRACTOR);
        ConverterSelector.retainMinimumDistanceConverters(converterProviders, valueClass, VALUE_CLASS_EXTRACTOR);
        ConverterSelector.retainMinimumDistanceConverters(converterProviders, targetClass, TARGET_CLASS_EXTRACTOR);
        return ConverterSelector.selectConverter(converterProviders, VALUE_CLASS_EXTRACTOR);
    }

    private static final class ValueClassExtractor implements ConverterSelector.ClassExtractor<ValueConverterProvider> {

        ValueClassExtractor() {
            super();
        }

        @Override
        public Class<?> extractClass(final ValueConverterProvider converterProvider) {
            return converterProvider.getValueClass();
        }

    }

    private static final class TargetClassExtractor implements ConverterSelector.ClassExtractor<ValueConverterProvider> {

        TargetClassExtractor() {
            super();
        }

        @Override
        public Class<?> extractClass(final ValueConverterProvider converterProvider) {
            return converterProvider.getTargetClass();
        }

    }

}
