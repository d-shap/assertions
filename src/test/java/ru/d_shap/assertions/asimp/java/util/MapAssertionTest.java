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
package ru.d_shap.assertions.asimp.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.hamcrest.Matchers;
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
    public void actualValueValidatorTest() {
        initialize(Raw.mapAssertion(), createHashMap());

        try {
            initializeWithRawActual(Raw.<String, String>mapAssertion(), new Object());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Map> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.<String, String>mapAssertion(), new Object(), "Message");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.Map> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.mapAssertion(), createHashMap()).isEmpty();

        try {
            Raw.<String, String>mapAssertion().isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key", "value")).isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key", "value"), "Message").isEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<{key=value}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.mapAssertion(), createHashMap()).isNullOrEmpty();
        initialize(Raw.<String, String>mapAssertion(), null).isNullOrEmpty();

        try {
            Raw.<String, String>mapAssertion().isNullOrEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key", "value")).isNullOrEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key", "value"), "Message").isNullOrEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<{key=value}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key", "value")).isNotEmpty();

        try {
            Raw.<String, String>mapAssertion().isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap()).isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap(), "Message").isNotEmpty();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toKeysTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toKeys().isNotEmpty();

        try {
            Raw.<String, String>mapAssertion().toKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toKeys()).contains("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toKeys()).contains("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toKeys().contains("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toKeys().contains("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toKeysMatcherTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toKeys(Matchers.hasItems("key1", "key2"));

        try {
            Raw.<String, String>mapAssertion().toKeys(Matchers.hasItems(""));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toKeys(Matchers.hasItems(""));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toKeys(Matchers.hasItems(""));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toKeys(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toKeys(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).toKeys(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").toKeys(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toKeys(Matchers.hasItems("key"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\nExpected: (a collection containing \"key\")\n     but: a collection containing \"key\" was \"key1\", was \"key2\"");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toKeys(Matchers.hasItems("key"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\nExpected: (a collection containing \"key\")\n     but: a collection containing \"key\" was \"key1\", was \"key2\"");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeyTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKey("key1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKey("key2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsKey(null);
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKey(null);

        try {
            Raw.<String, String>mapAssertion().containsKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsKey("key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainKeyTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey("key3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey("key4");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).doesNotContainKey("key3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey(null);

        try {
            Raw.<String, String>mapAssertion().doesNotContainKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).doesNotContainKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").doesNotContainKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").doesNotContainKey("key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key1", "key3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key2", "key3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key2", "key1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeys(null, "key1");

        try {
            Raw.<String, String>mapAssertion().containsAllKeys("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeys("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeys("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeys((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeys((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAllKeys((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAllKeys((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAllKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAllKeys();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key1", "key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAllKeys("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(Arrays.asList("key1", "key3"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(Arrays.asList("key2", "key3"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(Arrays.asList("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(Arrays.asList("key2", "key1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeys(Arrays.asList(null, "key1"));

        try {
            Raw.<String, String>mapAssertion().containsAllKeys(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeys(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeys(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeys((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeys((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAllKeys((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAllKeys((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAllKeys(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAllKeys(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys(Arrays.asList("key1", "key3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysInOrderArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key1", "key3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key2", "key3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key1", "key2", "key3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder("key1", null);
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(null, "key3");

        try {
            Raw.<String, String>mapAssertion().containsAllKeysInOrder("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeysInOrder("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeysInOrder("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeysInOrder((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeysInOrder((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAllKeysInOrder((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAllKeysInOrder((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAllKeysInOrder();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAllKeysInOrder();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder("key1", "key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key3", "key2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key2]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(null, "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[<NULL>, key1]> but was:<[key1, <NULL>, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeysInOrder("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAllKeysInOrder("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAllKeysInOrder("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAllKeysInOrder("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAllKeysInOrder("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllKeysInOrderIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(Arrays.asList("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(Arrays.asList("key1", "key3"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(Arrays.asList("key2", "key3"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(Arrays.asList("key1", "key2", "key3"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(Arrays.asList("key1", null));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(Arrays.asList(null, "key3"));

        try {
            Raw.<String, String>mapAssertion().containsAllKeysInOrder(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeysInOrder(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeysInOrder(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAllKeysInOrder(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAllKeysInOrder(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder(Arrays.asList("key1", "key3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(Arrays.asList("key3", "key2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key2]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(Arrays.asList("key2", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(Arrays.asList(null, "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[<NULL>, key1]> but was:<[key1, <NULL>, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllKeysInOrder(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key2", "key1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKeysExactly(null, "key1");
        initialize(Raw.mapAssertion(), createHashMap()).containsKeysExactly();

        try {
            Raw.<String, String>mapAssertion().containsKeysExactly("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactly("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactly("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactly((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactly((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsKeysExactly((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsKeysExactly((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key2", "key1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKeysExactly(Arrays.asList(null, "key1"));
        initialize(Raw.mapAssertion(), createHashMap()).containsKeysExactly(new ArrayList<>());

        try {
            Raw.<String, String>mapAssertion().containsKeysExactly(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactly(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactly(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactly((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactly((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsKeysExactly((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsKeysExactly((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key1", "key3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyInOrderArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder("key1", null);
        initialize(Raw.mapAssertion(), createHashMap()).containsKeysExactlyInOrder();

        try {
            Raw.<String, String>mapAssertion().containsKeysExactlyInOrder("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactlyInOrder("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactlyInOrder("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactlyInOrder((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactlyInOrder((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsKeysExactlyInOrder((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsKeysExactlyInOrder((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder("key1", "key3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsKeysExactlyInOrder("key3", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder(null, "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>, key1]> but was:<[key1, <NULL>]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsKeysExactlyInOrder("key1", null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[key1, <NULL>, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyInOrderIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(Arrays.asList("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder(Arrays.asList("key1", null));
        initialize(Raw.mapAssertion(), createHashMap()).containsKeysExactlyInOrder(new ArrayList<>());

        try {
            Raw.<String, String>mapAssertion().containsKeysExactlyInOrder(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactlyInOrder(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactlyInOrder(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(Arrays.asList("key1", "key3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).containsKeysExactlyInOrder(Arrays.asList("key3", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder(Arrays.asList(null, "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[<NULL>, key1]> but was:<[key1, <NULL>]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2", "key3", "value3")).containsKeysExactlyInOrder(Arrays.asList("key1", null));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[key1, <NULL>, key3]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(Arrays.asList("key2", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactlyInOrder(Arrays.asList("key2", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyKeyArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key2", "key1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key3", "key5");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key6", "key2", "key4");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsAnyKey("key6", null, "key4");

        try {
            Raw.<String, String>mapAssertion().containsAnyKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAnyKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAnyKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAnyKey((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAnyKey((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAnyKey((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAnyKey((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAnyKey();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAnyKey();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key4", "key6");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyKeyIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key1", "key2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key2", "key1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key1", "key3", "key5"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key6", "key2", "key4"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsAnyKey(Arrays.asList("key6", null, "key4"));

        try {
            Raw.<String, String>mapAssertion().containsAnyKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAnyKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAnyKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAnyKey((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAnyKey((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAnyKey((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAnyKey((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAnyKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAnyKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key4", "key6"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey(Arrays.asList("key9", "key8", "key7"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoKeyArrayTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key4");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key4", "key3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key6", "key7", "key8");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key7", "key6", "key8");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsNoKey("key7", "key6", "key8");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key7", null, "key8");
        initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsNoKey("key4", "key3");
        initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsNoKey("key4", "key3");

        try {
            Raw.<String, String>mapAssertion().containsNoKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNoKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNoKey("key");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNoKey((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNoKey((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsNoKey((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsNoKey((String[]) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsNoKey();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsNoKey();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key2", "key4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, 1(49)]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoKeyIterableTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key3", "key4"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key4", "key3"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key6", "key7", "key8"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key7", "key6", "key8"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", null, "value2")).containsNoKey(Arrays.asList("key7", "key6", "key8"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key7", null, "key8"));

        try {
            Raw.<String, String>mapAssertion().containsNoKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNoKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNoKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNoKey((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNoKey((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsNoKey((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsNoKey((Iterable<String>) null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsNoKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsNoKey(new ArrayList<String>());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key2", "key4"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsNoKey(Arrays.asList("key3", "key2", "key1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toValuesTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toValues().isNotEmpty();
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", null)).toValues().contains("value1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", null)).toValues().contains(null);

        try {
            Raw.<String, String>mapAssertion().toValues();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toValues();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toValues();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toValues()).contains("value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's values.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toValues()).contains("value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's values.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toValues().contains("value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's values.\n\tActual value should contain the expected value.\n\tExpected:<value> but was:<[value1, value2]>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toValues().contains("value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's values.\n\tActual value should contain the expected value.\n\tExpected:<value> but was:<[value1, value2]>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toValuesMatcherTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toValues(Matchers.hasItems("value1", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", null)).toValues(Matchers.hasItems("value1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", null)).toValues(Matchers.hasItems((String) null));

        try {
            Raw.<String, String>mapAssertion().toValues(Matchers.hasItems(""));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toValues(Matchers.hasItems(""));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toValues(Matchers.hasItems(""));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toValues(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toValues(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).toValues(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").toValues(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toValues(Matchers.hasItems("value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's values.\nExpected: (a collection containing \"value\")\n     but: a collection containing \"value\" was \"value1\", was \"value2\"");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toValues(Matchers.hasItems("value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's values.\nExpected: (a collection containing \"value\")\n     but: a collection containing \"value\" was \"value1\", was \"value2\"");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsEntryTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsEntry(null, "value1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsEntry("key1", null);

        try {
            Raw.<String, String>mapAssertion().containsEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry(null, "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{<NULL>=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key", null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key=<NULL>}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key2=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsEntry("key3", "value3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void doesNotContainEntryTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", "value");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry(null, "value");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", null);
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).doesNotContainEntry("key1", "value1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).doesNotContainEntry("key1", "value1");
        initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).doesNotContainEntry("key1", "value2");
        initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).doesNotContainEntry("key1", "value2");

        try {
            Raw.<String, String>mapAssertion().doesNotContainEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).doesNotContainEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").doesNotContainEntry("key", "value");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").doesNotContainEntry("key2", "value2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).doesNotContainEntry("key1", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").doesNotContainEntry("key1", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).doesNotContainEntry("key1", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").doesNotContainEntry("key1", "value1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=1(49)}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll1Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3");

        try {
            Raw.mapAssertion().containsAll("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAll("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAll("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll2Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5");

        try {
            Raw.mapAssertion().containsAll("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAll("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll3Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5", "k2", "v2");

        try {
            Raw.mapAssertion().containsAll("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAll("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll4Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5", "k2", "v2", "k1", "v1");

        try {
            Raw.mapAssertion().containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAll5Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5", "k2", "v2", "k1", "v1", "k4", "v4");

        try {
            Raw.mapAssertion().containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k1", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k1=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k1", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k1=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsAll(createHashMap("key2", "value2", null, "value1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsAll(createHashMap("key2", "value2", null, "value1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsAll(createHashMap("key2", "value2", "key1", null));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsAll(createHashMap("key2", "value2", "key1", null));
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAll(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));

        try {
            Raw.mapAssertion().containsAll(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAll(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAll(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAll(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "", (Object) "")).containsAll(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "", (Object) ""), "Message").containsAll(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key1", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAll(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAll(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAll(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAll(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAll(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAll(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAll(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key1", "value2", "key1", "value3"), "Message").containsAll(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder1Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k3", "v3");

        try {
            Raw.mapAssertion().containsAllInOrder("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAllInOrder("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAllInOrder("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder2Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k3", "v3", "k5", "v5");

        try {
            Raw.mapAssertion().containsAllInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder3Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k3", "v3", "k5", "v5");

        try {
            Raw.mapAssertion().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder4Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");

        try {
            Raw.mapAssertion().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrder5Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");

        try {
            Raw.mapAssertion().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(createHashMap("key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(createHashMap("key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsAllInOrder(createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsAllInOrder(createHashMap("key1", null, "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAllInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));

        try {
            Raw.mapAssertion().containsAllInOrder(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAllInOrder(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAllInOrder(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAllInOrder(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAllInOrder(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAllInOrder(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAllInOrder(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "", (Object) "")).containsAllInOrder(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "", (Object) ""), "Message").containsAllInOrder(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(createHashMap("key1", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(createHashMap("key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(createHashMap("key2", "value2", "key1", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key2=value2, key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsAllInOrder(createHashMap("key2", "value2", null, "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key2=value2, <NULL>=value1}> but was:<{<NULL>=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsAllInOrder(createHashMap("key2", "value2", "key1", null));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key2=value2, key1=<NULL>}> but was:<{key1=<NULL>, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAllInOrder(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAllInOrder(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAllInOrder(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAllInOrder(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAllInOrder(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAllInOrder(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAllInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key1", "value2", "key1", "value3"), "Message").containsAllInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly0Test() {
        initialize(Raw.mapAssertion(), createHashMap()).containsExactly();

        try {
            Raw.mapAssertion().containsExactly();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactly();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactly();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly1Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1")).containsExactly("k1", "v1");

        try {
            Raw.mapAssertion().containsExactly("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactly("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactly("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly2Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2")).containsExactly("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2")).containsExactly("k2", "v2", "k1", "v1");

        try {
            Raw.mapAssertion().containsExactly("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactly("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly3Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3")).containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3")).containsExactly("k2", "v2", "k1", "v1", "k3", "v3");

        try {
            Raw.mapAssertion().containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly4Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).containsExactly("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");

        try {
            Raw.mapAssertion().containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactly5Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");

        try {
            Raw.mapAssertion().containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsExactly(createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsExactly(createHashMap("key1", null, "key2", "value2"));
        initialize(Raw.mapAssertion(), createHashMap()).containsExactly(createHashMap());
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsExactly(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));

        try {
            Raw.mapAssertion().containsExactly(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactly(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactly(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsExactly(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key1", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key1", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", "value2")).containsExactly(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key1", "value2", "key2", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value2, key2=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactly(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsExactly(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsExactly(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsExactly(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsExactly(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsExactly(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsExactly(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key1", "value2", "key1", "value3"), "Message").containsExactly(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder0Test() {
        initialize(Raw.mapAssertion(), createHashMap()).containsExactlyInOrder();

        try {
            Raw.mapAssertion().containsExactlyInOrder();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactlyInOrder();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactlyInOrder();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder1Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1")).containsExactlyInOrder("k1", "v1");

        try {
            Raw.mapAssertion().containsExactlyInOrder("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactlyInOrder("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder2Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2")).containsExactlyInOrder("k1", "v1", "k2", "v2");

        try {
            Raw.mapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder3Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3")).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");

        try {
            Raw.mapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder4Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");

        try {
            Raw.mapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder5Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");

        try {
            Raw.mapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsExactlyInOrder(createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsExactlyInOrder(createHashMap("key1", null, "key2", "value2"));
        initialize(Raw.mapAssertion(), createHashMap()).containsExactlyInOrder(createHashMap());
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsExactlyInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));

        try {
            Raw.mapAssertion().containsExactlyInOrder(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsExactlyInOrder(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsExactlyInOrder(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsExactlyInOrder(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsExactlyInOrder(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsExactlyInOrder(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsExactlyInOrder(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(createHashMap("key1", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(createHashMap("key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(createHashMap("key1", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(createHashMap("key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", "value2")).containsExactlyInOrder(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(createHashMap("key2", "value2", "key1", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(createHashMap("key1", "value2", "key2", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value2, key2=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsExactlyInOrder(createHashMap("key2", "value2", null, "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, <NULL>=value1}> but was:<{<NULL>=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsExactlyInOrder(createHashMap("key2", "value2", "key1", null));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key1=<NULL>}> but was:<{key1=<NULL>, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsExactlyInOrder(createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsExactlyInOrder(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsExactlyInOrder(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsExactlyInOrder(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsExactlyInOrder(createHashMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsExactlyInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key1", "value2", "key1", "value3"), "Message").containsExactlyInOrder(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key1=value2, key1=value3}> but was:<{key1=value3}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny1Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k5", "v5");

        try {
            Raw.mapAssertion().containsAny("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAny("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAny("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny2Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k5", "v5");

        try {
            Raw.mapAssertion().containsAny("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAny("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny3Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k8", "v8", "k5", "v5");

        try {
            Raw.mapAssertion().containsAny("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAny("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny4Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k8", "v8", "k9", "v9", "k5", "v5");

        try {
            Raw.mapAssertion().containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAny5Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k8", "v8", "k9", "v9", "k10", "v10", "k5", "v5");

        try {
            Raw.mapAssertion().containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44, k5=v55}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44, k5=v55}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap("key1", "value1", "key3", "value3", "key5", "value5"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap("key4", "value4", "key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsAny(createHashMap(null, "value1", "key3", "value3", "key5", "value5"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsAny(createHashMap("key1", null, "key3", "value3", "key5", "value5"));
        initialize(Raw.<String, String>mapAssertion(), createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAny(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key1", "value2", "key1", "value3")).containsAny(createDuplicateMap("key1", "value1", "key1", "value2", "key1", "value3"));

        try {
            Raw.mapAssertion().containsAny(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsAny(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsAny(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsAny(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "", (Object) "")).containsAny(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "", (Object) ""), "Message").containsAny(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap("key1", "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key1=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap("key", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap("key", (String) null));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=<NULL>}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsAny(createHashMap("key", "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsAny(createHashMap("key", "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsAny(createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsAny(createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsAny(createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsAny(createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=1(49)}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone1Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11");

        try {
            Raw.mapAssertion().containsNone("k1", "v11");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNone("k1", "v11");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsNone("k1", "v11");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone2Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22");

        try {
            Raw.mapAssertion().containsNone("k1", "v11", "k2", "v22");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNone("k1", "v11", "k2", "v22");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone3Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22", "k3", "v33");

        try {
            Raw.mapAssertion().containsNone("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNone("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone4Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");

        try {
            Raw.mapAssertion().containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNone5Test() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");

        try {
            Raw.mapAssertion().containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap("key3", "value3", "key4", "value4", "key5", "value5"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap("key", "value"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap(null, "value1", "key2", "value2")).containsNone(createHashMap("key1", "value1"));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", null, "key2", "value2")).containsNone(createHashMap("key1", "value1"));
        initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", "value2")).containsNone(createHashMap(null, (Object) "value1"));
        initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", "value2")).containsNone(createHashMap((Object) "key1", null));
        initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsNone(createHashMap((Object) "key", (Object) "value"));
        initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsNone(createHashMap((Object) "key", (Object) "value"));

        try {
            Raw.mapAssertion().containsNone(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.mapAssertion(), null).containsNone(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.mapAssertion(), null, "Message").containsNone(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").containsNone(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "", (Object) "")).containsNone(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "", (Object) ""), "Message").containsNone(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap("key1", "value1"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).containsNone(createHashMap("key1", "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").containsNone(createHashMap("key1", "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2")).containsNone(createHashMap((Object) "key1", (Object) "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", '1', "value2"), "Message").containsNone(createHashMap((Object) "key1", (Object) "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, 1(49)=value2}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1')).containsNone(createHashMap((Object) "key1", (Object) "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=1(49)}>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap((Object) "key1", (Object) "value1", "key2", '1'), "Message").containsNone(createHashMap((Object) "key1", (Object) "value1", "key2", "value2"));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=1(49)}>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.mapAssertion(), createHashMap()).toSize().isEqualTo(0);
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1")).toSize().isEqualTo(1);
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(2);
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).toSize().isEqualTo(3);

        try {
            Raw.<String, String>mapAssertion().toSize();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toSize();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toSize();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toSize()).isEqualTo(1);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toSize()).isEqualTo(1);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toSize().isEqualTo(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void toSizeMatcherTest() {
        initialize(Raw.mapAssertion(), createHashMap()).toSize(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1")).toSize(Matchers.equalTo(1));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toSize(Matchers.equalTo(2));
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).toSize(Matchers.equalTo(3));

        try {
            Raw.<String, String>mapAssertion().toSize(Matchers.equalTo(0));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toSize(Matchers.equalTo(0));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toSize(Matchers.equalTo(0));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).toSize(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").toSize(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", "")).toSize(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("", ""), "Message").toSize(null);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).toSize(Matchers.equalTo(3));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\nExpected: <3>\n     but: was <2>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").toSize(Matchers.equalTo(3));
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\nExpected: <3>\n     but: was <2>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.mapAssertion(), createHashMap()).hasSize(0);
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1")).hasSize(1);
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).hasSize(2);
        initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2", "key3", "value3")).hasSize(3);

        try {
            Raw.<String, String>mapAssertion().hasSize(1);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null).hasSize(1);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), null, "Message").hasSize(1);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2")).hasSize(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.<String, String>mapAssertion(), createHashMap("key1", "value1", "key2", "value2"), "Message").hasSize(3);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String, String>mapAssertion(), null).isNull();

        try {
            initialize(Raw.mapAssertion(), createHashMap()).isNull();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.mapAssertion(), createHashMap(), "Message").isNull();
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<EMPTY>>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        Map<Object, Object> value = createHashMap();
        initialize(Raw.mapAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.mapAssertion(), value).isSameAs(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be the same.\n\tExpected:<<EMPTY>> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.mapAssertion(), value, "Message").isSameAs(createHashMap());
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be the same.\n\tExpected:<<EMPTY>> but was:<<EMPTY>>");
        }
    }

    /**
     * {@link MapAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        Map<Object, Object> value = createHashMap();
        initialize(Raw.mapAssertion(), value).isNotSameAs(createHashMap());

        try {
            initialize(Raw.mapAssertion(), value).isNotSameAs(value);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should be different.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.mapAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("MapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should be different.\n\tActual:<<EMPTY>>");
        }
    }

}
