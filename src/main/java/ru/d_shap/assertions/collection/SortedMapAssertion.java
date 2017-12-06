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
package ru.d_shap.assertions.collection;

import java.util.SortedMap;

import ru.d_shap.assertions.ReferenceAssertion;

/**
 * Assertions for the sorted map.
 *
 * @param <K> the generic type of the sorted map key.
 * @param <V> the generic type of the sorted map value.
 * @author Dmitry Shapovalov
 */
public class SortedMapAssertion<K, V> extends ReferenceAssertion<SortedMap<K, V>> {

    /**
     * Create new object.
     */
    public SortedMapAssertion() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final Class<SortedMap<K, V>> getActualValueClass() {
        return (Class<SortedMap<K, V>>) getRawActualValueClass();
    }

    private Class<?> getRawActualValueClass() {
        return SortedMap.class;
    }

    @Override
    protected final String asString(final Object value) {
        return value.toString();
    }

}
