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
package ru.d_shap.assertions.asimp.java.lang;

import ru.d_shap.assertions.ActualValueValidatorProvider;
import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.fail.AssertionErrorBuilder;

/**
 * Actual value validator to check if the actual value is the enum class.
 *
 * @author Dmitry Shapovalov
 */
public final class EnumActualValueValidator implements ActualValueValidatorProvider {

    /**
     * Create new object.
     */
    public EnumActualValueValidator() {
        super();
    }

    @Override
    public boolean isValid(final Object actual) {
        return actual instanceof Class<?> && Enum.class.isAssignableFrom((Class<?>) actual);
    }

    @Override
    public Object getFailValue(final Object actual) {
        return actual.getClass();
    }

    @Override
    public void addFailMessage(final AssertionErrorBuilder assertionErrorBuilder) {
        assertionErrorBuilder.addMessage(Messages.Fail.Assertion.IS_SUBTYPE_OF).addActual().addExpected(Enum.class);
    }

}
