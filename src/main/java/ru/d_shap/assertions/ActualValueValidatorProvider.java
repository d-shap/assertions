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

import ru.d_shap.assertions.fail.AssertionErrorBuilder;

/**
 * Service provider interface for the actual value validator.
 *
 * @author Dmitry Shapovalov
 */
public interface ActualValueValidatorProvider {

    /**
     * Check if the actual value is valid.
     *
     * @param actual the actual value.
     *
     * @return true, if the actual value is valid.
     */
    boolean isValid(Object actual);

    /**
     * Get the fail value.
     *
     * @param actual the actual value.
     *
     * @return the fail value.
     */
    Object getFailValue(Object actual);

    /**
     * Add the message to the assertion error.
     *
     * @param assertionErrorBuilder builder for the assertion error.
     */
    void addFailMessage(AssertionErrorBuilder assertionErrorBuilder);

}
