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

/**
 * Class to define distance between two classes.
 *
 * @author Dmitry Shapovalov
 */
final class ClassDistance {

    private static final int NON_RELATIVE_DISTANCE = Integer.MIN_VALUE;

    private ClassDistance() {
        super();
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
        Class<?>[] ifaces = clazz.getInterfaces();
        for (Class<?> iface : ifaces) {
            int ifaceDistance = getDistanceStep(iface, targetClazz, currentDistance + 1);
            if (ifaceDistance >= 0 && (distance < 0 || distance > ifaceDistance)) {
                distance = ifaceDistance;
            }
        }
        return distance;
    }

}
