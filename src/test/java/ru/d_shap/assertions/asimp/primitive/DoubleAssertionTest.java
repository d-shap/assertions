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
package ru.d_shap.assertions.asimp.primitive;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link DoubleAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class DoubleAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public DoubleAssertionTest() {
        super();
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.doubleAssertion(), 10.0);

        try {
            initializeWithRawActual(Raw.doubleAssertion(), new Object());
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Double> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.doubleAssertion(), new Object(), "Message");
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.lang.Double> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isEqualToDefaultDeltaPrimitiveTest() {
        initialize(Raw.doubleAssertion(), 10.1).isEqualTo(10.1);
        initialize(Raw.doubleAssertion(), 10.01).isEqualTo(10.01);
        initialize(Raw.doubleAssertion(), 10.001).isEqualTo(10.001);
        initialize(Raw.doubleAssertion(), 10.0001).isEqualTo(10.0001);
        initialize(Raw.doubleAssertion(), 10.00001).isEqualTo(10.00001);
        initialize(Raw.doubleAssertion(), 10.000001).isEqualTo(10.000001);
        initialize(Raw.doubleAssertion(), 10.0000001).isEqualTo(10.0000001);
        initialize(Raw.doubleAssertion(), 10.00000001).isEqualTo(10.00000001);
        initialize(Raw.doubleAssertion(), 10.000000001).isEqualTo(10.000000001);
        initialize(Raw.doubleAssertion(), 10.0000000001).isEqualTo(10.0000000001);
        initialize(Raw.doubleAssertion(), 10.00000000001).isEqualTo(10.00000000001);
        initialize(Raw.doubleAssertion(), 10.000000000011).isEqualTo(10.000000000012);
        initialize(Raw.doubleAssertion(), 10.000000000001).isEqualTo(10.000000000002);
        initialize(Raw.doubleAssertion(), 10.0000000000001).isEqualTo(10.0000000000002);

        try {
            Raw.doubleAssertion().isEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.00000000001).isEqualTo(10.00000000002);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.00000000002±9.999999960041972E-12> but was:<10.00000000001>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.00000000001, "Message").isEqualTo(10.00000000002);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.00000000002±9.999999960041972E-12> but was:<10.00000000001>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isEqualToDefaultDeltaObjectTest() {
        initialize(Raw.doubleAssertion(), null).isEqualTo(null);
        initialize(Raw.doubleAssertion(), 10.1).isEqualTo(Double.valueOf("10.1"));
        initialize(Raw.doubleAssertion(), 10.01).isEqualTo(Double.valueOf("10.01"));
        initialize(Raw.doubleAssertion(), 10.001).isEqualTo(Double.valueOf("10.001"));
        initialize(Raw.doubleAssertion(), 10.0001).isEqualTo(Double.valueOf("10.0001"));
        initialize(Raw.doubleAssertion(), 10.00001).isEqualTo(Double.valueOf("10.00001"));
        initialize(Raw.doubleAssertion(), 10.000001).isEqualTo(Double.valueOf("10.000001"));
        initialize(Raw.doubleAssertion(), 10.0000001).isEqualTo(Double.valueOf("10.0000001"));
        initialize(Raw.doubleAssertion(), 10.00000001).isEqualTo(Double.valueOf("10.00000001"));
        initialize(Raw.doubleAssertion(), 10.000000001).isEqualTo(Double.valueOf("10.000000001"));
        initialize(Raw.doubleAssertion(), 10.0000000001).isEqualTo(Double.valueOf("10.0000000001"));
        initialize(Raw.doubleAssertion(), 10.00000000001).isEqualTo(Double.valueOf("10.00000000001"));
        initialize(Raw.doubleAssertion(), 10.000000000011).isEqualTo(Double.valueOf("10.000000000012"));
        initialize(Raw.doubleAssertion(), 10.000000000001).isEqualTo(Double.valueOf("10.000000000002"));
        initialize(Raw.doubleAssertion(), 10.0000000000001).isEqualTo(Double.valueOf("10.0000000000002"));

        try {
            Raw.doubleAssertion().isEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.00000000001).isEqualTo(Double.valueOf("10.00000000002"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.00000000002±9.999999960041972E-12> but was:<10.00000000001>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.00000000001, "Message").isEqualTo(Double.valueOf("10.00000000002"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.00000000002±9.999999960041972E-12> but was:<10.00000000001>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isEqualToSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(10.0, 0.01);
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(9.999, 0.01);
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(10.001, 0.01);
        initialize(Raw.doubleAssertion(), 0.0).isEqualTo(0.0, 0.01);
        initialize(Raw.doubleAssertion(), Double.MAX_VALUE).isEqualTo(Double.MAX_VALUE, 0.01);
        initialize(Raw.doubleAssertion(), -0.0).isEqualTo(+0.0, 0.0);
        initialize(Raw.doubleAssertion(), +0.0).isEqualTo(-0.0, 0.0);

        try {
            Raw.doubleAssertion().isEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.01±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(10.01, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.01±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(9.99, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<9.99±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(9.99, 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<9.99±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(20.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20.0±0.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(20.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20.0±0.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isEqualToSpecifiedDeltaObjectTest() {
        initialize(Raw.doubleAssertion(), null).isEqualTo(null, 0.01);
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(Double.valueOf("10.0"), 0.01);
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(Double.valueOf("9.999"), 0.01);
        initialize(Raw.doubleAssertion(), 10.0).isEqualTo(Double.valueOf("10.001"), 0.01);
        initialize(Raw.doubleAssertion(), 0.0).isEqualTo(Double.valueOf("0.0"), 0.01);
        initialize(Raw.doubleAssertion(), Double.MAX_VALUE).isEqualTo(Double.valueOf(Double.MAX_VALUE), 0.01);

        try {
            Raw.doubleAssertion().isEqualTo(Double.valueOf("1.0"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isEqualTo(Double.valueOf("1.0"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isEqualTo(Double.valueOf("1.0"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isEqualTo(null, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isEqualTo(null, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<1.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(Double.valueOf("10.01"), 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<10.01±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(Double.valueOf("10.01"), 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<10.01±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(Double.valueOf("9.99"), 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<9.99±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(Double.valueOf("9.99"), 0.001);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<9.99±0.001> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isEqualTo(Double.valueOf("20.0"), 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<20.0±0.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isEqualTo(Double.valueOf("20.0"), 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<20.0±0.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotEqualToDefaultDeltaPrimitiveTest() {
        initialize(Raw.doubleAssertion(), 10.1).isNotEqualTo(10.2);
        initialize(Raw.doubleAssertion(), 10.01).isNotEqualTo(10.02);
        initialize(Raw.doubleAssertion(), 10.001).isNotEqualTo(10.002);
        initialize(Raw.doubleAssertion(), 10.0001).isNotEqualTo(10.0002);
        initialize(Raw.doubleAssertion(), 10.00001).isNotEqualTo(10.00002);
        initialize(Raw.doubleAssertion(), 10.000001).isNotEqualTo(10.000002);
        initialize(Raw.doubleAssertion(), 10.0000001).isNotEqualTo(10.0000002);
        initialize(Raw.doubleAssertion(), 10.00000001).isNotEqualTo(10.00000002);
        initialize(Raw.doubleAssertion(), 10.000000001).isNotEqualTo(10.000000002);
        initialize(Raw.doubleAssertion(), 10.0000000001).isNotEqualTo(10.0000000002);
        initialize(Raw.doubleAssertion(), 10.00000000001).isNotEqualTo(10.00000000002);

        try {
            Raw.doubleAssertion().isNotEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.000000000001).isNotEqualTo(10.000000000002);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.000000000001±9.999999960041972E-12>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.000000000001, "Message").isNotEqualTo(10.000000000002);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.000000000001±9.999999960041972E-12>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotEqualToDefaultDeltaObjectTest() {
        initialize(Raw.doubleAssertion(), null).isNotEqualTo(Double.valueOf("5.0"));
        initialize(Raw.doubleAssertion(), 5.0).isNotEqualTo(null);
        initialize(Raw.doubleAssertion(), 10.1).isNotEqualTo(Double.valueOf("10.2"));
        initialize(Raw.doubleAssertion(), 10.01).isNotEqualTo(Double.valueOf("10.02"));
        initialize(Raw.doubleAssertion(), 10.001).isNotEqualTo(Double.valueOf("10.002"));
        initialize(Raw.doubleAssertion(), 10.0001).isNotEqualTo(Double.valueOf("10.0002"));
        initialize(Raw.doubleAssertion(), 10.00001).isNotEqualTo(Double.valueOf("10.00002"));
        initialize(Raw.doubleAssertion(), 10.000001).isNotEqualTo(Double.valueOf("10.000002"));
        initialize(Raw.doubleAssertion(), 10.0000001).isNotEqualTo(Double.valueOf("10.0000002"));
        initialize(Raw.doubleAssertion(), 10.00000001).isNotEqualTo(Double.valueOf("10.00000002"));
        initialize(Raw.doubleAssertion(), 10.000000001).isNotEqualTo(Double.valueOf("10.000000002"));
        initialize(Raw.doubleAssertion(), 10.0000000001).isNotEqualTo(Double.valueOf("10.0000000002"));
        initialize(Raw.doubleAssertion(), 10.00000000001).isNotEqualTo(Double.valueOf("10.00000000002"));

        try {
            Raw.doubleAssertion().isNotEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.000000000001).isNotEqualTo(Double.valueOf("10.000000000002"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.000000000001±9.999999960041972E-12>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.000000000001, "Message").isNotEqualTo(Double.valueOf("10.000000000002"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.000000000001±9.999999960041972E-12>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotEqualToSpecifiedDeltaPrimitiveTest() {
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(10.01, 0.001);
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(9.99, 0.001);
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(20.0, 0.0);

        try {
            Raw.doubleAssertion().isNotEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotEqualTo(1.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(10.001, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(10.001, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(9.999, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(9.999, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(10.0, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0).isNotEqualTo(-0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<0.0±0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0, "Message").isNotEqualTo(-0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<0.0±0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0).isNotEqualTo(+0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<-0.0±0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0, "Message").isNotEqualTo(+0.0, 0.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<-0.0±0.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotEqualToSpecifiedDeltaObjectTest() {
        initialize(Raw.doubleAssertion(), null).isNotEqualTo(Double.valueOf("5.0"), 0.001);
        initialize(Raw.doubleAssertion(), 5.0).isNotEqualTo(null, 0.001);
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(Double.valueOf("10.01"), 0.001);
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(Double.valueOf("9.99"), 0.001);
        initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(Double.valueOf("20.0"), 0.0);

        try {
            Raw.doubleAssertion().isNotEqualTo(Double.valueOf("1.0"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotEqualTo(null, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotEqualTo(null, 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(Double.valueOf("10.001"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(Double.valueOf("10.001"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(Double.valueOf("9.999"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(Double.valueOf("9.999"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotEqualTo(Double.valueOf("10.0"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotEqualTo(Double.valueOf("10.0"), 0.01);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<10.0±0.01>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanPrimitiveTest() {
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(9.0);
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(8.0);
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(-1.0);

        try {
            Raw.doubleAssertion().isGreaterThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThan(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanObjectTest() {
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(Double.valueOf("9.0"));
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(Double.valueOf("8.0"));
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(Double.valueOf("-1.0"));

        try {
            Raw.doubleAssertion().isGreaterThan(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThan(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThan(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThan(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThan(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isGreaterThan(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isGreaterThan(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(Double.valueOf("10.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThan(Double.valueOf("10.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThan(Double.valueOf("11.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThan(Double.valueOf("11.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToPrimitiveTest() {
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(9.0);
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(10.0);
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(-1.0);

        try {
            Raw.doubleAssertion().isGreaterThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThanOrEqualTo(11.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isGreaterThanOrEqualToObjectTest() {
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(Double.valueOf("9.0"));
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(Double.valueOf("10.0"));
        initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(Double.valueOf("-1.0"));

        try {
            Raw.doubleAssertion().isGreaterThanOrEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThanOrEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThanOrEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isGreaterThanOrEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isGreaterThanOrEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isGreaterThanOrEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isGreaterThanOrEqualTo(Double.valueOf("11.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be greater than or equal to the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isGreaterThanOrEqualTo(Double.valueOf("11.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be greater than or equal to the expected.\n\tExpected:<11.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanPrimitiveTest() {
        initialize(Raw.doubleAssertion(), 10.0).isLessThan(11.0);
        initialize(Raw.doubleAssertion(), 10.0).isLessThan(12.0);
        initialize(Raw.doubleAssertion(), 10.0).isLessThan(100.0);

        try {
            Raw.doubleAssertion().isLessThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThan(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThan(10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThan(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanObjectTest() {
        initialize(Raw.doubleAssertion(), 10.0).isLessThan(Double.valueOf("11.0"));
        initialize(Raw.doubleAssertion(), 10.0).isLessThan(Double.valueOf("12.0"));
        initialize(Raw.doubleAssertion(), 10.0).isLessThan(Double.valueOf("100.0"));

        try {
            Raw.doubleAssertion().isLessThan(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThan(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThan(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThan(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThan(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isLessThan(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isLessThan(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThan(Double.valueOf("10.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThan(Double.valueOf("10.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<10.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThan(Double.valueOf("9.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThan(Double.valueOf("9.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToPrimitiveTest() {
        initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(11.0);
        initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(10.0);
        initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(100.0);

        try {
            Raw.doubleAssertion().isLessThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThanOrEqualTo(1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThanOrEqualTo(9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isLessThanOrEqualToObjectTest() {
        initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(Double.valueOf("11.0"));
        initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(Double.valueOf("10.0"));
        initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(Double.valueOf("100.0"));

        try {
            Raw.doubleAssertion().isLessThanOrEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThanOrEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThanOrEqualTo(Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isLessThanOrEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isLessThanOrEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isLessThanOrEqualTo(null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isLessThanOrEqualTo(Double.valueOf("9.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be less than or equal to the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isLessThanOrEqualTo(Double.valueOf("9.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be less than or equal to the expected.\n\tExpected:<9.0> but was:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isInRangePrimitiveTest() {
        initialize(Raw.doubleAssertion(), 5.0).isInRange(4.0, 6.0);
        initialize(Raw.doubleAssertion(), 5.0).isInRange(5.0, 6.0);
        initialize(Raw.doubleAssertion(), 5.0).isInRange(1.0, 10.0);

        try {
            Raw.doubleAssertion().isInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(1.0, 5.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(6.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(6.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(8.0, 9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8.0:9.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(8.0, 9.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8.0:9.0> but was:<5.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isInRangeObjectTest() {
        initialize(Raw.doubleAssertion(), 5.0).isInRange(Double.valueOf("4.0"), Double.valueOf("6.0"));
        initialize(Raw.doubleAssertion(), 5.0).isInRange(Double.valueOf("5.0"), Double.valueOf("6.0"));
        initialize(Raw.doubleAssertion(), 5.0).isInRange(Double.valueOf("1.0"), Double.valueOf("10.0"));

        try {
            Raw.doubleAssertion().isInRange(Double.valueOf("1.0"), Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isInRange(Double.valueOf("1.0"), Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isInRange(Double.valueOf("1.0"), Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isInRange(null, Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isInRange(null, Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isInRange(null, Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isInRange(null, Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isInRange(null, null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isInRange(null, null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isInRange(Double.valueOf("1.0"), null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isInRange(Double.valueOf("1.0"), null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(Double.valueOf("1.0"), Double.valueOf("5.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(Double.valueOf("1.0"), Double.valueOf("5.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<1.0:5.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(Double.valueOf("6.0"), Double.valueOf("10.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(Double.valueOf("6.0"), Double.valueOf("10.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<6.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isInRange(Double.valueOf("8.0"), Double.valueOf("9.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be in the expected range.\n\tExpected:<8.0:9.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isInRange(Double.valueOf("8.0"), Double.valueOf("9.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be in the expected range.\n\tExpected:<8.0:9.0> but was:<5.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotInRangePrimitiveTest() {
        initialize(Raw.doubleAssertion(), 5.0).isNotInRange(1.0, 5.0);
        initialize(Raw.doubleAssertion(), 5.0).isNotInRange(6.0, 10.0);
        initialize(Raw.doubleAssertion(), 5.0).isNotInRange(8.0, 9.0);

        try {
            Raw.doubleAssertion().isNotInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotInRange(1.0, 1.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(4.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(5.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(5.0, 6.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(1.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(1.0, 10.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1.0:10.0> but was:<5.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotInRangeObjectTest() {
        initialize(Raw.doubleAssertion(), 5.0).isNotInRange(Double.valueOf("1.0"), Double.valueOf("5.0"));
        initialize(Raw.doubleAssertion(), 5.0).isNotInRange(Double.valueOf("6.0"), Double.valueOf("10.0"));
        initialize(Raw.doubleAssertion(), 5.0).isNotInRange(Double.valueOf("8.0"), Double.valueOf("9.0"));

        try {
            Raw.doubleAssertion().isNotInRange(Double.valueOf("1.0"), Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotInRange(Double.valueOf("1.0"), Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotInRange(Double.valueOf("1.0"), Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotInRange(null, Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotInRange(null, Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isNotInRange(null, Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isNotInRange(null, Double.valueOf("1.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isNotInRange(null, null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isNotInRange(null, null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedFrom.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0).isNotInRange(Double.valueOf("1.0"), null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.doubleAssertion(), 1.0, "Message").isNotInRange(Double.valueOf("1.0"), null);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expectedTo.");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(Double.valueOf("4.0"), Double.valueOf("6.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(Double.valueOf("4.0"), Double.valueOf("6.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<4.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(Double.valueOf("5.0"), Double.valueOf("6.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(Double.valueOf("5.0"), Double.valueOf("6.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<5.0:6.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0).isNotInRange(Double.valueOf("1.0"), Double.valueOf("10.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be in the expected range.\n\tExpected:<1.0:10.0> but was:<5.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 5.0, "Message").isNotInRange(Double.valueOf("1.0"), Double.valueOf("10.0"));
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be in the expected range.\n\tExpected:<1.0:10.0> but was:<5.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isZeroTest() {
        initialize(Raw.doubleAssertion(), 0.0).isZero();
        initialize(Raw.doubleAssertion(), +0.0).isZero();
        initialize(Raw.doubleAssertion(), -0.0).isZero();

        try {
            Raw.doubleAssertion().isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be zero.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be zero.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be zero.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be zero.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be zero.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be zero.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be zero.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be zero.\n\tActual:<NaN>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotZeroTest() {
        initialize(Raw.doubleAssertion(), 10.0).isNotZero();
        initialize(Raw.doubleAssertion(), -10.0).isNotZero();
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNotZero();
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNotZero();
        initialize(Raw.doubleAssertion(), Double.NaN).isNotZero();

        try {
            Raw.doubleAssertion().isNotZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNotZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNotZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0).isNotZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), +0.0, "Message").isNotZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0).isNotZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be zero.");
        }
        try {
            initialize(Raw.doubleAssertion(), -0.0, "Message").isNotZero();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be zero.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isPositiveInfinityTest() {
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isPositiveInfinity();
        double val = getZero();
        initialize(Raw.doubleAssertion(), 1.0 / val).isPositiveInfinity();

        try {
            Raw.doubleAssertion().isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be positive infinity.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be positive infinity.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotPositiveInfinityTest() {
        initialize(Raw.doubleAssertion(), 0.0).isNotPositiveInfinity();
        initialize(Raw.doubleAssertion(), 10.0).isNotPositiveInfinity();
        initialize(Raw.doubleAssertion(), Double.NaN).isNotPositiveInfinity();
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNotPositiveInfinity();

        try {
            Raw.doubleAssertion().isNotPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNotPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be positive infinity.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isNotPositiveInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be positive infinity.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNegativeInfinityTest() {
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNegativeInfinity();
        double val = getZero();
        initialize(Raw.doubleAssertion(), -1.0 / val).isNegativeInfinity();

        try {
            Raw.doubleAssertion().isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be negative infinity.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be negative infinity.\n\tActual:<Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotNegativeInfinityTest() {
        initialize(Raw.doubleAssertion(), 0.0).isNotNegativeInfinity();
        initialize(Raw.doubleAssertion(), 10.0).isNotNegativeInfinity();
        initialize(Raw.doubleAssertion(), Double.NaN).isNotNegativeInfinity();
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNotNegativeInfinity();

        try {
            Raw.doubleAssertion().isNotNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNotNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be negative infinity.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isNotNegativeInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be negative infinity.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isInfinityTest() {
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isInfinity();
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isInfinity();
        double val = getZero();
        initialize(Raw.doubleAssertion(), 1.0 / val).isInfinity();
        initialize(Raw.doubleAssertion(), -1.0 / val).isInfinity();

        try {
            Raw.doubleAssertion().isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be infinity.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be infinity.\n\tActual:<NaN>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotInfinityTest() {
        initialize(Raw.doubleAssertion(), 0.0).isNotInfinity();
        initialize(Raw.doubleAssertion(), 10.0).isNotInfinity();
        initialize(Raw.doubleAssertion(), -10.0).isNotInfinity();
        initialize(Raw.doubleAssertion(), Double.NaN).isNotInfinity();

        try {
            Raw.doubleAssertion().isNotInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNotInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be infinity.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isNotInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be infinity.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNotInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be infinity.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isNotInfinity();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be infinity.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNaNTest() {
        initialize(Raw.doubleAssertion(), Double.NaN).isNaN();
        initialize(Raw.doubleAssertion(), Math.sqrt(-2.0)).isNaN();
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY / Double.NEGATIVE_INFINITY).isNaN();

        try {
            Raw.doubleAssertion().isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be NaN.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be NaN.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotNaNTest() {
        initialize(Raw.doubleAssertion(), 0.0).isNotNaN();
        initialize(Raw.doubleAssertion(), 10.0).isNotNaN();
        initialize(Raw.doubleAssertion(), -10.0).isNotNaN();
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNotNaN();
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNotNaN();

        try {
            Raw.doubleAssertion().isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be NaN.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isNotNaN();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be NaN.");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isFiniteTest() {
        initialize(Raw.doubleAssertion(), 0.0).isFinite();
        initialize(Raw.doubleAssertion(), 10.0).isFinite();
        initialize(Raw.doubleAssertion(), -10.0).isFinite();

        try {
            Raw.doubleAssertion().isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NaN, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<NaN>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be finite.\n\tActual:<-Infinity>");
        }
        try {
            initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY, "Message").isFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be finite.\n\tActual:<-Infinity>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotFiniteTest() {
        initialize(Raw.doubleAssertion(), Double.NaN).isNotFinite();
        initialize(Raw.doubleAssertion(), Double.POSITIVE_INFINITY).isNotFinite();
        initialize(Raw.doubleAssertion(), Double.NEGATIVE_INFINITY).isNotFinite();

        try {
            Raw.doubleAssertion().isNotFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.doubleAssertion(), null).isNotFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), null, "Message").isNotFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0).isNotFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be finite.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 0.0, "Message").isNotFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be finite.\n\tActual:<0.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0).isNotFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be finite.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNotFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be finite.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0).isNotFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be finite.\n\tActual:<-10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), -10.0, "Message").isNotFinite();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be finite.\n\tActual:<-10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.doubleAssertion(), null).isNull();

        try {
            initialize(Raw.doubleAssertion(), 10.0).isNull();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<10.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), 10.0, "Message").isNull();
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<10.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Double value = 10000.0;
        initialize(Raw.doubleAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.doubleAssertion(), value).isSameAs(10000.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<10000.0> but was:<10000.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), value, "Message").isSameAs(10000.0);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<10000.0> but was:<10000.0>");
        }
    }

    /**
     * {@link DoubleAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Double value = 10000.0;
        initialize(Raw.doubleAssertion(), value).isNotSameAs(10000.0);

        try {
            initialize(Raw.doubleAssertion(), value).isNotSameAs(value);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<10000.0>");
        }
        try {
            initialize(Raw.doubleAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("DoubleAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<10000.0>");
        }
    }

    private double getZero() {
        return 0.0;
    }

}
