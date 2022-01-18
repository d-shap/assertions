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

import java.util.TimeZone;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link TimeZoneAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public class TimeZoneAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public TimeZoneAssertionTest() {
        super();
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"));

        try {
            initializeWithRawActual(Raw.timeZoneAssertion(), new Object());
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.TimeZone> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.timeZoneAssertion(), new Object(), "Message");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.TimeZone> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).isEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).isEqualTo(TimeZone.getTimeZone("GMT"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).isEqualTo(TimeZone.getTimeZone("Asia/Novosibirsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).isEqualTo(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).isEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).isEqualTo(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).isEqualTo(TimeZone.getTimeZone("Europe/Vienna"));

        try {
            Raw.timeZoneAssertion().isEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).isEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").isEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).isEqualTo(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").isEqualTo(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).isEqualTo(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").isEqualTo(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).isEqualTo(TimeZone.getTimeZone("GMT"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<GMT> but was:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").isEqualTo(TimeZone.getTimeZone("GMT"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<GMT> but was:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).isEqualTo(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<Asia/Krasnoyarsk> but was:<Asia/Novosibirsk>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk"), "Message").isEqualTo(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<Asia/Krasnoyarsk> but was:<Asia/Novosibirsk>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).isNotEqualTo(TimeZone.getTimeZone("GMT"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).isNotEqualTo(TimeZone.getTimeZone("UTC"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).isNotEqualTo(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).isNotEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).isNotEqualTo(TimeZone.getTimeZone("Asia/Novosibirsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).isNotEqualTo(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).isNotEqualTo(TimeZone.getTimeZone("Asia/Novosibirsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).isNotEqualTo(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).isNotEqualTo(TimeZone.getTimeZone("Europe/Vienna"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).isNotEqualTo(TimeZone.getTimeZone("Europe/Berlin"));

        try {
            Raw.timeZoneAssertion().isNotEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).isNotEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").isNotEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).isNotEqualTo(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).isNotEqualTo(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").isNotEqualTo(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).isNotEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").isNotEqualTo(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).isNotEqualTo(TimeZone.getTimeZone("Asia/Novosibirsk"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<Asia/Novosibirsk>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk"), "Message").isNotEqualTo(TimeZone.getTimeZone("Asia/Novosibirsk"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<Asia/Novosibirsk>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void hasSameRulesTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasSameRules(TimeZone.getTimeZone("UTC"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasSameRules(TimeZone.getTimeZone("GMT"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).hasSameRules(TimeZone.getTimeZone("GMT"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).hasSameRules(TimeZone.getTimeZone("UTC"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).hasSameRules(TimeZone.getTimeZone("Asia/Novosibirsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).hasSameRules(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).hasSameRules(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).hasSameRules(TimeZone.getTimeZone("Europe/Berlin"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).hasSameRules(TimeZone.getTimeZone("Europe/Vienna"));

        try {
            Raw.timeZoneAssertion().hasSameRules(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).hasSameRules(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").hasSameRules(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).hasSameRules(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").hasSameRules(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasSameRules(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").hasSameRules(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).hasSameRules(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should have the same rules as the expected.\n\tExpected:<Asia/Krasnoyarsk> but was:<Asia/Novosibirsk>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk"), "Message").hasSameRules(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should have the same rules as the expected.\n\tExpected:<Asia/Krasnoyarsk> but was:<Asia/Novosibirsk>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void doesNotHaveSameRulesTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).doesNotHaveSameRules(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).doesNotHaveSameRules(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).doesNotHaveSameRules(TimeZone.getTimeZone("Asia/Novosibirsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).doesNotHaveSameRules(TimeZone.getTimeZone("Asia/Vientiane"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).doesNotHaveSameRules(TimeZone.getTimeZone("Asia/Novosibirsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).doesNotHaveSameRules(TimeZone.getTimeZone("Asia/Krasnoyarsk"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).doesNotHaveSameRules(TimeZone.getTimeZone("Europe/Vienna"));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).doesNotHaveSameRules(TimeZone.getTimeZone("Europe/Berlin"));

        try {
            Raw.timeZoneAssertion().doesNotHaveSameRules(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).doesNotHaveSameRules(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").doesNotHaveSameRules(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).doesNotHaveSameRules(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").doesNotHaveSameRules(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).doesNotHaveSameRules(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").doesNotHaveSameRules(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).doesNotHaveSameRules(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the same rules as the expected.\n\tExpected:<UTC> but was:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").doesNotHaveSameRules(TimeZone.getTimeZone("UTC"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the same rules as the expected.\n\tExpected:<UTC> but was:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).doesNotHaveSameRules(TimeZone.getTimeZone("GMT"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not have the same rules as the expected.\n\tExpected:<GMT> but was:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").doesNotHaveSameRules(TimeZone.getTimeZone("GMT"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not have the same rules as the expected.\n\tExpected:<GMT> but was:<UTC>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toIdTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toId().isEqualTo("UTC");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toId().isEqualTo("GMT");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toId().isEqualTo("Asia/Novosibirsk");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toId().isEqualTo("Asia/Krasnoyarsk");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toId().isEqualTo("Asia/Vientiane");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toId().isEqualTo("Europe/Berlin");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toId().isEqualTo("Europe/Vienna");

        try {
            Raw.timeZoneAssertion().toId();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toId();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toId();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toId()).isEqualTo("UTC");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's ID.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toId()).isEqualTo("UTC");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's ID.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toId().isEqualTo("GMT");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<GMT> but was:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toId().isEqualTo("GMT");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<GMT> but was:<UTC>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toIdMatcherTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toId(Matchers.is(Matchers.equalTo("UTC")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toId(Matchers.is(Matchers.equalTo("GMT")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toId(Matchers.is(Matchers.equalTo("Asia/Novosibirsk")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toId(Matchers.is(Matchers.equalTo("Asia/Krasnoyarsk")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toId(Matchers.is(Matchers.equalTo("Asia/Vientiane")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toId(Matchers.is(Matchers.equalTo("Europe/Berlin")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toId(Matchers.is(Matchers.equalTo("Europe/Vienna")));

        try {
            Raw.timeZoneAssertion().toId(Matchers.equalTo(""));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toId(Matchers.equalTo(""));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toId(Matchers.equalTo(""));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toId(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toId(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toId(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toId(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toId(Matchers.is(Matchers.equalTo("GMT")));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's ID.\nExpected: is \"GMT\"\n     but: was \"UTC\"");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toId(Matchers.is(Matchers.equalTo("GMT")));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's ID.\nExpected: is \"GMT\"\n     but: was \"UTC\"");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void hasIdTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasId("UTC");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).hasId("GMT");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).hasId("Asia/Novosibirsk");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).hasId("Asia/Krasnoyarsk");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).hasId("Asia/Vientiane");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).hasId("Europe/Berlin");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).hasId("Europe/Vienna");

        try {
            Raw.timeZoneAssertion().hasId("");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).hasId("");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").hasId("");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasId("GMT");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<GMT> but was:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").hasId("GMT");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's ID.\n\tActual and expected values should be the same.\n\tExpected:<GMT> but was:<UTC>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toDisplayNameTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDisplayName().isEqualTo("Coordinated Universal Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toDisplayName().isEqualTo("Greenwich Mean Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toDisplayName().isEqualTo("Novosibirsk Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toDisplayName().isEqualTo("Krasnoyarsk Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toDisplayName().isEqualTo("Indochina Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toDisplayName().isEqualTo("Central European Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toDisplayName().isEqualTo("Central European Time");

        try {
            Raw.timeZoneAssertion().toDisplayName();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toDisplayName();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toDisplayName();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDisplayName()).isEqualTo("UTC");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's display name.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toDisplayName()).isEqualTo("UTC");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display name.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDisplayName().isEqualTo("Greenwich Mean Time");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's display name.\n\tActual and expected values should be the same.\n\tExpected:<Greenwich Mean Time> but was:<Coordinated Universal Time>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toDisplayName().isEqualTo("Greenwich Mean Time");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display name.\n\tActual and expected values should be the same.\n\tExpected:<Greenwich Mean Time> but was:<Coordinated Universal Time>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toDisplayNameMatcherTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDisplayName(Matchers.is(Matchers.equalTo("Coordinated Universal Time")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toDisplayName(Matchers.is(Matchers.equalTo("Greenwich Mean Time")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toDisplayName(Matchers.is(Matchers.equalTo("Novosibirsk Time")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toDisplayName(Matchers.is(Matchers.equalTo("Krasnoyarsk Time")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toDisplayName(Matchers.is(Matchers.equalTo("Indochina Time")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toDisplayName(Matchers.is(Matchers.equalTo("Central European Time")));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toDisplayName(Matchers.is(Matchers.equalTo("Central European Time")));

        try {
            Raw.timeZoneAssertion().toDisplayName(Matchers.equalTo(""));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toDisplayName(Matchers.equalTo(""));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toDisplayName(Matchers.equalTo(""));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toDisplayName(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toDisplayName(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDisplayName(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toDisplayName(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDisplayName(Matchers.is(Matchers.equalTo("Greenwich Mean Time")));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's display name.\nExpected: is \"Greenwich Mean Time\"\n     but: was \"Coordinated Universal Time\"");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toDisplayName(Matchers.is(Matchers.equalTo("Greenwich Mean Time")));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display name.\nExpected: is \"Greenwich Mean Time\"\n     but: was \"Coordinated Universal Time\"");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void hasDisplayNameTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasDisplayName("Coordinated Universal Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).hasDisplayName("Greenwich Mean Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).hasDisplayName("Novosibirsk Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).hasDisplayName("Krasnoyarsk Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).hasDisplayName("Indochina Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).hasDisplayName("Central European Time");
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).hasDisplayName("Central European Time");

        try {
            Raw.timeZoneAssertion().hasDisplayName("");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).hasDisplayName("");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").hasDisplayName("");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasDisplayName("Greenwich Mean Time");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's display name.\n\tActual and expected values should be the same.\n\tExpected:<Greenwich Mean Time> but was:<Coordinated Universal Time>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").hasDisplayName("Greenwich Mean Time");
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's display name.\n\tActual and expected values should be the same.\n\tExpected:<Greenwich Mean Time> but was:<Coordinated Universal Time>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toRawOffsetTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toRawOffset().isEqualTo(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toRawOffset().isEqualTo(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toRawOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toRawOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toRawOffset().isEqualTo(7 * 60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toRawOffset().isEqualTo(60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toRawOffset().isEqualTo(60 * 60 * 1000);

        try {
            Raw.timeZoneAssertion().toRawOffset();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toRawOffset();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toRawOffset();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toRawOffset()).isEqualTo(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's raw offset.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toRawOffset()).isEqualTo(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's raw offset.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toRawOffset().isEqualTo(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's raw offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toRawOffset().isEqualTo(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's raw offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toRawOffsetMatcherTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toRawOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toRawOffset(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toRawOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toRawOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toRawOffset(Matchers.is(Matchers.equalTo(7 * 60 * 60 * 1000)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toRawOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toRawOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));

        try {
            Raw.timeZoneAssertion().toRawOffset(Matchers.equalTo(0));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toRawOffset(Matchers.equalTo(0));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toRawOffset(Matchers.equalTo(0));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toRawOffset(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toRawOffset(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toRawOffset(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toRawOffset(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toRawOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's raw offset.\nExpected: is <3600000>\n     but: was <0>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toRawOffset(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's raw offset.\nExpected: is <3600000>\n     but: was <0>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void hasRawOffsetTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasRawOffset(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).hasRawOffset(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).hasRawOffset(7 * 60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).hasRawOffset(7 * 60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).hasRawOffset(7 * 60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).hasRawOffset(60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).hasRawOffset(60 * 60 * 1000);

        try {
            Raw.timeZoneAssertion().hasRawOffset(0);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).hasRawOffset(0);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").hasRawOffset(0);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasRawOffset(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's raw offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").hasRawOffset(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's raw offset.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toUseDaylightTimeTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toUseDaylightTime().isFalse();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toUseDaylightTime().isFalse();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toUseDaylightTime().isFalse();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toUseDaylightTime().isFalse();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toUseDaylightTime().isFalse();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toUseDaylightTime().isTrue();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toUseDaylightTime().isTrue();

        try {
            Raw.timeZoneAssertion().toUseDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toUseDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toUseDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toUseDaylightTime()).isTrue();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's use daylight time.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toUseDaylightTime()).isTrue();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's use daylight time.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toUseDaylightTime().isTrue();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's use daylight time.\n\tActual value should be true.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toUseDaylightTime().isTrue();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's use daylight time.\n\tActual value should be true.");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toUseDaylightTimeMatcherTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toUseDaylightTime(Matchers.is(Matchers.equalTo(false)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toUseDaylightTime(Matchers.is(Matchers.equalTo(false)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toUseDaylightTime(Matchers.is(Matchers.equalTo(false)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toUseDaylightTime(Matchers.is(Matchers.equalTo(false)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toUseDaylightTime(Matchers.is(Matchers.equalTo(false)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toUseDaylightTime(Matchers.is(Matchers.equalTo(true)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toUseDaylightTime(Matchers.is(Matchers.equalTo(true)));

        try {
            Raw.timeZoneAssertion().toUseDaylightTime(Matchers.equalTo(false));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toUseDaylightTime(Matchers.equalTo(false));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toUseDaylightTime(Matchers.equalTo(false));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toUseDaylightTime(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toUseDaylightTime(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toUseDaylightTime(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toUseDaylightTime(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toUseDaylightTime(Matchers.is(Matchers.equalTo(true)));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's use daylight time.\nExpected: is <true>\n     but: was <false>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toUseDaylightTime(Matchers.is(Matchers.equalTo(true)));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's use daylight time.\nExpected: is <true>\n     but: was <false>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void useDaylightTimeTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).useDaylightTime();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).useDaylightTime();

        try {
            Raw.timeZoneAssertion().useDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).useDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").useDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).useDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's use daylight time.\n\tActual value should be true.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").useDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's use daylight time.\n\tActual value should be true.");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void doesNotUseDaylightTimeTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).doesNotUseDaylightTime();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).doesNotUseDaylightTime();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).doesNotUseDaylightTime();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).doesNotUseDaylightTime();
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).doesNotUseDaylightTime();

        try {
            Raw.timeZoneAssertion().doesNotUseDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).doesNotUseDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").doesNotUseDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).doesNotUseDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's use daylight time.\n\tActual value should be false.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin"), "Message").doesNotUseDaylightTime();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's use daylight time.\n\tActual value should be false.");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toDstSavingsTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDstSavings().isEqualTo(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toDstSavings().isEqualTo(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toDstSavings().isEqualTo(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toDstSavings().isEqualTo(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toDstSavings().isEqualTo(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toDstSavings().isEqualTo(60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toDstSavings().isEqualTo(60 * 60 * 1000);

        try {
            Raw.timeZoneAssertion().toDstSavings();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toDstSavings();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toDstSavings();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDstSavings()).isEqualTo(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST savings.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toDstSavings()).isEqualTo(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST savings.\n\tActual value should not be null.");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toDstSavingsMatcherTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDstSavings(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).toDstSavings(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).toDstSavings(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).toDstSavings(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).toDstSavings(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).toDstSavings(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).toDstSavings(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));

        try {
            Raw.timeZoneAssertion().toDstSavings(Matchers.equalTo(0));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toDstSavings(Matchers.equalTo(0));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toDstSavings(Matchers.equalTo(0));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).toDstSavings(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").toDstSavings(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDstSavings(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toDstSavings(null);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).toDstSavings(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST savings.\nExpected: is <3600000>\n     but: was <0>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").toDstSavings(Matchers.is(Matchers.equalTo(60 * 60 * 1000)));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST savings.\nExpected: is <3600000>\n     but: was <0>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void hasDstSavingsTest() {
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasDstSavings(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("GMT")).hasDstSavings(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Novosibirsk")).hasDstSavings(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Krasnoyarsk")).hasDstSavings(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Asia/Vientiane")).hasDstSavings(0);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Berlin")).hasDstSavings(60 * 60 * 1000);
        initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("Europe/Vienna")).hasDstSavings(60 * 60 * 1000);

        try {
            Raw.timeZoneAssertion().hasDstSavings(0);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null).hasDstSavings(0);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), null, "Message").hasDstSavings(0);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).hasDstSavings(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's DST savings.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").hasDstSavings(60 * 60 * 1000);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's DST savings.\n\tActual and expected values should be the same.\n\tExpected:<3600000> but was:<0>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.timeZoneAssertion(), null).isNull();

        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC")).isNull();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), TimeZone.getTimeZone("UTC"), "Message").isNull();
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<UTC>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        TimeZone value = TimeZone.getTimeZone("UTC");
        initialize(Raw.timeZoneAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.timeZoneAssertion(), value).isSameAs(TimeZone.getTimeZone("GMT"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<GMT> but was:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), value, "Message").isSameAs(TimeZone.getTimeZone("GMT"));
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<GMT> but was:<UTC>");
        }
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        TimeZone value = TimeZone.getTimeZone("UTC");
        initialize(Raw.timeZoneAssertion(), value).isNotSameAs(TimeZone.getTimeZone("GMT"));

        try {
            initialize(Raw.timeZoneAssertion(), value).isNotSameAs(value);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<UTC>");
        }
        try {
            initialize(Raw.timeZoneAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("TimeZoneAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<UTC>");
        }
    }

}
