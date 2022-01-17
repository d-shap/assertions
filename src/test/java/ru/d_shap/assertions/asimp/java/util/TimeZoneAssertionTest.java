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
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toDisplayNameMatcherTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void hasDisplayNameTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toRawOffsetTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toRawOffsetMatcherTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void hasRawOffsetTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toUseDaylightTimeTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toUseDaylightTimeMatcherTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void useDaylightTimeTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void doesNotUseDaylightTimeTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toDstSavingsTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void toDstSavingsMatcherTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void hasDstSavingsTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void isNullTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        // TODO
    }

    /**
     * {@link TimeZoneAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        // TODO
    }

}
