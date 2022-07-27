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
public final class LocaleAssertion extends ReferenceAssertion<LocaleAssertion, Locale> {

    /**
     * Create new object.
     */
    public LocaleAssertion() {
        super();
    }

    @Override
    protected Class<Locale> getActualValueClass() {
        return Locale.class;
    }

    /**
     * Check if the actual value is equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion isEqualTo(final Locale expected) {
        if (expected == null) {
            isNull();
        } else {
            checkActualIsNotNull();
            if (!getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_SAME).addActual().addExpected(expected).build();
            }
        }
        return this;
    }

    /**
     * Check if the actual value is NOT equal to the expected value.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion isNotEqualTo(final Locale expected) {
        if (expected == null) {
            isNotNull();
        } else {
            if (getActual() != null && getActual().equals(expected)) {
                throw getAssertionErrorBuilder().addMessage(Messages.Fail.Actual.IS_DIFFERENT).addActual().build();
            }
        }
        return this;
    }

    /**
     * Make assertion about the actual value's language.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toLanguage() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getLanguage(), Messages.Check.LANGUAGE);
    }

    /**
     * Make assertion about the actual value's language.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion toLanguage(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getLanguage(), matcher, Messages.Check.LANGUAGE);
        return this;
    }

    /**
     * Check if the actual value's language is equal to the expected language.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasLanguage(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toLanguage().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's display language.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toDisplayLanguage() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayLanguage(), Messages.Check.DISPLAY_LANGUAGE);
    }

    /**
     * Make assertion about the actual value's display language.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion toDisplayLanguage(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayLanguage(), matcher, Messages.Check.DISPLAY_LANGUAGE);
        return this;
    }

    /**
     * Check if the actual value's display language is equal to the expected display language.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasDisplayLanguage(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toDisplayLanguage().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's script.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toScript() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getScript(), Messages.Check.SCRIPT);
    }

    /**
     * Make assertion about the actual value's script.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion toScript(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getScript(), matcher, Messages.Check.SCRIPT);
        return this;
    }

    /**
     * Check if the actual value's script is equal to the expected script.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasScript(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toScript().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's display script.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toDisplayScript() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayScript(), Messages.Check.DISPLAY_SCRIPT);
    }

    /**
     * Make assertion about the actual value's display script.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion toDisplayScript(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayScript(), matcher, Messages.Check.DISPLAY_SCRIPT);
        return this;
    }

    /**
     * Check if the actual value's display script is equal to the expected display script.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasDisplayScript(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toDisplayScript().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's country.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toCountry() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getCountry(), Messages.Check.COUNTRY);
    }

    /**
     * Make assertion about the actual value's country.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion toCountry(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getCountry(), matcher, Messages.Check.COUNTRY);
        return this;
    }

    /**
     * Check if the actual value's country is equal to the expected country.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasCountry(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCountry().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's display country.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toDisplayCountry() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayCountry(), Messages.Check.DISPLAY_COUNTRY);
    }

    /**
     * Make assertion about the actual value's display country.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion toDisplayCountry(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayCountry(), matcher, Messages.Check.DISPLAY_COUNTRY);
        return this;
    }

    /**
     * Check if the actual value's display country is equal to the expected display country.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasDisplayCountry(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toDisplayCountry().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's variant.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toVariant() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getVariant(), Messages.Check.VARIANT);
    }

    /**
     * Make assertion about the actual value's variant.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion toVariant(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getVariant(), matcher, Messages.Check.VARIANT);
        return this;
    }

    /**
     * Check if the actual value's variant is equal to the expected variant.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasVariant(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toVariant().isEqualTo(expected);
        return this;
    }

    /**
     * Make assertion about the actual value's display variant.
     *
     * @return the assertion.
     */
    public CharSequenceAssertion toDisplayVariant() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayVariant(), Messages.Check.DISPLAY_VARIANT);
    }

    /**
     * Make assertion about the actual value's display variant.
     *
     * @param matcher the hamcrest matcher.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion toDisplayVariant(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayVariant(), matcher, Messages.Check.DISPLAY_VARIANT);
        return this;
    }

    /**
     * Check if the actual value's display variant is equal to the expected display variant.
     *
     * @param expected the expected value.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasDisplayVariant(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toDisplayVariant().isEqualTo(expected);
        return this;
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLanguage the expected language.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasProperties(final String expectedLanguage) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLanguage, "expectedLanguage");
        hasLanguage(expectedLanguage);
        return this;
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLanguage the expected language.
     * @param expectedCountry  the expected country.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasProperties(final String expectedLanguage, final String expectedCountry) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLanguage, "expectedLanguage");
        checkArgumentIsNotNull(expectedCountry, "expectedCountry");
        hasLanguage(expectedLanguage);
        hasCountry(expectedCountry);
        return this;
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLanguage the expected language.
     * @param expectedCountry  the expected country.
     * @param expectedVariant  the expected variant.
     *
     * @return current object for the chain call.
     */
    public LocaleAssertion hasProperties(final String expectedLanguage, final String expectedCountry, final String expectedVariant) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLanguage, "expectedLanguage");
        checkArgumentIsNotNull(expectedCountry, "expectedCountry");
        checkArgumentIsNotNull(expectedVariant, "expectedVariant");
        hasLanguage(expectedLanguage);
        hasCountry(expectedCountry);
        hasVariant(expectedVariant);
        return this;
    }

}
