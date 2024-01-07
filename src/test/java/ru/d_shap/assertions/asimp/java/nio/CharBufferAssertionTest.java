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
package ru.d_shap.assertions.asimp.java.nio;

import java.nio.CharBuffer;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

/**
 * Tests for {@link CharBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharBufferAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public CharBufferAssertionTest() {
        super();
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}));

        try {
            initializeWithRawActual(Raw.charBufferAssertion(), new Object());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.CharBuffer> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.charBufferAssertion(), new Object(), "Message");
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.nio.CharBuffer> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).isEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2)).isEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2, 2, 4)).isEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2, 2, 4)).isNotNull().isEmpty().isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().isEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).isEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").isEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}, 0, 4, 4)).isEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[ (0),  (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).isEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").isEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isRewindAndEmptyTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).isRewindAndEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 0, 0)).isRewindAndEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 0, 0, 4)).isRewindAndEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 0, 0, 4)).isNotNull().isRewindAndEmpty().isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().isRewindAndEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).isRewindAndEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").isRewindAndEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}, 0, 4, 4)).isRewindAndEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[ (0),  (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isRewindAndEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).isRewindAndEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").isRewindAndEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).isNullOrEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2)).isNullOrEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2, 2, 4)).isNullOrEmpty();
        initialize(Raw.charBufferAssertion(), null).isNullOrEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).isNotNull().isNullOrEmpty().isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().isNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}, 0, 4, 4)).isNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[ (0),  (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).isNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").isNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNullOrEmptyTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).isRewindAndNullOrEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 0, 0)).isRewindAndNullOrEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 0, 0, 4)).isRewindAndNullOrEmpty();
        initialize(Raw.charBufferAssertion(), null).isRewindAndNullOrEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).isNotNull().isRewindAndNullOrEmpty().isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().isRewindAndNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}, 0, 4, 4)).isRewindAndNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[ (0),  (0),  (0),  (0)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isRewindAndNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).isRewindAndNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1), "Message").isRewindAndNullOrEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).isNotEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}, 0, 4, 4)).isNotEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().isNotEmpty().isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().isNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).isNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").isNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).isNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2)).isNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2, 2, 4)).isNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2, 2, 4), "Message").isNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isRewindAndNotEmptyTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isRewindAndNotEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 1)).isRewindAndNotEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}, 0, 4, 4)).isRewindAndNotEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2)).isRewindAndNotEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}, 2, 2, 4)).isRewindAndNotEmpty();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().isRewindAndNotEmpty().isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().isRewindAndNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).isRewindAndNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").isRewindAndNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).isRewindAndNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").isRewindAndNotEmpty();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).contains('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).contains('2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().contains('2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().contains('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).contains('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").contains('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).contains('2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<2(50)> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).contains('4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4(52)> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).contains('3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").contains('3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContains('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContains('2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContains('2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContains('2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContains('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContains('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContains('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContains('4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<4(52)> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContains('3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContains('3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).doesNotContain('3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).doesNotContain('2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).doesNotContain('5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().doesNotContain('3').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().doesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).doesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").doesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).doesNotContain('2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2(50)> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).doesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1(49)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").doesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1(49)> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndDoesNotContain('3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndDoesNotContain('5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndDoesNotContain('3').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndDoesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndDoesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndDoesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndDoesNotContain('2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2(50)> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndDoesNotContain('2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<2(50)> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndDoesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain the expected value.\n\tExpected:<1(49)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndDoesNotContain('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain the expected value.\n\tExpected:<1(49)> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAll('1', '3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAll('4', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsAll('1', '2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsAll('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAll('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAll((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAll((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAll((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAll();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAll();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAll('1', '2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1(49), 2(50)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAll('4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll('2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAll('2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAll(49, 51);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAll(52, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsAll(49, 50).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsAll(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAll(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAll((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAll((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAll((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAll(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAll(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAll(49, 50);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1(49), 2(50)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAll(52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll(50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAll(50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAll(DataHelper.createIterable('1', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAll(DataHelper.createIterable('4', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsAll(DataHelper.createIterable('1', '2')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAll((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAll((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAll((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAll(DataHelper.createIterable('1', '2'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[1(49), 2(50)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAll(DataHelper.createIterable('4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAll(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAll('1', '3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAll('4', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAll('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsAll('1', '2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsAll('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAll('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAll((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAll((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAll((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAll();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAll();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAll('4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll('2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAll('2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAll(49, 51);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAll(52, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAll(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsAll(49, 50).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsAll(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAll(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAll((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAll((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAll(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAll(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAll(52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll(50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAll(50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAll(DataHelper.createIterable('1', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAll(DataHelper.createIterable('4', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAll(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsAll(DataHelper.createIterable('1', '2')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAll((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAll((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAll((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAll(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAll(DataHelper.createIterable('4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAll(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAllInOrder('1', '3', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsAllInOrder('1', '2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsAllInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAllInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAllInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAllInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAllInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAllInOrder();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAllInOrder();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder('2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAllInOrder('1', '2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAllInOrder('4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAllInOrder('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAllInOrder(49, 51, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsAllInOrder(49, 50).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsAllInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAllInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAllInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAllInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAllInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAllInOrder(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAllInOrder(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAllInOrder(49, 50);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAllInOrder(52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAllInOrder(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAllInOrder(DataHelper.createIterable('1', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsAllInOrder(DataHelper.createIterable('1', '2')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAllInOrder(DataHelper.createIterable('1', '2'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[1(49), 2(50)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAllInOrder(DataHelper.createIterable('4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAllInOrder(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAllInOrder('1', '3', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAllInOrder('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsAllInOrder('1', '2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsAllInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAllInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAllInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAllInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAllInOrder();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAllInOrder();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder('2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAllInOrder('4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAllInOrder('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAllInOrder(49, 51, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAllInOrder(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsAllInOrder(49, 50).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsAllInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAllInOrder(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAllInOrder(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAllInOrder(52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAllInOrder(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAllInOrder(DataHelper.createIterable('1', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsAllInOrder(DataHelper.createIterable('1', '2')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAllInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAllInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAllInOrder(DataHelper.createIterable('4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAllInOrder(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly('1', '2', '3', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly('1', '3', '2', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactly();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsExactly('1', '2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsExactly('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactly('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactly((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactly((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsExactly((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly('2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly('1', '1', '3', '2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactly('1', '1', '3', '2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(49, 50, 51, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(49, 51, 50, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactly(new int[]{});
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsExactly(49, 50).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsExactly(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactly(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactly((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactly((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsExactly((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(49, 49, 51, 50);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactly(49, 49, 51, 50);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(DataHelper.createIterable('1', '2', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(DataHelper.createIterable('1', '3', '2', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactly(DataHelper.<Character>createIterable());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsExactly(DataHelper.createIterable('1', '2')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactly((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactly((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsExactly((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactly(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactly(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(DataHelper.createIterable('1', '1', '3', '2'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactly(DataHelper.createIterable('1', '1', '3', '2'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly('1', '2', '3', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly('1', '3', '2', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactly();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactly('1', '2', '3', '4', '5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsExactly('1', '2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsExactly('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactly('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactly((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactly((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsExactly((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly('2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactly('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly('1', '1', '3', '2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactly('1', '1', '3', '2');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(49, 50, 51, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(49, 51, 50, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactly(new int[]{});
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactly(49, 50, 51, 52, 53);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsExactly(49, 50).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsExactly(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactly(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactly((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsExactly((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactly(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(49, 49, 51, 50);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactly(49, 49, 51, 50);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(DataHelper.createIterable('1', '2', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(DataHelper.createIterable('1', '3', '2', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactly(DataHelper.<Character>createIterable());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactly(DataHelper.createIterable('1', '2', '3', '4', '5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsExactly(DataHelper.createIterable('1', '2')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactly((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactly((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsExactly((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(DataHelper.createIterable('2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactly(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(DataHelper.createIterable('1', '1', '3', '2'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactly(DataHelper.createIterable('1', '1', '3', '2'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[1(49), 1(49), 3(51), 2(50)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder('1', '2', '3', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactlyInOrder();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsExactlyInOrder('1', '2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsExactlyInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactlyInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactlyInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactlyInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsExactlyInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder('1', '2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(49, 50, 51, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactlyInOrder(new int[]{});
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsExactlyInOrder(49, 50).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsExactlyInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactlyInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactlyInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsExactlyInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(49, 50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactlyInOrder(DataHelper.<Character>createIterable());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsExactlyInOrder(DataHelper.createIterable('1', '2')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(DataHelper.createIterable('1', '2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(DataHelper.createIterable('2', '3', '1', '4'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactlyInOrder(DataHelper.createIterable('2', '3', '1', '4'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder('1', '2', '3', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactlyInOrder();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsExactlyInOrder('1', '2').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsExactlyInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactlyInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsExactlyInOrder((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder('1', '2', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(49, 50, 51, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactlyInOrder(new int[]{});
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsExactlyInOrder(49, 50).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsExactlyInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(49, 50, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(DataHelper.createIterable('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactlyInOrder(DataHelper.<Character>createIterable());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4', '5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsExactlyInOrder(DataHelper.createIterable('1', '2')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(DataHelper.createIterable('1', '2', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactlyInOrder(DataHelper.createIterable('1', '2', '3', '4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[1(49), 2(50), 3(51), 4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(DataHelper.createIterable('2', '3', '1', '4'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactlyInOrder(DataHelper.createIterable('2', '3', '1', '4'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51), 1(49), 4(52)]> but was:<[1(49), 2(50), 3(51), 4(52)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny('2', '3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny('2', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny('4', '1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny('5', '3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsAny('2', '3').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsAny('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAny('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAny((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAny((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAny((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAny();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAny();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAny('1', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1(49), 3(51)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAny('4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny('3', '4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAny('3', '4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAnyArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny(50, 51);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny(50, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny(52, 49);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny(53, 51);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsAny(50, 51).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsAny(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAny(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAny((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAny((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAny((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAny(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAny(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAny(49, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1(49), 3(51)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAny(52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny(51, 52);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAny(51, 52);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny(DataHelper.createIterable('2', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny(DataHelper.createIterable('2', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny(DataHelper.createIterable('4', '1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny(DataHelper.createIterable('5', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsAny(DataHelper.createIterable('2', '3')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsAny((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAny((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAny((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAny(DataHelper.createIterable('1', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[1(49), 3(51)]> but was:<[4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAny(DataHelper.createIterable('4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny(DataHelper.createIterable('3', '4'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAny(DataHelper.createIterable('3', '4'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny('2', '3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny('2', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny('4', '1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny('5', '3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAny('1', '3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsAny('2', '3').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsAny('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAny('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAny((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAny((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAny((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAny();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAny();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAny('4', '5');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny('3', '4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAny('3', '4');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny(50, 51);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny(50, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny(52, 49);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny(53, 51);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAny(49, 51);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsAny(50, 51).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsAny(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAny(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAny((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAny((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAny(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAny(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAny(52, 53);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny(51, 52);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAny(51, 52);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny(DataHelper.createIterable('2', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny(DataHelper.createIterable('2', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny(DataHelper.createIterable('4', '1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny(DataHelper.createIterable('5', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAny(DataHelper.createIterable('1', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsAny(DataHelper.createIterable('2', '3')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsAny((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAny((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAny((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsAny(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAny(DataHelper.createIterable('4', '5'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[4(52), 5(53)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny(DataHelper.createIterable('3', '4'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAny(DataHelper.createIterable('3', '4'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<[3(51), 4(52)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone('3', '7');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone('3', '4', '5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsNone('1', '3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsNone('4', '5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsNone('3', '7').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsNone('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsNone('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsNone((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsNone((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsNone((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsNone();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsNone();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsNone('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsNoneArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(51, 55);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(51, 52, 53);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsNone(49, 51);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsNone(52, 53);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsNone(51, 55).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsNone(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsNone(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsNone((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsNone((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsNone((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsNone(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsNone(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsNone(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(DataHelper.createIterable('3', '7'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(DataHelper.createIterable('3', '4', '5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsNone(DataHelper.createIterable('1', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsNone(DataHelper.createIterable('4', '5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().containsNone(DataHelper.createIterable('3', '7')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").containsNone((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsNone((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsNone((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").containsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsNone(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone('3', '7');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone('3', '4', '5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsNone('4', '5');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsNone('3', '7').isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsNone('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsNone('1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsNone((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsNone((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsNone((char[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsNone();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsNone();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsNone('1', '3');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsNone('2', '1');
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(51, 55);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(51, 52, 53);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsNone(52, 53);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsNone(51, 55).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsNone(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsNone(49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsNone((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsNone((int[]) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsNone(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsNone(new int[]{});
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsNone(49, 51);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsNone(50, 49);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(DataHelper.createIterable('3', '7'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(DataHelper.createIterable('3', '4', '5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsNone(DataHelper.createIterable('4', '5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNotNull().rewindAndContainsNone(DataHelper.createIterable('3', '7')).isInstanceOf(CharBuffer.class);

        try {
            Raw.charBufferAssertion().rewindAndContainsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null, "Message").rewindAndContainsNone((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsNone((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsNone((Iterable<Character>) null);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{})).rewindAndContainsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{}), "Message").rewindAndContainsNone(DataHelper.<Character>createIterable());
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsNone(DataHelper.createIterable('1', '3'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[1(49), 3(51)]> but was:<[1(49), 2(50), 3(51), 4(52), 5(53)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsNone(DataHelper.createIterable('2', '1'));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.charBufferAssertion(), null).isNull();

        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).isNull();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").isNull();
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        CharBuffer value = createCharBuffer(new char[]{'1', '2'});
        initialize(Raw.charBufferAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.charBufferAssertion(), value).isSameAs(createCharBuffer(new char[]{'1', '2'}));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), value, "Message").isSameAs(createCharBuffer(new char[]{'1', '2'}));
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<[1(49), 2(50)]> but was:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        CharBuffer value = createCharBuffer(new char[]{'1', '2'});
        initialize(Raw.charBufferAssertion(), value).isNotSameAs(createCharBuffer(new char[]{'1', '2'}));

        try {
            initialize(Raw.charBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail(CharBufferAssertion.class);
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<[1(49), 2(50)]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void positionTest() {
        CharBuffer buffer = createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3);
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).contains('4');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContains('2');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).doesNotContain('2');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndDoesNotContain('0');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAll('4', '5');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAll('2', '5');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAllInOrder('4', '5');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAllInOrder('2', '5');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactly('4', '5');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactly('1', '2', '3', '4', '5');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsExactlyInOrder('4', '5');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsAny('1', '5', '7');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsAny('1', '7', '9');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).containsNone('1', '9');
        Assertions.assertThat(buffer).hasPosition(3);
        Assertions.assertThat(buffer).rewindAndContainsNone('7', '9');
        Assertions.assertThat(buffer).hasPosition(3);
    }

}
