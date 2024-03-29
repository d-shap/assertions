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
package ru.d_shap.assertions.asimp.java.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.io.InputStream> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.inputStreamAssertion(), new Object(), "Message");
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.io.InputStream> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isCompletedTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).isCompleted();
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).isNotNull().isCompleted().isInstanceOf(InputStream.class);
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais.read()).isEqualTo(1);
        Assertions.assertThat(bais.read()).isEqualTo(2);
        Assertions.assertThat(bais.read()).isEqualTo(3);
        initialize(Raw.inputStreamAssertion(), bais).isCompleted();

        try {
            Raw.inputStreamAssertion().isCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).isCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").isCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).isCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be completed.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").isCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be completed.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be completed.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be completed.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNotCompletedTest() {
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3, 0, 4});
        initialize(Raw.inputStreamAssertion(), bais).isNotCompleted();
        initialize(Raw.inputStreamAssertion(), bais).isNotCompleted();
        initialize(Raw.inputStreamAssertion(), bais).isNotCompleted();
        initialize(Raw.inputStreamAssertion(), bais).isNotCompleted();
        initialize(Raw.inputStreamAssertion(), bais).isNotCompleted();
        initialize(Raw.inputStreamAssertion(), bais).isCompleted();
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3, 0, 4})).isNotNull().isNotCompleted().isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().isNotCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNotCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isNotCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).isNotCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").isNotCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).isNotCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be completed.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").isNotCompleted();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be completed.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toByteArrayTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray().containsExactlyInOrder(1, 2, 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().toByteArray().containsExactlyInOrder(1, 2, 3);

        try {
            Raw.inputStreamAssertion().toByteArray();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toByteArray();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toByteArray();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray()).containsExactlyInOrder(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray()).containsExactlyInOrder(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray().containsExactlyInOrder(1, 2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray().containsExactlyInOrder(1, 2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b, 3b]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toByteArrayCountTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(4).containsExactlyInOrder(1, 2, 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(3).containsExactlyInOrder(1, 2, 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(2).containsExactlyInOrder(1, 2);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(1).containsExactlyInOrder(1);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().toByteArray(1).containsExactlyInOrder(1);

        try {
            Raw.inputStreamAssertion().toByteArray(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toByteArray(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toByteArray(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toByteArray(-1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toByteArray(-1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toByteArray(3);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toByteArray(3);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(1)).containsExactlyInOrder(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray(1)).containsExactlyInOrder(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(4).containsExactlyInOrder(1, 2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray(4).containsExactlyInOrder(1, 2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b, 3b]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toByteArrayMatcherTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(Matchers.arrayContaining((byte) 1, (byte) 2, (byte) 3));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().toByteArray(Matchers.arrayContaining((byte) 1, (byte) 2, (byte) 3)).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().toByteArray(Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray(Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray(Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toByteArray(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toByteArray(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toByteArray(Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toByteArray(Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(Matchers.arrayContaining((byte) 1, (byte) 2));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\nExpected: [<1>, <2>] \n     but: not matched: <3>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray(Matchers.arrayContaining((byte) 1, (byte) 2));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\nExpected: [<1>, <2>] \n     but: not matched: <3>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toByteArrayCountMatcherTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(4, Matchers.arrayContaining((byte) 1, (byte) 2, (byte) 3));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(3, Matchers.arrayContaining((byte) 1, (byte) 2, (byte) 3));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(2, Matchers.arrayContaining((byte) 1, (byte) 2));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(1, Matchers.arrayContaining((byte) 1));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().toByteArray(1, Matchers.arrayContaining((byte) 1)).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().toByteArray(1, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray(1, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray(1, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toByteArray(0, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toByteArray(0, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toByteArray(0, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toByteArray(0, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toByteArray(-1, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toByteArray(-1, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toByteArray(0, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toByteArray(0, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toByteArray(1, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toByteArray(1, null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toByteArray(3, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toByteArray(3, Matchers.arrayContaining((byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toByteArray(4, Matchers.arrayContaining((byte) 1, (byte) 2));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\nExpected: [<1>, <2>] \n     but: not matched: <3>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toByteArray(4, Matchers.arrayContaining((byte) 1, (byte) 2));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 4.\nExpected: [<1>, <2>] \n     but: not matched: <3>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNextByteEqualToTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextByteEqualTo(1);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{2, 3, 4})).isNextByteEqualTo(2);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).isNextByteEqualTo(0);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{2, 3, 4})).isNotNull().isNextByteEqualTo(2).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().isNextByteEqualTo(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).isNextByteEqualTo(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").isNextByteEqualTo(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNextByteEqualTo(2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b]> but was:<[1b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isNextByteEqualTo(2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2b]> but was:<[1b]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void areNextBytesEqualToArrayByteTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo((byte) 1, (byte) 2);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).areNextBytesEqualTo((byte) 0, (byte) 0);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().areNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().areNextBytesEqualTo((byte) 1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areNextBytesEqualTo((byte) 1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areNextBytesEqualTo((byte) 1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areNextBytesEqualTo((byte[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areNextBytesEqualTo((byte[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areNextBytesEqualTo((byte[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").areNextBytesEqualTo((byte[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areNextBytesEqualTo();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").areNextBytesEqualTo();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo((byte) 1, (byte) 3);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areNextBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).areNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b, 0b]> but was:<[0b, 0b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").areNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b, 0b]> but was:<[0b, 0b]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void areNextBytesEqualToArrayIntTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(1, 2);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(1, 2, 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).areNextBytesEqualTo(0, 0);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().areNextBytesEqualTo(1, 2, 3).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().areNextBytesEqualTo(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areNextBytesEqualTo(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areNextBytesEqualTo(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areNextBytesEqualTo((int[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areNextBytesEqualTo((int[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areNextBytesEqualTo((int[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").areNextBytesEqualTo((int[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areNextBytesEqualTo(new int[]{});
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").areNextBytesEqualTo(new int[]{});
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(1, 3);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(1, 2, 3, 4);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areNextBytesEqualTo(1, 2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).areNextBytesEqualTo(0, 0, 0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b, 0b]> but was:<[0b, 0b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").areNextBytesEqualTo(0, 0, 0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b, 0b]> but was:<[0b, 0b]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void areNextBytesEqualToIterableTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).areNextBytesEqualTo(DataHelper.createIterable((byte) 0, (byte) 0));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().areNextBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3)).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().areNextBytesEqualTo(DataHelper.<Byte>createIterable());
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areNextBytesEqualTo(DataHelper.<Byte>createIterable());
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areNextBytesEqualTo(DataHelper.<Byte>createIterable());
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").areNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areNextBytesEqualTo(DataHelper.<Byte>createIterable());
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").areNextBytesEqualTo(DataHelper.<Byte>createIterable());
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 3));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 3b]> but was:<[1b, 2b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areNextBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3, (byte) 4));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areNextBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0})).areNextBytesEqualTo(DataHelper.createIterable((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b, 0b]> but was:<[0b, 0b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0}), "Message").areNextBytesEqualTo(DataHelper.createIterable((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's bytes: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b, 0b]> but was:<[0b, 0b]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void areAllBytesEqualToArrayByteTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).areAllBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areAllBytesEqualTo();
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().areAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().areAllBytesEqualTo((byte) 1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areAllBytesEqualTo((byte) 1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areAllBytesEqualTo((byte) 1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areAllBytesEqualTo((byte[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areAllBytesEqualTo((byte[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areAllBytesEqualTo((byte[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").areAllBytesEqualTo((byte[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo((byte) 1, (byte) 2, (byte) 4);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).areAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b]> but was:<[0b, 0b, 0b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").areAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b]> but was:<[0b, 0b, 0b]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void areAllBytesEqualToArrayIntTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo(1, 2, 3);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).areAllBytesEqualTo(0, 0, 0);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areAllBytesEqualTo(new int[]{});
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().areAllBytesEqualTo(1, 2, 3).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().areAllBytesEqualTo(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areAllBytesEqualTo(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areAllBytesEqualTo(1);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areAllBytesEqualTo((int[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areAllBytesEqualTo((int[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areAllBytesEqualTo((int[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").areAllBytesEqualTo((int[]) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo(1, 2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo(1, 2, 4);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo(1, 2, 3, 4);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).areAllBytesEqualTo(0, 0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b]> but was:<[0b, 0b, 0b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").areAllBytesEqualTo(0, 0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b]> but was:<[0b, 0b, 0b]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void areAllBytesEqualToIterableTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).areAllBytesEqualTo(DataHelper.createIterable((byte) 0, (byte) 0, (byte) 0));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areAllBytesEqualTo(DataHelper.<Byte>createIterable());
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).isNotNull().areAllBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3)).isInstanceOf(InputStream.class);

        try {
            Raw.inputStreamAssertion().areAllBytesEqualTo(DataHelper.<Byte>createIterable());
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areAllBytesEqualTo(DataHelper.<Byte>createIterable());
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areAllBytesEqualTo(DataHelper.<Byte>createIterable());
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).areAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").areAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).areAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").areAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 4));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).areAllBytesEqualTo(DataHelper.createIterable((byte) 1, (byte) 2, (byte) 3, (byte) 4));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1b, 2b, 3b, 4b]> but was:<[1b, 2b, 3b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0})).areAllBytesEqualTo(DataHelper.createIterable((byte) 0, (byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b]> but was:<[0b, 0b, 0b]>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").areAllBytesEqualTo(DataHelper.createIterable((byte) 0, (byte) 0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's bytes.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[0b, 0b]> but was:<[0b, 0b, 0b]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toAvailableTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).toAvailable().isEqualTo(2);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0, 0, 0})).toAvailable().isEqualTo(5);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toAvailable().isEqualTo(0);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).isNotNull().toAvailable().isEqualTo(2);

        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3});
        initialize(Raw.inputStreamAssertion(), bais).toAvailable().isEqualTo(3);
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
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toAvailable();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toAvailable();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setAvailableException("available exception").buildInputStream()).toAvailable();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: available exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setAvailableException("available exception").buildInputStream(), "Message").toAvailable();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: available exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toAvailable().isEqualTo(2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's available.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toAvailable().isEqualTo(2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's available.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toAvailableMatcherTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).toAvailable(Matchers.is(Matchers.equalTo(2)));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0, 0, 0})).toAvailable(Matchers.equalTo(5));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toAvailable(Matchers.equalTo(0));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).isNotNull().toAvailable(Matchers.is(Matchers.equalTo(2))).isInstanceOf(InputStream.class);

        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3});
        initialize(Raw.inputStreamAssertion(), bais).toAvailable(Matchers.equalTo(3));
        Assertions.assertThat(bais.read()).isEqualTo(1);
        initialize(Raw.inputStreamAssertion(), bais).toAvailable(Matchers.equalTo(2));
        Assertions.assertThat(bais.read()).isEqualTo(2);
        initialize(Raw.inputStreamAssertion(), bais).toAvailable(Matchers.equalTo(1));
        Assertions.assertThat(bais.read()).isEqualTo(3);
        initialize(Raw.inputStreamAssertion(), bais).toAvailable(Matchers.equalTo(0));
        Assertions.assertThat(bais.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais).toAvailable(Matchers.equalTo(0));

        try {
            Raw.inputStreamAssertion().toAvailable(Matchers.equalTo(0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toAvailable(Matchers.equalTo(0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toAvailable(Matchers.equalTo(0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toAvailable(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toAvailable(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toAvailable(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toAvailable(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setAvailableException("available exception").buildInputStream()).toAvailable(Matchers.equalTo(0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: available exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setAvailableException("available exception").buildInputStream(), "Message").toAvailable(Matchers.equalTo(0));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: available exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toAvailable(Matchers.equalTo(2));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's available.\nExpected: <2>\n     but: was <3>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toAvailable(Matchers.equalTo(2));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's available.\nExpected: <2>\n     but: was <3>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void hasAvailableTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).hasAvailable(2);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0, 0, 0})).hasAvailable(5);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).hasAvailable(0);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).isNotNull().hasAvailable(2).isInstanceOf(InputStream.class);

        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3});
        initialize(Raw.inputStreamAssertion(), bais).hasAvailable(3);
        Assertions.assertThat(bais.read()).isEqualTo(1);
        initialize(Raw.inputStreamAssertion(), bais).hasAvailable(2);
        Assertions.assertThat(bais.read()).isEqualTo(2);
        initialize(Raw.inputStreamAssertion(), bais).hasAvailable(1);
        Assertions.assertThat(bais.read()).isEqualTo(3);
        initialize(Raw.inputStreamAssertion(), bais).hasAvailable(0);
        Assertions.assertThat(bais.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais).hasAvailable(0);

        try {
            Raw.inputStreamAssertion().hasAvailable(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).hasAvailable(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").hasAvailable(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setAvailableException("available exception").buildInputStream()).hasAvailable(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: available exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setAvailableException("available exception").buildInputStream(), "Message").hasAvailable(0);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: available exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).hasAvailable(2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's available.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").hasAvailable(2);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's available.\n\tActual and expected values should be the same.\n\tExpected:<2> but was:<3>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toLengthTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).toLength().isEqualTo(2L);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0, 0, 0})).toLength().isEqualTo(5L);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toLength().isEqualTo(0L);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).isNotNull().toLength().isEqualTo(2L);

        ByteArrayInputStream bais1 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        initialize(Raw.inputStreamAssertion(), bais1).toLength().isEqualTo(3L);
        Assertions.assertThat(bais1.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais1).toLength().isEqualTo(0L);

        ByteArrayInputStream bais2 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais2.read()).isEqualTo(1);
        initialize(Raw.inputStreamAssertion(), bais2).toLength().isEqualTo(2L);
        Assertions.assertThat(bais2.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais2).toLength().isEqualTo(0L);

        ByteArrayInputStream bais3 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais3.read()).isEqualTo(1);
        Assertions.assertThat(bais3.read()).isEqualTo(2);
        initialize(Raw.inputStreamAssertion(), bais3).toLength().isEqualTo(1L);
        Assertions.assertThat(bais3.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais3).toLength().isEqualTo(0L);

        ByteArrayInputStream bais4 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais4.read()).isEqualTo(1);
        Assertions.assertThat(bais4.read()).isEqualTo(2);
        Assertions.assertThat(bais4.read()).isEqualTo(3);
        initialize(Raw.inputStreamAssertion(), bais4).toLength().isEqualTo(0L);
        Assertions.assertThat(bais4.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais4).toLength().isEqualTo(0L);

        ByteArrayInputStream bais5 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais5.read()).isEqualTo(1);
        Assertions.assertThat(bais5.read()).isEqualTo(2);
        Assertions.assertThat(bais5.read()).isEqualTo(3);
        Assertions.assertThat(bais5.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais5).toLength().isEqualTo(0L);
        Assertions.assertThat(bais5.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais5).toLength().isEqualTo(0L);

        try {
            Raw.inputStreamAssertion().toLength();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toLength();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toLength();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toLength();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toLength();
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toLength().isEqualTo(2L);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toLength().isEqualTo(2L);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void toLengthMatcherTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).toLength(Matchers.is(Matchers.equalTo(2L)));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0, 0, 0})).toLength(Matchers.equalTo(5L));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toLength(Matchers.equalTo(0L));
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).isNotNull().toLength(Matchers.is(Matchers.equalTo(2L))).isInstanceOf(InputStream.class);

        ByteArrayInputStream bais1 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        initialize(Raw.inputStreamAssertion(), bais1).toLength(Matchers.equalTo(3L));
        Assertions.assertThat(bais1.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais1).toLength(Matchers.equalTo(0L));

        ByteArrayInputStream bais2 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais2.read()).isEqualTo(1);
        initialize(Raw.inputStreamAssertion(), bais2).toLength(Matchers.equalTo(2L));
        Assertions.assertThat(bais2.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais2).toLength(Matchers.equalTo(0L));

        ByteArrayInputStream bais3 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais3.read()).isEqualTo(1);
        Assertions.assertThat(bais3.read()).isEqualTo(2);
        initialize(Raw.inputStreamAssertion(), bais3).toLength(Matchers.equalTo(1L));
        Assertions.assertThat(bais3.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais3).toLength(Matchers.equalTo(0L));

        ByteArrayInputStream bais4 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais4.read()).isEqualTo(1);
        Assertions.assertThat(bais4.read()).isEqualTo(2);
        Assertions.assertThat(bais4.read()).isEqualTo(3);
        initialize(Raw.inputStreamAssertion(), bais4).toLength(Matchers.equalTo(0L));
        Assertions.assertThat(bais4.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais4).toLength(Matchers.equalTo(0L));

        ByteArrayInputStream bais5 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais5.read()).isEqualTo(1);
        Assertions.assertThat(bais5.read()).isEqualTo(2);
        Assertions.assertThat(bais5.read()).isEqualTo(3);
        Assertions.assertThat(bais5.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais5).toLength(Matchers.equalTo(0L));
        Assertions.assertThat(bais5.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais5).toLength(Matchers.equalTo(0L));

        try {
            Raw.inputStreamAssertion().toLength(Matchers.equalTo(0L));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toLength(Matchers.equalTo(0L));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toLength(Matchers.equalTo(0L));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).toLength(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").toLength(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).toLength(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{}), "Message").toLength(null);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).toLength(Matchers.equalTo(0L));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").toLength(Matchers.equalTo(0L));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).toLength(Matchers.equalTo(2L));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <2L>\n     but: was <3L>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").toLength(Matchers.equalTo(2L));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <2L>\n     but: was <3L>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void hasLengthTest() {
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).hasLength(2L);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0, 0, 0})).hasLength(5L);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{})).hasLength(0L);
        initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2})).isNotNull().hasLength(2L).isInstanceOf(InputStream.class);

        ByteArrayInputStream bais1 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        initialize(Raw.inputStreamAssertion(), bais1).hasLength(3L);
        Assertions.assertThat(bais1.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais1).hasLength(0L);

        ByteArrayInputStream bais2 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais2.read()).isEqualTo(1);
        initialize(Raw.inputStreamAssertion(), bais2).hasLength(2L);
        Assertions.assertThat(bais2.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais2).hasLength(0L);

        ByteArrayInputStream bais3 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais3.read()).isEqualTo(1);
        Assertions.assertThat(bais3.read()).isEqualTo(2);
        initialize(Raw.inputStreamAssertion(), bais3).hasLength(1L);
        Assertions.assertThat(bais3.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais3).hasLength(0L);

        ByteArrayInputStream bais4 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais4.read()).isEqualTo(1);
        Assertions.assertThat(bais4.read()).isEqualTo(2);
        Assertions.assertThat(bais4.read()).isEqualTo(3);
        initialize(Raw.inputStreamAssertion(), bais4).hasLength(0L);
        Assertions.assertThat(bais4.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais4).hasLength(0L);

        ByteArrayInputStream bais5 = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais5.read()).isEqualTo(1);
        Assertions.assertThat(bais5.read()).isEqualTo(2);
        Assertions.assertThat(bais5.read()).isEqualTo(3);
        Assertions.assertThat(bais5.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais5).hasLength(0L);
        Assertions.assertThat(bais5.read()).isLessThan(0);
        initialize(Raw.inputStreamAssertion(), bais5).hasLength(0L);

        try {
            Raw.inputStreamAssertion().hasLength(0L);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null).hasLength(0L);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), null, "Message").hasLength(0L);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream()).hasLength(0L);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), DataHelper.createInputStreamBuilder().setReadException("read exception").buildInputStream(), "Message").hasLength(0L);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3})).hasLength(2L);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").hasLength(2L);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
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
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isNull();
            Assertions.fail(InputStreamAssertion.class);
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
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should point to the same object.\n\tExpected:<java.io.ByteArrayInputStream.*> but was:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), value, "Message").isSameAs(new ByteArrayInputStream(new byte[]{0, 0, 0}));
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<java.io.ByteArrayInputStream.*> but was:<java.io.ByteArrayInputStream.*>");
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
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should point to the different objects.\n\tActual:<java.io.ByteArrayInputStream.*>");
        }
        try {
            initialize(Raw.inputStreamAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(InputStreamAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<java.io.ByteArrayInputStream.*>");
        }
    }

}
