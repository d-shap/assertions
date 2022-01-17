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

import ru.d_shap.assertions.Messages;
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
import ru.d_shap.assertions.asimp.java.util.MapAsStringConverter;
import ru.d_shap.assertions.asimp.java.util.TimeZoneAsStringConverter;
import ru.d_shap.assertions.asimp.org.w3c.dom.AttrAsStringConverter;
import ru.d_shap.assertions.asimp.org.w3c.dom.NodeAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.BooleanAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.ByteAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.CharAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.DoubleAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.FloatAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.LongAsStringConverter;
import ru.d_shap.assertions.asimp.primitive.ShortAsStringConverter;

/**
 * Class to convert the value to the string representation of the value.
 *
 * @author Dmitry Shapovalov
 */
public final class AsStringConverter {

    private static final List<AsStringConverterProvider> CONVERTER_PROVIDERS;

    static {
        CONVERTER_PROVIDERS = new LinkedList<>();

        CONVERTER_PROVIDERS.add(new BooleanAsStringConverter());
        CONVERTER_PROVIDERS.add(new ByteAsStringConverter());
        CONVERTER_PROVIDERS.add(new CharAsStringConverter());
        CONVERTER_PROVIDERS.add(new DoubleAsStringConverter());
        CONVERTER_PROVIDERS.add(new FloatAsStringConverter());
        CONVERTER_PROVIDERS.add(new LongAsStringConverter());
        CONVERTER_PROVIDERS.add(new ShortAsStringConverter());

        CONVERTER_PROVIDERS.add(new ClassAsStringConverter());
        CONVERTER_PROVIDERS.add(new IterableAsStringConverter());

        CONVERTER_PROVIDERS.add(new MapAsStringConverter());
        CONVERTER_PROVIDERS.add(new TimeZoneAsStringConverter());

        CONVERTER_PROVIDERS.add(new BooleanArrayAsStringConverter());
        CONVERTER_PROVIDERS.add(new ByteArrayAsStringConverter());
        CONVERTER_PROVIDERS.add(new CharArrayAsStringConverter());
        CONVERTER_PROVIDERS.add(new DoubleArrayAsStringConverter());
        CONVERTER_PROVIDERS.add(new FloatArrayAsStringConverter());
        CONVERTER_PROVIDERS.add(new IntArrayAsStringConverter());
        CONVERTER_PROVIDERS.add(new LongArrayAsStringConverter());
        CONVERTER_PROVIDERS.add(new ObjectArrayAsStringConverter());
        CONVERTER_PROVIDERS.add(new ShortArrayAsStringConverter());

        CONVERTER_PROVIDERS.add(new ByteBufferAsStringConverter());
        CONVERTER_PROVIDERS.add(new CharBufferAsStringConverter());
        CONVERTER_PROVIDERS.add(new DoubleBufferAsStringConverter());
        CONVERTER_PROVIDERS.add(new FloatBufferAsStringConverter());
        CONVERTER_PROVIDERS.add(new IntBufferAsStringConverter());
        CONVERTER_PROVIDERS.add(new LongBufferAsStringConverter());
        CONVERTER_PROVIDERS.add(new ShortBufferAsStringConverter());

        CONVERTER_PROVIDERS.add(new AttrAsStringConverter());
        CONVERTER_PROVIDERS.add(new NodeAsStringConverter());
    }

    private static final Map<ConverterKey, AsStringConverterProvider> CONVERTER_MAP = new HashMap<>();

    private static final ConverterSelector.ClassExtractor<AsStringConverterProvider> VALUE_CLASS_EXTRACTOR = new ValueClassExtractor();

    private AsStringConverter() {
        super();
    }

    /**
     * Get the string representation of the value.
     *
     * @param value the value.
     *
     * @return the string representation of the value.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    public static String asString(final Object value) throws ConversionException {
        if (value == null) {
            return Messages.NULL;
        }
        Class<?> valueClass = value.getClass();
        AsStringConverterProvider converterProvider = getConverterProvider(valueClass);
        if (converterProvider == null) {
            return value.toString();
        } else {
            return converterProvider.asString(value);
        }
    }

    /**
     * Get the string representation of the value.
     *
     * @param value       the value.
     * @param targetClass the target class.
     * @param arguments   the conversion arguments.
     *
     * @return the string representation of the value.
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    public static String asString(final Object value, final Class<?> targetClass, final Object... arguments) throws ConversionException {
        Object convertedValue = ValueConverter.convert(value, targetClass, arguments);
        return asString(convertedValue);
    }

    private static AsStringConverterProvider getConverterProvider(final Class<?> valueClass) {
        ConverterKey converterKey = new ConverterKey(valueClass);
        if (CONVERTER_MAP.containsKey(converterKey)) {
            return CONVERTER_MAP.get(converterKey);
        } else {
            AsStringConverterProvider converterProvider = findConverterProvider(valueClass);
            CONVERTER_MAP.put(converterKey, converterProvider);
            return converterProvider;
        }
    }

    private static AsStringConverterProvider findConverterProvider(final Class<?> valueClass) {
        List<AsStringConverterProvider> converterProviders = new LinkedList<>();
        for (AsStringConverterProvider converterProvider : CONVERTER_PROVIDERS) {
            boolean valueClassValid = converterProvider.getValueClass().isAssignableFrom(valueClass);
            if (valueClassValid) {
                converterProviders.add(converterProvider);
            }
        }
        ConverterSelector.retainSubclassConverters(converterProviders, VALUE_CLASS_EXTRACTOR);
        ConverterSelector.retainMinimumDistanceConverters(converterProviders, valueClass, VALUE_CLASS_EXTRACTOR);
        return ConverterSelector.selectConverter(converterProviders, VALUE_CLASS_EXTRACTOR);
    }

    /**
     * Value class extractor.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ValueClassExtractor implements ConverterSelector.ClassExtractor<AsStringConverterProvider> {

        ValueClassExtractor() {
            super();
        }

        @Override
        public Class<?> extractClass(final AsStringConverterProvider converterProvider) {
            return converterProvider.getValueClass();
        }

    }

}
