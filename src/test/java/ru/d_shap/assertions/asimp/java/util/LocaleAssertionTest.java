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
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).isEqualTo(new Locale("en", "US", "polyton"));

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
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).isNotEqualTo(new Locale("en", "US", "polyton"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<en_US_polyton>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").isNotEqualTo(new Locale("en", "US", "polyton"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<en_US_polyton>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toLanguageTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).toLanguage().isEqualTo("en");
        initialize(Raw.localeAssertion(), new Locale("en", "US")).toLanguage().isEqualTo("en");
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toLanguage().isEqualTo("en");
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toLanguage().isEqualTo("fr");

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
            clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toLanguage()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toLanguage()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's language.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toLanguage().isEqualTo("fr");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toLanguage().isEqualTo("fr");
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
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toLanguage(Matchers.is(Matchers.equalTo("en")));
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toLanguage(Matchers.is(Matchers.equalTo("fr")));

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
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toLanguage(Matchers.equalTo("fr"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\nExpected: \"fr\"\n     but: was \"en\"");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toLanguage(Matchers.equalTo("fr"));
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
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasLanguage("en");
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).hasLanguage("fr");

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
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasLanguage("fr");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasLanguage("fr");
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
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale("en")).toDisplayLanguage().isEqualTo("English");
            initialize(Raw.localeAssertion(), new Locale("en", "US")).toDisplayLanguage().isEqualTo("English");
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayLanguage().isEqualTo("English");
            initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toDisplayLanguage().isEqualTo("French");

            try {
                Raw.localeAssertion().toDisplayLanguage();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayLanguage();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayLanguage();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayLanguage()).isEqualTo("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display language.\n\tActual value should not be null.");
            }
            try {
                clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toDisplayLanguage()).isEqualTo("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display language.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayLanguage().isEqualTo("French");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display language.\n\tActual and expected values should be the same.\n\tExpected:<French> but was:<English>");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toDisplayLanguage().isEqualTo("French");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display language.\n\tActual and expected values should be the same.\n\tExpected:<French> but was:<English>");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayLanguageMatcherTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale("en")).toDisplayLanguage(Matchers.is(Matchers.equalTo("English")));
            initialize(Raw.localeAssertion(), new Locale("en", "US")).toDisplayLanguage(Matchers.is(Matchers.equalTo("English")));
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayLanguage(Matchers.is(Matchers.equalTo("English")));
            initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toDisplayLanguage(Matchers.is(Matchers.equalTo("French")));

            try {
                Raw.localeAssertion().toDisplayLanguage(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayLanguage(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayLanguage(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayLanguage(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayLanguage(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en")).toDisplayLanguage(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en"), "Message").toDisplayLanguage(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayLanguage(Matchers.equalTo("French"));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display language.\nExpected: \"French\"\n     but: was \"English\"");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toDisplayLanguage(Matchers.equalTo("French"));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display language.\nExpected: \"French\"\n     but: was \"English\"");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasDisplayLanguageTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale("en")).hasDisplayLanguage("English");
            initialize(Raw.localeAssertion(), new Locale("en", "US")).hasDisplayLanguage("English");
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasDisplayLanguage("English");
            initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).hasDisplayLanguage("French");

            try {
                Raw.localeAssertion().hasDisplayLanguage("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).hasDisplayLanguage("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").hasDisplayLanguage("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null).hasDisplayLanguage(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").hasDisplayLanguage(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en")).hasDisplayLanguage(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en"), "Message").hasDisplayLanguage(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasDisplayLanguage("French");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display language.\n\tActual and expected values should be the same.\n\tExpected:<French> but was:<English>");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasDisplayLanguage("French");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display language.\n\tActual and expected values should be the same.\n\tExpected:<French> but was:<English>");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toScriptTest() {
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").build()).toScript().isEqualTo("");
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").build()).toScript().isEqualTo("Latn");
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").build()).toScript().isEqualTo("Latn");
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toScript().isEqualTo("Latn");

        try {
            Raw.localeAssertion().toScript();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toScript();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toScript();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toScript()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's script.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").toScript()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's script.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toScript().isEqualTo("Cyrl");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's script.\n\tActual and expected values should be the same.\n\tExpected:<Cyrl> but was:<Latn>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").toScript().isEqualTo("Cyrl");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's script.\n\tActual and expected values should be the same.\n\tExpected:<Cyrl> but was:<Latn>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toScriptMatcherTest() {
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").build()).toScript(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").build()).toScript(Matchers.is(Matchers.equalTo("Latn")));
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").build()).toScript(Matchers.is(Matchers.equalTo("Latn")));
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toScript(Matchers.is(Matchers.equalTo("Latn")));

        try {
            Raw.localeAssertion().toScript(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toScript(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toScript(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toScript(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toScript(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toScript(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").toScript(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toScript(Matchers.equalTo("Cyrl"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's script.\nExpected: \"Cyrl\"\n     but: was \"Latn\"");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").toScript(Matchers.equalTo("Cyrl"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's script.\nExpected: \"Cyrl\"\n     but: was \"Latn\"");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasScriptTest() {
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").build()).hasScript("");
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").build()).hasScript("Latn");
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").build()).hasScript("Latn");
        initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).hasScript("Latn");

        try {
            Raw.localeAssertion().hasScript("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasScript("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasScript("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasScript(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasScript(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).hasScript(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").hasScript(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).hasScript("Cyrl");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's script.\n\tActual and expected values should be the same.\n\tExpected:<Cyrl> but was:<Latn>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").hasScript("Cyrl");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's script.\n\tActual and expected values should be the same.\n\tExpected:<Cyrl> but was:<Latn>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayScriptTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").build()).toDisplayScript().isEqualTo("");
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").build()).toDisplayScript().isEqualTo("Latin");
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").build()).toDisplayScript().isEqualTo("Latin");
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toDisplayScript().isEqualTo("Latin");

            try {
                Raw.localeAssertion().toDisplayScript();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayScript();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayScript();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                clearActual(initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toDisplayScript()).isEqualTo("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display script.\n\tActual value should not be null.");
            }
            try {
                clearActual(initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").toDisplayScript()).isEqualTo("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display script.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toDisplayScript().isEqualTo("Cyrillic");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display script.\n\tActual and expected values should be the same.\n\tExpected:<Cyrillic> but was:<Latin>");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").toDisplayScript().isEqualTo("Cyrillic");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display script.\n\tActual and expected values should be the same.\n\tExpected:<Cyrillic> but was:<Latin>");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayScriptMatcherTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").build()).toDisplayScript(Matchers.is(Matchers.equalTo("")));
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").build()).toDisplayScript(Matchers.is(Matchers.equalTo("Latin")));
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").build()).toDisplayScript(Matchers.is(Matchers.equalTo("Latin")));
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toDisplayScript(Matchers.is(Matchers.equalTo("Latin")));

            try {
                Raw.localeAssertion().toDisplayScript(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayScript(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayScript(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayScript(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayScript(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toDisplayScript(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").toDisplayScript(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).toDisplayScript(Matchers.equalTo("Cyrillic"));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display script.\nExpected: \"Cyrillic\"\n     but: was \"Latin\"");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").toDisplayScript(Matchers.equalTo("Cyrillic"));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display script.\nExpected: \"Cyrillic\"\n     but: was \"Latin\"");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasDisplayScriptTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").build()).hasDisplayScript("");
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").build()).hasDisplayScript("Latin");
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").build()).hasDisplayScript("Latin");
            initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).hasDisplayScript("Latin");

            try {
                Raw.localeAssertion().hasDisplayScript("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).hasDisplayScript("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").hasDisplayScript("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null).hasDisplayScript(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").hasDisplayScript(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).hasDisplayScript(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").hasDisplayScript(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build()).hasDisplayScript("Cyrillic");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display script.\n\tActual and expected values should be the same.\n\tExpected:<Cyrillic> but was:<Latin>");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale.Builder().setLanguage("en").setScript("Latn").setRegion("US").setVariant("polyton").build(), "Message").hasDisplayScript("Cyrillic");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display script.\n\tActual and expected values should be the same.\n\tExpected:<Cyrillic> but was:<Latin>");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toCountryTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).toCountry().isEqualTo("");
        initialize(Raw.localeAssertion(), new Locale("en", "US")).toCountry().isEqualTo("US");
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toCountry().isEqualTo("US");
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toCountry().isEqualTo("FR");

        try {
            Raw.localeAssertion().toCountry();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toCountry();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toCountry();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toCountry()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's country.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toCountry()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's country.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toCountry().isEqualTo("FR");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's country.\n\tActual and expected values should be the same.\n\tExpected:<FR> but was:<US>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toCountry().isEqualTo("FR");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's country.\n\tActual and expected values should be the same.\n\tExpected:<FR> but was:<US>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toCountryMatcherTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).toCountry(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.localeAssertion(), new Locale("en", "US")).toCountry(Matchers.is(Matchers.equalTo("US")));
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toCountry(Matchers.is(Matchers.equalTo("US")));
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toCountry(Matchers.is(Matchers.equalTo("FR")));

        try {
            Raw.localeAssertion().toCountry(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toCountry(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toCountry(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toCountry(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toCountry(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).toCountry(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").toCountry(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toCountry(Matchers.equalTo("FR"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's country.\nExpected: \"FR\"\n     but: was \"US\"");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toCountry(Matchers.equalTo("FR"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's country.\nExpected: \"FR\"\n     but: was \"US\"");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasCountryTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).hasCountry("");
        initialize(Raw.localeAssertion(), new Locale("en", "US")).hasCountry("US");
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasCountry("US");
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).hasCountry("FR");

        try {
            Raw.localeAssertion().hasCountry("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasCountry("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasCountry("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasCountry(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasCountry(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).hasCountry(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").hasCountry(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasCountry("FR");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's country.\n\tActual and expected values should be the same.\n\tExpected:<FR> but was:<US>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasCountry("FR");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's country.\n\tActual and expected values should be the same.\n\tExpected:<FR> but was:<US>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayCountryTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale("en")).toDisplayCountry().isEqualTo("");
            initialize(Raw.localeAssertion(), new Locale("en", "US")).toDisplayCountry().isEqualTo("United States");
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayCountry().isEqualTo("United States");
            initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toDisplayCountry().isEqualTo("France");

            try {
                Raw.localeAssertion().toDisplayCountry();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayCountry();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayCountry();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayCountry()).isEqualTo("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display country.\n\tActual value should not be null.");
            }
            try {
                clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toDisplayCountry()).isEqualTo("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display country.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayCountry().isEqualTo("France");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display country.\n\tActual and expected values should be the same.\n\tExpected:<France> but was:<United States>");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toDisplayCountry().isEqualTo("France");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display country.\n\tActual and expected values should be the same.\n\tExpected:<France> but was:<United States>");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayCountryMatcherTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale("en")).toDisplayCountry(Matchers.is(Matchers.equalTo("")));
            initialize(Raw.localeAssertion(), new Locale("en", "US")).toDisplayCountry(Matchers.is(Matchers.equalTo("United States")));
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayCountry(Matchers.is(Matchers.equalTo("United States")));
            initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toDisplayCountry(Matchers.is(Matchers.equalTo("France")));

            try {
                Raw.localeAssertion().toDisplayCountry(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayCountry(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayCountry(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayCountry(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayCountry(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en")).toDisplayCountry(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en"), "Message").toDisplayCountry(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayCountry(Matchers.equalTo("France"));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display country.\nExpected: \"France\"\n     but: was \"United States\"");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toDisplayCountry(Matchers.equalTo("France"));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display country.\nExpected: \"France\"\n     but: was \"United States\"");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasDisplayCountryTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale("en")).hasDisplayCountry("");
            initialize(Raw.localeAssertion(), new Locale("en", "US")).hasDisplayCountry("United States");
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasDisplayCountry("United States");
            initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).hasDisplayCountry("France");

            try {
                Raw.localeAssertion().hasDisplayCountry("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).hasDisplayCountry("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").hasDisplayCountry("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null).hasDisplayCountry(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").hasDisplayCountry(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en")).hasDisplayCountry(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en"), "Message").hasDisplayCountry(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasDisplayCountry("France");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display country.\n\tActual and expected values should be the same.\n\tExpected:<France> but was:<United States>");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasDisplayCountry("France");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display country.\n\tActual and expected values should be the same.\n\tExpected:<France> but was:<United States>");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toVariantTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).toVariant().isEqualTo("");
        initialize(Raw.localeAssertion(), new Locale("en", "US")).toVariant().isEqualTo("");
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toVariant().isEqualTo("polyton");
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toVariant().isEqualTo("POSIX");

        try {
            Raw.localeAssertion().toVariant();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toVariant();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toVariant();
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toVariant()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's variant.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toVariant()).isEqualTo("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's variant.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toVariant().isEqualTo("POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toVariant().isEqualTo("POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toVariantMatcherTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).toVariant(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.localeAssertion(), new Locale("en", "US")).toVariant(Matchers.is(Matchers.equalTo("")));
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toVariant(Matchers.is(Matchers.equalTo("polyton")));
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toVariant(Matchers.is(Matchers.equalTo("POSIX")));

        try {
            Raw.localeAssertion().toVariant(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toVariant(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toVariant(Matchers.equalTo(""));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null).toVariant(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").toVariant(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).toVariant(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").toVariant(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toVariant(Matchers.equalTo("POSIX"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's variant.\nExpected: \"POSIX\"\n     but: was \"polyton\"");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toVariant(Matchers.equalTo("POSIX"));
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's variant.\nExpected: \"POSIX\"\n     but: was \"polyton\"");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasVariantTest() {
        initialize(Raw.localeAssertion(), new Locale("en")).hasVariant("");
        initialize(Raw.localeAssertion(), new Locale("en", "US")).hasVariant("");
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasVariant("polyton");
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).hasVariant("POSIX");

        try {
            Raw.localeAssertion().hasVariant("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasVariant("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasVariant("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasVariant(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasVariant(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en")).hasVariant(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en"), "Message").hasVariant(null);
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasVariant("POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasVariant("POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayVariantTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale("en")).toDisplayVariant().isEqualTo("");
            initialize(Raw.localeAssertion(), new Locale("en", "US")).toDisplayVariant().isEqualTo("");
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayVariant().isEqualTo("polyton");
            initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toDisplayVariant().isEqualTo("POSIX");

            try {
                Raw.localeAssertion().toDisplayVariant();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayVariant();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayVariant();
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayVariant()).isEqualTo("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display variant.\n\tActual value should not be null.");
            }
            try {
                clearActual(initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toDisplayVariant()).isEqualTo("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display variant.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayVariant().isEqualTo("POSIX");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toDisplayVariant().isEqualTo("POSIX");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void toDisplayVariantMatcherTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale("en")).toDisplayVariant(Matchers.is(Matchers.equalTo("")));
            initialize(Raw.localeAssertion(), new Locale("en", "US")).toDisplayVariant(Matchers.is(Matchers.equalTo("")));
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayVariant(Matchers.is(Matchers.equalTo("polyton")));
            initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).toDisplayVariant(Matchers.is(Matchers.equalTo("POSIX")));

            try {
                Raw.localeAssertion().toDisplayVariant(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayVariant(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayVariant(Matchers.equalTo(""));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null).toDisplayVariant(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").toDisplayVariant(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en")).toDisplayVariant(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en"), "Message").toDisplayVariant(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).toDisplayVariant(Matchers.equalTo("POSIX"));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display variant.\nExpected: \"POSIX\"\n     but: was \"polyton\"");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").toDisplayVariant(Matchers.equalTo("POSIX"));
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display variant.\nExpected: \"POSIX\"\n     but: was \"polyton\"");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasDisplayVariantTest() {
        Locale locale = Locale.getDefault();

        try {
            Locale.setDefault(Locale.ENGLISH);

            initialize(Raw.localeAssertion(), new Locale("en")).hasDisplayVariant("");
            initialize(Raw.localeAssertion(), new Locale("en", "US")).hasDisplayVariant("");
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasDisplayVariant("polyton");
            initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).hasDisplayVariant("POSIX");

            try {
                Raw.localeAssertion().hasDisplayVariant("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
            }
            try {
                initialize(Raw.localeAssertion(), null).hasDisplayVariant("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").hasDisplayVariant("");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null).hasDisplayVariant(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), null, "Message").hasDisplayVariant(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en")).hasDisplayVariant(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en"), "Message").hasDisplayVariant(null);
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasDisplayVariant("POSIX");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Check actual value's display variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
            }
            try {
                initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasDisplayVariant("POSIX");
                Assertions.fail("LocaleAssertion test fail");
            } catch (AssertionError ex) {
                Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasPropertiesLanguageTest() {
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasProperties("en");
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).hasProperties("fr");

        try {
            Raw.localeAssertion().hasProperties("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasProperties("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasProperties("");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasProperties("fr");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasProperties("fr");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasPropertiesLanguageAndCountryTest() {
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasProperties("en", "US");
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).hasProperties("fr", "FR");

        try {
            Raw.localeAssertion().hasProperties("", "");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasProperties("", "");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasProperties("", "");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasProperties("fr", "FR");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasProperties("fr", "FR");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasProperties("en", "FR");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's country.\n\tActual and expected values should be the same.\n\tExpected:<FR> but was:<US>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasProperties("en", "FR");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's country.\n\tActual and expected values should be the same.\n\tExpected:<FR> but was:<US>");
        }
    }

    /**
     * {@link LocaleAssertion} class test.
     */
    @Test
    public void hasPropertiesLanguageAndCountryAndVariantTest() {
        initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasProperties("en", "US", "polyton");
        initialize(Raw.localeAssertion(), new Locale("fr", "FR", "POSIX")).hasProperties("fr", "FR", "POSIX");

        try {
            Raw.localeAssertion().hasProperties("", "", "");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.localeAssertion(), null).hasProperties("", "", "");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), null, "Message").hasProperties("", "", "");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasProperties("fr", "FR", "POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasProperties("fr", "FR", "POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's language.\n\tActual and expected values should be the same.\n\tExpected:<fr> but was:<en>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasProperties("en", "FR", "POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's country.\n\tActual and expected values should be the same.\n\tExpected:<FR> but was:<US>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasProperties("en", "FR", "POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's country.\n\tActual and expected values should be the same.\n\tExpected:<FR> but was:<US>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton")).hasProperties("en", "US", "POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
        }
        try {
            initialize(Raw.localeAssertion(), new Locale("en", "US", "polyton"), "Message").hasProperties("en", "US", "POSIX");
            Assertions.fail("LocaleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's variant.\n\tActual and expected values should be the same.\n\tExpected:<POSIX> but was:<polyton>");
        }
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
