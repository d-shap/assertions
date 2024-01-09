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

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.io.BufferedReader> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.bufferedReaderAssertion(), new Object(), "Message");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.io.BufferedReader> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void isCompletedTest() throws Exception {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isCompleted();
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNotNull().isCompleted().isInstanceOf(Reader.class);
        BufferedReader reader = new BufferedReader(new StringReader("123"));
        Assertions.assertThat(reader.read()).isEqualTo(49);
        Assertions.assertThat(reader.read()).isEqualTo(50);
        Assertions.assertThat(reader.read()).isEqualTo(51);
        initialize(Raw.bufferedReaderAssertion(), reader).isCompleted();

        try {
            Raw.bufferedReaderAssertion().isCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).isCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").isCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000"))).isCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be completed.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000")), "Message").isCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be completed.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be completed.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").isCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be completed.");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNotCompletedTest() {
        BufferedReader reader = new BufferedReader(new StringReader("123\u00004"));
        initialize(Raw.bufferedReaderAssertion(), reader).isNotCompleted();
        initialize(Raw.bufferedReaderAssertion(), reader).isNotCompleted();
        initialize(Raw.bufferedReaderAssertion(), reader).isNotCompleted();
        initialize(Raw.bufferedReaderAssertion(), reader).isNotCompleted();
        initialize(Raw.bufferedReaderAssertion(), reader).isNotCompleted();
        initialize(Raw.bufferedReaderAssertion(), reader).isCompleted();
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().isNotCompleted().isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().isNotCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNotCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNotCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).isNotCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").isNotCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).isNotCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be completed.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").isNotCompleted();
            Assertions.fail(BufferedReaderAssertion.class);
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
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().toCharArray().containsExactlyInOrder('1', '2', '3');

        try {
            Raw.bufferedReaderAssertion().toCharArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toCharArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toCharArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray()).containsExactlyInOrder('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray()).containsExactlyInOrder('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray().containsExactlyInOrder('1', '2');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray().containsExactlyInOrder('1', '2');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toCharArrayCountTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(4).containsExactlyInOrder('1', '2', '3');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(3).containsExactlyInOrder('1', '2', '3');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(2).containsExactlyInOrder('1', '2');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(1).containsExactlyInOrder('1');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().toCharArray(1).containsExactlyInOrder('1');

        try {
            Raw.bufferedReaderAssertion().toCharArray(1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(-1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(-1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toCharArray(3);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toCharArray(3);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(1)).containsExactlyInOrder('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray(1)).containsExactlyInOrder('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(4).containsExactlyInOrder('1', '2');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray(4).containsExactlyInOrder('1', '2');
            Assertions.fail(BufferedReaderAssertion.class);
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
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().toCharArray(Matchers.arrayContaining('1', '2', '3')).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toCharArray(Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(Matchers.arrayContaining('1', '2'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray(Matchers.arrayContaining('1', '2'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toCharArrayCountMatcherTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(4, Matchers.arrayContaining('1', '2', '3'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(3, Matchers.arrayContaining('1', '2', '3'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(2, Matchers.arrayContaining('1', '2'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(1, Matchers.arrayContaining('1'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().toCharArray(1, Matchers.arrayContaining('1')).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().toCharArray(1, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(1, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(1, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(0, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(-1, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(-1, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(0, null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(0, null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toCharArray(1, null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toCharArray(1, null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toCharArray(3, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toCharArray(3, Matchers.arrayContaining((char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toCharArray(4, Matchers.arrayContaining('1', '2'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toCharArray(4, Matchers.arrayContaining('1', '2'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 4.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toStringArrayTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray().containsExactlyInOrder("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray().containsExactlyInOrder("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).isNotNull().toStringArray().containsExactlyInOrder("1", "2", "3");

        try {
            Raw.bufferedReaderAssertion().toStringArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toStringArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toStringArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toStringArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toStringArray();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray()).containsExactlyInOrder("1");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").toStringArray()).containsExactlyInOrder("1");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's lines.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray().containsExactlyInOrder("1", "2");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").toStringArray().containsExactlyInOrder("1", "2");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toStringArrayCountTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray(4).containsExactlyInOrder("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray(3).containsExactlyInOrder("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray(2).containsExactlyInOrder("1", "2");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray(1).containsExactlyInOrder("1");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).isNotNull().toStringArray(1).containsExactlyInOrder("1");

        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(4).containsExactlyInOrder("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(3).containsExactlyInOrder("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(2).containsExactlyInOrder("1", "2");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(1).containsExactlyInOrder("1");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).isNotNull().toStringArray(1).containsExactlyInOrder("1");

        try {
            Raw.bufferedReaderAssertion().toStringArray(1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toStringArray(1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toStringArray(1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toStringArray(0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toStringArray(0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toStringArray(0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toStringArray(0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toStringArray(-1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toStringArray(-1);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toStringArray(3);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toStringArray(3);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(1)).containsExactlyInOrder("1");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").toStringArray(1)).containsExactlyInOrder("1");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's lines: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(4).containsExactlyInOrder("1", "2");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").toStringArray(4).containsExactlyInOrder("1", "2");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's lines: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toStringArrayMatcherTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray(Matchers.arrayContaining("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(Matchers.arrayContaining("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).isNotNull().toStringArray(Matchers.arrayContaining("1", "2", "3")).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().toStringArray(Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toStringArray(Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toStringArray(Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toStringArray(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toStringArray(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toStringArray(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toStringArray(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toStringArray(Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toStringArray(Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(Matchers.arrayContaining("1", "2"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").toStringArray(Matchers.arrayContaining("1", "2"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's lines.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void toStringArrayCountMatcherTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray(4, Matchers.arrayContaining("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray(3, Matchers.arrayContaining("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray(2, Matchers.arrayContaining("1", "2"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).toStringArray(1, Matchers.arrayContaining("1"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).isNotNull().toStringArray(1, Matchers.arrayContaining("1")).isInstanceOf(Reader.class);

        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(4, Matchers.arrayContaining("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(3, Matchers.arrayContaining("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(2, Matchers.arrayContaining("1", "2"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(1, Matchers.arrayContaining("1"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).isNotNull().toStringArray(1, Matchers.arrayContaining("1")).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().toStringArray(1, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toStringArray(1, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toStringArray(1, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toStringArray(0, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toStringArray(0, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toStringArray(0, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toStringArray(0, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toStringArray(-1, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toStringArray(-1, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toStringArray(0, null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toStringArray(0, null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toStringArray(1, null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toStringArray(1, null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toStringArray(3, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toStringArray(3, Matchers.arrayContaining(""));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toStringArray(4, Matchers.arrayContaining("1", "2"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 4.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").toStringArray(4, Matchers.arrayContaining("1", "2"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's lines: 4.\nExpected: [\"1\", \"2\"] \n     but: not matched: \"3\"");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNextCharEqualToTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharEqualTo('1');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("234"))).isNextCharEqualTo('2');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isNextCharEqualTo(0);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("234"))).isNotNull().isNextCharEqualTo('2').isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().isNextCharEqualTo('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNextCharEqualTo('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNextCharEqualTo('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNextCharEqualTo('2');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50)]> but was:<[1(49)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").isNextCharEqualTo('2');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50)]> but was:<[1(49)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areNextCharsEqualToArrayCharTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo('1', '2');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo('1', '2', '3');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).areNextCharsEqualTo((char) 0, (char) 0);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().areNextCharsEqualTo('1', '2', '3').isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areNextCharsEqualTo('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextCharsEqualTo('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextCharsEqualTo('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextCharsEqualTo((char[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextCharsEqualTo((char[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextCharsEqualTo((char[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextCharsEqualTo((char[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextCharsEqualTo();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextCharsEqualTo();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo('1', '3');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo('1', '2', '3', '4');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextCharsEqualTo('1', '2');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000"))).areNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000")), "Message").areNextCharsEqualTo((char) 0, (char) 0, (char) 0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areNextCharsEqualToArrayIntTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo(49, 50);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo(49, 50, 51);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).areNextCharsEqualTo(0, 0);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().areNextCharsEqualTo(49, 50, 51).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areNextCharsEqualTo(49);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextCharsEqualTo(49);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextCharsEqualTo(49);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextCharsEqualTo((int[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextCharsEqualTo((int[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextCharsEqualTo((int[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextCharsEqualTo((int[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextCharsEqualTo(new int[]{});
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextCharsEqualTo(new int[]{});
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo(49, 51);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo(49, 50, 51, 52);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextCharsEqualTo(49, 50);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000"))).areNextCharsEqualTo(0, 0, 0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000")), "Message").areNextCharsEqualTo(0, 0, 0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areNextCharsEqualToIterableTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo(DataHelper.createIterable('1', '2'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo(DataHelper.createIterable('1', '2', '3'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).areNextCharsEqualTo(DataHelper.createIterable((char) 0, (char) 0));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().areNextCharsEqualTo(DataHelper.createIterable('1', '2', '3')).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areNextCharsEqualTo(DataHelper.<Character>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextCharsEqualTo(DataHelper.<Character>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextCharsEqualTo(DataHelper.<Character>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextCharsEqualTo((Iterable<Character>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextCharsEqualTo(DataHelper.<Character>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextCharsEqualTo(DataHelper.<Character>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo(DataHelper.createIterable('1', '3'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areNextCharsEqualTo(DataHelper.createIterable('1', '2', '3', '4'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextCharsEqualTo(DataHelper.createIterable('1', '2'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000"))).areNextCharsEqualTo(DataHelper.createIterable((char) 0, (char) 0, (char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000")), "Message").areNextCharsEqualTo(DataHelper.createIterable((char) 0, (char) 0, (char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's chars: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0),  (0)]> but was:<[ (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areAllCharsEqualToArrayCharTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo('1', '2', '3');
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).areAllCharsEqualTo((char) 0, (char) 0, (char) 0);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllCharsEqualTo();
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().areAllCharsEqualTo('1', '2', '3').isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areAllCharsEqualTo('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllCharsEqualTo('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllCharsEqualTo('1');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllCharsEqualTo((char[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllCharsEqualTo((char[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllCharsEqualTo((char[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areAllCharsEqualTo((char[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo('1', '2');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo('1', '2', '4');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo('1', '2', '3', '4');
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).areAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000")), "Message").areAllCharsEqualTo((char) 0, (char) 0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areAllCharsEqualToArrayIntTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo(49, 50, 51);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).areAllCharsEqualTo(0, 0, 0);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllCharsEqualTo(new int[]{});
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().areAllCharsEqualTo(49, 50, 51).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areAllCharsEqualTo(49);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllCharsEqualTo(49);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllCharsEqualTo(49);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllCharsEqualTo((int[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllCharsEqualTo((int[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllCharsEqualTo((int[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areAllCharsEqualTo((int[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo(49, 50);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo(49, 50, 52);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo(49, 50, 51, 52);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).areAllCharsEqualTo(0, 0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000")), "Message").areAllCharsEqualTo(0, 0);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areAllCharsEqualToIterableTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo(DataHelper.createIterable('1', '2', '3'));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).areAllCharsEqualTo(DataHelper.createIterable((char) 0, (char) 0, (char) 0));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllCharsEqualTo(DataHelper.<Character>createIterable());
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).isNotNull().areAllCharsEqualTo(DataHelper.createIterable('1', '2', '3')).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areAllCharsEqualTo(DataHelper.<Character>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllCharsEqualTo(DataHelper.<Character>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllCharsEqualTo(DataHelper.<Character>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areAllCharsEqualTo((Iterable<Character>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo(DataHelper.createIterable('1', '2'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo(DataHelper.createIterable('1', '2', '4'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).areAllCharsEqualTo(DataHelper.createIterable('1', '2', '3', '4'));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).areAllCharsEqualTo(DataHelper.createIterable((char) 0, (char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000")), "Message").areAllCharsEqualTo(DataHelper.createIterable((char) 0, (char) 0));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's chars.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[ (0),  (0)]> but was:<[ (0),  (0),  (0)]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNextLineEqualToTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).isNextLineEqualTo("1");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("2\n3\n4"))).isNextLineEqualTo("2");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000"))).isNextLineEqualTo("\u0000");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("2\n3\n4"))).isNotNull().isNextLineEqualTo("2").isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().isNextLineEqualTo("");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).isNextLineEqualTo("");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").isNextLineEqualTo("");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).isNextLineEqualTo("2");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2]> but was:<[1]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").isNextLineEqualTo("2");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's lines: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2]> but was:<[1]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areNextLinesEqualToArrayTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo("1", "2");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).areNextLinesEqualTo("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000"))).areNextLinesEqualTo("\u0000", "\u0000");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).isNotNull().areNextLinesEqualTo("1", "2", "3").isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areNextLinesEqualTo("");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextLinesEqualTo("");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextLinesEqualTo("");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextLinesEqualTo((String[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextLinesEqualTo((String[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextLinesEqualTo((String[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextLinesEqualTo((String[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextLinesEqualTo();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextLinesEqualTo();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo("1", "3");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo("1", "2", "3", "4");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextLinesEqualTo("1", "2");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000"))).areNextLinesEqualTo("\u0000", "\u0000", "\u0000");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000")), "Message").areNextLinesEqualTo("\u0000", "\u0000", "\u0000");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's lines: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areNextLinesEqualToIterableTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo(DataHelper.createIterable("1", "2"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo(DataHelper.createIterable("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).areNextLinesEqualTo(DataHelper.createIterable("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000"))).areNextLinesEqualTo(DataHelper.createIterable("\u0000", "\u0000"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).isNotNull().areNextLinesEqualTo(DataHelper.createIterable("1", "2", "3")).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areNextLinesEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextLinesEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextLinesEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areNextLinesEqualTo((Iterable<String>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areNextLinesEqualTo((Iterable<String>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextLinesEqualTo((Iterable<String>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextLinesEqualTo((Iterable<String>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextLinesEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areNextLinesEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo(DataHelper.createIterable("1", "3"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areNextLinesEqualTo(DataHelper.createIterable("1", "2", "3", "4"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areNextLinesEqualTo(DataHelper.createIterable("1", "2"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000"))).areNextLinesEqualTo(DataHelper.createIterable("\u0000", "\u0000", "\u0000"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check next N actual value's lines: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000")), "Message").areNextLinesEqualTo(DataHelper.createIterable("\u0000", "\u0000", "\u0000"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck next N actual value's lines: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[\u0000, \u0000, \u0000]> but was:<[\u0000, \u0000]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areAllLinesEqualToArrayTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areAllLinesEqualTo("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).areAllLinesEqualTo("1", "2", "3");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000"))).areAllLinesEqualTo("\u0000", "\u0000", "\u0000");
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllLinesEqualTo();
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).isNotNull().areAllLinesEqualTo("1", "2", "3").isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areAllLinesEqualTo("");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllLinesEqualTo("");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllLinesEqualTo("");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllLinesEqualTo((String[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllLinesEqualTo((String[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllLinesEqualTo((String[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areAllLinesEqualTo((String[]) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areAllLinesEqualTo("1", "2");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areAllLinesEqualTo("1", "2", "4");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areAllLinesEqualTo("1", "2", "3", "4");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000"))).areAllLinesEqualTo("\u0000", "\u0000");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000")), "Message").areAllLinesEqualTo("\u0000", "\u0000");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void areAllLinesEqualToIterableTest() {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areAllLinesEqualTo(DataHelper.createIterable("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).areAllLinesEqualTo(DataHelper.createIterable("1", "2", "3"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000"))).areAllLinesEqualTo(DataHelper.createIterable("\u0000", "\u0000", "\u0000"));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllLinesEqualTo(DataHelper.<String>createIterable());
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3\n"))).isNotNull().areAllLinesEqualTo(DataHelper.createIterable("1", "2", "3")).isInstanceOf(Reader.class);

        try {
            Raw.bufferedReaderAssertion().areAllLinesEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllLinesEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllLinesEqualTo(DataHelper.<String>createIterable());
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).areAllLinesEqualTo((Iterable<String>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").areAllLinesEqualTo((Iterable<String>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).areAllLinesEqualTo((Iterable<String>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").areAllLinesEqualTo((Iterable<String>) null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areAllLinesEqualTo(DataHelper.createIterable("1", "2"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areAllLinesEqualTo(DataHelper.createIterable("1", "2", "4"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).areAllLinesEqualTo(DataHelper.createIterable("1", "2", "3", "4"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1, 2, 3, 4]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000"))).areAllLinesEqualTo(DataHelper.createIterable("\u0000", "\u0000"));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000")), "Message").areAllLinesEqualTo("\u0000", "\u0000");
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck all actual value's lines.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[\u0000, \u0000]> but was:<[\u0000, \u0000, \u0000]>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLengthTest() throws Exception {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("12"))).toLength().isEqualTo(2L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000\u0000\u0000"))).toLength().isEqualTo(5L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toLength().isEqualTo(0L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("12"))).isNotNull().toLength().isEqualTo(2L);

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
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toLength();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toLength();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toLength();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toLength();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toLength().isEqualTo(2L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toLength().isEqualTo(2L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLengthMatcherTest() throws Exception {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("12"))).toLength(Matchers.is(Matchers.equalTo(2L)));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000\u0000\u0000"))).toLength(Matchers.equalTo(5L));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toLength(Matchers.equalTo(0L));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("12"))).isNotNull().toLength(Matchers.is(Matchers.equalTo(2L))).isInstanceOf(Reader.class);

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
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toLength(Matchers.equalTo(0L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toLength(Matchers.equalTo(0L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toLength(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toLength(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toLength(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toLength(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toLength(Matchers.equalTo(0L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toLength(Matchers.equalTo(0L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).toLength(Matchers.equalTo(2L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\nExpected: <2L>\n     but: was <3L>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").toLength(Matchers.equalTo(2L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\nExpected: <2L>\n     but: was <3L>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasLengthTest() throws Exception {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("12"))).hasLength(2L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000\u0000\u0000"))).hasLength(5L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).hasLength(0L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("12"))).isNotNull().hasLength(2L).isInstanceOf(Reader.class);

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
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).hasLength(0L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").hasLength(0L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).hasLength(0L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").hasLength(0L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123"))).hasLength(2L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("123")), "Message").hasLength(2L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLinesLengthTest() throws Exception {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2"))).toLinesLength().isEqualTo(2L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n"))).toLinesLength().isEqualTo(2L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000\n\u0000\n\u0000"))).toLinesLength().isEqualTo(5L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toLinesLength().isEqualTo(0L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n"))).isNotNull().toLinesLength().isEqualTo(2L);

        BufferedReader reader1 = new BufferedReader(new StringReader("1\n2\n3"));
        initialize(Raw.bufferedReaderAssertion(), reader1).toLinesLength().isEqualTo(3L);
        Assertions.assertThat(reader1.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader1).toLinesLength().isEqualTo(0L);

        BufferedReader reader2 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader2.readLine()).isEqualTo("1");
        initialize(Raw.bufferedReaderAssertion(), reader2).toLinesLength().isEqualTo(2L);
        Assertions.assertThat(reader2.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader2).toLinesLength().isEqualTo(0L);

        BufferedReader reader3 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader3.readLine()).isEqualTo("1");
        Assertions.assertThat(reader3.readLine()).isEqualTo("2");
        initialize(Raw.bufferedReaderAssertion(), reader3).toLinesLength().isEqualTo(1L);
        Assertions.assertThat(reader3.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader3).toLinesLength().isEqualTo(0L);

        BufferedReader reader4 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader4.readLine()).isEqualTo("1");
        Assertions.assertThat(reader4.readLine()).isEqualTo("2");
        Assertions.assertThat(reader4.readLine()).isEqualTo("3");
        initialize(Raw.bufferedReaderAssertion(), reader4).toLinesLength().isEqualTo(0L);
        Assertions.assertThat(reader4.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader4).toLinesLength().isEqualTo(0L);

        BufferedReader reader5 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader5.readLine()).isEqualTo("1");
        Assertions.assertThat(reader5.readLine()).isEqualTo("2");
        Assertions.assertThat(reader5.readLine()).isEqualTo("3");
        Assertions.assertThat(reader5.readLine()).isNull();
        initialize(Raw.bufferedReaderAssertion(), reader5).toLinesLength().isEqualTo(0L);
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader5).toLinesLength().isEqualTo(0L);

        try {
            Raw.bufferedReaderAssertion().toLinesLength();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toLinesLength();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toLinesLength();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toLinesLength();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toLinesLength();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toLinesLength().isEqualTo(2L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's lines length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").toLinesLength().isEqualTo(2L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's lines length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void toLinesLengthMatcherTest() throws Exception {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2"))).toLinesLength(Matchers.is(Matchers.equalTo(2L)));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n"))).toLinesLength(Matchers.is(Matchers.equalTo(2L)));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000\n\u0000\n\u0000"))).toLinesLength(Matchers.equalTo(5L));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toLinesLength(Matchers.equalTo(0L));
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n"))).isNotNull().toLinesLength(Matchers.is(Matchers.equalTo(2L))).isInstanceOf(Reader.class);

        BufferedReader reader1 = new BufferedReader(new StringReader("1\n2\n3"));
        initialize(Raw.bufferedReaderAssertion(), reader1).toLinesLength(Matchers.equalTo(3L));
        Assertions.assertThat(reader1.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader1).toLinesLength(Matchers.equalTo(0L));

        BufferedReader reader2 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader2.readLine()).isEqualTo("1");
        initialize(Raw.bufferedReaderAssertion(), reader2).toLinesLength(Matchers.equalTo(2L));
        Assertions.assertThat(reader2.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader2).toLinesLength(Matchers.equalTo(0L));

        BufferedReader reader3 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader3.readLine()).isEqualTo("1");
        Assertions.assertThat(reader3.readLine()).isEqualTo("2");
        initialize(Raw.bufferedReaderAssertion(), reader3).toLinesLength(Matchers.equalTo(1L));
        Assertions.assertThat(reader3.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader3).toLinesLength(Matchers.equalTo(0L));

        BufferedReader reader4 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader4.readLine()).isEqualTo("1");
        Assertions.assertThat(reader4.readLine()).isEqualTo("2");
        Assertions.assertThat(reader4.readLine()).isEqualTo("3");
        initialize(Raw.bufferedReaderAssertion(), reader4).toLinesLength(Matchers.equalTo(0L));
        Assertions.assertThat(reader4.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader4).toLinesLength(Matchers.equalTo(0L));

        BufferedReader reader5 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader5.readLine()).isEqualTo("1");
        Assertions.assertThat(reader5.readLine()).isEqualTo("2");
        Assertions.assertThat(reader5.readLine()).isEqualTo("3");
        Assertions.assertThat(reader5.readLine()).isNull();
        initialize(Raw.bufferedReaderAssertion(), reader5).toLinesLength(Matchers.equalTo(0L));
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader5).toLinesLength(Matchers.equalTo(0L));

        try {
            Raw.bufferedReaderAssertion().toLinesLength(Matchers.equalTo(0L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toLinesLength(Matchers.equalTo(0L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toLinesLength(Matchers.equalTo(0L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).toLinesLength(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").toLinesLength(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).toLinesLength(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("")), "Message").toLinesLength(null);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).toLinesLength(Matchers.equalTo(0L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").toLinesLength(Matchers.equalTo(0L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).toLinesLength(Matchers.equalTo(2L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's lines length.\nExpected: <2L>\n     but: was <3L>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").toLinesLength(Matchers.equalTo(2L));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's lines length.\nExpected: <2L>\n     but: was <3L>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     *
     * @throws Exception exception in test.
     */
    @Test
    public void hasLinesLengthTest() throws Exception {
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2"))).hasLinesLength(2L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n"))).hasLinesLength(2L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\n\u0000\n\u0000\n\u0000\n\u0000"))).hasLinesLength(5L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader(""))).hasLinesLength(0L);
        initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n"))).isNotNull().hasLinesLength(2L).isInstanceOf(Reader.class);

        BufferedReader reader1 = new BufferedReader(new StringReader("1\n2\n3"));
        initialize(Raw.bufferedReaderAssertion(), reader1).hasLinesLength(3L);
        Assertions.assertThat(reader1.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader1).hasLinesLength(0L);

        BufferedReader reader2 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader2.readLine()).isEqualTo("1");
        initialize(Raw.bufferedReaderAssertion(), reader2).hasLinesLength(2L);
        Assertions.assertThat(reader2.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader2).hasLinesLength(0L);

        BufferedReader reader3 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader3.readLine()).isEqualTo("1");
        Assertions.assertThat(reader3.readLine()).isEqualTo("2");
        initialize(Raw.bufferedReaderAssertion(), reader3).hasLinesLength(1L);
        Assertions.assertThat(reader3.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader3).hasLinesLength(0L);

        BufferedReader reader4 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader4.readLine()).isEqualTo("1");
        Assertions.assertThat(reader4.readLine()).isEqualTo("2");
        Assertions.assertThat(reader4.readLine()).isEqualTo("3");
        initialize(Raw.bufferedReaderAssertion(), reader4).hasLinesLength(0L);
        Assertions.assertThat(reader4.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader4).hasLinesLength(0L);

        BufferedReader reader5 = new BufferedReader(new StringReader("1\n2\n3"));
        Assertions.assertThat(reader5.readLine()).isEqualTo("1");
        Assertions.assertThat(reader5.readLine()).isEqualTo("2");
        Assertions.assertThat(reader5.readLine()).isEqualTo("3");
        Assertions.assertThat(reader5.readLine()).isNull();
        initialize(Raw.bufferedReaderAssertion(), reader5).hasLinesLength(0L);
        Assertions.assertThat(reader5.read()).isLessThan(0);
        initialize(Raw.bufferedReaderAssertion(), reader5).hasLinesLength(0L);

        try {
            Raw.bufferedReaderAssertion().hasLinesLength(0L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null).hasLinesLength(0L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), null, "Message").hasLinesLength(0L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader()).hasLinesLength(0L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("java.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), DataHelper.createReaderBuilder().setReadException("read exception").buildBufferedReader(), "Message").hasLinesLength(0L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tjava.io.IOException: read exception.");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3"))).hasLinesLength(2L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's lines length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("1\n2\n3")), "Message").hasLinesLength(2L);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's lines length.\n\tActual and expected values should be the same.\n\tExpected:<2L> but was:<3L>");
        }
    }

    /**
     * {@link BufferedReaderAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.bufferedReaderAssertion(), null).isNull();

        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000"))).isNull();
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual value should be null.\n\tActual:<java.io.BufferedReader.*>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), new BufferedReader(new StringReader("\u0000\u0000\u0000")), "Message").isNull();
            Assertions.fail(BufferedReaderAssertion.class);
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
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should point to the same object.\n\tExpected:<java.io.BufferedReader.*> but was:<java.io.BufferedReader.*>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), value, "Message").isSameAs(new BufferedReader(new StringReader("\u0000\u0000\u0000")));
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<java.io.BufferedReader.*> but was:<java.io.BufferedReader.*>");
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
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Actual and expected values should point to the different objects.\n\tActual:<java.io.BufferedReader.*>");
        }
        try {
            initialize(Raw.bufferedReaderAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(BufferedReaderAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).messageMatches("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<java.io.BufferedReader.*>");
        }
    }

}
