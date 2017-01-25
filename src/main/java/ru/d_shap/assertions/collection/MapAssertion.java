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
package ru.d_shap.assertions.collection;

import java.util.Map;

import ru.d_shap.assertions.ReferenceAssertion;

/**
 * Assertions for the map.
 *
 * @author Dmitry Shapovalov
 */
public class MapAssertion extends ReferenceAssertion {

    /**
     * Create new object.
     *
     * @param actual  the actual map.
     * @param message the assertion message.
     */
    public MapAssertion(final Map<?, ?> actual, final String message) {
        super(actual, message);
    }

    /**
     * Make assertion about the actual map keys.
     *
     * @return assertion.
     */
    public final SetAssertion toKeys() {
        return new SetAssertion(((Map<?, ?>) getActual()).keySet(), getMessage());
    }

    /**
     * Check if the actual value contains the expected key.
     *
     * @param expected the expected key.
     */
    public final void containsKey(final Object expected) {
        toKeys().contains(expected);
    }

    @Override
    protected final String asString(final Object value) {
        if (value == null) {
            return null;
        } else {
            return String.valueOf(value);
        }
    }

}
