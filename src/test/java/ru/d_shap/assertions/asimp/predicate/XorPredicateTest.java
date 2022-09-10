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
 * Tests for {@link XorPredicate}.
 *
 * @author Dmitry Shapovalov
 */
public final class XorPredicateTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public XorPredicateTest() {
        super();
    }

    /**
     * {@link XorPredicate} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(new XorPredicate(), new AssertionInvoker[0]);

        try {
            initializeWithRawActual(new XorPredicate(), new Object());
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[Lru.d_shap.assertions.AssertionInvoker;> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(new XorPredicate(), new Object(), "Message");
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[Lru.d_shap.assertions.AssertionInvoker;> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link XorPredicate} class test.
     */
    @Test
    public void invokeTest() {
        AssertionInvoker assertionInvoker1 = createAssertionInvoker(5, 5);
        AssertionInvoker assertionInvoker1Fail = createAssertionInvoker(5, 6);
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

        initialize(new XorPredicate(), new AssertionInvoker[0]).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker2}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker3}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1, assertionInvoker2Fail}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1, assertionInvoker3Fail}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail, assertionInvoker2}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail, assertionInvoker3}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker2, assertionInvoker3Fail}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker2Fail, assertionInvoker3}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1, assertionInvoker2, assertionInvoker3}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1, assertionInvoker2Fail, assertionInvoker3Fail}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail, assertionInvoker2, assertionInvoker3Fail}).invoke();
        initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail, assertionInvoker2Fail, assertionInvoker3}).invoke();

        try {
            new XorPredicate().invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(new XorPredicate(), null).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(new XorPredicate(), null, "Message").invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }

        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker2Fail}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Suspended message.\n\tActual value should not be empty.");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker3Fail}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.util.Calendar> but was:<java.util.Date>");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1, assertionInvoker2}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed();
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1, assertionInvoker3}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed();
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker2, assertionInvoker3}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed();
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail, assertionInvoker2Fail}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Suspended message.\n\tActual value should not be empty.");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail, assertionInvoker3Fail}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.util.Calendar> but was:<java.util.Date>");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker2Fail, assertionInvoker3Fail}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Suspended message.\n\tActual value should not be empty.");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.util.Calendar> but was:<java.util.Date>");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail, assertionInvoker2, assertionInvoker3}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1, assertionInvoker2Fail, assertionInvoker3}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Suspended message.\n\tActual value should not be empty.");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1, assertionInvoker2, assertionInvoker3Fail}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.util.Calendar> but was:<java.util.Date>");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail, assertionInvoker2Fail, assertionInvoker3Fail}).invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("XOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Suspended message.\n\tActual value should not be empty.");
            Assertions.assertThat(ex).hasSuppressedMessage(2, "Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.util.Calendar> but was:<java.util.Date>");
        }
        try {
            initialize(new XorPredicate(), new AssertionInvoker[]{assertionInvoker1Fail, assertionInvoker2Fail, assertionInvoker3Fail}, "Message").invoke();
            Assertions.fail("XorPredicate test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tXOR predicate failed.");
            Assertions.assertThat(ex).hasSuppressed(AssertionError.class, AssertionError.class, AssertionError.class);
            Assertions.assertThat(ex).hasSuppressedMessage(0, "Actual and expected values should be the same.\n\tExpected:<6> but was:<5>");
            Assertions.assertThat(ex).hasSuppressedMessage(1, "Suspended message.\n\tActual value should not be empty.");
            Assertions.assertThat(ex).hasSuppressedMessage(2, "Check actual value's class.\n\tActual value should be the subtype of the expected value.\n\tExpected:<java.util.Calendar> but was:<java.util.Date>");
        }
    }

}
