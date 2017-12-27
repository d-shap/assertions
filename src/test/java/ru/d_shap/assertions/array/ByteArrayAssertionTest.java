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
package ru.d_shap.assertions.array;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ByteArrayAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ByteArrayAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ByteArrayAssertionTest() {
        super();
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.byteArrayAssertion(), new byte[0]);

        try {
            initializeWithRawActual(Raw.byteArrayAssertion(), new Object());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.byteArrayAssertion(), new Object(), "Message");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).contains(1);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).contains(2);

        try {
            Raw.byteArrayAssertion().contains(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).contains(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").contains(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).contains(3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").contains(3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).doesNotContain(3);

        try {
            Raw.byteArrayAssertion().doesNotContain(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).doesNotContain(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").doesNotContain(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).doesNotContain(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").doesNotContain(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayByteTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll((byte) 1, (byte) 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAll((byte) 1, (byte) 3);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAll((byte) 4, (byte) 2);

        try {
            Raw.byteArrayAssertion().containsAll((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAll((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAll((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAll((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAll((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllArrayIntTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(1, 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAll(1, 3);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAll(4, 2);

        try {
            Raw.byteArrayAssertion().containsAll(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAll(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAll(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAll((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAll(Arrays.asList((byte) 1, (byte) 3));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAll(Arrays.asList((byte) 4, (byte) 2));

        try {
            Raw.byteArrayAssertion().containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayByteTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder((byte) 1, (byte) 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAllInOrder((byte) 1, (byte) 3, (byte) 4);

        try {
            Raw.byteArrayAssertion().containsAllInOrder((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAllInOrder((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAllInOrder((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAllInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAllInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayIntTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(1, 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAllInOrder(1, 3, 4);

        try {
            Raw.byteArrayAssertion().containsAllInOrder(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAllInOrder(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAllInOrder(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAllInOrder(Arrays.asList((byte) 1, (byte) 3, (byte) 4));

        try {
            Raw.byteArrayAssertion().containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayByteTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly((byte) 1, (byte) 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly((byte) 1, (byte) 3, (byte) 2, (byte) 4);
        initialize(Raw.byteArrayAssertion(), new byte[0]).containsExactly();

        try {
            Raw.byteArrayAssertion().containsExactly((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactly((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactly((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactly((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactly((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsExactly((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyArrayIntTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(1, 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(1, 3, 2, 4);
        initialize(Raw.byteArrayAssertion(), new byte[0]).containsExactly(new int[0]);

        try {
            Raw.byteArrayAssertion().containsExactly(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactly(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactly(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsExactly((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(Arrays.asList((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        initialize(Raw.byteArrayAssertion(), new byte[0]).containsExactly(new ArrayList<Byte>());

        try {
            Raw.byteArrayAssertion().containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(Arrays.asList((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactly(Arrays.asList((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayByteTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder((byte) 1, (byte) 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        initialize(Raw.byteArrayAssertion(), new byte[0]).containsExactlyInOrder();

        try {
            Raw.byteArrayAssertion().containsExactlyInOrder((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactlyInOrder((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactlyInOrder((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(1, 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.byteArrayAssertion(), new byte[0]).containsExactlyInOrder(new int[0]);

        try {
            Raw.byteArrayAssertion().containsExactlyInOrder(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactlyInOrder(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactlyInOrder(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        initialize(Raw.byteArrayAssertion(), new byte[0]).containsExactlyInOrder(new ArrayList<Byte>());

        try {
            Raw.byteArrayAssertion().containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(Arrays.asList((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayByteTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny((byte) 2, (byte) 3);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny((byte) 2, (byte) 1);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny((byte) 4, (byte) 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny((byte) 5, (byte) 3);

        try {
            Raw.byteArrayAssertion().containsAny((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAny((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAny((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAny((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAny((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAnyArrayIntTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(2, 3);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny(2, 1);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny(4, 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny(5, 3);

        try {
            Raw.byteArrayAssertion().containsAny(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAny(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAny(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAny((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(3, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(Arrays.asList((byte) 2, (byte) 3));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny(Arrays.asList((byte) 2, (byte) 1));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny(Arrays.asList((byte) 4, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny(Arrays.asList((byte) 5, (byte) 3));

        try {
            Raw.byteArrayAssertion().containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny(Arrays.asList((byte) 3, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayByteTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone((byte) 3, (byte) 5);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone((byte) 3, (byte) 4, (byte) 5);

        try {
            Raw.byteArrayAssertion().containsNone((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsNone((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsNone((byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsNone((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsNone((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayIntTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(3, 5);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(3, 4, 5);

        try {
            Raw.byteArrayAssertion().containsNone(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsNone(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsNone(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsNone((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone(new int[0]);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(Arrays.asList((byte) 3, (byte) 5));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(Arrays.asList((byte) 3, (byte) 4, (byte) 5));

        try {
            Raw.byteArrayAssertion().containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone(Arrays.asList((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.byteArrayAssertion(), null).isNull();

        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).isNull();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").isNull();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        byte[] value = new byte[]{1, 2};
        initialize(Raw.byteArrayAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.byteArrayAssertion(), value).isSameAs(new byte[]{1, 2});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), value, "Message").isSameAs(new byte[]{1, 2});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<[1, 2]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        byte[] value = new byte[]{1, 2};
        initialize(Raw.byteArrayAssertion(), value).isNotSameAs(new byte[]{1, 2});

        try {
            initialize(Raw.byteArrayAssertion(), value).isNotSameAs(value);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<[1, 2]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<[1, 2]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.byteArrayAssertion(), null).asString(null));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.byteArrayAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.byteArrayAssertion(), null).asString(Arrays.asList("val1", "val2", "val3"))).isEqualTo("[val1, val2, val3]");
        Assertions.assertThat(initialize(Raw.byteArrayAssertion(), null).asString(new byte[]{1, 2})).isEqualTo("[1, 2]");
    }

}
