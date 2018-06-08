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

import ru.d_shap.assertions.array.BooleanArrayToListValueConverter;
import ru.d_shap.assertions.array.ByteArrayToListValueConverter;
import ru.d_shap.assertions.array.CharArrayToListValueConverter;
import ru.d_shap.assertions.array.DoubleArrayToListValueConverter;
import ru.d_shap.assertions.array.FloatArrayToListValueConverter;
import ru.d_shap.assertions.array.IntArrayToListValueConverter;
import ru.d_shap.assertions.array.LongArrayToListValueConverter;
import ru.d_shap.assertions.array.ObjectArrayToListValueConverter;
import ru.d_shap.assertions.array.ShortArrayToListValueConverter;
import ru.d_shap.assertions.primitive.IntToByteValueConverter;
import ru.d_shap.assertions.primitive.IntToCharValueConverter;
import ru.d_shap.assertions.primitive.IntToShortValueConverter;

/**
 * Class to convert value to the value with the target class.
 *
 * @author Dmitry Shapovalov
 */
final class ValueConverter {

    private static final List<BaseValueConverter> CONVERTERS;

    static {
        CONVERTERS = new ArrayList<>(9);

        CONVERTERS.add(new IntToByteValueConverter());
        CONVERTERS.add(new IntToCharValueConverter());
        CONVERTERS.add(new IntToShortValueConverter());

        CONVERTERS.add(new BooleanArrayToListValueConverter());
        CONVERTERS.add(new ByteArrayToListValueConverter());
        CONVERTERS.add(new CharArrayToListValueConverter());
        CONVERTERS.add(new DoubleArrayToListValueConverter());
        CONVERTERS.add(new FloatArrayToListValueConverter());
        CONVERTERS.add(new IntArrayToListValueConverter());
        CONVERTERS.add(new LongArrayToListValueConverter());
        CONVERTERS.add(new ObjectArrayToListValueConverter());
        CONVERTERS.add(new ShortArrayToListValueConverter());
    }

    private ValueConverter() {
        super();
    }

    static Object convert(final Object value, final Class<?> targetClass) {
        if (value == null) {
            return null;
        }
        Class<?> valueClass = value.getClass();
        for (int i = 0; i < CONVERTERS.size(); i++) {
            BaseValueConverter converter = CONVERTERS.get(i);
            boolean valueClassValid = converter.getValueClass().isAssignableFrom(valueClass);
            boolean targetClassValid = converter.getTargetClass().isAssignableFrom(targetClass);
            boolean canConvert = valueClassValid && targetClassValid && converter.canConvert(value);
            if (canConvert) {
                return converter.convert(value);
            }
        }
        return value;
    }

}
