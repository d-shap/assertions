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
import java.util.Collections;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

/**
 * Tests for {@link InputStreamAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class InputStreamAssertionTest {

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
    public void isCompletedTest() {
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), new FailDescription()).isCompleted();
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais.read()).isEqualTo(1);
        Assertions.assertThat(bais.read()).isEqualTo(2);
        Assertions.assertThat(bais.read()).isEqualTo(3);
        new InputStreamAssertion(bais, new FailDescription()).isCompleted();

        try {
            new InputStreamAssertion(null, new FailDescription()).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription("Message")).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription("Message")).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should be less then or equal to the expected. Expected:<-1> but was:<1>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription("Message")).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should be less then or equal to the expected. Expected:<-1> but was:<1>.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toByteArrayTest() {
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).toByteArray().containsExactlyInOrder(1, 2, 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).toByteArray(4).containsExactlyInOrder(1, 2, 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).toByteArray(3).containsExactlyInOrder(1, 2, 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).toByteArray(2).containsExactlyInOrder(1, 2);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).toByteArray(1).containsExactlyInOrder(1);

        try {
            new InputStreamAssertion(null, new FailDescription()).toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription("Message")).toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).toByteArray(3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription("Message")).toByteArray(3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).toByteArray(0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription("Message")).toByteArray(0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).toByteArray(-1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription("Message")).toByteArray(-1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription("Message")).toByteArray();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).toByteArray(3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription("Message")).toByteArray(3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. java.io.IOException: read exception.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNextBytesEqualToTest() {
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((byte) 1);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo(1);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo(Collections.singletonList((byte) 1));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((byte) 1, (byte) 2);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo(1, 2);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo(1, 2, 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isNextBytesEqualTo((byte) 0, (byte) 0);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isNextBytesEqualTo(0, 0);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));

        try {
            new InputStreamAssertion(null, new FailDescription()).isNextBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isNextBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isNextBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isNextBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo(new int[0]);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((byte) 1, (byte) 3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[0]), new FailDescription()).isNextBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription()).isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription("Message")).isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription()).isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription("Message")).isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription()).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription("Message")).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isAllBytesEqualToTest() {
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo(1, 2, 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isAllBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isAllBytesEqualTo(0, 0, 0);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[0]), new FailDescription()).isAllBytesEqualTo();
        new InputStreamAssertion(new ByteArrayInputStream(new byte[0]), new FailDescription()).isAllBytesEqualTo(new int[0]);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[0]), new FailDescription()).isAllBytesEqualTo(new ArrayList<Byte>());

        try {
            new InputStreamAssertion(null, new FailDescription()).isAllBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isAllBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isAllBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isAllBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isAllBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, new FailDescription()).isAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((int[]) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1]> but was:<[1, 2, 3]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription("Message")).isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isAllBytesEqualTo(0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription("Message")).isAllBytesEqualTo(0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription("Message")).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream bytes. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new InputStreamAssertion(null, new FailDescription()).isNull();

        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isNull();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Value should be null. Actual:<java.io.ByteArrayInputStream.*>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription("Message")).isNull();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Value should be null. Actual:<java.io.ByteArrayInputStream.*>.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        InputStream value = new ByteArrayInputStream(new byte[]{0, 0, 0});
        new InputStreamAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new InputStreamAssertion(value, new FailDescription()).isSameAs(new ByteArrayInputStream(new byte[]{0, 0, 0}));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<java.io.ByteArrayInputStream.*> but was:<java.io.ByteArrayInputStream.*>.");
        }
        try {
            new InputStreamAssertion(value, new FailDescription("Message")).isSameAs(new ByteArrayInputStream(new byte[]{0, 0, 0}));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<java.io.ByteArrayInputStream.*> but was:<java.io.ByteArrayInputStream.*>.");
        }
        try {
            new InputStreamAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<test> but was:<java.io.ByteArrayInputStream.*>.");
        }
        try {
            new InputStreamAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<test> but was:<java.io.ByteArrayInputStream.*>.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        InputStream value = new ByteArrayInputStream(new byte[]{0, 0, 0});
        new InputStreamAssertion(value, new FailDescription()).isNotSameAs(new ByteArrayInputStream(new byte[]{0, 0, 0}));
        new InputStreamAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new InputStreamAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be different. Actual:<java.io.ByteArrayInputStream.*>.");
        }
        try {
            new InputStreamAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be different. Actual:<java.io.ByteArrayInputStream.*>.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(new ByteArrayInputStream(new byte[0]))).matches("java.io.ByteArrayInputStream.*");
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(new ByteArrayInputStream(new byte[]{0, 0, 0}))).matches("java.io.ByteArrayInputStream.*");
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
