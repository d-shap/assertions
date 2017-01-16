///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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

import ru.d_shap.assertions.ReferenceAssertion;

/**
 * Assertions for the iterable.
 *
 * @author Dmitry Shapovalov
 */
public class IterableAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual iterable.
     * @param message the assertion message.
     */
    public IterableAssertion(final Iterable<?> actual, final String message) {
        super(actual, message);
    }

    @Override
    protected final String asString(final Object value) {
        return String.valueOf(value);
    }

}
