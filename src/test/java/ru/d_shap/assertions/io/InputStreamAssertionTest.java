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
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check input stream byte read. Value should be less then or equal to the expected. Expected:<-1> but was:<1>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription("Message")).isCompleted();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check input stream byte read. Value should be less then or equal to the expected. Expected:<-1> but was:<1>.");
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

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), new FailDescription()).isNextBytesEqualTo();
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), new FailDescription()).isNextBytesEqualTo(new int[0]);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), new FailDescription()).isNextBytesEqualTo(new ArrayList<Byte>());

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
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).isNextBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).isNextBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).isNextBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((byte) 1, (byte) 3);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isNextBytesEqualTo();
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[0]), new FailDescription()).isNextBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription()).isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription("Message")).isNextBytesEqualTo((byte) 0, (byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription()).isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription("Message")).isNextBytesEqualTo(0, 0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription()).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0}), new FailDescription("Message")).isNextBytesEqualTo(Arrays.asList((byte) 0, (byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0, 0]> but was:<[0, 0]>.");
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

        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), new FailDescription()).isAllBytesEqualTo();
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), new FailDescription()).isAllBytesEqualTo(new int[0]);
        new InputStreamAssertion(new ByteArrayInputStream(new byte[]{}), new FailDescription()).isAllBytesEqualTo(new ArrayList<Byte>());

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
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).isAllBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).isAllBytesEqualTo(1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ErrorInputStream(), new FailDescription()).isAllBytesEqualTo(new ArrayList<Byte>());
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte) 1);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte) 1, (byte) 2);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{1, 2, 3}), new FailDescription()).isAllBytesEqualTo((byte) 1, (byte) 2, (byte) 3, (byte) 4);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription("Message")).isAllBytesEqualTo((byte) 0, (byte) 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isAllBytesEqualTo(0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription("Message")).isAllBytesEqualTo(0, 0);
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription()).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
        try {
            new InputStreamAssertion(new ByteArrayInputStream(new byte[]{0, 0, 0}), new FailDescription("Message")).isAllBytesEqualTo(Arrays.asList((byte) 0, (byte) 0));
            Assertions.fail("InputStreamAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[0, 0]> but was:<[0, 0, 0]>.");
        }
    }

    /**
     * {@link InputStreamAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(null, true)).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(new StringBuilder("test"), true)).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(new ByteArrayInputStream(new byte[0]), true)).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(new ByteArrayInputStream(new byte[]{0, 0, 0}), true)).isNull();

        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(null, false)).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(new StringBuilder("test"), false)).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(new ByteArrayInputStream(new byte[0]), false)).isNull();
        Assertions.assertThat(new InputStreamAssertion(null, new FailDescription()).asString(new ByteArrayInputStream(new byte[]{0, 0, 0}), false)).isNull();
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
