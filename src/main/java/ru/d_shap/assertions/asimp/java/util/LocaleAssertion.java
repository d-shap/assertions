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
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
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
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toDisplayLanguage().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's script.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toScript() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getScript(), Messages.Check.SCRIPT);
    }

    /**
     * Make assertion about the actual value's script.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toScript(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getScript(), matcher, Messages.Check.SCRIPT);
    }

    /**
     * Check if the actual value's script is equal to the expected script.
     *
     * @param expected the expected value.
     */
    public final void hasScript(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toScript().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's display script.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toDisplayScript() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayScript(), Messages.Check.DISPLAY_SCRIPT);
    }

    /**
     * Make assertion about the actual value's display script.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDisplayScript(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayScript(), matcher, Messages.Check.DISPLAY_SCRIPT);
    }

    /**
     * Check if the actual value's display script is equal to the expected display script.
     *
     * @param expected the expected value.
     */
    public final void hasDisplayScript(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toDisplayScript().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's country.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toCountry() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getCountry(), Messages.Check.COUNTRY);
    }

    /**
     * Make assertion about the actual value's country.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toCountry(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getCountry(), matcher, Messages.Check.COUNTRY);
    }

    /**
     * Check if the actual value's country is equal to the expected country.
     *
     * @param expected the expected value.
     */
    public final void hasCountry(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toCountry().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's display country.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toDisplayCountry() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayCountry(), Messages.Check.DISPLAY_COUNTRY);
    }

    /**
     * Make assertion about the actual value's display country.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDisplayCountry(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayCountry(), matcher, Messages.Check.DISPLAY_COUNTRY);
    }

    /**
     * Check if the actual value's display country is equal to the expected display country.
     *
     * @param expected the expected value.
     */
    public final void hasDisplayCountry(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toDisplayCountry().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's variant.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toVariant() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getVariant(), Messages.Check.VARIANT);
    }

    /**
     * Make assertion about the actual value's variant.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toVariant(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getVariant(), matcher, Messages.Check.VARIANT);
    }

    /**
     * Check if the actual value's variant is equal to the expected variant.
     *
     * @param expected the expected value.
     */
    public final void hasVariant(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toVariant().isEqualTo(expected);
    }

    /**
     * Make assertion about the actual value's display variant.
     *
     * @return the assertion.
     */
    public final CharSequenceAssertion toDisplayVariant() {
        checkActualIsNotNull();
        return initializeAssertion(Raw.charSequenceAssertion(), getActual().getDisplayVariant(), Messages.Check.DISPLAY_VARIANT);
    }

    /**
     * Make assertion about the actual value's display variant.
     *
     * @param matcher the hamcrest matcher.
     */
    public final void toDisplayVariant(final Matcher<? super String> matcher) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(matcher, "matcher");
        matcherAssertion(getActual().getDisplayVariant(), matcher, Messages.Check.DISPLAY_VARIANT);
    }

    /**
     * Check if the actual value's display variant is equal to the expected display variant.
     *
     * @param expected the expected value.
     */
    public final void hasDisplayVariant(final String expected) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expected, "expected");
        toDisplayVariant().isEqualTo(expected);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLanguage the expected language.
     */
    public final void hasProperties(final String expectedLanguage) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLanguage, "expectedLanguage");
        hasLanguage(expectedLanguage);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLanguage the expected language.
     * @param expectedCountry  the expected country.
     */
    public final void hasProperties(final String expectedLanguage, final String expectedCountry) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLanguage, "expectedLanguage");
        checkArgumentIsNotNull(expectedCountry, "expectedCountry");
        hasLanguage(expectedLanguage);
        hasCountry(expectedCountry);
    }

    /**
     * Check if the actual value's properties are equal to the expected properties.
     *
     * @param expectedLanguage the expected language.
     * @param expectedCountry  the expected country.
     * @param expectedVariant  the expected variant.
     */
    public final void hasProperties(final String expectedLanguage, final String expectedCountry, final String expectedVariant) {
        checkActualIsNotNull();
        checkArgumentIsNotNull(expectedLanguage, "expectedLanguage");
        checkArgumentIsNotNull(expectedCountry, "expectedCountry");
        checkArgumentIsNotNull(expectedVariant, "expectedVariant");
        hasLanguage(expectedLanguage);
        hasCountry(expectedCountry);
        hasVariant(expectedVariant);
    }

}