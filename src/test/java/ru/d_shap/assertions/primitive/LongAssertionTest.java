///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
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
package ru.d_shap.assertions.primitive;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link LongAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class LongAssertionTest {

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
    public void isEqualToTest() {
        new LongAssertion(10L, null).isEqualTo(10L);
        new LongAssertion(75L, null).isEqualTo(75L);
        new LongAssertion(236L, null).isEqualTo(236L);
        new LongAssertion(257L, null).isEqualTo(257L);

        try {
            new LongAssertion(10L, null).isEqualTo(20L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new LongAssertion(10L, null).isNotEqualTo(15L);
        new LongAssertion(75L, null).isNotEqualTo(76L);
        new LongAssertion(236L, null).isNotEqualTo(143L);
        new LongAssertion(257L, null).isNotEqualTo(2L);

        try {
            new LongAssertion(10L, null).isNotEqualTo(10L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new LongAssertion(10L, null).isGreaterThan(5L);
        new LongAssertion(60L, null).isGreaterThan(30L);
        new LongAssertion(245L, null).isGreaterThan(244L);

        try {
            new LongAssertion(10L, null).isGreaterThan(10L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            new LongAssertion(10L, null).isGreaterThan(11L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new LongAssertion(10L, null).isGreaterThanOrEqualTo(5L);
        new LongAssertion(60L, null).isGreaterThanOrEqualTo(60L);
        new LongAssertion(245L, null).isGreaterThanOrEqualTo(244L);

        try {
            new LongAssertion(10L, null).isGreaterThanOrEqualTo(11L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new LongAssertion(5L, null).isLessThan(10L);
        new LongAssertion(30L, null).isLessThan(60L);
        new LongAssertion(244L, null).isLessThan(245L);

        try {
            new LongAssertion(10L, null).isLessThan(10L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            new LongAssertion(11L, null).isLessThan(10L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new LongAssertion(5L, null).isLessThanOrEqualTo(10L);
        new LongAssertion(60L, null).isLessThanOrEqualTo(60L);
        new LongAssertion(244L, null).isLessThanOrEqualTo(245L);

        try {
            new LongAssertion(11L, null).isLessThanOrEqualTo(10L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new LongAssertion(5L, null).isInRange(4L, 6L);
        new LongAssertion(5L, null).isInRange(5L, 6L);
        new LongAssertion(5L, null).isInRange(1L, 10L);

        try {
            new LongAssertion(5L, null).isInRange(1L, 5L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>");
        }
        try {
            new LongAssertion(5L, null).isInRange(6L, 10L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>");
        }
        try {
            new LongAssertion(5L, null).isInRange(8L, 9L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new LongAssertion(5L, null).isNotInRange(1L, 5L);
        new LongAssertion(5L, null).isNotInRange(6L, 10L);
        new LongAssertion(5L, null).isNotInRange(8L, 9L);

        try {
            new LongAssertion(5L, null).isNotInRange(4L, 6L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>");
        }
        try {
            new LongAssertion(5L, null).isNotInRange(5L, 6L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>");
        }
        try {
            new LongAssertion(5L, null).isNotInRange(1L, 10L);
            Assertions.fail("Long assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>");
        }
    }

    /**
     * {@link LongAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new LongAssertion(5L, null).asString(null)).isNull();
        Assertions.assertThat(new LongAssertion(5L, null).asString(5L)).isEqualTo("5");
        Assertions.assertThat(new LongAssertion(5L, null).asString(60L)).isEqualTo("60");
        Assertions.assertThat(new LongAssertion(5L, null).asString(244L)).isEqualTo("244");
        Assertions.assertThat(new LongAssertion(5L, null).asString("test")).isEqualTo("test");
    }

}
