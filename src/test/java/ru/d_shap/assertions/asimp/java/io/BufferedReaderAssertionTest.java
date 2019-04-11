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
package ru.d_shap.assertions.asimp.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link BufferedReaderAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class BufferedReaderAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public BufferedReaderAssertionTest() {
        super();
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")));

        try {
            initializeWithRawActual(Raw.bufferedReaderAssertion(), new Object());
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.bufferedReaderAssertion(), new Object(), "Message");
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws IOException IO exception.
     */
    @Test
    public void isCompletedTest() throws IOException {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isCompleted();
        BufferedReader reader = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader.read()).isEqualTo(49);
        Assertions.assertThat(reader.read()).isEqualTo(50);
        Assertions.assertThat(reader.read()).isEqualTo(51);
        initialize(Raw.bufferedReaderAssertion(), reader).isCompleted();

        try {
            Raw.bufferedReaderAssertion().isCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader()).isCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader(), "Message").isCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be completed.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").isCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be completed.");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNotCompletedTest() {
        BufferedReader reader = new BufferedReader(new StringReader("123"));
        initialize(Raw.bufferedReaderAssertion(), reader).isNotCompleted();
        initialize(Raw.bufferedReaderAssertion(), reader).isNotCompleted();
        initialize(Raw.bufferedReaderAssertion(), reader).isNotCompleted();
        initialize(Raw.bufferedReaderAssertion(), reader).isCompleted();

        try {
            Raw.bufferedReaderAssertion().isNotCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNotCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNotCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader()).isNotCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader(), "Message").isNotCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNotCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be completed.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isNotCompleted();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be completed.");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toCharArrayTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray().containsExactlyInOrder('1', '2', '3');

        try {
            Raw.bufferedReaderAssertion().toCharArray();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader()).toCharArray();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader(), "Message").toCharArray();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray()).containsExactlyInOrder('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray()).containsExactlyInOrder('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray().containsExactlyInOrder('1', '2');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray().containsExactlyInOrder('1', '2');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toCharArrayLengthTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(4).containsExactlyInOrder('1', '2', '3');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(3).containsExactlyInOrder('1', '2', '3');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(2).containsExactlyInOrder('1', '2');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(1).containsExactlyInOrder('1');

        try {
            Raw.bufferedReaderAssertion().toCharArray(1);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(1);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(1);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(-1);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(-1);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader()).toCharArray(3);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader(), "Message").toCharArray(3);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(1)).containsExactlyInOrder('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray(1)).containsExactlyInOrder('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(4).containsExactlyInOrder('1', '2');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray(4).containsExactlyInOrder('1', '2');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toCharArrayMatcherTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(Matchers.arrayContaining('1', '2', '3'));

        try {
            Raw.bufferedReaderAssertion().toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader()).toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader(), "Message").toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(Matchers.arrayContaining('1', '2'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\nExpected: [\"1\", \"2\"]\n     but: Not matched: \"3\"");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray(Matchers.arrayContaining('1', '2'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\nExpected: [\"1\", \"2\"]\n     but: Not matched: \"3\"");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toCharArrayLengthMatcherTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(4, Matchers.arrayContaining('1', '2', '3'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(3, Matchers.arrayContaining('1', '2', '3'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(2, Matchers.arrayContaining('1', '2'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(1, Matchers.arrayContaining('1'));

        try {
            Raw.bufferedReaderAssertion().toCharArray(1, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(1, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(1, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(-1, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(-1, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(0, null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(0, null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(1, null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(1, null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader()).toCharArray(3, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader(), "Message").toCharArray(3, Matchers.arrayContaining((char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(4, Matchers.arrayContaining('1', '2'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\nExpected: [\"1\", \"2\"]\n     but: Not matched: \"3\"");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray(4, Matchers.arrayContaining('1', '2'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 4.\nExpected: [\"1\", \"2\"]\n     but: Not matched: \"3\"");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toStringArrayTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toStringArrayLengthTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toStringArrayMatcherTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toStringArrayLengthMatcherTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNextCharEqualToTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharEqualTo('1');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("234"))).isNextCharEqualTo('2');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isNextCharEqualTo(0);

        try {
            Raw.bufferedReaderAssertion().isNextCharEqualTo('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNextCharEqualTo('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNextCharEqualTo('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharEqualTo('2');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50)]> but was:<[1(49)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").isNextCharEqualTo('2');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50)]> but was:<[1(49)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNextCharsEqualToArrayCharTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo('1', '2');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo('1', '2', '3');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isNextCharsEqualTo((char) 0, (char) 0);

        try {
            Raw.bufferedReaderAssertion().isNextCharsEqualTo('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNextCharsEqualTo('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNextCharsEqualTo('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNextCharsEqualTo((char[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNextCharsEqualTo((char[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNextCharsEqualTo((char[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isNextCharsEqualTo((char[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNextCharsEqualTo();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isNextCharsEqualTo();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo('1', '3');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo('1', '2', '3', '4');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNextCharsEqualTo('1', '2');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000"))).isNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000")), "Message").isNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNextCharsEqualToArrayIntTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo(49, 50);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo(49, 50, 51);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isNextCharsEqualTo(0, 0);

        try {
            Raw.bufferedReaderAssertion().isNextCharsEqualTo(49);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNextCharsEqualTo(49);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNextCharsEqualTo(49);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNextCharsEqualTo((int[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNextCharsEqualTo((int[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNextCharsEqualTo((int[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isNextCharsEqualTo((int[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNextCharsEqualTo(new int[]{});
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isNextCharsEqualTo(new int[]{});
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo(49, 51);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo(49, 50, 51, 52);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNextCharsEqualTo(49, 50);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000"))).isNextCharsEqualTo(0, 0, 0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000")), "Message").isNextCharsEqualTo(0, 0, 0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNextCharsEqualToIterableTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo(Arrays.asList('1', '2'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo(Arrays.asList('1', '2', '3'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0));

        try {
            Raw.bufferedReaderAssertion().isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isNextCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo(Arrays.asList('1', '3'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharsEqualTo(Arrays.asList('1', '2', '3', '4'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNextCharsEqualTo(Arrays.asList('1', '2'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000"))).isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000")), "Message").isNextCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isAllCharsEqualToArrayCharTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo('1', '2', '3');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isAllCharsEqualTo((char) 0, (char) 0, (char) 0);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isAllCharsEqualTo();

        try {
            Raw.bufferedReaderAssertion().isAllCharsEqualTo('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isAllCharsEqualTo('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isAllCharsEqualTo('1');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isAllCharsEqualTo((char[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isAllCharsEqualTo((char[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isAllCharsEqualTo((char[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isAllCharsEqualTo((char[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo('1', '2');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo('1', '2', '4');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo('1', '2', '3', '4');
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000")), "Message").isAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isAllCharsEqualToArrayIntTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo(49, 50, 51);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isAllCharsEqualTo(0, 0, 0);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isAllCharsEqualTo(new int[]{});

        try {
            Raw.bufferedReaderAssertion().isAllCharsEqualTo(49);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isAllCharsEqualTo(49);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isAllCharsEqualTo(49);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isAllCharsEqualTo((int[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isAllCharsEqualTo((int[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isAllCharsEqualTo((int[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isAllCharsEqualTo((int[]) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo(49, 50);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo(49, 50, 52);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo(49, 50, 51, 52);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isAllCharsEqualTo(0, 0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000")), "Message").isAllCharsEqualTo(0, 0);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isAllCharsEqualToIterableTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo(Arrays.asList('1', '2', '3'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0, (char) 0));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isAllCharsEqualTo(new ArrayList<Character>());

        try {
            Raw.bufferedReaderAssertion().isAllCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isAllCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isAllCharsEqualTo(new ArrayList<Character>());
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo(Arrays.asList('1', '2'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo(Arrays.asList('1', '2', '4'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isAllCharsEqualTo(Arrays.asList('1', '2', '3', '4'));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000")), "Message").isAllCharsEqualTo(Arrays.asList((char) 0, (char) 0));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNextLineEqualToTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNextLinesEqualToArrayTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNextLinesEqualToIterableTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isAllLinesEqualToArrayTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isAllLinesEqualToIterableTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws IOException IO exception.
     */
    @Test
    public void toLengthTest() throws IOException {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("12"))).toLength().isEqualTo(2L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000\u0000\u0000"))).toLength().isEqualTo(5L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toLength().isEqualTo(0L);

        BufferedReader reader1 = new BufferedReader(new StringReader("123"));
        initialize(Raw.bufferedReaderAssertion(), reader1).toLength().isEqualTo(3L);
        Assertions.assertThat(reader1.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader1).toLength().isEqualTo(0L);

        BufferedReader reader2 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader2.read()).isEqualTo('1');
        initialize(Raw.bufferedReaderAssertion(), reader2).toLength().isEqualTo(2L);
        Assertions.assertThat(reader2.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader2).toLength().isEqualTo(0L);

        BufferedReader reader3 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader3.read()).isEqualTo('1');
        Assertions.assertThat(reader3.read()).isEqualTo('2');
        initialize(Raw.bufferedReaderAssertion(), reader3).toLength().isEqualTo(1L);
        Assertions.assertThat(reader3.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader3).toLength().isEqualTo(0L);

        BufferedReader reader4 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader4.read()).isEqualTo('1');
        Assertions.assertThat(reader4.read()).isEqualTo('2');
        Assertions.assertThat(reader4.read()).isEqualTo('3');
        initialize(Raw.bufferedReaderAssertion(), reader4).toLength().isEqualTo(0L);
        Assertions.assertThat(reader4.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader4).toLength().isEqualTo(0L);

        BufferedReader reader5 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader5.read()).isEqualTo('1');
        Assertions.assertThat(reader5.read()).isEqualTo('2');
        Assertions.assertThat(reader5.read()).isEqualTo('3');
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader5).toLength().isEqualTo(0L);
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader5).toLength().isEqualTo(0L);

        try {
            Raw.bufferedReaderAssertion().toLength();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toLength();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toLength();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader()).toLength();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader(), "Message").toLength();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toLength().isEqualTo(2L);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toLength().isEqualTo(2L);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws IOException IO exception.
     */
    @Test
    public void toLengthMatcherTest() throws IOException {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("12"))).toLength(Matchers.is(Matchers.equalTo(2L)));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000\u0000\u0000"))).toLength(Matchers.equalTo(5L));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toLength(Matchers.equalTo(0L));

        BufferedReader reader1 = new BufferedReader(new StringReader("123"));
        initialize(Raw.bufferedReaderAssertion(), reader1).toLength(Matchers.equalTo(3L));
        Assertions.assertThat(reader1.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader1).toLength(Matchers.equalTo(0L));

        BufferedReader reader2 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader2.read()).isEqualTo('1');
        initialize(Raw.bufferedReaderAssertion(), reader2).toLength(Matchers.equalTo(2L));
        Assertions.assertThat(reader2.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader2).toLength(Matchers.equalTo(0L));

        BufferedReader reader3 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader3.read()).isEqualTo('1');
        Assertions.assertThat(reader3.read()).isEqualTo('2');
        initialize(Raw.bufferedReaderAssertion(), reader3).toLength(Matchers.equalTo(1L));
        Assertions.assertThat(reader3.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader3).toLength(Matchers.equalTo(0L));

        BufferedReader reader4 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader4.read()).isEqualTo('1');
        Assertions.assertThat(reader4.read()).isEqualTo('2');
        Assertions.assertThat(reader4.read()).isEqualTo('3');
        initialize(Raw.bufferedReaderAssertion(), reader4).toLength(Matchers.equalTo(0L));
        Assertions.assertThat(reader4.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader4).toLength(Matchers.equalTo(0L));

        BufferedReader reader5 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader5.read()).isEqualTo('1');
        Assertions.assertThat(reader5.read()).isEqualTo('2');
        Assertions.assertThat(reader5.read()).isEqualTo('3');
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader5).toLength(Matchers.equalTo(0L));
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader5).toLength(Matchers.equalTo(0L));

        try {
            Raw.bufferedReaderAssertion().toLength(Matchers.equalTo(0L));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toLength(Matchers.equalTo(0L));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toLength(Matchers.equalTo(0L));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toLength(null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toLength(null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toLength(null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toLength(null);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader()).toLength(Matchers.equalTo(0L));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader(), "Message").toLength(Matchers.equalTo(0L));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toLength(Matchers.equalTo(2L));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <2L>\n     but: was <3L>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toLength(Matchers.equalTo(2L));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <2L>\n     but: was <3L>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws IOException IO exception.
     */
    @Test
    public void hasLengthTest() throws IOException {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("12"))).hasLength(2L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000\u0000\u0000"))).hasLength(5L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).hasLength(0L);

        BufferedReader reader1 = new BufferedReader(new StringReader("123"));
        initialize(Raw.bufferedReaderAssertion(), reader1).hasLength(3L);
        Assertions.assertThat(reader1.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader1).hasLength(0L);

        BufferedReader reader2 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader2.read()).isEqualTo('1');
        initialize(Raw.bufferedReaderAssertion(), reader2).hasLength(2L);
        Assertions.assertThat(reader2.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader2).hasLength(0L);

        BufferedReader reader3 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader3.read()).isEqualTo('1');
        Assertions.assertThat(reader3.read()).isEqualTo('2');
        initialize(Raw.bufferedReaderAssertion(), reader3).hasLength(1L);
        Assertions.assertThat(reader3.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader3).hasLength(0L);

        BufferedReader reader4 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader4.read()).isEqualTo('1');
        Assertions.assertThat(reader4.read()).isEqualTo('2');
        Assertions.assertThat(reader4.read()).isEqualTo('3');
        initialize(Raw.bufferedReaderAssertion(), reader4).hasLength(0L);
        Assertions.assertThat(reader4.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader4).hasLength(0L);

        BufferedReader reader5 = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader5.read()).isEqualTo('1');
        Assertions.assertThat(reader5.read()).isEqualTo('2');
        Assertions.assertThat(reader5.read()).isEqualTo('3');
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader5).hasLength(0L);
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader5).hasLength(0L);

        try {
            Raw.bufferedReaderAssertion().hasLength(0L);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).hasLength(0L);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").hasLength(0L);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader()).hasLength(0L);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), createBufferedErrorReader(), "Message").hasLength(0L);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).hasLength(2L);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").hasLength(2L);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toLinesLengthTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toLinesLengthMatcherTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void hasLinesLengthTest() {
        // TODO
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.bufferedReaderAssertion(), null).isNull();

        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isNull();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.io.BufferedReader.*>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000")), "Message").isNull();
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual value should be null.\n\tActual:<java.io.BufferedReader.*>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        BufferedReader value = new BufferedReader(new StringReader("\u0000\u0000\u0000"));
        initialize(Raw.bufferedReaderAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.bufferedReaderAssertion(), value).isSameAs(new BufferedReader(new StringReader("\u0000\u0000\u0000")));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should be the same.\n\tExpected:<java.io.BufferedReader.*> but was:<java.io.BufferedReader.*>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), value, "Message").isSameAs(new BufferedReader(new StringReader("\u0000\u0000\u0000")));
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should be the same.\n\tExpected:<java.io.BufferedReader.*> but was:<java.io.BufferedReader.*>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        BufferedReader value = new BufferedReader(new StringReader("\u0000\u0000\u0000"));
        initialize(Raw.bufferedReaderAssertion(), value).isNotSameAs(new BufferedReader(new StringReader("\u0000\u0000\u0000")));

        try {
            initialize(Raw.bufferedReaderAssertion(), value).isNotSameAs(value);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should be different.\n\tActual:<java.io.BufferedReader.*>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("BufferedReaderAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should be different.\n\tActual:<java.io.BufferedReader.*>");
        }
    }

}
