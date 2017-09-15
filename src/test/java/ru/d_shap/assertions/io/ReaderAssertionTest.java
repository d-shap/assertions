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

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link ReaderAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ReaderAssertionTest {

    /**
     * Test class constructor.
     */
    public ReaderAssertionTest() {
        super();
    }

    /**
     * {@link ReaderAssertion} class test.
     *
     * @throws IOException IO exception.
     */
    @Test
    public void isCompletedTest() throws IOException {
        new ReaderAssertion(new StringReader(""), null).isCompleted();
        StringReader reader = new StringReader("123");
        Assertions.assertThat(reader.read()).isEqualTo(49);
        Assertions.assertThat(reader.read()).isEqualTo(50);
        Assertions.assertThat(reader.read()).isEqualTo(51);
        new ReaderAssertion(reader, null).isCompleted();

        try {
            new ReaderAssertion(null, null).isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReaderAssertion(new ErrorReader(), null).isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be less then or equal to the expected. Expected:<-1> but was:<49>");
        }
        try {
            new ReaderAssertion(new StringReader("123"), "Message").isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be less then or equal to the expected. Expected:<-1> but was:<49>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isNextCharsEqualToTest() {
        new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo('1');
        new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo(49);
        new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo(Collections.singletonList('1'));

        new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo('1', '2');
        new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo(49, 50);
        new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo(Arrays.asList('1', '2'));

        new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo('1', '2', '3');
        new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo(49, 50, 51);
        new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo(Arrays.asList('1', '2', '3'));

        new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), null).isNextCharsEqualTo((char) 0, (char) 0);
        new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), null).isNextCharsEqualTo(0, 0);
        new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), null).isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0));

        new ReaderAssertion(new StringReader(""), null).isNextCharsEqualTo();
        new ReaderAssertion(new StringReader(""), null).isNextCharsEqualTo(new int[0]);
        new ReaderAssertion(new StringReader(""), null).isNextCharsEqualTo(new ArrayList<Character>());

        try {
            new ReaderAssertion(null, null).isNextCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReaderAssertion(null, null).isNextCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReaderAssertion(null, null).isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReaderAssertion(new ErrorReader(), null).isNextCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new ReaderAssertion(new ErrorReader(), null).isNextCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new ReaderAssertion(new ErrorReader(), null).isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo('1', '3');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo('1', '2', '3', '4');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isNextCharsEqualTo();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1]>");
        }
        try {
            new ReaderAssertion(new StringReader(""), null).isNextCharsEqualTo('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000"), null).isNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000"), "Message").isNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000"), null).isNextCharsEqualTo(0, 0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000"), "Message").isNextCharsEqualTo(0, 0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000"), null).isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000"), "Message").isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isAllCharsEqualToTest() {
        new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo('1', '2', '3');
        new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo(49, 50, 51);
        new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo(Arrays.asList('1', '2', '3'));

        new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), null).isAllCharsEqualTo((byte) 0, (byte) 0, (byte) 0);
        new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), null).isAllCharsEqualTo(0, 0, 0);
        new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), null).isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));

        new ReaderAssertion(new StringReader(""), null).isAllCharsEqualTo();
        new ReaderAssertion(new StringReader(""), null).isAllCharsEqualTo(new int[0]);
        new ReaderAssertion(new StringReader(""), null).isAllCharsEqualTo(new ArrayList<Character>());

        try {
            new ReaderAssertion(null, null).isAllCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReaderAssertion(null, null).isAllCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReaderAssertion(null, null).isAllCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new ReaderAssertion(new ErrorReader(), null).isAllCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new ReaderAssertion(new ErrorReader(), null).isAllCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new ReaderAssertion(new ErrorReader(), null).isAllCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo('1', '2', '4');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new ReaderAssertion(new StringReader("123"), null).isAllCharsEqualTo('1', '2', '3', '4');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), null).isAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), "Message").isAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), null).isAllCharsEqualTo(0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), "Message").isAllCharsEqualTo(0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), null).isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            new ReaderAssertion(new StringReader("\u0000\u0000\u0000"), "Message").isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new ReaderAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new ReaderAssertion(null, null).asString(new StringBuilder("test"))).isNull();
        Assertions.assertThat(new ReaderAssertion(null, null).asString(new StringReader(""))).isNull();
        Assertions.assertThat(new ReaderAssertion(null, null).asString(new StringReader("\u0000\u0000\u0000"))).isNull();
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class ErrorReader extends Reader {

        ErrorReader() {
            super();
        }

        @Override
        public int read() throws IOException {
            throw new IOException("read exception");
        }

        @Override
        public int read(final char[] buffer, final int from, final int to) throws IOException {
            throw new IOException("read exception");
        }

        @Override
        public void close() throws IOException {
            // Ignore
        }

    }

}
