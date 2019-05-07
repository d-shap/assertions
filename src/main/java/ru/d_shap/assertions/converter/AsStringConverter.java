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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import ru.d_shap.assertions.Messages;

/**
 * Class to convert the value to the string representation of the value.
 *
 * @author Dmitry Shapovalov
 */
public final class AsStringConverter {

    private static final List<AsStringConverterProvider> CONVERTER_PROVIDERS;

    static {
        CONVERTER_PROVIDERS = new LinkedList<>();
        ServiceLoader<AsStringConverterProvider> serviceLoader = ServiceLoader.load(AsStringConverterProvider.class);
        Iterator<AsStringConverterProvider> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            AsStringConverterProvider converterProvider = iterator.next();
            CONVERTER_PROVIDERS.add(converterProvider);
        }
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
