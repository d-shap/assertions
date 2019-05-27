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

    static <T> void retainSubclassConverters(final List<T> list, final ClassExtractor<T> classExtractor) {
        boolean result;
        do {
            result = retainSubclassConvertersStep(list, classExtractor);
        } while (result);
    }

    private static <T> boolean retainSubclassConvertersStep(final List<T> list, final ClassExtractor<T> classExtractor) {
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            Class<?> clazz = classExtractor.extractClass(element);
            for (int j = 0; j < list.size(); j++) {
                T checkElement = list.get(j);
                Class<?> checkClazz = classExtractor.extractClass(checkElement);
                if (checkClazz.equals(clazz)) {
                    continue;
                }
                if (checkClazz.isAssignableFrom(clazz)) {
                    list.remove(j);
                    return true;
                }
            }
        }
        return false;
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

    static int getDistance(final Class<?> clazz, final Class<?> targetClazz) {
        if (clazz.isInterface()) {
            return getInterfaceDistanceStep(clazz, targetClazz, true, 0);
        } else {
            return getDistanceStep(clazz, targetClazz, 0);
        }
    }

    private static int getInterfaceDistanceStep(final Class<?> clazz, final Class<?> targetClazz, final boolean withSuperObject, final int currentDistance) {
        if (clazz == targetClazz) {
            return currentDistance;
        }
        int distance = NON_RELATIVE_DISTANCE;
        Class<?>[] ifaces = clazz.getInterfaces();
        if (ifaces.length == 0) {
            if (withSuperObject) {
                int ifaceDistance = getDistanceStep(Object.class, targetClazz, currentDistance + 1);
                distance = getMinimumDistance(distance, ifaceDistance);
            }
        } else {
            for (Class<?> iface : ifaces) {
                int ifaceDistance = getInterfaceDistanceStep(iface, targetClazz, withSuperObject, currentDistance + 1);
                distance = getMinimumDistance(distance, ifaceDistance);
            }
        }
        return distance;
    }

    private static int getDistanceStep(final Class<?> clazz, final Class<?> targetClazz, final int currentDistance) {
        if (clazz == targetClazz) {
            return currentDistance;
        }
        if (clazz.isArray() && targetClazz.isArray()) {
            Class<?> componentClazz = clazz.getComponentType();
            Class<?> componentTargetClazz = targetClazz.getComponentType();
            if (componentClazz.isInterface()) {
                return getInterfaceDistanceStep(componentClazz, componentTargetClazz, true, currentDistance);
            } else {
                return getDistanceStep(componentClazz, componentTargetClazz, currentDistance);
            }
        } else {
            int distance = NON_RELATIVE_DISTANCE;
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null) {
                int superclassDistance = getDistanceStep(superclass, targetClazz, currentDistance + 1);
                distance = getMinimumDistance(distance, superclassDistance);
            }
            Class<?>[] ifaces = clazz.getInterfaces();
            for (Class<?> iface : ifaces) {
                int ifaceDistance = getInterfaceDistanceStep(iface, targetClazz, false, currentDistance + 1);
                distance = getMinimumDistance(distance, ifaceDistance);
            }
            return distance;
        }
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
