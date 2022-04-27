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

import java.util.SortedMap;

import org.hamcrest.Matchers;
import org.junit.Test;

import ru.d_shap.assertions.AssertionTest;
import ru.d_shap.assertions.Assertions;
import ru.d_shap.assertions.Raw;
import ru.d_shap.assertions.util.DataHelper;

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
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap());

        try {
            initializeWithRawActual(Raw.<String, String>sortedMapAssertion(), new Object());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.SortedMap> but was:<java.lang.Object>");
        }
        try {
            initializeWithRawActual(Raw.<String, String>sortedMapAssertion(), new Object(), "Message");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should match the assertion.\n\tActual value should be the instance of the expected class.\n\tExpected:<java.util.SortedMap> but was:<java.lang.Object>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isEmptyTest() {
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).isEmpty();

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").isEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key", "value")).isEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be empty.\n\tActual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key", "value"), "Message").isEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be empty.\n\tActual:<{key=value}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isNullOrEmptyTest() {
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).isNullOrEmpty();
        initialize(Raw.<String, String>sortedMapAssertion(), null).isNullOrEmpty();

        try {
            Raw.<String, String>sortedMapAssertion().isNullOrEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key", "value")).isNullOrEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null or empty.\n\tActual:<{key=value}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key", "value"), "Message").isNullOrEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null or empty.\n\tActual:<{key=value}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isNotEmptyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key", "value")).isNotEmpty();

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").isNotEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).isNotEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be empty.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").isNotEmpty();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be empty.");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toKeysTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toKeys().isNotEmpty();

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toKeys();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toKeys()).contains("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").toKeys()).contains("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toKeys().contains("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").toKeys().contains("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toKeysMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toKeys(Matchers.hasItems("key1", "key2"));

        try {
            Raw.<String, String>sortedMapAssertion().toKeys(Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toKeys(Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toKeys(Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toKeys(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toKeys(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toKeys(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toKeys(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toKeys(Matchers.hasItems("key"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\nExpected: (a collection containing \"key\")\n     but: a collection containing \"key\" mismatches were: [was \"key1\", was \"key2\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").toKeys(Matchers.hasItems("key"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\nExpected: (a collection containing \"key\")\n     but: a collection containing \"key\" mismatches were: [was \"key1\", was \"key2\"]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsKeyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKey("key1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKey("key2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsKey(null);
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsKey(null);

        try {
            Raw.<String, String>sortedMapAssertion().containsKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKey("key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsKey("key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsKey('3');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsKey('3');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<3(51)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsKey("key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsKey("key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain the expected value.\n\tExpected:<key3> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void doesNotContainKeyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainKey("key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainKey("key4");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).doesNotContainKey("key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainKey(null);

        try {
            Raw.<String, String>sortedMapAssertion().doesNotContainKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).doesNotContainKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").doesNotContainKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainKey("key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").doesNotContainKey("key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).doesNotContainKey('1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<1(49)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").doesNotContainKey('1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<1(49)> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).doesNotContainKey("key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").doesNotContainKey("key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain the expected value.\n\tExpected:<key1> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toHeadKeysElementTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key0").containsExactlyInOrder();
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key1").containsExactlyInOrder();
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key2").containsExactlyInOrder("key1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key3").containsExactlyInOrder("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key4").containsExactlyInOrder("key1", "key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value", "key1", "value1", "key2", "value2")).toHeadKeys("key1").containsExactlyInOrder((String) null);
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(null).containsExactlyInOrder();

        try {
            Raw.<String, String>sortedMapAssertion().toHeadKeys("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadKeys("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadKeys("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toHeadKeys("key")).containsExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's head elements up to element: key.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toHeadKeys("key")).containsExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's head elements up to element: key.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toHeadKeys("key2").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toHeadKeys("key2").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key2").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key1]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadKeys("key2").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key1]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3")).toHeadKeys((Character) '2').containsExactlyInOrder('2', '3');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's head elements up to element: 2(50).\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3"), "Message").toHeadKeys((Character) '2').containsExactlyInOrder('2', '3');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's head elements up to element: 2(50).\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[1(49)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3')).toHeadKeys("key2").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key1]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3'), "Message").toHeadKeys("key2").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key1]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toHeadKeysCountTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(1).containsExactlyInOrder("key1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(2).containsExactlyInOrder("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(3).containsExactlyInOrder("key1", "key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(4).containsExactlyInOrder("key1", "key2", "key3");

        try {
            Raw.<String, String>sortedMapAssertion().toHeadKeys(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadKeys(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadKeys(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadKeys(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadKeys(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadKeys(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadKeys(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadKeys(-1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadKeys(-1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toHeadKeys(1)).containsExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N head elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toHeadKeys(1)).containsExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N head elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toHeadKeys(1).containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N head elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toHeadKeys(1).containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N head elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(1).containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N head elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key1]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadKeys(1).containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N head elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key1]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(4).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadKeys(4).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3")).toHeadKeys(4).containsExactlyInOrder('2', '4');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3"), "Message").toHeadKeys(4).containsExactlyInOrder('2', '4');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3')).toHeadKeys(4).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3'), "Message").toHeadKeys(4).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key1, key2, key3]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toHeadKeysElementMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key0", Matchers.emptyIterableOf(String.class));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key1", Matchers.emptyIterableOf(String.class));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key2", Matchers.hasItems("key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key3", Matchers.hasItems("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key4", Matchers.hasItems("key1", "key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value", "key1", "value1", "key2", "value2")).toHeadKeys("key1", Matchers.hasItems((String) null));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(null, Matchers.emptyIterableOf(String.class));

        try {
            Raw.<String, String>sortedMapAssertion().toHeadKeys("key", Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadKeys("key", Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadKeys("key", Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadKeys("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadKeys("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadKeys("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadKeys("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys("key2", Matchers.hasItems("key2", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's head elements up to element: key2.\nExpected: (a collection containing \"key2\" and a collection containing \"key3\")\n     but: a collection containing \"key2\" mismatches were: [was \"key1\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadKeys("key2", Matchers.hasItems("key2", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's head elements up to element: key2.\nExpected: (a collection containing \"key2\" and a collection containing \"key3\")\n     but: a collection containing \"key2\" mismatches were: [was \"key1\"]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toHeadKeysCountMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(1, Matchers.hasItems("key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(2, Matchers.hasItems("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(3, Matchers.hasItems("key1", "key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(4, Matchers.hasItems("key1", "key2", "key3"));

        try {
            Raw.<String, String>sortedMapAssertion().toHeadKeys(1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadKeys(1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadKeys(1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadKeys(0, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadKeys(0, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadKeys(0, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadKeys(0, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadKeys(-1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadKeys(-1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadKeys(0, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadKeys(0, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadKeys(1, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadKeys(1, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(1, Matchers.hasItems("key2", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N head elements: 1.\nExpected: (a collection containing \"key2\" and a collection containing \"key3\")\n     but: a collection containing \"key2\" mismatches were: [was \"key1\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadKeys(1, Matchers.hasItems("key2", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N head elements: 1.\nExpected: (a collection containing \"key2\" and a collection containing \"key3\")\n     but: a collection containing \"key2\" mismatches were: [was \"key1\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadKeys(4, Matchers.hasItems("key2", "key4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N head elements: 4.\nExpected: (a collection containing \"key2\" and a collection containing \"key4\")\n     but: a collection containing \"key4\" mismatches were: [was \"key1\", was \"key2\", was \"key3\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadKeys(4, Matchers.hasItems("key2", "key4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N head elements: 4.\nExpected: (a collection containing \"key2\" and a collection containing \"key4\")\n     but: a collection containing \"key4\" mismatches were: [was \"key1\", was \"key2\", was \"key3\"]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toTailKeysElementTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key0").containsExactlyInOrder("key1", "key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key1").containsExactlyInOrder("key1", "key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key2").containsExactlyInOrder("key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key3").containsExactlyInOrder("key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key4").containsExactlyInOrder();
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value", "key1", "value1", "key2", "value2")).toTailKeys("key1").containsExactlyInOrder("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(null).containsExactlyInOrder("key1", "key2", "key3");

        try {
            Raw.<String, String>sortedMapAssertion().toTailKeys("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailKeys("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailKeys("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toTailKeys("key")).containsExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's tail elements from element: key.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toTailKeys("key")).containsExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's tail elements from element: key.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toTailKeys("key3").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toTailKeys("key3").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key3").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailKeys("key3").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key3]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3")).toTailKeys((Character) '3').containsExactlyInOrder('2', '3');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's tail elements from element: 3(51).\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[3(51)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3"), "Message").toTailKeys((Character) '3').containsExactlyInOrder('2', '3');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's tail elements from element: 3(51).\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 3(51)]> but was:<[3(51)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3')).toTailKeys("key3").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key3]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3'), "Message").toTailKeys("key3").containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<[key3]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toTailKeysCountTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(1).containsExactlyInOrder("key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(2).containsExactlyInOrder("key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(3).containsExactlyInOrder("key1", "key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(4).containsExactlyInOrder("key1", "key2", "key3");

        try {
            Raw.<String, String>sortedMapAssertion().toTailKeys(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailKeys(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailKeys(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailKeys(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailKeys(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailKeys(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailKeys(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailKeys(-1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailKeys(-1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toTailKeys(1)).containsExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N tail elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toTailKeys(1)).containsExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N tail elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toTailKeys(1).containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N tail elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toTailKeys(1).containsExactlyInOrder("key2", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N tail elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key3]> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(1).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N tail elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailKeys(1).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N tail elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(4).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailKeys(4).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3")).toTailKeys(4).containsExactlyInOrder('2', '4');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3"), "Message").toTailKeys(4).containsExactlyInOrder('2', '4');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 4(52)]> but was:<[1(49), 2(50), 3(51)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3')).toTailKeys(4).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3'), "Message").toTailKeys(4).containsExactlyInOrder("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key4]> but was:<[key1, key2, key3]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toTailKeysElementMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key0", Matchers.hasItems("key1", "key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key1", Matchers.hasItems("key1", "key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key2", Matchers.hasItems("key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key3", Matchers.hasItems("key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key4", Matchers.emptyIterableOf(String.class));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value", "key1", "value1", "key2", "value2")).toTailKeys("key1", Matchers.hasItems("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(null, Matchers.hasItems("key1", "key2", "key3"));

        try {
            Raw.<String, String>sortedMapAssertion().toTailKeys("key", Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailKeys("key", Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailKeys("key", Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailKeys("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailKeys("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailKeys("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailKeys("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys("key3", Matchers.hasItems("key2", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's tail elements from element: key3.\nExpected: (a collection containing \"key2\" and a collection containing \"key3\")\n     but: a collection containing \"key2\" mismatches were: [was \"key3\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailKeys("key3", Matchers.hasItems("key2", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's tail elements from element: key3.\nExpected: (a collection containing \"key2\" and a collection containing \"key3\")\n     but: a collection containing \"key2\" mismatches were: [was \"key3\"]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toTailKeysCountMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(1, Matchers.hasItems("key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(2, Matchers.hasItems("key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(3, Matchers.hasItems("key1", "key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(4, Matchers.hasItems("key1", "key2", "key3"));

        try {
            Raw.<String, String>sortedMapAssertion().toTailKeys(1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailKeys(1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailKeys(1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailKeys(0, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailKeys(0, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailKeys(0, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailKeys(0, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailKeys(-1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailKeys(-1, Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailKeys(0, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailKeys(0, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailKeys(1, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailKeys(1, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(1, Matchers.hasItems("key2", "key4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N tail elements: 1.\nExpected: (a collection containing \"key2\" and a collection containing \"key4\")\n     but: a collection containing \"key2\" mismatches were: [was \"key3\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailKeys(1, Matchers.hasItems("key2", "key4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N tail elements: 1.\nExpected: (a collection containing \"key2\" and a collection containing \"key4\")\n     but: a collection containing \"key2\" mismatches were: [was \"key3\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailKeys(4, Matchers.hasItems("key2", "key4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tCheck actual value's N tail elements: 4.\nExpected: (a collection containing \"key2\" and a collection containing \"key4\")\n     but: a collection containing \"key4\" mismatches were: [was \"key1\", was \"key2\", was \"key3\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailKeys(4, Matchers.hasItems("key2", "key4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tCheck actual value's N tail elements: 4.\nExpected: (a collection containing \"key2\" and a collection containing \"key4\")\n     but: a collection containing \"key4\" mismatches were: [was \"key1\", was \"key2\", was \"key3\"]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllKeysArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key1", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys("key2", "key1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeys(null, "key1");

        try {
            Raw.<String, String>sortedMapAssertion().containsAllKeys("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeys("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAllKeys("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeys((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAllKeys((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAllKeys((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAllKeys((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAllKeys();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAllKeys();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys("key1", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsAllKeys('3', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[3(51), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsAllKeys('3', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[3(51), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '1')).containsAllKeys("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '1'), "Message").containsAllKeys("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllKeysIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable("key1", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable("key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable("key2", "key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeys(DataHelper.createIterable(null, "key1"));

        try {
            Raw.<String, String>sortedMapAssertion().containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeys((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAllKeys((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAllKeys((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAllKeys((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAllKeys(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys(DataHelper.createIterable("key1", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllKeys(DataHelper.createIterable("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAllKeys(DataHelper.createIterable("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllKeysInOrderArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key1", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key1", "key2", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(null, "key1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(null, "key3");

        try {
            Raw.<String, String>sortedMapAssertion().containsAllKeysInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeysInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAllKeysInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeysInOrder((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAllKeysInOrder((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAllKeysInOrder((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAllKeysInOrder((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAllKeysInOrder();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAllKeysInOrder();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder("key1", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key3", "key2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key2]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder("key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder("key1", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[<NULL>, key1, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAllKeysInOrder("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '1', "value2")).containsAllKeysInOrder('3', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[3(51), 1(49)]> but was:<[1(49)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '1', "value2"), "Message").containsAllKeysInOrder('3', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[3(51), 1(49)]> but was:<[1(49)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '1')).containsAllKeysInOrder("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '1'), "Message").containsAllKeysInOrder("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllKeysInOrderIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key1", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key1", "key2", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable(null, "key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable(null, "key3"));

        try {
            Raw.<String, String>sortedMapAssertion().containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAllKeysInOrder((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAllKeysInOrder(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder(DataHelper.createIterable("key1", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key3", "key2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key2]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key2", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsAllKeysInOrder(DataHelper.createIterable("key1", null));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[<NULL>, key1, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllKeysInOrder(DataHelper.createIterable("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAllKeysInOrder(DataHelper.createIterable("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly("key2", "key1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsKeysExactly(null, "key1");
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).containsKeysExactly();

        try {
            Raw.<String, String>sortedMapAssertion().containsKeysExactly("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactly("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKeysExactly("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactly((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKeysExactly((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsKeysExactly((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsKeysExactly((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly("key1", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsKeysExactly('3', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[3(51), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsKeysExactly('3', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[3(51), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsKeysExactly("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsKeysExactly("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.createIterable("key2", "key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsKeysExactly(DataHelper.createIterable(null, "key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.<String, String>createTreeMap()).containsKeysExactly(DataHelper.<String>createIterable());

        try {
            Raw.<String, String>sortedMapAssertion().containsKeysExactly(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactly(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKeysExactly(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactly((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKeysExactly((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsKeysExactly((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsKeysExactly((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.createIterable("key1", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactly(DataHelper.createIterable("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactly(DataHelper.createIterable("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<[key3, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyInOrderArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder(null, "key1");
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).containsKeysExactlyInOrder();

        try {
            Raw.<String, String>sortedMapAssertion().containsKeysExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKeysExactlyInOrder("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactlyInOrder((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKeysExactlyInOrder((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsKeysExactlyInOrder((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsKeysExactlyInOrder((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder("key1", "key3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsKeysExactlyInOrder("key3", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder("key1", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[<NULL>, key1]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsKeysExactlyInOrder("key1", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[<NULL>, key1, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsKeysExactlyInOrder('2', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsKeysExactlyInOrder('2', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsKeysExactlyInOrder("key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsKeysExactlyInOrderIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder(DataHelper.createIterable(null, "key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.<String, String>createTreeMap()).containsKeysExactlyInOrder(DataHelper.<String>createIterable());

        try {
            Raw.<String, String>sortedMapAssertion().containsKeysExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKeysExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsKeysExactlyInOrder((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(DataHelper.createIterable("key1", "key3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, key3]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).containsKeysExactlyInOrder(DataHelper.createIterable("key3", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key3, key1]> but was:<[key1, key2, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsKeysExactlyInOrder(DataHelper.createIterable("key1", null));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[<NULL>, key1]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2", "key3", "value3")).containsKeysExactlyInOrder(DataHelper.createIterable("key1", null));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key1, <NULL>]> but was:<[<NULL>, key1, key3]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsKeysExactlyInOrder(DataHelper.createIterable("key2", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsKeysExactlyInOrder(DataHelper.createIterable("key2", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<[key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAnyKeyArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key2", "key1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key1", "key3", "key5");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key6", "key2", "key4");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsAnyKey("key6", null, "key4");

        try {
            Raw.<String, String>sortedMapAssertion().containsAnyKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAnyKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAnyKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAnyKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAnyKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAnyKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAnyKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAnyKey();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAnyKey();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key4", "key6");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsAnyKey('9', '8', '7');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[9(57), 8(56), 7(55)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsAnyKey('9', '8', '7');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[9(57), 8(56), 7(55)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsAnyKey("key9", "key8", "key7");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsAnyKey("key9", "key8", "key7");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAnyKeyIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key1", "key2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key2", "key1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key1", "key3", "key5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key6", "key2", "key4"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsAnyKey(DataHelper.createIterable("key6", null, "key4"));

        try {
            Raw.<String, String>sortedMapAssertion().containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAnyKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAnyKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAnyKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAnyKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAnyKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key4", "key6"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key4, key6]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAnyKey(DataHelper.createIterable("key9", "key8", "key7"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAnyKey(DataHelper.createIterable("key9", "key8", "key7"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should contain any of the expected values.\n\tExpected:<[key9, key8, key7]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNoKeyArrayTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key4");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key4", "key3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key6", "key7", "key8");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key7", "key6", "key8");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsNoKey("key7", "key6", "key8");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key7", null, "key8");

        try {
            Raw.<String, String>sortedMapAssertion().containsNoKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNoKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsNoKey("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNoKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsNoKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsNoKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsNoKey((String[]) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsNoKey();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsNoKey();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key2", "key4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey("key3", "key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsNoKey('3', '2', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[3(51), 2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsNoKey('3', '2', '1');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[3(51), 2(50), 1(49)]> but was:<[1(49), 2(50)]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsNoKey("key3", "key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsNoKey("key3", "key2", "key1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNoKeyIterableTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key3", "key4"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key4", "key3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key6", "key7", "key8"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key7", "key6", "key8"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", null, "value2")).containsNoKey(DataHelper.createIterable("key7", "key6", "key8"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key7", null, "key8"));

        try {
            Raw.<String, String>sortedMapAssertion().containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNoKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsNoKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsNoKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsNoKey((Iterable<String>) null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsNoKey(DataHelper.<String>createIterable());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key2", "key4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key2, key4]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNoKey(DataHelper.createIterable("key3", "key2", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsNoKey(DataHelper.createIterable("key3", "key2", "key1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's keys.\n\tActual value should not contain any of the expected values.\n\tExpected:<[key3, key2, key1]> but was:<[key1, key2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toValuesTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toValues().isNotEmpty();
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", null)).toValues().contains("value1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", null)).toValues().contains(null);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toValues();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toValues()).contains("value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's values.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").toValues()).contains("value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's values.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toValues().contains("value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's values.\n\tActual value should contain the expected value.\n\tExpected:<value> but was:<[value1, value2]>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").toValues().contains("value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's values.\n\tActual value should contain the expected value.\n\tExpected:<value> but was:<[value1, value2]>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toValuesMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toValues(Matchers.hasItems("value1", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", null)).toValues(Matchers.hasItems("value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", null)).toValues(Matchers.hasItems((String) null));

        try {
            Raw.<String, String>sortedMapAssertion().toValues(Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toValues(Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toValues(Matchers.hasItems(""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toValues(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toValues(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toValues(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toValues(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toValues(Matchers.hasItems("value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's values.\nExpected: (a collection containing \"value\")\n     but: a collection containing \"value\" mismatches were: [was \"value1\", was \"value2\"]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").toValues(Matchers.hasItems("value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's values.\nExpected: (a collection containing \"value\")\n     but: a collection containing \"value\" mismatches were: [was \"value1\", was \"value2\"]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsEntryTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsEntry(null, "value1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsEntry("key1", null);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsEntry("key", "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsEntry(null, "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{<NULL>=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key=<NULL>}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key1", "value2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key2", "value1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key2=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsEntry("key3", "value3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsEntry("key3", "value3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsEntry('3', "value3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsEntry('3', "value3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsEntry("key3", '3');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsEntry("key3", '3');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void doesNotContainEntryTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", "value");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry(null, "value");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key", null);
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).doesNotContainEntry("key1", "value1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).doesNotContainEntry("key1", "value1");

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").doesNotContainEntry("key", "value");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key1", "value1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).doesNotContainEntry("key2", "value2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").doesNotContainEntry("key2", "value2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).doesNotContainEntry('2', "value2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{2(50)=value2}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").doesNotContainEntry('2', "value2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{2(50)=value2}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).doesNotContainEntry("key2", '2');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key2=2(50)}> but was:<{key1=1(49), key2=2(50)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").doesNotContainEntry("key2", '2');
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key2=2(50)}> but was:<{key1=1(49), key2=2(50)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toHeadMapElementTest() {
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3")).toHeadMap("key0").containsExactlyInOrder(DataHelper.createHashMap());
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3")).toHeadMap("key1").containsExactlyInOrder(DataHelper.createHashMap());
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap("key2").containsExactlyInOrder(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap("key3").containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap("key4").containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) null, (Object) "value", "key1", "value1", "key2", "value2")).toHeadMap("key1").containsExactlyInOrder(DataHelper.createHashMap(null, (Object) "value"));
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3")).toHeadMap(null).containsExactlyInOrder(DataHelper.createHashMap());

        try {
            Raw.<String, String>sortedMapAssertion().toHeadMap("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadMap("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadMap("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toHeadMap("key")).containsExactlyInOrder(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: key.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toHeadMap("key")).containsExactlyInOrder(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: key.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toHeadMap("key2").containsExactlyInOrder(DataHelper.createHashMap((Object) "key2", (Object) "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toHeadMap("key2").containsExactlyInOrder(DataHelper.createHashMap((Object) "key2", (Object) "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap("key2").containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<{key1=value1}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadMap("key2").containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<{key1=value1}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3")).toHeadMap((Character) '2').containsExactlyInOrder(DataHelper.createHashMap('2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: 2(50).\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3"), "Message").toHeadMap((Character) '2').containsExactlyInOrder(DataHelper.createHashMap('2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: 2(50).\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3')).toHeadMap("key2").containsExactlyInOrder(DataHelper.createHashMap("key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=2(50), key3=3(51)}> but was:<{key1=1(49)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3'), "Message").toHeadMap("key2").containsExactlyInOrder(DataHelper.createHashMap("key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: key2.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=2(50), key3=3(51)}> but was:<{key1=1(49)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toHeadMapCountTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toHeadMap(1).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toHeadMap(2).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toHeadMap(3).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toHeadMap(4).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toHeadMap(5).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toHeadMap(6).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5"));

        SortedMap<String, String> sortedMap = DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3");
        initialize(Raw.<String, String>sortedMapAssertion(), sortedMap).toHeadMap(2).isNotSameAs(sortedMap);
        initialize(Raw.<String, String>sortedMapAssertion(), sortedMap).toHeadMap(3).isSameAs(sortedMap);
        initialize(Raw.<String, String>sortedMapAssertion(), sortedMap).toHeadMap(4).isSameAs(sortedMap);

        try {
            Raw.<String, String>sortedMapAssertion().toHeadMap(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadMap(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadMap(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadMap(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadMap(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadMap(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadMap(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadMap(-1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadMap(-1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toHeadMap(1)).containsExactlyInOrder(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toHeadMap(1)).containsExactlyInOrder(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toHeadMap(1).containsExactlyInOrder(DataHelper.createHashMap((Object) "key2", (Object) "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toHeadMap(1).containsExactlyInOrder(DataHelper.createHashMap((Object) "key2", (Object) "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(1).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadMap(1).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(3).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1, key2=value2, key3=value3}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadMap(3).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1, key2=value2, key3=value3}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(4).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1, key2=value2, key3=value3}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadMap(4).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1, key2=value2, key3=value3}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3")).toHeadMap(4).containsExactlyInOrder(DataHelper.createHashMap('2', "value2", '4', "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{2(50)=value2, 4(52)=value4}> but was:<{1(49)=value1, 2(50)=value2, 3(51)=value3}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3"), "Message").toHeadMap(4).containsExactlyInOrder(DataHelper.createHashMap('2', "value2", '4', "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{2(50)=value2, 4(52)=value4}> but was:<{1(49)=value1, 2(50)=value2, 3(51)=value3}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3')).toHeadMap(4).containsExactlyInOrder(DataHelper.createHashMap("key2", '2', "key4", '4'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=2(50), key4=4(52)}> but was:<{key1=1(49), key2=2(50), key3=3(51)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3'), "Message").toHeadMap(4).containsExactlyInOrder(DataHelper.createHashMap("key2", '2', "key4", '4'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=2(50), key4=4(52)}> but was:<{key1=1(49), key2=2(50), key3=3(51)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toHeadMapElementMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap("key2", Matchers.hasEntry("key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap("key3", Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2")));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap("key4", Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));

        try {
            Raw.<String, String>sortedMapAssertion().toHeadMap("key", Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadMap("key", Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadMap("key", Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadMap("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadMap("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadMap("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadMap("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap("key2", Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's head elements up to element: key2.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key3\"->\"value3\"])\n     but: map containing [\"key2\"->\"value2\"] map was [<key1=value1>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadMap("key2", Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's head elements up to element: key2.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key3\"->\"value3\"])\n     but: map containing [\"key2\"->\"value2\"] map was [<key1=value1>]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toHeadMapCountMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(1, Matchers.hasEntry("key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(2, Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2")));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(3, Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(4, Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));

        try {
            Raw.<String, String>sortedMapAssertion().toHeadMap(1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadMap(1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadMap(1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toHeadMap(0, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toHeadMap(0, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadMap(0, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadMap(0, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadMap(-1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadMap(-1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadMap(0, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadMap(0, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toHeadMap(1, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toHeadMap(1, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(1, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 1.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key2\"->\"value2\"] map was [<key1=value1>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadMap(1, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 1.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key2\"->\"value2\"] map was [<key1=value1>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(3, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 3.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key4\"->\"value4\"] map was [<key1=value1>, <key2=value2>, <key3=value3>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadMap(3, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 3.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key4\"->\"value4\"] map was [<key1=value1>, <key2=value2>, <key3=value3>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toHeadMap(4, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N head elements: 4.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key4\"->\"value4\"] map was [<key1=value1>, <key2=value2>, <key3=value3>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toHeadMap(4, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N head elements: 4.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key4\"->\"value4\"] map was [<key1=value1>, <key2=value2>, <key3=value3>]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toTailMapElementTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key0").containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key1").containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key2").containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key3", "value3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key3").containsExactlyInOrder(DataHelper.createHashMap("key3", "value3"));
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "key1", (Object) "value1", "key2", "value2", "key3", "value3")).toTailMap("key4").containsExactlyInOrder(DataHelper.createHashMap());
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value", "key1", "value1", "key2", "value2")).toTailMap("key1").containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(null).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));

        try {
            Raw.<String, String>sortedMapAssertion().toTailMap("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailMap("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailMap("key");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toTailMap("key")).containsExactlyInOrder(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: key.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toTailMap("key")).containsExactlyInOrder(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: key.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toTailMap("key3").containsExactlyInOrder(DataHelper.createHashMap((Object) "key2", (Object) "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toTailMap("key3").containsExactlyInOrder(DataHelper.createHashMap((Object) "key2", (Object) "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key3").containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<{key3=value3}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailMap("key3").containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<{key3=value3}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3")).toTailMap((Character) '3').containsExactlyInOrder(DataHelper.createHashMap('2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: 3(51).\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{2(50)=value2, 3(51)=value3}> but was:<{3(51)=value3}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3"), "Message").toTailMap((Character) '3').containsExactlyInOrder(DataHelper.createHashMap('2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: 3(51).\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{2(50)=value2, 3(51)=value3}> but was:<{3(51)=value3}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3')).toTailMap("key3").containsExactlyInOrder(DataHelper.createHashMap("key2", '2', "key3", '4'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=2(50), key3=4(52)}> but was:<{key3=3(51)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3'), "Message").toTailMap("key3").containsExactlyInOrder(DataHelper.createHashMap("key2", '2', "key3", '4'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: key3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=2(50), key3=4(52)}> but was:<{key3=3(51)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toTailMapCountTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toTailMap(1).containsExactlyInOrder(DataHelper.createHashMap("key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toTailMap(2).containsExactlyInOrder(DataHelper.createHashMap("key4", "value4", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toTailMap(3).containsExactlyInOrder(DataHelper.createHashMap("key3", "value3", "key4", "value4", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toTailMap(4).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toTailMap(5).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5")).toTailMap(6).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5"));

        SortedMap<String, String> sortedMap = DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3");
        initialize(Raw.<String, String>sortedMapAssertion(), sortedMap).toTailMap(2).isNotSameAs(sortedMap);
        initialize(Raw.<String, String>sortedMapAssertion(), sortedMap).toTailMap(3).isSameAs(sortedMap);
        initialize(Raw.<String, String>sortedMapAssertion(), sortedMap).toTailMap(4).isSameAs(sortedMap);

        try {
            Raw.<String, String>sortedMapAssertion().toTailMap(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailMap(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailMap(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailMap(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailMap(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailMap(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailMap(0);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailMap(-1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailMap(-1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toTailMap(1)).containsExactlyInOrder(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 1.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toTailMap(1)).containsExactlyInOrder(DataHelper.createHashMap((Object) "key", (Object) "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 1.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toTailMap(1).containsExactlyInOrder(DataHelper.createHashMap((Object) "key2", (Object) "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").toTailMap(1).containsExactlyInOrder(DataHelper.createHashMap((Object) "key2", (Object) "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key3=value3}> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(1).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key3=value3}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailMap(1).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 1.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key3=value3}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(3).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1, key2=value2, key3=value3}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailMap(3).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 3.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1, key2=value2, key3=value3}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(4).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1, key2=value2, key3=value3}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailMap(4).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key4", "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key4=value4}> but was:<{key1=value1, key2=value2, key3=value3}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3")).toTailMap(4).containsExactlyInOrder(DataHelper.createHashMap('2', "value2", '4', "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{2(50)=value2, 4(52)=value4}> but was:<{1(49)=value1, 2(50)=value2, 3(51)=value3}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2", '3', "value3"), "Message").toTailMap(4).containsExactlyInOrder(DataHelper.createHashMap('2', "value2", '4', "value4"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{2(50)=value2, 4(52)=value4}> but was:<{1(49)=value1, 2(50)=value2, 3(51)=value3}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3')).toTailMap(4).containsExactlyInOrder(DataHelper.createHashMap("key2", '2', "key4", '4'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=2(50), key4=4(52)}> but was:<{key1=1(49), key2=2(50), key3=3(51)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2', "key3", '3'), "Message").toTailMap(4).containsExactlyInOrder(DataHelper.createHashMap("key2", '2', "key4", '4'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 4.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=2(50), key4=4(52)}> but was:<{key1=1(49), key2=2(50), key3=3(51)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toTailMapElementMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key0", Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key1", Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key2", Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key3", Matchers.hasEntry("key3", "value3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value", "key1", "value1", "key2", "value2")).toTailMap("key1", Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2")));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(null, Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));

        try {
            Raw.<String, String>sortedMapAssertion().toTailMap("key", Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailMap("key", Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailMap("key", Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailMap("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailMap("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailMap("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailMap("key", null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap("key3", Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's tail elements from element: key3.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key3\"->\"value3\"])\n     but: map containing [\"key2\"->\"value2\"] map was [<key3=value3>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailMap("key3", Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's tail elements from element: key3.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key3\"->\"value3\"])\n     but: map containing [\"key2\"->\"value2\"] map was [<key3=value3>]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toTailMapCountMatcherTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(1, Matchers.hasEntry("key3", "value3"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(2, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(3, Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(4, Matchers.allOf(Matchers.hasEntry("key1", "value1"), Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key3", "value3")));

        try {
            Raw.<String, String>sortedMapAssertion().toTailMap(1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailMap(1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailMap(1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toTailMap(0, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toTailMap(0, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailMap(0, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailMap(0, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailMap(-1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailMap(-1, Matchers.hasEntry("", ""));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailMap(0, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailMap(0, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should be valid: count.\n\tThe argument's value should be greater than zero.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toTailMap(1, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toTailMap(1, null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(1, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 1.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key2\"->\"value2\"] map was [<key3=value3>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailMap(1, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 1.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key2\"->\"value2\"] map was [<key3=value3>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(3, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 3.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key4\"->\"value4\"] map was [<key1=value1>, <key2=value2>, <key3=value3>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailMap(3, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 3.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key4\"->\"value4\"] map was [<key1=value1>, <key2=value2>, <key3=value3>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toTailMap(4, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's N tail elements: 4.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key4\"->\"value4\"] map was [<key1=value1>, <key2=value2>, <key3=value3>]");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3"), "Message").toTailMap(4, Matchers.allOf(Matchers.hasEntry("key2", "value2"), Matchers.hasEntry("key4", "value4")));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's N tail elements: 4.\nExpected: (map containing [\"key2\"->\"value2\"] and map containing [\"key4\"->\"value4\"])\n     but: map containing [\"key4\"->\"value4\"] map was [<key1=value1>, <key2=value2>, <key3=value3>]");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAll1Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3");

        try {
            Raw.sortedMapAssertion().containsAll("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAll("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAll("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAll2Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAll("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAll("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAll3Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5", "k2", "v2");

        try {
            Raw.sortedMapAssertion().containsAll("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAll("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAll4Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5", "k2", "v2", "k1", "v1");

        try {
            Raw.sortedMapAssertion().containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAll5Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v3", "k5", "v5", "k2", "v2", "k1", "v1", "k4", "v4");

        try {
            Raw.sortedMapAssertion().containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAll("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAll("k3", "v1", "k1", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{k3=v1, k1=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAll("k3", "v1", "k1", "v1", "k2", "v2", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{k3=v1, k1=v1, k2=v2, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", null, "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", null, "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", "key1", null));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsAll(DataHelper.createHashMap("key2", "value2", "key1", null));

        try {
            Raw.sortedMapAssertion().containsAll(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAll(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAll(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAll(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAll(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAll(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAll(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "", (Object) "")).containsAll(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "", (Object) ""), "Message").containsAll(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key1", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAll(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAll(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsAll(DataHelper.createHashMap('1', "value1", '2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{1(49)=value1, 2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsAll(DataHelper.createHashMap('1', "value1", '2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{1(49)=value1, 2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsAll(DataHelper.createHashMap("key1", '1', "key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values.\n\tExpected:<{key1=1(49), key2=2(50), key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsAll(DataHelper.createHashMap("key1", '1', "key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values.\n\tExpected:<{key1=1(49), key2=2(50), key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllInOrder1Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k3", "v3");

        try {
            Raw.sortedMapAssertion().containsAllInOrder("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAllInOrder("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAllInOrder("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllInOrder2Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k3", "v3", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAllInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllInOrder3Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k3", "v3", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllInOrder4Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllInOrder5Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAllInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAllInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAllInOrderTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", null, "key2", "value2"));

        try {
            Raw.sortedMapAssertion().containsAllInOrder(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAllInOrder(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAllInOrder(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAllInOrder(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAllInOrder(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAllInOrder(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAllInOrder(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "", (Object) "")).containsAllInOrder(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "", (Object) ""), "Message").containsAllInOrder(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key2", "value2", "key1", "value1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key2=value2, key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key2", "value2", null, "value1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key2=value2, <NULL>=value1}> but was:<{<NULL>=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key2", "value2", "key1", null));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key2=value2, key1=<NULL>}> but was:<{key1=<NULL>, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAllInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAllInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsAllInOrder(DataHelper.createHashMap('1', "value1", '2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{1(49)=value1, 2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsAllInOrder(DataHelper.createHashMap('1', "value1", '2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{1(49)=value1, 2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsAllInOrder(DataHelper.createHashMap("key1", '1', "key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=1(49), key2=2(50), key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsAllInOrder(DataHelper.createHashMap("key1", '1', "key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values in the specified order.\n\tExpected:<{key1=1(49), key2=2(50), key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactly0Test() {
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).containsExactly();

        try {
            Raw.sortedMapAssertion().containsExactly();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactly();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactly();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactly1Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1")).containsExactly("k1", "v1");

        try {
            Raw.sortedMapAssertion().containsExactly("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactly("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactly("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactly2Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2")).containsExactly("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2")).containsExactly("k2", "v2", "k1", "v1");

        try {
            Raw.sortedMapAssertion().containsExactly("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactly("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactly3Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3")).containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3")).containsExactly("k2", "v2", "k1", "v1", "k3", "v3");

        try {
            Raw.sortedMapAssertion().containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactly4Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).containsExactly("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");

        try {
            Raw.sortedMapAssertion().containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactly5Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactly("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactly("k6", "v6", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{k6=v6, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactlyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", null, "key2", "value2"));
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).containsExactly(DataHelper.createHashMap());

        try {
            Raw.sortedMapAssertion().containsExactly(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactly(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactly(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsExactly(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsExactly(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsExactly(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsExactly(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", "value1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key2", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "key1", (Object) "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<<EMPTY>> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactly(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsExactly(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsExactly(DataHelper.createHashMap('1', "value1", '2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{1(49)=value1, 2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsExactly(DataHelper.createHashMap('1', "value1", '2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{1(49)=value1, 2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsExactly(DataHelper.createHashMap("key1", '1', "key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly.\n\tExpected:<{key1=1(49), key2=2(50), key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsExactly(DataHelper.createHashMap("key1", '1', "key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly.\n\tExpected:<{key1=1(49), key2=2(50), key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder0Test() {
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).containsExactlyInOrder();

        try {
            Raw.sortedMapAssertion().containsExactlyInOrder();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactlyInOrder();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactlyInOrder();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder1Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1")).containsExactlyInOrder("k1", "v1");

        try {
            Raw.sortedMapAssertion().containsExactlyInOrder("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactlyInOrder("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder2Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2")).containsExactlyInOrder("k1", "v1", "k2", "v2");

        try {
            Raw.sortedMapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder3Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3")).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");

        try {
            Raw.sortedMapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder4Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4")).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");

        try {
            Raw.sortedMapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrder5Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactlyInOrder("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsExactlyInOrder("k2", "v2", "k1", "v1", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{k2=v2, k1=v1, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsExactlyInOrderTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap(null, "value1", "key2", "value2"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", null, "key2", "value2"));
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).containsExactlyInOrder(DataHelper.createHashMap());

        try {
            Raw.sortedMapAssertion().containsExactlyInOrder(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsExactlyInOrder(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsExactlyInOrder(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsExactlyInOrder(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsExactlyInOrder(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsExactlyInOrder(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsExactlyInOrder(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "key1", (Object) "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<<EMPTY>> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key1", "value1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", null, "value1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, <NULL>=value1}> but was:<{<NULL>=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key2", "value2", "key1", null));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key2=value2, key1=<NULL>}> but was:<{key1=<NULL>, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsExactlyInOrder(DataHelper.createHashMap("key1", "value1", "key2", "value2", "key3", "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=value1, key2=value2, key3=value3}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsExactlyInOrder(DataHelper.createHashMap('1', "value1", '2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{1(49)=value1, 2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsExactlyInOrder(DataHelper.createHashMap('1', "value1", '2', "value2", '3', "value3"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{1(49)=value1, 2(50)=value2, 3(51)=value3}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsExactlyInOrder(DataHelper.createHashMap("key1", '1', "key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=1(49), key2=2(50), key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsExactlyInOrder(DataHelper.createHashMap("key1", '1', "key2", '2', "key3", '3'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain all of the expected values exactly in the specified order.\n\tExpected:<{key1=1(49), key2=2(50), key3=3(51)}> but was:<{key1=1(49), key2=2(50)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAny1Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAny("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAny("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAny("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAny2Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAny("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAny("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAny3Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2", "k3", "v3");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k8", "v8", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAny("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAny("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAny4Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k8", "v8", "k9", "v9", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAny5Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k7", "v7", "k8", "v8", "k9", "v9", "k10", "v10", "k5", "v5");

        try {
            Raw.sortedMapAssertion().containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAny("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44, k5=v55}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsAny("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{k1=v11, k2=v22, k3=v33, k4=v44, k5=v55}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsAnyTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAny(DataHelper.createHashMap("key1", "value1", "key3", "value3", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAny(DataHelper.createHashMap("key4", "value4", "key2", "value2", "key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsAny(DataHelper.createHashMap(null, "value1", "key3", "value3", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsAny(DataHelper.createHashMap("key1", null, "key3", "value3", "key5", "value5"));

        try {
            Raw.sortedMapAssertion().containsAny(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsAny(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsAny(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsAny(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsAny(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsAny(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsAny(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "", (Object) "")).containsAny(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "", (Object) ""), "Message").containsAny(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always false.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsAny(DataHelper.createHashMap("key", "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsAny(DataHelper.createHashMap("key", "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{key=value}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsAny(DataHelper.createHashMap('0', "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{0(48)=value}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsAny(DataHelper.createHashMap('0', "value"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{0(48)=value}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsAny(DataHelper.createHashMap("key", '0'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should contain any of the expected values.\n\tExpected:<{key=0(48)}> but was:<{key1=1(49), key2=2(50)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsAny(DataHelper.createHashMap("key", '0'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should contain any of the expected values.\n\tExpected:<{key=0(48)}> but was:<{key1=1(49), key2=2(50)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNone1Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11");

        try {
            Raw.sortedMapAssertion().containsNone("k1", "v11");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsNone("k1", "v11");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsNone("k1", "v11");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNone2Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22");

        try {
            Raw.sortedMapAssertion().containsNone("k1", "v11", "k2", "v22");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsNone("k1", "v11", "k2", "v22");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNone3Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22", "k3", "v33");

        try {
            Raw.sortedMapAssertion().containsNone("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsNone("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22", "k3", "v33");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2", "k3", "v3");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNone4Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");

        try {
            Raw.sortedMapAssertion().containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNone5Test() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");

        try {
            Raw.sortedMapAssertion().containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsNone("k1", "v11", "k2", "v22", "k3", "v33", "k4", "v44", "k5", "v55");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5")).containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5"), "Message").containsNone("k1", "v1", "k2", "v2", "k3", "v3", "k4", "v4", "k5", "v5");
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}> but was:<{k1=v1, k2=v2, k3=v3, k4=v4, k5=v5}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void containsNoneTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key3", "value3", "key4", "value4", "key5", "value5"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key", "value"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap(null, "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", null, "key2", "value2")).containsNone(DataHelper.createHashMap("key1", "value1"));
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "key1", (Object) "value1", "key2", "value2")).containsNone(DataHelper.createHashMap(null, (Object) "value1"));
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "key1", (Object) "value1", "key2", "value2")).containsNone(DataHelper.createHashMap((Object) "key1", null));

        try {
            Raw.sortedMapAssertion().containsNone(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null).containsNone(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), null, "Message").containsNone(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).containsNone(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").containsNone(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).containsNone(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: expected.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").containsNone(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: expected.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "", (Object) "")).containsNone(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap((Object) "", (Object) ""), "Message").containsNone(DataHelper.createHashMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be empty: expected.\n\tThe result is always true.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key1", "value1"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).containsNone(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").containsNone(DataHelper.createHashMap("key1", "value1", "key2", "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=value1, key2=value2}> but was:<{key1=value1, key2=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2")).containsNone(DataHelper.createHashMap('1', "value1", '2', "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{1(49)=value1, 2(50)=value2}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<Character, String>sortedMapAssertion(), DataHelper.createTreeMap('1', "value1", '2', "value2"), "Message").containsNone(DataHelper.createHashMap('1', "value1", '2', "value2"));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{1(49)=value1, 2(50)=value2}> but was:<{1(49)=value1, 2(50)=value2}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2')).containsNone(DataHelper.createHashMap("key1", '1', "key2", '2'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not contain any of the expected values.\n\tExpected:<{key1=1(49), key2=2(50)}> but was:<{key1=1(49), key2=2(50)}>");
        }
        try {
            initialize(Raw.<String, Character>sortedMapAssertion(), DataHelper.createTreeMap("key1", '1', "key2", '2'), "Message").containsNone(DataHelper.createHashMap("key1", '1', "key2", '2'));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not contain any of the expected values.\n\tExpected:<{key1=1(49), key2=2(50)}> but was:<{key1=1(49), key2=2(50)}>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toSizeTest() {
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toSize().isEqualTo(0);
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1")).toSize().isEqualTo(1);
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(2);
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toSize().isEqualTo(3);

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
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toSize();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toSize()).isEqualTo(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual value should not be null.");
        }
        try {
            clearActual(initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").toSize()).isEqualTo(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toSize().isEqualTo(3);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").toSize().isEqualTo(3);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void toSizeMatcherTest() {
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).toSize(Matchers.is(Matchers.equalTo(0)));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1")).toSize(Matchers.equalTo(1));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toSize(Matchers.equalTo(2));
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).toSize(Matchers.equalTo(3));

        try {
            Raw.<String, String>sortedMapAssertion().toSize(Matchers.equalTo(0));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toSize(Matchers.equalTo(0));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toSize(Matchers.equalTo(0));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).toSize(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").toSize(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", "")).toSize(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Argument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("", ""), "Message").toSize(null);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tArgument should not be null: matcher.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).toSize(Matchers.equalTo(3));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\nExpected: <3>\n     but: was <2>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").toSize(Matchers.equalTo(3));
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\nExpected: <3>\n     but: was <2>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void hasSizeTest() {
        initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).hasSize(0);
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1")).hasSize(1);
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).hasSize(2);
        initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2", "key3", "value3")).hasSize(3);

        try {
            Raw.<String, String>sortedMapAssertion().hasSize(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Assertion should be initialized.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null).hasSize(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), null, "Message").hasSize(1);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should not be null.");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2")).hasSize(3);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Check actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
        try {
            initialize(Raw.<String, String>sortedMapAssertion(), DataHelper.createTreeMap("key1", "value1", "key2", "value2"), "Message").hasSize(3);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tCheck actual value's size.\n\tActual and expected values should be the same.\n\tExpected:<3> but was:<2>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isNullTest() {
        initialize(Raw.<String, String>sortedMapAssertion(), null).isNull();

        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap()).isNull();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual value should be null.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), DataHelper.createTreeMap(), "Message").isNull();
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual value should be null.\n\tActual:<<EMPTY>>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isSameAsTest() {
        SortedMap<Object, Object> value = DataHelper.createTreeMap();
        initialize(Raw.sortedMapAssertion(), value).isSameAs(value);

        try {
            initialize(Raw.sortedMapAssertion(), value).isSameAs(DataHelper.createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the same object.\n\tExpected:<<EMPTY>> but was:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), value, "Message").isSameAs(DataHelper.createTreeMap());
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the same object.\n\tExpected:<<EMPTY>> but was:<<EMPTY>>");
        }
    }

    /**
     * {@link SortedMapAssertion} class test.
     */
    @Test
    public void isNotSameAsTest() {
        SortedMap<Object, Object> value = DataHelper.createTreeMap();
        initialize(Raw.sortedMapAssertion(), value).isNotSameAs(DataHelper.createTreeMap());

        try {
            initialize(Raw.sortedMapAssertion(), value).isNotSameAs(value);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Actual and expected values should point to the different objects.\n\tActual:<<EMPTY>>");
        }
        try {
            initialize(Raw.sortedMapAssertion(), value, "Message").isNotSameAs(value);
            Assertions.fail("SortedMapAssertion test fail");
        } catch (AssertionError ex) {
            Assertions.assertThat(ex).hasMessage("Message.\n\tActual and expected values should point to the different objects.\n\tActual:<<EMPTY>>");
        }
    }

}
