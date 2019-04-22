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
 * Key implementation for the converter cache.
 *
 * @author Dmitry Shapovalov
 */
final class ConverterKey {

    private final Class<?> _clazz1;

    private final Class<?> _clazz2;

    ConverterKey(final Class<?> clazz) {
        super();
        _clazz1 = clazz;
        _clazz2 = clazz;
    }

    ConverterKey(final Class<?> clazz1, final Class<?> clazz2) {
        super();
        _clazz1 = clazz1;
        _clazz2 = clazz2;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ConverterKey)) {
            return false;
        }
        return _clazz1.equals(((ConverterKey) object)._clazz1) && _clazz2.equals(((ConverterKey) object)._clazz2);
    }

    @Override
    public int hashCode() {
        return _clazz1.getName().hashCode() + _clazz2.getName().hashCode();
    }

}
