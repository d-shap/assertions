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
package ru.d_shap.assertions.asimp.predicate;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import ru.d_shap.assertions.AssertionInvoker;
import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link NotPredicate}.
 *
 * @author Dmitry Shapovalov
 */
public final class NotPredicateTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public NotPredicateTest() {
        super();
    }

    /**
     * {@link NotPredicate} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        AssertionInvoker assertionInvoker = new AssertionInvoker() {

            @Override
            public void invoke() {
                Assertions.assertThat(5).isEqualTo(5);
            }
        };
        initialize(new NotPredicate(), assertionInvoker);

        try {
            initializeWithRawActual(new NotPredicate(), new Object());
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<ru.d_shap.assertions.AssertionInvoker> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(new NotPredicate(), new Object(), "Message");
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<ru.d_shap.assertions.AssertionInvoker> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link NotPredicate} class test.
     */
    @Test
    public void invokeTest() {
        AssertionInvoker assertionInvoker1 = new AssertionInvoker() {

            @Override
            public void invoke() {
                Assertions.assertThat(5).isEqualTo(5);
            }
        };
        AssertionInvoker assertionInvoker1Fail = new AssertionInvoker() {

            @Override
            public void invoke() {
                Assertions.assertThat(5).isEqualTo(6);
            }
        };
        AssertionInvoker assertionInvoker2 = new AssertionInvoker() {

            @Override
            public void invoke() {
                Assertions.assertThat(DataHelper.createArrayList()).isEmpty();
            }
        };
        AssertionInvoker assertionInvoker2Fail = new AssertionInvoker() {

            @Override
            public void invoke() {
                Assertions.assertWithMessage("Suspended message").that(DataHelper.createArrayList()).isNotEmpty();
            }
        };
        AssertionInvoker assertionInvoker3 = new AssertionInvoker() {

            @Override
            public void invoke() {
                Assertions.assertThat(DataHelper.createDate(2020, Calendar.SEPTEMBER, 10, 0, 0, 0)).isInstanceOf(Date.class);
            }
        };
        AssertionInvoker assertionInvoker3Fail = new AssertionInvoker() {

            @Override
            public void invoke() {
                Assertions.assertThat(DataHelper.createDate(2020, Calendar.SEPTEMBER, 10, 0, 0, 0)).isInstanceOf(Calendar.class);
            }
        };

        initialize(new NotPredicate(), assertionInvoker1Fail).invoke();
        initialize(new NotPredicate(), assertionInvoker2Fail).invoke();
        initialize(new NotPredicate(), assertionInvoker3Fail).invoke();

        try {
            new NotPredicate().invoke();
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new NotPredicate(), null).invoke();
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(new NotPredicate(), null, "Message").invoke();
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }

        try {
            initialize(new NotPredicate(), assertionInvoker1).invoke();
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion in NOT predicate does not fail.");
            Assertions.assertThat(ex).hasSuppressed();
        }
        try {
            initialize(new NotPredicate(), assertionInvoker1, "Message").invoke();
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion in NOT predicate does not fail.");
            Assertions.assertThat(ex).hasSuppressed();
        }
        try {
            initialize(new NotPredicate(), assertionInvoker2).invoke();
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion in NOT predicate does not fail.");
            Assertions.assertThat(ex).hasSuppressed();
        }
        try {
            initialize(new NotPredicate(), assertionInvoker2, "Message").invoke();
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion in NOT predicate does not fail.");
            Assertions.assertThat(ex).hasSuppressed();
        }
        try {
            initialize(new NotPredicate(), assertionInvoker3).invoke();
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion in NOT predicate does not fail.");
            Assertions.assertThat(ex).hasSuppressed();
        }
        try {
            initialize(new NotPredicate(), assertionInvoker3, "Message").invoke();
            Assertions.fail("NotPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tAssertion in NOT predicate does not fail.");
            Assertions.assertThat(ex).hasSuppressed();
        }
    }

}
