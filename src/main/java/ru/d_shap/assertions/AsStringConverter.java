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
import ru.d_shap.assertions.array.ByteArrayAsStringConverter;
import ru.d_shap.assertions.array.CharArrayAsStringConverter;
import ru.d_shap.assertions.array.DoubleArrayAsStringConverter;
import ru.d_shap.assertions.array.FloatArrayAsStringConverter;
import ru.d_shap.assertions.array.IntArrayAsStringConverter;
import ru.d_shap.assertions.array.LongArrayAsStringConverter;
import ru.d_shap.assertions.array.ObjectArrayAsStringConverter;
import ru.d_shap.assertions.array.ShortArrayAsStringConverter;
import ru.d_shap.assertions.collection.CollectionAsStringConverter;
import ru.d_shap.assertions.collection.MapAsStringConverter;
import ru.d_shap.assertions.core.ClassAsStringConverter;
import ru.d_shap.assertions.core.IterableAsStringConverter;
import ru.d_shap.assertions.primitive.CharAsStringConverter;

/**
 * Class to convert the value to the string representation.
 *
 * @author Dmitry Shapovalov
 */
final class AsStringConverter {

    private static final List<BaseAsStringConverter> CONVERTERS;

    static {
        CONVERTERS = new ArrayList<>(14);

        CONVERTERS.add(new CharAsStringConverter());

        CONVERTERS.add(new ClassAsStringConverter());
        CONVERTERS.add(new IterableAsStringConverter());

        CONVERTERS.add(new CollectionAsStringConverter());
        CONVERTERS.add(new MapAsStringConverter());

        CONVERTERS.add(new BooleanArrayAsStringConverter());
        CONVERTERS.add(new ByteArrayAsStringConverter());
        CONVERTERS.add(new CharArrayAsStringConverter());
        CONVERTERS.add(new DoubleArrayAsStringConverter());
        CONVERTERS.add(new FloatArrayAsStringConverter());
        CONVERTERS.add(new IntArrayAsStringConverter());
        CONVERTERS.add(new LongArrayAsStringConverter());
        CONVERTERS.add(new ObjectArrayAsStringConverter());
        CONVERTERS.add(new ShortArrayAsStringConverter());
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
            BaseAsStringConverter asStringConverter = CONVERTERS.get(i);
            if (asStringConverter.getValueClass().isAssignableFrom(valueClass)) {
                return asStringConverter.asString(value);
            }
        }
        return value.toString();
    }

    static String asString(final Object value, final Class<?> targetClass, final Object... arguments) {
        Object convertedValue = ValueConverter.convert(value, targetClass, arguments);
        return asString(convertedValue);
    }

}
