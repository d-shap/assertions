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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Class to convert the value to the string representation.
 *
 * @author Dmitry Shapovalov
 */
public final class AsStringConverter {

    private static final List<AsStringConverterProvider> AS_STRING_CONVERTER_PROVIDERS;

    static {
        List<AsStringConverterProvider> converterProviders = new LinkedList<>();
        ServiceLoader<AsStringConverterProvider> serviceLoader = ServiceLoader.load(AsStringConverterProvider.class);
        for (Iterator<AsStringConverterProvider> iterator = serviceLoader.iterator(); iterator.hasNext(); ) {
            AsStringConverterProvider asStringConverterProvider = iterator.next();
            converterProviders.add(asStringConverterProvider);
        }
        converterProviders = new ArrayList<>(converterProviders);
        AS_STRING_CONVERTER_PROVIDERS = Collections.unmodifiableList(converterProviders);
    }

    private AsStringConverter() {
        super();
    }

    public static String asString(final Object value) throws ConversionException {
        if (value == null) {
            return null;
        }
        Class<?> valueClass = value.getClass();
        for (AsStringConverterProvider asStringConverter : AS_STRING_CONVERTER_PROVIDERS) {
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
