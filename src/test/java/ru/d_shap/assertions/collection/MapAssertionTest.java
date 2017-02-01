///////////////////////////////////////////////////////////////////////////////////////////////////
// Assertions framework provides facilities for unit testing.
// Copyright (C) 2017 Dmitry Shapovalov.
//
// This file is part of Assertions framework.
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
package ru.d_shap.assertions.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;

/**
 * Tests for {@link MapAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class MapAssertionTest {

    /**
     * Test class constructor.
     */
    public MapAssertionTest() {
        super();
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        new MapAssertion(new MapImpl(), null).isEmpty();

        try {
            new MapAssertion(null, null).isEmpty();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key", "value"), null).isEmpty();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<{key=value}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new MapAssertion(new MapImpl(), null).isNullOrEmpty();
        new MapAssertion(null, null).isNullOrEmpty();

        try {
            new MapAssertion(new MapImpl("key", "value"), null).isNullOrEmpty();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<{key=value}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new MapAssertion(new MapImpl("key", "value"), null).isNotEmpty();

        try {
            new MapAssertion(null, null).isNotEmpty();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl(), null).isNotEmpty();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toKeysTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).toKeys().isNotEmpty();

        try {
            new MapAssertion(null, null).toKeys();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).toKeys().contains("key");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<key> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").toKeys().contains("key");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<key> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKey("key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKey("key2");

        try {
            new MapAssertion(null, null).containsKey("key");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKey(null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKey("key3");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<key3> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsKey("key3");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<key3> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainKeyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainKey("key3");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainKey("key4");

        try {
            new MapAssertion(null, null).doesNotContainKey("key");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainKey(null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainKey("key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain the expected value. Expected:<key1> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").doesNotContainKey("key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain the expected value. Expected:<key1> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys("key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys("key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys("key1", "key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys("key2", "key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys(Arrays.asList("key1", "key2"));

        try {
            new MapAssertion(null, null).containsAllKeys("key");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys((Object[]) null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys((Iterable<?>) null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys(new ArrayList<String>());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys("key3");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys("key1", "key3");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys("key3", "key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsAllKeys("key3", "key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly("key1", "key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly("key2", "key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly(Arrays.asList("key1", "key2"));

        try {
            new MapAssertion(null, null).containsKeysExactly("key");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly((Object[]) null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly((Iterable<?>) null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly(new ArrayList<String>());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly("key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly("key2");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key2]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly("key3");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key3]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly("key1", "key3");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly("key3", "key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyKeyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey("key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey("key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey("key1", "key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey("key2", "key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey("key1", "key3", "key5");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey("key6", "key2", "key4");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey(Arrays.asList("key1", "key3", "key5"));

        try {
            new MapAssertion(null, null).containsAnyKey("key");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey((Object[]) null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey((Iterable<?>) null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey(new ArrayList<String>());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey("key3");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[key3]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey("key4", "key6");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoKeyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey("key3");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey("key4");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey("key3", "key4");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey("key4", "key3");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey("key6", "key7", "key8");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey("key7", "key6", "key8");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey(Arrays.asList("key6", "key7", "key8"));

        try {
            new MapAssertion(null, null).containsNoKey("key");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey((Object[]) null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey((Iterable<?>) null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey(new ArrayList<String>());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey("key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey("key2", "key4");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey("key3", "key2", "key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toValuesTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).toValues().isNotEmpty();

        try {
            new MapAssertion(null, null).isNotEmpty();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).toValues().contains("value");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain the expected value. Expected:<value> but was:<[value1, value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").toValues().contains("value");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain the expected value. Expected:<value> but was:<[value1, value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsEntryTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsEntry("key1", "value1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsEntry("key2", "value2");

        try {
            new MapAssertion(null, null).containsEntry("key", "value");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsEntry(null, "value");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[null=value]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsEntry("key", null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key=null]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsEntry("key1", "value2");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsEntry("key2", "value1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key2=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsEntry("key3", "value3");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainEntryTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainEntry("key", "value");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainEntry("key1", "value2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainEntry("key2", "value1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainEntry(null, "value");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainEntry("key", null);

        try {
            new MapAssertion(null, null).doesNotContainEntry("key", "value");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainEntry("key1", "value1");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).doesNotContainEntry("key2", "value2");
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAll(new MapImpl("key1", "value1"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAll(new MapImpl("key2", "value2"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAll(new MapImpl("key1", "value1", "key2", "value2"));

        try {
            new MapAssertion(null, null).containsAll(new MapImpl());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAll(null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAll(new HashMap<String, String>());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAll(new MapImpl("key1", "value2"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAll(new MapImpl("key3", "value3"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAll(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsAll(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsExactly(new MapImpl("key1", "value1", "key2", "value2"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsExactly(new MapImpl("key2", "value2", "key1", "value1"));

        try {
            new MapAssertion(null, null).containsExactly(new MapImpl());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsExactly(null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsExactly(new MapImpl());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsExactly(new MapImpl("key1", "value1"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsExactly(new MapImpl("key2", "value2"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsExactly(new MapImpl("key1", "value2"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsExactly(new MapImpl("key3", "value3"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsExactly(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsExactly(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAny(new MapImpl("key1", "value1", "key3", "value3", "key5", "value5"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAny(new MapImpl("key4", "value4", "key2", "value2", "key1", "value1"));

        try {
            new MapAssertion(null, null).containsAny(new MapImpl());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAny(null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAny(new MapImpl());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsAny(new MapImpl("key", "value"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[key=value]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsAny(new MapImpl("key", "value"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[key=value]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNone(new MapImpl("key3", "value3", "key4", "value4", "key5", "value5"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNone(new MapImpl("key", "value"));

        try {
            new MapAssertion(null, null).containsNone(new MapImpl());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNone(null);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNone(new HashMap<String, String>());
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNone(new MapImpl("key1", "value1"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).containsNone(new MapImpl("key1", "value1", "key2", "value2"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1, key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").containsNone(new MapImpl("key1", "value1", "key2", "value2"));
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[key1=value1, key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        new MapAssertion(new MapImpl(), null).toSize().isEqualTo(0);
        new MapAssertion(new MapImpl("key1", "value1"), null).toSize().isEqualTo(1);
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).toSize().isEqualTo(2);
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"), null).toSize().isEqualTo(3);

        try {
            new MapAssertion(null, null).toSize();
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).toSize().isEqualTo(3);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<3> but was:<2>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").toSize().isEqualTo(3);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<3> but was:<2>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        new MapAssertion(new MapImpl(), null).hasSize(0);
        new MapAssertion(new MapImpl("key1", "value1"), null).hasSize(1);
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).hasSize(2);
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"), null).hasSize(3);

        try {
            new MapAssertion(null, null).hasSize(0);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), null).hasSize(3);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<3> but was:<2>");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), "Message").hasSize(3);
            Assertions.fail("Map assertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<3> but was:<2>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new MapAssertion(null, null).asString(null)).isNull();
        Assertions.assertThat(new MapAssertion(null, null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new MapAssertion(null, null).asString(new MapImpl())).isEqualTo("{}");
        Assertions.assertThat(new MapAssertion(null, null).asString(new MapImpl("key1", "value1"))).isEqualTo("{key1=value1}");
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class MapImpl extends HashMap<String, String> {

        private static final long serialVersionUID = 1L;

        MapImpl() {
            super();
        }

        MapImpl(final String key, final String value) {
            super();
            put(key, value);
        }

        MapImpl(final String key1, final String value1, final String key2, final String value2) {
            super();
            put(key1, value1);
            put(key2, value2);
        }

        MapImpl(final String key1, final String value1, final String key2, final String value2, final String key3, final String value3) {
            super();
            put(key1, value1);
            put(key2, value2);
            put(key3, value3);
        }

        @Override
        public Set<String> keySet() {
            return new TreeSet<>(super.keySet());
        }

    }

}
