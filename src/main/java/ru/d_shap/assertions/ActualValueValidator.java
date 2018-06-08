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

/**
 * Class to validate the actual value.
 *
 * @author Dmitry Shapovalov
 */
final class ActualValueValidator {

    private final List<BaseActualValueValidator> _actualValueValidators;

    ActualValueValidator() {
        super();
        _actualValueValidators = new ArrayList<>();
    }

    void addActualValueValidator(final BaseActualValueValidator actualValueValidator) {
        _actualValueValidators.add(actualValueValidator);
    }

    boolean isValid(final Object actual) {
        if (actual == null) {
            return true;
        } else {
            for (BaseActualValueValidator actualValueValidator : _actualValueValidators) {
                if (!actualValueValidator.isValid(actual)) {
                    return false;
                }
            }
            return true;
        }
    }

}
