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
package ru.d_shap.assertions.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link InputStreamAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class InputStreamAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public InputStreamAssertionTest() {
        super();
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}));

        try {
            initializeWithRawActual(Raw.inputStreamAssertion(), new Object());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.inputStreamAssertion(), new Object(), "Message");
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isCompletedTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).isCompleted();
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais.read()).isEqualTo(1);
        Assertions.assertThat(bais.read()).isEqualTo(2);
        Assertions.assertThat(bais.read()).isEqualTo(3);
        initialize(Raw.inputStreamAssertion(), bais).isCompleted();

        try {
            Raw.inputStreamAssertion().isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ErrorInputStream()).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ErrorInputStream(), "Message").isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next actual value's byte.\n\tActual value should be less then the expected.\n\tExpected:<0> but was:<1>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next actual value's byte.\n\tActual value should be less then the expected.\n\tExpected:<0> but was:<1>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNotCompletedTest() {
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3});
        initialize(Raw.inputStreamAssertion(), bais).isNotCompleted();
        initialize(Raw.inputStreamAssertion(), bais).isNotCompleted();
        initialize(Raw.inputStreamAssertion(), bais).isNotCompleted();
        initialize(Raw.inputStreamAssertion(), bais).isCompleted();

        try {
            Raw.inputStreamAssertion().isNotCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNotCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isNotCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ErrorInputStream()).isNotCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ErrorInputStream(), "Message").isNotCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).isNotCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next actual value's byte.\n\tActual value should be greater then or equal to the expected.\n\tExpected:<0> but was:<-1>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").isNotCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next actual value's byte.\n\tActual value should be greater then or equal to the expected.\n\tExpected:<0> but was:<-1>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toByteArrayFullTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray().containsExactlyInOrder(1, 2, 3);

        try {
            Raw.inputStreamAssertion().toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ErrorInputStream()).toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ErrorInputStream(), "Message").toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray()).containsExactlyInOrder(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray()).containsExactlyInOrder(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray().containsExactlyInOrder(1, 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray().containsExactlyInOrder(1, 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toByteArrayWithLengthTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(4).containsExactlyInOrder(1, 2, 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(3).containsExactlyInOrder(1, 2, 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(2).containsExactlyInOrder(1, 2);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(1).containsExactlyInOrder(1);

        try {
            Raw.inputStreamAssertion().toByteArray(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray(0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray(0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray(0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(-1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray(-1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ErrorInputStream()).toByteArray(3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ErrorInputStream(), "Message").toByteArray(3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(1)).containsExactlyInOrder(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray(1)).containsExactlyInOrder(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(4).containsExactlyInOrder(1, 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray(4).containsExactlyInOrder(1, 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNextBytesEqualToArrayByteTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((byte) 1, (byte) 2);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isNextBytesEqualTo((byte) 0, (byte) 0);

        try {
            Raw.inputStreamAssertion().isNextBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isNextBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isNextBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isNextBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isNextBytesEqualTo();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((byte) 1, (byte) 3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).isNextBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0, 0]> but was:<[0, 0]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNextBytesEqualToArrayIntTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 2);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 2, 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isNextBytesEqualTo(0, 0);

        try {
            Raw.inputStreamAssertion().isNextBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isNextBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isNextBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isNextBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(new int[0]);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isNextBytesEqualTo(new int[0]);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 2, 3, 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).isNextBytesEqualTo(1, 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0, 0]> but was:<[0, 0]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNextBytesEqualToIterableTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));

        try {
            Raw.inputStreamAssertion().isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 3));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0, 0]> but was:<[0, 0]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isAllBytesEqualToArrayByteTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isAllBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).isAllBytesEqualTo();

        try {
            Raw.inputStreamAssertion().isAllBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isAllBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isAllBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isAllBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isAllBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isAllBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0]> but was:<[0, 0, 0]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isAllBytesEqualToArrayIntTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(1, 2, 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isAllBytesEqualTo(0, 0, 0);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).isAllBytesEqualTo(new int[0]);

        try {
            Raw.inputStreamAssertion().isAllBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isAllBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isAllBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isAllBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isAllBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isAllBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(1, 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(1, 2, 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(1, 2, 3, 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isAllBytesEqualTo(0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isAllBytesEqualTo(0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0]> but was:<[0, 0, 0]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isAllBytesEqualToIterableTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).isAllBytesEqualTo(new ArrayList<Byte>());

        try {
            Raw.inputStreamAssertion().isAllBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isAllBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isAllBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 4));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0, 0]> but was:<[0, 0, 0]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toAvailableTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toAvailable().isEqualTo(3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0, 0, 0})).toAvailable().isEqualTo(5);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).toAvailable().isEqualTo(0);
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais.read()).isEqualTo(1);
        initialize(Raw.inputStreamAssertion(), bais).toAvailable().isEqualTo(2);
        Assertions.assertThat(bais.read()).isEqualTo(2);
        initialize(Raw.inputStreamAssertion(), bais).toAvailable().isEqualTo(1);
        Assertions.assertThat(bais.read()).isEqualTo(3);
        initialize(Raw.inputStreamAssertion(), bais).toAvailable().isEqualTo(0);
        Assertions.assertThat(bais.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais).toAvailable().isEqualTo(0);

        try {
            Raw.inputStreamAssertion().toAvailable();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toAvailable();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toAvailable();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toAvailable().isEqualTo(2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's available.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toAvailable().isEqualTo(2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's available.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.inputStreamAssertion(), null).isNull();

        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isNull();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isNull();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual value should be null.\n\tActual:<java.io.ByteArrayInputStream.*>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        InputStream value = new ByteArrayInputStream(new byte[]{0, 0, 0});
        initialize(Raw.inputStreamAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.inputStreamAssertion(), value).isSameAs(new ByteArrayInputStream(new byte[]{0, 0, 0}));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should be the same.\n\tExpected:<java.io.ByteArrayInputStream.*> but was:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), value, "Message").isSameAs(new ByteArrayInputStream(new byte[]{0, 0, 0}));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should be the same.\n\tExpected:<java.io.ByteArrayInputStream.*> but was:<java.io.ByteArrayInputStream.*>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        InputStream value = new ByteArrayInputStream(new byte[]{0, 0, 0});
        initialize(Raw.inputStreamAssertion(), value).isNotSameAs(new ByteArrayInputStream(new byte[]{0, 0, 0}));

        try {
            initialize(Raw.inputStreamAssertion(), value).isNotSameAs(value);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should be different.\n\tActual:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should be different.\n\tActual:<java.io.ByteArrayInputStream.*>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.inputStreamAssertion(), null).asString(null));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.inputStreamAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.inputStreamAssertion(), null).asString(new ByteArrayInputStream(new byte[0]))).matches("java.io.ByteArrayInputStream.*");
        Assertions.assertThat(initialize(Raw.inputStreamAssertion(), null).asString(new ByteArrayInputStream(new byte[]{0, 0, 0}))).matches("java.io.ByteArrayInputStream.*");
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ErrorInputStream extends InputStream {

        ErrorInputStream() {
            super();
        }

        @Override
        public int read() throws IOException {
            throw new IOException("read exception");
        }

    }

}
