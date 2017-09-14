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

/**
 * Error is thrown when the assertion class is wrong, i.e. class is abstract, does not have
 * the necessary constructor, etc.
 *
 * @author Dmitry Shapovalov
 */
public final class WrongAssertionClassError extends Error {

    private static final long serialVersionUID = 1L;

    /**
     * Create new object.
     *
     * @param assertionClass assertion class.
     * @param actualClass    actual class.
     */
    WrongAssertionClassError(final Class<? extends BaseAssertion> assertionClass, final Class<?> actualClass) {
        super("Wrong assertion class: " + assertionClass.getName() + " - class should have one constructor " + assertionClass.getSimpleName() + "(" + actualClass.getName() + ", " + String.class.getName() + ")");
    }

    /**
     * Create new object.
     *
     * @param assertionClass assertion class.
     * @param cause          cause of the error.
     */
    WrongAssertionClassError(final Class<? extends BaseAssertion> assertionClass, final ReflectiveOperationException cause) {
        super("Wrong assertion class: " + assertionClass.getName(), cause);
    }

}
