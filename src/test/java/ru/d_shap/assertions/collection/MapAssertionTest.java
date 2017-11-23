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

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link MapAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class MapAssertionTest extends AssertionTest {

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
        initialize(Raw.mapAssertion(), createHashMap()).isEmpty();

        try {
            initialize(Raw.mapAssertion(), null).isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key", "value")).isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<{key=value}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key", "value"), "Message").isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<{key=value}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.mapAssertion(), createHashMap()).isNullOrEmpty();
        initialize(Raw.mapAssertion(), null).isNullOrEmpty();

        try {
            initialize(Raw.mapAssertion(), createHashMap("key", "value")).isNullOrEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<{key=value}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key", "value"), "Message").isNullOrEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<{key=value}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.mapAssertion(), createHashMap("key", "value")).isNotEmpty();

        try {
            initialize(Raw.mapAssertion(), null).isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap()).isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap(), "Message").isNotEmpty();
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
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toKeys().isNotEmpty();

        try {
            initialize(Raw.mapAssertion(), null).toKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").toKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toKeys().contains("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain the expected value. Expected:<key> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toKeys().contains("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain the expected value. Expected:<key> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeyTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKey("key1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKey("key2");
        initialize(Raw.mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsKey(null);
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKey(null);

        try {
            initialize(Raw.mapAssertion(), null).containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain the expected value. Expected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain the expected value. Expected:<key3> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainKeyTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey("key3");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey("key4");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).doesNotContainKey("key3");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey(null);

        try {
            initialize(Raw.mapAssertion(), null).doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain the expected value. Expected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should not contain the expected value. Expected:<key1> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key2");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key1", "key2");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key2", "key1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys(Arrays.asList("key2", "key1"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsAllKeys(null, "key1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsAllKeys(Arrays.asList(null, "key1"));

        try {
            initialize(Raw.mapAssertion(), null).containsAllKeys("key1", "key2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAllKeys(Arrays.asList("key1", "key2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAllKeys((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAllKeys((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key1", "key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key2");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key2", "key1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key2", "key1"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKeysExactly(null, "key1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKeysExactly(Arrays.asList(null, "key1"));
        initialize(Raw.mapAssertion(), createHashMap()).containsKeysExactly();
        initialize(Raw.mapAssertion(), createHashMap()).containsKeysExactly(new ArrayList<String>());

        try {
            initialize(Raw.mapAssertion(), null).containsKeysExactly("key1", "key2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsKeysExactly(Arrays.asList("key1", "key2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsKeysExactly((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsKeysExactly((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key2]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyKeyTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key2");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key2");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key2", "key1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key3", "key5");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key6", "key2", "key4");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key6", "key2", "key4"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsAnyKey("key6", null, "key4");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsAnyKey(Arrays.asList("key6", null, "key4"));

        try {
            initialize(Raw.mapAssertion(), null).containsAnyKey("key1", "key2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAnyKey(Arrays.asList("key1", "key2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAnyKey((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAnyKey((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key4", "key6");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoKeyTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key3");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key4");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key4");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key4", "key3");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key6", "key7", "key8");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key7", "key6", "key8");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key7", "key6", "key8"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsNoKey("key7", "key6", "key8");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsNoKey(Arrays.asList("key7", "key6", "key8"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key7", null, "key8");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key7", null, "key8"));

        try {
            initialize(Raw.mapAssertion(), null).containsNoKey("key1", "key2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNoKey(Arrays.asList("key1", "key2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNoKey((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNoKey((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey((Object[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey((Iterable<?>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key2", "key4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toValuesTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toValues().isNotEmpty();
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", null)).toValues().contains("value1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", null)).toValues().contains(null);

        try {
            initialize(Raw.mapAssertion(), null).toValues();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").toValues();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toValues().contains("value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check values. Value should contain the expected value. Expected:<value> but was:<[value1, value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toValues().contains("value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check values. Value should contain the expected value. Expected:<value> but was:<[value1, value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsEntryTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value2");
        initialize(Raw.mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsEntry(null, "value1");
        initialize(Raw.mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsEntry("key1", null);

        try {
            initialize(Raw.mapAssertion(), null).containsEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry(null, "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[null=value]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key", null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key=null]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key2=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainEntryTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", "value");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value2");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value1");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry(null, "value");
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", null);
        initialize(Raw.mapAssertion(), createHashMap(null, "value1", "key2", "value2")).doesNotContainEntry("key1", "value1");
        initialize(Raw.mapAssertion(), createHashMap("key1", null, "key2", "value2")).doesNotContainEntry("key1", "value1");

        try {
            initialize(Raw.mapAssertion(), null).doesNotContainEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").doesNotContainEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").doesNotContainEntry("key2", "value2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key1", "value1"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key2", "value2"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsAll(createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsAll(createHashMap("key1", null, "key2", "value2"));

        try {
            initialize(Raw.mapAssertion(), null).containsAll(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAll(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(new HashMap<String, String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAll(new HashMap<String, String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key1", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAll(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key2", "value2", "key1", "value1"));
        initialize(Raw.mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsExactly(createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsExactly(createHashMap("key1", null, "key2", "value2"));
        initialize(Raw.mapAssertion(), createHashMap()).containsExactly(createHashMap());

        try {
            initialize(Raw.mapAssertion(), null).containsExactly(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactly(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key1", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key1", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsExactly(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap("key1", "value1", "key3", "value3", "key5", "value5"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap("key4", "value4", "key2", "value2", "key1", "value1"));
        initialize(Raw.mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsAny(createHashMap(null, "value1", "key3", "value3", "key5", "value5"));
        initialize(Raw.mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsAny(createHashMap("key1", null, "key3", "value3", "key5", "value5"));

        try {
            initialize(Raw.mapAssertion(), null).containsAny(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAny(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAny(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap("key", "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[key=value]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAny(createHashMap("key", "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[key=value]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap("key3", "value3", "key4", "value4", "key5", "value5"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap("key", "value"));
        initialize(Raw.mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsNone(createHashMap("key1", "value1"));
        initialize(Raw.mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsNone(createHashMap("key1", "value1"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap(null, "value1"));
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap("key1", null));

        try {
            initialize(Raw.mapAssertion(), null).containsNone(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsNone(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(new HashMap<String, String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsNone(new HashMap<String, String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap("key1", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap("key1", "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1, key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsNone(createHashMap("key1", "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[key1=value1, key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.mapAssertion(), createHashMap()).toSize().isEqualTo(0);
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1")).toSize().isEqualTo(1);
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(2);
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).toSize().isEqualTo(3);

        try {
            initialize(Raw.mapAssertion(), null).toSize();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").toSize();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<3> but was:<2>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toSize().isEqualTo(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<3> but was:<2>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.mapAssertion(), createHashMap()).hasSize(0);
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1")).hasSize(1);
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).hasSize(2);
        initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).hasSize(3);

        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).hasSize(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value size. Values should be the same. Expected:<3> but was:<2>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").hasSize(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value size. Values should be the same. Expected:<3> but was:<2>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.mapAssertion(), null).isNull();

        try {
            initialize(Raw.mapAssertion(), createHashMap()).isNull();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<{}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap(), "Message").isNull();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<{}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Map<String, String> value = createHashMap();
        initialize(Raw.mapAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.mapAssertion(), value).isSameAs(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<{}> but was:<{}>");
        }
        try {
            initialize(Raw.mapAssertion(), value, "Message").isSameAs(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<{}> but was:<{}>");
        }
        try {
            initialize(Raw.mapAssertion(), value).isSameAs("test");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<test> but was:<{}>");
        }
        try {
            initialize(Raw.mapAssertion(), value, "Message").isSameAs("test");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<test> but was:<{}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Map<String, String> value = createHashMap();
        initialize(Raw.mapAssertion(), value).isNotSameAs(createHashMap());
        initialize(Raw.mapAssertion(), value).isNotSameAs("test");

        try {
            initialize(Raw.mapAssertion(), value).isNotSameAs(value);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<{}>");
        }
        try {
            initialize(Raw.mapAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<{}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.mapAssertion(), null).asString(null));
            Assertions.fail("MapAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.mapAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.mapAssertion(), null).asString(createHashMap())).isEqualTo("{}");
        Assertions.assertThat(initialize(Raw.mapAssertion(), null).asString(createHashMap("key1", "value1"))).isEqualTo("{key1=value1}");
    }

}
