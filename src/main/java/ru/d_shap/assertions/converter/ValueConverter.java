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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Class to convert the value to the value with the target class.
 *
 * @author Dmitry Shapovalov
 */
public final class ValueConverter {

    private static final List<ValueConverterProvider> CONVERTER_PROVIDERS;

    static {
        CONVERTER_PROVIDERS = new LinkedList<>();
        ServiceLoader<ValueConverterProvider> serviceLoader = ServiceLoader.load(ValueConverterProvider.class);
        Iterator<ValueConverterProvider> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            ValueConverterProvider converterProvider = iterator.next();
            CONVERTER_PROVIDERS.add(converterProvider);
        }
    }

    private static final Map<ConverterKey, ValueConverterProvider> CONVERTER_MAP = new HashMap<>();

    private ValueConverter() {
        super();
    }

    /**
     * Get the value converted to the target class.
     *
     * @param value       the value.
     * @param targetClass the target class.
     * @param arguments   the conversion arguments.
     * @param <V>         the generic type of the value converted to the target class.
     *
     * @return the value converted to the target class (or the same value if conversion cannot be performed).
     *
     * @throws ConversionException wrapper for exceptions, that can occur during conversion.
     */
    @SuppressWarnings("unchecked")
    public static <V> V convert(final Object value, final Class<?> targetClass, final Object... arguments) throws ConversionException {
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
        List<ValueConverterProvider> converterProviders = findConverterProviderCandidates(valueClass, targetClass);
        converterProviders = findMinimumValueClassConverterProviders(valueClass, converterProviders);
        converterProviders = findMinimumTargetClassConverterProviders(targetClass, converterProviders);
        if (converterProviders.isEmpty()) {
            return null;
        } else {
            return converterProviders.get(0);
        }
    }

    private static List<ValueConverterProvider> findConverterProviderCandidates(final Class<?> valueClass, final Class<?> targetClass) {
        List<ValueConverterProvider> result = new LinkedList<>();
        for (ValueConverterProvider converterProvider : CONVERTER_PROVIDERS) {
            boolean valueClassValid = converterProvider.getValueClass().isAssignableFrom(valueClass);
            boolean targetClassValid = converterProvider.getTargetClass().isAssignableFrom(targetClass);
            if (valueClassValid && targetClassValid) {
                result.add(converterProvider);
            }
        }
        return result;
    }

    private static List<ValueConverterProvider> findMinimumValueClassConverterProviders(final Class<?> valueClass, final List<ValueConverterProvider> converterProviders) {
        List<Integer> distanceList = new ArrayList<>(converterProviders.size());
        List<ValueConverterProvider> converterProviderList = new ArrayList<>(converterProviders.size());
        int minimumDistance = ClassDistance.NON_RELATIVE_DISTANCE;

        for (ValueConverterProvider converterProvider : converterProviders) {
            int distance = ClassDistance.getDistance(valueClass, converterProvider.getValueClass());
            distanceList.add(distance);
            converterProviderList.add(converterProvider);
            if (distance >= 0 && (minimumDistance < 0 || minimumDistance > distance)) {
                minimumDistance = distance;
            }
        }

        List<ValueConverterProvider> result = new LinkedList<>();
        if (minimumDistance >= 0) {
            for (int i = 0; i < distanceList.size(); i++) {
                int distance = distanceList.get(i);
                if (distance == minimumDistance) {
                    ValueConverterProvider converterProvider = converterProviderList.get(i);
                    result.add(converterProvider);
                }
            }
        }
        return result;
    }

    private static List<ValueConverterProvider> findMinimumTargetClassConverterProviders(final Class<?> targetClass, final List<ValueConverterProvider> converterProviders) {
        List<Integer> distanceList = new ArrayList<>(converterProviders.size());
        List<ValueConverterProvider> converterProviderList = new ArrayList<>(converterProviders.size());
        int minimumDistance = ClassDistance.NON_RELATIVE_DISTANCE;

        for (ValueConverterProvider converterProvider : converterProviders) {
            int distance = ClassDistance.getDistance(targetClass, converterProvider.getTargetClass());
            distanceList.add(distance);
            converterProviderList.add(converterProvider);
            if (distance >= 0 && (minimumDistance < 0 || minimumDistance > distance)) {
                minimumDistance = distance;
            }
        }

        List<ValueConverterProvider> result = new LinkedList<>();
        if (minimumDistance >= 0) {
            for (int i = 0; i < distanceList.size(); i++) {
                int distance = distanceList.get(i);
                if (distance == minimumDistance) {
                    ValueConverterProvider converterProvider = converterProviderList.get(i);
                    result.add(converterProvider);
                }
            }
        }
        return result;
    }

}
