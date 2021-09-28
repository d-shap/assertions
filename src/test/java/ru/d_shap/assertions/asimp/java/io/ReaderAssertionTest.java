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

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
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
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.io.Reader> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.readerAssertion(), new Object(), "Message");
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.io.Reader> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isCompletedTest() throws Exception {
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader()).isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader(), "Message").isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000")).isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be completed.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000"), "Message").isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be completed.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be completed.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be completed.");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isNotCompletedTest() {
        StringReader reader = new StringReader("123\u00004");
        initialize(Raw.readerAssertion(), reader).isNotCompleted();
        initialize(Raw.readerAssertion(), reader).isNotCompleted();
        initialize(Raw.readerAssertion(), reader).isNotCompleted();
        initialize(Raw.readerAssertion(), reader).isNotCompleted();
        initialize(Raw.readerAssertion(), reader).isNotCompleted();
        initialize(Raw.readerAssertion(), reader).isCompleted();

        try {
            Raw.readerAssertion().isNotCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNotCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNotCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader()).isNotCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader(), "Message").isNotCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNotCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be completed.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isNotCompleted();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be completed.");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void toCharArrayTest() {
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader()).toCharArray();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader(), "Message").toCharArray();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray()).containsExactlyInOrder('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray()).containsExactlyInOrder('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray().containsExactlyInOrder('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray().containsExactlyInOrder('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void toCharArrayLengthTest() {
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray(1);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toCharArray(0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray(0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).toCharArray(0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").toCharArray(0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).toCharArray(-1);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").toCharArray(-1);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader()).toCharArray(3);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader(), "Message").toCharArray(3);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(1)).containsExactlyInOrder('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray(1)).containsExactlyInOrder('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(4).containsExactlyInOrder('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray(4).containsExactlyInOrder('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void toCharArrayMatcherTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(Matchers.arrayContaining('1', '2', '3'));

        try {
            Raw.readerAssertion().toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toCharArray(null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray(null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).toCharArray(null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").toCharArray(null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader()).toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader(), "Message").toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(Matchers.arrayContaining('1', '2'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray(Matchers.arrayContaining('1', '2'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void toCharArrayLengthMatcherTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(4, Matchers.arrayContaining('1', '2', '3'));
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(3, Matchers.arrayContaining('1', '2', '3'));
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(2, Matchers.arrayContaining('1', '2'));
        initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(1, Matchers.arrayContaining('1'));

        try {
            Raw.readerAssertion().toCharArray(1, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toCharArray(1, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray(1, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).toCharArray(-1, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").toCharArray(-1, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).toCharArray(0, null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").toCharArray(0, null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).toCharArray(1, null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").toCharArray(1, null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader()).toCharArray(3, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader(), "Message").toCharArray(3, Matchers.arrayContaining((char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toCharArray(4, Matchers.arrayContaining('1', '2'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toCharArray(4, Matchers.arrayContaining('1', '2'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 4.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isNextCharEqualToTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharEqualTo('1');
        initialize(Raw.readerAssertion(), new StringReader("234")).isNextCharEqualTo('2');
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isNextCharEqualTo(0);

        try {
            Raw.readerAssertion().isNextCharEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharEqualTo('2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50)]> but was:<[1(49)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").isNextCharEqualTo('2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50)]> but was:<[1(49)]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isNextCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isNextCharsEqualTo();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo('1', '3');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo('1', '2', '3', '4');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000")).isNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000"), "Message").isNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isNextCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo(new int[]{});
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isNextCharsEqualTo(new int[]{});
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(49, 51);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(49, 50, 51, 52);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo(49, 50);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000")).isNextCharsEqualTo(0, 0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000"), "Message").isNextCharsEqualTo(0, 0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(Arrays.asList('1', '3'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isNextCharsEqualTo(Arrays.asList('1', '2', '3', '4'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isNextCharsEqualTo(Arrays.asList('1', '2'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000")).isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000"), "Message").isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo('1');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isAllCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isAllCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isAllCharsEqualTo((char[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo('1', '2');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo('1', '2', '4');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo('1', '2', '3', '4');
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000"), "Message").isAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     */
    @Test
    public void isAllCharsEqualToArrayIntTest() {
        initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(49, 50, 51);
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo(0, 0, 0);
        initialize(Raw.readerAssertion(), new StringReader("")).isAllCharsEqualTo(new int[]{});

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo(49);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isAllCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isAllCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isAllCharsEqualTo((int[]) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(49, 50);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(49, 50, 52);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(49, 50, 51, 52);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo(0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000"), "Message").isAllCharsEqualTo(0, 0);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(Arrays.asList('1', '2'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(Arrays.asList('1', '2', '4'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).isAllCharsEqualTo(Arrays.asList('1', '2', '3', '4'));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000")).isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000"), "Message").isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLengthTest() throws Exception {
        initialize(Raw.readerAssertion(), new StringReader("12")).toLength().isEqualTo(2L);
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000\u0000\u0000")).toLength().isEqualTo(5L);
        initialize(Raw.readerAssertion(), new StringReader("")).toLength().isEqualTo(0L);

        StringReader reader1 = new StringReader("123");
        initialize(Raw.readerAssertion(), reader1).toLength().isEqualTo(3L);
        Assertions.assertThat(reader1.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader1).toLength().isEqualTo(0L);

        StringReader reader2 = new StringReader("123");
        Assertions.assertThat(reader2.read()).isEqualTo('1');
        initialize(Raw.readerAssertion(), reader2).toLength().isEqualTo(2L);
        Assertions.assertThat(reader2.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader2).toLength().isEqualTo(0L);

        StringReader reader3 = new StringReader("123");
        Assertions.assertThat(reader3.read()).isEqualTo('1');
        Assertions.assertThat(reader3.read()).isEqualTo('2');
        initialize(Raw.readerAssertion(), reader3).toLength().isEqualTo(1L);
        Assertions.assertThat(reader3.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader3).toLength().isEqualTo(0L);

        StringReader reader4 = new StringReader("123");
        Assertions.assertThat(reader4.read()).isEqualTo('1');
        Assertions.assertThat(reader4.read()).isEqualTo('2');
        Assertions.assertThat(reader4.read()).isEqualTo('3');
        initialize(Raw.readerAssertion(), reader4).toLength().isEqualTo(0L);
        Assertions.assertThat(reader4.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader4).toLength().isEqualTo(0L);

        StringReader reader5 = new StringReader("123");
        Assertions.assertThat(reader5.read()).isEqualTo('1');
        Assertions.assertThat(reader5.read()).isEqualTo('2');
        Assertions.assertThat(reader5.read()).isEqualTo('3');
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader5).toLength().isEqualTo(0L);
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader5).toLength().isEqualTo(0L);

        try {
            Raw.readerAssertion().toLength();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toLength();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toLength();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader()).toLength();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader(), "Message").toLength();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toLength().isEqualTo(2L);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toLength().isEqualTo(2L);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLengthMatcherTest() throws Exception {
        initialize(Raw.readerAssertion(), new StringReader("12")).toLength(Matchers.is(Matchers.equalTo(2L)));
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000\u0000\u0000")).toLength(Matchers.equalTo(5L));
        initialize(Raw.readerAssertion(), new StringReader("")).toLength(Matchers.equalTo(0L));

        StringReader reader1 = new StringReader("123");
        initialize(Raw.readerAssertion(), reader1).toLength(Matchers.equalTo(3L));
        Assertions.assertThat(reader1.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader1).toLength(Matchers.equalTo(0L));

        StringReader reader2 = new StringReader("123");
        Assertions.assertThat(reader2.read()).isEqualTo('1');
        initialize(Raw.readerAssertion(), reader2).toLength(Matchers.equalTo(2L));
        Assertions.assertThat(reader2.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader2).toLength(Matchers.equalTo(0L));

        StringReader reader3 = new StringReader("123");
        Assertions.assertThat(reader3.read()).isEqualTo('1');
        Assertions.assertThat(reader3.read()).isEqualTo('2');
        initialize(Raw.readerAssertion(), reader3).toLength(Matchers.equalTo(1L));
        Assertions.assertThat(reader3.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader3).toLength(Matchers.equalTo(0L));

        StringReader reader4 = new StringReader("123");
        Assertions.assertThat(reader4.read()).isEqualTo('1');
        Assertions.assertThat(reader4.read()).isEqualTo('2');
        Assertions.assertThat(reader4.read()).isEqualTo('3');
        initialize(Raw.readerAssertion(), reader4).toLength(Matchers.equalTo(0L));
        Assertions.assertThat(reader4.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader4).toLength(Matchers.equalTo(0L));

        StringReader reader5 = new StringReader("123");
        Assertions.assertThat(reader5.read()).isEqualTo('1');
        Assertions.assertThat(reader5.read()).isEqualTo('2');
        Assertions.assertThat(reader5.read()).isEqualTo('3');
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader5).toLength(Matchers.equalTo(0L));
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader5).toLength(Matchers.equalTo(0L));

        try {
            Raw.readerAssertion().toLength(Matchers.equalTo(0L));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toLength(Matchers.equalTo(0L));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toLength(Matchers.equalTo(0L));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null).toLength(null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").toLength(null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("")).toLength(null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader(""), "Message").toLength(null);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader()).toLength(Matchers.equalTo(0L));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader(), "Message").toLength(Matchers.equalTo(0L));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).toLength(Matchers.equalTo(2L));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <2L>\n     but: was <3L>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").toLength(Matchers.equalTo(2L));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <2L>\n     but: was <3L>");
        }
    }

    /**
     * {@link ReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasLengthTest() throws Exception {
        initialize(Raw.readerAssertion(), new StringReader("12")).hasLength(2L);
        initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000\u0000\u0000")).hasLength(5L);
        initialize(Raw.readerAssertion(), new StringReader("")).hasLength(0L);

        StringReader reader1 = new StringReader("123");
        initialize(Raw.readerAssertion(), reader1).hasLength(3L);
        Assertions.assertThat(reader1.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader1).hasLength(0L);

        StringReader reader2 = new StringReader("123");
        Assertions.assertThat(reader2.read()).isEqualTo('1');
        initialize(Raw.readerAssertion(), reader2).hasLength(2L);
        Assertions.assertThat(reader2.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader2).hasLength(0L);

        StringReader reader3 = new StringReader("123");
        Assertions.assertThat(reader3.read()).isEqualTo('1');
        Assertions.assertThat(reader3.read()).isEqualTo('2');
        initialize(Raw.readerAssertion(), reader3).hasLength(1L);
        Assertions.assertThat(reader3.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader3).hasLength(0L);

        StringReader reader4 = new StringReader("123");
        Assertions.assertThat(reader4.read()).isEqualTo('1');
        Assertions.assertThat(reader4.read()).isEqualTo('2');
        Assertions.assertThat(reader4.read()).isEqualTo('3');
        initialize(Raw.readerAssertion(), reader4).hasLength(0L);
        Assertions.assertThat(reader4.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader4).hasLength(0L);

        StringReader reader5 = new StringReader("123");
        Assertions.assertThat(reader5.read()).isEqualTo('1');
        Assertions.assertThat(reader5.read()).isEqualTo('2');
        Assertions.assertThat(reader5.read()).isEqualTo('3');
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader5).hasLength(0L);
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.readerAssertion(), reader5).hasLength(0L);

        try {
            Raw.readerAssertion().hasLength(0L);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.readerAssertion(), null).hasLength(0L);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), null, "Message").hasLength(0L);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader()).hasLength(0L);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), createErrorReader(), "Message").hasLength(0L);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123")).hasLength(2L);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("123"), "Message").hasLength(2L);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
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
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.io.StringReader.*>");
        }
        try {
            initialize(Raw.readerAssertion(), new StringReader("\u0000\u0000\u0000"), "Message").isNull();
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual value should be null.\n\tActual:<java.io.StringReader.*>");
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
            Assertions.assertThat(ex).messageMatches("Actual and expected values should be the same.\n\tExpected:<java.io.StringReader.*> but was:<java.io.StringReader.*>");
        }
        try {
            initialize(Raw.readerAssertion(), value, "Message").isSameAs(new StringReader("\u0000\u0000\u0000"));
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should be the same.\n\tExpected:<java.io.StringReader.*> but was:<java.io.StringReader.*>");
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
            Assertions.assertThat(ex).messageMatches("Actual and expected values should be different.\n\tActual:<java.io.StringReader.*>");
        }
        try {
            initialize(Raw.readerAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("ReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should be different.\n\tActual:<java.io.StringReader.*>");
        }
    }

}
