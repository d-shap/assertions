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
package ru.d_shap.assertions.asimp.java.util;

import java.util.Locale;

import org.hamcrest.Matcher;

import ru.d_shap.assertions.Messages;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.asimp.ReferenceAssertion;
import ru.d_shap.assertions.asimp.java.lang.CharSequenceAssertion;

/**
 * Assertions for the locale.
 *
 * @author Dmitry Shapovalov
 */
public class LocaleAssertion extends ReferenceAssertion<Locale> {

    /**
     * Create new object.
     */
    public LocaleAssertion() {
        super();
    }

    @Override
    protected final Class<Locale> getActualValueClass() {
        return Locale.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isEqualTo(final Locale expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
        }
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     */
    public final void isNotEqualTo(final Locale expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
        }
    }

    /**
     * Make assertion about the actual value's language.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toLanguage() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getLanguage(), Messages.Check.LANGUAGE);
    }

    /**
     * Make assertion about the actual value's language.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toLanguage(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getLanguage(), matcher, Messages.Check.LANGUAGE);
    }

    /**
     * Check if the actual value's language is equal to the expected language.
     *
     * @param expected the expected value.
     */
    public final void hasLanguage(final String expected) {
        toLanguage().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's display language.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toDisplayLanguage() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayLanguage(), Messages.Check.DISPLAY_LANGUAGE);
    }

    /**
     * Make assertion about the actual value's display language.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDisplayLanguage(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayLanguage(), matcher, Messages.Check.DISPLAY_LANGUAGE);
    }

    /**
     * Check if the actual value's display language is equal to the expected display language.
     *
     * @param expected the expected value.
     */
    public final void hasDisplayLanguage(final String expected) {
        toDisplayLanguage().isEqualTo(expected);
    }

}
