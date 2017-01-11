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
        new ShortAssertion((short) 10, null).isEqualTo((short) 10);
        new ShortAssertion((short) 75, null).isEqualTo((short) 75);
        new ShortAssertion((short) 236, null).isEqualTo((short) 236);
        new ShortAssertion((short) 257, null).isEqualTo((short) 257);

        try {
            new ShortAssertion((short) 10, null).isEqualTo((short) 20);
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
        new ShortAssertion((short) 10, null).isNotEqualTo((short) 15);
        new ShortAssertion((short) 75, null).isNotEqualTo((short) 76);
        new ShortAssertion((short) 236, null).isNotEqualTo((short) 143);
        new ShortAssertion((short) 257, null).isNotEqualTo((short) 2);

        try {
            new ShortAssertion((short) 10, null).isNotEqualTo((short) 10);
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
        new ShortAssertion((short) 10, null).isGreaterThan((short) 5);
        new ShortAssertion((short) 60, null).isGreaterThan((short) 30);
        new ShortAssertion((short) 245, null).isGreaterThan((short) 244);

        try {
            new ShortAssertion((short) 10, null).isGreaterThan((short) 10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>");
        }
        try {
            new ShortAssertion((short) 10, null).isGreaterThan((short) 11);
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
        new ShortAssertion((short) 10, null).isGreaterThanOrEqualTo((short) 5);
        new ShortAssertion((short) 60, null).isGreaterThanOrEqualTo((short) 60);
        new ShortAssertion((short) 245, null).isGreaterThanOrEqualTo((short) 244);

        try {
            new ShortAssertion((short) 10, null).isGreaterThanOrEqualTo((short) 11);
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
        new ShortAssertion((short) 5, null).isLessThan((short) 10);
        new ShortAssertion((short) 30, null).isLessThan((short) 60);
        new ShortAssertion((short) 244, null).isLessThan((short) 245);

        try {
            new ShortAssertion((short) 10, null).isLessThan((short) 10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>");
        }
        try {
            new ShortAssertion((short) 11, null).isLessThan((short) 10);
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
        new ShortAssertion((short) 5, null).isLessThanOrEqualTo((short) 10);
        new ShortAssertion((short) 60, null).isLessThanOrEqualTo((short) 60);
        new ShortAssertion((short) 244, null).isLessThanOrEqualTo((short) 245);

        try {
            new ShortAssertion((short) 11, null).isLessThanOrEqualTo((short) 10);
            Assertions.fail("Short assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>");
        }
    }

}
