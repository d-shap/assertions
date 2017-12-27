///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for the unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of assertions framework.
//
// Assertions framework is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Assertions framework is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program. If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////////////////////////
package ru.d_shap.assertions.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link LongAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public LongAssertionTest() {
        super();
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.longAssertion(), 10L);

        try {
            initializeWithRawActual(Raw.longAssertion(), new Object());
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.longAssertion(), new Object(), "Message");
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.longAssertion(), 10L).isEqualTo(10L);
        initialize(Raw.longAssertion(), 75L).isEqualTo(75L);
        initialize(Raw.longAssertion(), 236L).isEqualTo(236L);
        initialize(Raw.longAssertion(), 257L).isEqualTo(257L);

        try {
            Raw.longAssertion().isEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isEqualTo(20L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20> but was:<10>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isEqualTo(20L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20> but was:<10>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.longAssertion(), 10L).isNotEqualTo(15L);
        initialize(Raw.longAssertion(), 75L).isNotEqualTo(76L);
        initialize(Raw.longAssertion(), 236L).isNotEqualTo(143L);
        initialize(Raw.longAssertion(), 257L).isNotEqualTo(2L);

        try {
            Raw.longAssertion().isNotEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isNotEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isNotEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isNotEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isNotEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.longAssertion(), 10L).isGreaterThan(5L);
        initialize(Raw.longAssertion(), 60L).isGreaterThan(30L);
        initialize(Raw.longAssertion(), 245L).isGreaterThan(244L);

        try {
            Raw.longAssertion().isGreaterThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isGreaterThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isGreaterThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater then the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater then the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThan(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater then the expected.\n\tExpected:<11> but was:<10>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThan(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater then the expected.\n\tExpected:<11> but was:<10>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.longAssertion(), 10L).isGreaterThanOrEqualTo(5L);
        initialize(Raw.longAssertion(), 60L).isGreaterThanOrEqualTo(60L);
        initialize(Raw.longAssertion(), 245L).isGreaterThanOrEqualTo(244L);

        try {
            Raw.longAssertion().isGreaterThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isGreaterThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isGreaterThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isGreaterThanOrEqualTo(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater then or equal to the expected.\n\tExpected:<11> but was:<10>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isGreaterThanOrEqualTo(11L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater then or equal to the expected.\n\tExpected:<11> but was:<10>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.longAssertion(), 5L).isLessThan(10L);
        initialize(Raw.longAssertion(), 30L).isLessThan(60L);
        initialize(Raw.longAssertion(), 244L).isLessThan(245L);

        try {
            Raw.longAssertion().isLessThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isLessThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isLessThan(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 10L).isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less then the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less then the expected.\n\tExpected:<10> but was:<10>");
        }
        try {
            initialize(Raw.longAssertion(), 11L).isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less then the expected.\n\tExpected:<10> but was:<11>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").isLessThan(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less then the expected.\n\tExpected:<10> but was:<11>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.longAssertion(), 5L).isLessThanOrEqualTo(10L);
        initialize(Raw.longAssertion(), 60L).isLessThanOrEqualTo(60L);
        initialize(Raw.longAssertion(), 244L).isLessThanOrEqualTo(245L);

        try {
            Raw.longAssertion().isLessThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isLessThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isLessThanOrEqualTo(1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 11L).isLessThanOrEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less then or equal to the expected.\n\tExpected:<10> but was:<11>");
        }
        try {
            initialize(Raw.longAssertion(), 11L, "Message").isLessThanOrEqualTo(10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less then or equal to the expected.\n\tExpected:<10> but was:<11>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.longAssertion(), 5L).isInRange(4L, 6L);
        initialize(Raw.longAssertion(), 5L).isInRange(5L, 6L);
        initialize(Raw.longAssertion(), 5L).isInRange(1L, 10L);

        try {
            Raw.longAssertion().isInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(1L, 5L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(1L, 5L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(6L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(6L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isInRange(8L, 9L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8:9> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isInRange(8L, 9L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.longAssertion(), 5L).isNotInRange(1L, 5L);
        initialize(Raw.longAssertion(), 5L).isNotInRange(6L, 10L);
        initialize(Raw.longAssertion(), 5L).isNotInRange(8L, 9L);

        try {
            Raw.longAssertion().isNotInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.longAssertion(), null).isNotInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), null, "Message").isNotInRange(1L, 1L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(4L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(4L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(5L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(5L, 6L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L).isNotInRange(1L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1:10> but was:<5>");
        }
        try {
            initialize(Raw.longAssertion(), 5L, "Message").isNotInRange(1L, 10L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1:10> but was:<5>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.longAssertion(), null).isNull();

        try {
            initialize(Raw.longAssertion(), 10L).isNull();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<10>");
        }
        try {
            initialize(Raw.longAssertion(), 10L, "Message").isNull();
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<10>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Long value = 10000L;
        initialize(Raw.longAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.longAssertion(), value).isSameAs(10000L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10000> but was:<10000>");
        }
        try {
            initialize(Raw.longAssertion(), value, "Message").isSameAs(10000L);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10000> but was:<10000>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Long value = 10000L;
        initialize(Raw.longAssertion(), value).isNotSameAs(10000L);

        try {
            initialize(Raw.longAssertion(), value).isNotSameAs(value);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10000>");
        }
        try {
            initialize(Raw.longAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("LongAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10000>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString(null));
            Assertions.fail("LongAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString(5L)).isEqualTo("5");
        Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString(60L)).isEqualTo("60");
        Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString(244L)).isEqualTo("244");
        Assertions.assertThat(initialize(Raw.longAssertion(), 5L).asString("test")).isEqualTo("test");
    }

}
