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
package ru.d_shap.assertions.asimp;

/**
 * Class to describe the class' executable (method or constructor).
 *
 * @author Dmitry Shapovalov
 */
public final class ExecutableDescription {

    private final String _name;

    private final Class<?>[] _parameterTypes;

    /**
     * Create new object.
     *
     * @param name           the name of the executable.
     * @param parameterTypes the executable parameter types.
     */
    public ExecutableDescription(final String name, final Class<?>... parameterTypes) {
        super();
        _name = name;
        _parameterTypes = parameterTypes;
    }

    /**
     * Get the name of the executable.
     *
     * @return the name of the executable.
     */
    public String getName() {
        return _name;
    }

    /**
     * Get the executable parameter types.
     *
     * @return the executable parameter types.
     */
    public Class<?>[] getParameterTypes() {
        return _parameterTypes;
    }

}
