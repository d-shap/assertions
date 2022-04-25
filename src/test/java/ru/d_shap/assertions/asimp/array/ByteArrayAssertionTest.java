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
package ru.d_shap.assertions.asimp.array;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
        initialize(Raw.byteArrayAssertion(), new byte[]{});

        try {
            initializeWithRawActual(Raw.byteArrayAssertion(), new Object());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[B> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.byteArrayAssertion(), new Object(), "Message");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<[B> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{}).isEmpty();

        try {
            Raw.byteArrayAssertion().isEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).isEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").isEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).isEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").isEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.byteArrayAssertion(), null).isNullOrEmpty();
        initialize(Raw.byteArrayAssertion(), new byte[]{}).isNullOrEmpty();

        try {
            Raw.byteArrayAssertion().isNullOrEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).isNullOrEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").isNullOrEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).isNotEmpty();

        try {
            Raw.byteArrayAssertion().isNotEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).isNotEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).isNotEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").isNotEmpty();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
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
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3b> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").contains(3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3b> but was:<[1b, 2b]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1b> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").doesNotContain(1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1b> but was:<[1b, 2b]>");
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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAll((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAll((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAll();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAll();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAll((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAll((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAll(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAll(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(DataHelper.createIterable((byte) 1, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAll(DataHelper.createIterable((byte) 1, (byte) 3));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAll(DataHelper.createIterable((byte) 4, (byte) 2));

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAll((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAll(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAll(DataHelper.createIterable((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAll(DataHelper.createIterable((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAllInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAllInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAllInOrder();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAllInOrder();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAllInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAllInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAllInOrder(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAllInOrder(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(DataHelper.createIterable((byte) 1, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAllInOrder(DataHelper.createIterable((byte) 1, (byte) 3, (byte) 4));

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAllInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAllInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(DataHelper.createIterable((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAllInOrder(DataHelper.createIterable((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAllInOrder(DataHelper.createIterable((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
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
        initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactly();

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactly((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsExactly((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly((byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactly((byte) 1, (byte) 1, (byte) 3, (byte) 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
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
        initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactly(new int[]{});

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactly((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsExactly((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(1, 2, 3, 4, 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactly(1, 1, 3, 2);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactly(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(DataHelper.createIterable((byte) 1, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(DataHelper.createIterable((byte) 1, (byte) 3, (byte) 2, (byte) 4));
        initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactly(new ArrayList<Byte>());

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsExactly((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(DataHelper.createIterable((byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactly(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactly(DataHelper.createIterable((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactly(DataHelper.createIterable((byte) 1, (byte) 1, (byte) 3, (byte) 2));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1b, 1b, 3b, 2b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayByteTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder((byte) 1, (byte) 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactlyInOrder();

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsExactlyInOrder((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder((byte) 2, (byte) 3, (byte) 1, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(1, 2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4);
        initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactlyInOrder(new int[]{});

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(1, 2, 3, 4, 5);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(2, 3, 1, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b, 3b, 4b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(DataHelper.createIterable((byte) 1, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactlyInOrder(new ArrayList<Byte>());

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsExactlyInOrder((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(DataHelper.createIterable((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b, 5b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsExactlyInOrder(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsExactlyInOrder(DataHelper.createIterable((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").containsExactlyInOrder(DataHelper.createIterable((byte) 2, (byte) 3, (byte) 1, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b, 3b, 1b, 4b]> but was:<[1b, 2b, 3b, 4b]>");
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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAny((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAny((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAny();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAny();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny((byte) 3, (byte) 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAny((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAny((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAny(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAny(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(3, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny(3, 4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny(100000, 100001);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[100000, 100001]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(DataHelper.createIterable((byte) 2, (byte) 3));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny(DataHelper.createIterable((byte) 2, (byte) 1));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny(DataHelper.createIterable((byte) 4, (byte) 2));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).containsAny(DataHelper.createIterable((byte) 5, (byte) 3));

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAny((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsAny(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsAny(DataHelper.createIterable((byte) 3, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsAny(DataHelper.createIterable((byte) 3, (byte) 4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3b, 4b]> but was:<[1b, 2b]>");
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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsNone((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsNone((byte[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsNone();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsNone();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone((byte) 2, (byte) 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsNoneArrayIntTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(3, 5);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(3, 4, 5);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(100000, 100001);

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsNone((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsNone((int[]) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsNone(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsNone(new int[]{});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone(2, 1);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(DataHelper.createIterable((byte) 3, (byte) 5));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(DataHelper.createIterable((byte) 3, (byte) 4, (byte) 5));

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
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsNone((Iterable<Byte>) null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").containsNone(new ArrayList<Byte>());
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).containsNone(DataHelper.createIterable((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").containsNone(DataHelper.createIterable((byte) 2, (byte) 1));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2b, 1b]> but was:<[1b, 2b]>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toLength().isEqualTo(2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toLength().isGreaterThan(1);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toLength().isLessThan(3);

        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).toLength().isEqualTo(4);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).toLength().isGreaterThan(3);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).toLength().isLessThan(5);

        try {
            Raw.byteArrayAssertion().toLength();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toLength();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toLength();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toLength()).isEqualTo(0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toLength()).isEqualTo(0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toLength().isEqualTo(4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toLength().isEqualTo(4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toLength(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toLength(Matchers.is(Matchers.greaterThan(1)));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toLength(Matchers.is(Matchers.lessThan(3)));

        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).toLength(Matchers.equalTo(4));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).toLength(Matchers.greaterThan(3));
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).toLength(Matchers.lessThan(5));

        try {
            Raw.byteArrayAssertion().toLength(Matchers.equalTo(0));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toLength(Matchers.equalTo(0));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toLength(Matchers.equalTo(0));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toLength(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toLength(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}).toLength(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{}, "Message").toLength(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toLength(Matchers.equalTo(4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <4>\n     but: was <2>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toLength(Matchers.equalTo(4));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <4>\n     but: was <2>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasLength(2);
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).hasLength(4);

        try {
            Raw.byteArrayAssertion().hasLength(0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasLength(0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasLength(0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasLength(4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasLength(4);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<4> but was:<2>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toHexStringTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString().isEqualTo("0102");
        initialize(Raw.byteArrayAssertion(), new byte[]{15, -3, 7}).toHexString().isEqualTo("0ffd07");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString().isEqualTo("630500eb");

        try {
            Raw.byteArrayAssertion().toHexString();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toHexString();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toHexString();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString()).isEqualTo("0000");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString()).isEqualTo("0000");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString().isEqualTo("0000");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0102>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString().isEqualTo("0000");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0102>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toHexStringPartTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(0, 2).isEqualTo("0102");
        initialize(Raw.byteArrayAssertion(), new byte[]{15, -3, 7}).toHexString(0, 3).isEqualTo("0ffd07");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 0).isEqualTo("");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 1).isEqualTo("63");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 2).isEqualTo("6305");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 3).isEqualTo("630500");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 4).isEqualTo("630500eb");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(1, 1).isEqualTo("");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(1, 2).isEqualTo("05");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(1, 3).isEqualTo("0500");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(1, 4).isEqualTo("0500eb");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(2, 2).isEqualTo("");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(2, 3).isEqualTo("00");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(2, 4).isEqualTo("00eb");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(3, 3).isEqualTo("");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(3, 4).isEqualTo("eb");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(4, 4).isEqualTo("");

        try {
            Raw.byteArrayAssertion().toHexString(0, 0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toHexString(0, 0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toHexString(0, 0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toHexString(-1, 0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toHexString(-1, 0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(-1, 0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(-1, 0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(-1, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(-1, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(0, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(0, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(3, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(3, 3);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(1, 0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(1, 0);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(0, 0)).isEqualTo("0000");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(0, 0)).isEqualTo("0000");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 0:0.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).toHexString(1, 3).isEqualTo("0102");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0102> but was:<0203>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").toHexString(1, 3).isEqualTo("0102");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0102> but was:<0203>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toHexStringMatcherTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(Matchers.is(Matchers.equalTo("0102")));
        initialize(Raw.byteArrayAssertion(), new byte[]{15, -3, 7}).toHexString(Matchers.is(Matchers.equalTo("0ffd07")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(Matchers.is(Matchers.equalTo("630500eb")));

        try {
            Raw.byteArrayAssertion().toHexString(Matchers.equalTo(""));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toHexString(Matchers.equalTo(""));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toHexString(Matchers.equalTo(""));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toHexString(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toHexString(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(Matchers.equalTo("0000"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\nExpected: \"0000\"\n     but: was \"0102\"");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(Matchers.equalTo("0000"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\nExpected: \"0000\"\n     but: was \"0102\"");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void toHexStringPartMatcherTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(0, 2, Matchers.is(Matchers.equalTo("0102")));
        initialize(Raw.byteArrayAssertion(), new byte[]{15, -3, 7}).toHexString(0, 3, Matchers.is(Matchers.equalTo("0ffd07")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 0, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 1, Matchers.is(Matchers.equalTo("63")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 2, Matchers.is(Matchers.equalTo("6305")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 3, Matchers.is(Matchers.equalTo("630500")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(0, 4, Matchers.is(Matchers.equalTo("630500eb")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(1, 1, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(1, 2, Matchers.is(Matchers.equalTo("05")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(1, 3, Matchers.is(Matchers.equalTo("0500")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(1, 4, Matchers.is(Matchers.equalTo("0500eb")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(2, 2, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(2, 3, Matchers.is(Matchers.equalTo("00")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(2, 4, Matchers.is(Matchers.equalTo("00eb")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(3, 3, Matchers.is(Matchers.equalTo("")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(3, 4, Matchers.is(Matchers.equalTo("eb")));
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).toHexString(4, 4, Matchers.is(Matchers.equalTo("")));

        try {
            Raw.byteArrayAssertion().toHexString(0, 0, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toHexString(0, 0, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toHexString(0, 0, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).toHexString(-1, 0, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").toHexString(-1, 0, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(-1, 0, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(-1, 0, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(-1, 3, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(-1, 3, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(0, 3, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(0, 3, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(3, 3, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(3, 3, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(1, 0, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(1, 0, Matchers.equalTo("00"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(0, 3, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(0, 3, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).toHexString(0, 2, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").toHexString(0, 2, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).toHexString(1, 3, Matchers.equalTo("0102"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\nExpected: \"0102\"\n     but: was \"0203\"");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").toHexString(1, 3, Matchers.equalTo("0102"));
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\nExpected: \"0102\"\n     but: was \"0203\"");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void hasHexStringTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString("0102");
        initialize(Raw.byteArrayAssertion(), new byte[]{15, -3, 7}).hasHexString("0ffd07");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString("630500eb");

        try {
            Raw.byteArrayAssertion().hasHexString("");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasHexString("");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasHexString("");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasHexString(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasHexString(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString("0000");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0102>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString("0000");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation.\n\tActual and expected values should be the same.\n\tExpected:<0000> but was:<0102>");
        }
    }

    /**
     * {@link ByteArrayAssertion} class test.
     */
    @Test
    public void hasHexStringPartTest() {
        initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(0, 2, "0102");
        initialize(Raw.byteArrayAssertion(), new byte[]{15, -3, 7}).hasHexString(0, 3, "0ffd07");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(0, 0, "");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(0, 1, "63");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(0, 2, "6305");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(0, 3, "630500");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(0, 4, "630500eb");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(1, 1, "");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(1, 2, "05");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(1, 3, "0500");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(1, 4, "0500eb");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(2, 2, "");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(2, 3, "00");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(2, 4, "00eb");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(3, 3, "");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(3, 4, "eb");
        initialize(Raw.byteArrayAssertion(), new byte[]{99, 5, 0, -21}).hasHexString(4, 4, "");

        try {
            Raw.byteArrayAssertion().hasHexString(0, 0, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasHexString(0, 0, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasHexString(0, 0, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null).hasHexString(-1, 0, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), null, "Message").hasHexString(-1, 0, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(-1, 0, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(-1, 0, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(-1, 3, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(-1, 3, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be greater than or equal to zero.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(0, 3, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(0, 3, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(3, 3, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(3, 3, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(3, 3, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(3, 3, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: from.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(1, 0, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(1, 0, "");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(1, 0, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(1, 0, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be greater than or equal to the minimum value: 1.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(0, 3, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(0, 3, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: to.\n\tThe argument's value should be less than or equal to the maximum value: 2.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}).hasHexString(0, 2, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").hasHexString(0, 2, null);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}).hasHexString(1, 3, "0102");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0102> but was:<0203>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2, 3, 4}, "Message").hasHexString(1, 3, "0102");
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's hex representation part: 1:3.\n\tActual and expected values should be the same.\n\tExpected:<0102> but was:<0203>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), new byte[]{1, 2}, "Message").isNull();
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1b, 2b]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), value, "Message").isSameAs(new byte[]{1, 2});
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b]>");
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
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1b, 2b]>");
        }
        try {
            initialize(Raw.byteArrayAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ByteArrayAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1b, 2b]>");
        }
    }

}
