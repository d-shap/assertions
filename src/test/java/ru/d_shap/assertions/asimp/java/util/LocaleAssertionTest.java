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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LocaleAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LocaleAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LocaleAssertionTest() {
        super();
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.localeAssertion(), Locale.getDefault());

        try {
            initializeWithRawActual(Raw.localeAssertion(), new Object());
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Locale> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.localeAssertion(), new Object(), "Message");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Locale> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toLanguageTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toLanguageMatcherTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasLanguageTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayLanguageTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayLanguageMatcherTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasDisplayLanguageTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toScriptTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toScriptMatcherTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasScriptTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayScriptTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayScriptMatcherTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasDisplayScriptTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toCountryTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toCountryMatcherTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasCountryTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayCountryTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayCountryMatcherTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasDisplayCountryTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toVariantTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toVariantMatcherTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasVariantTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayVariantTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayVariantMatcherTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasDisplayVariantTest() {
        // TODO
    }

}
