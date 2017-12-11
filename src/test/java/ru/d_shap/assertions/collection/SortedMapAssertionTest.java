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
import java.util.SortedMap;

import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;

/**
 * Tests for {@link SortedMapAssertion}.
 *
 * @author Dmitry Shapovalov
 */
public final class SortedMapAssertionTest extends AssertionTest {

    /**
     * Test class constructor.
     */
    public SortedMapAssertionTest() {
        super();
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void actualValueValidatorTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap());

        try {
            initializeWithRawActual(Raw.<String, String>sortedMapAssertion(), new Object());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should match the assertion.");
        }
        try {
            initializeWithRawActual(Raw.<String, String>sortedMapAssertion(), new Object(), "Message");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should match the assertion.");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap()).isEmpty();

        try {
            Raw.<String, String>sortedMapAssertion().isEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).isEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").isEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key", "value")).isEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be empty. Actual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key", "value"), "Message").isEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be empty. Actual:<{key=value}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap()).isNullOrEmpty();
        initialize(Raw.<String, String>sortedMapAssertion(), null).isNullOrEmpty();

        try {
            Raw.<String, String>sortedMapAssertion().isNullOrEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key", "value")).isNullOrEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null or empty. Actual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key", "value"), "Message").isNullOrEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null or empty. Actual:<{key=value}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key", "value")).isNotEmpty();

        try {
            Raw.<String, String>sortedMapAssertion().isNotEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).isNotEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap()).isNotEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be empty.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap(), "Message").isNotEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be empty.");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toKeysTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).toKeys().isNotEmpty();

        try {
            Raw.<String, String>sortedMapAssertion().toKeys();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toKeys();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toKeys();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).toKeys().contains("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain the expected value. Expected:<key> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").toKeys().contains("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain the expected value. Expected:<key> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsKeyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKey("key1");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKey("key2");

        try {
            Raw.<String, String>sortedMapAssertion().containsKey("key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKey("key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKey("key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKey("key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain the expected value. Expected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsKey("key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain the expected value. Expected:<key3> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void doesNotContainKeyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainKey("key3");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainKey("key4");

        try {
            Raw.<String, String>sortedMapAssertion().doesNotContainKey("key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).doesNotContainKey("key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").doesNotContainKey("key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainKey("key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain the expected value. Expected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").doesNotContainKey("key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should not contain the expected value. Expected:<key1> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllKeysArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key1", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key2", "key1");

        try {
            Raw.<String, String>sortedMapAssertion().containsAllKeys("key1", "key2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeys("key1", "key2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeys((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys("key1", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllKeysIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(Arrays.asList("key1", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(Arrays.asList("key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(Arrays.asList("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(Arrays.asList("key2", "key1"));

        try {
            Raw.<String, String>sortedMapAssertion().containsAllKeys(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeys(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeys((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys(Arrays.asList("key1", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly("key2", "key1");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap()).containsKeysExactly();

        try {
            Raw.<String, String>sortedMapAssertion().containsKeysExactly("key1", "key2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactly("key1", "key2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactly((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key2", "key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap()).containsKeysExactly(new ArrayList<String>());

        try {
            Raw.<String, String>sortedMapAssertion().containsKeysExactly(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactly(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactly((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key1", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain all of the expected values exactly. Expected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAnyKeyArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key2", "key1");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key3", "key5");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key6", "key2", "key4");

        try {
            Raw.<String, String>sortedMapAssertion().containsAnyKey("key1", "key2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAnyKey("key1", "key2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAnyKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key4", "key6");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAnyKeyIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key2", "key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key1", "key3", "key5"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key6", "key2", "key4"));

        try {
            Raw.<String, String>sortedMapAssertion().containsAnyKey(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAnyKey(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAnyKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key4", "key6"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should contain any of the expected values. Expected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNoKeyArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key4");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key4", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key6", "key7", "key8");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key7", "key6", "key8");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key7", null, "key8");

        try {
            Raw.<String, String>sortedMapAssertion().containsNoKey("key1", "key2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNoKey("key1", "key2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNoKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNoKeyIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key3", "key4"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key4", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key6", "key7", "key8"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key7", "key6", "key8"));

        try {
            Raw.<String, String>sortedMapAssertion().containsNoKey(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNoKey(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNoKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(new ArrayList<String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key2", "key4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check keys. Value should not contain any of the expected values. Expected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toValuesTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).toValues().isNotEmpty();
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", null)).toValues().contains("value1");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", null)).toValues().contains(null);

        try {
            Raw.<String, String>sortedMapAssertion().toValues();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toValues();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toValues();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).toValues().contains("value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check values. Value should contain the expected value. Expected:<value> but was:<[value1, value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").toValues().contains("value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check values. Value should contain the expected value. Expected:<value> but was:<[value1, value2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsEntryTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value1");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value2");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", null, "key2", "value2")).containsEntry("key1", null);

        try {
            Raw.<String, String>sortedMapAssertion().containsEntry("key", "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsEntry("key", "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsEntry("key", "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsEntry(null, "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[null=value]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key=null]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key2=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key3", "value3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsEntry("key3", "value3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void doesNotContainEntryTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", "value");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value2");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value1");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry(null, "value");
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", null);
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", null, "key2", "value2")).doesNotContainEntry("key1", "value1");

        try {
            Raw.<String, String>sortedMapAssertion().doesNotContainEntry("key", "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).doesNotContainEntry("key", "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").doesNotContainEntry("key", "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").doesNotContainEntry("key2", "value2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAll(createTreeMap("key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAll(createTreeMap("key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAll(createTreeMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", null, "key2", "value2")).containsAll(createTreeMap("key1", null, "key2", "value2"));

        try {
            Raw.<String, String>sortedMapAssertion().containsAll(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAll(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAll(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAll(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAll(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAll(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAll(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAll(new HashMap<String, String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAll(new HashMap<String, String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAll(createTreeMap("key1", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAll(createTreeMap("key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAll(createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAll(createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsExactly(createTreeMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsExactly(createTreeMap("key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", null, "key2", "value2")).containsExactly(createTreeMap("key1", null, "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap()).containsExactly(createTreeMap());

        try {
            Raw.<String, String>sortedMapAssertion().containsExactly(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsExactly(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsExactly(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsExactly(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsExactly(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsExactly(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsExactly(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsExactly(createTreeMap("key1", "value1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsExactly(createTreeMap("key2", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsExactly(createTreeMap("key1", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsExactly(createTreeMap("key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsExactly(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsExactly(createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain all of the expected values exactly. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsExactly(createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain all of the expected values exactly. Expected:<[key1=value1, key2=value2, key3=value3]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAny(createTreeMap("key1", "value1", "key3", "value3", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAny(createTreeMap("key4", "value4", "key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", null, "key2", "value2")).containsAny(createTreeMap("key1", null, "key3", "value3", "key5", "value5"));

        try {
            Raw.<String, String>sortedMapAssertion().containsAny(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAny(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAny(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAny(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAny(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAny(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAny(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAny(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAny(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always false.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsAny(createTreeMap("key", "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should contain any of the expected values. Expected:<[key=value]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAny(createTreeMap("key", "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should contain any of the expected values. Expected:<[key=value]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNone(createTreeMap("key3", "value3", "key4", "value4", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNone(createTreeMap("key", "value"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", null, "key2", "value2")).containsNone(createTreeMap("key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNone(createTreeMap("key1", null));

        try {
            Raw.<String, String>sortedMapAssertion().containsNone(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNone(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsNone(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNone(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsNone(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNone(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsNone(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNone(new HashMap<String, String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsNone(new HashMap<String, String>());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Argument should not be empty. The result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNone(createTreeMap("key1", "value1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).containsNone(createTreeMap("key1", "value1", "key2", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not contain any of the expected values. Expected:<[key1=value1, key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").containsNone(createTreeMap("key1", "value1", "key2", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not contain any of the expected values. Expected:<[key1=value1, key2=value2]> but was:<[key1=value1, key2=value2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap()).toSize().isEqualTo(0);
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1")).toSize().isEqualTo(1);
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(2);
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toSize().isEqualTo(3);

        try {
            Raw.<String, String>sortedMapAssertion().toSize();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toSize();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toSize();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(3);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's size. Values should be the same. Expected:<3> but was:<2>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").toSize().isEqualTo(3);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's size. Values should be the same. Expected:<3> but was:<2>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap()).hasSize(0);
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1")).hasSize(1);
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).hasSize(2);
        initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).hasSize(3);

        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2")).hasSize(3);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check value's size. Values should be the same. Expected:<3> but was:<2>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap("key1", "value1", "key2", "value2"), "Message").hasSize(3);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Check value's size. Values should be the same. Expected:<3> but was:<2>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), null).isNull();

        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap()).isNull();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Value should be null. Actual:<{}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), createTreeMap(), "Message").isNull();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Value should be null. Actual:<{}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        SortedMap<String, String> value = createTreeMap();
        initialize(Raw.<String, String>sortedMapAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.<String, String>sortedMapAssertion(), value).isSameAs(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be the same. Expected:<{}> but was:<{}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), value, "Message").isSameAs(createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be the same. Expected:<{}> but was:<{}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        SortedMap<String, String> value = createTreeMap();
        initialize(Raw.<String, String>sortedMapAssertion(), value).isNotSameAs(createTreeMap());

        try {
            initialize(Raw.<String, String>sortedMapAssertion(), value).isNotSameAs(value);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Values should be different. Actual:<{}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message. Values should be different. Actual:<{}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void asStringTest() {
        try {
            Assertions.assertThat(initialize(Raw.<String, String>sortedMapAssertion(), null).asString(null));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (NullPointerException ex) {
            Assertions.assertThat(ex).isNotNull();
        }
        Assertions.assertThat(initialize(Raw.<String, String>sortedMapAssertion(), null).asString(new StringBuilder("test"))).isEqualTo("test");
        Assertions.assertThat(initialize(Raw.<String, String>sortedMapAssertion(), null).asString(createTreeMap())).isEqualTo("{}");
        Assertions.assertThat(initialize(Raw.<String, String>sortedMapAssertion(), null).asString(createTreeMap("key1", "value1"))).isEqualTo("{key1=value1}");
    }

}
