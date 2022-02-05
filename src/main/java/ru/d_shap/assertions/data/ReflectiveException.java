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
package ru.d_shap.assertions.data;

/**
 * Wrapper for exceptions, that can occur during reflective operations.
 *
 * @author Dmitry Shapovalov
 */
public final class ReflectiveException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Create new object.
     *
     * @param cause the cause of the exception.
     */
    public ReflectiveException(final ReflectiveOperationException cause) {
        super(cause);
    }

}
