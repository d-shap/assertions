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

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

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
        new ComparableAssertion(10, new FailDescription()).isEqualTo(10);
        new ComparableAssertion(75, new FailDescription()).isEqualTo(75);
        new ComparableAssertion(236, new FailDescription()).isEqualTo(236);
        new ComparableAssertion(257, new FailDescription()).isEqualTo(257);

        try {
            new ComparableAssertion(null, new FailDescription()).isEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isEqualTo(20);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<20> but was:<10>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotEqualToTest() {
        new ComparableAssertion(10, new FailDescription()).isNotEqualTo(15);
        new ComparableAssertion(75, new FailDescription()).isNotEqualTo(76);
        new ComparableAssertion(236, new FailDescription()).isNotEqualTo(143);
        new ComparableAssertion(257, new FailDescription()).isNotEqualTo(2);

        try {
            new ComparableAssertion(null, new FailDescription()).isNotEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isNotEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isNotEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<10>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isGreaterThanTest() {
        new ComparableAssertion(10, new FailDescription()).isGreaterThan(5);
        new ComparableAssertion(60, new FailDescription()).isGreaterThan(30);
        new ComparableAssertion(245, new FailDescription()).isGreaterThan(244);

        try {
            new ComparableAssertion(null, new FailDescription()).isGreaterThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isGreaterThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isGreaterThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isGreaterThan(11);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then the expected. Expected:<11> but was:<10>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToTest() {
        new ComparableAssertion(10, new FailDescription()).isGreaterThanOrEqualTo(5);
        new ComparableAssertion(60, new FailDescription()).isGreaterThanOrEqualTo(60);
        new ComparableAssertion(245, new FailDescription()).isGreaterThanOrEqualTo(244);

        try {
            new ComparableAssertion(null, new FailDescription()).isGreaterThanOrEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isGreaterThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isGreaterThanOrEqualTo(11);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be greater then or equal to the expected. Expected:<11> but was:<10>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isLessThanTest() {
        new ComparableAssertion(5, new FailDescription()).isLessThan(10);
        new ComparableAssertion(30, new FailDescription()).isLessThan(60);
        new ComparableAssertion(244, new FailDescription()).isLessThan(245);

        try {
            new ComparableAssertion(null, new FailDescription()).isLessThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isLessThan(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isLessThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<10>.");
        }
        try {
            new ComparableAssertion(11, new FailDescription()).isLessThan(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then the expected. Expected:<10> but was:<11>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToTest() {
        new ComparableAssertion(5, new FailDescription()).isLessThanOrEqualTo(10);
        new ComparableAssertion(60, new FailDescription()).isLessThanOrEqualTo(60);
        new ComparableAssertion(244, new FailDescription()).isLessThanOrEqualTo(245);

        try {
            new ComparableAssertion(null, new FailDescription()).isLessThanOrEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isLessThanOrEqualTo(null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(11, new FailDescription()).isLessThanOrEqualTo(10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<10> but was:<11>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isInRangeTest() {
        new ComparableAssertion(5, new FailDescription()).isInRange(4, 6);
        new ComparableAssertion(5, new FailDescription()).isInRange(5, 6);
        new ComparableAssertion(5, new FailDescription()).isInRange(1, 10);

        try {
            new ComparableAssertion(null, new FailDescription()).isInRange(10, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isInRange(null, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isInRange(10, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(5, new FailDescription()).isInRange(1, 5);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<1:5> but was:<5>.");
        }
        try {
            new ComparableAssertion(5, new FailDescription()).isInRange(6, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<6:10> but was:<5>.");
        }
        try {
            new ComparableAssertion(5, new FailDescription()).isInRange(8, 9);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be in the expected range. Expected:<8:9> but was:<5>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotInRangeTest() {
        new ComparableAssertion(5, new FailDescription()).isNotInRange(1, 5);
        new ComparableAssertion(5, new FailDescription()).isNotInRange(6, 10);
        new ComparableAssertion(5, new FailDescription()).isNotInRange(8, 9);

        try {
            new ComparableAssertion(null, new FailDescription()).isNotInRange(10, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isNotInRange(null, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(10, new FailDescription()).isNotInRange(10, null);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ComparableAssertion(5, new FailDescription()).isNotInRange(4, 6);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<4:6> but was:<5>.");
        }
        try {
            new ComparableAssertion(5, new FailDescription()).isNotInRange(5, 6);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<5:6> but was:<5>.");
        }
        try {
            new ComparableAssertion(5, new FailDescription()).isNotInRange(1, 10);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be in the expected range. Expected:<1:10> but was:<5>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new ComparableAssertion(null, new FailDescription()).isNull();

        try {
            new ComparableAssertion(5, new FailDescription()).isNull();
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<5>.");
        }
        try {
            new ComparableAssertion(5, new FailDescription("Message")).isNull();
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<5>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Comparable<?> value = 5.0;
        new ComparableAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new ComparableAssertion(value, new FailDescription()).isSameAs(5.0);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<5.0> but was:<5.0>.");
        }
        try {
            new ComparableAssertion(value, new FailDescription("Message")).isSameAs(5.0);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<5.0> but was:<5.0>.");
        }
        try {
            new ComparableAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<5.0>.");
        }
        try {
            new ComparableAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<5.0>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Comparable<?> value = 5.0;
        new ComparableAssertion(value, new FailDescription()).isNotSameAs(5.0);
        new ComparableAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new ComparableAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<5.0>.");
        }
        try {
            new ComparableAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("ComparableAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<5.0>.");
        }
    }

    /**
     * {@link ComparableAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString(5, true)).isEqualTo("5");
        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString(60, true)).isEqualTo("60");
        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString(244, true)).isEqualTo("244");
        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString("test", true)).isEqualTo("test");

        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString(5, false)).isEqualTo("5");
        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString(60, false)).isEqualTo("60");
        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString(244, false)).isEqualTo("244");
        Assertions.assertThat(new ComparableAssertion(5, new FailDescription()).asString("test", false)).isEqualTo("test");
    }

}
