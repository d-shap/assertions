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

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Class to convert the value to the string representation.
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

    private AsStringConverter() {
        super();
    }

    public static String asString(final Object value) throws ConversionException {
        if (value == null) {
            return null;
        }
        Class<?> valueClass = value.getClass();
        AsStringConverterProvider converterProvider = getConverterProvider(valueClass);
        if (converterProvider == null) {
            return value.toString();
        } else {
            return converterProvider.asString(value);
        }
    }

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
        for (AsStringConverterProvider converterProvider : CONVERTER_PROVIDERS) {
            if (converterProvider.getValueClass().isAssignableFrom(valueClass)) {
                return converterProvider;
            }
        }
        return null;
    }

}
