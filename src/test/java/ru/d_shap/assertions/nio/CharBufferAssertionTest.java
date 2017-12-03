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
package ru.d_shap.assertions.nio;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

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
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0]));

        try {
            initialize(Raw.charBufferAssertion(), new Object());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initialize(Raw.charBufferAssertion(), new Object(), "Message");
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).contains('1');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).contains('2');

        try {
            Raw.charBufferAssertion().contains('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).contains('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).contains('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).contains('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).contains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").contains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().rewindAndContains('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContains('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContains('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().doesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).doesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).doesNotContain('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).doesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").doesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndDoesNotContain('3');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndDoesNotContain('5');

        try {
            Raw.charBufferAssertion().rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndDoesNotContain('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndDoesNotContain('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().containsAll('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAll('1', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAll('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().containsAll(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAll(49, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAll(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll(Arrays.asList('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAll(Arrays.asList('1', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAll(Arrays.asList('4', '2'));

        try {
            Raw.charBufferAssertion().containsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAll(Arrays.asList('1', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAll(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().rewindAndContainsAll('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAll('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().rewindAndContainsAll(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAll(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll(Arrays.asList('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAll(Arrays.asList('1', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAll(Arrays.asList('4', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAll(Arrays.asList('1', '2'));

        try {
            Raw.charBufferAssertion().rewindAndContainsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAll(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAllInOrder('1', '3', '4');

        try {
            Raw.charBufferAssertion().containsAllInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAllInOrder('1', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAllInOrder('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAllInOrder(49, 51, 52);

        try {
            Raw.charBufferAssertion().containsAllInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAllInOrder(49, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAllInOrder(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(Arrays.asList('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAllInOrder(Arrays.asList('1', '3', '4'));

        try {
            Raw.charBufferAssertion().containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAllInOrder(Arrays.asList('1', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAllInOrder(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().rewindAndContainsAllInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAllInOrder('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().rewindAndContainsAllInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAllInOrder(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(Arrays.asList('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAllInOrder(Arrays.asList('1', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAllInOrder(Arrays.asList('1', '2'));

        try {
            Raw.charBufferAssertion().rewindAndContainsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAllInOrder(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
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
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).containsExactly();

        try {
            Raw.charBufferAssertion().containsExactly('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
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
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).containsExactly(new int[0]);

        try {
            Raw.charBufferAssertion().containsExactly(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(Arrays.asList('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(Arrays.asList('1', '2', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(Arrays.asList('1', '3', '2', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).containsExactly(new ArrayList<Character>());

        try {
            Raw.charBufferAssertion().containsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
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
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).rewindAndContainsExactly();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactly('1', '2', '3', '4', '5');

        try {
            Raw.charBufferAssertion().rewindAndContainsExactly('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
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
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).rewindAndContainsExactly(new int[0]);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactly(49, 50, 51, 52, 53);

        try {
            Raw.charBufferAssertion().rewindAndContainsExactly(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(Arrays.asList('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(Arrays.asList('1', '2', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(Arrays.asList('1', '3', '2', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).rewindAndContainsExactly(new ArrayList<Character>());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactly(Arrays.asList('1', '2', '3', '4', '5'));

        try {
            Raw.charBufferAssertion().rewindAndContainsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder('1', '2', '3', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).containsExactlyInOrder();

        try {
            Raw.charBufferAssertion().containsExactlyInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder('1', '2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(49, 50, 51, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).containsExactlyInOrder(new int[0]);

        try {
            Raw.charBufferAssertion().containsExactlyInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(49, 50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(Arrays.asList('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).containsExactlyInOrder(new ArrayList<Character>());

        try {
            Raw.charBufferAssertion().containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(Arrays.asList('1', '2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayCharTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder('1', '2');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder('1', '2', '3', '4');
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).rewindAndContainsExactlyInOrder();
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');

        try {
            Raw.charBufferAssertion().rewindAndContainsExactlyInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder('1', '2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderArrayIntTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(49, 50);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(49, 50, 51, 52);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).rewindAndContainsExactlyInOrder(new int[0]);
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);

        try {
            Raw.charBufferAssertion().rewindAndContainsExactlyInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(49, 50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[0])).rewindAndContainsExactlyInOrder(new ArrayList<Character>());
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));

        try {
            Raw.charBufferAssertion().rewindAndContainsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
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

        try {
            Raw.charBufferAssertion().containsAny('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAny('1', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAny('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().containsAny(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAny(49, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAny(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAnyIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny(Arrays.asList('2', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny(Arrays.asList('2', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny(Arrays.asList('4', '1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).containsAny(Arrays.asList('5', '3'));

        try {
            Raw.charBufferAssertion().containsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsAny(Arrays.asList('1', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsAny(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().rewindAndContainsAny('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAny('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().rewindAndContainsAny(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAny(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny(Arrays.asList('2', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny(Arrays.asList('2', '4'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny(Arrays.asList('4', '1'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4'})).rewindAndContainsAny(Arrays.asList('5', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsAny(Arrays.asList('1', '3'));

        try {
            Raw.charBufferAssertion().rewindAndContainsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsAny(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().containsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().containsNone(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsNoneIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(Arrays.asList('3', '7'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(Arrays.asList('3', '4', '5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).containsNone(Arrays.asList('1', '3'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).containsNone(Arrays.asList('4', '5'));

        try {
            Raw.charBufferAssertion().containsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).containsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().rewindAndContainsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsNone('1', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
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

        try {
            Raw.charBufferAssertion().rewindAndContainsNone(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsNone(49, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneIterableTest() {
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(Arrays.asList('3', '7'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(Arrays.asList('3', '4', '5'));
        initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3)).rewindAndContainsNone(Arrays.asList('4', '5'));

        try {
            Raw.charBufferAssertion().rewindAndContainsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), null).rewindAndContainsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3)).rewindAndContainsNone(Arrays.asList('1', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'})).rewindAndContainsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
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
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), createCharBuffer(new char[]{'1', '2'}), "Message").isNull();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>");
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
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), value, "Message").isSameAs(createCharBuffer(new char[]{'1', '2'}));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), value).isSameAs("test");
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        CharBuffer value = createCharBuffer(new char[]{'1', '2'});
        initialize(Raw.charBufferAssertion(), value).isNotSameAs(createCharBuffer(new char[]{'1', '2'}));
        initialize(Raw.charBufferAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.charBufferAssertion(), value).isNotSameAs(value);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>");
        }
        try {
            initialize(Raw.charBufferAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).asString(null));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).asString(createCharBuffer(new char[]{'1', '2', '3'}))).isEqualTo("[1, 2, 3]");
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).asString(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}))).isEqualTo("[1, 2, 3, 4, 5]");
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).asString(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 2))).isEqualTo("[3, 4, 5]");
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
        Assertions.assertThat(buffer).rewindAndDoesNotContain(0);
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

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void listCapacityTest() {
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).createList(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}), false), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).createList(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(2);
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).createList(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(3);
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).createList(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 1, 3), false), "elementData", Raw.objectArrayAssertion()).hasLength(2);

        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).createList(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}), true), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).createList(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(5);
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).createList(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(3);
        Assertions.assertThat(initialize(Raw.charBufferAssertion(), null).createList(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 1, 3), true), "elementData", Raw.objectArrayAssertion()).hasLength(3);
    }

}
