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

import java.lang.reflect.AccessibleObject;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Class to make the private class elements accessible.
 *
 * @author Dmitry Shapovalov
 */
final class PrivateAccessor {

    private PrivateAccessor() {
        super();
    }

    static void setAccessible(final AccessibleObject accessibleObject) {
        AccessController.doPrivileged(new PrivilegedAccessAction(accessibleObject));
    }

    /**
     * Privileged action to make the private class element accessible.
     *
     * @author Dmitry Shapovalov
     */
    private static final class PrivilegedAccessAction implements PrivilegedAction<Void> {

        private final AccessibleObject _accessibleObject;

        PrivilegedAccessAction(final AccessibleObject accessibleObject) {
            super();
            _accessibleObject = accessibleObject;
        }

        @Override
        public Void run() {
            _accessibleObject.setAccessible(true);
            return null;
        }

    }

}
