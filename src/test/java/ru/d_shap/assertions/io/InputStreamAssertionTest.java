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
            initialize(Raw.inputStreamAssertion(), new Object());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new Object(), "Message");
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should be less then or equal to the expected. Expected:<-1> but was:<1>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should be less then or equal to the expected. Expected:<-1> but was:<1>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. java.io.IOException: read exception.");
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
            Raw.inputStreamAssertion().toByteArray(3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray(3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray(3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
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
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
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
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
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
            Assertions.assertThat(ex).hasMessage("Message. java.io.IOException: read exception.");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((byte) 1, (byte) 3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).isNextBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(new int[0]);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(1, 2, 3, 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).isNextBytesEqualTo(1, 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 3));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[0])).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isAllBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isAllBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(1, 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(1, 2, 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(1, 2, 3, 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isAllBytesEqualTo(0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isAllBytesEqualTo(0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
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
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(Arrays.asList((byte) 1, (byte) 2));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 4));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isAllBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
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
            Assertions.assertThat(ex).messageMatches("Value should be null. Actual:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isNull();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Value should be null. Actual:<java.io.ByteArrayInputStream.*>");
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
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<java.io.ByteArrayInputStream.*> but was:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), value, "Message").isSameAs(new ByteArrayInputStream(new byte[]{0, 0, 0}));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<java.io.ByteArrayInputStream.*> but was:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), value).isSameAs("test");
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<test> but was:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<test> but was:<java.io.ByteArrayInputStream.*>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        InputStream value = new ByteArrayInputStream(new byte[]{0, 0, 0});
        initialize(Raw.inputStreamAssertion(), value).isNotSameAs(new ByteArrayInputStream(new byte[]{0, 0, 0}));
        initialize(Raw.inputStreamAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.inputStreamAssertion(), value).isNotSameAs(value);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be different. Actual:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be different. Actual:<java.io.ByteArrayInputStream.*>");
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
