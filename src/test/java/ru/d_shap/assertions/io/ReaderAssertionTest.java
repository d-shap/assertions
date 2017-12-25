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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link ReaderAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class ReaderAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public ReaderAssertionTest() {
        super();
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.readerAssertion(), new StringReader(""));

        try {
            initializeWithRawActual(Raw.readerAssertion(), new Object());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.readerAssertion(), new Object(), "Message");
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     *
     * @throws IOException IO exception.
     */
    @Test
    public void isCompletedTest() throws IOException {
        initialize(Raw.readerAssertion(), new StringReader("")).isCompleted();
        StringReader reader = new StringReader("123");
        Assertions.assertThat(reader.read()).isEqualTo(49);
        Assertions.assertThat(reader.read()).isEqualTo(50);
        Assertions.assertThat(reader.read()).isEqualTo(51);
        initialize(Raw.readerAssertion(), reader).isCompleted();

        try {
            Raw.readerAssertion().isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new ErrorReader()).isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new ErrorReader(), "Message").isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should be less then the expected. Expected:<0> but was:<49>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should be less then the expected. Expected:<0> but was:<49>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void toCharArrayFullTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray().containsExactlyInOrder('1', '2', '3');

        try {
            Raw.readerAssertion().toCharArray();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toCharArray();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new ErrorReader()).toCharArray();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new ErrorReader(), "Message").toCharArray();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. java.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray()).containsExactlyInOrder('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should not be null.");
        }
        try {
            clearActual(initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray()).containsExactlyInOrder('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray().containsExactlyInOrder('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray().containsExactlyInOrder('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void toCharArrayWithLengthTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(4).containsExactlyInOrder('1', '2', '3');
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(3).containsExactlyInOrder('1', '2', '3');
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(2).containsExactlyInOrder('1', '2');
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(1).containsExactlyInOrder('1');

        try {
            Raw.readerAssertion().toCharArray(1);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toCharArray(1);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray(1);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toCharArray(0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray(0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray(0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(-1);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray(-1);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should be valid.");
        }
        try {
            initialize(Raw.readerAssertion(), new ErrorReader()).toCharArray(3);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new ErrorReader(), "Message").toCharArray(3);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. java.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(1)).containsExactlyInOrder('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should not be null.");
        }
        try {
            clearActual(initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray(1)).containsExactlyInOrder('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(4).containsExactlyInOrder('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray(4).containsExactlyInOrder('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isNextCharsEqualToArrayCharTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo('1', '2');
        initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo('1', '2', '3');
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isNextCharsEqualTo((char) 0, (char) 0);

        try {
            Raw.readerAssertion().isNextCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isNextCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isNextCharsEqualTo();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo('1', '3');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo('1', '2', '3', '4');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000")).isNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000"), "Message").isNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isNextCharsEqualToArrayIntTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(49, 50);
        initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(49, 50, 51);
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isNextCharsEqualTo(0, 0);

        try {
            Raw.readerAssertion().isNextCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isNextCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(new int[0]);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isNextCharsEqualTo(new int[0]);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(49, 51);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(49, 50, 51, 52);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo(49, 50);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000")).isNextCharsEqualTo(0, 0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000"), "Message").isNextCharsEqualTo(0, 0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isNextCharsEqualToIterableTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(Arrays.asList('1', '2'));
        initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(Arrays.asList('1', '2', '3'));
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0));

        try {
            Raw.readerAssertion().isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(Arrays.asList('1', '3'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(Arrays.asList('1', '2', '3', '4'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo(Arrays.asList('1', '2'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000")).isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000"), "Message").isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isAllCharsEqualToArrayCharTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo('1', '2', '3');
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo((char) 0, (char) 0, (char) 0);
        initialize(Raw.readerAssertion(), new StringReader("")).isAllCharsEqualTo();

        try {
            Raw.readerAssertion().isAllCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isAllCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isAllCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isAllCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo('1', '2', '4');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo('1', '2', '3', '4');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000"), "Message").isAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isAllCharsEqualToArrayIntTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(49, 50, 51);
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo(0, 0, 0);
        initialize(Raw.readerAssertion(), new StringReader("")).isAllCharsEqualTo(new int[0]);

        try {
            Raw.readerAssertion().isAllCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isAllCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isAllCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isAllCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(49, 50);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(49, 50, 52);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(49, 50, 51, 52);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo(0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000"), "Message").isAllCharsEqualTo(0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isAllCharsEqualToIterableTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(Arrays.asList('1', '2', '3'));
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
        initialize(Raw.readerAssertion(), new StringReader("")).isAllCharsEqualTo(new ArrayList<Character>());

        try {
            Raw.readerAssertion().isAllCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isAllCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(Arrays.asList('1', '2'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(Arrays.asList('1', '2', '4'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(Arrays.asList('1', '2', '3', '4'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000"), "Message").isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check reader chars. Value should contain all of the expected values exactly in the specified order. Expected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.readerAssertion(), null).isNull();

        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isNull();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Value should be null. Actual:<java.io.StringReader.*>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000"), "Message").isNull();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Value should be null. Actual:<java.io.StringReader.*>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Reader value = new StringReader("\u0000\u0000\u0000");
        initialize(Raw.readerAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.readerAssertion(), value).isSameAs(new StringReader("\u0000\u0000\u0000"));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be the same. Expected:<java.io.StringReader.*> but was:<java.io.StringReader.*>");
        }
        try {
            initialize(Raw.readerAssertion(), value, "Message").isSameAs(new StringReader("\u0000\u0000\u0000"));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be the same. Expected:<java.io.StringReader.*> but was:<java.io.StringReader.*>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Reader value = new StringReader("\u0000\u0000\u0000");
        initialize(Raw.readerAssertion(), value).isNotSameAs(new StringReader("\u0000\u0000\u0000"));

        try {
            initialize(Raw.readerAssertion(), value).isNotSameAs(value);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Values should be different. Actual:<java.io.StringReader.*>");
        }
        try {
            initialize(Raw.readerAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message. Values should be different. Actual:<java.io.StringReader.*>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.readerAssertion(), null).asString(null));
            Assertions.fail("ReaderAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.readerAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.readerAssertion(), null).asString(new StringReader(""))).matches("java.io.StringReader.*");
        Assertions.assertThat(initialize(Raw.readerAssertion(), null).asString(new StringReader("\u0000\u0000\u0000"))).matches("java.io.StringReader.*");
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
