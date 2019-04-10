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
import java.util.List;

/**
 * Class to select the best matching converter from the list.
 * The best matching converter has the minimum class distance between the converter class and the
 * actual value class. The distance - is the number of classes or interfaces between two classes.
 *
 * @author Dmitry Shapovalov
 */
final class ConverterSelector {

    private static final int NON_RELATIVE_DISTANCE = Integer.MIN_VALUE;

    private ConverterSelector() {
        super();
    }

    static <T> void retainMinimumDistanceConverters(final List<T> list, final Class<?> clazz, final ClassExtractor<T> classExtractor) {
        List<Integer> distances = new ArrayList<>(list.size());
        int minimumDistance = NON_RELATIVE_DISTANCE;

        for (T element : list) {
            Class<?> targetClazz = classExtractor.extractClass(element);
            int distance = getDistance(clazz, targetClazz);
            distances.add(distance);
            minimumDistance = getMinimumDistance(minimumDistance, distance);
        }

        for (int i = distances.size() - 1; i >= 0; i--) {
            int distance = distances.get(i);
            if (!isMinimumDistance(minimumDistance, distance)) {
                list.remove(i);
            }
        }
    }

    static int getDistance(final Class<?> clazz, final Class<?> targetClazz) {
        return getDistanceStep(clazz, targetClazz, 0);
    }

    private static int getDistanceStep(final Class<?> clazz, final Class<?> targetClazz, final int currentDistance) {
        if (clazz == null) {
            return NON_RELATIVE_DISTANCE;
        }
        if (clazz == targetClazz) {
            return currentDistance;
        }

        int distance = getDistanceStep(clazz.getSuperclass(), targetClazz, currentDistance + 1);
        if (clazz.isArray() && targetClazz.isArray()) {
            int componentDistance = getDistanceStep(clazz.getComponentType(), targetClazz.getComponentType(), currentDistance);
            distance = getMinimumDistance(distance, componentDistance);
        }
        Class<?>[] ifaces = clazz.getInterfaces();
        for (Class<?> iface : ifaces) {
            int ifaceDistance = getDistanceStep(iface, targetClazz, currentDistance + 1);
            distance = getMinimumDistance(distance, ifaceDistance);
        }
        return distance;
    }

    private static int getMinimumDistance(final int minimumDistance, final int currentDistance) {
        if (currentDistance >= 0 && (minimumDistance < 0 || minimumDistance > currentDistance)) {
            return currentDistance;
        } else {
            return minimumDistance;
        }
    }

    private static boolean isMinimumDistance(final int minimumDistance, final int currentDistance) {
        return minimumDistance >= 0 && currentDistance <= minimumDistance;
    }

    static <T> T selectConverter(final List<T> list, final ClassExtractor<T> classExtractor) {
        if (list.isEmpty()) {
            return null;
        }
        for (T element : list) {
            Class<?> clazz = classExtractor.extractClass(element);
            if (!clazz.isInterface()) {
                return element;
            }
        }
        return list.get(0);
    }

    /**
     * Interface to extract the class from the object.
     *
     * @param <T> the generic type of the converter.
     *
     * @author Dmitry Shapovalov
     */
    interface ClassExtractor<T> {

        /**
         * Extract the class from the object.
         *
         * @param object the object.
         *
         * @return the extracted class.
         */
        Class<?> extractClass(T object);

    }

}
