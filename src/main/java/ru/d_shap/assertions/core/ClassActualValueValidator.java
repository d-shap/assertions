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
package ru.d_shap.assertions.core;

import ru.d_shap.assertions.BaseActualValueValidator;

/**
 * Validator for the actual value. Check if the actual value is instance of the specified class.
 *
 * @author Dmitry Shapovalov
 */
public class ClassActualValueValidator extends BaseActualValueValidator {

    private final Class<?> _clazz;

    /**
     * Create new object.
     *
     * @param clazz the specified class.
     */
    public ClassActualValueValidator(final Class<?> clazz) {
        super();
        _clazz = clazz;
    }

    @Override
    protected final boolean isValid(final Object actual) {
        return _clazz.isInstance(actual);
    }

}