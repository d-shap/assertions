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
package ru.d_shap.assertions.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.FailDescription;

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
        new MapAssertion(new MapImpl(), new FailDescription()).isEmpty();

        try {
            new MapAssertion(null, new FailDescription()).isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key", "value"), new FailDescription()).isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<{key=value}>.");
        }
        try {
            new MapAssertion(new MapImpl("key", "value"), new FailDescription("Message")).isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<{key=value}>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        new MapAssertion(new MapImpl(), new FailDescription()).isNullOrEmpty();
        new MapAssertion(null, new FailDescription()).isNullOrEmpty();

        try {
            new MapAssertion(new MapImpl("key", "value"), new FailDescription()).isNullOrEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<{key=value}>.");
        }
        try {
            new MapAssertion(new MapImpl("key", "value"), new FailDescription("Message")).isNullOrEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<{key=value}>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        new MapAssertion(new MapImpl("key", "value"), new FailDescription()).isNotEmpty();

        try {
            new MapAssertion(null, new FailDescription()).isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl(), new FailDescription()).isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            new MapAssertion(new MapImpl(), new FailDescription("Message")).isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toKeysTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).toKeys().isNotEmpty();

        try {
            new MapAssertion(null, new FailDescription()).toKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).toKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).toKeys().contains("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain the expected value. Expected:<key> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).toKeys().contains("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain the expected value. Expected:<key> but was:<[key1, key2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKey("key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKey("key2");

        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKey(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain the expected value. Expected:<key3> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain the expected value. Expected:<key3> but was:<[key1, key2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainKeyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainKey("key3");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainKey("key4");

        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainKey(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain the expected value. Expected:<key1> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should not contain the expected value. Expected:<key1> but was:<[key1, key2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys("key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys("key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys("key1", "key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys("key2", "key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys(Arrays.asList("key1", "key2"));

        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be empty. The result is always true.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be empty. The result is always true.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key3]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys("key1", "key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key1, key3]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly("key1", "key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly("key2", "key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly(Arrays.asList("key1", "key2"));
        new MapAssertion(new MapImpl(), new FailDescription()).containsKeysExactly();
        new MapAssertion(new MapImpl(), new FailDescription()).containsKeysExactly(new ArrayList<String>());

        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly("key2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key2]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key3]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly("key1", "key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key1, key3]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyKeyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey("key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey("key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey("key1", "key2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey("key2", "key1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey("key1", "key3", "key5");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey("key6", "key2", "key4");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey(Arrays.asList("key1", "key3", "key5"));

        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be empty. The result is always false.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be empty. The result is always false.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key3]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey("key4", "key6");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key4, key6]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoKeyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey("key3");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey("key4");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey("key3", "key4");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey("key4", "key3");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey("key6", "key7", "key8");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey("key7", "key6", "key8");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey(Arrays.asList("key6", "key7", "key8"));

        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be empty. The result is always true.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Argument should not be empty. The result is always true.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey("key2", "key4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key2, key4]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toValuesTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).toValues().isNotEmpty();

        try {
            new MapAssertion(null, new FailDescription()).toValues();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).toValues();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).toValues().contains("value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check values. Value should contain the expected value. Expected:<value> but was:<[value1, value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).toValues().contains("value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check values. Value should contain the expected value. Expected:<value> but was:<[value1, value2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsEntryTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsEntry("key1", "value1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsEntry("key2", "value2");

        try {
            new MapAssertion(null, new FailDescription()).containsEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).containsEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsEntry(null, "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[null=value]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsEntry("key", null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key=null]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsEntry("key1", "value2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsEntry("key2", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key2=value1]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainEntryTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainEntry("key", "value");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainEntry("key1", "value2");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainEntry("key2", "value1");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainEntry(null, "value");
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainEntry("key", null);

        try {
            new MapAssertion(null, new FailDescription()).doesNotContainEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).doesNotContainEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainEntry("key1", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).doesNotContainEntry("key2", "value2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).doesNotContainEntry("key2", "value2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAll(new MapImpl("key1", "value1"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAll(new MapImpl("key2", "value2"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAll(new MapImpl("key1", "value1", "key2", "value2"));

        try {
            new MapAssertion(null, new FailDescription()).containsAll(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).containsAll(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAll(new HashMap<String, String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAll(new HashMap<String, String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAll(new MapImpl("key1", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAll(new MapImpl("key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAll(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAll(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsExactly(new MapImpl("key1", "value1", "key2", "value2"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsExactly(new MapImpl("key2", "value2", "key1", "value1"));
        new MapAssertion(new MapImpl(), new FailDescription()).containsExactly(new MapImpl());

        try {
            new MapAssertion(null, new FailDescription()).containsExactly(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).containsExactly(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsExactly(new MapImpl("key1", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsExactly(new MapImpl("key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsExactly(new MapImpl("key1", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsExactly(new MapImpl("key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsExactly(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsExactly(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsExactly(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAny(new MapImpl("key1", "value1", "key3", "value3", "key5", "value5"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAny(new MapImpl("key4", "value4", "key2", "value2", "key1", "value1"));

        try {
            new MapAssertion(null, new FailDescription()).containsAny(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).containsAny(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAny(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAny(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsAny(new MapImpl("key", "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[key=value]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsAny(new MapImpl("key", "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[key=value]> but was:<[key1=value1, key2=value2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNone(new MapImpl("key3", "value3", "key4", "value4", "key5", "value5"));
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNone(new MapImpl("key", "value"));

        try {
            new MapAssertion(null, new FailDescription()).containsNone(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).containsNone(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNone(new HashMap<String, String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsNone(new HashMap<String, String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNone(new MapImpl("key1", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).containsNone(new MapImpl("key1", "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1, key2=value2]> but was:<[key1=value1, key2=value2]>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).containsNone(new MapImpl("key1", "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[key1=value1, key2=value2]> but was:<[key1=value1, key2=value2]>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        new MapAssertion(new MapImpl(), new FailDescription()).toSize().isEqualTo(0);
        new MapAssertion(new MapImpl("key1", "value1"), new FailDescription()).toSize().isEqualTo(1);
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).toSize().isEqualTo(2);
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"), new FailDescription()).toSize().isEqualTo(3);

        try {
            new MapAssertion(null, new FailDescription()).toSize();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            new MapAssertion(null, new FailDescription("Message")).toSize();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).toSize().isEqualTo(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<3> but was:<2>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).toSize().isEqualTo(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<3> but was:<2>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        new MapAssertion(new MapImpl(), new FailDescription()).hasSize(0);
        new MapAssertion(new MapImpl("key1", "value1"), new FailDescription()).hasSize(1);
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).hasSize(2);
        new MapAssertion(new MapImpl("key1", "value1", "key2", "value2", "key3", "value3"), new FailDescription()).hasSize(3);

        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription()).hasSize(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<3> but was:<2>.");
        }
        try {
            new MapAssertion(new MapImpl("key1", "value1", "key2", "value2"), new FailDescription("Message")).hasSize(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<3> but was:<2>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNullTest() {
        new MapAssertion(null, new FailDescription()).isNull();

        try {
            new MapAssertion(new MapImpl(), new FailDescription()).isNull();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<{}>.");
        }
        try {
            new MapAssertion(new MapImpl(), new FailDescription("Message")).isNull();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<{}>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Map<String, String> value = new MapImpl();
        new MapAssertion(value, new FailDescription()).isSameAs(value);

        try {
            new MapAssertion(value, new FailDescription()).isSameAs(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<{}> but was:<{}>.");
        }
        try {
            new MapAssertion(value, new FailDescription("Message")).isSameAs(new MapImpl());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<{}> but was:<{}>.");
        }
        try {
            new MapAssertion(value, new FailDescription()).isSameAs("test");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<{}>.");
        }
        try {
            new MapAssertion(value, new FailDescription("Message")).isSameAs("test");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<{}>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Map<String, String> value = new MapImpl();
        new MapAssertion(value, new FailDescription()).isNotSameAs(new MapImpl());
        new MapAssertion(value, new FailDescription()).isNotSameAs("test");

        try {
            new MapAssertion(value, new FailDescription()).isNotSameAs(value);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<{}>.");
        }
        try {
            new MapAssertion(value, new FailDescription("Message")).isNotSameAs(value);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<{}>.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void asStringTest() {
        Assertions.assertThat(new MapAssertion(null, new FailDescription()).asString(null)).isNull();
        Assertions.assertThat(new MapAssertion(null, new FailDescription()).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(new MapAssertion(null, new FailDescription()).asString(new MapImpl())).isEqualTo("{}");
        Assertions.assertThat(new MapAssertion(null, new FailDescription()).asString(new MapImpl("key1", "value1"))).isEqualTo("{key1=value1}");
    }

    /**
     * Test class.
     *
     * @author Dmitry Shapovalov
     */
    private static final class MapImpl extends TreeMap<String, String> {

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

    }

}
