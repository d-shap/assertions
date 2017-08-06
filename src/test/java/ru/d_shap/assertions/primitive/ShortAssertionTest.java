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

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ShortAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ShortAssertionTest {

    /**
     * Test class constructor.
     */
    public ShortAssertionTest() {
        super();
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isEqualToTest() {
        new ShortAssertion((short) 10, null).isEqualTo(10);
        new ShortAssertion((short) 75, null).isEqualTo(75);
        new ShortAssertion((short) 236, null).isEqualTo(236);
        new ShortAssertion((short) 257, null).isEqualTo(257);

        try {
            new ShortAssertion((short) 10, null).isEqualTo(20);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ShortAssertion((short) 10, null).isNotEqualTo(15);
        new ShortAssertion((short) 75, null).isNotEqualTo(76);
        new ShortAssertion((short) 236, null).isNotEqualTo(143);
        new ShortAssertion((short) 257, null).isNotEqualTo(2);

        try {
            new ShortAssertion((short) 10, null).isNotEqualTo(10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new ShortAssertion((short) 10, null).isGreaterThan(5);
        new ShortAssertion((short) 60, null).isGreaterThan(30);
        new ShortAssertion((short) 245, null).isGreaterThan(244);

        try {
            new ShortAssertion((short) 10, null).isGreaterThan(10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            new ShortAssertion((short) 10, null).isGreaterThan(11);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new ShortAssertion((short) 10, null).isGreaterThanOrEqualTo(5);
        new ShortAssertion((short) 60, null).isGreaterThanOrEqualTo(60);
        new ShortAssertion((short) 245, null).isGreaterThanOrEqualTo(244);

        try {
            new ShortAssertion((short) 10, null).isGreaterThanOrEqualTo(11);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new ShortAssertion((short) 5, null).isLessThan(10);
        new ShortAssertion((short) 30, null).isLessThan(60);
        new ShortAssertion((short) 244, null).isLessThan(245);

        try {
            new ShortAssertion((short) 10, null).isLessThan(10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            new ShortAssertion((short) 11, null).isLessThan(10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new ShortAssertion((short) 5, null).isLessThanOrEqualTo(10);
        new ShortAssertion((short) 60, null).isLessThanOrEqualTo(60);
        new ShortAssertion((short) 244, null).isLessThanOrEqualTo(245);

        try {
            new ShortAssertion((short) 11, null).isLessThanOrEqualTo(10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new ShortAssertion((short) 5, null).isInRange(4, 6);
        new ShortAssertion((short) 5, null).isInRange(5, 6);
        new ShortAssertion((short) 5, null).isInRange(1, 10);

        try {
            new ShortAssertion((short) 5, null).isInRange(1, 5);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>");
        }
        try {
            new ShortAssertion((short) 5, null).isInRange(6, 10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>");
        }
        try {
            new ShortAssertion((short) 5, null).isInRange(8, 9);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new ShortAssertion((short) 5, null).isNotInRange(1, 5);
        new ShortAssertion((short) 5, null).isNotInRange(6, 10);
        new ShortAssertion((short) 5, null).isNotInRange(8, 9);

        try {
            new ShortAssertion((short) 5, null).isNotInRange(4, 6);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>");
        }
        try {
            new ShortAssertion((short) 5, null).isNotInRange(5, 6);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>");
        }
        try {
            new ShortAssertion((short) 5, null).isNotInRange(1, 10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>");
        }
    }

    /**
     * {@link ShortAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ShortAssertion((short) 5, null).asString(null)).isNull();
        Assertions.assertThat(new ShortAssertion((short) 5, null).asString((short) 5)).isEqualTo("5");
        Assertions.assertThat(new ShortAssertion((short) 5, null).asString((short) 60)).isEqualTo("60");
        Assertions.assertThat(new ShortAssertion((short) 5, null).asString((short) 244)).isEqualTo("244");
        Assertions.assertThat(new ShortAssertion((short) 5, null).asString("test")).isEqualTo("test");
    }

}
