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
import ru.d_shap.assertions.FailDescription;

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
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).contains('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).contains('2');

        try {
            new CharBufferAssertion(null, new FailDescription()).contains('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).contains('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<2> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).contains('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).contains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).contains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContains('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContains('2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContains('2');

        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContains('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContains('4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<4> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContains('3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<3> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void doesNotContainTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).doesNotContain('3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).doesNotContain('2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).doesNotContain('5');

        try {
            new CharBufferAssertion(null, new FailDescription()).doesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).doesNotContain('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).doesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).doesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndDoesNotContainTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndDoesNotContain('3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndDoesNotContain('5');

        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndDoesNotContain('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndDoesNotContain('2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<2> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndDoesNotContain('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<1> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAll('1', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAll('4', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAll(52, 50);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAll(Arrays.asList('4', '2'));

        try {
            new CharBufferAssertion(null, new FailDescription()).containsAll('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAll(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsAll('1', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsAll(49, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsAll(Arrays.asList('1', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsAll('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsAll(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsAll(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAll('1', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAll('4', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAll(52, 50);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAll(Arrays.asList('4', '2'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsAll('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsAll(49, 50);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList('1', '2'));

        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAll('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAll(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsAll('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsAll(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsAll(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsAll('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsAll(50, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsAll(Arrays.asList('2', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAllInOrder('1', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAllInOrder(49, 51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAllInOrder(Arrays.asList('1', '3', '4'));

        try {
            new CharBufferAssertion(null, new FailDescription()).containsAllInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAllInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsAllInOrder('1', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsAllInOrder(49, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsAllInOrder(Arrays.asList('1', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[1, 2]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsAllInOrder('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsAllInOrder(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsAllInOrder(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAllInOrderTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder('1');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAllInOrder('1', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAllInOrder(49, 51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList('1', '3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsAllInOrder('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsAllInOrder(49, 50);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList('1', '2'));

        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsAllInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsAllInOrder(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsAllInOrder(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactly('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactly('1', '2', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactly('1', '3', '2', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactly(49, 51, 50, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactly(Arrays.asList('1', '3', '2', '4'));
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).containsExactly();
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).containsExactly(new int[0]);
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).containsExactly(new ArrayList<Character>());

        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactly('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactly(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactly('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactly();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactly(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).containsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).containsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).containsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactly('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactly('1', '2', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactly('1', '3', '2', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactly(49, 51, 50, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactly(Arrays.asList('1', '3', '2', '4'));
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).rewindAndContainsExactly();
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).rewindAndContainsExactly(new int[0]);
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).rewindAndContainsExactly(new ArrayList<Character>());
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsExactly('1', '2', '3', '4', '5');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsExactly(49, 50, 51, 52, 53);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList('1', '2', '3', '4', '5'));

        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactly('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactly((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactly((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactly((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactly('2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[2, 3]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactly();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactly(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactly(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsExactly('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsExactly(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsExactly(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).rewindAndContainsExactly('1', '1', '3', '2');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).rewindAndContainsExactly(49, 49, 51, 50);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).rewindAndContainsExactly(Arrays.asList('1', '1', '3', '2'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[1, 1, 3, 2]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactlyInOrder('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactlyInOrder('1', '2', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactlyInOrder(49, 50, 51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).containsExactlyInOrder();
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).containsExactlyInOrder(new int[0]);
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).containsExactlyInOrder(new ArrayList<Character>());

        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactlyInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactlyInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactlyInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactlyInOrder('1', '2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactlyInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactlyInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).containsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).containsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).containsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsExactlyInOrderTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactlyInOrder('1', '2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactlyInOrder('1', '2', '3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactlyInOrder(49, 50, 51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).rewindAndContainsExactlyInOrder();
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new int[0]);
        new CharBufferAssertion(createCharBuffer(new char[0]), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Character>());
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));

        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactlyInOrder((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactlyInOrder((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactlyInOrder((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactlyInOrder('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactlyInOrder('1', '2', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactlyInOrder();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactlyInOrder(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsExactlyInOrder(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder('1', '2', '3', '4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(49, 50, 51, 52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList('1', '2', '3', '4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[1, 2, 3, 4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).rewindAndContainsExactlyInOrder('2', '3', '1', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(50, 51, 49, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription("Message")).rewindAndContainsExactlyInOrder(Arrays.asList('2', '3', '1', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly in the specified order. Expected:<[2, 3, 1, 4]> but was:<[1, 2, 3, 4]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny('2', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAny('2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAny('4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAny('5', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAny(53, 51);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).containsAny(Arrays.asList('5', '3'));

        try {
            new CharBufferAssertion(null, new FailDescription()).containsAny('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAny(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsAny('1', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsAny(49, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsAny(Arrays.asList('1', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[1, 3]> but was:<[4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsAny('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsAny(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsAny(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsAnyTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny('2', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAny('2');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAny('4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAny('5', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAny(53, 51);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4'}), new FailDescription()).rewindAndContainsAny(Arrays.asList('5', '3'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsAny('1', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsAny(49, 51);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList('1', '3'));

        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAny('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAny(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsAny('4', '5');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsAny(52, 53);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsAny(Arrays.asList('4', '5'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[4, 5]> but was:<[1, 2, 3]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsAny('3', '4');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsAny(51, 52);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsAny(Arrays.asList('3', '4'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[3, 4]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone('3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone('3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone(51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone(Arrays.asList('3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsNone('1', '3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsNone(49, 51);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).containsNone(Arrays.asList('1', '3'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsNone('4', '5');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsNone(52, 53);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).containsNone(Arrays.asList('4', '5'));

        try {
            new CharBufferAssertion(null, new FailDescription()).containsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsNone(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).containsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).containsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void rewindAndContainsNoneTest() {
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone('3');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone('3', '4');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone(51, 52);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone(Arrays.asList('3', '4'));
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsNone('4', '5');
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsNone(52, 53);
        new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 0, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList('4', '5'));

        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsNone(49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(null, new FailDescription()).rewindAndContainsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone((char[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone((int[]) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone((Iterable<Character>) null);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone(new int[0]);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone(new ArrayList<Character>());
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone('1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsNone('1', '3');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsNone(49, 51);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 3), new FailDescription()).rewindAndContainsNone(Arrays.asList('1', '3'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[1, 3]> but was:<[1, 2, 3, 4, 5]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsNone('2', '1');
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsNone(50, 49);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).rewindAndContainsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).rewindAndContainsNone(Arrays.asList('2', '1'));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[2, 1]> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new CharBufferAssertion(null, new FailDescription()).isNull();

        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription()).isNull();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(createCharBuffer(new char[]{'1', '2'}), new FailDescription("Message")).isNull();
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        CharBuffer value = createCharBuffer(new char[]{'1', '2'});
        new CharBufferAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new CharBufferAssertion(value, new FailDescription()).isSameAs(createCharBuffer(new char[]{'1', '2'}));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(value, new FailDescription("Message")).isSameAs(createCharBuffer(new char[]{'1', '2'}));
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<[1, 2]> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        CharBuffer value = createCharBuffer(new char[]{'1', '2'});
        new CharBufferAssertion(value, new FailDescription()).isNotSameAs(createCharBuffer(new char[]{'1', '2'}));
        new CharBufferAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new CharBufferAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<[1, 2]>.");
        }
        try {
            new CharBufferAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("CharBufferAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<[1, 2]>.");
        }
    }

    /**
     * {@link CharBufferAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new CharBufferAssertion(null, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new CharBufferAssertion(null, new FailDescription()).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new CharBufferAssertion(null, new FailDescription()).asString(createCharBuffer(new char[]{'1', '2', '3'}))).isEqualTo("[1, 2, 3]");
        Assertions.assertThat(new CharBufferAssertion(null, new FailDescription()).asString(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}))).isEqualTo("[1, 2, 3, 4, 5]");
        Assertions.assertThat(new CharBufferAssertion(null, new FailDescription()).asString(createCharBuffer(new char[]{'1', '2', '3', '4', '5'}, 2))).isEqualTo("[3, 4, 5]");
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
