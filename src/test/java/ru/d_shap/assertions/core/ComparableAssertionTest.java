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
package ru.d_shap.assertions.core;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ComparableAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ComparableAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ComparableAssertionTest() {
        super();
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        initialize(Raw.comparableAssertion(), 10).isEqualTo(10);
        initialize(Raw.comparableAssertion(), 75).isEqualTo(75);
        initialize(Raw.comparableAssertion(), 236).isEqualTo(236);
        initialize(Raw.comparableAssertion(), 257).isEqualTo(257);

        try {
            initialize(Raw.comparableAssertion(), null).isEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isEqualTo(20);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        initialize(Raw.comparableAssertion(), 10).isNotEqualTo(15);
        initialize(Raw.comparableAssertion(), 75).isNotEqualTo(76);
        initialize(Raw.comparableAssertion(), 236).isNotEqualTo(143);
        initialize(Raw.comparableAssertion(), 257).isNotEqualTo(2);

        try {
            initialize(Raw.comparableAssertion(), null).isNotEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isNotEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isNotEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        initialize(Raw.comparableAssertion(), 10).isGreaterThan(5);
        initialize(Raw.comparableAssertion(), 60).isGreaterThan(30);
        initialize(Raw.comparableAssertion(), 245).isGreaterThan(244);

        try {
            initialize(Raw.comparableAssertion(), null).isGreaterThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isGreaterThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isGreaterThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isGreaterThan(11);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        initialize(Raw.comparableAssertion(), 10).isGreaterThanOrEqualTo(5);
        initialize(Raw.comparableAssertion(), 60).isGreaterThanOrEqualTo(60);
        initialize(Raw.comparableAssertion(), 245).isGreaterThanOrEqualTo(244);

        try {
            initialize(Raw.comparableAssertion(), null).isGreaterThanOrEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isGreaterThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isGreaterThanOrEqualTo(11);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        initialize(Raw.comparableAssertion(), 5).isLessThan(10);
        initialize(Raw.comparableAssertion(), 30).isLessThan(60);
        initialize(Raw.comparableAssertion(), 244).isLessThan(245);

        try {
            initialize(Raw.comparableAssertion(), null).isLessThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isLessThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isLessThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            initialize(Raw.comparableAssertion(), 11).isLessThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        initialize(Raw.comparableAssertion(), 5).isLessThanOrEqualTo(10);
        initialize(Raw.comparableAssertion(), 60).isLessThanOrEqualTo(60);
        initialize(Raw.comparableAssertion(), 244).isLessThanOrEqualTo(245);

        try {
            initialize(Raw.comparableAssertion(), null).isLessThanOrEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isLessThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 11).isLessThanOrEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        initialize(Raw.comparableAssertion(), 5).isInRange(4, 6);
        initialize(Raw.comparableAssertion(), 5).isInRange(5, 6);
        initialize(Raw.comparableAssertion(), 5).isInRange(1, 10);

        try {
            initialize(Raw.comparableAssertion(), null).isInRange(10, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isInRange(null, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isInRange(10, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 5).isInRange(1, 5);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>");
        }
        try {
            initialize(Raw.comparableAssertion(), 5).isInRange(6, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>");
        }
        try {
            initialize(Raw.comparableAssertion(), 5).isInRange(8, 9);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        initialize(Raw.comparableAssertion(), 5).isNotInRange(1, 5);
        initialize(Raw.comparableAssertion(), 5).isNotInRange(6, 10);
        initialize(Raw.comparableAssertion(), 5).isNotInRange(8, 9);

        try {
            initialize(Raw.comparableAssertion(), null).isNotInRange(10, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isNotInRange(null, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 10).isNotInRange(10, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.comparableAssertion(), 5).isNotInRange(4, 6);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>");
        }
        try {
            initialize(Raw.comparableAssertion(), 5).isNotInRange(5, 6);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>");
        }
        try {
            initialize(Raw.comparableAssertion(), 5).isNotInRange(1, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.comparableAssertion(), null).isNull();

        try {
            initialize(Raw.comparableAssertion(), 5).isNull();
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<5>");
        }
        try {
            initialize(Raw.comparableAssertion(), 5, "Message").isNull();
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<5>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Comparable<Double> value = 5.0;
        initialize(Raw.comparableAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.comparableAssertion(), value).isSameAs(5.0);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.comparableAssertion(), value, "Message").isSameAs(5.0);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.comparableAssertion(), value).isSameAs("test");
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<5.0>");
        }
        try {
            initialize(Raw.comparableAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<5.0>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Comparable<Double> value = 5.0;
        initialize(Raw.comparableAssertion(), value).isNotSameAs(5.0);
        initialize(Raw.comparableAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.comparableAssertion(), value).isNotSameAs(value);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<5.0>");
        }
        try {
            initialize(Raw.comparableAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<5.0>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.comparableAssertion(), 5).asString(null));
            Assertions.fail("ComparableAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.comparableAssertion(), 5).asString(5)).isEqualTo("5");
        Assertions.assertThat(initialize(Raw.comparableAssertion(), 5).asString(60)).isEqualTo("60");
        Assertions.assertThat(initialize(Raw.comparableAssertion(), 5).asString(244)).isEqualTo("244");
        Assertions.assertThat(initialize(Raw.comparableAssertion(), 5).asString("test")).isEqualTo("test");
    }

}
