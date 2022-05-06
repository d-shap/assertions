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

import org.hamcrest.Matchers;
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
        initialize(Raw.localeAssertion(), null).isEqualTo(null);
        initialize(Raw.localeAssertion(), new Locale("en")).isEqualTo(new Locale("en"));
        initialize(Raw.localeAssertion(), new Locale("en", "US")).isEqualTo(new Locale("en", "US"));
        initialize(Raw.localeAssertion(), new Locale("en", "US", "var")).isEqualTo(new Locale("en", "US", "var"));

        try {
            Raw.localeAssertion().isEqualTo(new Locale("en"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).isEqualTo(new Locale("en"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").isEqualTo(new Locale("en"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).isEqualTo(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").isEqualTo(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).isEqualTo(new Locale("fr"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").isEqualTo(new Locale("fr"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).isEqualTo(new Locale("en", "US"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<en_US> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").isEqualTo(new Locale("en", "US"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<en_US> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "GB")).isEqualTo(new Locale("en", "US"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<en_US> but was:<en_GB>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "GB"), "Message").isEqualTo(new Locale("en", "US"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<en_US> but was:<en_GB>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.localeAssertion(), null).isNotEqualTo(new Locale("en"));
        initialize(Raw.localeAssertion(), new Locale("en")).isNotEqualTo(null);
        initialize(Raw.localeAssertion(), new Locale("en")).isNotEqualTo(new Locale("fr"));
        initialize(Raw.localeAssertion(), new Locale("en")).isNotEqualTo(new Locale("en", "US"));
        initialize(Raw.localeAssertion(), new Locale("en", "US")).isNotEqualTo(new Locale("en"));
        initialize(Raw.localeAssertion(), new Locale("en", "GB")).isNotEqualTo(new Locale("en", "US"));
        initialize(Raw.localeAssertion(), new Locale("en", "US")).isNotEqualTo(new Locale("en", "GB"));

        try {
            Raw.localeAssertion().isNotEqualTo(new Locale("en"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).isNotEqualTo(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).isNotEqualTo(new Locale("en"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").isNotEqualTo(new Locale("en"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US")).isNotEqualTo(new Locale("en", "US"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<en_US>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US"), "Message").isNotEqualTo(new Locale("en", "US"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<en_US>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "var")).isNotEqualTo(new Locale("en", "US", "var"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<en_US_var>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "var"), "Message").isNotEqualTo(new Locale("en", "US", "var"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<en_US_var>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toLanguageTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).toLanguage().isEqualTo("en");
        initialize(Raw.localeAssertion(), new Locale("en", "US")).toLanguage().isEqualTo("en");
        initialize(Raw.localeAssertion(), new Locale("en", "US", "var")).toLanguage().isEqualTo("en");
        initialize(Raw.localeAssertion(), new Locale("fr")).toLanguage().isEqualTo("fr");

        try {
            Raw.localeAssertion().toLanguage();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toLanguage();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toLanguage();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "var")).toLanguage()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "var"), "Message").toLanguage()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's language.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "var")).toLanguage().isEqualTo("fr");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "var"), "Message").toLanguage().isEqualTo("fr");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toLanguageMatcherTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).toLanguage(Matchers.is(Matchers.equalTo("en")));
        initialize(Raw.localeAssertion(), new Locale("en", "US")).toLanguage(Matchers.is(Matchers.equalTo("en")));
        initialize(Raw.localeAssertion(), new Locale("en", "US", "var")).toLanguage(Matchers.is(Matchers.equalTo("en")));
        initialize(Raw.localeAssertion(), new Locale("fr")).toLanguage(Matchers.is(Matchers.equalTo("fr")));

        try {
            Raw.localeAssertion().toLanguage(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toLanguage(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toLanguage(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toLanguage(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toLanguage(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).toLanguage(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").toLanguage(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "var")).toLanguage(Matchers.equalTo("fr"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\nExpected: \"fr\"\n     but: was \"en\"");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "var"), "Message").toLanguage(Matchers.equalTo("fr"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's language.\nExpected: \"fr\"\n     but: was \"en\"");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasLanguageTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).hasLanguage("en");
        initialize(Raw.localeAssertion(), new Locale("en", "US")).hasLanguage("en");
        initialize(Raw.localeAssertion(), new Locale("en", "US", "var")).hasLanguage("en");
        initialize(Raw.localeAssertion(), new Locale("fr")).hasLanguage("fr");

        try {
            Raw.localeAssertion().hasLanguage("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasLanguage("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasLanguage("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasLanguage(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasLanguage(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).hasLanguage(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").hasLanguage(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "var")).hasLanguage("fr");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "var"), "Message").hasLanguage("fr");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
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

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasPropertiesLanguageTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasPropertiesLanguageAndCountryTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasPropertiesLanguageAndCountryAndVariantTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void isNullTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        // TODO
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        // TODO
    }

}
