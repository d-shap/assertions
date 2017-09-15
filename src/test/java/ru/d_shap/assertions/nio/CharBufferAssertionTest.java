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

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link CharBufferAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class CharBufferAssertionTest {

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
    public void containsTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).contains('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).contains('2');

        try {
            new CharBufferAssertion(null, null).contains('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).contains('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).contains('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).contains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").contains('3');
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
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContains('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContains('2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContains('2');

        try {
            new CharBufferAssertion(null, null).rewindAndContains('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContains('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContains('3');
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
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).doesNotContain('3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).doesNotContain('2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).doesNotContain('5');

        try {
            new CharBufferAssertion(null, null).doesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).doesNotContain('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).doesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").doesNotContain('1');
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
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndDoesNotContain('3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndDoesNotContain('5');

        try {
            new CharBufferAssertion(null, null).rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndDoesNotContain('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndDoesNotContain('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAll('1', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAll('4', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAll(52, 50);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAll(Arrays.asList('4', '2'));

        try {
            new CharBufferAssertion(null, null).containsAll('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsAll(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsAll('1', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsAll(49, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsAll(Arrays.asList('1', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsAll('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsAll(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsAll(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAll('1', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAll('4', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAll(52, 50);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAll(Arrays.asList('4', '2'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsAll('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsAll(49, 50);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsAll(Arrays.asList('1', '2'));

        try {
            new CharBufferAssertion(null, null).rewindAndContainsAll('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsAll(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsAll('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsAll(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsAll(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAllInOrder('1', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAllInOrder(49, 51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAllInOrder(Arrays.asList('1', '3', '4'));

        try {
            new CharBufferAssertion(null, null).containsAllInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsAllInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsAllInOrder('1', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsAllInOrder(49, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsAllInOrder(Arrays.asList('1', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsAllInOrder('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsAllInOrder(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsAllInOrder(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAllInOrder('1', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAllInOrder(49, 51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAllInOrder(Arrays.asList('1', '3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsAllInOrder('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsAllInOrder(49, 50);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsAllInOrder(Arrays.asList('1', '2'));

        try {
            new CharBufferAssertion(null, null).rewindAndContainsAllInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsAllInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsAllInOrder('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsAllInOrder(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsAllInOrder(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactly('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactly('1', '2', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactly('1', '3', '2', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactly(49, 51, 50, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactly(Arrays.asList('1', '3', '2', '4'));
        new CharBufferAssertion(createCharBuffer(new char[0]), null).containsExactly();
        new CharBufferAssertion(createCharBuffer(new char[0]), null).containsExactly(new int[0]);
        new CharBufferAssertion(createCharBuffer(new char[0]), null).containsExactly(new ArrayList<Character>());

        try {
            new CharBufferAssertion(null, null).containsExactly('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsExactly(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactly('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactly();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactly(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactly('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactly('1', '2', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactly('1', '3', '2', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactly(49, 51, 50, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactly(Arrays.asList('1', '3', '2', '4'));
        new CharBufferAssertion(createCharBuffer(new char[0]), null).rewindAndContainsExactly();
        new CharBufferAssertion(createCharBuffer(new char[0]), null).rewindAndContainsExactly(new int[0]);
        new CharBufferAssertion(createCharBuffer(new char[0]), null).rewindAndContainsExactly(new ArrayList<Character>());
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsExactly('1', '2', '3', '4', '5');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsExactly(49, 50, 51, 52, 53);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsExactly(Arrays.asList('1', '2', '3', '4', '5'));

        try {
            new CharBufferAssertion(null, null).rewindAndContainsExactly('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsExactly(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactly('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactly();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactly(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactlyInOrder('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactlyInOrder('1', '2', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactlyInOrder(49, 50, 51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[0]), null).containsExactlyInOrder();
        new CharBufferAssertion(createCharBuffer(new char[0]), null).containsExactlyInOrder(new int[0]);
        new CharBufferAssertion(createCharBuffer(new char[0]), null).containsExactlyInOrder(new ArrayList<Character>());

        try {
            new CharBufferAssertion(null, null).containsExactlyInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsExactlyInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactlyInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactlyInOrder('1', '2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactlyInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactlyInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactlyInOrder('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactlyInOrder('1', '2', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactlyInOrder(49, 50, 51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[0]), null).rewindAndContainsExactlyInOrder();
        new CharBufferAssertion(createCharBuffer(new char[0]), null).rewindAndContainsExactlyInOrder(new int[0]);
        new CharBufferAssertion(createCharBuffer(new char[0]), null).rewindAndContainsExactlyInOrder(new ArrayList<Character>());
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));

        try {
            new CharBufferAssertion(null, null).rewindAndContainsExactlyInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsExactlyInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactlyInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactlyInOrder('1', '2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactlyInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactlyInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), "Message").rewindAndContainsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny('2', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAny('2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAny('4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAny('5', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAny(53, 51);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).containsAny(Arrays.asList('5', '3'));

        try {
            new CharBufferAssertion(null, null).containsAny('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsAny(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsAny('1', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsAny(49, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsAny(Arrays.asList('1', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsAny('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsAny(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsAny(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny('2', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAny('2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAny('4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAny('5', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAny(53, 51);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), null).rewindAndContainsAny(Arrays.asList('5', '3'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsAny('1', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsAny(49, 51);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsAny(Arrays.asList('1', '3'));

        try {
            new CharBufferAssertion(null, null).rewindAndContainsAny('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsAny(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsAny('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsAny(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsAny(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone('3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone('3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone(51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone(Arrays.asList('3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsNone('1', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsNone(49, 51);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).containsNone(Arrays.asList('1', '3'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsNone('4', '5');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsNone(52, 53);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).containsNone(Arrays.asList('4', '5'));

        try {
            new CharBufferAssertion(null, null).containsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsNone(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).containsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone('3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone('3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone(51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone(Arrays.asList('3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsNone('4', '5');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsNone(52, 53);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), null).rewindAndContainsNone(Arrays.asList('4', '5'));

        try {
            new CharBufferAssertion(null, null).rewindAndContainsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsNone(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, null).rewindAndContainsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsNone('1', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsNone(49, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), null).rewindAndContainsNone(Arrays.asList('1', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).rewindAndContainsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").rewindAndContainsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void createCollectionAssertionTest() {
        new CharBufferAssertion(createCharBuffer(new char[0]), null).createCollectionAssertion(false).isEmpty();
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).createCollectionAssertion(false).isNotEmpty();

        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), null).createCollectionAssertion(false).isEmpty();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<[1, 2]>");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), "Message").createCollectionAssertion(false).isEmpty();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<[1, 2]>");
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

    private static CharBuffer createCharBuffer(final char[] values) {
        return createCharBuffer(values, 0);
    }

    private static CharBuffer createCharBuffer(final char[] values, final int position) {
        return createCharBuffer(values, position, values.length);
    }

    private static CharBuffer createCharBuffer(final char[] values, final int position, final int limit) {
        return createCharBuffer(values, position, limit, values.length);
    }

    private static CharBuffer createCharBuffer(final char[] values, final int position, final int limit, final int capacity) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(capacity * 2);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        for (char value : values) {
            charBuffer.put(value);
        }
        charBuffer.position(position);
        charBuffer.limit(limit);
        return charBuffer;
    }

}
