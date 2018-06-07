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
package ru.d_shap.assertions;

import java.util.ArrayList;
import java.util.List;

import ru.d_shap.assertions.array.BooleanArrayAsStringConverter;
import ru.d_shap.assertions.collection.CollectionAsStringConverter;
import ru.d_shap.assertions.collection.MapAsStringConverter;
import ru.d_shap.assertions.core.ClassAsStringConverter;
import ru.d_shap.assertions.primitive.CharAsStringConverter;

/**
 * Class to convert value to the string representation.
 *
 * @author Dmitry Shapovalov
 */
final class AsStringConverter {

    private static final List<BaseAsStringConverter> CONVERTERS;

    static {
        CONVERTERS = new ArrayList<>(5);
        CONVERTERS.add(new CharAsStringConverter());
        CONVERTERS.add(new ClassAsStringConverter());
        CONVERTERS.add(new CollectionAsStringConverter());
        CONVERTERS.add(new MapAsStringConverter());
        CONVERTERS.add(new BooleanArrayAsStringConverter());
    }

    private AsStringConverter() {
        super();
    }

    static String asString(final Object value) {
        if (value == null) {
            return null;
        }
        Class<?> valueClass = value.getClass();
        for (int i = 0; i < CONVERTERS.size(); i++) {
            BaseAsStringConverter converter = CONVERTERS.get(i);
            if (converter.getValueClass().isAssignableFrom(valueClass)) {
                return converter.asString(value);
            }
        }
        return value.toString();
    }

    static String asString(final Object value, final Class<?> targetClass) {
        Object convertedObject = ValueConverter.convert(value, targetClass);
        return asString(convertedObject);
    }

}
