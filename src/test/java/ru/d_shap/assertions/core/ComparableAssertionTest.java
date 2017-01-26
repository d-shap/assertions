///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2016 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ComparableAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ComparableAssertionTest {

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
        new ComparableAssertion(10, null).isEqualTo(10);
        new ComparableAssertion(75, null).isEqualTo(75);
        new ComparableAssertion(236, null).isEqualTo(236);
        new ComparableAssertion(257, null).isEqualTo(257);

        try {
            new ComparableAssertion(null, null).isEqualTo(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isEqualTo(null);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isEqualTo(20);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ComparableAssertion(10, null).isNotEqualTo(15);
        new ComparableAssertion(75, null).isNotEqualTo(76);
        new ComparableAssertion(236, null).isNotEqualTo(143);
        new ComparableAssertion(257, null).isNotEqualTo(2);

        try {
            new ComparableAssertion(null, null).isNotEqualTo(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isNotEqualTo(null);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isNotEqualTo(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new ComparableAssertion(10, null).isGreaterThan(5);
        new ComparableAssertion(60, null).isGreaterThan(30);
        new ComparableAssertion(245, null).isGreaterThan(244);

        try {
            new ComparableAssertion(null, null).isGreaterThan(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isGreaterThan(null);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isGreaterThan(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            new ComparableAssertion(10, null).isGreaterThan(11);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new ComparableAssertion(10, null).isGreaterThanOrEqualTo(5);
        new ComparableAssertion(60, null).isGreaterThanOrEqualTo(60);
        new ComparableAssertion(245, null).isGreaterThanOrEqualTo(244);

        try {
            new ComparableAssertion(null, null).isGreaterThanOrEqualTo(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isGreaterThanOrEqualTo(null);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isGreaterThanOrEqualTo(11);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new ComparableAssertion(5, null).isLessThan(10);
        new ComparableAssertion(30, null).isLessThan(60);
        new ComparableAssertion(244, null).isLessThan(245);

        try {
            new ComparableAssertion(null, null).isLessThan(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isLessThan(null);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isLessThan(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            new ComparableAssertion(11, null).isLessThan(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new ComparableAssertion(5, null).isLessThanOrEqualTo(10);
        new ComparableAssertion(60, null).isLessThanOrEqualTo(60);
        new ComparableAssertion(244, null).isLessThanOrEqualTo(245);

        try {
            new ComparableAssertion(null, null).isLessThanOrEqualTo(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isLessThanOrEqualTo(null);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(11, null).isLessThanOrEqualTo(10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new ComparableAssertion(5, null).isInRange(4, 6);
        new ComparableAssertion(5, null).isInRange(5, 6);
        new ComparableAssertion(5, null).isInRange(1, 10);

        try {
            new ComparableAssertion(null, null).isInRange(10, 10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isInRange(null, 10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isInRange(10, null);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(5, null).isInRange(1, 5);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>");
        }
        try {
            new ComparableAssertion(5, null).isInRange(6, 10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>");
        }
        try {
            new ComparableAssertion(5, null).isInRange(8, 9);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new ComparableAssertion(5, null).isNotInRange(1, 5);
        new ComparableAssertion(5, null).isNotInRange(6, 10);
        new ComparableAssertion(5, null).isNotInRange(8, 9);

        try {
            new ComparableAssertion(null, null).isNotInRange(10, 10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isNotInRange(null, 10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, null).isNotInRange(10, null);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(5, null).isNotInRange(4, 6);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>");
        }
        try {
            new ComparableAssertion(5, null).isNotInRange(5, 6);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>");
        }
        try {
            new ComparableAssertion(5, null).isNotInRange(1, 10);
            Assertions.fail("Comparable assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ComparableAssertion(5, null).asString(null)).isNull();
        Assertions.assertThat(new ComparableAssertion(5, null).asString(5)).isEqualTo("5");
        Assertions.assertThat(new ComparableAssertion(5, null).asString(60)).isEqualTo("60");
        Assertions.assertThat(new ComparableAssertion(5, null).asString(244)).isEqualTo("244");
        Assertions.assertThat(new ComparableAssertion(5, null).asString("test")).isEqualTo("test");
    }

}
