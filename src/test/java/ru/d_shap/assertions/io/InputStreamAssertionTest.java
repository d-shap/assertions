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
package ru.d_shap.assertions.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

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
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), null).isCompleted();
        ByteArrayInputStream bais = new ByteArrayInputStream(new byte[]{1, 2, 3});
        Assertions.assertThat(bais.read()).isEqualTo(1);
        Assertions.assertThat(bais.read()).isEqualTo(2);
        Assertions.assertThat(bais.read()).isEqualTo(3);
        new InputStreamAssertion(bais, null).isCompleted();

        try {
            new InputStreamAssertion(null, null).isCompleted();
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), null).isCompleted();
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isCompleted();
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<-1> but was:<1>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), "Message").isCompleted();
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<-1> but was:<1>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isNextBytesEqualToTest() {
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo((byte) 1);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo(1);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo(Collections.singletonList((byte) 1));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo((byte) 1, (byte) 2);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo(1, 2);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo(1, 2, 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), null).isNextBytesEqualTo((byte) 0, (byte) 0);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), null).isNextBytesEqualTo(0, 0);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), null).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), null).isNextBytesEqualTo();
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), null).isNextBytesEqualTo(new int[0]);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), null).isNextBytesEqualTo(new ArrayList<Byte>());

        try {
            new InputStreamAssertion(null, null).isNextBytesEqualTo((byte) 1);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, null).isNextBytesEqualTo(1);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, null).isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo((byte[]) null);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo((int[]) null);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), null).isNextBytesEqualTo((byte) 1);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), null).isNextBytesEqualTo(1);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), null).isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo((byte) 1, (byte) 3);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isNextBytesEqualTo();
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[0]), null).isNextBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), null).isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), "Message").isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), null).isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), "Message").isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), null).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), "Message").isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void isAllBytesEqualToTest() {
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo(1, 2, 3);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo(Arrays.asList((byte) 1, (byte) 2, (byte) 3));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), null).isAllBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), null).isAllBytesEqualTo(0, 0, 0);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), null).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), null).isAllBytesEqualTo();
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), null).isAllBytesEqualTo(new int[0]);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), null).isAllBytesEqualTo(new ArrayList<Byte>());

        try {
            new InputStreamAssertion(null, null).isAllBytesEqualTo((byte) 1);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, null).isAllBytesEqualTo(1);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(null, null).isAllBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo((byte[]) null);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo((int[]) null);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo((Iterable<Byte>) null);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), null).isAllBytesEqualTo((byte) 1);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), null).isAllBytesEqualTo(1);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), null).isAllBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo((byte) 1);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 4);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), null).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), null).isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), null).isAllBytesEqualTo(0, 0);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isAllBytesEqualTo(0, 0);
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), null).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), "Message").isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("Input stream assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new InputStreamAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, null).asString(new StringBuilder("test"))).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, null).asString(new ByteArrayInputStream(new byte[0]))).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, null).asString(new ByteArrayInputStream(new byte[]{0, 0, 0}))).isNull();
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
